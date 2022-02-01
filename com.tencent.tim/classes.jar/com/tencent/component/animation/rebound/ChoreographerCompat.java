package com.tencent.component.animation.rebound;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;

public class ChoreographerCompat
{
  private static final boolean IS_JELLYBEAN_OR_HIGHER;
  private static final long ONE_FRAME_MILLIS = 17L;
  private static ChoreographerCompat __instance;
  private Choreographer mChoreographer;
  private Handler mHandler;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    for (boolean bool = true;; bool = false)
    {
      IS_JELLYBEAN_OR_HIGHER = bool;
      __instance = new ChoreographerCompat();
      return;
    }
  }
  
  private ChoreographerCompat()
  {
    if (IS_JELLYBEAN_OR_HIGHER)
    {
      this.mChoreographer = getChoreographer();
      return;
    }
    this.mHandler = new Handler(Looper.getMainLooper());
  }
  
  @TargetApi(16)
  private void choreographerPostFrameCallback(Choreographer.FrameCallback paramFrameCallback)
  {
    this.mChoreographer.postFrameCallback(paramFrameCallback);
  }
  
  @TargetApi(16)
  private void choreographerPostFrameCallbackDelayed(Choreographer.FrameCallback paramFrameCallback, long paramLong)
  {
    this.mChoreographer.postFrameCallbackDelayed(paramFrameCallback, paramLong);
  }
  
  @TargetApi(16)
  private void choreographerRemoveFrameCallback(Choreographer.FrameCallback paramFrameCallback)
  {
    this.mChoreographer.removeFrameCallback(paramFrameCallback);
  }
  
  @TargetApi(16)
  private Choreographer getChoreographer()
  {
    return Choreographer.getInstance();
  }
  
  public static ChoreographerCompat getInstance()
  {
    return __instance;
  }
  
  public void postFrameCallback(FrameCallback paramFrameCallback)
  {
    if (IS_JELLYBEAN_OR_HIGHER)
    {
      choreographerPostFrameCallback(paramFrameCallback.getFrameCallback());
      return;
    }
    this.mHandler.postDelayed(paramFrameCallback.getRunnable(), 0L);
  }
  
  public void postFrameCallbackDelayed(FrameCallback paramFrameCallback, long paramLong)
  {
    if (IS_JELLYBEAN_OR_HIGHER)
    {
      choreographerPostFrameCallbackDelayed(paramFrameCallback.getFrameCallback(), paramLong);
      return;
    }
    this.mHandler.postDelayed(paramFrameCallback.getRunnable(), 17L + paramLong);
  }
  
  public void removeFrameCallback(FrameCallback paramFrameCallback)
  {
    if (IS_JELLYBEAN_OR_HIGHER)
    {
      choreographerRemoveFrameCallback(paramFrameCallback.getFrameCallback());
      return;
    }
    this.mHandler.removeCallbacks(paramFrameCallback.getRunnable());
  }
  
  public static abstract class FrameCallback
  {
    private Choreographer.FrameCallback mFrameCallback;
    private Runnable mRunnable;
    
    public abstract void doFrame(long paramLong);
    
    @TargetApi(16)
    Choreographer.FrameCallback getFrameCallback()
    {
      if (this.mFrameCallback == null) {
        this.mFrameCallback = new ChoreographerCompat.FrameCallback.1(this);
      }
      return this.mFrameCallback;
    }
    
    Runnable getRunnable()
    {
      if (this.mRunnable == null) {
        this.mRunnable = new ChoreographerCompat.FrameCallback.2(this);
      }
      return this.mRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.animation.rebound.ChoreographerCompat
 * JD-Core Version:    0.7.0.1
 */