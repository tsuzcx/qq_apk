package com.tencent.token;

import android.annotation.SuppressLint;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

public class km
  extends WifiManager
{
  private WifiManager a;
  
  public km(WifiManager paramWifiManager)
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
 * Qualified Name:     com.tencent.token.km
 * JD-Core Version:    0.7.0.1
 */