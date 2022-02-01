package com.tencent.moai.downloader.util;

import com.tencent.moai.downloader.delegate.LogDelegate;

public class Logger
{
  private static LogDelegate delegate = new Logger.1();
  
  public static void d(String paramString1, String paramString2)
  {
    delegate.log(1, paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    delegate.log(4, paramString1, paramString2);
  }
  
  public static LogDelegate getDelegate()
  {
    return delegate;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    delegate.log(2, paramString1, paramString2);
  }
  
  public static void setDelegate(LogDelegate paramLogDelegate)
  {
    delegate = paramLogDelegate;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    delegate.log(0, paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    delegate.log(3, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.util.Logger
 * JD-Core Version:    0.7.0.1
 */