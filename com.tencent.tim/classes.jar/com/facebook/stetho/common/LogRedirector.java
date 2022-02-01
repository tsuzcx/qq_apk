package com.facebook.stetho.common;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;

public class LogRedirector
{
  private static volatile Logger sLogger;
  
  public static void d(String paramString1, String paramString2)
  {
    log(3, paramString1, paramString2);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    d(paramString1, paramString2 + "\n" + formatThrowable(paramThrowable));
  }
  
  public static void e(String paramString1, String paramString2)
  {
    log(6, paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    e(paramString1, paramString2 + "\n" + formatThrowable(paramThrowable));
  }
  
  private static String formatThrowable(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    paramThrowable.printStackTrace();
    localPrintWriter.flush();
    return localStringWriter.toString();
  }
  
  public static void i(String paramString1, String paramString2)
  {
    log(4, paramString1, paramString2);
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    i(paramString1, paramString2 + "\n" + formatThrowable(paramThrowable));
  }
  
  public static boolean isLoggable(String paramString, int paramInt)
  {
    Logger localLogger = sLogger;
    if (localLogger != null) {
      return localLogger.isLoggable(paramString, paramInt);
    }
    return Log.isLoggable(paramString, paramInt);
  }
  
  private static void log(int paramInt, String paramString1, String paramString2)
  {
    Logger localLogger = sLogger;
    if (localLogger != null)
    {
      localLogger.log(paramInt, paramString1, paramString2);
      return;
    }
    Log.println(paramInt, paramString1, paramString2);
  }
  
  public static void setLogger(Logger paramLogger)
  {
    Util.throwIfNull(paramLogger);
    Util.throwIfNotNull(sLogger);
    sLogger = paramLogger;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    log(2, paramString1, paramString2);
  }
  
  public static void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    v(paramString1, paramString2 + "\n" + formatThrowable(paramThrowable));
  }
  
  public static void w(String paramString1, String paramString2)
  {
    log(5, paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    w(paramString1, paramString2 + "\n" + formatThrowable(paramThrowable));
  }
  
  public static abstract interface Logger
  {
    public abstract boolean isLoggable(String paramString, int paramInt);
    
    public abstract void log(int paramInt, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.common.LogRedirector
 * JD-Core Version:    0.7.0.1
 */