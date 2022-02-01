package com.tencent.token;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public final class kt
{
  public static String a = "";
  public static String b = "";
  public static String c = "";
  
  public static int a(Context paramContext)
  {
    if (paramContext == null) {
      return -1;
    }
    try
    {
      int i = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("level", 0);
      return i;
    }
    catch (Exception paramContext) {}
    return -1;
  }
  
  private static int a(Context paramContext, float paramFloat)
  {
    try
    {
      if (paramContext.getResources().getDisplayMetrics().widthPixels < paramContext.getResources().getDisplayMetrics().heightPixels) {
        i = paramContext.getResources().getDisplayMetrics().widthPixels;
      } else {
        i = paramContext.getResources().getDisplayMetrics().heightPixels;
      }
      int j = (int)(i * 0.9F);
      int k = (int)(paramFloat * 400.0F);
      i = j;
      if (j <= k) {
        break label79;
      }
      return k;
    }
    catch (Exception paramContext)
    {
      int i;
      label73:
      label79:
      break label73;
    }
    i = (int)(paramFloat * 300.0F);
    return i;
  }
  
  public static int a(Context paramContext, Window paramWindow, RelativeLayout paramRelativeLayout1, RelativeLayout paramRelativeLayout2, ks paramks)
  {
    float f = paramContext.getResources().getDisplayMetrics().density;
    int i = a(paramContext, f);
    paramWindow.setBackgroundDrawable(new ColorDrawable(0));
    paramks.setVisibility(4);
    paramContext = new RelativeLayout.LayoutParams(-1, -1);
    paramContext.addRule(13);
    paramRelativeLayout1.addView(paramks, paramContext);
    paramContext = paramRelativeLayout2.getLayoutParams();
    int j = (int)(140.0F * f);
    paramContext.width = j;
    paramContext.height = j;
    paramRelativeLayout2.setLayoutParams(paramContext);
    j = (int)(52.0F * f);
    new RelativeLayout.LayoutParams(j, j).addRule(13);
    paramContext = paramWindow.getAttributes();
    paramContext.width = i;
    paramContext.height = i;
    paramWindow.setAttributes(paramContext);
    paramks.a = (f * 3.0F);
    paramks.b = i;
    paramks.c = i;
    return 140;
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramInt == 0)
      {
        if (localTelephonyManager != null)
        {
          paramContext = new StringBuilder();
          paramContext.append(localTelephonyManager.getNetworkType());
          return paramContext.toString();
        }
      }
      else
      {
        if (paramInt == 1)
        {
          if (localTelephonyManager == null) {
            break label201;
          }
          return localTelephonyManager.getNetworkOperatorName();
        }
        if (paramInt == 2)
        {
          paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
          if (paramContext == null) {
            return "";
          }
        }
        switch (paramContext.getType())
        {
        case 0: 
          switch (paramContext.getSubtype())
          {
          case 1: 
          case 2: 
          case 4: 
          case 7: 
          case 11: 
            return "2G";
            return "";
          }
          break;
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return "";
    }
    return "";
    label201:
    return "";
    return "";
    return "WIFI";
    return "UNKOWN";
    return "4G";
    return "3G";
  }
  
  public static void a()
  {
    for (;;)
    {
      int i;
      try
      {
        InputStreamReader localInputStreamReader = new InputStreamReader(Runtime.getRuntime().exec("cat /proc/cpuinfo").getInputStream());
        LineNumberReader localLineNumberReader = new LineNumberReader(localInputStreamReader);
        i = 0;
        String str = localLineNumberReader.readLine();
        if (str != null)
        {
          if (i == 0)
          {
            String[] arrayOfString = str.split(":\\s+", 2);
            if (arrayOfString.length >= 2) {
              a = arrayOfString[1];
            }
          }
          if (str.indexOf("Serial") >= 0) {
            c = str.substring(str.indexOf(":") + 1, str.length()).trim();
          }
          if (str.indexOf("Hardware") >= 0) {
            b = str.substring(str.indexOf(":") + 1, str.length()).trim();
          }
        }
        else
        {
          localInputStreamReader.close();
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      i += 1;
    }
  }
  
  public static float b(Context paramContext)
  {
    try
    {
      float f = paramContext.getResources().getDisplayMetrics().density;
      return f;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0.0F;
  }
  
  public static String b()
  {
    if (Build.DISPLAY.contains(Build.VERSION.INCREMENTAL)) {
      return Build.DISPLAY;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.DISPLAY);
    localStringBuilder.append("|");
    localStringBuilder.append(Build.VERSION.INCREMENTAL);
    return localStringBuilder.toString();
  }
  
  public static String b(Context paramContext, int paramInt)
  {
    Object localObject;
    for (;;)
    {
      try
      {
        paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
        if (paramInt == 0)
        {
          if (paramContext != null)
          {
            paramContext = paramContext.getSSID();
            localObject = paramContext;
            if (paramContext != null)
            {
              localObject = paramContext;
              if (paramContext.length() > 0)
              {
                localObject = paramContext;
                if (paramContext.indexOf("\"") == 0) {
                  localObject = paramContext.substring(1, paramContext.length());
                }
              }
            }
            if ((localObject == null) || (((String)localObject).length() <= 0) || (((String)localObject).lastIndexOf("\"") != ((String)localObject).length() - 1)) {
              break;
            }
            return ((String)localObject).substring(0, ((String)localObject).length() - 1);
          }
        }
        else
        {
          if (paramInt == 1)
          {
            if (paramContext != null) {
              return paramContext.getBSSID();
            }
            return "";
          }
          return "";
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return "";
      }
      paramContext = "";
    }
    return localObject;
  }
  
  public static int c()
  {
    int i;
    try
    {
      if ((!Build.FINGERPRINT.startsWith("generic")) && (!Build.FINGERPRINT.startsWith("unknown")) && (!Build.MODEL.contains("google_sdk")) && (!Build.MODEL.contains("Emulator")) && (!Build.MODEL.contains("Android SDK built for x86")) && (!Build.MANUFACTURER.contains("Genymotion")) && ((!Build.BRAND.startsWith("generic")) || (!Build.DEVICE.startsWith("generic"))))
      {
        boolean bool = "google_sdk".equals(Build.PRODUCT);
        if (!bool) {}
      }
      else
      {
        i = 1;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i = 0;
    }
    if (i != 0) {
      return 1;
    }
    return 0;
  }
  
  public static int c(Context paramContext)
  {
    try
    {
      int i = paramContext.getResources().getDisplayMetrics().widthPixels;
      return i;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public static int d()
  {
    int j = 0;
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j < 8) {
        try
        {
          String str = new String[] { "/system/bin/", "/system/xbin/", "/sbin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/xbin/", "/data/local/bin/", "/data/local/" }[j];
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("su");
          boolean bool = new File(localStringBuilder.toString()).exists();
          if (bool) {
            i = 1;
          }
          j += 1;
        }
        catch (Exception localException)
        {
          break label135;
        }
      }
    }
  }
  
  public static int d(Context paramContext)
  {
    try
    {
      int i = paramContext.getResources().getDisplayMetrics().heightPixels;
      return i;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public static int e(Context paramContext)
  {
    for (;;)
    {
      try
      {
        paramContext = (SensorManager)paramContext.getSystemService("sensor");
        j = 1;
        if (paramContext.getDefaultSensor(1) != null)
        {
          int i = j;
          if (paramContext.getDefaultSensor(2) != null) {
            i = j | 0x2;
          }
          j = i;
          if (paramContext.getDefaultSensor(4) != null) {
            j = i | 0x4;
          }
          i = j;
          if (paramContext.getDefaultSensor(9) != null) {
            i = j | 0x8;
          }
          j = i;
          if (paramContext.getDefaultSensor(10) != null) {
            j = i | 0x10;
          }
          i = j;
          if (paramContext.getDefaultSensor(5) != null) {
            i = j | 0x20;
          }
          j = i;
          if (paramContext.getDefaultSensor(8) != null) {
            j = i | 0x40;
          }
          i = j;
          if (paramContext.getDefaultSensor(7) != null) {
            i = j | 0x80;
          }
          paramContext = paramContext.getDefaultSensor(6);
          j = i;
          if (paramContext != null) {
            j = i | 0x100;
          }
          return j;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return 0;
      }
      int j = 0;
    }
  }
  
  public static String e()
  {
    try
    {
      String str = System.getProperty("os.name");
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  public static int f(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if ((paramContext != null) && (paramContext.getActiveNetworkInfo() != null))
      {
        int i = paramContext.getActiveNetworkInfo().getType();
        if (i == 1) {
          return 1;
        }
      }
      return 0;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public static String f()
  {
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat /proc/version").getInputStream()), 8192);
      StringBuilder localStringBuilder;
      for (String str1 = "";; str1 = localStringBuilder.toString())
      {
        String str2 = localBufferedReader.readLine();
        if (str2 == null) {
          break;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str1);
        localStringBuilder.append(str2);
      }
      if (str1 != "")
      {
        str1 = str1.substring(str1.indexOf("version ") + 8);
        str1 = str1.substring(0, str1.indexOf(" "));
        return str1;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  public static String g(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).applicationInfo.labelRes;
      paramContext = paramContext.getResources().getString(i);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static String h(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.kt
 * JD-Core Version:    0.7.0.1
 */