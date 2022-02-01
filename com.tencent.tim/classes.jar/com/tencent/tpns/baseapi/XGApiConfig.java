package com.tencent.tpns.baseapi;

import android.content.Context;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.baseapi.core.a;

public class XGApiConfig
{
  private static String a = "";
  
  public static void clearRegistered(Context paramContext)
  {
    a.n(paramContext);
  }
  
  public static long getAccessId(Context paramContext)
  {
    return a.a(paramContext);
  }
  
  public static String getAccessKey(Context paramContext)
  {
    return a.b(paramContext);
  }
  
  public static String getCustomEvenServerAddr(Context paramContext)
  {
    return a.g(paramContext);
  }
  
  public static String getDebugMQTTServer(Context paramContext)
  {
    if (Util.isNullOrEmptyString(a)) {
      a = PushPreferences.getString(paramContext, "debug_server", "");
    }
    return a;
  }
  
  public static String getErrCodeServerAddr(Context paramContext)
  {
    return a.f(paramContext);
  }
  
  public static long getFreeVersionAccessId(Context paramContext)
  {
    return a.k(paramContext);
  }
  
  public static String getOfflineMsgServerAddr(Context paramContext)
  {
    return a.i(paramContext);
  }
  
  public static String getServerSuffix(Context paramContext)
  {
    return a.c(paramContext);
  }
  
  public static String getStatServerAddr(Context paramContext)
  {
    return a.e(paramContext);
  }
  
  public static boolean isEnableService(Context paramContext)
  {
    return a.l(paramContext);
  }
  
  public static boolean isPowerSaveMode(Context paramContext)
  {
    return a.j(paramContext);
  }
  
  public static boolean isRegistered(Context paramContext)
  {
    return a.o(paramContext);
  }
  
  public static void setAccessId(Context paramContext, long paramLong)
  {
    a.a(paramContext, paramLong);
  }
  
  public static void setAccessKey(Context paramContext, String paramString)
  {
    a.a(paramContext, paramString);
  }
  
  public static void setCustomEvenServerAddr(Context paramContext, String paramString)
  {
    a.f(paramContext, paramString);
  }
  
  public static void setDebugMQTTServer(Context paramContext, String paramString)
  {
    if (Util.isNullOrEmptyString(paramString)) {}
    while (a.equals(paramString)) {
      return;
    }
    a = paramString;
    PushPreferences.putString(paramContext, "debug_server", a);
  }
  
  public static void setErrCodeServerAddr(Context paramContext, String paramString)
  {
    a.e(paramContext, paramString);
  }
  
  public static void setGuidServerAddr(Context paramContext, String paramString)
  {
    a.c(paramContext, paramString);
  }
  
  public static void setGuidServerAddrWithoutRefreshingTime(Context paramContext, String paramString)
  {
    a.g(paramContext, paramString);
  }
  
  public static void setPowerSaveMode(Context paramContext, boolean paramBoolean)
  {
    a.a(paramContext, paramBoolean);
  }
  
  public static void setRegisterSuccess(Context paramContext)
  {
    a.m(paramContext);
  }
  
  public static void setServerSuffix(Context paramContext, String paramString)
  {
    a.b(paramContext, paramString);
  }
  
  public static void setStatServerAddr(Context paramContext, String paramString)
  {
    a.d(paramContext, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.XGApiConfig
 * JD-Core Version:    0.7.0.1
 */