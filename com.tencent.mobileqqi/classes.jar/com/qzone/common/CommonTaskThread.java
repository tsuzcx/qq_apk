package com.qzone.common;

import android.os.Handler;
import android.os.HandlerThread;

public class CommonTaskThread
  extends HandlerThread
{
  private static CommonTaskThread thread = new CommonTaskThread("CommonTaskThread");
  private Handler handler;
  
  public CommonTaskThread(String paramString)
  {
    super(paramString, 10);
    start();
  }
  
  public static CommonTaskThread getInstance()
  {
    return thread;
  }
  
  public void post(Runnable paramRunnable)
  {
    try
    {
      if (this.handler == null) {
        this.handler = new Handler(getLooper());
      }
      this.handler.post(paramRunnable);
      return;
    }
    finally {}
  }
  
  public void postDelay(Runnable paramRunnable, long paramLong)
  {
    try
    {
      if (this.handler == null) {
        this.handler = new Handler(getLooper());
      }
      this.handler.postDelayed(paramRunnable, paramLong);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.common.CommonTaskThread
 * JD-Core Version:    0.7.0.1
 */