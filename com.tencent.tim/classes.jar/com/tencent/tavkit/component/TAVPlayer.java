package com.tencent.tavkit.component;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.player.IPlayer.PlayerListener;
import com.tencent.tav.player.IPlayer.PlayerStatus;
import com.tencent.tav.player.OnCompositionUpdateListener;
import com.tencent.tav.player.Player;
import com.tencent.tav.player.PlayerItem;
import com.tencent.tav.player.PlayerLayer;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;

public class TAVPlayer
{
  public static final int VIDEO_PLAYER_HEIGHT = 960;
  public static final int VIDEO_PLAYER_WIDTH = 540;
  private final String TAG = "GameTemplatePlayer@" + Integer.toHexString(hashCode());
  private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = new TAVPlayer.4(this);
  private AudioManager audioManager;
  private boolean audioTracksMerge = true;
  private OnCompositionUpdateListener compositionUpdateListener;
  private Context context;
  private boolean isAllowInterrupt = true;
  private boolean isAutoPlay = true;
  private boolean isResetting = false;
  private boolean loopPlay = false;
  @Nullable
  private FrameLayout mPlayerLayout;
  private CMTimeRange playRange;
  private Player player;
  private IPlayer.PlayerListener playerListener;
  private CMTime position = CMTime.CMTimeZero;
  private PostUpdateThread postUpdateThread;
  private Surface surface;
  private int surfaceHeight;
  private int surfaceWidth;
  private TAVComposition tavComposition;
  private boolean videoTracksMerge = true;
  private float volume = 1.0F;
  
  public TAVPlayer() {}
  
  public TAVPlayer(Surface paramSurface, int paramInt1, int paramInt2)
  {
    onSurfaceCreate(paramSurface, paramInt2, paramInt1);
  }
  
  public TAVPlayer(FrameLayout paramFrameLayout)
  {
    this.context = paramFrameLayout.getContext();
    this.mPlayerLayout = paramFrameLayout;
    initContentView();
  }
  
  private void abandonAudioFocus()
  {
    if (this.audioManager == null) {
      return;
    }
    this.audioManager.abandonAudioFocus(this.audioFocusChangeListener);
  }
  
  @NonNull
  private PlayerItem buildPlayerItem(TAVComposition paramTAVComposition)
  {
    Logger.d(this.TAG, "buildPlayerItem() called with: tavComposition = [" + paramTAVComposition + "]");
    paramTAVComposition = new TAVCompositionBuilder(paramTAVComposition);
    paramTAVComposition.setVideoTracksMerge(this.videoTracksMerge);
    paramTAVComposition.setAudioTracksMerge(this.audioTracksMerge);
    paramTAVComposition = paramTAVComposition.buildSource();
    PlayerItem localPlayerItem = new PlayerItem(paramTAVComposition.getAsset());
    localPlayerItem.setVideoComposition(paramTAVComposition.getVideoComposition());
    localPlayerItem.setAudioMix(paramTAVComposition.getAudioMix());
    return localPlayerItem;
  }
  
  private void initContentView()
  {
    if (this.mPlayerLayout == null) {
      return;
    }
    this.mPlayerLayout.removeAllViews();
    TextureView localTextureView = new TextureView(this.context);
    localTextureView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.mPlayerLayout.addView(localTextureView);
    localTextureView.setSurfaceTextureListener(new TAVPlayer.1(this));
  }
  
  @NonNull
  private Player newPlayer(PlayerItem paramPlayerItem, CMTime paramCMTime, boolean paramBoolean)
  {
    Logger.d(this.TAG, "newPlayer() called with: playerItem = [" + paramPlayerItem + "], position = [" + paramCMTime + "], autoPlay = [" + paramBoolean + "]");
    Log.d(this.TAG, "newVersion, onSurfaceTextureAvailable: use surfaceTexture");
    paramPlayerItem = new Player(paramPlayerItem);
    paramPlayerItem.setPlayerListener(this.playerListener);
    paramPlayerItem.setLoop(this.loopPlay);
    paramPlayerItem.setPlayRange(this.playRange);
    paramPlayerItem.setVolume(this.volume);
    paramPlayerItem.seekToTime(paramCMTime);
    new PlayerLayer(this.surface, this.surfaceWidth, this.surfaceHeight).setPlayer(paramPlayerItem);
    if ((paramBoolean) && (requestAudioFocus())) {
      paramPlayerItem.play();
    }
    if (this.compositionUpdateListener != null) {
      this.compositionUpdateListener.onUpdated(paramPlayerItem, false);
    }
    this.isResetting = false;
    return paramPlayerItem;
  }
  
