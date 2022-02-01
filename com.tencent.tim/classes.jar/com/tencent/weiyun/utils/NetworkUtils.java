package com.tencent.weiyun.utils;

import alkz;
import android.content.Context;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

public class NetworkUtils
{
  public static final int NETWORK_TYPE_2G = 1;
  public static final int NETWORK_TYPE_3G = 2;
  public static final int NETWORK_TYPE_UNKNOWN = 0;
  public static final int NETWORK_TYPE_WIFI = 3;
  private static final String TAG = "NetworkUtils";
  private static INetworkInfoProvider sNetworkInfoProvider;
  
  public static String convert2IP(int paramInt)
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    StringBuffer localStringBuffer2 = localStringBuffer1.append(paramInt & 0xFF).append('.');
    paramInt >>>= 8;
    localStringBuffer2 = localStringBuffer2.append(paramInt & 0xFF).append('.');
    paramInt >>>= 8;
    localStringBuffer2.append(paramInt & 0xFF).append('.').append(paramInt >>> 8 & 0xFF);
    return localStringBuffer1.toString();
  }
  
  private static int convertNetworkType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 3;
    case 2: 
      return 1;
    }
    return 2;
  }
  
  public static NetworkInfo getActiveNetworkInfo(Context paramContext)
  {
    if (sNetworkInfoProvider == null) {
      return null;
    }
    return sNetworkInfoProvider.getNetworkInfo(paramContext);
  }
  
  public static String getDnsInfo(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getDhcpInfo();
    if (paramContext == null) {
      return "none";
    }
    return convert2IP(paramContext.dns1) + ';' + convert2IP(paramContext.dns2);
  }
  
  public static int getNetworkType(Context paramContext)
  {
    paramContext = getActiveNetworkInfo(paramContext);
    if ((paramContext == null) || (!paramContext.isConnected())) {
      return 0;
    }
    return convertNetworkType(getNetworkType(paramContext));
  }
  
  private static int getNetworkType(NetworkInfo paramNetworkInfo)
  {
    switch (paramNetworkInfo.getType())
    {
    default: 
      return 0;
    case 1: 
      return 1;
    }
    switch (paramNetworkInfo.getSubtype())
    {
    case 0: 
    default: 
      return 0;
    case 1: 
    case 2: 
    case 4: 
    case 7: 
    case 11: 
      return 2;
    case 3: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    case 14: 
    case 15: 
      return 3;
    }
    return 4;
  }
  
  public static int getNetworkTypeDiff4G(Context paramContext)
  {
    paramContext = getActiveNetworkInfo(paramContext);
    if ((paramContext == null) || (!paramContext.isConnected())) {
      return 0;
    }
    return getNetworkType(paramContext);
  }
  
  public static String getWifiBSSID(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return null;
      paramContext = getWifiInfo(paramContext);
    } while (paramContext == null);
    return paramContext.getBSSID();
  }
  
  public static WifiInfo getWifiInfo(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = (WifiManager)paramContext.getSystemService("wifi");
    if (paramContext == null) {}
    for (paramContext = null;; paramContext = alkz.a(paramContext)) {
      return paramContext;
    }
  }
  
  public static String getWifiMacAddress(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = getWifiInfo(paramContext);
    if (paramContext != null)
    {
      paramContext = alkz.c(paramContext);
      if (paramContext != null) {
        return paramContext.toLowerCase().replaceAll(":", "-");
      }
      Log.w("NetworkUtils", "mac address is null!");
      return null;
    }
    Log.w("NetworkUtils", "can *NOT* get connect info when get mac address!");
    return null;
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    paramContext = getActiveNetworkInfo(paramContext);
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  public static boolean isWifiAvailable(Context paramContext)
  {
    paramContext = getActiveNetworkInfo(paramContext);
    return (paramContext != null) && (paramContext.isConnected()) && (paramContext.getType() == 1);
  }
  
  public static void setNetworkInfoProvider(INetworkInfoProvider paramINetworkInfoProvider)
  {
    if ((sNetworkInfoProvider == null) && (paramINetworkInfoProvider != null)) {
      sNetworkInfoProvider = paramINetworkInfoProvider;
    }
  }
  
  public static abstract interface INetworkInfoProvider
  {
    public abstract NetworkInfo getNetworkInfo(Context paramContext);
  }
  
  public static final class IspType
  {
    public static final int ISP_TYPE_CMCC = 1;
    public static final int ISP_TYPE_CMCT = 3;
    public static final int ISP_TYPE_UNICOM = 2;
    public static final int ISP_TYPE_UNKNOWN = 0;
    public static final int ISP_TYPE_WIFI = 4;
  }
  
  public static final class NetworkType
  {
    public static final int MOBILE_2G = 2;
    public static final int MOBILE_3G = 3;
    public static final int MOBILE_4G = 4;
    public static final int NONE = 0;
    public static final int WIFI = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weiyun.utils.NetworkUtils
 * JD-Core Version:    0.7.0.1
 */