package com.tencent.moai.proxycat.util;

public class Logger
{
  private static LoggerDelegate delegate = new Logger.1();
  
  public static void d(String paramString1, String paramString2)
  {
    delegate.log(3, paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    delegate.log(6, paramString1, paramString2);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    delegate.log(2, paramString1, paramString2);
  }
  
  public static void setDelegate(LoggerDelegate paramLoggerDelegate)
  {
    if (paramLoggerDelegate != null) {
      delegate = paramLoggerDelegate;
    }
  }
  
  public static void v(String paramString1, String paramString2)
  {
    delegate.log(2, paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    delegate.log(5, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.proxycat.util.Logger
 * JD-Core Version:    0.7.0.1
 */