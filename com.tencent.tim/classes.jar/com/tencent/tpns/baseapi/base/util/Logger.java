package com.tencent.tpns.baseapi.base.util;

import com.tencent.tpns.baseapi.base.logger.TBaseLogger;

public class Logger
{
  public static void d(String paramString1, String paramString2)
  {
    TBaseLogger.d("Base-TPush - " + paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    TBaseLogger.e("Base-TPush - " + paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    TBaseLogger.e("Base-TPush - " + paramString1, paramString2, paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    TBaseLogger.i("Base-TPush - " + paramString1, paramString2);
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    TBaseLogger.i("Base-TPush - " + paramString1, paramString2, paramThrowable);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    TBaseLogger.w("Base-TPush - " + paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    TBaseLogger.w("Base-TPush - " + paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.base.util.Logger
 * JD-Core Version:    0.7.0.1
 */