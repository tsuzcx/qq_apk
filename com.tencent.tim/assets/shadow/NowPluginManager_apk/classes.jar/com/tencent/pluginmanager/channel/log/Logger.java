package com.tencent.pluginmanager.channel.log;

import android.util.Log;

public class Logger
{
  private static Logger sLogger = new Logger();
  private ILogger mLogger;
  
  public static void d(String paramString1, String paramString2)
  {
    if (sLogger.mLogger != null)
    {
      sLogger.mLogger.print(3, paramString1, paramString2);
      return;
    }
    Log.d(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (sLogger.mLogger != null)
    {
      sLogger.mLogger.print(6, paramString1, paramString2);
      return;
    }
    Log.e(paramString1, paramString2);
  }
  
  public static Logger getInstance()
  {
    return sLogger;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (sLogger.mLogger != null)
    {
      sLogger.mLogger.print(4, paramString1, paramString2);
      return;
    }
    Log.i(paramString1, paramString2);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (sLogger.mLogger != null)
    {
      sLogger.mLogger.print(2, paramString1, paramString2);
      return;
    }
    Log.v(paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (sLogger.mLogger != null)
    {
      sLogger.mLogger.print(5, paramString1, paramString2);
      return;
    }
    Log.w(paramString1, paramString2);
  }
  
  public void setLogger(ILogger paramILogger)
  {
    this.mLogger = paramILogger;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.pluginmanager.channel.log.Logger
 * JD-Core Version:    0.7.0.1
 */