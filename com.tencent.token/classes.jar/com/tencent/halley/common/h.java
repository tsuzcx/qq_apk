package com.tencent.halley.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.net.URLEncoder;

public final class h
{
  private static String a = "";
  private static String b = "";
  
  public static int a(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[0] << 24 & 0xFF000000) + (paramArrayOfByte[1] << 16 & 0xFF0000) + (paramArrayOfByte[2] << 8 & 0xFF00) + (paramArrayOfByte[3] & 0xFF);
  }
  
  private static String a(Context paramContext)
  {
    int i = 1;
    for (;;)
    {
      try
      {
        paramContext = a;
        if (paramContext != null) {
          continue;
        }
        if (i != 0)
        {
          paramContext = f.a();
          if (paramContext != null)
          {
            paramContext = (TelephonyManager)paramContext.getSystemService("phone");
            if (paramContext != null)
            {
              String str = paramContext.getDeviceId();
              paramContext = str;
              if (str == null) {
                paramContext = "";
              }
              a = paramContext;
            }
          }
        }
      }
      catch (Throwable paramContext)
      {
        int j;
        continue;
      }
      return a;
      j = paramContext.trim().length();
      if (j != 0) {
        i = 0;
      }
    }
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String str = paramString;
    if (paramBoolean) {
      str = paramString;
    }
    try
    {
      if (paramString.length() > 30) {
        str = paramString.substring(0, 30);
      }
      paramString = URLEncoder.encode(str);
      return paramString;
    }
    catch (Throwable paramString) {}
    return "";
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    Object localObject;
    if (paramArrayOfByte == null)
    {
      localObject = "";
      return localObject;
    }
    String str = "";
    int i = 0;
    for (;;)
    {
      localObject = str;
      if (i >= paramArrayOfByte.length) {
        break;
      }
      str = str + Integer.toHexString(paramArrayOfByte[i] >> 4 & 0xF);
      str = str + Integer.toHexString(paramArrayOfByte[i] & 0xF);
      i += 1;
    }
  }
  
  public static boolean a()
  {
    return "mounted".equals(Environment.getExternalStorageState());
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {}
    while (paramString.trim().length() == 0) {
      return true;
    }
    return false;
  }
  
  public static int b()
  {
    return (int)(Math.random() * 2147483647.0D);
  }
  
  private static String b(Context paramContext)
  {
    int i = 1;
    for (;;)
    {
      try
      {
        paramContext = b;
        if (paramContext != null) {
          continue;
        }
        if (i != 0)
        {
          paramContext = f.a();
          if (paramContext != null)
          {
            paramContext = (WifiManager)paramContext.getSystemService("wifi");
            if (paramContext != null)
            {
              paramContext = paramContext.getConnectionInfo();
              if (paramContext != null)
              {
                String str = paramContext.getMacAddress();
                paramContext = str;
                if (str == null) {
                  paramContext = "";
                }
                b = paramContext;
              }
            }
          }
        }
      }
      catch (Throwable paramContext)
      {
        int j;
        continue;
      }
      return b;
      j = paramContext.trim().length();
      if (j != 0) {
        i = 0;
      }
    }
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      paramString = URLEncoder.encode(paramString);
      return paramString;
    }
    catch (Throwable paramString) {}
    return "";
  }
  
  public static String c()
  {
    return a(null);
  }
  
  public static String d()
  {
    return b(null);
  }
  
  public static String e()
  {
    Context localContext = f.a();
    if (localContext == null) {
      return null;
    }
    return localContext.getPackageName();
  }
  
  public static String f()
  {
    Context localContext = f.a();
    if (localContext == null) {
      return null;
    }
    Object localObject = f.a();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((Context)localObject).getPackageName()) {
      try
      {
        localObject = localContext.getPackageManager().getPackageInfo((String)localObject, 0).versionName;
        return localObject;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return null;
  }
  
  public static int g()
  {
    Context localContext = f.a();
    if (localContext == null) {
      return 0;
    }
    Object localObject = f.a();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((Context)localObject).getPackageName()) {
      try
      {
        int i = localContext.getPackageManager().getPackageInfo((String)localObject, 0).versionCode;
        return i;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.common.h
 * JD-Core Version:    0.7.0.1
 */