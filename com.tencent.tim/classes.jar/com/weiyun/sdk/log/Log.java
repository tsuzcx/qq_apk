package com.weiyun.sdk.log;

import com.weiyun.sdk.context.SdkContext;

public class Log
{
  public static void d(String paramString1, String paramString2)
  {
    SdkContext.getInstance().getLogger().d(paramString1, paramString2);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    SdkContext.getInstance().getLogger().d(paramString1, paramString2, paramThrowable);
  }
  
  public static void d(String paramString, Throwable paramThrowable)
  {
    SdkContext.getInstance().getLogger().d(paramString, paramThrowable);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    SdkContext.getInstance().getLogger().e(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    SdkContext.getInstance().getLogger().e(paramString1, paramString2, paramThrowable);
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    SdkContext.getInstance().getLogger().e(paramString, paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    SdkContext.getInstance().getLogger().i(paramString1, paramString2);
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    SdkContext.getInstance().getLogger().i(paramString1, paramString2, paramThrowable);
  }
  
  public static void i(String paramString, Throwable paramThrowable)
  {
    SdkContext.getInstance().getLogger().i(paramString, paramThrowable);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    SdkContext.getInstance().getLogger().v(paramString1, paramString2);
  }
  
  public static void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    SdkContext.getInstance().getLogger().v(paramString1, paramString2, paramThrowable);
  }
  
  public static void v(String paramString, Throwable paramThrowable)
  {
    SdkContext.getInstance().getLogger().v(paramString, paramThrowable);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    SdkContext.getInstance().getLogger().w(paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    SdkContext.getInstance().getLogger().w(paramString1, paramString2, paramThrowable);
  }
  
  public static void w(String paramString, Throwable paramThrowable)
  {
    SdkContext.getInstance().getLogger().w(paramString, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.log.Log
 * JD-Core Version:    0.7.0.1
 */