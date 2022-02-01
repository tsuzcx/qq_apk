package com.tencent.mm.opensdk.utils;

public class Log
{
  private static ILog logImpl;
  
  public static void d(String paramString1, String paramString2)
  {
    if (logImpl == null)
    {
      android.util.Log.d(paramString1, paramString2);
      return;
    }
    logImpl.d(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (logImpl == null)
    {
      android.util.Log.e(paramString1, paramString2);
      return;
    }
    logImpl.e(paramString1, paramString2);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (logImpl == null)
    {
      android.util.Log.i(paramString1, paramString2);
      return;
    }
    logImpl.i(paramString1, paramString2);
  }
  
  public static void setLogImpl(ILog paramILog)
  {
    logImpl = paramILog;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (logImpl == null)
    {
      android.util.Log.v(paramString1, paramString2);
      return;
    }
    logImpl.v(paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (logImpl == null)
    {
      android.util.Log.w(paramString1, paramString2);
      return;
    }
    logImpl.w(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.opensdk.utils.Log
 * JD-Core Version:    0.7.0.1
 */