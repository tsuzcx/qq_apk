package com.tencent.smtt.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.sdk.c;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

public class j
{
  private static SharedPreferences a;
  private static SharedPreferences.Editor b;
  
  private static String a()
  {
    try
    {
      String str2 = Build.SERIAL;
      String str1;
      if (!TextUtils.isEmpty(str2))
      {
        str1 = str2;
        if (!str2.contains("unknown")) {}
      }
      else
      {
        str1 = b();
      }
      return str1;
    }
    catch (Exception localException) {}
    return "unknown";
  }
  
  public static String a(Context paramContext)
  {
    if (!c(paramContext)) {
      localObject = "";
    }
    do
    {
      return localObject;
      a = paramContext.getApplicationContext().getSharedPreferences("tsui", 0);
      if (a == null) {
        break;
      }
      str2 = a.getString("tsui", "");
      localObject = str2;
    } while (!TextUtils.isEmpty(str2));
    Object localObject = new StringBuilder();
    String str2 = b();
    String str3 = b.k(paramContext);
    String str4 = a();
    String str5 = b(paramContext).replace("-", "");
    if ((str2 != null) && (str2.length() > 0))
    {
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append("|");
    }
    if ((str3 != null) && (str3.length() > 0))
    {
      ((StringBuilder)localObject).append(str3);
      ((StringBuilder)localObject).append("|");
    }
    if ((str4 != null) && (str4.length() > 0))
    {
      ((StringBuilder)localObject).append(str4);
      ((StringBuilder)localObject).append("|");
    }
    if ((str5 != null) && (str5.length() > 0)) {
      ((StringBuilder)localObject).append(str5);
    }
    if (((StringBuilder)localObject).length() > 0) {
      try
      {
        localObject = a(a(((StringBuilder)localObject).toString()));
        if ((localObject != null) && (((String)localObject).length() > 0))
        {
          a(paramContext, "tsui", (String)localObject);
          return localObject;
        }
      }
      catch (Exception localException) {}
    }
    String str1 = UUID.randomUUID().toString().replace("-", "");
    a(paramContext, "tsui", str1);
    return str1;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() == 1) {
        localStringBuilder.append("0");
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString().toUpperCase(Locale.CHINA);
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (a == null) {
      a = paramContext.getApplicationContext().getSharedPreferences("tsui", 0);
    }
    b = a.edit();
    b.putString(paramString1, paramString2);
    b.commit();
  }
  
  private static byte[] a(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
      localMessageDigest.reset();
      localMessageDigest.update(paramString.getBytes("UTF-8"));
      paramString = localMessageDigest.digest();
      return paramString;
    }
    catch (Exception paramString) {}
    return "".getBytes();
  }
  
  private static String b()
  {
    int i = new Random().nextInt(2147483646);
    return Build.FINGERPRINT + i;
  }
  
  private static String b(Context paramContext)
  {
    try
    {
      paramContext = q.d(paramContext);
      int i = new Random().nextInt(2147483646);
      paramContext = new UUID(("" + i + Build.BOARD.length() % 10 + Build.BRAND.length() % 10 + Build.DEVICE.length() % 10 + Build.HARDWARE.length() % 10 + Build.ID.length() % 10 + paramContext.length() % 10 + Build.PRODUCT.length() % 10 + Build.SERIAL.length() % 10).hashCode(), Build.SERIAL.hashCode()).toString();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  private static boolean c(Context paramContext)
  {
    try
    {
      bool = paramContext.getSharedPreferences("sai", 0).getBoolean("sui", true);
      TbsLog.i("SDKUID", "stack is " + Log.getStackTraceString(paramContext));
    }
    catch (Throwable paramContext)
    {
      try
      {
        Log.d("SDKUID", "isSDKUIDEnable is " + bool);
        TbsLog.i("SDKUID", "isSDKUIDEnable is " + bool);
        c.a().a(paramContext, Integer.valueOf(1002), new j.1(paramContext));
        return bool;
      }
      catch (Throwable paramContext)
      {
        boolean bool;
        break label91;
      }
      paramContext = paramContext;
      bool = true;
    }
    label91:
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.utils.j
 * JD-Core Version:    0.7.0.1
 */