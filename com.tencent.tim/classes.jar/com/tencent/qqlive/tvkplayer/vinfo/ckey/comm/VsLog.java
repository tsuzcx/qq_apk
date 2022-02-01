package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

import android.util.Log;

public class VsLog
{
  public static final String LOG_TAG = "[ckey_sdk]";
  public static boolean logIf = false;
  
  private static boolean checkLog()
  {
    return logIf;
  }
  
  public static void debug(String paramString, Object... paramVarArgs)
  {
    if (checkLog()) {
      Log.d("[ckey_sdk]", String.format(paramString, paramVarArgs));
    }
  }
  
  public static void error(String paramString, Object... paramVarArgs)
  {
    Log.e("[ckey_sdk]", String.format(paramString, paramVarArgs));
  }
  
  public static void info(String paramString, Object... paramVarArgs)
  {
    if (checkLog()) {
      Log.i("[ckey_sdk]", String.format(paramString, paramVarArgs));
    }
  }
  
  public static void printStackTrace(Throwable paramThrowable)
  {
    if ((paramThrowable != null) && ((paramThrowable instanceof Throwable)))
    {
      if (checkLog()) {
        paramThrowable.printStackTrace();
      }
    }
    else {
      return;
    }
    error(paramThrowable.getMessage(), new Object[0]);
  }
  
  public static void warn(String paramString, Object... paramVarArgs)
  {
    if (checkLog()) {
      Log.w("[ckey_sdk]", String.format(paramString, paramVarArgs));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsLog
 * JD-Core Version:    0.7.0.1
 */