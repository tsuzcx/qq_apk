package com.tencent.camerasdk.avreporter;

import android.util.Log;

public class LogUtils
{
  private static volatile LogProxy logProxy = null;
  
  public static void d(String paramString1, String paramString2)
  {
    if (logProxy != null)
    {
      logProxy.d(paramString1, paramString2);
      return;
    }
    Log.d(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    e(paramString1, paramString2, null);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (paramThrowable == null)
    {
      if (logProxy != null)
      {
        logProxy.e(paramString1, paramString2);
        return;
      }
      Log.e(paramString1, paramString2);
      return;
    }
    if (logProxy != null)
    {
      logProxy.e(paramString1, paramString2, paramThrowable);
      return;
    }
    Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public static void setProxy(LogProxy paramLogProxy)
  {
    if (logProxy == null) {
      try
      {
        if (logProxy != null) {
          return;
        }
        logProxy = paramLogProxy;
        return;
      }
      finally {}
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    w(paramString1, paramString2, null);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (paramThrowable == null)
    {
      if (logProxy != null)
      {
        logProxy.w(paramString1, paramString2);
        return;
      }
      Log.w(paramString1, paramString2);
      return;
    }
    if (logProxy != null)
    {
      logProxy.w(paramString1, paramString2, paramThrowable);
      return;
    }
    Log.w(paramString1, paramString2, paramThrowable);
  }
  
  public static abstract interface LogProxy
  {
    public abstract void d(String paramString1, String paramString2);
    
    public abstract void e(String paramString1, String paramString2);
    
    public abstract void e(String paramString1, String paramString2, Throwable paramThrowable);
    
    public abstract void w(String paramString1, String paramString2);
    
    public abstract void w(String paramString1, String paramString2, Throwable paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.camerasdk.avreporter.LogUtils
 * JD-Core Version:    0.7.0.1
 */