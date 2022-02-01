package com.tencent.qqmail.utilities.log;

import android.util.Log;

public class Logger
{
  public static final ILogger DEFAULT_LOGGER = new DefaultLogger();
  private static final String TAG = "CrashCatcher";
  private static ILogger sLogger = DEFAULT_LOGGER;
  private static int sPriority = 2;
  
  public static void log(int paramInt, String paramString1, String paramString2)
  {
    log(paramInt, paramString1, paramString2, null);
  }
  
  public static void log(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((sLogger == null) || (paramInt < sPriority)) {
      return;
    }
    try
    {
      sLogger.log(paramInt, paramString1, paramString2, paramThrowable);
      return;
    }
    catch (Throwable paramString1)
    {
      DEFAULT_LOGGER.log(6, "CrashCatcher", "logger error!!", paramString1);
    }
  }
  
  public static void setLogger(ILogger paramILogger)
  {
    sLogger = paramILogger;
  }
  
  public static void setPriority(int paramInt)
  {
    sPriority = paramInt;
  }
  
  public static class DefaultLogger
    implements ILogger
  {
    public void log(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
    {
      Log.println(paramInt, paramString1, paramString2 + '\n' + Log.getStackTraceString(paramThrowable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.Logger
 * JD-Core Version:    0.7.0.1
 */