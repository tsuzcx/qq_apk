package com.tencent.qqmini.miniapp.core.service;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.qqmini.miniapp.core.model.EmbeddedState;
import com.tencent.qqmini.miniapp.core.worker.MiniWorkerInterface;
import com.tencent.qqmini.miniapp.util.AppBrandUtil;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class AppBrandWebviewService
  extends AbsAppBrandService
{
  protected static final String JS_INTERFACE_NAME = "WeixinJSCore";
  protected static final String TAG = "AppBrandWebviewService";
  private ServiceEventListener mAppBrandEventInterface;
  private EmbeddedState mEmbeddedState = null;
  private WebView mWebView;
  
  public AppBrandWebviewService(IMiniAppContext paramIMiniAppContext, ServiceEventListener paramServiceEventListener)
  {
    super(paramIMiniAppContext);
    setAppBrandEventInterface(paramServiceEventListener);
    this.mWebView = new WebView(paramIMiniAppContext.getContext());
    this.mWebView.addJavascriptInterface(this, "WeixinJSCore");
    this.mWebView.addJavascriptInterface(new MiniWorkerInterface(this.miniAppContext), "WeixinWorker");
    paramIMiniAppContext = this.mWebView.getSettings();
    paramIMiniAppContext.setSupportZoom(false);
    paramIMiniAppContext.setJavaScriptEnabled(true);
    paramIMiniAppContext.setCacheMode(2);
    this.mWebView.setWebChromeClient(new AppBrandWebviewService.1(this));
    sendEvent(Integer.valueOf(3));
  }
  
  public static int[] jsStringToJavaIntArray(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {
      return new int[0];
    }
    paramString = paramString.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
    int[] arrayOfInt = new int[paramString.length];
    for (;;)
    {
      if (i < paramString.length) {}
      try
      {
        arrayOfInt[i] = Integer.parseInt(paramString[i]);
        label61:
        i += 1;
        continue;
        return arrayOfInt;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label61;
      }
    }
  }
  
  public void evaluateCallbackJs(int paramInt, String paramString)
  {
    evaluateJs(String.format("WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[] { Integer.valueOf(paramInt), paramString }), null);
  }
  
  public void evaluateJs(String paramString, ValueCallback paramValueCallback)
  {
    evaluateJs(paramString, paramValueCallback, null);
  }
  
  public void evaluateJs(String paramString1, ValueCallback paramValueCallback, String paramString2)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      if (this.mWebView != null) {
        this.mWebView.evaluateJavascript(paramString1, AppBrandUtil.convertValueCallback(paramValueCallback));
      }
      return;
    }
    this.mMainHandler.post(new AppBrandWebviewService.2(this, paramString1, paramValueCallback));
  }
  
  public void evaluateSubscribeJS(String paramString1, String paramString2, int paramInt)
  {
    QMLog.d("AppBrandWebviewService", "evaluateSubscribeJS  eventName=" + paramString1);
    paramString1 = "WeixinJSBridge.subscribeHandler(\"" + paramString1 + "\"," + paramString2 + "," + paramInt + "," + 0 + ")";
    if (!isStateSucc())
    {
      QMLog.e("AppBrandWebviewService", "Service is not completd! Add to waiting list");
      addWaitEvaluateJs(paramString1);
      return;
    }
    evaluateJs(paramString1, null);
  }
  
  public String getJSGlobalConfig(ApkgInfo paramApkgInfo)
  {
    if (paramApkgInfo == null) {
      return "";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", paramApkgInfo.appId);
      localJSONObject.put("icon", paramApkgInfo.iconUrl);
      localJSONObject.put("nickname", "testuser");
      String str2 = "release";
      String str1 = "";
      if (paramApkgInfo.mMiniAppInfo != null)
      {
        str2 = paramApkgInfo.mMiniAppInfo.getVerTypeStr();
        str1 = paramApkgInfo.mMiniAppInfo.version;
      }
      str2 = String.format("if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig=%1$s;  __qqConfig = extend(__qqConfig, __tempConfig);__qqConfig.accountInfo=JSON.parse('%2$s');  __qqConfig.envVersion='" + str2 + "'; __qqConfig.deviceinfo='" + QUAUtil.getSimpleDeviceInfo(AppLoaderFactory.g().getMiniAppEnv().getContext()) + "'; __qqConfig.miniapp_version='" + str1 + "';", new Object[] { paramApkgInfo.mConfigStr, localJSONObject.toString() });
      str1 = str2;
      if (StorageUtil.getPreference().getBoolean(paramApkgInfo.appId + "_debug", false)) {
        str1 = str2 + "__qqConfig.debug=true;";
      }
      paramApkgInfo = str1;
      if (this.mEmbeddedState != null)
      {
        paramApkgInfo = str1 + "__qqConfig.useXWebVideo=" + this.mEmbeddedState.isEnableEmbeddedVideo() + ";";
        QMLog.d("miniapp-embedded", "system service enableEmbeddedVideo : " + this.mEmbeddedState.isEnableEmbeddedVideo());
        paramApkgInfo = paramApkgInfo + "__qqConfig.useXWebLive=" + this.mEmbeddedState.isEnableEmbeddedLive() + ";";
        QMLog.d("miniapp-embedded", "system service enableEmbeddedLive : " + this.mEmbeddedState.isEnableEmbeddedLive());
      }
      return paramApkgInfo + "if (typeof WeixinJSBridge != 'undefined' && typeof WeixinJSBridge.subscribeHandler == 'function') {WeixinJSBridge.subscribeHandler('onWxConfigReady')};";
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public String getJsDefaultConfig(boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("USER_DATA_PATH", "qqfile://usr");
      localJSONObject.put("env", localObject);
      localJSONObject.put("preload", paramBoolean);
      int i = WnsConfig.getConfig("qqminiapp", "xprof_api_report", 0);
      StringBuilder localStringBuilder = new StringBuilder().append("function extend(obj, src) {\n    for (var key in src) {\n        if (src.hasOwnProperty(key)) obj[key] = src[key];\n    }\n    return obj;\n}\nvar window = window || {}; window.__webview_engine_version__ = 0.02; if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig = JSON.parse('%1$s');__qqConfig = extend(__qqConfig, __tempConfig);__qqConfig.appContactInfo = {};__qqConfig.appContactInfo.operationInfo = {};__qqConfig.appContactInfo.operationInfo.jsonInfo = {};__qqConfig.appContactInfo.operationInfo.jsonInfo.apiAvailable = {'navigateToMiniProgramConfig':0,'shareCustomImageUrl':1,'share':0,'authorize':0,'navigateToMiniProgram':1,'getUserInfo':0,'openSetting':0};__qqConfig.platform = 'android';__qqConfig.QUA='").append(QUAUtil.getPlatformQUA()).append("';__qqConfig.frameworkInfo = {};__qqConfig.frameworkInfo.isAlpha=");
      if (i == 0) {}
      for (localObject = "false";; localObject = "true")
      {
        localObject = String.format((String)localObject + ";", new Object[] { localJSONObject });
        QMLog.d("minisdk-start", "getJsDefaultConfig ServiceWebview String: " + (String)localObject);
        return localObject;
      }
      return "";
    }
    catch (Exception localException)
    {
      QMLog.d("minisdk-start", "getJsDefaultConfig failed: " + localException);
    }
  }
  
  public int getStatus()
  {
    return 0;
  }
  
  public void initBaseJs(BaselibLoader.BaselibContent paramBaselibContent)
  {
    setDefaultConfigJs(getJsDefaultConfig(true));
    setWaServiceJS(paramBaselibContent.waServiceJsStr, paramBaselibContent.waServicePath);
  }
  
  public void initEmbeddedState(EmbeddedState paramEmbeddedState)
  {
    this.mEmbeddedState = paramEmbeddedState;
  }
  
  @JavascriptInterface
  public String invokeHandler(String paramString1, String paramString2, int paramInt)
  {
    QMLog.d("AppBrandWebviewService", "invokeHandler|service: " + paramString1 + " |id:" + paramInt);
    if (this.mAppBrandEventInterface != null) {
      return this.mAppBrandEventInterface.onServiceNativeRequest(paramString1, paramString2, paramInt);
    }
    return "";
  }
  
  @JavascriptInterface
  public void publishHandler(String paramString1, String paramString2, String paramString3)
  {
    QMLog.d("AppBrandWebviewService", "publishHandler|service: " + paramString1 + " |webviewIds:" + paramString3);
    String str = paramString3;
    if ("[]".equals(paramString3)) {
      str = "";
    }
    if (this.mAppBrandEventInterface != null) {
      this.mAppBrandEventInterface.onServiceEvent(paramString1, paramString2, jsStringToJavaIntArray(str));
    }
  }
  
  public void setApkgInfo(ApkgInfo paramApkgInfo)
  {
    if (paramApkgInfo == null) {
      return;
    }
    setGlobalConfigJs(getJSGlobalConfig(paramApkgInfo));
    String str = "";
    try
    {
      paramApkgInfo = FileUtils.readFileToString(new File(paramApkgInfo.getAppServiceJsPath()));
      setAppServiceJs(paramApkgInfo);
      return;
    }
    catch (IOException paramApkgInfo)
    {
      for (;;)
      {
        paramApkgInfo.printStackTrace();
        paramApkgInfo = str;
      }
    }
  }
  
  public void setAppBrandEventInterface(ServiceEventListener paramServiceEventListener)
  {
    this.mAppBrandEventInterface = paramServiceEventListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.service.AppBrandWebviewService
 * JD-Core Version:    0.7.0.1
 */