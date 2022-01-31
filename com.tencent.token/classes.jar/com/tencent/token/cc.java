package com.tencent.token;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.halley.common.h;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class cc
{
  private static String a = "";
  private static String b = "";
  
  public static String a(Context paramContext)
  {
    int i = 1;
    if (paramContext == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        str = a;
        if (str != null) {
          continue;
        }
        if (i != 0)
        {
          paramContext = (TelephonyManager)paramContext.getSystemService("phone");
          if (paramContext != null) {
            a = paramContext.getDeviceId();
          }
        }
      }
      catch (Exception paramContext)
      {
        String str;
        int j;
        continue;
      }
      return a;
      j = str.trim().length();
      if (j != 0) {
        i = 0;
      }
    }
  }
  
  public static String a(Exception paramException)
  {
    String str = Log.getStackTraceString(paramException);
    if (str != null)
    {
      if ((str.indexOf("\n") != -1) && (str.indexOf("\n") < 100)) {
        paramException = str.substring(0, str.indexOf("\n"));
      }
      do
      {
        return paramException;
        paramException = str;
      } while (str.length() <= 100);
      return str.substring(0, 100);
    }
    return "";
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {}
    while (paramString.trim().length() == 0) {
      return true;
    }
    return false;
  }
  
  public static String b(Context paramContext)
  {
    int i = 1;
    if (paramContext == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        str = b;
        if (str != null) {
          continue;
        }
        if (i != 0)
        {
          paramContext = (WifiManager)paramContext.getSystemService("wifi");
          if (paramContext != null)
          {
            paramContext = paramContext.getConnectionInfo();
            if (paramContext != null) {
              b = paramContext.getMacAddress();
            }
          }
        }
      }
      catch (Exception paramContext)
      {
        String str;
        int j;
        continue;
      }
      return b;
      j = str.trim().length();
      if (j != 0) {
        i = 0;
      }
    }
  }
  
  public static String b(String paramString)
  {
    Object localObject = h.a();
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("");
      String str = a((Context)localObject);
      if (!TextUtils.isEmpty(str)) {
        localStringBuilder.append(str);
      }
      localObject = b((Context)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localStringBuilder.append((String)localObject);
      }
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append(paramString);
      localStringBuilder.append((int)(Math.random() * 2147483647.0D));
      paramString = c(localStringBuilder.toString());
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  private static String c(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    try
    {
      localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      paramString = ((MessageDigest)localObject).digest();
      if (paramString == null) {
        return "";
      }
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    Object localObject = new StringBuffer();
    int i = 0;
    while (i < paramString.length)
    {
      String str = Integer.toHexString(paramString[i] & 0xFF);
      if (str.length() == 1) {
        ((StringBuffer)localObject).append("0");
      }
      ((StringBuffer)localObject).append(str);
      i += 1;
    }
    return ((StringBuffer)localObject).toString().toUpperCase();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cc
 * JD-Core Version:    0.7.0.1
 */