package com.tencent.token;

import android.content.Context;
import android.hardware.SensorManager;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;

public final class h
  extends i
{
  private String a;
  private Context b = null;
  private String c = "";
  private SensorManager d = null;
  private int e = 0;
  
  public h(Context paramContext)
  {
    this.b = paramContext;
    this.e = new c(paramContext).f();
    this.a = "sensor";
    this.c = (Long.toString(620365L, 16) + Long.toString(355688L, 16) + Long.toString(3036316L, 16));
  }
  
  public final String a()
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
  
  public final String b()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.h
 * JD-Core Version:    0.7.0.1
 */