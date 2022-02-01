package com.tencent.mobileqq.mini.appbrand.page;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import aqiw;
import aqnm;
import avpq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.OnLoadServiceWebvieJsListener;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniAppWebSocket
  extends BaseMiniWebSocket
{
  public static final String TAG = "ServiceRemoteRuntime";
  private AppBrandServiceEventInterface appBrandEventInterface;
  private AtomicInteger count = new AtomicInteger();
  private boolean hasEnterRoom;
  private boolean hasSetupContext;
  private boolean hasSetupContextResult;
  public Map<Long, ValueCallback> jsCallBackMap = new HashMap();
  private ApkgInfo mApkgInfo;
  private ConcurrentLinkedQueue<EvaluateData> mEvaluateDatas = new ConcurrentLinkedQueue();
  private AbstactJsRuntime mJsRutime;
  private AppBrandRuntime.OnLoadServiceWebvieJsListener mServiceInitFinishListener;
  private AtomicInteger pingcount = new AtomicInteger();
  private AtomicInteger scriptId = new AtomicInteger();
  private boolean startPing;
  
  public MiniAppWebSocket(Handler paramHandler, AbstactJsRuntime paramAbstactJsRuntime)
  {
    this.mThreadHandler = paramHandler;
    this.mJsRutime = paramAbstactJsRuntime;
    this.mListener = new MiniAppWebSocket.1(this);
  }
  
  public void evaluateJs(String paramString, ValueCallback paramValueCallback)
  {
    if (this.hasSetupContextResult)
    {
      while (!this.mEvaluateDatas.isEmpty())
      {
        EvaluateData localEvaluateData = (EvaluateData)this.mEvaluateDatas.poll();
        if (localEvaluateData != null) {
          evaluateJsEx(localEvaluateData.js, localEvaluateData.valueCallback);
        }
      }
      evaluateJsEx(paramString, paramValueCallback);
      return;
    }
    this.mEvaluateDatas.add(new EvaluateData(paramString, paramValueCallback));
  }
  
  public void evaluateJsEx(String paramString, ValueCallback paramValueCallback)
  {
    long l = getScriptId();
    sendStringMessage(getSendCmdString("DebugMessageClient", "evaluateJavascript", getEvaluateSCriptData(paramString, l)));
    if (paramValueCallback != null) {
      this.jsCallBackMap.put(Long.valueOf(l), paramValueCallback);
    }
  }
  
  public JSONObject getCallInterfaceResultData(long paramLong, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("call_id", paramLong);
      if (TextUtils.isEmpty(paramString))
      {
        localJSONObject.put("ret", "{}");
        return localJSONObject;
      }
      localJSONObject.put("ret", paramString);
      return localJSONObject;
    }
    catch (Exception paramString)
    {
      QLog.e("ServiceRemoteRuntime", 1, "getCallInterfaceResultData error:" + paramString);
    }
    return null;
  }
  
  public String getDefaultConfigScript()
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("appId", this.mApkgInfo.appId);
      localJSONObject1.put("icon", this.mApkgInfo.iconUrl);
      localJSONObject1.put("nickname", "testuser");
      JSONObject localJSONObject2 = new JSONObject(this.mApkgInfo.mConfigStr);
      localJSONObject2.put("appContactInfo", new JSONObject("{'operationInfo':{'jsonInfo':{'apiAvailable':{'navigateToMiniProgramConfig':0,'shareCustomImageUrl':1,'authorize':0,'navigateToMiniProgram':1,'getUserInfo':0,'openSetting':0}}}}"));
      localJSONObject2.remove("preload");
      String str2 = "release";
      String str1 = str2;
      if (this.mApkgInfo.appConfig != null)
      {
        str1 = str2;
        if (this.mApkgInfo.appConfig.config != null) {
          str1 = this.mApkgInfo.appConfig.config.getVerTypeStr();
        }
      }
      str2 = String.format("function extend(obj, src) {\n    for (var key in src) {\n        if (src.hasOwnProperty(key)) obj[key] = src[key];\n    }\n    return obj;\n}\nif (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig = JSON.parse('%1$s'); __qqConfig = extend(__qqConfig, __tempConfig);__qqConfig.accountInfo=JSON.parse('%2$s'); __qqConfig.envVersion='" + str1 + "';__qqConfig.QUA='" + avpq.getQUA3() + "';var __wxIndexPage = 'page/index/index.html';", new Object[] { localJSONObject2.toString(), localJSONObject1.toString() });
      str1 = str2;
      if (Boolean.valueOf(StorageUtil.getPreference().getBoolean(this.mApkgInfo.appId + "_debug", false)).booleanValue()) {
        str1 = str2 + "__qqConfig.debug =true;";
      }
      str1 = str1 + "if (typeof WeixinJSBridge != 'undefined' && typeof WeixinJSBridge.subscribeHandler == 'function') {WeixinJSBridge.subscribeHandler('onWxConfigReady')};";
      return str1;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public JSONObject getDeviceInfo()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("device_name", Build.DEVICE);
      localJSONObject.put("device_model", Build.MODEL);
      localJSONObject.put("os", Build.VERSION.SDK_INT);
      localJSONObject.put("qq_version", "3.4.4");
      localJSONObject.put("pixel_ratio", "3");
      localJSONObject.put("screen_width", aqnm.getScreenWidth());
      localJSONObject.put("publib", AppLoaderFactory.getAppLoaderManager().getBaseLibInfo().baseLibVersion);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      QLog.e("ServiceRemoteRuntime", 1, "getDeviceInfo error:" + localException);
    }
    return null;
  }
  
  public JSONObject getDomEventData(String paramString, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("params", paramString);
      localJSONObject.put("webview_id", paramInt);
      return localJSONObject;
    }
    catch (Exception paramString)
    {
      QLog.e("ServiceRemoteRuntime", 1, "getDomEventData error:" + paramString);
    }
    return null;
  }
  
  public JSONObject getEvaluateSCriptData(String paramString, long paramLong)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("script", paramString);
      localJSONObject.put("evaluate_id", paramLong);
      return localJSONObject;
    }
    catch (Exception paramString)
    {
      QLog.e("ServiceRemoteRuntime", 1, "getEvaluateSCriptData error:" + paramString);
    }
    return null;
  }
  
  public JSONObject getMethodObject(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("method_name", paramString1);
      paramString1 = new JSONArray();
      paramString1.put(paramString2);
      paramString1.put(paramString3);
      paramString1.put(paramString4);
      localJSONObject.put("obj_methods", paramString1);
      return localJSONObject;
    }
    catch (Exception paramString1)
    {
      QLog.e("ServiceRemoteRuntime", 1, "getMethodObject error:" + paramString1);
    }
    return null;
  }
  
  int getNetworkType()
  {
    int i = aqiw.getNetworkType(BaseApplicationImpl.getContext());
    if (i == 5) {
      return 1;
    }
    if (i == 1) {
      return 5;
    }
    if ((i == 2) || (i == 3) || (i == 4)) {
      return i;
    }
    return 0;
  }
  
  public int getPingCount()
  {
    return this.pingcount.incrementAndGet();
  }
  
  public int getScriptId()
  {
    return this.scriptId.incrementAndGet();
  }
  
  public String getSendCmdString(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("seq", getSeq());
      localJSONObject.put("category", paramString2);
      localJSONObject.put("data", paramJSONObject);
      localJSONObject.put("compress_algo", 0);
      localJSONObject.put("original_size", 0);
      localJSONObject.put("delay", 0);
      paramString2 = new JSONArray();
      paramString2.put(localJSONObject);
      paramJSONObject = new JSONObject();
      paramJSONObject.put("debug_message", paramString2);
      paramString2 = new JSONObject();
      paramString2.put("cmd", paramString1);
      paramString2.put("data", paramJSONObject);
      paramString1 = paramString2.toString();
      return paramString1;
    }
    catch (Exception paramString1)
    {
      QLog.e("ServiceRemoteRuntime", 1, "send Cmd error: " + paramString1);
    }
    return "";
  }
  
  public int getSeq()
  {
    return this.count.incrementAndGet();
  }
  
  public JSONObject getSetupContexData()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("configure_js", getDefaultConfigScript());
      localJSONObject.put("device_info", getDeviceInfo());
      localJSONObject.put("support_compress_algo", 0);
      localJSONObject.put("publib_ver", this.mApkgInfo.appConfig.baseLibInfo.baseLibVersion);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      QLog.e("ServiceRemoteRuntime", 1, "getSetupContexData error:" + localException);
    }
    return null;
  }
  
  public void sendArkCmd(long paramLong)
  {
    sendStringMessage("{\"cmd\":\"DebugArkClient\",\"data\":{\"ark_message\":[{\"ark\":" + paramLong + "}]}}");
  }
  
  public void sendCallInterfaceResultCmd(long paramLong, String paramString)
  {
    sendStringMessage(getSendCmdString("DebugMessageClient", "callInterfaceResult", getCallInterfaceResultData(paramLong, paramString)));
  }
  
  public void sendDomEvent(String paramString, int paramInt)
  {
    sendStringMessage(getSendCmdString("DebugMessageClient", "domEvent", getDomEventData(paramString, paramInt)));
  }
  
  public void sendPingCmd(long paramLong)
  {
    sendStringMessage("{ \"cmd\": \"DebugPong\", \"data\": { \"ping_id\": " + paramLong + " }}");
  }
  
  public void sendPongCmd(long paramLong)
  {
    sendStringMessage("{ \"cmd\": \"DebugPong\", \"data\": { \"ping_id\": " + paramLong + ",\"network_type\":" + getNetworkType() + " }}");
  }
  
  public void sendSetupContextCmd(AppBrandRuntime.OnLoadServiceWebvieJsListener paramOnLoadServiceWebvieJsListener)
  {
    if ((this.mApkgInfo != null) && (this.hasEnterRoom))
    {
      if (!this.hasSetupContext)
      {
        sendStringMessage(getSendCmdString("DebugMessageClient", "setupContext", getSetupContexData()));
        this.hasSetupContext = true;
      }
      if (paramOnLoadServiceWebvieJsListener != null)
      {
        this.mServiceInitFinishListener = paramOnLoadServiceWebvieJsListener;
        if ((this.hasSetupContextResult) && (this.mServiceInitFinishListener != null)) {
          this.mServiceInitFinishListener.onLoadFinish();
        }
      }
      return;
    }
    this.mServiceInitFinishListener = paramOnLoadServiceWebvieJsListener;
  }
  
  public void setApkgInfo(ApkgInfo paramApkgInfo)
  {
    this.mApkgInfo = paramApkgInfo;
  }
  
  public void setAppBrandEventInterface(AppBrandServiceEventInterface paramAppBrandServiceEventInterface)
  {
    this.appBrandEventInterface = paramAppBrandServiceEventInterface;
  }
  
  public class EvaluateData
  {
    public String js;
    public ValueCallback valueCallback;
    
    public EvaluateData(String paramString, ValueCallback paramValueCallback)
    {
      this.js = paramString;
      this.valueCallback = paramValueCallback;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.MiniAppWebSocket
 * JD-Core Version:    0.7.0.1
 */