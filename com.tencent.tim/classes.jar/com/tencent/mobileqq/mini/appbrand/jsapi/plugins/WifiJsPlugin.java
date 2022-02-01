package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import alkz;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WifiJsPlugin
  extends BaseJsPlugin
{
  private static final String API_CONNECT_WIFI = "connectWifi";
  private static final String API_GET_CONNECTED_WIFI = "getConnectedWifi";
  private static final String API_GET_WIFI_LIST = "getWifiList";
  private static final String API_ON_GET_WIFI_LIST = "onGetWifiList";
  private static final String API_ON_WIFI_CONNECTED = "onWifiConnected";
  private static final String API_START_WIFI = "startWifi";
  private static final String API_STOP_WIFI = "stopWifi";
  public static final int MODE_EAP = 3;
  public static final int MODE_NONE = 0;
  public static final int MODE_PSK = 2;
  public static final int MODE_WEP = 1;
  private static final Set<String> S_EVENT_MAP = new WifiJsPlugin.2();
  private static final String TAG = "[mini] WifiJsPlugin";
  private boolean hasRegister;
  private WifiManager wifiManager;
  private BroadcastReceiver wifiReceiver = new WifiJsPlugin.1(this);
  
  private int calculateSignalStrength(int paramInt)
  {
    if (paramInt <= -100) {
      return 0;
    }
    if (paramInt >= -50) {
      return 100;
    }
    return (paramInt + 100) * 2;
  }
  
  private JSONObject getWifiInfo(WifiInfo paramWifiInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    label162:
    label167:
    for (;;)
    {
      try
      {
        String str = paramWifiInfo.getSSID();
        if (str == null) {
          break label167;
        }
        str = str.replace("\"", "");
        Iterator localIterator = this.wifiManager.getScanResults().iterator();
        if (!localIterator.hasNext()) {
          break label162;
        }
        ScanResult localScanResult = (ScanResult)localIterator.next();
        if (!localScanResult.SSID.equals(str)) {
          continue;
        }
        bool = isSecurity(localScanResult);
        localJSONObject.put("SSID", str);
        localJSONObject.put("BSSID", paramWifiInfo.getBSSID());
        localJSONObject.put("secure", bool);
        localJSONObject.put("signalStrength", calculateSignalStrength(paramWifiInfo.getRssi()));
      }
      catch (Exception paramWifiInfo)
      {
        try
        {
          paramWifiInfo.put("wifi", localJSONObject);
          return paramWifiInfo;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          return paramWifiInfo;
        }
        paramWifiInfo = paramWifiInfo;
        paramWifiInfo.printStackTrace();
        continue;
      }
      paramWifiInfo = new JSONObject();
      boolean bool = false;
    }
  }
  
  private JSONArray getWifiList()
  {
    localJSONArray = new JSONArray();
    Object localObject = this.wifiManager.getScanResults();
    try
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ScanResult localScanResult = (ScanResult)((Iterator)localObject).next();
        String str1 = localScanResult.SSID;
        String str2 = localScanResult.BSSID;
        boolean bool = isSecurity(localScanResult);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("SSID", str1);
        localJSONObject.put("BSSID", str2);
        localJSONObject.put("secure", bool);
        localJSONObject.put("signalStrength", calculateSignalStrength(localScanResult.level));
        localJSONArray.put(localJSONObject);
      }
      return localJSONArray;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void handlerWifiState(Intent paramIntent)
  {
    NetworkInfo localNetworkInfo = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
    if ((localNetworkInfo != null) && (localNetworkInfo.isConnected()))
    {
      paramIntent = (WifiInfo)paramIntent.getParcelableExtra("wifiInfo");
      if (paramIntent != null)
      {
        paramIntent = getWifiInfo(paramIntent);
        this.jsPluginEngine.appBrandRuntime.evaluateServiceSubcribeJS("onWifiConnected", paramIntent.toString());
      }
    }
  }
  
  private WifiConfiguration isExsits(String paramString)
  {
    Object localObject = this.wifiManager.getConfiguredNetworks();
    if ((localObject == null) || (paramString == null)) {
      return null;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      WifiConfiguration localWifiConfiguration = (WifiConfiguration)((Iterator)localObject).next();
      if ((localWifiConfiguration != null) && (localWifiConfiguration.SSID != null) && (localWifiConfiguration.SSID.equals("\"" + paramString + "\""))) {
        return localWifiConfiguration;
      }
    }
    return null;
  }
  
  private void registerWifiReceiver()
  {
    if ((!this.hasRegister) && (this.wifiReceiver != null))
    {
      Activity localActivity = this.jsPluginEngine.appBrandRuntime.activity;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
      localActivity.registerReceiver(this.wifiReceiver, localIntentFilter);
      this.hasRegister = true;
    }
  }
  
  private void unregisterWifiReceiver()
  {
    if ((this.hasRegister) && (this.wifiReceiver != null))
    {
      this.jsPluginEngine.appBrandRuntime.activity.unregisterReceiver(this.wifiReceiver);
      this.hasRegister = false;
    }
  }
  
  @TargetApi(23)
  public void checkPermission(LocationPermissionListener paramLocationPermissionListener)
  {
    BaseActivity localBaseActivity = this.jsPluginEngine.getActivityContext();
    if ((localBaseActivity instanceof BaseActivity)) {
      ((BaseActivity)localBaseActivity).requestPermissions(new WifiJsPlugin.4(this, paramLocationPermissionListener), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    }
  }
  
  protected WifiConfiguration createWifiInfo(String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    while ((paramInt != 0) && (paramInt != 2) && (paramInt != 1)) {
      return null;
    }
    WifiConfiguration localWifiConfiguration = new WifiConfiguration();
    localWifiConfiguration.allowedAuthAlgorithms.clear();
    localWifiConfiguration.allowedGroupCiphers.clear();
    localWifiConfiguration.allowedKeyManagement.clear();
    localWifiConfiguration.allowedPairwiseCiphers.clear();
    localWifiConfiguration.allowedProtocols.clear();
    localWifiConfiguration.SSID = ("\"" + paramString1 + "\"");
    paramString1 = isExsits(paramString1);
    if (paramString1 != null) {
      this.wifiManager.removeNetwork(paramString1.networkId);
    }
    if (paramInt == 0)
    {
      String[] arrayOfString = localWifiConfiguration.wepKeys;
      if (TextUtils.isEmpty(paramString2))
      {
        paramString1 = "";
        arrayOfString[0] = paramString1;
        localWifiConfiguration.allowedKeyManagement.set(0);
        localWifiConfiguration.wepTxKeyIndex = 0;
      }
    }
    for (;;)
    {
      return localWifiConfiguration;
      paramString1 = "\"" + paramString2 + "\"";
      break;
      if (paramInt == 1)
      {
        localWifiConfiguration.hiddenSSID = true;
        localWifiConfiguration.wepKeys[0] = ("\"" + paramString2 + "\"");
        localWifiConfiguration.allowedAuthAlgorithms.set(1);
        localWifiConfiguration.allowedGroupCiphers.set(3);
        localWifiConfiguration.allowedGroupCiphers.set(2);
        localWifiConfiguration.allowedGroupCiphers.set(0);
        localWifiConfiguration.allowedGroupCiphers.set(1);
        localWifiConfiguration.allowedKeyManagement.set(0);
        localWifiConfiguration.wepTxKeyIndex = 0;
      }
      else if (paramInt == 2)
      {
        localWifiConfiguration.preSharedKey = ("\"" + paramString2 + "\"");
        localWifiConfiguration.hiddenSSID = true;
        localWifiConfiguration.allowedAuthAlgorithms.set(0);
        localWifiConfiguration.allowedGroupCiphers.set(2);
        localWifiConfiguration.allowedKeyManagement.set(1);
        localWifiConfiguration.allowedPairwiseCiphers.set(1);
        localWifiConfiguration.allowedGroupCiphers.set(3);
        localWifiConfiguration.allowedPairwiseCiphers.set(2);
        localWifiConfiguration.status = 2;
      }
    }
  }
  
  public int getSecurityMode(ScanResult paramScanResult)
  {
    paramScanResult = paramScanResult.capabilities;
    if (paramScanResult.contains("WEP")) {
      return 1;
    }
    if (paramScanResult.contains("PSK")) {
      return 2;
    }
    if (paramScanResult.contains("EAP")) {
      return 3;
    }
    return 0;
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("[mini] WifiJsPlugin", 2, "handleNativeRequest: " + paramString1 + " |jsonParams: " + paramString2 + " |callbackId:" + paramInt);
    if (this.jsPluginEngine == null) {
      return "";
    }
    Object localObject1 = this.jsPluginEngine.getActivityContext();
    if (localObject1 == null) {
      return "";
    }
    if ("stopWifi".equals(paramString1)) {
      if (this.wifiManager != null)
      {
        this.wifiManager = null;
        localObject1 = new JSONObject();
      }
    }
    Object localObject2;
    do
    {
      for (;;)
      {
        try
        {
          ((JSONObject)localObject1).put("errCode", 0);
          this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, (JSONObject)localObject1, paramInt);
          unregisterWifiReceiver();
          return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
        }
        catch (JSONException localJSONException2)
        {
          localJSONException2.printStackTrace();
          continue;
        }
        localObject1 = new JSONObject();
        try
        {
          ((JSONObject)localObject1).put("errCode", 12000);
          this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, ":not invoke startWifi", paramInt);
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            localJSONException1.printStackTrace();
          }
        }
        if ("startWifi".equals(paramString1))
        {
          if (Build.VERSION.SDK_INT >= 23)
          {
            if (localJSONException1.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0)
            {
              this.wifiManager = ((WifiManager)localJSONException1.getApplicationContext().getSystemService("wifi"));
              localObject2 = new JSONObject();
              try
              {
                ((JSONObject)localObject2).put("errCode", 0);
                this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, (JSONObject)localObject2, paramInt);
                registerWifiReceiver();
              }
              catch (JSONException localJSONException3)
              {
                for (;;)
                {
                  localJSONException3.printStackTrace();
                }
              }
            }
            else
            {
              checkPermission(new WifiJsPlugin.3(this, (Context)localObject2, paramJsRuntime, paramString1, paramInt));
              return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
            }
          }
          else
          {
            this.wifiManager = ((WifiManager)((Context)localObject2).getApplicationContext().getSystemService("wifi"));
            localObject2 = new JSONObject();
            try
            {
              ((JSONObject)localObject2).put("errCode", 0);
              this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, (JSONObject)localObject2, paramInt);
              registerWifiReceiver();
            }
            catch (JSONException localJSONException4)
            {
              for (;;)
              {
                localJSONException4.printStackTrace();
              }
            }
          }
        }
        else if ("getWifiList".equals(paramString1))
        {
          if (this.wifiManager != null)
          {
            if (this.wifiManager.isWifiEnabled())
            {
              JSONArray localJSONArray = getWifiList();
              localObject2 = new JSONObject();
              JSONObject localJSONObject = new JSONObject();
              try
              {
                ((JSONObject)localObject2).put("wifiList", localJSONArray);
                localJSONObject.put("errCode", 0);
                this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, localJSONObject, paramInt);
                this.jsPluginEngine.appBrandRuntime.evaluateServiceSubcribeJS("onGetWifiList", ((JSONObject)localObject2).toString());
              }
              catch (JSONException localJSONException10)
              {
                for (;;)
                {
                  localJSONException10.printStackTrace();
                }
              }
            }
            else
            {
              localObject2 = new JSONObject();
              try
              {
                ((JSONObject)localObject2).put("errCode", 12005);
                this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, (JSONObject)localObject2, ":wifi is disable", paramInt);
              }
              catch (JSONException localJSONException5)
              {
                for (;;)
                {
                  localJSONException5.printStackTrace();
                }
              }
            }
          }
          else
          {
            localObject2 = new JSONObject();
            try
            {
              ((JSONObject)localObject2).put("errCode", 12000);
              this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, (JSONObject)localObject2, ":not invoke startWifi", paramInt);
            }
            catch (JSONException localJSONException6)
            {
              for (;;)
              {
                localJSONException6.printStackTrace();
              }
            }
          }
        }
        else if ("getConnectedWifi".equals(paramString1))
        {
          if (this.wifiManager != null)
          {
            if (this.wifiManager.isWifiEnabled())
            {
              localObject2 = getWifiInfo(alkz.a(this.wifiManager));
              try
              {
                ((JSONObject)localObject2).put("errCode", 0);
                this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, (JSONObject)localObject2, paramInt);
              }
              catch (JSONException localJSONException7)
              {
                for (;;)
                {
                  localJSONException7.printStackTrace();
                }
              }
            }
            localObject2 = new JSONObject();
            try
            {
              ((JSONObject)localObject2).put("errCode", 12005);
              this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, (JSONObject)localObject2, ":wifi is disable", paramInt);
            }
            catch (JSONException localJSONException8)
            {
              for (;;)
              {
                localJSONException8.printStackTrace();
              }
            }
          }
          localObject2 = new JSONObject();
          try
          {
            ((JSONObject)localObject2).put("errCode", 12000);
            this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, (JSONObject)localObject2, ":not invoke startWifi", paramInt);
          }
          catch (JSONException localJSONException9)
          {
            for (;;)
            {
              localJSONException9.printStackTrace();
            }
          }
        }
      }
    } while (!"connectWifi".equals(paramString1));
    if (this.wifiManager != null) {
      if (!this.wifiManager.isWifiEnabled()) {}
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject(paramString2);
        if (localObject2 == null) {
          break label993;
        }
        String str = ((JSONObject)localObject2).optString("SSID");
        ((JSONObject)localObject2).optString("BSSID");
        localObject2 = ((JSONObject)localObject2).optString("password");
        Iterator localIterator = this.wifiManager.getScanResults().iterator();
        if (!localIterator.hasNext()) {
          break label1047;
        }
        ScanResult localScanResult = (ScanResult)localIterator.next();
        if (!localScanResult.SSID.equals(str)) {
          continue;
        }
        i = getSecurityMode(localScanResult);
        localObject2 = createWifiInfo(str, (String)localObject2, i);
        if (localObject2 != null)
        {
          i = this.wifiManager.addNetwork((WifiConfiguration)localObject2);
          if (i != -1) {
            this.wifiManager.enableNetwork(i, true);
          }
          this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        Object localObject3 = null;
        continue;
        this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, ":invalid network id", paramInt);
      }
      break;
      label993:
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, ":invalid data", paramInt);
      break;
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, ":wifi is disable", paramInt);
      break;
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, ":not invoke startWifi", paramInt);
      break;
      label1047:
      int i = 0;
    }
  }
  
  public boolean isSecurity(ScanResult paramScanResult)
  {
    return getSecurityMode(paramScanResult) > 1;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    unregisterWifiReceiver();
    this.wifiReceiver = null;
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
  
  public static abstract interface LocationPermissionListener
  {
    public abstract void onExecute(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.WifiJsPlugin
 * JD-Core Version:    0.7.0.1
 */