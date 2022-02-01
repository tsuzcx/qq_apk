package com.tencent.qqlive.module.videoreport;

import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;

public class Log
{
  public static void d(String paramString1, String paramString2)
  {
    ILogger localILogger = getLogger();
    if ((VideoReportInner.getInstance().isDebugMode()) && (localILogger != null)) {
      localILogger.d(paramString1, paramString2);
    }
  }
  
  public static void ddf(String paramString1, String paramString2, Object... paramVarArgs)
  {
    try
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      label8:
      break label8;
    }
    d(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    ILogger localILogger = getLogger();
    if ((VideoReportInner.getInstance().isDebugMode()) && (localILogger != null)) {
      localILogger.e(paramString1, paramString2);
    }
  }
  
  private static ILogger getLogger()
  {
    return VideoReportInner.getInstance().getConfiguration().getLogger();
  }
  
  public static void i(String paramString1, String paramString2)
  {
    ILogger localILogger = getLogger();
    if ((VideoReportInner.getInstance().isDebugMode()) && (localILogger != null)) {
      localILogger.i(paramString1, paramString2);
    }
  }
  
  public static void v(String paramString1, String paramString2)
  {
    ILogger localILogger = getLogger();
    if ((VideoReportInner.getInstance().isDebugMode()) && (localILogger != null)) {
      localILogger.v(paramString1, paramString2);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    ILogger localILogger = getLogger();
    if ((VideoReportInner.getInstance().isDebugMode()) && (localILogger != null)) {
      localILogger.w(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.Log
 * JD-Core Version:    0.7.0.1
 */