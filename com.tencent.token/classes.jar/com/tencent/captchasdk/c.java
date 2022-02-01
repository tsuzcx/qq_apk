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

class c
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
  
  public static int a(Context paramContext, Window paramWindow, RelativeLayout paramRelativeLayout1, RelativeLayout paramRelativeLayout2, b paramb)
  {
    float f = paramContext.getResources().getDisplayMetrics().density;
    int i = a(paramContext, f);
    paramWindow.setBackgroundDrawable(new ColorDrawable(0));
    paramb.setVisibility(4);
    paramContext = new RelativeLayout.LayoutParams(-1, -1);
    paramContext.addRule(13);
    paramRelativeLayout1.addView(paramb, paramContext);
    paramContext = paramRelativeLayout2.getLayoutParams();
    int j = (int)('' * f);
    paramContext.width = j;
    paramContext.height = j;
    paramRelativeLayout2.setLayoutParams(paramContext);
    j = (int)(52 * f);
    new RelativeLayout.LayoutParams(j, j).addRule(13);
    paramContext = paramWindow.getAttributes();
    paramContext.width = i;
    paramContext.height = i;
    paramWindow.setAttributes(paramContext);
    paramb.a(i, i, f * 3.0F);
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
          paramContext.append("");
          return paramContext.toString();
        }
      }
      else
      {
        if (paramInt == 1)
        {
          if (localTelephonyManager == null) {
            break label206;
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
    label206:
    return "";
    return "";
    return "WIFI";
    return "UNKOWN";
    return "4G";
    return "3G";
    return "2G";
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
            if (paramContext == null) {
              break label139;
            }
            return paramContext.getBSSID();
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
    label139:
    return "";
  }
  
  public static int c()
  {
    try
    {
      if ((!Build.FINGERPRINT.startsWith("generic")) && (!Build.FINGERPRINT.startsWith("unknown")) && (!Build.MODEL.contains("google_sdk")) && (!Build.MODEL.contains("Emulator")) && (!Build.MODEL.contains("Android SDK built for x86")) && (!Build.MANUFACTURER.contains("Genymotion")) && ((!Build.BRAND.startsWith("generic")) || (!Build.DEVICE.startsWith("generic"))))
      {
        boolean bool = "google_sdk".equals(Build.PRODUCT);
        if (!bool) {}
      }
      else
      {
        return 1;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
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
    int i;
    try
    {
      String[] arrayOfString = new String[8];
      arrayOfString[0] = "/system/bin/";
      arrayOfString[1] = "/system/xbin/";
      arrayOfString[2] = "/sbin/";
      arrayOfString[3] = "/system/sd/xbin/";
      arrayOfString[4] = "/system/bin/failsafe/";
      arrayOfString[5] = "/data/local/xbin/";
      arrayOfString[6] = "/data/local/bin/";
      arrayOfString[7] = "/data/local/";
      int m = arrayOfString.length;
      i = 0;
      for (;;)
      {
        k = i;
        if (j >= m) {
          return k;
        }
        String str = arrayOfString[j];
        try
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("su");
          boolean bool = new File(localStringBuilder.toString()).exists();
          if (bool) {
            i = 1;
          }
          j += 1;
        }
        catch (Exception localException1) {}
      }
      localException2.printStackTrace();
    }
    catch (Exception localException2)
    {
      i = 0;
    }
    int k = i;
    return k;
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
    int j = 0;
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      int i = j;
      if (paramContext != null)
      {
        i = j;
        if (paramContext.getActiveNetworkInfo() != null)
        {
          int k = paramContext.getActiveNetworkInfo().getType();
          i = j;
          if (k == 1) {
            i = 1;
          }
        }
      }
      return i;
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
 * Qualified Name:     com.tencent.captchasdk.c
 * JD-Core Version:    0.7.0.1
 */