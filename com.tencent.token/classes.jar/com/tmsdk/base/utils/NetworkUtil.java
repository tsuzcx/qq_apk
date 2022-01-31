package com.tmsdk.base.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import btmsdkobf.bc;
import btmsdkobf.eg;
import btmsdkobf.ei;
import tmsdk.QQPIM.ConnectType;

public class NetworkUtil
{
  public static NetworkInfo getActiveNetworkInfo()
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)bc.n().getSystemService("connectivity")).getActiveNetworkInfo();
      return localNetworkInfo;
    }
    catch (Throwable localThrowable)
    {
      eg.h("NetworkUtil", localThrowable.toString());
    }
    return null;
  }
  
  public static int getNetType()
  {
    Context localContext = bc.n();
    if (!ei.ol)
    {
      ei.ol = false;
      ei.n(localContext);
    }
    switch (ei.op)
    {
    case 17: 
    default: 
      return 0;
    case 1: 
      return 1;
    case 2: 
      return 2;
    case 3: 
      return 3;
    case 4: 
      return 4;
    case 5: 
      return 5;
    case 6: 
      return 6;
    case 7: 
      return 7;
    case 8: 
      return 8;
    case 9: 
      return 9;
    case 10: 
      return 10;
    case 11: 
      return 11;
    case 12: 
      return 12;
    case 13: 
      return 13;
    case 14: 
      return 14;
    case 15: 
      return 15;
    }
    return 16;
  }
  
  public static ConnectType getNetworkType()
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)bc.n().getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo == null) {
        return ConnectType.CT_NONE;
      }
    }
    catch (Throwable localThrowable)
    {
      String str;
      for (;;)
      {
        eg.g("getActiveNetworkInfo", localThrowable.getMessage());
        str = null;
      }
      if (str.getType() == 1) {
        return ConnectType.CT_WIFI;
      }
      if (str.getType() == 0)
      {
        str = getProxyHost();
        if ((str != null) && (str.length() > 0) && (getProxyPort() > 0)) {
          return ConnectType.CT_GPRS_WAP;
        }
        return ConnectType.CT_GPRS_NET;
      }
    }
    return ConnectType.CT_GPRS_NET;
  }
  
  public static String getProxyHost()
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return System.getProperty("http.proxyHost");
    }
    return Proxy.getHost(bc.n());
  }
  
  public static int getProxyPort()
  {
    if (Build.VERSION.SDK_INT >= 14) {
      try
      {
        int i = Integer.parseInt(System.getProperty("http.proxyPort"));
        return i;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        return -1;
      }
    }
    return Proxy.getPort(bc.n());
  }
  
  public static String getSSID()
  {
    try
    {
      Object localObject = (WifiManager)bc.n().getSystemService("wifi");
      if (localObject != null)
      {
        localObject = ((WifiManager)localObject).getConnectionInfo();
        if (localObject != null)
        {
          localObject = ((WifiInfo)localObject).getSSID();
          return localObject;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      eg.h("WifiUtil", "getSSID: " + localThrowable);
    }
    return "";
  }
  
  public static boolean is2GNetWork()
  {
    Object localObject = null;
    try
    {
      NetworkInfo localNetworkInfo = getActiveNetworkInfo();
      localObject = localNetworkInfo;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        eg.g("getActiveNetworkInfo", " getActiveNetworkInfo NullPointerException--- \n" + localThrowable.getMessage());
      }
    }
    return (localObject != null) && (localObject.getType() == 0) && ((localObject.getSubtype() == 1) || (localObject.getSubtype() == 4) || (localObject.getSubtype() == 2));
  }
  
  public static boolean isNetworkConnected()
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)bc.n().getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo == null) {
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      for (;;)
      {
        eg.h("NetworkUtil", localThrowable.toString());
        localObject = null;
      }
      return localObject.isConnected();
    }
  }
  
  public static boolean isWifiConnected()
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)bc.n().getSystemService("connectivity")).getNetworkInfo(1);
      if (localNetworkInfo == null) {
        return false;
      }
      boolean bool = localNetworkInfo.isConnected();
      if (bool) {
        return true;
      }
    }
    catch (Exception localException)
    {
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.base.utils.NetworkUtil
 * JD-Core Version:    0.7.0.1
 */