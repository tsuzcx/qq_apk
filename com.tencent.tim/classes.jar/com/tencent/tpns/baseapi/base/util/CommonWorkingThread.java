package com.tencent.tpns.baseapi.base.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;

public class CommonWorkingThread
{
  private static HandlerThread a = null;
  private static Handler b = null;
  
  private static void a()
  {
    try
    {
      if ((a == null) || (!a.isAlive()) || (a.isInterrupted()) || (a.getState() == Thread.State.TERMINATED))
      {
        a = new HandlerThread("tpns.baseapi.thread");
        a.start();
        Looper localLooper = a.getLooper();
        if (localLooper != null)
        {
          b = new Handler(localLooper);
          return;
        }
        Logger.e("CommonWorkingThread", ">>> Create new working thread false, cause thread.getLooper()==null");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      Logger.e("CommonWorkingThread", "unexpected for initHandler", localThrowable);
    }
  }
  
  public static CommonWorkingThread getInstance()
  {
    a();
    return CommonWorkingThreadHolder.instance;
  }
  
  public boolean execute(Runnable paramRunnable)
  {
    if (b != null) {
      return b.post(paramRunnable);
    }
    return false;
  }
  
  public boolean execute(Runnable paramRunnable, long paramLong)
  {
    if (b != null) {
      return b.postDelayed(paramRunnable, paramLong);
    }
    return false;
  }
  
  public boolean executeAtTime(Runnable paramRunnable, int paramInt, long paramLong)
  {
    if (b != null) {
      return b.postAtTime(paramRunnable, Integer.valueOf(paramInt), SystemClock.uptimeMillis() + paramLong);
    }
    return false;
  }
  
  public Handler getHandler()
  {
    return b;
  }
  
  public void remove(int paramInt)
  {
    if (b != null) {
      b.removeCallbacksAndMessages(Integer.valueOf(paramInt));
    }
  }
  
  public void remove(Runnable paramRunnable)
  {
    if (b != null) {
      b.removeCallbacks(paramRunnable);
    }
  }
  
  public static class CommonWorkingThreadHolder
  {
    public static CommonWorkingThread instance = new CommonWorkingThread(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.base.util.CommonWorkingThread
 * JD-Core Version:    0.7.0.1
 */