package com.tencent.token;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;

@SuppressLint({"MissingPermission"})
public class kp
  extends TelephonyManager
{
  private TelephonyManager a;
  
  public kp(Context paramContext, TelephonyManager paramTelephonyManager)
  {
    super(paramContext);
    this.a = paramTelephonyManager;
  }
  
  public String getDeviceId()
  {
    return this.a.getDeviceId();
  }
  
  public String getDeviceId(int paramInt)
  {
    return this.a.getDeviceId(paramInt);
  }
  
  public String getImei()
  {
    return this.a.getImei();
  }
  
  public String getImei(int paramInt)
  {
    return this.a.getImei(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.kp
 * JD-Core Version:    0.7.0.1
 */