package com.tencent.moai.nativepages.util;

import android.os.Handler;
import android.os.Looper;

public final class Threads
{
  public static final Handler mainHandler = new Handler(Looper.getMainLooper());
  
  public static void runOnMainThread(Runnable paramRunnable)
  {
    mainHandler.post(paramRunnable);
  }
  
  public static void runOnMainThread(Runnable paramRunnable, int paramInt)
  {
    mainHandler.postDelayed(paramRunnable, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.util.Threads
 * JD-Core Version:    0.7.0.1
 */