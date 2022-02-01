package com.tencent.webbundle.sdk;

import android.os.Handler;
import android.os.Looper;

public class ThreadManager
{
  private static volatile Handler sUiHandler;
  
  static void checkMainThread(String paramString)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new IllegalThreadStateException(paramString + " need to be invoke in main thread.");
    }
  }
  
  static void executeOnUiThread(Runnable paramRunnable)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramRunnable.run();
      return;
    }
    getUiHandler().postAtFrontOfQueue(paramRunnable);
  }
  
  public static Handler getUiHandler()
  {
    if (sUiHandler == null) {}
    try
    {
      if (sUiHandler == null) {
        sUiHandler = new Handler(Looper.getMainLooper());
      }
      return sUiHandler;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.webbundle.sdk.ThreadManager
 * JD-Core Version:    0.7.0.1
 */