package com.tencent.android.tpush.service.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.Util;

public class SharePrefsUtil
{
  public static final String SHAREPRE_WATCH_PORT = "tpush_watchdog_port";
  static int a = 100;
  private static SharedPreferences b = null;
  
  private static SharedPreferences a(Context paramContext)
  {
    if (b == null) {
      b = paramContext.getSharedPreferences("tpush.vip.shareprefs", 0);
    }
    return b;
  }
  
  private static String a(String paramString)
  {
    return Util.getKey(paramString);
  }
  
  public static boolean getBoolean(Context paramContext, String paramString, boolean paramBoolean)
  {
    a(paramContext);
    try
    {
      boolean bool = b.getBoolean(a(paramString), paramBoolean);
      return bool;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("SharePrefsUtil", "getBoolean", paramContext);
    }
    return paramBoolean;
  }
  
  public static int getInt(Context paramContext, String paramString, int paramInt)
  {
    a(paramContext);
    return b.getInt(a(paramString), paramInt);
  }
  
  public static long getLong(Context paramContext, String paramString, long paramLong)
  {
    a(paramContext);
    return b.getLong(a(paramString), paramLong);
  }
  
  public static int getSeqId(Context paramContext)
  {
    a += 1;
    if (a == 2147483647) {
      a = 1;
    }
    TLogger.i("SharePrefsUtil", "seqId = " + a);
    return a;
  }
  
  public static String getString(Context paramContext, String paramString1, String paramString2)
  {
    a(paramContext);
    return b.getString(a(paramString1), paramString2);
  }
  
  public static void setBoolean(Context paramContext, String paramString, boolean paramBoolean)
  {
    try
    {
      paramContext = a(paramContext).edit();
      paramContext.putBoolean(a(paramString), paramBoolean);
      paramContext.commit();
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("SharePrefsUtil", "", paramContext);
    }
  }
  
  public static void setInt(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      paramContext = a(paramContext).edit();
      paramContext.putInt(a(paramString), paramInt);
      paramContext.commit();
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("SharePrefsUtil", "", paramContext);
    }
  }
  
  public static void setLong(Context paramContext, String paramString, long paramLong)
  {
    try
    {
      paramContext = a(paramContext).edit();
      paramContext.putLong(a(paramString), paramLong);
      paramContext.commit();
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("SharePrefsUtil", "", paramContext);
    }
  }
  
  public static void setString(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = a(paramContext).edit();
      paramContext.putString(a(paramString1), paramString2);
      paramContext.commit();
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("SharePrefsUtil", "", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.util.SharePrefsUtil
 * JD-Core Version:    0.7.0.1
 */