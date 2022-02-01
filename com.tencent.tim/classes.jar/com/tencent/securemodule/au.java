package com.tencent.securemodule;

import alkz;
import alla;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;

public final class au
{
  public static String a()
  {
    return Build.MODEL;
  }
  
  public static String a(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    try
    {
      paramContext = alla.a(paramContext);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "0000000000";
  }
  
  public static String b()
  {
    return Build.PRODUCT;
  }
  
  public static String b(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    try
    {
      paramContext = alla.e(paramContext);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "0000000000";
  }
  
  public static int c()
  {
    return Integer.parseInt(Build.VERSION.SDK);
  }
  
  public static String c(Context paramContext)
  {
    try
    {
      paramContext = alkz.a((WifiManager)paramContext.getSystemService("wifi"));
      if (paramContext != null)
      {
        paramContext = alkz.c(paramContext);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      return null;
    }
    return null;
  }
  
  public static String d()
  {
    return "android_id";
  }
  
  public static String d(Context paramContext)
  {
    try
    {
      paramContext = alla.d((TelephonyManager)paramContext.getSystemService("phone"));
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.securemodule.au
 * JD-Core Version:    0.7.0.1
 */