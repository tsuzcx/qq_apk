package com.tencent.token;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Map;

public final class xw
{
  static Map<String, String> a;
  private static String b = "";
  private static String c = "";
  private static String d = "";
  
  public static String a()
  {
    avo.b("getModelName");
    if (!TextUtils.isEmpty(c))
    {
      localObject = new StringBuilder("getModelName:");
      ((StringBuilder)localObject).append(c);
      avo.b(((StringBuilder)localObject).toString());
      return c;
    }
    Object localObject = yd.a;
    c = (String)localObject;
    return localObject;
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (cl.a(paramContext, "android.permission.READ_PHONE_STATE") != 0) {
        return "000000000000000";
      }
      paramContext = localTelephonyManager.getSubscriberId();
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      paramContext = null;
    }
    if (paramContext == null) {
      return "000000000000000";
    }
    return paramContext;
  }
  
  @SuppressLint({"HardwareIds"})
  public static String b()
  {
    avo.b("getIMEI");
    if (!TextUtils.isEmpty(d))
    {
      StringBuilder localStringBuilder = new StringBuilder("getIMEI:");
      localStringBuilder.append(d);
      avo.b(localStringBuilder.toString());
      return d;
    }
    if (!sj.a().b()) {
      return "00000000000000";
    }
    d = "00000000000006";
    return "00000000000006";
  }
  
  @SuppressLint({"HardwareIds"})
  public static String b(Context paramContext)
  {
    avo.b("getAndoidId");
    if (!TextUtils.isEmpty(b))
    {
      paramContext = new StringBuilder("getAndoidId:");
      paramContext.append(b);
      avo.b(paramContext.toString());
      return b;
    }
    if (!sj.a().b()) {
      return "";
    }
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      b = paramContext;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label71:
      break label71;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.xw
 * JD-Core Version:    0.7.0.1
 */