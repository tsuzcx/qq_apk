package com.tencent.token;

import android.annotation.SuppressLint;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.LocalOnlyHotspotCallback;
import android.os.Build.VERSION;
import android.os.Handler;
import java.util.List;

public final class akd
{
  static WifiManager a;
  
  @SuppressLint({"MissingPermission"})
  public static WifiInfo a()
  {
    boolean bool = ll.a();
    Object localObject = new StringBuilder("getConnectionInfo, isAllow:[");
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).append("]");
    if (!bool) {
      return null;
    }
    akg.a("[API]WifiManagerInvoke_");
    localObject = a.getConnectionInfo();
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder("getConnectionInfo,WifiInfo-getMacAddress:[");
      localStringBuilder.append(((WifiInfo)localObject).getMacAddress());
      localStringBuilder.append("]");
      akg.a("[API]WifiManagerInvoke_");
    }
    return localObject;
  }
  
  @SuppressLint({"MissingPermission"})
  public static void a(WifiManager.LocalOnlyHotspotCallback paramLocalOnlyHotspotCallback, Handler paramHandler)
  {
    if (!ll.b()) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      akg.a("[API]WifiManagerInvoke_");
      a.startLocalOnlyHotspot(paramLocalOnlyHotspotCallback, paramHandler);
    }
  }
  
  @SuppressLint({"MissingPermission"})
  public static List<ScanResult> b()
  {
    boolean bool = ll.a();
    StringBuilder localStringBuilder = new StringBuilder("getScanResults, isAllow:[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    if (!bool) {
      return null;
    }
    akg.a("[API]WifiManagerInvoke_");
    return a.getScanResults();
  }
  
  @SuppressLint({"MissingPermission"})
  public static List<WifiConfiguration> c()
  {
    boolean bool = ll.a();
    StringBuilder localStringBuilder = new StringBuilder("getConfiguredNetworks, isAllow:[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    if (!bool) {
      return null;
    }
    akg.a("[API]WifiManagerInvoke_");
    return a.getConfiguredNetworks();
  }
  
  @SuppressLint({"MissingPermission"})
  public static boolean d()
  {
    boolean bool = ll.a();
    StringBuilder localStringBuilder = new StringBuilder("startScan, isAllow:[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    if (!bool) {
      return false;
    }
    akg.a("[API]WifiManagerInvoke_");
    return a.startScan();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.akd
 * JD-Core Version:    0.7.0.1
 */