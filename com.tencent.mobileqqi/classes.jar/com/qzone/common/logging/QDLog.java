package com.qzone.common.logging;

public class QDLog
{
  public static final String TAG_DOWNLOAD = "downloader";
  private static Log sLog;
  
  public static void d(String paramString1, String paramString2)
  {
    d(paramString1, paramString2, null);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((sLog != null) && (sLog.isDebugEnabled()))
    {
      sLog.d(paramString1, paramString2, paramThrowable);
      return;
    }
    android.util.Log.d(paramString1, paramString2, paramThrowable);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    e(paramString1, paramString2, null);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((sLog != null) && (sLog.isErrorEnabled()))
    {
      sLog.e(paramString1, paramString2, paramThrowable);
      return;
    }
    android.util.Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public static Log getLog()
  {
    return sLog;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    i(paramString1, paramString2, null);
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((sLog != null) && (sLog.isInfoEnabled()))
    {
      sLog.i(paramString1, paramString2, paramThrowable);
      return;
    }
    android.util.Log.i(paramString1, paramString2, paramThrowable);
  }
  
  public static void setLog(Log paramLog)
  {
    sLog = paramLog;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    v(paramString1, paramString2, null);
  }
  
  public static void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((sLog != null) && (sLog.isVerboseEnabled()))
    {
      sLog.v(paramString1, paramString2, paramThrowable);
      return;
    }
    android.util.Log.v(paramString1, paramString2, paramThrowable);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    w(paramString1, paramString2, null);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((sLog != null) && (sLog.isWarnEnabled()))
    {
      sLog.w(paramString1, paramString2, paramThrowable);
      return;
    }
    android.util.Log.w(paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.common.logging.QDLog
 * JD-Core Version:    0.7.0.1
 */