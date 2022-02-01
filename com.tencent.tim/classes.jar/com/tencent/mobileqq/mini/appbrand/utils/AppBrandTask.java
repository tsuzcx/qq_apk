package com.tencent.mobileqq.mini.appbrand.utils;

import android.os.Handler;
import android.os.Looper;

public class AppBrandTask
{
  private static Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
  
  public static void runTaskOnUiThread(Runnable paramRunnable)
  {
    mMainThreadHandler.post(paramRunnable);
  }
  
  public static void runTaskOnUiThreadDelay(Runnable paramRunnable, long paramLong)
  {
    mMainThreadHandler.postDelayed(paramRunnable, paramLong);
  }
  
  public static void runTaskOnUiThreadIfNot(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      runTaskOnUiThread(paramRunnable);
      return;
    }
    paramRunnable.run();
  }
  
  public void clearTask()
  {
    mMainThreadHandler.removeCallbacksAndMessages(null);
  }
  
  public void clearTask(Runnable paramRunnable)
  {
    mMainThreadHandler.removeCallbacks(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask
 * JD-Core Version:    0.7.0.1
 */