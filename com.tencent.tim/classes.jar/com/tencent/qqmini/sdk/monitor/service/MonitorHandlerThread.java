package com.tencent.qqmini.sdk.monitor.service;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class MonitorHandlerThread
{
  private static HT loopThread = null;
  private static HT writeLogThread = null;
  
  public static Handler getLooperThreadHandler()
  {
    if (loopThread == null) {
      loopThread = new HT("loop", null);
    }
    return loopThread.getHandler();
  }
  
  public static Handler getWriteFileHandler()
  {
    if (writeLogThread == null) {
      writeLogThread = new HT("writelog", null);
    }
    return writeLogThread.getHandler();
  }
  
  static class HT
  {
    private Handler handler = null;
    public HandlerThread handlerThread = null;
    private Looper looper = null;
    
    public HT(String paramString, HandlerThread paramHandlerThread)
    {
      if (paramHandlerThread != null) {
        this.handlerThread = paramHandlerThread;
      }
      for (;;)
      {
        this.looper = this.handlerThread.getLooper();
        this.handler = new Handler(this.looper);
        return;
        this.handlerThread = new HandlerThread("Tencent_PerformanceMonitorThread_" + paramString);
        this.handlerThread.start();
      }
    }
    
    public Handler getHandler()
    {
      return this.handler;
    }
    
    public Looper getLooper()
    {
      return this.looper;
    }
  }
  
  public static abstract interface ThreadFactory
  {
    public abstract HandlerThread getLooperThread();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.service.MonitorHandlerThread
 * JD-Core Version:    0.7.0.1
 */