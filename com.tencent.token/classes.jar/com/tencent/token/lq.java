package com.tencent.token;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.net.URLEncoder;

public final class lq
{
  private static String a = "";
  private static String b = "";
  
  public static int a(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte[0] << 24 & 0xFF000000) + (paramArrayOfByte[1] << 16 & 0xFF0000) + (paramArrayOfByte[2] << 8 & 0xFF00) + (paramArrayOfByte[3] & 0xFF);
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
    catch (Throwable paramString)
    {
      label42:
      break label42;
    }
    return "";
  }
  
  public static boolean a()
  {
    return "mounted".equals(Environment.getExternalStorageState());
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {
      return true;
    }
    return paramString.trim().length() == 0;
  }
  
  public static int b()
  {
    return (int)(Math.random() * 2147483647.0D);
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
    catch (Throwable paramString)
    {
      label17:
      break label17;
    }
    return "";
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    String str = "";
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(Integer.toHexString(paramArrayOfByte[i] >> 4 & 0xF));
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(Integer.toHexString(paramArrayOfByte[i] & 0xF));
      str = localStringBuilder.toString();
      i += 1;
    }
    return str;
  }
  
  public static String c()
  {
    return h();
  }
  
  public static String d()
  {
    return i();
  }
  
  public static String e()
  {
    Context localContext = lo.a();
    if (localContext == null) {
      return null;
    }
    return localContext.getPackageName();
  }
  
  public static String f()
  {
    Context localContext = lo.a();
    if (localContext == null) {
      return null;
    }
    Object localObject = lo.a();
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((Context)localObject).getPackageName();
    }
    try
    {
      localObject = localContext.getPackageManager().getPackageInfo((String)localObject, 0).versionName;
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public static int g()
  {
    Context localContext = lo.a();
    if (localContext == null) {
      return 0;
    }
    Object localObject = lo.a();
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((Context)localObject).getPackageName();
    }
    try
    {
      int i = localContext.getPackageManager().getPackageInfo((String)localObject, 0).versionCode;
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  private static String h()
  {
    try
    {
      localObject = a;
      i = 1;
      if (localObject != null) {
        if (((String)localObject).trim().length() != 0) {
          break label78;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject;
        String str;
        continue;
        label78:
        int i = 0;
      }
    }
    if (i != 0)
    {
      localObject = lo.a();
      if (localObject != null)
      {
        localObject = (TelephonyManager)((Context)localObject).getSystemService("phone");
        if (localObject != null)
        {
          str = ((TelephonyManager)localObject).getDeviceId();
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          a = (String)localObject;
        }
      }
    }
    return a;
  }
  
  private static String i()
  {
    try
    {
      localObject = b;
      i = 1;
      if (localObject != null) {
        if (((String)localObject).trim().length() != 0) {
          break label87;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject;
        String str;
        continue;
        label87:
        int i = 0;
      }
    }
    if (i != 0)
    {
      localObject = lo.a();
      if (localObject != null)
      {
        localObject = (WifiManager)((Context)localObject).getSystemService("wifi");
        if (localObject != null)
        {
          localObject = ((WifiManager)localObject).getConnectionInfo();
          if (localObject != null)
          {
            str = ((WifiInfo)localObject).getMacAddress();
            localObject = str;
            if (str == null) {
              localObject = "";
            }
            b = (String)localObject;
          }
        }
      }
    }
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.lq
 * JD-Core Version:    0.7.0.1
 */