  private boolean requestAudioFocus()
  {
    if (this.context == null) {
      return true;
    }
    if (this.audioManager == null) {
      this.audioManager = ((AudioManager)this.context.getSystemService("audio"));
    }
    if (this.audioManager.requestAudioFocus(this.audioFocusChangeListener, 3, 1) == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void setPlayerListener(IPlayer.PlayerListener paramPlayerListener)
  {
    Logger.d(this.TAG, "setPlayerListener() called with: playerListener = [" + paramPlayerListener + "],player = " + this.player);
    this.playerListener = paramPlayerListener;
    if (this.player != null) {
      this.player.setPlayerListener(paramPlayerListener);
    }
  }
  
  /* Error */
  public IPlayer.PlayerStatus getCurrentStatus()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 144	com/tencent/tavkit/component/TAVPlayer:player	Lcom/tencent/tav/player/Player;
    //   6: ifnonnull +11 -> 17
    //   9: getstatic 336	com/tencent/tav/player/IPlayer$PlayerStatus:ERROR	Lcom/tencent/tav/player/IPlayer$PlayerStatus;
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_0
    //   18: getfield 144	com/tencent/tavkit/component/TAVPlayer:player	Lcom/tencent/tav/player/Player;
    //   21: invokevirtual 339	com/tencent/tav/player/Player:currentStatus	()Lcom/tencent/tav/player/IPlayer$PlayerStatus;
    //   24: astore_1
    //   25: goto -12 -> 13
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	TAVPlayer
    //   12	13	1	localPlayerStatus	IPlayer.PlayerStatus
    //   28	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	28	finally
    //   17	25	28	finally
  }
  
  /* Error */
  public CMTime getPosition()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 144	com/tencent/tavkit/component/TAVPlayer:player	Lcom/tencent/tav/player/Player;
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: getfield 144	com/tencent/tavkit/component/TAVPlayer:player	Lcom/tencent/tav/player/Player;
    //   13: invokevirtual 343	com/tencent/tav/player/Player:position	()Lcom/tencent/tav/coremedia/CMTime;
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: areturn
    //   21: getstatic 346	com/tencent/tav/coremedia/CMTime:CMTimeInvalid	Lcom/tencent/tav/coremedia/CMTime;
    //   24: astore_1
    //   25: goto -8 -> 17
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	TAVPlayer
    //   16	9	1	localCMTime	CMTime
    //   28	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	28	finally
    //   21	25	28	finally
  }
  
