package com.tencent.qq.effect.utils;

import android.util.Log;

public class LogUtil
{
  private static boolean SHOW_ERR_WNR_LOG = true;
  private static boolean SHOW_INFO_DEBUG_LOG = true;
  private static final String TAG = "QEffectLog";
  
  private static boolean canLogDebug()
  {
    return Log.isLoggable("QEffectLog", 3);
  }
  
  private static boolean canLogError()
  {
    return Log.isLoggable("QEffectLog", 6);
  }
  
  private static boolean canLogInfo()
  {
    return Log.isLoggable("QEffectLog", 4);
  }
  
  private static boolean canLogVerbose()
  {
    return Log.isLoggable("QEffectLog", 2);
  }
  
  private static boolean canLogWarn()
  {
    return Log.isLoggable("QEffectLog", 5);
  }
  
  public static void closeLog()
  {
    SHOW_INFO_DEBUG_LOG = false;
    SHOW_ERR_WNR_LOG = false;
  }
  
  public static void d(String paramString)
  {
    if ((SHOW_INFO_DEBUG_LOG) && (canLogDebug())) {
      Log.d("QEffectLog", paramString);
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if ((SHOW_INFO_DEBUG_LOG) && (canLogDebug())) {
      Log.d(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString)
  {
    if ((SHOW_ERR_WNR_LOG) && (canLogError())) {
      Log.e("QEffectLog", paramString);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if ((SHOW_ERR_WNR_LOG) && (canLogError())) {
      Log.e(paramString1, paramString2);
    }
  }
  
  public static void enableInfoLog(boolean paramBoolean)
  {
    SHOW_INFO_DEBUG_LOG = paramBoolean;
  }
  
  public static void i(String paramString)
  {
    if ((SHOW_INFO_DEBUG_LOG) && (canLogInfo())) {
      Log.i("QEffectLog", paramString);
    }
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if ((SHOW_INFO_DEBUG_LOG) && (canLogInfo())) {
      Log.i(paramString1, paramString2);
    }
  }
  
  public static void v(String paramString)
  {
    if ((SHOW_INFO_DEBUG_LOG) && (canLogVerbose())) {
      Log.v("QEffectLog", paramString);
    }
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if ((SHOW_INFO_DEBUG_LOG) && (canLogVerbose())) {
      Log.v(paramString1, paramString2);
    }
  }
  
  public static void w(Exception paramException)
  {
    if (SHOW_ERR_WNR_LOG) {
      paramException.printStackTrace();
    }
  }
  
  public static void w(String paramString)
  {
    if ((SHOW_ERR_WNR_LOG) && (canLogWarn())) {
      Log.w("QEffectLog", paramString);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if ((SHOW_ERR_WNR_LOG) && (canLogWarn())) {
      Log.w(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qq.effect.utils.LogUtil
 * JD-Core Version:    0.7.0.1
 */