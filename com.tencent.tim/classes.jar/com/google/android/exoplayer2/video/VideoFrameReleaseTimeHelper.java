package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManager.DisplayListener;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.exoplayer2.util.Util;

@TargetApi(16)
public final class VideoFrameReleaseTimeHelper
{
  private static final long CHOREOGRAPHER_SAMPLE_DELAY_MILLIS = 500L;
  private static final long MAX_ALLOWED_DRIFT_NS = 20000000L;
  private static final int MIN_FRAMES_FOR_ADJUSTMENT = 6;
  private static final long VSYNC_OFFSET_PERCENTAGE = 80L;
  private long adjustedLastFrameTimeNs;
  private final DefaultDisplayListener displayListener;
  private long frameCount;
  private boolean haveSync;
  private long lastFramePresentationTimeUs;
  private long pendingAdjustedFrameTimeNs;
  private long syncFramePresentationTimeNs;
  private long syncUnadjustedReleaseTimeNs;
  private long vsyncDurationNs;
  private long vsyncOffsetNs;
  private final VSyncSampler vsyncSampler;
  private final WindowManager windowManager;
  
  public VideoFrameReleaseTimeHelper()
  {
    this(null);
  }
  
  public VideoFrameReleaseTimeHelper(@Nullable Context paramContext)
  {
    Object localObject1;
    if (paramContext == null)
    {
      localObject1 = null;
      this.windowManager = ((WindowManager)localObject1);
      if (this.windowManager == null) {
        break label80;
      }
      localObject1 = localObject2;
      if (Util.SDK_INT >= 17) {
        localObject1 = maybeBuildDefaultDisplayListenerV17(paramContext);
      }
      this.displayListener = ((DefaultDisplayListener)localObject1);
    }
    for (this.vsyncSampler = VSyncSampler.getInstance();; this.vsyncSampler = null)
    {
      this.vsyncDurationNs = -9223372036854775807L;
      this.vsyncOffsetNs = -9223372036854775807L;
      return;
      localObject1 = (WindowManager)paramContext.getSystemService("window");
      break;
      label80:
      this.displayListener = null;
    }
  }
  
  private static long closestVsync(long paramLong1, long paramLong2, long paramLong3)
  {
    paramLong2 = (paramLong1 - paramLong2) / paramLong3 * paramLong3 + paramLong2;
    long l;
    if (paramLong1 <= paramLong2) {
      l = paramLong2 - paramLong3;
    }
    while (paramLong2 - paramLong1 < paramLong1 - l)
    {
      return paramLong2;
      l = paramLong2;
      paramLong2 += paramLong3;
    }
    return l;
  }
  
  private boolean isDriftTooLarge(long paramLong1, long paramLong2)
  {
    long l = this.syncFramePresentationTimeNs;
    return Math.abs(paramLong2 - this.syncUnadjustedReleaseTimeNs - (paramLong1 - l)) > 20000000L;
  }
  
  @TargetApi(17)
  private DefaultDisplayListener maybeBuildDefaultDisplayListenerV17(Context paramContext)
  {
    paramContext = (DisplayManager)paramContext.getSystemService("display");
    if (paramContext == null) {
      return null;
    }
    return new DefaultDisplayListener(paramContext);
  }
  
  private void updateDefaultDisplayRefreshRateParams()
  {
    Display localDisplay = this.windowManager.getDefaultDisplay();
    if (localDisplay != null)
    {
      this.vsyncDurationNs = ((1000000000.0D / localDisplay.getRefreshRate()));
      this.vsyncOffsetNs = (this.vsyncDurationNs * 80L / 100L);
    }
  }
  
