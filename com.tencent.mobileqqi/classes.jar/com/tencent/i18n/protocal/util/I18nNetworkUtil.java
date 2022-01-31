package com.tencent.i18n.protocal.util;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.qphone.base.util.BaseApplication;

public class I18nNetworkUtil
{
  public static String a()
  {
    WifiManager localWifiManager = (WifiManager)BaseApplication.getContext().getSystemService("wifi");
    if (!localWifiManager.isWifiEnabled()) {
      return "";
    }
    return a(localWifiManager.getConnectionInfo().getIpAddress());
  }
  
  private static String a(int paramInt)
  {
    return (paramInt & 0xFF) + "." + (paramInt >> 8 & 0xFF) + "." + (paramInt >> 16 & 0xFF) + "." + (paramInt >> 24 & 0xFF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.i18n.protocal.util.I18nNetworkUtil
 * JD-Core Version:    0.7.0.1
 */