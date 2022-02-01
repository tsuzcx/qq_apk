package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import aqiw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.network.RequestStrategy;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import org.json.JSONObject;

public class NetworkJsPlugin
  extends BaseJsPlugin
{
  private static final Set<String> S_EVENT_MAP = new NetworkJsPlugin.1();
  private static final String TAG = "[mini] NetworkJsPlugin";
  private String mLastNetworkType = "";
  private NetInfoHandler mNetEventHandle;
  
  public NetworkJsPlugin()
  {
    if (this.mNetEventHandle == null)
    {
      this.mNetEventHandle = new NetInfoHandler();
      AppNetConnInfo.registerNetChangeReceiver(BaseApplicationImpl.getContext(), this.mNetEventHandle);
    }
  }
  
  private void callBackStatusChange(JSONObject paramJSONObject)
  {
    if ((this.jsPluginEngine.getServiceRuntime() != null) && (paramJSONObject != null) && (paramJSONObject.has("networkType")) && (!this.mLastNetworkType.equals(paramJSONObject.optString("networkType"))))
    {
      this.mLastNetworkType = paramJSONObject.optString("networkType");
      this.jsPluginEngine.getServiceRuntime().evaluateSubcribeJS("onNetworkStatusChange", paramJSONObject.toString(), 0);
    }
  }
  
  private String getCurrentType()
  {
    if (this.jsPluginEngine.getServiceRuntime() != null)
    {
      switch (aqiw.getSystemNetwork(this.jsPluginEngine.getServiceRuntime().getContextEx()))
      {
      default: 
        return "unknown";
      case 0: 
        return "none";
      case 2: 
        return "2g";
      case 3: 
        return "3g";
      case 4: 
        return "4g";
      }
      return "wifi";
    }
    return "unknown";
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("[mini] NetworkJsPlugin", 2, "handleNativeRequest: " + paramString1 + " |jsonParams: " + paramString2 + " |callbackId:" + paramInt);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("networkType", getCurrentType());
      this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, localJSONObject, paramInt);
      return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
    }
    catch (Throwable paramString2)
    {
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
      paramString2.printStackTrace();
    }
    return "";
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mNetEventHandle != null)
    {
      AppNetConnInfo.unregisterNetEventHandler(this.mNetEventHandle);
      this.mNetEventHandle = null;
    }
    this.mLastNetworkType = "";
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
  
  public class NetInfoHandler
    implements INetEventHandler
  {
    public NetInfoHandler() {}
    
    public void onNetChangeEvent(boolean paramBoolean)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        String str = NetworkJsPlugin.this.getCurrentType();
        localJSONObject.put("networkType", str);
        if ("none".equals(str)) {
          localJSONObject.put("isConnected", false);
        }
        for (;;)
        {
          NetworkJsPlugin.this.callBackStatusChange(localJSONObject);
          RequestStrategy.g.notifyNetWorkStatusChange();
          return;
          localJSONObject.put("isConnected", true);
        }
        return;
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.NetworkJsPlugin
 * JD-Core Version:    0.7.0.1
 */