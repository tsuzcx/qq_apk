package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import aqgz;
import aqiw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.network.http.RequestTask.Request;
import com.tencent.mobileqq.mini.network.websocket.WebsocketRequestTask;
import com.tencent.mobileqq.mini.network.websocket.WebsocketRequestTask.RequestParam;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.util.JSONUtil;
import com.tencent.mobileqq.mini.utils.TroopApplicationListUtil;
import com.tencent.mobileqq.mini.utils.TroopApplicationListUtil.JsPluginParam;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.utils.NativeBuffer;
import com.tencent.mobileqq.triton.sdk.bridge.ITNativeBufferPool;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.json.JSONException;
import org.json.JSONObject;

public class RequestPlugin
  extends BaseJsPlugin
{
  private static final String CREATE_REQUEST_TASK = "createRequestTask";
  private static final String CREATE_SOCKET_TASK = "createSocketTask";
  private static final int MAX_SUPPORT_SOCKET_CONNECTION_SIZE = 2;
  private static final String OPERATE_REQUEST_TASK = "operateRequestTask";
  private static final String OPERATE_SOCKET_TASK = "operateSocketTask";
  private static final String STATE_COMPLETE = "complete";
  private static final String STATE_FAIL = "fail";
  private static final String STATE_OK = "ok";
  private static final Set<String> S_EVENT_MAP = new RequestPlugin.1();
  private static final String TAG = "[mini] http.RequestPlugin";
  private static final String WNS_ADD_GROUP_APP = "addGroupApp";
  private static final String WNS_CGI_REQUEST = "wnsCgiRequest";
  private static final String WNS_GET_GROUP_APP_STATUS = "getGroupAppStatus";
  private static final String WNS_GROUP_REQUEST = "wnsGroupRequest";
  private int callbackId;
  private String event;
  private byte[] lock = new byte[0];
  private WeakReference<BaseJsPluginEngine> mEngineRef;
  private JsRuntime mJsRuntime;
  private ConcurrentHashMap<Integer, RequestTask.Request> requestMap = new ConcurrentHashMap();
  private SparseArray<WebsocketRequestTask> socketTaskList = new SparseArray();
  private String ua;
  
  private void callback(JsRuntime paramJsRuntime, JSONObject paramJSONObject, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder;
    if (paramJsRuntime != null)
    {
      localStringBuilder = new StringBuilder().append(paramString1).append(":").append(paramString2);
      if (!TextUtils.isEmpty(paramString3)) {
        break label104;
      }
    }
    label104:
    for (paramString1 = "";; paramString1 = " " + paramString3)
    {
      paramJSONObject = JSONUtil.append(paramJSONObject, "errMsg", paramString1).toString();
      paramJsRuntime.evaluateCallbackJs(paramInt, paramJSONObject);
      if (!"fail".equals(paramString2)) {
        break;
      }
      QLog.e("[mini] http.RequestPlugin", 1, "[callbackFail] " + paramJSONObject);
      return;
    }
    QLog.i("[mini] http.RequestPlugin", 1, "[callback] " + paramJSONObject);
  }
  
  private void callbackComplete(JsRuntime paramJsRuntime, JSONObject paramJSONObject, int paramInt, String paramString)
  {
    callback(paramJsRuntime, paramJSONObject, paramInt, paramString, "complete", null);
  }
  
  private void callbackFail(JsRuntime paramJsRuntime, JSONObject paramJSONObject, int paramInt, String paramString)
  {
    callback(paramJsRuntime, paramJSONObject, paramInt, paramString, "fail", null);
  }
  
  private void callbackFail(JsRuntime paramJsRuntime, JSONObject paramJSONObject, int paramInt, String paramString1, String paramString2)
  {
    callback(paramJsRuntime, paramJSONObject, paramInt, paramString1, "fail", paramString2);
  }
  
  private void callbackOK(JsRuntime paramJsRuntime, JSONObject paramJSONObject, int paramInt, String paramString)
  {
    callback(paramJsRuntime, paramJSONObject, paramInt, paramString, "ok", null);
  }
  
  private String constructUA(String paramString, boolean paramBoolean)
  {
    int i = 0;
    Object localObject = paramString;
    String str;
    if (paramBoolean) {
      str = "";
    }
    for (;;)
    {
      try
      {
        int j = paramString.indexOf("(Linux;");
        int k = paramString.indexOf(")", j);
        localObject = str;
        if (j > 0)
        {
          localObject = str;
          if (k > j) {
            localObject = paramString.substring(j, k + 1);
          }
        }
        localObject = "Mozilla/5.0 " + (String)localObject + " AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/68.0.3440.91 Mobile Safari/537.36";
        paramString = new StringBuilder();
        j = ((String)localObject).length();
        if (i < j)
        {
          char c = ((String)localObject).charAt(i);
          if ((c <= '\037') || (c >= '')) {
            paramString.append(String.format("\\u%04x", new Object[] { Integer.valueOf(c) }));
          } else {
            paramString.append(c);
          }
        }
      }
      catch (Throwable paramString)
      {
        return "Mozilla/5.0 (Linux; Android 9; V1821A Build/PKQ1.181016.001; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/68.0.3440.91 Mobile Safari/537.36";
      }
      paramString = paramString.toString();
      return paramString;
      i += 1;
    }
  }
  
  private void getGroupAppStatus(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    if (this.jsPluginEngine == null)
    {
      QLog.e("[mini] http.RequestPlugin", 1, "getGroupAppStatus, jsPluginEngine=null");
      return;
    }
    try
    {
      String str = new JSONObject(paramString2).optString("entryDataHash");
      ApkgInfo localApkgInfo = this.jsPluginEngine.appBrandRuntime.getApkgInfo();
      if ((TextUtils.isEmpty(str)) || (!str.equals(localApkgInfo.appConfig.launchParam.entryModel.getEntryHash()))) {
        break label218;
      }
      if (localApkgInfo.appConfig.launchParam.entryModel.isAdmin)
      {
        long l = localApkgInfo.appConfig.launchParam.entryModel.uin;
        str = this.jsPluginEngine.appBrandRuntime.getApkgInfo().appId;
        TroopApplicationListUtil.getGroupAppStatus(this.jsPluginEngine, String.valueOf(l), str, new TroopApplicationListUtil.JsPluginParam(paramString1, paramString2, paramJsRuntime, paramInt));
        return;
      }
    }
    catch (Exception paramString2)
    {
      QLog.e("[mini] http.RequestPlugin", 1, "getGroupAppStatus, exception: " + Log.getStackTraceString(paramString2));
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, ApiUtil.wrapCallbackFail(paramString1, null, "native exception"), paramInt);
      return;
    }
    this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, ApiUtil.wrapCallbackFail(paramString1, null, "you are not group administrator"), paramInt);
    return;
    label218:
    this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, ApiUtil.wrapCallbackFail(paramString1, null, "entryDataHash is not vaild or you are not group administrator"), paramInt);
  }
  
  private int getMenshenToken(String paramString)
  {
    int i = 5381;
    if (!TextUtils.isEmpty(paramString))
    {
      int k = paramString.length();
      int j = 5381;
      i = 0;
      while (i < k)
      {
        j += (j << 5) + paramString.charAt(i);
        i += 1;
      }
      i = 0x7FFFFFFF & j;
    }
    return i;
  }
  
  private static String getSecondLevelDomain(String paramString)
  {
    if (paramString != null)
    {
      paramString = Uri.parse(paramString);
      if (paramString != null)
      {
        Object localObject = paramString.getHost();
        if (localObject != null)
        {
          paramString = ((String)localObject).split("\\.");
          if (paramString.length <= 3) {
            return localObject;
          }
          int j = paramString.length;
          localObject = new StringBuilder();
          int i = j - 3;
          while (i < j)
          {
            ((StringBuilder)localObject).append(paramString[i]);
            if (i != j - 1) {
              ((StringBuilder)localObject).append('.');
            }
            i += 1;
          }
          return ((StringBuilder)localObject).toString();
        }
      }
    }
    return null;
  }
  
  private String getSystemUA()
  {
    try
    {
      if (this.ua != null) {
        return this.ua;
      }
      this.ua = constructUA(System.getProperty("http.agent"), true);
      ThreadManagerV2.executeOnFileThread(new RequestPlugin.3(this));
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        this.ua = "AndroidQQ";
      }
    }
    return this.ua;
  }
  
  private String getUserAgent()
  {
    if ((this.jsPluginEngine != null) && (this.jsPluginEngine.getActivityContext() != null)) {
      return getSystemUA() + " QQ/MiniApp QQ/" + aqgz.getQQVersion();
    }
    return null;
  }
  
  private void handleAddToTroopApplicationList(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    if (this.jsPluginEngine == null)
    {
      QLog.e("[mini] http.RequestPlugin", 1, "handleAddToTroopApplicationList, jsPluginEngine=null");
      return;
    }
    String str3;
    try
    {
      String str1 = new JSONObject(paramString2).optString("method");
      try
      {
        if (this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.launchParam.entryModel != null)
        {
          i = 1;
          str3 = this.jsPluginEngine.appBrandRuntime.getApkgInfo().appId;
          if (i == 0) {
            break label219;
          }
          if (this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.launchParam.entryModel.isAdmin) {
            break label166;
          }
          this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, ApiUtil.wrapCallbackFail(paramString1, null, null), paramInt);
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("[mini] http.RequestPlugin", 1, "handleAddToTroopApplicationList exception: " + Log.getStackTraceString(paramString1));
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      String str2;
      for (;;)
      {
        str2 = null;
        continue;
        int i = 0;
      }
      label166:
      long l = this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.launchParam.entryModel.uin;
      TroopApplicationListUtil.addMiniAppToTroopApplicationList(this.jsPluginEngine, String.valueOf(l), str3, str2, new TroopApplicationListUtil.JsPluginParam(paramString1, paramString2, paramJsRuntime, paramInt));
      return;
    }
    label219:
    TroopApplicationListUtil.startTroopActivityAndAddTroopApplication(this.jsPluginEngine, str3, new TroopApplicationListUtil.JsPluginParam(paramString1, paramString2, paramJsRuntime, paramInt));
  }
  
  private void onCloseCallback(int paramInt1, String paramString, int paramInt2)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("socketTaskId", paramInt2);
      ((JSONObject)localObject).put("state", "close");
      ((JSONObject)localObject).put("code", paramInt1);
      ((JSONObject)localObject).put("reason", paramString);
      if (this.mJsRuntime != null) {
        this.mJsRuntime.evaluateSubcribeJS("onSocketTaskStateChange", ((JSONObject)localObject).toString(), 0);
      }
      paramString = (WebsocketRequestTask)this.socketTaskList.get(paramInt2);
      String str;
      if ((this.jsPluginEngine != null) && (this.jsPluginEngine.appBrandRuntime != null) && (this.jsPluginEngine.appBrandRuntime.getApkgInfo() != null) && (this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig != null))
      {
        localObject = this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig;
        str = MiniReportManager.getAppType(this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig);
        if ((paramString == null) || (paramString.getRequestParam() == null)) {
          break label206;
        }
      }
      label206:
      for (paramString = paramString.getRequestParam().mOriginUrl;; paramString = null)
      {
        MiniReportManager.reportEventType((MiniAppConfig)localObject, 633, null, null, null, 0, str, 0L, getSecondLevelDomain(paramString));
        return;
      }
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("[mini] http.RequestPlugin", 1, "MiniAppWebsocketListener onClose exception:", paramString);
    }
  }
  
  public BaseJsPluginEngine getEngine()
  {
    if ((this.mEngineRef != null) && (this.mEngineRef.get() != null)) {
      return (BaseJsPluginEngine)this.mEngineRef.get();
    }
    return null;
  }
  
  /* Error */
  public String handleNativeRequest(String paramString1, String arg2, JsRuntime paramJsRuntime, int paramInt)
  {
    // Byte code:
    //   0: ldc 38
    //   2: iconst_1
    //   3: new 120	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 466
    //   13: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_2
    //   17: invokestatic 471	com/tencent/mobileqq/minigame/utils/GameLog:cutString	(Ljava/lang/String;)Ljava/lang/String;
    //   20: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc_w 473
    //   26: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc_w 475
    //   36: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: iload 4
    //   41: invokevirtual 478	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 176	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: ldc 11
    //   52: aload_1
    //   53: invokevirtual 161	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   56: ifeq +407 -> 463
    //   59: aload_0
    //   60: monitorenter
    //   61: new 148	org/json/JSONObject
    //   64: dup
    //   65: aload_2
    //   66: invokespecial 243	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   69: astore 7
    //   71: getstatic 484	com/tencent/mobileqq/mini/network/RequestStrategy:g	Lcom/tencent/mobileqq/mini/network/RequestStrategy;
    //   74: aload 7
    //   76: invokevirtual 488	com/tencent/mobileqq/mini/network/RequestStrategy:addHttpForwardingInfo	(Lorg/json/JSONObject;)Z
    //   79: pop
    //   80: aload 7
    //   82: ldc_w 490
    //   85: iconst_0
    //   86: invokevirtual 494	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   89: istore 6
    //   91: new 496	com/tencent/mobileqq/mini/network/http/RequestTask$Request
    //   94: dup
    //   95: aload 7
    //   97: aload_0
    //   98: getfield 238	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   101: invokestatic 502	com/tencent/mobileqq/mini/network/http/MiniappHttpUtil:getRequestReferer	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;)Ljava/lang/String;
    //   104: aload_0
    //   105: invokespecial 504	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:getUserAgent	()Ljava/lang/String;
    //   108: aload_0
    //   109: getfield 238	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   112: invokevirtual 507	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getNativeBufferPool	()Ljava/lang/Object;
    //   115: checkcast 509	com/tencent/mobileqq/triton/sdk/bridge/ITNativeBufferPool
    //   118: invokespecial 512	com/tencent/mobileqq/mini/network/http/RequestTask$Request:<init>	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/triton/sdk/bridge/ITNativeBufferPool;)V
    //   121: astore 7
    //   123: aload 7
    //   125: getfield 513	com/tencent/mobileqq/mini/network/http/RequestTask$Request:mOriginUrl	Ljava/lang/String;
    //   128: astore 8
    //   130: aload_0
    //   131: getfield 238	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   134: getfield 254	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   137: invokevirtual 260	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   140: iload 6
    //   142: aload 8
    //   144: iconst_0
    //   145: invokevirtual 517	com/tencent/mobileqq/mini/apkg/ApkgInfo:isDomainValid	(ZLjava/lang/String;I)Z
    //   148: ifne +91 -> 239
    //   151: ldc 38
    //   153: iconst_1
    //   154: new 120	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   161: ldc_w 519
    //   164: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_1
    //   168: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: ldc_w 521
    //   174: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: iload 4
    //   179: invokevirtual 478	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   182: ldc_w 523
    //   185: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload 8
    //   190: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 526	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: aload_0
    //   200: aload_3
    //   201: aconst_null
    //   202: iload 4
    //   204: ldc_w 528
    //   207: ldc_w 529
    //   210: invokestatic 535	acfp:m	(I)Ljava/lang/String;
    //   213: invokespecial 537	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;Ljava/lang/String;)V
    //   216: ldc_w 528
    //   219: aconst_null
    //   220: ldc_w 538
    //   223: invokestatic 535	acfp:m	(I)Ljava/lang/String;
    //   226: invokestatic 322	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   229: invokevirtual 149	org/json/JSONObject:toString	()Ljava/lang/String;
    //   232: astore 7
    //   234: aload_0
    //   235: monitorexit
    //   236: aload 7
    //   238: areturn
    //   239: aload_0
    //   240: getfield 82	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:requestMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   243: aload 7
    //   245: getfield 541	com/tencent/mobileqq/mini/network/http/RequestTask$Request:mTaskId	I
    //   248: invokestatic 222	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   251: aload 7
    //   253: invokevirtual 544	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   256: pop
    //   257: aload 7
    //   259: new 546	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin$2
    //   262: dup
    //   263: aload_0
    //   264: aload 8
    //   266: aload 7
    //   268: aload_3
    //   269: iload 4
    //   271: aload_2
    //   272: invokespecial 549	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin$2:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin;Ljava/lang/String;Lcom/tencent/mobileqq/mini/network/http/RequestTask$Request;Lcom/tencent/mobileqq/mini/webview/JsRuntime;ILjava/lang/String;)V
    //   275: putfield 553	com/tencent/mobileqq/mini/network/http/RequestTask$Request:mCallback	Lcom/tencent/mobileqq/mini/network/http/HttpCallBack;
    //   278: new 148	org/json/JSONObject
    //   281: dup
    //   282: invokespecial 400	org/json/JSONObject:<init>	()V
    //   285: astore 9
    //   287: aload 9
    //   289: ldc_w 555
    //   292: aload 8
    //   294: invokevirtual 413	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   297: pop
    //   298: aload 9
    //   300: ldc_w 557
    //   303: aload 7
    //   305: getfield 541	com/tencent/mobileqq/mini/network/http/RequestTask$Request:mTaskId	I
    //   308: invokevirtual 406	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   311: pop
    //   312: aload 7
    //   314: invokestatic 563	com/tencent/mobileqq/mini/network/http/WxRequest:request	(Lcom/tencent/mobileqq/mini/network/http/RequestTask$Request;)Z
    //   317: ifeq +94 -> 411
    //   320: aload_0
    //   321: getfield 566	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   324: ifne +13 -> 337
    //   327: aload_0
    //   328: aload_3
    //   329: aload 9
    //   331: iload 4
    //   333: aload_1
    //   334: invokespecial 568	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   337: aload_1
    //   338: aload 9
    //   340: invokestatic 572	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   343: invokevirtual 149	org/json/JSONObject:toString	()Ljava/lang/String;
    //   346: astore 7
    //   348: aload_0
    //   349: monitorexit
    //   350: aload 7
    //   352: areturn
    //   353: astore 7
    //   355: aload_0
    //   356: monitorexit
    //   357: aload 7
    //   359: athrow
    //   360: astore 7
    //   362: ldc 38
    //   364: iconst_1
    //   365: new 120	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   372: aload_1
    //   373: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: ldc_w 574
    //   379: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: aload 7
    //   387: invokestatic 453	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   390: aload_0
    //   391: aload_3
    //   392: aconst_null
    //   393: iload 4
    //   395: ldc_w 528
    //   398: invokespecial 576	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   401: aload_0
    //   402: aload_1
    //   403: aload_2
    //   404: aload_3
    //   405: iload 4
    //   407: invokespecial 578	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPlugin:handleNativeRequest	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;I)Ljava/lang/String;
    //   410: areturn
    //   411: aload_0
    //   412: getfield 566	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   415: ifne +13 -> 428
    //   418: aload_0
    //   419: aload_3
    //   420: aload 9
    //   422: iload 4
    //   424: aload_1
    //   425: invokespecial 576	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   428: aload_1
    //   429: aload 9
    //   431: invokestatic 580	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   434: invokevirtual 149	org/json/JSONObject:toString	()Ljava/lang/String;
    //   437: astore 7
    //   439: aload_0
    //   440: monitorexit
    //   441: aload 7
    //   443: areturn
    //   444: astore 7
    //   446: ldc 38
    //   448: iconst_1
    //   449: aload 7
    //   451: iconst_0
    //   452: anewarray 216	java/lang/Object
    //   455: invokestatic 583	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   458: aload_0
    //   459: monitorexit
    //   460: goto -59 -> 401
    //   463: ldc 20
    //   465: aload_1
    //   466: invokevirtual 161	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   469: ifeq +137 -> 606
    //   472: new 148	org/json/JSONObject
    //   475: dup
    //   476: aload_2
    //   477: invokespecial 243	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   480: astore 7
    //   482: aload 7
    //   484: ldc_w 557
    //   487: invokevirtual 586	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   490: istore 5
    //   492: aload 7
    //   494: ldc_w 588
    //   497: invokevirtual 248	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   500: astore 7
    //   502: aload_0
    //   503: getfield 82	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:requestMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   506: iload 5
    //   508: invokestatic 222	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   511: invokevirtual 591	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   514: ifeq -113 -> 401
    //   517: aload_0
    //   518: getfield 82	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:requestMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   521: iload 5
    //   523: invokestatic 222	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   526: invokevirtual 595	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   529: checkcast 496	com/tencent/mobileqq/mini/network/http/RequestTask$Request
    //   532: astore 8
    //   534: aload 8
    //   536: ifnull -135 -> 401
    //   539: ldc_w 597
    //   542: aload 7
    //   544: invokevirtual 161	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   547: ifeq -146 -> 401
    //   550: aload 8
    //   552: invokestatic 600	com/tencent/mobileqq/mini/network/http/WxRequest:abort	(Lcom/tencent/mobileqq/mini/network/http/RequestTask$Request;)V
    //   555: aload_0
    //   556: getfield 566	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   559: ifne -158 -> 401
    //   562: aload_0
    //   563: aload_3
    //   564: aconst_null
    //   565: iload 4
    //   567: aload_1
    //   568: invokespecial 568	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   571: goto -170 -> 401
    //   574: astore 7
    //   576: ldc 38
    //   578: iconst_1
    //   579: new 120	java/lang/StringBuilder
    //   582: dup
    //   583: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   586: ldc_w 602
    //   589: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: aload 7
    //   594: invokevirtual 605	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   597: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: invokestatic 169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   603: goto -202 -> 401
    //   606: ldc 14
    //   608: aload_1
    //   609: invokevirtual 161	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   612: ifeq +487 -> 1099
    //   615: aload_0
    //   616: aload_3
    //   617: putfield 93	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:mJsRuntime	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   620: aload_0
    //   621: aload_1
    //   622: putfield 607	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:event	Ljava/lang/String;
    //   625: aload_0
    //   626: iload 4
    //   628: putfield 609	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackId	I
    //   631: aload_0
    //   632: getfield 84	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:lock	[B
    //   635: astore 7
    //   637: aload 7
    //   639: monitorenter
    //   640: new 148	org/json/JSONObject
    //   643: dup
    //   644: aload_2
    //   645: invokespecial 243	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   648: astore 9
    //   650: getstatic 484	com/tencent/mobileqq/mini/network/RequestStrategy:g	Lcom/tencent/mobileqq/mini/network/RequestStrategy;
    //   653: aload 9
    //   655: invokevirtual 488	com/tencent/mobileqq/mini/network/RequestStrategy:addHttpForwardingInfo	(Lorg/json/JSONObject;)Z
    //   658: pop
    //   659: aload 9
    //   661: ldc_w 490
    //   664: iconst_0
    //   665: invokevirtual 494	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   668: istore 6
    //   670: aload 9
    //   672: ldc_w 611
    //   675: aload_0
    //   676: getfield 238	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   679: getfield 254	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   682: invokevirtual 260	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   685: invokevirtual 615	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   688: getfield 621	com/tencent/mobileqq/mini/apkg/AppConfigInfo:networkTimeoutInfo	Lcom/tencent/mobileqq/mini/apkg/NetworkTimeoutInfo;
    //   691: getfield 626	com/tencent/mobileqq/mini/apkg/NetworkTimeoutInfo:connectSocket	I
    //   694: invokevirtual 406	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   697: pop
    //   698: new 6	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin$MiniAppWebsocketListener
    //   701: dup
    //   702: aload_0
    //   703: invokespecial 627	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin$MiniAppWebsocketListener:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin;)V
    //   706: astore 8
    //   708: new 441	com/tencent/mobileqq/mini/network/websocket/WebsocketRequestTask$RequestParam
    //   711: dup
    //   712: aload 9
    //   714: invokespecial 630	com/tencent/mobileqq/mini/network/websocket/WebsocketRequestTask$RequestParam:<init>	(Lorg/json/JSONObject;)V
    //   717: astore 9
    //   719: aload_0
    //   720: getfield 238	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   723: getfield 254	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   726: invokevirtual 260	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   729: iload 6
    //   731: aload 9
    //   733: getfield 444	com/tencent/mobileqq/mini/network/websocket/WebsocketRequestTask$RequestParam:mOriginUrl	Ljava/lang/String;
    //   736: iconst_1
    //   737: invokevirtual 517	com/tencent/mobileqq/mini/apkg/ApkgInfo:isDomainValid	(ZLjava/lang/String;I)Z
    //   740: ifne +257 -> 997
    //   743: ldc 38
    //   745: iconst_1
    //   746: new 120	java/lang/StringBuilder
    //   749: dup
    //   750: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   753: ldc_w 632
    //   756: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: aload_1
    //   760: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: ldc_w 521
    //   766: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: iload 4
    //   771: invokevirtual 478	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   774: ldc_w 523
    //   777: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   780: aload 9
    //   782: getfield 444	com/tencent/mobileqq/mini/network/websocket/WebsocketRequestTask$RequestParam:mOriginUrl	Ljava/lang/String;
    //   785: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   791: invokestatic 526	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   794: aload_0
    //   795: aload_3
    //   796: aconst_null
    //   797: iload 4
    //   799: ldc_w 634
    //   802: ldc_w 635
    //   805: invokestatic 535	acfp:m	(I)Ljava/lang/String;
    //   808: invokespecial 537	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;Ljava/lang/String;)V
    //   811: aload 7
    //   813: monitorexit
    //   814: ldc 135
    //   816: areturn
    //   817: astore 8
    //   819: aload 7
    //   821: monitorexit
    //   822: aload 8
    //   824: athrow
    //   825: astore 7
    //   827: ldc 38
    //   829: iconst_1
    //   830: new 120	java/lang/StringBuilder
    //   833: dup
    //   834: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   837: aload_1
    //   838: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   841: ldc_w 574
    //   844: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   847: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   850: aload 7
    //   852: invokestatic 453	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   855: aload_0
    //   856: aload_0
    //   857: getfield 93	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:mJsRuntime	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   860: aconst_null
    //   861: iload 4
    //   863: aload_1
    //   864: invokespecial 576	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   867: new 441	com/tencent/mobileqq/mini/network/websocket/WebsocketRequestTask$RequestParam
    //   870: dup
    //   871: new 148	org/json/JSONObject
    //   874: dup
    //   875: aload_2
    //   876: invokespecial 243	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   879: invokespecial 630	com/tencent/mobileqq/mini/network/websocket/WebsocketRequestTask$RequestParam:<init>	(Lorg/json/JSONObject;)V
    //   882: getfield 444	com/tencent/mobileqq/mini/network/websocket/WebsocketRequestTask$RequestParam:mOriginUrl	Ljava/lang/String;
    //   885: astore 7
    //   887: aload_0
    //   888: getfield 238	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   891: ifnull -490 -> 401
    //   894: aload_0
    //   895: getfield 238	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   898: getfield 254	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   901: ifnull -500 -> 401
    //   904: aload_0
    //   905: getfield 238	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   908: getfield 254	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   911: invokevirtual 260	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   914: ifnull -513 -> 401
    //   917: aload_0
    //   918: getfield 238	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   921: getfield 254	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   924: invokevirtual 260	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   927: getfield 266	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   930: ifnull -529 -> 401
    //   933: aload_0
    //   934: getfield 238	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   937: getfield 254	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   940: invokevirtual 260	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   943: getfield 266	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   946: sipush 632
    //   949: aconst_null
    //   950: aconst_null
    //   951: aconst_null
    //   952: iconst_1
    //   953: aload_0
    //   954: getfield 238	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   957: getfield 254	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   960: invokevirtual 260	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   963: getfield 266	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   966: invokestatic 435	com/tencent/mobileqq/mini/report/MiniReportManager:getAppType	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;)Ljava/lang/String;
    //   969: lconst_0
    //   970: aload 7
    //   972: invokestatic 98	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:getSecondLevelDomain	(Ljava/lang/String;)Ljava/lang/String;
    //   975: invokestatic 448	com/tencent/mobileqq/mini/report/MiniReportManager:reportEventType	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;)V
    //   978: goto -577 -> 401
    //   981: astore 7
    //   983: ldc 38
    //   985: iconst_2
    //   986: ldc_w 637
    //   989: aload 7
    //   991: invokestatic 453	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   994: goto -593 -> 401
    //   997: new 429	com/tencent/mobileqq/mini/network/websocket/WebsocketRequestTask
    //   1000: dup
    //   1001: aload 9
    //   1003: aload 8
    //   1005: invokespecial 640	com/tencent/mobileqq/mini/network/websocket/WebsocketRequestTask:<init>	(Lcom/tencent/mobileqq/mini/network/websocket/WebsocketRequestTask$RequestParam;Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin$MiniAppWebsocketListener;)V
    //   1008: astore 9
    //   1010: aload_0
    //   1011: getfield 89	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1014: aload 8
    //   1016: getfield 643	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin$MiniAppWebsocketListener:currSocketId	I
    //   1019: aload 9
    //   1021: invokevirtual 646	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   1024: new 148	org/json/JSONObject
    //   1027: dup
    //   1028: aload_2
    //   1029: invokespecial 243	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1032: astore 9
    //   1034: aload 9
    //   1036: ldc_w 402
    //   1039: aload 8
    //   1041: getfield 643	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin$MiniAppWebsocketListener:currSocketId	I
    //   1044: invokevirtual 406	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1047: pop
    //   1048: aload 9
    //   1050: ldc 137
    //   1052: new 120	java/lang/StringBuilder
    //   1055: dup
    //   1056: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   1059: aload_1
    //   1060: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1063: ldc_w 648
    //   1066: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1069: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1072: invokevirtual 413	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1075: pop
    //   1076: aload_0
    //   1077: aload_3
    //   1078: aload 9
    //   1080: iload 4
    //   1082: aload_1
    //   1083: invokespecial 568	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   1086: aload 9
    //   1088: invokevirtual 149	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1091: astore 8
    //   1093: aload 7
    //   1095: monitorexit
    //   1096: aload 8
    //   1098: areturn
    //   1099: ldc 23
    //   1101: aload_1
    //   1102: invokevirtual 161	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1105: ifeq +669 -> 1774
    //   1108: new 148	org/json/JSONObject
    //   1111: dup
    //   1112: aload_2
    //   1113: invokespecial 243	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1116: astore 7
    //   1118: aload 7
    //   1120: ldc_w 588
    //   1123: invokevirtual 248	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1126: astore 8
    //   1128: aload 7
    //   1130: ldc_w 402
    //   1133: invokevirtual 586	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1136: istore 5
    //   1138: ldc_w 410
    //   1141: aload 8
    //   1143: invokevirtual 161	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1146: ifeq +200 -> 1346
    //   1149: aload_0
    //   1150: getfield 84	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:lock	[B
    //   1153: astore_2
    //   1154: aload_2
    //   1155: monitorenter
    //   1156: aload_0
    //   1157: getfield 89	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1160: ifnull +149 -> 1309
    //   1163: aload_0
    //   1164: getfield 89	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1167: invokevirtual 651	android/util/SparseArray:size	()I
    //   1170: ifeq +139 -> 1309
    //   1173: aload_0
    //   1174: getfield 89	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1177: iload 5
    //   1179: invokevirtual 427	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1182: checkcast 429	com/tencent/mobileqq/mini/network/websocket/WebsocketRequestTask
    //   1185: astore 8
    //   1187: aload_0
    //   1188: getfield 89	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1191: iload 5
    //   1193: invokevirtual 654	android/util/SparseArray:remove	(I)V
    //   1196: aload 7
    //   1198: ldc_w 415
    //   1201: sipush 1000
    //   1204: invokevirtual 656	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1207: istore 5
    //   1209: aload 7
    //   1211: ldc_w 417
    //   1214: ldc_w 658
    //   1217: invokevirtual 661	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1220: astore 7
    //   1222: aload 8
    //   1224: ifnull +12 -> 1236
    //   1227: aload 8
    //   1229: iload 5
    //   1231: aload 7
    //   1233: invokevirtual 664	com/tencent/mobileqq/mini/network/websocket/WebsocketRequestTask:closeSocket	(ILjava/lang/String;)V
    //   1236: aload_0
    //   1237: getfield 566	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   1240: ifeq +14 -> 1254
    //   1243: aload_0
    //   1244: aload_3
    //   1245: aconst_null
    //   1246: iload 4
    //   1248: ldc_w 665
    //   1251: invokespecial 568	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   1254: aload_1
    //   1255: aconst_null
    //   1256: invokestatic 572	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1259: invokevirtual 149	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1262: astore_3
    //   1263: aload_2
    //   1264: monitorexit
    //   1265: aload_3
    //   1266: areturn
    //   1267: astore_3
    //   1268: aload_2
    //   1269: monitorexit
    //   1270: aload_3
    //   1271: athrow
    //   1272: astore_2
    //   1273: ldc 38
    //   1275: iconst_1
    //   1276: new 120	java/lang/StringBuilder
    //   1279: dup
    //   1280: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   1283: aload_1
    //   1284: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1287: ldc_w 574
    //   1290: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1293: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1296: aload_2
    //   1297: invokestatic 453	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1300: aload_1
    //   1301: aconst_null
    //   1302: invokestatic 580	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1305: invokevirtual 149	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1308: areturn
    //   1309: aload_0
    //   1310: getfield 566	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   1313: ifeq +17 -> 1330
    //   1316: aload_0
    //   1317: aload_3
    //   1318: aconst_null
    //   1319: iload 4
    //   1321: ldc_w 665
    //   1324: ldc_w 667
    //   1327: invokespecial 537	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;Ljava/lang/String;)V
    //   1330: aload_1
    //   1331: aconst_null
    //   1332: ldc_w 667
    //   1335: invokestatic 322	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   1338: invokevirtual 149	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1341: astore_3
    //   1342: aload_2
    //   1343: monitorexit
    //   1344: aload_3
    //   1345: areturn
    //   1346: ldc_w 669
    //   1349: aload 8
    //   1351: invokevirtual 161	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1354: ifeq -953 -> 401
    //   1357: aload 7
    //   1359: ldc_w 671
    //   1362: aconst_null
    //   1363: invokevirtual 661	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1366: astore 8
    //   1368: aload 8
    //   1370: ifnull +200 -> 1570
    //   1373: aload_0
    //   1374: getfield 84	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:lock	[B
    //   1377: astore_2
    //   1378: aload_2
    //   1379: monitorenter
    //   1380: aload_0
    //   1381: getfield 89	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1384: ifnull +149 -> 1533
    //   1387: aload_0
    //   1388: getfield 89	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1391: invokevirtual 651	android/util/SparseArray:size	()I
    //   1394: ifeq +139 -> 1533
    //   1397: aload_0
    //   1398: getfield 89	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1401: iload 5
    //   1403: invokevirtual 427	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1406: checkcast 429	com/tencent/mobileqq/mini/network/websocket/WebsocketRequestTask
    //   1409: astore 7
    //   1411: aload 7
    //   1413: ifnull +46 -> 1459
    //   1416: aload 7
    //   1418: aload 8
    //   1420: invokevirtual 674	com/tencent/mobileqq/mini/network/websocket/WebsocketRequestTask:sendStringMessage	(Ljava/lang/String;)V
    //   1423: aload_0
    //   1424: getfield 566	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   1427: ifeq +14 -> 1441
    //   1430: aload_0
    //   1431: aload_3
    //   1432: aconst_null
    //   1433: iload 4
    //   1435: ldc_w 676
    //   1438: invokespecial 568	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   1441: aload_1
    //   1442: aconst_null
    //   1443: invokestatic 572	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1446: invokevirtual 149	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1449: astore_3
    //   1450: aload_2
    //   1451: monitorexit
    //   1452: aload_3
    //   1453: areturn
    //   1454: astore_3
    //   1455: aload_2
    //   1456: monitorexit
    //   1457: aload_3
    //   1458: athrow
    //   1459: ldc 38
    //   1461: iconst_1
    //   1462: new 120	java/lang/StringBuilder
    //   1465: dup
    //   1466: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   1469: aload_1
    //   1470: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1473: ldc_w 678
    //   1476: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1479: aload 8
    //   1481: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1484: ldc_w 680
    //   1487: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1490: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1493: invokestatic 169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1496: aload_0
    //   1497: getfield 566	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   1500: ifeq +17 -> 1517
    //   1503: aload_0
    //   1504: aload_3
    //   1505: aconst_null
    //   1506: iload 4
    //   1508: ldc_w 676
    //   1511: ldc_w 682
    //   1514: invokespecial 537	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;Ljava/lang/String;)V
    //   1517: aload_1
    //   1518: aconst_null
    //   1519: ldc_w 682
    //   1522: invokestatic 322	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   1525: invokevirtual 149	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1528: astore_3
    //   1529: aload_2
    //   1530: monitorexit
    //   1531: aload_3
    //   1532: areturn
    //   1533: aload_0
    //   1534: getfield 566	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   1537: ifeq +17 -> 1554
    //   1540: aload_0
    //   1541: aload_3
    //   1542: aconst_null
    //   1543: iload 4
    //   1545: ldc_w 676
    //   1548: ldc_w 667
    //   1551: invokespecial 537	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;Ljava/lang/String;)V
    //   1554: aload_1
    //   1555: aconst_null
    //   1556: ldc_w 667
    //   1559: invokestatic 322	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   1562: invokevirtual 149	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1565: astore_3
    //   1566: aload_2
    //   1567: monitorexit
    //   1568: aload_3
    //   1569: areturn
    //   1570: aload 7
    //   1572: invokestatic 687	com/tencent/mobileqq/minigame/utils/NativeBuffer:hasNativeBuffer	(Lorg/json/JSONObject;)Z
    //   1575: ifeq -1174 -> 401
    //   1578: aload 7
    //   1580: ldc_w 671
    //   1583: aload_0
    //   1584: getfield 238	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1587: invokevirtual 507	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getNativeBufferPool	()Ljava/lang/Object;
    //   1590: checkcast 509	com/tencent/mobileqq/triton/sdk/bridge/ITNativeBufferPool
    //   1593: invokestatic 691	com/tencent/mobileqq/minigame/utils/NativeBuffer:unpackNativeBuffer	(Lorg/json/JSONObject;Ljava/lang/String;Lcom/tencent/mobileqq/triton/sdk/bridge/ITNativeBufferPool;)Lcom/tencent/mobileqq/minigame/utils/NativeBuffer;
    //   1596: astore_2
    //   1597: aload_2
    //   1598: ifnull +141 -> 1739
    //   1601: aload_2
    //   1602: getfield 694	com/tencent/mobileqq/minigame/utils/NativeBuffer:buf	[B
    //   1605: ifnull +134 -> 1739
    //   1608: aload_0
    //   1609: getfield 89	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1612: ifnull +127 -> 1739
    //   1615: aload_0
    //   1616: getfield 89	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1619: invokevirtual 651	android/util/SparseArray:size	()I
    //   1622: ifeq +117 -> 1739
    //   1625: aload_0
    //   1626: getfield 89	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1629: iload 5
    //   1631: invokevirtual 427	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1634: checkcast 429	com/tencent/mobileqq/mini/network/websocket/WebsocketRequestTask
    //   1637: astore 7
    //   1639: aload 7
    //   1641: ifnull +39 -> 1680
    //   1644: aload 7
    //   1646: aload_2
    //   1647: getfield 694	com/tencent/mobileqq/minigame/utils/NativeBuffer:buf	[B
    //   1650: invokevirtual 698	com/tencent/mobileqq/mini/network/websocket/WebsocketRequestTask:sendBinaryMessage	([B)V
    //   1653: aload_0
    //   1654: getfield 566	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   1657: ifeq +14 -> 1671
    //   1660: aload_0
    //   1661: aload_3
    //   1662: aconst_null
    //   1663: iload 4
    //   1665: ldc_w 676
    //   1668: invokespecial 568	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   1671: aload_1
    //   1672: aconst_null
    //   1673: invokestatic 572	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1676: invokevirtual 149	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1679: areturn
    //   1680: ldc 38
    //   1682: iconst_1
    //   1683: new 120	java/lang/StringBuilder
    //   1686: dup
    //   1687: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   1690: aload_1
    //   1691: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1694: ldc_w 700
    //   1697: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1700: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1703: invokestatic 169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1706: aload_0
    //   1707: getfield 566	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   1710: ifeq +17 -> 1727
    //   1713: aload_0
    //   1714: aload_3
    //   1715: aconst_null
    //   1716: iload 4
    //   1718: ldc_w 676
    //   1721: ldc_w 682
    //   1724: invokespecial 537	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;Ljava/lang/String;)V
    //   1727: aload_1
    //   1728: aconst_null
    //   1729: ldc_w 682
    //   1732: invokestatic 322	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   1735: invokevirtual 149	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1738: areturn
    //   1739: aload_0
    //   1740: getfield 566	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   1743: ifeq +17 -> 1760
    //   1746: aload_0
    //   1747: aload_3
    //   1748: aconst_null
    //   1749: iload 4
    //   1751: ldc_w 676
    //   1754: ldc_w 667
    //   1757: invokespecial 537	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;Ljava/lang/String;)V
    //   1760: aload_1
    //   1761: aconst_null
    //   1762: ldc_w 667
    //   1765: invokestatic 322	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   1768: invokevirtual 149	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1771: astore_2
    //   1772: aload_2
    //   1773: areturn
    //   1774: ldc 44
    //   1776: aload_1
    //   1777: invokevirtual 161	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1780: ifeq +61 -> 1841
    //   1783: aload_0
    //   1784: getfield 238	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1787: ifnonnull +6 -> 1793
    //   1790: ldc 135
    //   1792: areturn
    //   1793: aload_2
    //   1794: aload_3
    //   1795: aload_1
    //   1796: iload 4
    //   1798: aload_0
    //   1799: getfield 238	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1802: invokestatic 706	com/tencent/mobileqq/mini/entry/MiniAppUtils:performWnsCgiRequest	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;ILcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;)V
    //   1805: goto -1404 -> 401
    //   1808: astore 7
    //   1810: ldc 38
    //   1812: iconst_1
    //   1813: new 120	java/lang/StringBuilder
    //   1816: dup
    //   1817: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   1820: aload_1
    //   1821: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1824: ldc_w 574
    //   1827: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1830: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1833: aload 7
    //   1835: invokestatic 453	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1838: goto -1437 -> 401
    //   1841: ldc 50
    //   1843: aload_1
    //   1844: invokevirtual 161	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1847: ifeq +312 -> 2159
    //   1850: invokestatic 710	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1853: ifeq +33 -> 1886
    //   1856: ldc 38
    //   1858: iconst_2
    //   1859: new 120	java/lang/StringBuilder
    //   1862: dup
    //   1863: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   1866: aload_1
    //   1867: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1870: ldc_w 712
    //   1873: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1876: aload_2
    //   1877: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1880: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1883: invokestatic 715	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1886: aload_0
    //   1887: getfield 238	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1890: ifnull +371 -> 2261
    //   1893: aload_2
    //   1894: invokestatic 133	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1897: ifeq +6 -> 1903
    //   1900: goto +361 -> 2261
    //   1903: new 148	org/json/JSONObject
    //   1906: dup
    //   1907: aload_2
    //   1908: invokespecial 243	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1911: ldc 245
    //   1913: invokevirtual 248	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1916: astore 7
    //   1918: aload_0
    //   1919: getfield 238	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1922: getfield 254	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1925: invokevirtual 260	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1928: astore 8
    //   1930: aload 8
    //   1932: ifnull -1531 -> 401
    //   1935: aload 8
    //   1937: getfield 266	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   1940: ifnull -1539 -> 401
    //   1943: aload 8
    //   1945: getfield 266	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   1948: getfield 272	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   1951: ifnull -1550 -> 401
    //   1954: aload 8
    //   1956: getfield 266	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   1959: getfield 272	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   1962: getfield 278	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   1965: ifnull -1564 -> 401
    //   1968: aload 7
    //   1970: ifnull -1569 -> 401
    //   1973: aload 7
    //   1975: aload 8
    //   1977: getfield 266	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   1980: getfield 272	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   1983: getfield 278	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   1986: invokevirtual 283	com/tencent/mobileqq/mini/sdk/EntryModel:getEntryHash	()Ljava/lang/String;
    //   1989: invokevirtual 161	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1992: ifeq +132 -> 2124
    //   1995: aload 8
    //   1997: getfield 266	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2000: getfield 272	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2003: getfield 278	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   2006: getfield 287	com/tencent/mobileqq/mini/sdk/EntryModel:isAdmin	Z
    //   2009: ifeq +115 -> 2124
    //   2012: aload_2
    //   2013: ldc_w 717
    //   2016: invokevirtual 720	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2019: ifeq +74 -> 2093
    //   2022: aload_2
    //   2023: ldc_w 717
    //   2026: aload 8
    //   2028: getfield 266	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2031: getfield 272	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2034: getfield 278	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   2037: getfield 291	com/tencent/mobileqq/mini/sdk/EntryModel:uin	J
    //   2040: invokestatic 297	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2043: invokevirtual 724	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   2046: aload_3
    //   2047: aload_1
    //   2048: iload 4
    //   2050: aload_0
    //   2051: getfield 238	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2054: invokestatic 706	com/tencent/mobileqq/mini/entry/MiniAppUtils:performWnsCgiRequest	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;ILcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;)V
    //   2057: goto -1656 -> 401
    //   2060: astore 7
    //   2062: ldc 38
    //   2064: iconst_1
    //   2065: new 120	java/lang/StringBuilder
    //   2068: dup
    //   2069: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   2072: aload_1
    //   2073: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2076: ldc_w 574
    //   2079: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2082: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2085: aload 7
    //   2087: invokestatic 453	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2090: goto -1689 -> 401
    //   2093: aload_0
    //   2094: getfield 238	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2097: aload_3
    //   2098: aload_1
    //   2099: aload_1
    //   2100: aconst_null
    //   2101: ldc_w 726
    //   2104: invokestatic 322	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   2107: iload 4
    //   2109: invokevirtual 326	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   2112: aload_1
    //   2113: aconst_null
    //   2114: ldc_w 726
    //   2117: invokestatic 322	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   2120: invokevirtual 149	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2123: areturn
    //   2124: aload_0
    //   2125: getfield 238	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2128: aload_3
    //   2129: aload_1
    //   2130: aload_1
    //   2131: aconst_null
    //   2132: ldc_w 330
    //   2135: invokestatic 322	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   2138: iload 4
    //   2140: invokevirtual 326	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   2143: aload_1
    //   2144: aconst_null
    //   2145: ldc_w 330
    //   2148: invokestatic 322	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   2151: invokevirtual 149	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2154: astore 7
    //   2156: aload 7
    //   2158: areturn
    //   2159: ldc 41
    //   2161: aload_1
    //   2162: invokevirtual 161	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2165: ifeq +45 -> 2210
    //   2168: ldc 38
    //   2170: iconst_2
    //   2171: new 120	java/lang/StringBuilder
    //   2174: dup
    //   2175: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   2178: aload_1
    //   2179: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2182: ldc_w 728
    //   2185: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2188: aload_2
    //   2189: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2192: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2195: invokestatic 715	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2198: aload_0
    //   2199: aload_1
    //   2200: aload_2
    //   2201: aload_3
    //   2202: iload 4
    //   2204: invokespecial 730	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:handleAddToTroopApplicationList	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;I)V
    //   2207: goto -1806 -> 401
    //   2210: ldc 47
    //   2212: aload_1
    //   2213: invokevirtual 161	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2216: ifeq -1815 -> 401
    //   2219: ldc 38
    //   2221: iconst_2
    //   2222: new 120	java/lang/StringBuilder
    //   2225: dup
    //   2226: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   2229: aload_1
    //   2230: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2233: ldc_w 728
    //   2236: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2239: aload_2
    //   2240: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2243: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2246: invokestatic 715	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2249: aload_0
    //   2250: aload_1
    //   2251: aload_2
    //   2252: aload_3
    //   2253: iload 4
    //   2255: invokespecial 732	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:getGroupAppStatus	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;I)V
    //   2258: goto -1857 -> 401
    //   2261: ldc 135
    //   2263: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2264	0	this	RequestPlugin
    //   0	2264	1	paramString1	String
    //   0	2264	3	paramJsRuntime	JsRuntime
    //   0	2264	4	paramInt	int
    //   490	1140	5	i	int
    //   89	641	6	bool	boolean
    //   69	282	7	localObject1	Object
    //   353	5	7	localObject2	Object
    //   360	26	7	localThrowable1	Throwable
    //   437	5	7	str1	String
    //   444	6	7	localThrowable2	Throwable
    //   480	63	7	localObject3	Object
    //   574	19	7	localException	Exception
    //   825	26	7	localThrowable3	Throwable
    //   885	86	7	str2	String
    //   981	113	7	localThrowable4	Throwable
    //   1116	529	7	localObject4	Object
    //   1808	26	7	localThrowable5	Throwable
    //   1916	58	7	str3	String
    //   2060	26	7	localThrowable6	Throwable
    //   2154	3	7	str4	String
    //   128	579	8	localObject5	Object
    //   817	223	8	localMiniAppWebsocketListener	MiniAppWebsocketListener
    //   1091	936	8	localObject6	Object
    //   285	802	9	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   61	236	353	finally
    //   239	278	353	finally
    //   278	337	353	finally
    //   337	348	353	finally
    //   348	350	353	finally
    //   355	357	353	finally
    //   411	428	353	finally
    //   428	439	353	finally
    //   439	441	353	finally
    //   446	460	353	finally
    //   59	61	360	java/lang/Throwable
    //   357	360	360	java/lang/Throwable
    //   278	337	444	java/lang/Throwable
    //   337	348	444	java/lang/Throwable
    //   411	428	444	java/lang/Throwable
    //   428	439	444	java/lang/Throwable
    //   472	534	574	java/lang/Exception
    //   539	571	574	java/lang/Exception
    //   640	814	817	finally
    //   819	822	817	finally
    //   997	1096	817	finally
    //   631	640	825	java/lang/Throwable
    //   822	825	825	java/lang/Throwable
    //   867	978	981	java/lang/Throwable
    //   1156	1222	1267	finally
    //   1227	1236	1267	finally
    //   1236	1254	1267	finally
    //   1254	1265	1267	finally
    //   1268	1270	1267	finally
    //   1309	1330	1267	finally
    //   1330	1344	1267	finally
    //   1108	1156	1272	java/lang/Throwable
    //   1270	1272	1272	java/lang/Throwable
    //   1346	1368	1272	java/lang/Throwable
    //   1373	1380	1272	java/lang/Throwable
    //   1457	1459	1272	java/lang/Throwable
    //   1570	1597	1272	java/lang/Throwable
    //   1601	1639	1272	java/lang/Throwable
    //   1644	1671	1272	java/lang/Throwable
    //   1671	1680	1272	java/lang/Throwable
    //   1680	1727	1272	java/lang/Throwable
    //   1727	1739	1272	java/lang/Throwable
    //   1739	1760	1272	java/lang/Throwable
    //   1760	1772	1272	java/lang/Throwable
    //   1380	1411	1454	finally
    //   1416	1441	1454	finally
    //   1441	1452	1454	finally
    //   1455	1457	1454	finally
    //   1459	1517	1454	finally
    //   1517	1531	1454	finally
    //   1533	1554	1454	finally
    //   1554	1568	1454	finally
    //   1783	1790	1808	java/lang/Throwable
    //   1793	1805	1808	java/lang/Throwable
    //   1886	1900	2060	java/lang/Throwable
    //   1903	1930	2060	java/lang/Throwable
    //   1935	1968	2060	java/lang/Throwable
    //   1973	2057	2060	java/lang/Throwable
    //   2093	2124	2060	java/lang/Throwable
    //   2124	2156	2060	java/lang/Throwable
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    this.mEngineRef = new WeakReference(paramBaseJsPluginEngine);
    super.onCreate(paramBaseJsPluginEngine);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    int i = this.socketTaskList.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        WebsocketRequestTask localWebsocketRequestTask = (WebsocketRequestTask)this.socketTaskList.valueAt(i);
        if (localWebsocketRequestTask != null) {}
        try
        {
          QLog.d("[mini] http.RequestPlugin", 1, "destory close socket, socket id " + this.socketTaskList.keyAt(i));
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("socketTaskId", this.socketTaskList.keyAt(i));
          localJSONObject.put("state", "close");
          localJSONObject.put("statusCode", 600);
          if (this.mJsRuntime != null) {
            this.mJsRuntime.evaluateSubcribeJS("onSocketTaskStateChange", localJSONObject.toString(), 0);
          }
          localWebsocketRequestTask.destory();
          this.socketTaskList.remove(i);
          i -= 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.e("[mini] http.RequestPlugin", 1, "onDestroy exception ", localException);
          }
        }
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
  
  public class MiniAppWebsocketListener
    extends WebSocketListener
  {
    public int currSocketId;
    private boolean socketClosedCallbacked;
    public WebSocket webSocket;
    
    public MiniAppWebsocketListener() {}
    
    public void onActivelyClose(int paramInt, String paramString)
    {
      if (this.socketClosedCallbacked)
      {
        QLog.d("[mini] http.RequestPlugin", 1, "onClose has been called, return. ");
        return;
      }
      QLog.d("[mini] http.RequestPlugin", 1, "---onActivelyClose---" + paramString);
      this.socketClosedCallbacked = true;
      RequestPlugin.this.onCloseCallback(paramInt, paramString, this.currSocketId);
    }
    
    public void onClosed(WebSocket paramWebSocket, int paramInt, String paramString)
    {
      QLog.d("[mini] http.RequestPlugin", 1, "---onClosed---" + paramString);
      this.socketClosedCallbacked = true;
      RequestPlugin.this.onCloseCallback(paramInt, paramString, this.currSocketId);
    }
    
    public void onFailure(WebSocket paramWebSocket, Throwable paramThrowable, @Nullable Response paramResponse)
    {
      Object localObject1 = null;
      QLog.e("[mini] http.RequestPlugin", 1, "MiniAppWebsocketListener onFailure, socketId=" + this.currSocketId, paramThrowable);
      if (paramThrowable != null) {}
      int i;
      Object localObject3;
      try
      {
        if ((paramThrowable.getMessage() != null) && ((paramThrowable.getMessage().equals("SSL handshake timed out")) || (paramThrowable.getMessage().equals("timeout"))))
        {
          QLog.e("[mini] http.RequestPlugin", 1, "MiniAppWebsocketListener onFailure , timeout , send close state. socketId=" + this.currSocketId);
          paramWebSocket = new JSONObject();
          paramWebSocket.put("socketTaskId", this.currSocketId);
          paramWebSocket.put("state", "close");
          if (paramResponse == null)
          {
            i = 600;
            paramWebSocket.put("statusCode", i);
            if (RequestPlugin.this.mJsRuntime != null) {
              RequestPlugin.this.mJsRuntime.evaluateSubcribeJS("onSocketTaskStateChange", paramWebSocket.toString(), 0);
            }
          }
        }
        for (;;)
        {
          if ((RequestPlugin.this.jsPluginEngine == null) || (RequestPlugin.this.jsPluginEngine.appBrandRuntime == null) || (RequestPlugin.this.jsPluginEngine.appBrandRuntime.getApkgInfo() == null) || (RequestPlugin.this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig == null)) {
            return;
          }
          Object localObject2 = RequestPlugin.this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig;
          localObject3 = MiniReportManager.getAppType(RequestPlugin.this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig);
          paramWebSocket = localObject1;
          if (paramResponse != null)
          {
            paramWebSocket = localObject1;
            if (paramResponse.request() != null) {
              paramWebSocket = paramResponse.request().url().toString();
            }
          }
          MiniReportManager.reportEventType((MiniAppConfig)localObject2, 634, null, null, null, 0, (String)localObject3, 0L, RequestPlugin.getSecondLevelDomain(paramWebSocket));
          return;
          i = paramResponse.code();
          break;
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("socketTaskId", this.currSocketId);
          ((JSONObject)localObject2).put("state", "error");
          if ((aqiw.getNetworkType(BaseApplicationImpl.getContext()) != 0) && (aqiw.getNetworkType(BaseApplicationImpl.getContext()) != -1)) {
            break label468;
          }
          paramWebSocket = "network is down";
          ((JSONObject)localObject2).put("errMsg", "network is down");
          QLog.e("[mini] http.RequestPlugin", 1, "MiniAppWebsocketListener onFailure socketId=" + this.currSocketId + " errMsg=" + paramWebSocket);
          if (RequestPlugin.this.mJsRuntime != null) {
            RequestPlugin.this.mJsRuntime.evaluateSubcribeJS("onSocketTaskStateChange", ((JSONObject)localObject2).toString(), 0);
          }
        }
        localObject3 = new StringBuilder().append("resposeCode=");
      }
      catch (JSONException paramWebSocket)
      {
        QLog.e("[mini] http.RequestPlugin", 1, "MiniAppWebsocketListener onFailure exception:", paramThrowable);
        return;
      }
      label468:
      if (paramResponse == null) {}
      for (paramWebSocket = "-1";; paramWebSocket = Integer.valueOf(i))
      {
        paramWebSocket = paramWebSocket;
        break;
        i = paramResponse.code();
      }
    }
    
    public void onMessage(WebSocket paramWebSocket, String paramString)
    {
      try
      {
        paramWebSocket = new JSONObject();
        paramWebSocket.put("socketTaskId", this.currSocketId);
        paramWebSocket.put("state", "message");
        paramWebSocket.put("errMsg", "ok");
        paramWebSocket.put("isBuffer", false);
        paramWebSocket.put("data", paramString);
        if (RequestPlugin.this.mJsRuntime != null) {
          RequestPlugin.this.mJsRuntime.evaluateSubcribeJS("onSocketTaskStateChange", paramWebSocket.toString(), 0);
        }
        return;
      }
      catch (JSONException paramWebSocket)
      {
        paramWebSocket = paramWebSocket;
        QLog.e("[mini] http.RequestPlugin", 1, "MiniAppWebsocketListener onMessage exception:", paramWebSocket);
        return;
      }
      finally {}
    }
    
    public void onMessage(WebSocket paramWebSocket, ByteString paramByteString)
    {
      try
      {
        paramWebSocket = new JSONObject();
        paramWebSocket.put("socketTaskId", this.currSocketId);
        paramWebSocket.put("state", "message");
        paramWebSocket.put("errMsg", "ok");
        paramWebSocket.put("isBuffer", true);
        if (RequestPlugin.this.isGameRuntime) {
          NativeBuffer.packNativeBuffer(paramByteString.toByteArray(), NativeBuffer.TYPE_BUFFER_NATIVE, "data", paramWebSocket, (ITNativeBufferPool)RequestPlugin.this.jsPluginEngine.getNativeBufferPool());
        }
        while (RequestPlugin.this.mJsRuntime != null)
        {
          RequestPlugin.this.mJsRuntime.evaluateSubcribeJS("onSocketTaskStateChange", paramWebSocket.toString(), 0);
          return;
          NativeBuffer.packNativeBuffer(paramByteString.toByteArray(), NativeBuffer.TYPE_BUFFER_BASE64, "data", paramWebSocket, null);
        }
        return;
      }
      catch (JSONException paramWebSocket)
      {
        paramWebSocket = paramWebSocket;
        QLog.e("[mini] http.RequestPlugin", 1, "MiniAppWebsocketListener onMessage exception:", paramWebSocket);
        return;
      }
      finally {}
    }
    
    public void onOpen(WebSocket paramWebSocket, Response paramResponse)
    {
      Object localObject = null;
      this.webSocket = paramWebSocket;
      try
      {
        paramWebSocket = new JSONObject();
        paramWebSocket.put("socketTaskId", this.currSocketId);
        paramWebSocket.put("state", "open");
        paramWebSocket.put("statusCode", paramResponse.code());
        paramWebSocket.put("header", JSONUtil.headerToJson(paramResponse.headers().toMultimap()));
        if (RequestPlugin.this.mJsRuntime != null) {
          RequestPlugin.this.mJsRuntime.evaluateSubcribeJS("onSocketTaskStateChange", paramWebSocket.toString(), 0);
        }
        if ((RequestPlugin.this.jsPluginEngine != null) && (RequestPlugin.this.jsPluginEngine.appBrandRuntime != null) && (RequestPlugin.this.jsPluginEngine.appBrandRuntime.getApkgInfo() != null) && (RequestPlugin.this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig != null))
        {
          MiniAppConfig localMiniAppConfig = RequestPlugin.this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig;
          String str = MiniReportManager.getAppType(RequestPlugin.this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig);
          paramWebSocket = localObject;
          if (paramResponse.request() != null) {
            paramWebSocket = paramResponse.request().url().toString();
          }
          MiniReportManager.reportEventType(localMiniAppConfig, 632, null, null, null, 0, str, 0L, RequestPlugin.getSecondLevelDomain(paramWebSocket));
        }
        return;
      }
      catch (JSONException paramWebSocket)
      {
        QLog.e("[mini] http.RequestPlugin", 1, "MiniAppWebsocketListener onOpen error:", paramWebSocket);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.RequestPlugin
 * JD-Core Version:    0.7.0.1
 */