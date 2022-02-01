package com.tencent.token;

import android.content.Context;
import android.content.res.Resources;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;

public final class atn
{
  private static String a = "tms_";
  private static String b = "[com.android.internal.telephony.ITelephony]";
  private static String c = "[com.android.internal.telephony.ITelephonyRegistry]";
  private static Boolean d;
  
  public static String a()
  {
    return "android_id";
  }
  
  public static String a(Context paramContext)
  {
    return ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
  }
  
  public static String b()
  {
    return Build.MODEL;
  }
  
  public static String b(Context paramContext)
  {
    paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
    if (paramContext == null) {
      return "000000000000000";
    }
    return paramContext;
  }
  
  public static String c(Context paramContext)
  {
    paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
    if (paramContext != null) {
      return paramContext.getMacAddress();
    }
    return null;
  }
  
  public static int d(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static int e(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  public static int f(Context paramContext)
  {
    paramContext = b(paramContext);
    if (paramContext != null) {
      if ((!paramContext.startsWith("46000")) && (!paramContext.startsWith("46002")) && (!paramContext.startsWith("46007")))
      {
        if (paramContext.startsWith("46001")) {
          return 1;
        }
        if (paramContext.startsWith("46003")) {
          return 2;
        }
      }
      else
      {
        return 0;
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.atn
 * JD-Core Version:    0.7.0.1
 */