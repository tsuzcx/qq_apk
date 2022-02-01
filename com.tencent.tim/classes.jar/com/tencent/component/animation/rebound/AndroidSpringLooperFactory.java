package com.tencent.component.animation.rebound;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;

abstract class AndroidSpringLooperFactory
{
  public static SpringLooper createSpringLooper()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return ChoreographerAndroidSpringLooper.create();
    }
    return LegacyAndroidSpringLooper.create();
  }
  
  @TargetApi(16)
  static class ChoreographerAndroidSpringLooper
    extends SpringLooper
  {
    private final Choreographer mChoreographer;
    private final Choreographer.FrameCallback mFrameCallback;
    private long mLastTime;
    private boolean mStarted;
    
    public ChoreographerAndroidSpringLooper(Choreographer paramChoreographer)
    {
      this.mChoreographer = paramChoreographer;
      this.mFrameCallback = new AndroidSpringLooperFactory.ChoreographerAndroidSpringLooper.1(this);
    }
    
    public static ChoreographerAndroidSpringLooper create()
    {
      return new ChoreographerAndroidSpringLooper(Choreographer.getInstance());
    }
    
    public void start()
    {
      if (this.mStarted) {
        return;
      }
      this.mStarted = true;
      this.mLastTime = SystemClock.uptimeMillis();
      this.mChoreographer.removeFrameCallback(this.mFrameCallback);
      this.mChoreographer.postFrameCallback(this.mFrameCallback);
    }
    
    public void stop()
    {
      this.mStarted = false;
      this.mChoreographer.removeFrameCallback(this.mFrameCallback);
    }
  }
  
  static class LegacyAndroidSpringLooper
    extends SpringLooper
  {
    private final Handler mHandler;
    private long mLastTime;
    private final Runnable mLooperRunnable;
    private boolean mStarted;
    
    public LegacyAndroidSpringLooper(Handler paramHandler)
    {
      this.mHandler = paramHandler;
      this.mLooperRunnable = new AndroidSpringLooperFactory.LegacyAndroidSpringLooper.1(this);
    }
    
    public static SpringLooper create()
    {
      return new LegacyAndroidSpringLooper(new Handler());
    }
    
    public void start()
    {
      if (this.mStarted) {
        return;
      }
      this.mStarted = true;
      this.mLastTime = SystemClock.uptimeMillis();
      this.mHandler.removeCallbacks(this.mLooperRunnable);
      this.mHandler.post(this.mLooperRunnable);
    }
    
    public void stop()
    {
      this.mStarted = false;
      this.mHandler.removeCallbacks(this.mLooperRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.animation.rebound.AndroidSpringLooperFactory
 * JD-Core Version:    0.7.0.1
 */