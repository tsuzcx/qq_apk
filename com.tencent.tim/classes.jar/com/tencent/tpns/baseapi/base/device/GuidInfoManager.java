package com.tencent.tpns.baseapi.base.device;

import android.content.Context;
import com.tencent.tpns.baseapi.core.a.a;

public class GuidInfoManager
{
  public static void clearGuidInfo(Context paramContext)
  {
    a.o(paramContext);
  }
  
  public static void forceExpired(Context paramContext)
  {
    a.n(paramContext);
  }
  
  public static int getEncryptLevel(Context paramContext)
  {
    return a.r(paramContext);
  }
  
  public static long getExpiredSeconds(Context paramContext)
  {
    return a.i(paramContext);
  }
  
  public static long getGuid(Context paramContext)
  {
    return a.c(paramContext);
  }
  
  public static long getLastRefreshTime(Context paramContext)
  {
    return a.j(paramContext);
  }
  
  public static String getLastResolvedGuidServerIP(Context paramContext)
  {
    try
    {
      paramContext = a.e(paramContext);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static String getMqttPassword(Context paramContext)
  {
    return a.h(paramContext);
  }
  
  public static String getMqttServer(Context paramContext)
  {
    return a.d(paramContext);
  }
  
  public static String getMqttServerIP(Context paramContext)
  {
    try
    {
      paramContext = a.f(paramContext);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static long getMqttServerRefreshTime(Context paramContext)
  {
    try
    {
      long l = a.l(paramContext);
      return l;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static String getMqttUserName(Context paramContext)
  {
    return a.g(paramContext);
  }
  
  public static int getRefuseRate(Context paramContext)
  {
    return a.q(paramContext);
  }
  
  public static String getToken(Context paramContext)
  {
    return a.a(paramContext);
  }
  
  public static String getTokenList(Context paramContext)
  {
    return a.b(paramContext);
  }
  
  public static boolean isExpired(Context paramContext)
  {
    return a.k(paramContext);
  }
  
  public static boolean isMqttServerExpired(Context paramContext)
  {
    return a.m(paramContext);
  }
  
  public static boolean isServerDestroy(Context paramContext)
  {
    return a.p(paramContext);
  }
  
  public static GUIDInfo refreshConnectInfoSynchronized(Context paramContext, int paramInt, RefreshCallback paramRefreshCallback)
  {
    try
    {
      paramContext = a.a(paramContext, paramInt);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void setLastResolvedGuidServerIP(Context paramContext, String paramString)
  {
    try
    {
      a.a(paramContext, paramString);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void setMqttServerIP(Context paramContext, String paramString)
  {
    try
    {
      a.b(paramContext, paramString);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void setMqttServerRefreshTime(Context paramContext, long paramLong)
  {
    try
    {
      a.a(paramContext, paramLong);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void wrtieDebugInfo(Context paramContext, String paramString1, String paramString2)
  {
    a.a(paramContext, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.base.device.GuidInfoManager
 * JD-Core Version:    0.7.0.1
 */