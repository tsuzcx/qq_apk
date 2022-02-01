package com.tencent.mobileqq.highway.netprobe;

import alkz;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

public class LoginWifiProbe
  extends ProbeItem
{
  public static final String PROBE_NAME = "LoginWifi_Probe";
  public final int RESULT_ECHO_NORMAL = 0;
  public final int RESULT_NEED_LOGIN = 2;
  public final int RESULT_NO_WIFI = 1;
  public final int RESULT_UNSPECT_EXCEPTION = 3;
  private EchoTask echoTask;
  private String ssid = "XG";
  
  private String getWifiSSID()
  {
    WifiInfo localWifiInfo = alkz.a((WifiManager)WeakNetLearner.mContext.getSystemService("wifi"));
    if (localWifiInfo != null) {
      return localWifiInfo.getSSID();
    }
    return null;
  }
  
  public void doProbe()
  {
    if (isWifiEnabled()) {
      this.ssid = getWifiSSID();
    }
    this.echoTask = new EchoTask(WeakNetLearner.mContext);
    switch (this.echoTask.doEcho())
    {
    default: 
      return;
    case 3: 
      onFinish(3, this.echoTask.getErrorMsg());
      return;
    case 1: 
      onFinish(0, null);
      return;
    }
    onFinish(2, this.echoTask.getResponseUrl());
  }
  
  public String getProbeName()
  {
    return "LoginWifi_Probe";
  }
  
  public boolean isWifiEnabled()
  {
    try
    {
      boolean bool = ((ConnectivityManager)WeakNetLearner.mContext.getSystemService("connectivity")).getActiveNetworkInfo().getTypeName().toLowerCase().equals("wifi");
      if (bool) {
        return true;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public void onFinish(int paramInt, Object paramObject)
  {
    this.mResult.errCode = paramInt;
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.mResult.success = true;
      this.mResult.appendResult("the network type is not wifi!");
      return;
    case 0: 
      this.mResult.success = true;
      this.mResult.appendResult("echo function is normal , wifi maybe is good !");
      return;
    case 3: 
      this.mResult.success = false;
      this.mResult.errDesc = ("the echo test has some exception:" + (String)paramObject);
      return;
    }
    this.mResult.success = false;
    this.mResult.errDesc = ("the wifi(" + this.ssid + ") need to login , the login-url:" + paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.netprobe.LoginWifiProbe
 * JD-Core Version:    0.7.0.1
 */