  public float getVolume()
  {
    try
    {
      float f = this.volume;
      return f;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public boolean isPlaying()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 144	com/tencent/tavkit/component/TAVPlayer:player	Lcom/tencent/tav/player/Player;
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: getfield 144	com/tencent/tavkit/component/TAVPlayer:player	Lcom/tencent/tav/player/Player;
    //   13: invokevirtual 351	com/tencent/tav/player/Player:isPlaying	()Z
    //   16: istore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_1
    //   20: ireturn
    //   21: iconst_0
    //   22: istore_1
    //   23: goto -6 -> 17
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	TAVPlayer
    //   16	7	1	bool	boolean
    //   26	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	26	finally
  }
  
  public boolean isResetting()
  {
    return this.isResetting;
  }
  
  public void onSurfaceCreate(Surface paramSurface, int paramInt1, int paramInt2)
  {
    this.surfaceWidth = paramInt2;
    this.surfaceHeight = paramInt1;
    this.surface = paramSurface;
    updateComposition(this.tavComposition, this.position, this.isAutoPlay, this.compositionUpdateListener);
  }
  
  public void onSurfaceDestory()
  {
    if ((this.player != null) && (!this.player.isReleased()))
    {
      this.position = this.player.position();
      this.player.release();
    }
    this.surface = null;
  }
  
  public void onSurfaceSizeChanged(int paramInt1, int paramInt2)
  {
    if (this.player != null) {
      this.player.updateViewport(paramInt1, paramInt2);
    }
  }
  
  /* Error */
  public void pause()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 85	com/tencent/tavkit/component/TAVPlayer:TAG	Ljava/lang/String;
    //   6: new 62	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 371
    //   16: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload_0
    //   20: getfield 144	com/tencent/tavkit/component/TAVPlayer:player	Lcom/tencent/tav/player/Player;
    //   23: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 166	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield 144	com/tencent/tavkit/component/TAVPlayer:player	Lcom/tencent/tav/player/Player;
    //   36: ifnull +17 -> 53
    //   39: aload_0
    //   40: invokespecial 373	com/tencent/tavkit/component/TAVPlayer:abandonAudioFocus	()V
    //   43: aload_0
    //   44: getfield 144	com/tencent/tavkit/component/TAVPlayer:player	Lcom/tencent/tav/player/Player;
    //   47: invokevirtual 375	com/tencent/tav/player/Player:pause	()V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: aload_0
    //   54: iconst_0
    //   55: putfield 89	com/tencent/tavkit/component/TAVPlayer:isAutoPlay	Z
    //   58: goto -8 -> 50
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	TAVPlayer
    //   61	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	50	61	finally
    //   53	58	61	finally
  }
  
