package com.tencent.token;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Map;

public final class xk
{
  static Map<String, String> a;
  private static String b = "";
  private static String c = "";
  private static String d = "";
  
  public static String a()
  {
    auq.b("getModelName");
    if (!TextUtils.isEmpty(c))
    {
      localObject = new StringBuilder("getModelName:");
      ((StringBuilder)localObject).append(c);
      auq.b(((StringBuilder)localObject).toString());
      return c;
    }
    Object localObject = xr.a;
    c = (String)localObject;
    return localObject;
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (bx.a(paramContext, "android.permission.READ_PHONE_STATE") != 0) {
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
  public static String b(Context paramContext)
  {
    auq.b("getAndoidId");
    if (!TextUtils.isEmpty(b))
    {
      paramContext = new StringBuilder("getAndoidId:");
      paramContext.append(b);
      auq.b(paramContext.toString());
      return b;
    }
    if (!rw.a().b()) {
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
  
  @SuppressLint({"HardwareIds"})
  public static String c(Context paramContext)
  {
    auq.b("getIMEI");
    if (!TextUtils.isEmpty(d))
    {
      paramContext = new StringBuilder("getIMEI:");
      paramContext.append(d);
      auq.b(paramContext.toString());
      return d;
    }
    if (!rw.a().b()) {
      return "00000000000000";
    }
    try
    {
      localObject = (TelephonyManager)paramContext.getSystemService("phone");
      if (bx.a(paramContext, "android.permission.READ_PHONE_STATE") != 0) {
        return "00000000000002";
      }
      if (localObject != null) {
        paramContext = ((TelephonyManager)localObject).getDeviceId();
      } else {
        paramContext = "00000000000004";
      }
    }
    catch (Throwable paramContext)
    {
      Object localObject;
      label95:
      break label95;
    }
    paramContext = "00000000000001";
    localObject = paramContext;
    if (paramContext == null) {
      localObject = "00000000000000";
    }
    d = (String)localObject;
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.xk
 * JD-Core Version:    0.7.0.1
 */