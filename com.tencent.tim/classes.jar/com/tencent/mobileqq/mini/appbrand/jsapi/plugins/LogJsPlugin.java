package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.sdk.BridgeInfo;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class LogJsPlugin
  extends BaseJsPlugin
{
  public static final String API_SET_ENABLE_DEBUG = "setEnableDebug";
  private static final Set<String> S_EVENT_MAP = new LogJsPlugin.1();
  public static final String TAG = "[mini] LogJsPlugin";
  private static final String TAG_MINI_LOG = "miniAppLog";
  private Activity mActivity;
  
  private void appendMiniLogToNative(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("miniAppLog", 2, getAppId() + "|" + paramString);
    }
  }
  
  public static String getDebugConfig(String paramString, boolean paramBoolean)
  {
    try
    {
      paramString = new JSONObject(paramString);
      paramString.put("debug", paramBoolean);
      paramString = paramString.toString().replaceAll("\\\\", "");
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  private void handleEnableDebug(String paramString1, String paramString2, BridgeInfo paramBridgeInfo)
  {
    try
    {
      boolean bool = new JSONObject(paramString2).optBoolean("enableDebug");
      if ((this.jsPluginEngine != null) && (this.jsPluginEngine.appBrandRuntime != null) && (this.jsPluginEngine.appBrandRuntime.getApkgInfo() != null))
      {
        if (bool != Boolean.valueOf(StorageUtil.getPreference().getBoolean(this.jsPluginEngine.appBrandRuntime.appId + "_debug", false)).booleanValue())
        {
          AppBrandTask.runTaskOnUiThread(new LogJsPlugin.2(this, bool));
          return;
        }
        this.jsPluginEngine.callbackJsEventOK(paramBridgeInfo.getWebView(), paramString1, null, paramBridgeInfo.callbackId);
        return;
      }
    }
    catch (JSONException paramString2)
    {
      handleNativeResponseFail(paramString1, paramBridgeInfo);
    }
  }
  
  private void handleNativeResponseFail(String paramString, BridgeInfo paramBridgeInfo)
  {
    if ((this.jsPluginEngine != null) && (paramBridgeInfo != null)) {
      this.jsPluginEngine.callbackJsEventFail(paramBridgeInfo.getWebView(), paramString, null, paramBridgeInfo.callbackId);
    }
  }
  
  private void handleNativeResponseOk(String paramString, BridgeInfo paramBridgeInfo)
  {
    if ((this.jsPluginEngine != null) && (paramBridgeInfo != null)) {
      this.jsPluginEngine.callbackJsEventOK(paramBridgeInfo.getWebView(), paramString, null, paramBridgeInfo.callbackId);
    }
  }
  
  @NonNull
  private BridgeInfo wrapBridge(JsRuntime paramJsRuntime, int paramInt)
  {
    return new BridgeInfo(paramJsRuntime, paramInt);
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    BridgeInfo localBridgeInfo = wrapBridge(paramJsRuntime, paramInt);
    if ("setEnableDebug".equals(paramString1)) {
      handleEnableDebug(paramString1, paramString2, localBridgeInfo);
    }
    return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
    this.mActivity = paramBaseJsPluginEngine.getActivityContext();
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.LogJsPlugin
 * JD-Core Version:    0.7.0.1
 */