  /* Error */
  public void play()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 85	com/tencent/tavkit/component/TAVPlayer:TAG	Ljava/lang/String;
    //   6: new 62	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 377
    //   16: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload_0
    //   20: getfield 144	com/tencent/tavkit/component/TAVPlayer:player	Lcom/tencent/tav/player/Player;
    //   23: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 166	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield 144	com/tencent/tavkit/component/TAVPlayer:player	Lcom/tencent/tav/player/Player;
    //   36: ifnull +20 -> 56
    //   39: aload_0
    //   40: invokespecial 302	com/tencent/tavkit/component/TAVPlayer:requestAudioFocus	()Z
    //   43: ifeq +10 -> 53
    //   46: aload_0
    //   47: getfield 144	com/tencent/tavkit/component/TAVPlayer:player	Lcom/tencent/tav/player/Player;
    //   50: invokevirtual 305	com/tencent/tav/player/Player:play	()V
    //   53: aload_0
    //   54: monitorexit
    //   55: return
    //   56: aload_0
    //   57: iconst_1
    //   58: putfield 89	com/tencent/tavkit/component/TAVPlayer:isAutoPlay	Z
    //   61: goto -8 -> 53
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	TAVPlayer
    //   64	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	53	64	finally
    //   56	61	64	finally
  }
  
  public void postUpdate(@NonNull ICompositionBuilder paramICompositionBuilder, boolean paramBoolean)
  {
    try
    {
      if (this.postUpdateThread == null)
      {
        this.postUpdateThread = new PostUpdateThread("PostUpdateThread", null);
        this.postUpdateThread.start();
      }
      this.postUpdateThread.update(paramICompositionBuilder, paramBoolean);
      return;
    }
    finally {}
  }
  
  public void postUpdate(TAVComposition paramTAVComposition, boolean paramBoolean)
  {
    try
    {
      postUpdate(new TAVPlayer.5(this, paramTAVComposition), paramBoolean);
      return;
    }
    finally
    {
      paramTAVComposition = finally;
      throw paramTAVComposition;
    }
  }
  
  public void release()
  {
    try
    {
      Logger.d(this.TAG, "release: player = " + this.player);
      if (this.player != null)
      {
        this.position = this.player.position();
        abandonAudioFocus();
        this.player.release();
        this.player = null;
      }
      if (this.postUpdateThread != null)
      {
        this.postUpdateThread.quit();
        this.postUpdateThread = null;
      }
      this.isResetting = false;
      return;
    }
    finally {}
  }
  
  public void reset()
  {
    try
    {
      Log.d(this.TAG, "reset() called");
      this.isResetting = true;
      initContentView();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void seekToTime(CMTime paramCMTime)
  {
    Logger.d(this.TAG, "seekToTime() called with: cmTime = [" + paramCMTime + "],player = " + this.player);
    if (this.player != null) {
      this.player.seekToTime(paramCMTime);
    }
  }
  
  public void setAllowInterrupt(boolean paramBoolean)
  {
    this.isAllowInterrupt = paramBoolean;
  }
  
  public void setAudioTracksMerge(boolean paramBoolean)
  {
    this.audioTracksMerge = paramBoolean;
  }
  
  public void setAutoPlay(boolean paramBoolean)
  {
    try
    {
      this.isAutoPlay = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setLoopPlay(boolean paramBoolean)
  {
    try
    {
      Logger.d(this.TAG, "setLoopPlay() called with: loopPlay = [" + paramBoolean + "],player = " + this.player);
      this.loopPlay = paramBoolean;
      if (this.player != null) {
        this.player.setLoop(paramBoolean);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setPlayRange(CMTimeRange paramCMTimeRange)
  {
    try
    {
      Logger.d(this.TAG, "setPlayRange() called with: playRange = [" + paramCMTimeRange + "],player = " + this.player);
      this.playRange = paramCMTimeRange;
      if (this.player != null) {
        this.player.setPlayRange(paramCMTimeRange);
      }
      return;
    }
    finally
    {
      paramCMTimeRange = finally;
      throw paramCMTimeRange;
    }
  }
  
  public void setPlayerListener(PlayerListener paramPlayerListener)
  {
    Logger.d(this.TAG, "setPlayerListener() called with: playerListener = [" + paramPlayerListener + "],player = " + this.player);
    setPlayerListener(new TAVPlayer.2(this, paramPlayerListener));
  }
  
  public void setVideoTracksMerge(boolean paramBoolean)
  {
    this.videoTracksMerge = paramBoolean;
  }
  
  public void setVolume(float paramFloat)
  {
    try
    {
      Logger.d(this.TAG, "setVolume() called with: volume = [" + paramFloat + "],player = " + this.player);
      this.volume = paramFloat;
      if (this.player != null) {
        this.player.setVolume(paramFloat);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void updateComposition(TAVComposition paramTAVComposition, CMTime paramCMTime, boolean paramBoolean)
  {
    updateComposition(paramTAVComposition, paramCMTime, paramBoolean, null);
  }
  
  public void updateComposition(TAVComposition paramTAVComposition, CMTime paramCMTime, boolean paramBoolean, OnCompositionUpdateListener paramOnCompositionUpdateListener)
  {
    Logger.d(this.TAG, "updateComposition() called with: tavComposition = [" + paramTAVComposition + "], position = [" + paramCMTime + "], autoPlay = [" + paramBoolean + "]");
    this.tavComposition = paramTAVComposition;
    this.position = paramCMTime;
    this.compositionUpdateListener = paramOnCompositionUpdateListener;
    if (paramTAVComposition == null)
    {
      this.isResetting = false;
      return;
    }
    if (this.surface == null)
    {
      this.isAutoPlay = paramBoolean;
      this.isResetting = false;
      return;
    }
    paramTAVComposition = buildPlayerItem(paramTAVComposition);
    if ((this.player == null) || (this.player.isReleased()))
    {
      this.player = newPlayer(paramTAVComposition, paramCMTime, paramBoolean);
      return;
    }
    Player localPlayer = this.player;
    if (paramOnCompositionUpdateListener != null) {}
    for (;;)
    {
      localPlayer.update(paramTAVComposition, paramCMTime, paramOnCompositionUpdateListener);
      this.compositionUpdateListener = null;
      return;
      paramOnCompositionUpdateListener = new TAVPlayer.3(this, paramCMTime, paramBoolean);
    }
  }
  
  public void updateComposition(TAVComposition paramTAVComposition, boolean paramBoolean)
  {
    updateComposition(paramTAVComposition, CMTime.CMTimeZero, paramBoolean);
  }
  
  public static abstract interface ICompositionBuilder
    extends OnCompositionUpdateListener
  {
    @NonNull
    public abstract TAVComposition buildComposition();
  }
  
  public static abstract interface PlayerListener
  {
    public abstract void onPositionChanged(CMTime paramCMTime1, CMTime paramCMTime2);
    
    public abstract void onStatusChanged(IPlayer.PlayerStatus paramPlayerStatus, Player paramPlayer);
  }
  
  class PostUpdateThread
    extends HandlerThread
    implements Handler.Callback
  {
    private static final int MSG_UNLOCK = 95;
    private static final int MSG_UPDATE = 223;
    private boolean autoPlay;
    private Handler handler;
    private volatile boolean msgLock = false;
    private TAVPlayer.ICompositionBuilder templateSource;
    
    private PostUpdateThread(String paramString)
    {
      super();
    }
    
    private void doUnlockMsg()
    {
      if (this.msgLock)
      {
        this.msgLock = false;
        if (this.templateSource != null) {
          update(this.templateSource, this.autoPlay);
        }
      }
    }
    
    private void doUpdateComposition(TAVPlayer.ICompositionBuilder paramICompositionBuilder, boolean paramBoolean)
    {
      unlockMsg(1000);
      TAVComposition localTAVComposition = paramICompositionBuilder.buildComposition();
      TAVPlayer.this.updateComposition(localTAVComposition, CMTime.CMTimeZero, paramBoolean, new TAVPlayer.PostUpdateThread.1(this, paramICompositionBuilder));
    }
    
    private void doUpdateMsg()
    {
      if ((!this.msgLock) && (this.templateSource != null))
      {
        Log.d(TAVPlayer.this.TAG, "doUpdateMsg() called");
        this.msgLock = true;
        doUpdateComposition(this.templateSource, this.autoPlay);
        this.templateSource = null;
        this.autoPlay = false;
      }
    }
    
    private void unlockMsg(int paramInt)
    {
      try
      {
        Logger.d(TAVPlayer.this.TAG, "unlockMsg() called thread = " + Thread.currentThread().getName());
        this.handler.removeMessages(95);
        this.handler.sendEmptyMessageDelayed(95, paramInt);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    private void update(TAVPlayer.ICompositionBuilder paramICompositionBuilder, boolean paramBoolean)
    {
      try
      {
        Logger.d(TAVPlayer.this.TAG, "update() called with: thread = " + Thread.currentThread().getName() + ", templateSource = [" + paramICompositionBuilder + "], autoPlay = [" + paramBoolean + "]");
        this.templateSource = paramICompositionBuilder;
        this.autoPlay = paramBoolean;
        this.handler.removeMessages(223);
        this.handler.sendEmptyMessage(223);
        return;
      }
      finally
      {
        paramICompositionBuilder = finally;
        throw paramICompositionBuilder;
      }
    }
    
    public boolean handleMessage(Message paramMessage)
    {
      Logger.d(TAVPlayer.this.TAG, "handleMessage() called with: msg = [" + paramMessage + "] msgLock = " + this.msgLock + ",templateSource = " + this.templateSource);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        return true;
        doUpdateMsg();
        continue;
        doUnlockMsg();
      }
    }
    
    protected void onLooperPrepared()
    {
      super.onLooperPrepared();
    }
    
    public void release()
    {
      this.templateSource = null;
      if (this.handler != null)
      {
        this.handler.removeCallbacksAndMessages(null);
        this.handler = null;
      }
      quit();
    }
    
    public void start()
    {
      try
      {
        super.start();
        this.handler = new Handler(getLooper(), this);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVPlayer
 * JD-Core Version:    0.7.0.1
 */