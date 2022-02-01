package com.tencent.qqlive.tvkplayer.tools.utils;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.qqlive.tvkplayer.TVideoMgr.OnTVideoLogListener;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigField;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig.PlayerConfig;
import java.util.MissingFormatArgumentException;

public class TVKLogUtil
{
  public static final int DEBUG = 50;
  public static final int ERROR = 10;
  public static final int INFO = 40;
  public static final String TAG = "MediaPlayerMgr";
  public static final int VERBOSE = 60;
  public static final int WARNING = 20;
  private static boolean isDebug = false;
  private static TVideoMgr.OnTVideoLogListener onTVideoLogListener = null;
  
  public static void d(String paramString1, String paramString2)
  {
    printTag(50, paramString1, paramString2, new Object[0]);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    printTag(10, paramString1, paramString2, new Object[0]);
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    e(paramString, paramThrowable, "");
  }
  
  public static void e(String paramString1, Throwable paramThrowable, String paramString2)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramString2)) {
      str = paramString2 + "\n";
    }
    paramString2 = str;
    if (paramThrowable != null) {
      paramString2 = str + Log.getStackTraceString(paramThrowable);
    }
    printTag(10, paramString1, paramString2, new Object[0]);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    printTag(40, paramString1, paramString2, new Object[0]);
  }
  
  private static void logToLogListener(int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 60: 
      onTVideoLogListener.v(paramString1, paramString2);
      return;
    case 50: 
      onTVideoLogListener.d(paramString1, paramString2);
      return;
    case 40: 
      onTVideoLogListener.i(paramString1, paramString2);
      return;
    case 20: 
      onTVideoLogListener.w(paramString1, paramString2);
      return;
    }
    onTVideoLogListener.e(paramString1, paramString2);
  }
  
  private static void printTag(int paramInt, String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((paramInt == 60) || (paramInt == 50)) {}
    for (;;)
    {
      return;
      int i = paramInt;
      if (paramInt == 20) {
        i = 10;
      }
      String str = paramString2;
      if (paramVarArgs != null) {}
      try
      {
        if (paramVarArgs.length == 0)
        {
          str = paramString2;
          if (onTVideoLogListener == null) {
            break label89;
          }
          if (i > ((Integer)TVKMediaPlayerConfig.PlayerConfig.log_print_level.getValue()).intValue()) {
            continue;
          }
          logToLogListener(i, paramString1, str);
        }
      }
      catch (MissingFormatArgumentException paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
          return;
          str = String.format(paramString2, paramVarArgs);
        }
        if ((isDebug) && (i <= ((Integer)TVKMediaPlayerConfig.PlayerConfig.log_print_level.getValue()).intValue()))
        {
          Log.println(toSysLevel(i), paramString1, str);
          return;
        }
      }
      catch (Exception paramString1)
      {
        label89:
        paramString1.printStackTrace();
        return;
      }
      catch (OutOfMemoryError paramString1) {}
    }
  }
  
  public static void setDebugEnable(boolean paramBoolean)
  {
    isDebug = paramBoolean;
  }
  
  public static void setOnTVideoLogListener(TVideoMgr.OnTVideoLogListener paramOnTVideoLogListener)
  {
    onTVideoLogListener = paramOnTVideoLogListener;
  }
  
  private static int toSysLevel(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 60: 
      return 2;
    case 50: 
      return 3;
    case 40: 
      return 4;
    case 20: 
      return 5;
    }
    return 6;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    printTag(60, paramString1, paramString2, new Object[0]);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    printTag(20, paramString1, paramString2, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil
 * JD-Core Version:    0.7.0.1
 */