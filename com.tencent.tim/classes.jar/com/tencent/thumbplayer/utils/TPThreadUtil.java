package com.tencent.thumbplayer.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class TPThreadUtil
{
  public static ExecutorService THREAD_POOL_EXECUTOR = ;
  private static volatile EventHandler mMainThreadHandler = null;
  private static volatile ScheduledExecutorService mScheduler = null;
  
  private static void getMainThreadHandler()
  {
    if (mMainThreadHandler == null) {
      try
      {
        if (mMainThreadHandler == null)
        {
          Looper localLooper = Looper.getMainLooper();
          if (localLooper != null) {
            mMainThreadHandler = new EventHandler(localLooper);
          }
        }
        else
        {
          return;
        }
        mMainThreadHandler = null;
        throw new IllegalStateException("cannot get thread looper");
      }
      finally {}
    }
  }
  
  public static ScheduledExecutorService getScheduledExecutorServiceInstance()
  {
    if (mScheduler == null) {}
    try
    {
      if (mScheduler == null) {
        mScheduler = Executors.newScheduledThreadPool(4);
      }
      return mScheduler;
    }
    finally {}
  }
  
  public static void postDelayRunnableOnMainThread(Runnable paramRunnable, long paramLong)
  {
    
    if (mMainThreadHandler != null) {
      mMainThreadHandler.postDelayed(paramRunnable, paramLong);
    }
  }
  
  public static void postRunnableOnMainThread(Runnable paramRunnable)
  {
    
    if (mMainThreadHandler != null) {
      mMainThreadHandler.post(paramRunnable);
    }
  }
  
  public static void postRunnableOnMainThreadFront(Runnable paramRunnable)
  {
    
    if (mMainThreadHandler != null) {
      mMainThreadHandler.postAtFrontOfQueue(paramRunnable);
    }
  }
  
  static class EventHandler
    extends Handler
  {
    public EventHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.TPThreadUtil
 * JD-Core Version:    0.7.0.1
 */