package com.tencent.mobileqq.emosm.web;

import android.os.Handler;
import android.os.HandlerThread;

public class EmojiIPCAlarmer
{
  a a;
  private volatile Handler cN;
  
  public EmojiIPCAlarmer(a parama)
  {
    this.a = parama;
  }
  
  public void af(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      this.cN.removeCallbacks(paramRunnable);
    }
  }
  
  public Runnable c(int paramInt, long paramLong)
  {
    TimeoutTaskWrapper localTimeoutTaskWrapper = new TimeoutTaskWrapper(paramInt);
    this.cN.postDelayed(localTimeoutTaskWrapper, paramLong);
    return localTimeoutTaskWrapper;
  }
  
  public void init()
  {
    HandlerThread localHandlerThread = new HandlerThread("EmojiIPCTimeoutChecker", 5);
    localHandlerThread.start();
    this.cN = new Handler(localHandlerThread.getLooper());
  }
  
  class PendingTaskWrapper
    implements Runnable
  {
    public void run() {}
  }
  
  class TimeoutTaskWrapper
    implements Runnable
  {
    private int cRe;
    
    public TimeoutTaskWrapper(int paramInt)
    {
      this.cRe = paramInt;
    }
    
    public void run()
    {
      if (EmojiIPCAlarmer.this.a != null) {}
      try
      {
        EmojiIPCAlarmer.this.a.onTimeOut(this.cRe);
        return;
      }
      catch (Throwable localThrowable) {}
    }
  }
  
  public static abstract interface a
  {
    public abstract void onTimeOut(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.EmojiIPCAlarmer
 * JD-Core Version:    0.7.0.1
 */