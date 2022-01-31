package com.tencent.mobileqq.emosm.web;

import android.os.Handler;
import android.os.HandlerThread;

public class EmojiIPCAlarmer
{
  static final String tag = "Q.emoji.web.EmojiIPC.Alarmer";
  private volatile Handler timeoutHandler;
  EmojiIPCAlarmer.TimeoutObserver timeoutObserver;
  
  public EmojiIPCAlarmer(EmojiIPCAlarmer.TimeoutObserver paramTimeoutObserver)
  {
    this.timeoutObserver = paramTimeoutObserver;
  }
  
  public Runnable addPendingMsg(Object paramObject, int paramInt)
  {
    paramObject = new EmojiIPCAlarmer.PendingTaskWrapper(this, paramObject);
    this.timeoutHandler.postDelayed(paramObject, paramInt);
    return paramObject;
  }
  
  public Runnable addTimeoutCheck(int paramInt, long paramLong)
  {
    EmojiIPCAlarmer.TimeoutTaskWrapper localTimeoutTaskWrapper = new EmojiIPCAlarmer.TimeoutTaskWrapper(this, paramInt);
    this.timeoutHandler.postDelayed(localTimeoutTaskWrapper, paramLong);
    return localTimeoutTaskWrapper;
  }
  
  public void addTimoutRunnable(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable != null) {
      this.timeoutHandler.postDelayed(paramRunnable, paramLong);
    }
  }
  
  public Handler getTimeoutHandler()
  {
    return this.timeoutHandler;
  }
  
  public void init()
  {
    HandlerThread localHandlerThread = new HandlerThread("EmojiIPCTimeoutChecker", 5);
    localHandlerThread.start();
    this.timeoutHandler = new Handler(localHandlerThread.getLooper());
  }
  
  public void removeTimeoutCheck(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      this.timeoutHandler.removeCallbacks(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.EmojiIPCAlarmer
 * JD-Core Version:    0.7.0.1
 */