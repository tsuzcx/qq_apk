package com.android.safeguard;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;

public class g
  extends h
{
  private String a;
  private Context b = null;
  private String c = "";
  private SensorManager d = null;
  private int e = 0;
  
  public g(Context paramContext)
  {
    this.b = paramContext;
    this.e = new b(paramContext).g();
    this.a = "sensor";
    paramContext = new StringBuilder(String.valueOf(Long.toString(620365L, 16)));
    paramContext.append(Long.toString(355688L, 16));
    paramContext.append(Long.toString(3036316L, 16));
    this.c = paramContext.toString();
  }
  
  public String a()
  {
    try
    {
      String str = ((TelephonyManager)this.b.getSystemService("phone")).getDeviceId();
      return str;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return "";
  }
  
  public String b()
  {
    try
    {
      String str = Settings.Secure.getString(this.b.getContentResolver(), "android_id");
      return str;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return "";
  }
  
  public String c()
  {
    return Build.PRODUCT;
  }
  
  public String d()
  {
    return Build.MODEL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.android.safeguard.g
 * JD-Core Version:    0.7.0.1
 */