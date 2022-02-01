package com.tencent.token;

import android.net.DhcpInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.LocalOnlyHotspotCallback;
import android.net.wifi.WifiManager.MulticastLock;
import android.net.wifi.WifiManager.WifiLock;
import android.net.wifi.WifiManager.WpsCallback;
import android.net.wifi.WpsInfo;
import android.net.wifi.hotspot2.PasspointConfiguration;
import android.os.Build.VERSION;
import android.os.Handler;
import java.net.InetAddress;
import java.util.List;

public class ake
  extends le
{
  private WifiManager a;
  
  public ake(WifiManager paramWifiManager)
  {
    super(paramWifiManager);
    this.a = paramWifiManager;
  }
  
  public int addNetwork(WifiConfiguration paramWifiConfiguration)
  {
    int i = this.a.addNetwork(paramWifiConfiguration);
    StringBuilder localStringBuilder = new StringBuilder("addNetwork:[");
    localStringBuilder.append(paramWifiConfiguration.SSID);
    localStringBuilder.append("][");
    localStringBuilder.append(paramWifiConfiguration.preSharedKey);
    localStringBuilder.append("]ret:[");
    localStringBuilder.append(i);
    localStringBuilder.append("]");
    akg.a("[API]WifiManager_");
    return i;
  }
  
  public void addOrUpdatePasspointConfiguration(PasspointConfiguration paramPasspointConfiguration)
  {
    akg.a("[API]WifiManager_");
    if (Build.VERSION.SDK_INT >= 26) {
      this.a.addOrUpdatePasspointConfiguration(paramPasspointConfiguration);
    }
  }
  
  public void cancelWps(WifiManager.WpsCallback paramWpsCallback)
  {
    akg.a("[API]WifiManager_");
    if (Build.VERSION.SDK_INT >= 21) {
      this.a.cancelWps(paramWpsCallback);
    }
  }
  
  public WifiManager.MulticastLock createMulticastLock(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("createMulticastLock, tag:[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    akg.a("[API]WifiManager_");
    return this.a.createMulticastLock(paramString);
  }
  
  public WifiManager.WifiLock createWifiLock(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("createWifiLock, lockType:[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]tag:[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    akg.a("[API]WifiManager_");
    return this.a.createWifiLock(paramInt, paramString);
  }
  
  public WifiManager.WifiLock createWifiLock(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("createWifiLock, tag:[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    akg.a("[API]WifiManager_");
    return this.a.createWifiLock(paramString);
  }
  
  public boolean disableNetwork(int paramInt)
  {
    boolean bool = this.a.disableNetwork(paramInt);
    StringBuilder localStringBuilder = new StringBuilder("disableNetwork, netId:[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]ret:[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    akg.a("[API]WifiManager_");
    return bool;
  }
  
  public boolean disconnect()
  {
    boolean bool = this.a.disconnect();
    StringBuilder localStringBuilder = new StringBuilder("disconnect:[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    akg.a("[API]WifiManager_");
    return bool;
  }
  
  public boolean enableNetwork(int paramInt, boolean paramBoolean)
  {
    boolean bool = this.a.enableNetwork(paramInt, paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder("enableNetwork, netId:[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]attemptConnect:[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]ret:[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    akg.a("[API]WifiManager_");
    return bool;
  }
  
  public List<WifiConfiguration> getConfiguredNetworks()
  {
    akg.a("[API]WifiManager_");
    return this.a.getConfiguredNetworks();
  }
  
  public WifiInfo getConnectionInfo()
  {
    akg.a("[API]WifiManager_");
    return this.a.getConnectionInfo();
  }
  
  public DhcpInfo getDhcpInfo()
  {
    akg.a("[API]WifiManager_");
    return this.a.getDhcpInfo();
  }
  
  public List<PasspointConfiguration> getPasspointConfigurations()
  {
    akg.a("[API]WifiManager_");
    if (Build.VERSION.SDK_INT >= 26) {
      return this.a.getPasspointConfigurations();
    }
    return null;
  }
  
  public List<ScanResult> getScanResults()
  {
    akg.a("[API]WifiManager_");
    return this.a.getScanResults();
  }
  
  public int getWifiState()
  {
    int i = this.a.getWifiState();
    StringBuilder localStringBuilder = new StringBuilder("getWifiState:[");
    localStringBuilder.append(i);
    localStringBuilder.append("]");
    akg.a("[API]WifiManager_");
    return i;
  }
  
  public boolean is5GHzBandSupported()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = this.a.is5GHzBandSupported();
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder("is5GHzBandSupported:[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    akg.a("[API]WifiManager_");
    return bool;
  }
  
  public boolean isDeviceToApRttSupported()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = this.a.isDeviceToApRttSupported();
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder("isDeviceToApRttSupported:[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    akg.a("[API]WifiManager_");
    return bool;
  }
  
  public boolean isEnhancedPowerReportingSupported()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = this.a.isEnhancedPowerReportingSupported();
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder("isEnhancedPowerReportingSupported:[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    akg.a("[API]WifiManager_");
    return bool;
  }
  
  public boolean isP2pSupported()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = this.a.isP2pSupported();
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder("isP2pSupported:[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    akg.a("[API]WifiManager_");
    return bool;
  }
  
  public boolean isPreferredNetworkOffloadSupported()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = this.a.isPreferredNetworkOffloadSupported();
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder("isPreferredNetworkOffloadSupported:[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    akg.a("[API]WifiManager_");
    return bool;
  }
  
  public boolean isScanAlwaysAvailable()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 18) {
      bool = this.a.isScanAlwaysAvailable();
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder("isScanAlwaysAvailable:[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    akg.a("[API]WifiManager_");
    return bool;
  }
  
  public boolean isTdlsSupported()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = this.a.isTdlsSupported();
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder("isTdlsSupported:[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    akg.a("[API]WifiManager_");
    return bool;
  }
  
  public boolean isWifiEnabled()
  {
    boolean bool = this.a.isWifiEnabled();
    StringBuilder localStringBuilder = new StringBuilder("isWifiEnabled:[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    akg.a("[API]WifiManager_");
    return bool;
  }
  
  public boolean pingSupplicant()
  {
    boolean bool = this.a.pingSupplicant();
    StringBuilder localStringBuilder = new StringBuilder("pingSupplicant:[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    akg.a("[API]WifiManager_");
    return bool;
  }
  
  public boolean reassociate()
  {
    boolean bool = this.a.reassociate();
    StringBuilder localStringBuilder = new StringBuilder("reassociate:[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    akg.a("[API]WifiManager_");
    return bool;
  }
  
  public boolean reconnect()
  {
    boolean bool = this.a.reconnect();
    StringBuilder localStringBuilder = new StringBuilder("reconnect:[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    akg.a("[API]WifiManager_");
    return bool;
  }
  
  public boolean removeNetwork(int paramInt)
  {
    boolean bool = this.a.removeNetwork(paramInt);
    StringBuilder localStringBuilder = new StringBuilder("removeNetwork:[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]ret:[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    akg.a("[API]WifiManager_");
    return bool;
  }
  
  public void removePasspointConfiguration(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("removePasspointConfiguration:[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    akg.a("[API]WifiManager_");
    if (Build.VERSION.SDK_INT >= 26) {
      this.a.removePasspointConfiguration(paramString);
    }
  }
  
  public boolean saveConfiguration()
  {
    boolean bool = this.a.saveConfiguration();
    StringBuilder localStringBuilder = new StringBuilder("saveConfiguration:[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    akg.a("[API]WifiManager_");
    return bool;
  }
  
  public void setTdlsEnabled(InetAddress paramInetAddress, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("setTdlsEnabled:[");
    localStringBuilder.append(paramInetAddress);
    localStringBuilder.append("]");
    akg.a("[API]WifiManager_");
    if (Build.VERSION.SDK_INT >= 19) {
      this.a.setTdlsEnabled(paramInetAddress, paramBoolean);
    }
  }
  
  public void setTdlsEnabledWithMacAddress(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("setTdlsEnabledWithMacAddress:[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]enable:[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    akg.a("[API]WifiManager_");
    if (Build.VERSION.SDK_INT >= 19) {
      this.a.setTdlsEnabledWithMacAddress(paramString, paramBoolean);
    }
  }
  
  public boolean setWifiEnabled(boolean paramBoolean)
  {
    boolean bool = this.a.setWifiEnabled(paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder("setWifiEnabled:[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]ret:[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    akg.a("[API]WifiManager_");
    return bool;
  }
  
  public void startLocalOnlyHotspot(WifiManager.LocalOnlyHotspotCallback paramLocalOnlyHotspotCallback, Handler paramHandler)
  {
    akg.a("[API]WifiManager_");
    if (Build.VERSION.SDK_INT >= 26) {
      this.a.startLocalOnlyHotspot(paramLocalOnlyHotspotCallback, paramHandler);
    }
  }
  
  public boolean startScan()
  {
    boolean bool = this.a.startScan();
    StringBuilder localStringBuilder = new StringBuilder("startScan:[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    akg.a("[API]WifiManager_");
    return bool;
  }
  
  public void startWps(WpsInfo paramWpsInfo, WifiManager.WpsCallback paramWpsCallback)
  {
    akg.a("[API]WifiManager_");
    if (Build.VERSION.SDK_INT >= 21) {
      this.a.startWps(paramWpsInfo, paramWpsCallback);
    }
  }
  
  public int updateNetwork(WifiConfiguration paramWifiConfiguration)
  {
    int i = this.a.updateNetwork(paramWifiConfiguration);
    StringBuilder localStringBuilder = new StringBuilder("updateNetwork, [");
    localStringBuilder.append(paramWifiConfiguration.SSID);
    localStringBuilder.append("][");
    localStringBuilder.append(paramWifiConfiguration.preSharedKey);
    localStringBuilder.append("]ret:[");
    localStringBuilder.append(i);
    localStringBuilder.append("]");
    akg.a("[API]WifiManager_");
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ake
 * JD-Core Version:    0.7.0.1
 */