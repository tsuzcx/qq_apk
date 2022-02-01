package com.tencent.qqlive.module.videoreport.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadUtils
{
  private static final Executor EXECUTOR = Executors.newFixedThreadPool(2, new ThreadUtils.1());
  private static final Handler HANDLER = new Handler(Looper.getMainLooper());
  private static final AtomicInteger NUMBER = new AtomicInteger(1);
  
  public static void execTask(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      EXECUTOR.execute(paramRunnable);
    }
  }
  
  public static void execTask(Runnable paramRunnable, boolean paramBoolean)
  {
    if (paramRunnable == null) {
      return;
    }
    if (paramBoolean)
    {
      paramRunnable.run();
      return;
    }
    execTask(paramRunnable);
  }
  
  public static void runOnUiThread(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      HANDLER.post(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.ThreadUtils
 * JD-Core Version:    0.7.0.1
 */