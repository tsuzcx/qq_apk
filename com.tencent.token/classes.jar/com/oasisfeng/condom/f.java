package com.oasisfeng.condom;

import android.annotation.SuppressLint;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

public class f
  extends WifiManager
{
  private WifiManager a;
  
  public f(WifiManager paramWifiManager)
  {
    this.a = paramWifiManager;
  }
  
  @SuppressLint({"MissingPermission"})
  public WifiInfo getConnectionInfo()
  {
    return this.a.getConnectionInfo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.oasisfeng.condom.f
 * JD-Core Version:    0.7.0.1
 */