  public long adjustReleaseTime(long paramLong1, long paramLong2)
  {
    long l3 = paramLong1 * 1000L;
    long l1;
    long l2;
    if (this.haveSync)
    {
      if (paramLong1 != this.lastFramePresentationTimeUs)
      {
        this.frameCount += 1L;
        this.adjustedLastFrameTimeNs = this.pendingAdjustedFrameTimeNs;
      }
      if (this.frameCount >= 6L)
      {
        l1 = (l3 - this.syncFramePresentationTimeNs) / this.frameCount;
        l2 = this.adjustedLastFrameTimeNs + l1;
        if (isDriftTooLarge(l2, paramLong2))
        {
          this.haveSync = false;
          l1 = paramLong2;
          l2 = l3;
          if (!this.haveSync)
          {
            this.syncFramePresentationTimeNs = l3;
            this.syncUnadjustedReleaseTimeNs = paramLong2;
            this.frameCount = 0L;
            this.haveSync = true;
          }
          this.lastFramePresentationTimeUs = paramLong1;
          this.pendingAdjustedFrameTimeNs = l2;
          if ((this.vsyncSampler != null) && (this.vsyncDurationNs != -9223372036854775807L)) {
            break label199;
          }
        }
      }
    }
    label199:
    do
    {
      return l1;
      l1 = this.syncUnadjustedReleaseTimeNs + l2 - this.syncFramePresentationTimeNs;
      break;
      if (isDriftTooLarge(l3, paramLong2)) {
        this.haveSync = false;
      }
      l1 = paramLong2;
      l2 = l3;
      break;
      paramLong1 = this.vsyncSampler.sampledVsyncTimeNs;
    } while (paramLong1 == -9223372036854775807L);
    return closestVsync(l1, paramLong1, this.vsyncDurationNs) - this.vsyncOffsetNs;
  }
  
  public void disable()
  {
    if (this.windowManager != null)
    {
      if (this.displayListener != null) {
        this.displayListener.unregister();
      }
      this.vsyncSampler.removeObserver();
    }
  }
  
  public void enable()
  {
    this.haveSync = false;
    if (this.windowManager != null)
    {
      this.vsyncSampler.addObserver();
      if (this.displayListener != null) {
        this.displayListener.register();
      }
      updateDefaultDisplayRefreshRateParams();
    }
  }
  
  @TargetApi(17)
  final class DefaultDisplayListener
    implements DisplayManager.DisplayListener
  {
    private final DisplayManager displayManager;
    
    public DefaultDisplayListener(DisplayManager paramDisplayManager)
    {
      this.displayManager = paramDisplayManager;
    }
    
    public void onDisplayAdded(int paramInt) {}
    
    public void onDisplayChanged(int paramInt)
    {
      if (paramInt == 0) {
        VideoFrameReleaseTimeHelper.this.updateDefaultDisplayRefreshRateParams();
      }
    }
    
    public void onDisplayRemoved(int paramInt) {}
    
    public void register()
    {
      this.displayManager.registerDisplayListener(this, null);
    }
    
    public void unregister()
    {
      this.displayManager.unregisterDisplayListener(this);
    }
  }
  
  static final class VSyncSampler
    implements Handler.Callback, Choreographer.FrameCallback
  {
    private static final int CREATE_CHOREOGRAPHER = 0;
    private static final VSyncSampler INSTANCE = new VSyncSampler();
    private static final int MSG_ADD_OBSERVER = 1;
    private static final int MSG_REMOVE_OBSERVER = 2;
    private Choreographer choreographer;
    private final HandlerThread choreographerOwnerThread = new HandlerThread("ChoreographerOwner:Handler");
    private final Handler handler;
    private int observerCount;
    public volatile long sampledVsyncTimeNs = -9223372036854775807L;
    
    private VSyncSampler()
    {
      this.choreographerOwnerThread.start();
      this.handler = new Handler(this.choreographerOwnerThread.getLooper(), this);
      this.handler.sendEmptyMessage(0);
    }
    
    private void addObserverInternal()
    {
      this.observerCount += 1;
      if (this.observerCount == 1) {
        this.choreographer.postFrameCallback(this);
      }
    }
    
    private void createChoreographerInstanceInternal()
    {
      this.choreographer = Choreographer.getInstance();
    }
    
    public static VSyncSampler getInstance()
    {
      return INSTANCE;
    }
    
    private void removeObserverInternal()
    {
      this.observerCount -= 1;
      if (this.observerCount == 0)
      {
        this.choreographer.removeFrameCallback(this);
        this.sampledVsyncTimeNs = -9223372036854775807L;
      }
    }
    
    public void addObserver()
    {
      this.handler.sendEmptyMessage(1);
    }
    
    public void doFrame(long paramLong)
    {
      this.sampledVsyncTimeNs = paramLong;
      this.choreographer.postFrameCallbackDelayed(this, 500L);
    }
    
    public boolean handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return false;
      case 0: 
        createChoreographerInstanceInternal();
        return true;
      case 1: 
        addObserverInternal();
        return true;
      }
      removeObserverInternal();
      return true;
    }
    
    public void removeObserver()
    {
      this.handler.sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper
 * JD-Core Version:    0.7.0.1
 */