package com.tencent.tpns.mqttchannel.core.common.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.mqttchannel.api.MqttConfig;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b
{
  public static int a = 0;
  
  public static String a(Context paramContext, String paramString)
  {
    return "/_xg/rpc/recv/" + MqttConfig.getAccessId(paramContext) + "/" + paramString;
  }
  
  public static boolean a()
  {
    boolean bool = false;
    try
    {
      Process localProcess = Runtime.getRuntime().exec("ping -c 1 -w 10 www.qq.com");
      int i = localProcess.waitFor();
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localProcess.getInputStream()));
      while (localBufferedReader.readLine() != null) {}
      localBufferedReader.close();
      localProcess.destroy();
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    bool1 = true;
    try
    {
      if (!Util.checkPermission(paramContext, "android.permission.ACCESS_NETWORK_STATE")) {
        return true;
      }
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        if (paramContext.getActiveNetworkInfo() != null)
        {
          boolean bool2 = paramContext.getActiveNetworkInfo().isConnected();
          if (!bool2) {}
        }
        for (bool1 = true;; bool1 = false) {
          return bool1;
        }
      }
      return bool1;
    }
    catch (Throwable paramContext)
    {
      if (!a())
      {
        a.a("com.tencent.tpns.mqttchannel.core.common.util", "APNUtil -> checkNetWork", paramContext);
        a += 1;
        if (a >= 5)
        {
          a = 0;
          return true;
        }
        bool1 = false;
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.trim().length() == 0);
  }
  
  public static String b(Context paramContext, String paramString)
  {
    return "/_xg/push/" + MqttConfig.getAccessId(paramContext) + "/" + paramString;
  }
  
  public static String c(Context paramContext, String paramString)
  {
    return "/_xg/rpc/recv/aes/" + MqttConfig.getAccessId(paramContext) + "/" + paramString;
  }
  
  public static String d(Context paramContext, String paramString)
  {
    return "/_xg/push/aes/" + MqttConfig.getAccessId(paramContext) + "/" + paramString;
  }
  
  public static String e(Context paramContext, String paramString)
  {
    return "/_xg/rpc/recv/gzip/" + MqttConfig.getAccessId(paramContext) + "/" + paramString;
  }
  
  public static String f(Context paramContext, String paramString)
  {
    return "/_xg/push/gzip/" + MqttConfig.getAccessId(paramContext) + "/" + paramString;
  }
  
  public static String g(Context paramContext, String paramString)
  {
    return "/_xg/rpc/recv/gzip_aes/" + MqttConfig.getAccessId(paramContext) + "/" + paramString;
  }
  
  public static String h(Context paramContext, String paramString)
  {
    return "/_xg/push/gzip_aes/" + MqttConfig.getAccessId(paramContext) + "/" + paramString;
  }
  
  public static boolean i(Context paramContext, String paramString)
  {
    return paramString.startsWith("/_xg/rpc/recv/" + MqttConfig.getAccessId(paramContext) + "/");
  }
  
  public static boolean j(Context paramContext, String paramString)
  {
    return paramString.startsWith("/_xg/push/" + MqttConfig.getAccessId(paramContext) + "/");
  }
  
  public static boolean k(Context paramContext, String paramString)
  {
    return paramString.startsWith("/_xg/rpc/recv/aes/" + MqttConfig.getAccessId(paramContext) + "/");
  }
  
  public static boolean l(Context paramContext, String paramString)
  {
    return paramString.startsWith("/_xg/push/aes/" + MqttConfig.getAccessId(paramContext) + "/");
  }
  
  public static boolean m(Context paramContext, String paramString)
  {
    return paramString.startsWith("/_xg/rpc/recv/gzip/" + MqttConfig.getAccessId(paramContext) + "/");
  }
  
  public static boolean n(Context paramContext, String paramString)
  {
    return paramString.startsWith("/_xg/push/gzip/" + MqttConfig.getAccessId(paramContext) + "/");
  }
  
  public static boolean o(Context paramContext, String paramString)
  {
    return paramString.startsWith("/_xg/rpc/recv/gzip_aes/" + MqttConfig.getAccessId(paramContext) + "/");
  }
  
  public static boolean p(Context paramContext, String paramString)
  {
    return paramString.startsWith("/_xg/push/gzip_aes/" + MqttConfig.getAccessId(paramContext) + "/");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.core.common.c.b
 * JD-Core Version:    0.7.0.1
 */