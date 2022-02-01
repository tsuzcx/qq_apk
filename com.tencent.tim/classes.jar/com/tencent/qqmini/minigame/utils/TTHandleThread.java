package com.tencent.qqmini.minigame.utils;

import android.os.Handler;
import android.os.HandlerThread;

public class TTHandleThread
  extends HandlerThread
{
  private static Handler handler;
  private static volatile TTHandleThread instance;
  
  private TTHandleThread(String paramString)
  {
    super(paramString);
  }
  
  public static Handler getHandler()
  {
    return handler;
  }
  
  public static TTHandleThread getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null)
      {
        TTHandleThread localTTHandleThread = new TTHandleThread("TTIOThread");
        localTTHandleThread.start();
        handler = new Handler(localTTHandleThread.getLooper());
        instance = localTTHandleThread;
      }
      return instance;
    }
    finally {}
  }
  
  public final void post(Runnable paramRunnable)
  {
    handler.post(paramRunnable);
  }
  
  public final void postDelayed(Runnable paramRunnable, long paramLong)
  {
    handler.postDelayed(paramRunnable, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.utils.TTHandleThread
 * JD-Core Version:    0.7.0.1
 */