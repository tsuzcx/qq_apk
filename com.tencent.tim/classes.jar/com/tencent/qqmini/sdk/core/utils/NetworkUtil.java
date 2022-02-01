package com.tencent.qqmini.sdk.core.utils;

import alkz;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

public class NetworkUtil
{
  public static final String TAG = "NetworkUtil";
  
  public static int getActiveNetworkType(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable())) {
        switch (localNetworkInfo.getType())
        {
        case 0: 
        case 2: 
        case 3: 
        case 4: 
        case 5: 
          i = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType();
          switch (i)
          {
          case 4: 
          case 7: 
          case 11: 
          default: 
            i = 2;
            break;
          case 13: 
            i = 4;
            break;
          case 3: 
          case 5: 
          case 6: 
          case 8: 
          case 9: 
          case 10: 
          case 12: 
          case 14: 
          case 15: 
            i = 3;
          }
          break;
        }
      }
    }
    catch (Throwable paramContext)
    {
      QMLog.e("NetworkUtil", "fail to get active network info", paramContext);
      i = 0;
    }
    int i = 0;
    for (;;)
    {
      return i;
      i = 5;
      continue;
      i = 1;
    }
  }
  
  public static String getCurrentWifiSSID(Context paramContext)
  {
    try
    {
      paramContext = alkz.a((WifiManager)paramContext.getSystemService("wifi"));
      if ((paramContext != null) && (paramContext.getSSID() != null))
      {
        paramContext = paramContext.getSSID().replaceAll("\"", "");
        boolean bool = paramContext.equals("<unknown ssid>");
        if (!bool) {
          return paramContext;
        }
        return null;
      }
    }
    catch (Throwable paramContext)
    {
      QMLog.e("NetworkUtil", "fail to get active network info", paramContext);
      return null;
    }
    paramContext = null;
    return paramContext;
  }
  
  public static String getNetWorkTypeByStr(Context paramContext)
  {
    switch (getActiveNetworkType(paramContext))
    {
    default: 
      return null;
    case -1: 
      return "UNKNOWN";
    case 0: 
      return "NONE";
    case 1: 
      return "WIFI";
    case 2: 
      return "2G";
    case 3: 
      return "3G";
    case 4: 
      return "4G";
    }
    return "CABLE";
  }
  
  public static class NetType
  {
    public static final int CABLE = 5;
    public static final int G2 = 2;
    public static final int G3 = 3;
    public static final int G4 = 4;
    public static final int NONE = 0;
    public static final int WIFI = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.NetworkUtil
 * JD-Core Version:    0.7.0.1
 */