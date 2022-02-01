package com.tencent.intervideo.nowproxy.common;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class ThreadManager
{
  public static volatile HandlerThread FILE_HANDLER_THREAD = null;
  public static volatile Handler FILE_THREAD_HANDLER = null;
  public static volatile Handler UI_THREAD_HANDLER = null;
  
  public static Handler getFileThreadHandler()
  {
    if (FILE_HANDLER_THREAD == null) {}
    try
    {
      FILE_HANDLER_THREAD = new HandlerThread("nowlive_install", 0);
      FILE_HANDLER_THREAD.start();
      FILE_THREAD_HANDLER = new Handler(FILE_HANDLER_THREAD.getLooper());
      return FILE_THREAD_HANDLER;
    }
    finally {}
  }
  
  public static Handler getUIThreadHandler()
  {
    if (FILE_HANDLER_THREAD == null) {}
    try
    {
      FILE_THREAD_HANDLER = new Handler(Looper.getMainLooper());
      return FILE_THREAD_HANDLER;
    }
    finally {}
  }
  
  public static void unInit()
  {
    try
    {
      if (FILE_HANDLER_THREAD != null)
      {
        FILE_HANDLER_THREAD.quit();
        FILE_HANDLER_THREAD = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.common.ThreadManager
 * JD-Core Version:    0.7.0.1
 */