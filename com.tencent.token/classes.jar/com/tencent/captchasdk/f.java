package com.tencent.captchasdk;

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

class f
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
  
  public static int a(Context paramContext, float paramFloat)
  {
    int i;
    try
    {
      if (paramContext.getResources().getDisplayMetrics().widthPixels < paramContext.getResources().getDisplayMetrics().heightPixels)
      {
        i = (int)(paramContext.getResources().getDisplayMetrics().widthPixels * 0.9F);
      }
      else
      {
        i = paramContext.getResources().getDisplayMetrics().heightPixels;
        i = (int)(i * 0.9F);
      }
    }
    catch (Exception paramContext)
    {
      return (int)(300.0F * paramFloat);
    }
    int j = i;
    if (i > (int)(400.0F * paramFloat)) {
      j = (int)(400.0F * paramFloat);
    }
    return j;
  }
  
  public static int a(Context paramContext, Window paramWindow, RelativeLayout paramRelativeLayout1, RelativeLayout paramRelativeLayout2, e parame)
  {
    float f = paramContext.getResources().getDisplayMetrics().density;
    int i = a(paramContext, f);
    paramWindow.setBackgroundDrawable(new ColorDrawable(0));
    parame.setVisibility(4);
    paramContext = new RelativeLayout.LayoutParams(-1, -1);
    paramContext.addRule(13);
    paramRelativeLayout1.addView(parame, paramContext);
    paramContext = paramRelativeLayout2.getLayoutParams();
    paramContext.width = ((int)('' * f));
    paramContext.height = ((int)('' * f));
    paramRelativeLayout2.setLayoutParams(paramContext);
    new RelativeLayout.LayoutParams((int)(52 * f), (int)(52 * f)).addRule(13);
    paramContext = paramWindow.getAttributes();
    paramContext.width = i;
    paramContext.height = i;
    paramWindow.setAttributes(paramContext);
    parame.a(i, i, f * 3.0F);
    return 140;
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramInt == 0)
      {
        if (localTelephonyManager != null) {
          return localTelephonyManager.getNetworkType() + "";
        }
      }
      else
      {
        if (paramInt == 1)
        {
          if (localTelephonyManager == null) {
            break label202;
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
          default: 
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
    label202:
    return "";
    return "";
    return "WIFI";
    return "UNKOWN";
    return "2G";
    return "3G";
    return "4G";
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
          if (str.indexOf("Serial") > -1) {
            c = str.substring(str.indexOf(":") + 1, str.length()).trim();
          }
          if (str.indexOf("Hardware") > -1) {
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
    return Build.DISPLAY + "|" + Build.VERSION.INCREMENTAL;
  }
  
  public static String b(Context paramContext, int paramInt)
  {
    for (;;)
    {
      try
      {
        paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
        if (paramInt == 0)
        {
          if (paramContext == null) {
            break label136;
          }
          localObject = paramContext.getSSID();
          paramContext = (Context)localObject;
          if (localObject != null)
          {
            paramContext = (Context)localObject;
            if (((String)localObject).length() > 0)
            {
              paramContext = (Context)localObject;
              if (((String)localObject).indexOf("\"") == 0) {
                paramContext = ((String)localObject).substring(1, ((String)localObject).length());
              }
            }
          }
          localObject = paramContext;
          if (paramContext != null)
          {
            localObject = paramContext;
            if (paramContext.length() > 0)
            {
              localObject = paramContext;
              if (paramContext.lastIndexOf("\"") == paramContext.length() - 1) {
                return paramContext.substring(0, paramContext.length() - 1);
              }
            }
          }
        }
        else
        {
          if (paramInt == 1)
          {
            if (paramContext == null) {
              break;
            }
            return paramContext.getBSSID();
          }
          return "";
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        localObject = "";
      }
      return localObject;
      label136:
      Object localObject = "";
    }
    return "";
  }
  
  public static int c()
  {
    for (;;)
    {
      try
      {
        if ((!Build.FINGERPRINT.startsWith("generic")) && (!Build.FINGERPRINT.startsWith("unknown")) && (!Build.MODEL.contains("google_sdk")) && (!Build.MODEL.contains("Emulator")) && (!Build.MODEL.contains("Android SDK built for x86")) && (!Build.MANUFACTURER.contains("Genymotion")) && ((!Build.BRAND.startsWith("generic")) || (!Build.DEVICE.startsWith("generic"))))
        {
          boolean bool = "google_sdk".equals(Build.PRODUCT);
          if (!bool) {
            continue;
          }
        }
        i = 1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        int i = 0;
        continue;
      }
      if (i == 0) {
        break label133;
      }
      return 1;
      i = 0;
    }
    label133:
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
    try
    {
      arrayOfString = new String[8];
      arrayOfString[0] = "/system/bin/";
      arrayOfString[1] = "/system/xbin/";
      arrayOfString[2] = "/sbin/";
      arrayOfString[3] = "/system/sd/xbin/";
      arrayOfString[4] = "/system/bin/failsafe/";
      arrayOfString[5] = "/data/local/xbin/";
      arrayOfString[6] = "/data/local/bin/";
      arrayOfString[7] = "/data/local/";
      m = arrayOfString.length;
      j = 0;
      i = 0;
    }
    catch (Exception localException1)
    {
      try
      {
        String[] arrayOfString;
        int m;
        int j;
        String str;
        boolean bool = new File(str + "su").exists();
        if (bool) {
          i = 1;
        }
        j += 1;
      }
      catch (Exception localException2)
      {
        int i;
        int k;
        break label137;
      }
      localException1 = localException1;
      i = 0;
    }
    k = i;
    if (j < m)
    {
      str = arrayOfString[j];
      label137:
      localException1.printStackTrace();
      k = i;
    }
    if (k != 0) {
      return 1;
    }
    return 0;
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
    for (int j = 1;; j = 0)
    {
      int i;
      try
      {
        paramContext = (SensorManager)paramContext.getSystemService("sensor");
        if (paramContext.getDefaultSensor(1) == null) {
          continue;
        }
        i = j;
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
        if (paramContext != null) {
          return i | 0x100;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return 0;
      }
      return i;
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
    String str2 = "";
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat /proc/version").getInputStream()), 8192);
      String str3;
      for (String str1 = "";; str1 = str1 + str3)
      {
        str3 = localBufferedReader.readLine();
        if (str3 == null) {
          break;
        }
      }
      if (str1 != "")
      {
        int i = str1.indexOf("version ");
        str1 = str1.substring("version ".length() + i);
        str2 = str1.substring(0, str1.indexOf(" "));
      }
      return str2;
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
 * Qualified Name:     com.tencent.captchasdk.f
 * JD-Core Version:    0.7.0.1
 */