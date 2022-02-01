package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_MINI_INTERFACE.INTERFACE.StGetUserSettingRsp;
import NS_MINI_INTERFACE.INTERFACE.StSubscribeMessage;
import NS_MINI_INTERFACE.INTERFACE.StUserSettingInfo;
import acfp;
import android.content.DialogInterface.OnDismissListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import aqmr;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.AppMode;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkg.SecondApiRightInfo;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.jsapi.IJsPlugin;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.AuthDialog;
import com.tencent.mobileqq.mini.widget.AuthDialog.AuthDialogResBuilder;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseJsPluginEngine<ActivityContext extends BaseActivity>
  implements Handler.Callback
{
  public static final int API_BLACK = 0;
  public static final int API_WHITE = 1;
  public static final int AUTH_PASS = 3;
  public static final int AUTH_REFUSE = 2;
  public static final int AUTH_SUCC = 1;
  private static final String CONFIG_SPLIT = ",";
  public static final String KEY_APP_ID = "key_app_id";
  public static final String KEY_ONCE_SUB_RSP_DATA = "key_once_sub_rsp_data";
  public static final String TAG = "BaseJsPluginEngine";
  private static ArrayList<String> authWhiteList;
  private static volatile int curInputId = -1;
  private static String mCurWhiteListConfig;
  private final String KEY_CALLBACK_ID = "key_callback_id";
  private final String KEY_EVENT_NAME = "key_event_name";
  private final String KEY_JOB_INFO = "key_job_info";
  private final String KEY_PARAMS = "key_params";
  private final int ONCE_SUBSCRIBE_CODE_OTHER = -2;
  private final int ONCE_SUBSCRIBE_CODE_PASS = -1;
  private final int ONCE_SUBSCRIBE_CODE_REJECT = 0;
  private final int ONCE_SUBSCRIBE_CODE_SUC = 1;
  private final int SUBSCRIBE_CODE_FAIL_OTHER = -2;
  private final int SUBSCRIBE_CODE_REJECT = -1;
  private final int SUBSCRIBE_CODE_REJECT_FIRST = 0;
  private final int SUBSCRIBE_CODE_SUC = 1;
  private final int WHAT_NOTIFY_QUEUE = 1;
  private final int WHAT_NOTIFY_SYS_QUEUE = 4;
  private final int WHAT_SHOW_AUTH_DIALOG = 2;
  private final int WHAT_SHOW_AUTH_DIALOG_BY_AUTHORIZE = 5;
  private final int WHAT_SHOW_SYS_AUTH_DIALOG = 3;
  public ActivityContext activityContext;
  public BaseAppBrandRuntime appBrandRuntime;
  AuthDialog authDialog;
  public AuthorizeCenter authorizeCenter;
  private boolean checkStoragePermission;
  private List<String> defaultBlackList;
  DialogInterface.OnDismissListener dismissListener;
  private HashMap<String, Integer> firstApiMap;
  private boolean isCreated;
  private boolean isDestory;
  private boolean isFirstTimeRequestAuth;
  private boolean isPause;
  private boolean isSubAuthPassed;
  public ConcurrentLinkedQueue<NativeJobInfo> jobQueue;
  private final HashMap<String, IJsPlugin> mPluginEventMap = new HashMap();
  private final ArrayList<IJsPlugin> mPluginList = new ArrayList();
  private Map<Integer, ReqGantApiPermissionCallback> mReqGantApiPermissionCallbackMap = new ConcurrentHashMap();
  private int onceSubCallbackId = -1;
  DialogInterface.OnDismissListener onceSubDismissListener;
  private JsRuntime onceSubWebView;
  private HashMap<String, HashMap<String, Integer>> secondApiMap;
  public ConcurrentLinkedQueue<NativeJobInfo> sysPermissionQueue;
  public Handler uiHandler;
  
  public BaseJsPluginEngine()
  {
    this(null);
  }
  
  public BaseJsPluginEngine(BaseAppBrandRuntime paramBaseAppBrandRuntime)
  {
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "miniappcheckstoragepermission", 0) == 1) {}
    for (;;)
    {
      this.checkStoragePermission = bool;
      this.onceSubDismissListener = new BaseJsPluginEngine.9(this);
      this.dismissListener = new BaseJsPluginEngine.10(this);
      this.appBrandRuntime = paramBaseAppBrandRuntime;
      this.jobQueue = new ConcurrentLinkedQueue();
      this.sysPermissionQueue = new ConcurrentLinkedQueue();
      this.uiHandler = new Handler(Looper.getMainLooper(), this);
      return;
      bool = false;
    }
  }
  
  public static void assertInMainThread()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (arrayOfStackTraceElement != null)
      {
        localObject1 = localObject2;
        if (arrayOfStackTraceElement.length >= 4) {
          localObject1 = arrayOfStackTraceElement[3].toString();
        }
      }
      throw new IllegalStateException("Call the method must be in main thread: " + (String)localObject1);
    }
  }
  
  private String grantApiPermission(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    IJsPlugin localIJsPlugin = getEventHandler(paramString1);
    if (localIJsPlugin != null)
    {
      reportApiInvoke(paramString1);
      return localIJsPlugin.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
    }
    QLog.w("BaseJsPluginEngine", 2, "handleNativeRequest fail,event not support! eventName=" + paramString1 + "，jsonParams=" + paramString2 + ",webview=" + paramJsRuntime + ",callbackId=" + paramInt);
    callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
    return "";
  }
  
  private String handleNativeRequestInner(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt, boolean paramBoolean)
  {
    int i = this.authorizeCenter.getAuthFlag(paramString1, paramString2);
    if (paramString1.equals("subscribeAppMsg"))
    {
      reqGrantSubscribeApiPermission(paramString2, paramJsRuntime, paramInt);
      paramJsRuntime = "";
      return paramJsRuntime;
    }
    if (paramString1.equals("subscribeOnceAppMsg"))
    {
      reqGrantOnceSubscribeApiPermission(paramString2, paramJsRuntime, paramInt);
      return "";
    }
    String str;
    if (i == 1) {
      if (!apiAuthoritySilent())
      {
        if (this.appBrandRuntime != null)
        {
          str = this.appBrandRuntime.appId;
          label86:
          if (!isAuthWhiteAppId(str)) {
            break label274;
          }
        }
      }
      else
      {
        str = AuthorizeCenter.getScopeName(paramString1, paramString2);
        if (!TextUtils.isEmpty(str))
        {
          this.authorizeCenter.setAuthorize(str, true);
          QLog.i("BaseJsPluginEngine", 1, "apiAuthoritySilent setAuthorize : " + str);
        }
        i = 2;
      }
    }
    label274:
    label317:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseJsPluginEngine", 2, "handleNativeRequest authFlag=" + i + ",eventName=" + paramString1 + ",callbackId=" + paramInt);
      }
      if ((i == 2) || ("getPhoneNumber".equals(paramString1)))
      {
        str = grantApiPermission(paramString1, paramString2, paramJsRuntime, paramInt);
        paramJsRuntime = str;
        if (this.jobQueue.size() <= 0) {
          break;
        }
        paramJsRuntime = str;
        if (!AuthorizeCenter.isInScopeList(paramString1, paramString2)) {
          break;
        }
        this.uiHandler.obtainMessage(1).sendToTarget();
        return str;
        str = null;
        break label86;
        if (paramBoolean)
        {
          i = 2;
          continue;
        }
        if (!this.authorizeCenter.shouldAskEveryTime(paramString1, paramString2)) {
          break label317;
        }
        i = 1;
        continue;
      }
      reqGrantApiPermission(paramString1, paramString2, paramJsRuntime, paramInt, true);
      return "";
    }
  }
  
  private void handleOnceSubscribeResponse(String paramString, JsRuntime paramJsRuntime, int paramInt, boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean) {}
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      ArrayList localArrayList3;
      int i;
      INTERFACE.StSubscribeMessage localStSubscribeMessage;
      try
      {
        if (!"setting.onceMsgSubscribed".equals(paramJSONObject.optString("settingItem")))
        {
          QLog.e("BaseJsPluginEngine", 1, "handleOnceSubscribeResponse settingItem is no 'setting.onceMsgSubscribed'!");
          return;
        }
        localObject1 = paramJSONObject.optString("originalData");
        localObject2 = new INTERFACE.StGetUserSettingRsp();
        localObject1 = ((String)localObject1).getBytes();
        ((INTERFACE.StGetUserSettingRsp)localObject2).mergeFrom((byte[])localObject1);
        localObject2 = ((INTERFACE.StGetUserSettingRsp)localObject2).setting.subItems.get();
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        localArrayList3 = new ArrayList();
        i = 0;
        if (i >= ((List)localObject2).size()) {
          break label229;
        }
        localStSubscribeMessage = (INTERFACE.StSubscribeMessage)((List)localObject2).get(i);
        if (localStSubscribeMessage.authState.get() == 0) {
          localArrayList1.add(localStSubscribeMessage);
        } else if (localStSubscribeMessage.authState.get() == 1) {
          localArrayList2.add(localStSubscribeMessage);
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("BaseJsPluginEngine", 2, "handleOnceSubscribeResponse get an Error:", paramString);
      }
      onceSubMsgCallbackFail(paramJsRuntime, paramJSONObject, paramInt);
      return;
      if (localStSubscribeMessage.authState.get() == 2)
      {
        localArrayList3.add(localStSubscribeMessage);
        break label330;
        label229:
        if ((localArrayList2.size() > 0) || (localArrayList3.size() > 0)) {
          this.authorizeCenter.updateIsOnceSubMsgMaintain(true);
        }
        if ((localArrayList1.size() > 0) && (localArrayList1.size() <= 3))
        {
          showOnceSubMsgReqDialog(paramString, paramJsRuntime, paramInt, (byte[])localObject1);
          return;
        }
        if (localArrayList2.size() > 0)
        {
          this.authorizeCenter.updateOnceSubMsgSetting(true, localArrayList2, new BaseJsPluginEngine.4(this, paramJsRuntime, (List)localObject2, paramInt));
          return;
        }
        onceSubMsgCallbackSuc(paramJsRuntime, (List)localObject2, paramInt);
        return;
      }
      label330:
      i += 1;
    }
  }
  
  public static void initAuthWhiteList()
  {
    try
    {
      if (authWhiteList == null)
      {
        String str1 = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppAuthWhiteList", "1108292102");
        if ((str1 != null) && (!str1.equals(mCurWhiteListConfig)))
        {
          QLog.i("BaseJsPluginEngine", 1, "Default white appid:" + str1);
          authWhiteList = new ArrayList();
          try
          {
            String[] arrayOfString = str1.split(",");
            if (arrayOfString != null)
            {
              int j = arrayOfString.length;
              int i = 0;
              while (i < j)
              {
                String str2 = arrayOfString[i];
                if (!TextUtils.isEmpty(str2)) {
                  authWhiteList.add(str2);
                }
                i += 1;
              }
            }
          }
          catch (Throwable localThrowable)
          {
            QLog.e("BaseJsPluginEngine", 1, "initAuthWhiteList error,", localThrowable);
            mCurWhiteListConfig = str1;
          }
        }
      }
      return;
    }
    finally {}
  }
  
  private void initDefaultBlackMap()
  {
    if (this.defaultBlackList == null) {
      this.defaultBlackList = new ArrayList();
    }
    this.defaultBlackList.add("requestPayment");
    this.defaultBlackList.add("requestMidasPayment");
    this.defaultBlackList.add("requestPaymentToBank");
    this.defaultBlackList.add("reportSubmitForm");
    this.defaultBlackList.add("insertHTMLWebView");
    this.defaultBlackList.add("updateHTMLWebView");
    this.defaultBlackList.add("removeHTMLWebView");
    this.defaultBlackList.add("onWebInvokeAppService");
    this.defaultBlackList.add("insertLivePusher");
    this.defaultBlackList.add("updateLivePusher");
    this.defaultBlackList.add("removeLivePusher");
    this.defaultBlackList.add("operateLivePusher");
    this.defaultBlackList.add("onLivePusherEvent");
    this.defaultBlackList.add("onLivePusherNetStatus");
    this.defaultBlackList.add("insertLivePlayer");
    this.defaultBlackList.add("updateLivePlayer");
    this.defaultBlackList.add("removeLivePlayer");
    this.defaultBlackList.add("operateLivePlayer");
    this.defaultBlackList.add("onLivePlayerEvent");
    this.defaultBlackList.add("onLivePlayerFullScreenChange");
    this.defaultBlackList.add("onLivePlayerNetStatus");
    this.defaultBlackList.add("shareAppPictureMessage");
    this.defaultBlackList.add("shareAppPictureMessageDirectly");
    this.defaultBlackList.add("getPhoneNumber");
    this.defaultBlackList.add("wnsRequest");
    this.defaultBlackList.add("getQua");
    this.defaultBlackList.add("notifyNative");
    this.defaultBlackList.add("openUrl");
    this.defaultBlackList.add("getUserInfoExtra");
    this.defaultBlackList.add("openScheme");
    this.defaultBlackList.add("Personalize");
    this.defaultBlackList.add("invokeNativePlugin");
    if (this.secondApiMap == null) {
      this.secondApiMap = new HashMap();
    }
    this.secondApiMap.put("openScheme", new HashMap());
    this.secondApiMap.put("Personalize", new HashMap());
    this.secondApiMap.put("invokeNativePlugin", new HashMap());
    this.defaultBlackList.add("startDownloadAppTask");
    this.defaultBlackList.add("cancelDownloadAppTask");
    this.defaultBlackList.add("queryDownloadAppTask");
    this.defaultBlackList.add("queryAppInfo");
    this.defaultBlackList.add("installApp");
    this.defaultBlackList.add("startApp");
    this.defaultBlackList.add("showMiniAIOEntrance");
    this.defaultBlackList.add("hideMiniAIOEntrance");
    this.defaultBlackList.add("getGroupInfoExtra");
    this.defaultBlackList.add("wnsGroupRequest");
  }
  
  public static boolean isAuthWhiteAppId(String paramString)
  {
    if ((authWhiteList != null) && (authWhiteList.size() > 0) && (!TextUtils.isEmpty(paramString))) {
      return authWhiteList.contains(paramString);
    }
    return false;
  }
  
  private boolean isEventNameRight(String paramString1, String paramString2)
  {
    if ((this.firstApiMap != null) && (this.firstApiMap.containsKey(paramString1)))
    {
      if (((Integer)this.firstApiMap.get(paramString1)).intValue() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BaseJsPluginEngine_isEventNameRight", 2, "false, first level blacklist : " + paramString1);
        }
        return false;
      }
      if (((Integer)this.firstApiMap.get(paramString1)).intValue() == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BaseJsPluginEngine_isEventNameRight", 2, "true, first level whitelist: " + paramString1);
        }
        return true;
      }
    }
    if ((this.secondApiMap != null) && (this.secondApiMap.containsKey(paramString1)))
    {
      if ((this.secondApiMap.get(paramString1) != null) && (((HashMap)this.secondApiMap.get(paramString1)).containsKey(paramString2)) && (((Integer)((HashMap)this.secondApiMap.get(paramString1)).get(paramString2)).intValue() == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BaseJsPluginEngine_isEventNameRight", 2, "true, second level whitelist: " + paramString1 + " " + paramString2);
        }
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BaseJsPluginEngine_isEventNameRight", 2, "false, second level blacklist or not config: " + paramString1 + " " + paramString2);
      }
      return false;
    }
    if ((this.defaultBlackList != null) && (this.defaultBlackList.contains(paramString1)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseJsPluginEngine_isEventNameRight", 2, "false, local blacklist : " + paramString1);
      }
      return false;
    }
    if (QLog.isDebugVersion()) {
      QLog.d("BaseJsPluginEngine_isEventNameRight", 1, "true, permissible api : " + paramString1);
    }
    return true;
  }
  
  private boolean judgeOnceSubMsgState(boolean paramBoolean1, boolean paramBoolean2, INTERFACE.StSubscribeMessage paramStSubscribeMessage)
  {
    boolean bool = false;
    if (paramBoolean1) {
      if (paramBoolean2) {
        paramStSubscribeMessage.authState.set(1);
      }
    }
    for (;;)
    {
      paramBoolean1 = true;
      do
      {
        return paramBoolean1;
        paramStSubscribeMessage.authState.set(2);
        break;
        paramBoolean1 = bool;
      } while (!paramBoolean2);
      paramStSubscribeMessage.authState.set(0);
    }
  }
  
  private void removeAllMessage()
  {
    this.uiHandler.removeMessages(1);
    this.uiHandler.removeMessages(2);
    this.uiHandler.removeMessages(3);
    this.uiHandler.removeMessages(4);
  }
  
  private void reportApiInvoke(String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new BaseJsPluginEngine.5(this, paramString));
  }
  
  private void reqGrantApiPermission(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt, boolean paramBoolean)
  {
    boolean bool1;
    if (this.authorizeCenter.getAuthFlag(paramString1, paramString2) == 4)
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("BaseJsPluginEngine", 2, "handleNativeRequest hasRefused=" + bool1 + ",isPause=" + this.isPause);
      }
      if ((bool1) && (!this.authorizeCenter.shouldAskEveryTime(paramString1, paramString2))) {
        break label303;
      }
      bool1 = true;
    }
    for (;;)
    {
      try
      {
        if (!"operateWXData".equals(paramString1)) {
          continue;
        }
        localObject = new JSONObject(paramString2).optJSONObject("data");
        String str = ((JSONObject)localObject).optString("api_name");
        if ((!"webapi_getuserinfo".equals(str)) && (!"getSubjectalterInfo".equals(str)))
        {
          bool2 = bool1;
          if (!"webapi_wxa_subscribe_biz".endsWith(str)) {}
        }
        else
        {
          bool2 = ((JSONObject)localObject).optBoolean("from_component");
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        label303:
        boolean bool3;
        QZLog.e("BaseJsPluginEngine", 2, new Object[] { Log.getStackTraceString(localThrowable) });
        boolean bool2 = bool1;
        continue;
        QLog.d("BaseJsPluginEngine", 2, "handleNativeRequest callbackJsEventFail");
        callbackJsEventFail(paramJsRuntime, paramString1, null, "auth deny", paramInt);
        this.uiHandler.obtainMessage(1).sendToTarget();
      }
      if (!bool2) {
        continue;
      }
      if (paramBoolean)
      {
        paramJsRuntime = new NativeJobInfo(paramString1, paramString2, paramJsRuntime, paramInt);
        this.jobQueue.offer(paramJsRuntime);
      }
      if ((!this.isPause) && ((this.authDialog == null) || (!this.authDialog.isShowing())))
      {
        paramJsRuntime = this.uiHandler.obtainMessage(2);
        localObject = new Bundle();
        ((Bundle)localObject).putString("key_event_name", paramString1);
        ((Bundle)localObject).putString("key_params", paramString2);
        ((Bundle)localObject).putInt("key_callback_id", paramInt);
        if (this.appBrandRuntime != null) {
          ((Bundle)localObject).putString("key_app_id", this.appBrandRuntime.appId);
        }
        paramJsRuntime.setData((Bundle)localObject);
        paramJsRuntime.sendToTarget();
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      bool2 = bool1;
      if ("authorize".equals(paramString1))
      {
        bool3 = "scope.userInfo".equals(((JSONArray)new JSONObject(paramString2).get("scope")).get(0));
        bool2 = bool1;
        if (bool3) {
          bool2 = false;
        }
      }
    }
  }
  
  private void reqGrantOnceSubscribeApiPermission(String paramString, JsRuntime paramJsRuntime, int paramInt)
  {
    JSONArray localJSONArray;
    ArrayList localArrayList;
    try
    {
      localJSONArray = new JSONObject(paramString).optJSONArray("tmplIds");
      if (localJSONArray == null) {
        break label169;
      }
      localArrayList = new ArrayList();
      if (localJSONArray.length() > 3)
      {
        onceSubMsgCallbackFail(paramJsRuntime, "Templates count out of max bounds", 20003, paramInt);
        return;
      }
      if (localJSONArray.length() == 0)
      {
        onceSubMsgCallbackFail(paramJsRuntime, "TmplIds can't be empty", 10001, paramInt);
        return;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("BaseJsPluginEngine", 1, "reqGrantOnceSubscribeApiPermission get an Exception:" + paramString);
      return;
    }
    int i = 0;
    while (i < localJSONArray.length())
    {
      localArrayList.add(localJSONArray.getString(i));
      i += 1;
    }
    MiniAppCmdUtil.getInstance().getUserSetting(this.appBrandRuntime.appId, "", "setting.onceMsgSubscribed", localArrayList, new BaseJsPluginEngine.3(this, paramString, paramJsRuntime, paramInt));
    return;
    label169:
    QLog.e("BaseJsPluginEngine", 1, "reqGrantOnceSubscribeApiPermission: tmplIdJsonArr is null!");
    onceSubMsgCallbackFail(paramJsRuntime, "TmplIds can't be empty", 10001, paramInt);
  }
  
  private void reqGrantSubscribeApiPermission(String paramString, JsRuntime paramJsRuntime, int paramInt)
  {
    int i = this.authorizeCenter.getAuthFlag("subscribeAppMsg", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("BaseJsPluginEngine", 2, "reqGrantSubscribeApiPermission authFlag=" + i + ",isPause=" + this.isPause);
    }
    try
    {
      Object localObject = new BaseJsPluginEngine.2(this, paramJsRuntime, paramInt);
      if ((i == 1) && (!this.isSubAuthPassed))
      {
        this.isFirstTimeRequestAuth = true;
        localObject = new NativeJobInfo("subscribeAppMsg", paramString, paramJsRuntime, paramInt);
        this.jobQueue.offer(localObject);
        if ((this.isPause) || ((this.authDialog != null) && (this.authDialog.isShowing()))) {
          return;
        }
        localObject = this.uiHandler.obtainMessage(2);
        Bundle localBundle = new Bundle();
        localBundle.putString("key_event_name", "subscribeAppMsg");
        localBundle.putString("key_params", paramString);
        ((Message)localObject).setData(localBundle);
        ((Message)localObject).sendToTarget();
        return;
      }
      if (i == 2)
      {
        this.isFirstTimeRequestAuth = false;
        this.authorizeCenter.setAuthorize(AuthorizeCenter.getScopeName("subscribeAppMsg", paramString), true, (MiniAppCmdInterface)localObject);
        return;
      }
    }
    catch (JSONException paramString)
    {
      callbackJsEventFail(paramJsRuntime, "subscribeAppMsg", null, acfp.m(2131703110), paramInt);
      return;
    }
    if ((i == 4) || (this.isSubAuthPassed))
    {
      if (this.isSubAuthPassed)
      {
        paramString = new JSONObject();
        paramString.put("SubscribeAppMsgCode", -2);
        callbackJsEventFail(paramJsRuntime, "subscribeAppMsg", paramString, "user pass auth", paramInt);
        this.isSubAuthPassed = false;
        return;
      }
      if (this.isFirstTimeRequestAuth)
      {
        paramString = new JSONObject();
        paramString.put("SubscribeAppMsgCode", 0);
        callbackJsEventFail(paramJsRuntime, "subscribeAppMsg", paramString, "no permission", paramInt);
        this.isFirstTimeRequestAuth = false;
        return;
      }
      paramString = new JSONObject();
      paramString.put("SubscribeAppMsgCode", -1);
      callbackJsEventFail(paramJsRuntime, "subscribeAppMsg", paramString, "no permission", paramInt);
    }
  }
  
  private void showOnceSubMsgReqDialog(String paramString, JsRuntime paramJsRuntime, int paramInt, byte[] paramArrayOfByte)
  {
    if ((!this.isPause) && ((this.authDialog == null) || (!this.authDialog.isShowing())))
    {
      this.onceSubWebView = paramJsRuntime;
      this.onceSubCallbackId = paramInt;
      paramJsRuntime = this.uiHandler.obtainMessage(2);
      Bundle localBundle = new Bundle();
      localBundle.putString("key_event_name", "subscribeOnceAppMsg");
      localBundle.putString("key_params", paramString);
      localBundle.putByteArray("key_once_sub_rsp_data", paramArrayOfByte);
      paramJsRuntime.setData(localBundle);
      paramJsRuntime.sendToTarget();
    }
  }
  
  public boolean apiAuthoritySilent()
  {
    return (this.appBrandRuntime != null) && (this.appBrandRuntime.getApkgInfo() != null) && (this.appBrandRuntime.getApkgInfo().appConfig != null) && (this.appBrandRuntime.getApkgInfo().appConfig.config != null) && ((this.appBrandRuntime.getApkgInfo().appConfig.config.isAppStoreMiniApp()) || (this.appBrandRuntime.getApkgInfo().appConfig.config.appMode.authoritySilent));
  }
  
  public void callbackJsEventCancel(JsRuntime paramJsRuntime, String paramString, JSONObject paramJSONObject, int paramInt) {}
  
  public void callbackJsEventFail(JsRuntime paramJsRuntime, String paramString, JSONObject paramJSONObject, int paramInt) {}
  
  public void callbackJsEventFail(JsRuntime paramJsRuntime, String paramString1, JSONObject paramJSONObject, String paramString2, int paramInt) {}
  
  public void callbackJsEventOK(JsRuntime paramJsRuntime, String paramString, JSONObject paramJSONObject, int paramInt) {}
  
  public ActivityContext getActivityContext()
  {
    return this.activityContext;
  }
  
  public MiniAppInfo getAppInfo()
  {
    if ((this.appBrandRuntime != null) && (this.appBrandRuntime.getApkgInfo() != null) && (this.appBrandRuntime.getApkgInfo().appConfig != null) && (this.appBrandRuntime.getApkgInfo().appConfig.config != null)) {
      return this.appBrandRuntime.getApkgInfo().appConfig.config;
    }
    return null;
  }
  
  public int getCurInputId()
  {
    return curInputId;
  }
  
  @Nullable
  public EntryModel getEntryModel()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.appBrandRuntime != null)
    {
      localObject1 = localObject2;
      if (this.appBrandRuntime.getApkgInfo() != null)
      {
        localObject1 = localObject2;
        if (this.appBrandRuntime.getApkgInfo().appConfig != null)
        {
          localObject1 = localObject2;
          if (this.appBrandRuntime.getApkgInfo().appConfig.launchParam != null) {
            localObject1 = this.appBrandRuntime.getApkgInfo().appConfig.launchParam.entryModel;
          }
        }
      }
    }
    return localObject1;
  }
  
  @Nullable
  protected final IJsPlugin getEventHandler(@NonNull String paramString)
  {
    return (IJsPlugin)this.mPluginEventMap.get(paramString);
  }
  
  public <T> T getNativeBufferPool()
  {
    return null;
  }
  
  public String getPkgName()
  {
    return "";
  }
  
  public JsRuntime getServiceRuntime()
  {
    return null;
  }
  
  public WebviewContainer getWebviewContainer(JsRuntime paramJsRuntime)
  {
    if ((paramJsRuntime instanceof PageWebview))
    {
      AbsAppBrandPage localAbsAppBrandPage = ((AppBrandPageContainer)this.appBrandRuntime.getContainer()).getPageByWebViewId(paramJsRuntime.getPageWebViewId());
      paramJsRuntime = ((PageWebview)paramJsRuntime).getRouteUrl();
      if (localAbsAppBrandPage != null) {
        return localAbsAppBrandPage.getWebviewContainerByUrl(paramJsRuntime);
      }
    }
    else
    {
      return this.appBrandRuntime.getCurWebviewContainer();
    }
    return null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("BaseJsPluginEngine", 2, "handleMessage what=" + paramMessage.what + ",isDestory=" + this.isDestory);
    }
    if ((this.isDestory) || (this.isPause)) {
      return false;
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    switch (paramMessage.what)
    {
    case 3: 
    default: 
      return false;
    case 1: 
      localObject1 = this.jobQueue.iterator();
      if ((paramMessage.arg1 == 3) || (paramMessage.arg1 == 2))
      {
        localObject2 = (String)paramMessage.obj;
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject2).equals("setting.appMsgSubscribed"))) {
          if (((String)localObject2).equals("scope.camera")) {
            getServiceRuntime().evaluateSubcribeJS("onCameraNeedAuthCancel", null, 0);
          }
        }
      }
      break;
    case 2: 
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          paramMessage = (NativeJobInfo)((Iterator)localObject1).next();
          if (((String)localObject2).equals(AuthorizeCenter.getScopeName(paramMessage.eventName, paramMessage.jsonParams)))
          {
            ((Iterator)localObject1).remove();
            callbackJsEventFail((JsRuntime)paramMessage.jsRuntimeRef.get(), paramMessage.eventName, null, "auth deny", paramMessage.callbackId);
            continue;
            paramMessage = paramMessage.getData();
            localObject1 = paramMessage.getString("key_event_name", "");
            localObject3 = paramMessage.getString("key_params", "");
            if (!"getPhoneNumber".equals(localObject1)) {
              break;
            }
          }
        }
      }
    }
    for (;;)
    {
      label288:
      this.authDialog = new AuthDialog(this.activityContext, i);
      if ("subscribeOnceAppMsg".equals(localObject1)) {
        this.authDialog.setOnDismissListener(this.onceSubDismissListener);
      }
      String str1;
      String str2;
      String str3;
      for (;;)
      {
        this.authDialog.bindData(paramMessage);
        String str4 = AuthorizeCenter.getScopeName((String)localObject1, (String)localObject3);
        if (str4 == null) {
          break;
        }
        localObject2 = (String)AuthorizeCenter.scopeTitleMap.get(str4);
        str1 = (String)AuthorizeCenter.scopeDescMap.get(str4);
        localObject1 = (String)AuthorizeCenter.negativeButtonDesMap.get(str4);
        paramMessage = (Message)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          paramMessage = acfp.m(2131703113);
        }
        if (this.appBrandRuntime == null) {
          break;
        }
        localObject1 = this.appBrandRuntime.getApkgInfo();
        if (localObject1 == null) {
          break;
        }
        str2 = ((ApkgInfo)localObject1).iconUrl;
        str3 = ((ApkgInfo)localObject1).apkgName;
        if (!"scope.userInfo".equals(str4)) {
          break label506;
        }
        MiniAppCmdUtil.getInstance().getUserInfo(this.appBrandRuntime.appId, false, "en", new BaseJsPluginEngine.6(this, str2, str3, (String)localObject2, str1));
        return false;
        if (!"subscribeOnceAppMsg".equals(localObject1)) {
          break label940;
        }
        i = 3;
        break label288;
        this.authDialog.setOnDismissListener(this.dismissListener);
      }
      label506:
      if ((this.authDialog == null) || (this.isPause)) {
        break;
      }
      try
      {
        localObject1 = new JSONObject((String)localObject3).optJSONObject("getPhoneNumber");
        if ((localObject1 == null) || (!((JSONObject)localObject1).has("phoneLists"))) {
          break label665;
        }
        localObject1 = ((JSONObject)localObject1).optJSONArray("phoneLists");
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("BaseJsPluginEngine", 1, "get phoneNumberList error,", localThrowable);
          localIterator = null;
        }
      }
      localObject3 = new AuthDialog.AuthDialogResBuilder();
      ((AuthDialog.AuthDialogResBuilder)localObject3).setMiniAppIconUrl(str2).setMiniAppName(str3).setAuthTitle((String)localObject2).setAuthDesc(str1).setLeftBtnText(paramMessage).setLeftBtnClickListener(new BaseJsPluginEngine.8(this)).setRightBtnText(acfp.m(2131703111)).setRightBtnClickListener(new BaseJsPluginEngine.7(this));
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0)) {
        ((AuthDialog.AuthDialogResBuilder)localObject3).setPhoneNumberList((JSONArray)localObject1);
      }
      this.authDialog.show((AuthDialog.AuthDialogResBuilder)localObject3);
      return false;
      label665:
      Iterator localIterator = this.sysPermissionQueue.iterator();
      if ((paramMessage.arg1 == 3) || (paramMessage.arg1 == 2))
      {
        paramMessage = (String)paramMessage.obj;
        if (TextUtils.isEmpty(paramMessage)) {
          break;
        }
        if (paramMessage.equals("android.permission.CAMERA")) {
          getServiceRuntime().evaluateSubcribeJS("onCameraNeedAuthCancel", null, 0);
        }
        while (localIterator.hasNext())
        {
          localObject2 = (NativeJobInfo)localIterator.next();
          if (paramMessage.equals(AuthorizeCenter.systemPermissionMap.get(((NativeJobInfo)localObject2).eventName)))
          {
            localIterator.remove();
            callbackJsEventFail((JsRuntime)((NativeJobInfo)localObject2).jsRuntimeRef.get(), ((NativeJobInfo)localObject2).eventName, null, "auth deny", ((NativeJobInfo)localObject2).callbackId);
          }
        }
        break;
      }
      paramMessage = (NativeJobInfo)this.sysPermissionQueue.peek();
      if (paramMessage == null) {
        break;
      }
      this.jobQueue.remove(paramMessage);
      handleNativeRequest(paramMessage.eventName, paramMessage.jsonParams, (JsRuntime)paramMessage.jsRuntimeRef.get(), paramMessage.callbackId);
      return false;
      if ((((String)localObject2).equals("setting.appMsgSubscribed")) && (paramMessage.arg1 == 3)) {
        this.isSubAuthPassed = true;
      }
      paramMessage = (NativeJobInfo)this.jobQueue.peek();
      if (paramMessage == null) {
        break;
      }
      this.jobQueue.remove(paramMessage);
      handleNativeRequestInner(paramMessage.eventName, paramMessage.jsonParams, (JsRuntime)paramMessage.jsRuntimeRef.get(), paramMessage.callbackId, true);
      return false;
      label940:
      i = 1;
    }
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramJsRuntime == null) || (this.isDestory))
    {
      QLog.w("BaseJsPluginEngine", 1, "handleNativeRequest fail eventName=" + paramString1 + ",webview=" + paramJsRuntime + ",callbackId=" + paramInt + ",isDestory=" + this.isDestory);
      return "";
    }
    String str2 = "";
    String str1 = str2;
    Object localObject;
    try
    {
      if (this.secondApiMap != null)
      {
        str1 = str2;
        if (this.secondApiMap.containsKey(paramString1))
        {
          JSONObject localJSONObject = new JSONObject(paramString2);
          str1 = str2;
          if (localJSONObject.has("api_name")) {
            str1 = localJSONObject.optString("api_name", "");
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("BaseJsPluginEngine", 1, "handleNativeRequest get apiName error.", localException);
        localObject = str2;
      }
      callbackJsEventFail(paramJsRuntime, paramString1, null, "no permission", paramInt);
      return "";
    }
    if ((!isMiniAppStore()) && (!isEventNameRight(paramString1, str1)))
    {
      QLog.e("BaseJsPluginEngine", 1, "eventname : " + paramString1 + "; apiName : " + str1 + " request failed.");
      if (paramString1.endsWith("Sync")) {
        return ApiUtil.wrapCallbackFail(paramString1, null, "no permission").toString();
      }
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (this.appBrandRuntime != null)
      {
        localObject = this.appBrandRuntime.activity;
        if ((localObject == null) || (!(localObject instanceof BaseActivity))) {
          break label393;
        }
        localObject = (BaseActivity)localObject;
        label313:
        if (localObject != null)
        {
          str2 = AuthorizeCenter.getSystemPermission(paramString1, paramString2);
          if (aqmr.isEmpty(str2)) {
            break label443;
          }
          if (((BaseActivity)localObject).checkSelfPermission(str2) != 0) {
            break label399;
          }
        }
      }
      label393:
      label399:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label405;
        }
        ((BaseActivity)localObject).requestPermissions(new BaseJsPluginEngine.1(this, paramString1, paramString2, paramJsRuntime, paramInt, str2, (BaseActivity)localObject), 1, new String[] { str2 });
        return "";
        localObject = null;
        break;
        localObject = null;
        break label313;
      }
      label405:
      QLog.d("BaseJsPluginEngine", 2, str2 + " has granted permission!!!");
      return handleNativeRequestInner(paramString1, paramString2, paramJsRuntime, paramInt, false);
      label443:
      return handleNativeRequestInner(paramString1, paramString2, paramJsRuntime, paramInt, false);
    }
    return handleNativeRequestInner(paramString1, paramString2, paramJsRuntime, paramInt, false);
  }
  
  public void init()
  {
    initDefaultBlackMap();
    initAuthWhiteList();
  }
  
  public boolean isMiniAppStore()
  {
    return (this.appBrandRuntime != null) && (this.appBrandRuntime.getApkgInfo() != null) && (this.appBrandRuntime.getApkgInfo().appConfig != null) && (this.appBrandRuntime.getApkgInfo().appConfig.config != null) && (this.appBrandRuntime.getApkgInfo().appConfig.config.isAppStoreMiniApp());
  }
  
  public void onAttachWindow(ActivityContext paramActivityContext)
  {
    this.activityContext = paramActivityContext;
  }
  
  public void onCreate()
  {
    assertInMainThread();
    this.authorizeCenter = this.appBrandRuntime.appInterface.getAuthorizeCenter(this.appBrandRuntime.appId);
    Object localObject1;
    if ((this.appBrandRuntime.getApkgInfo() != null) && (this.appBrandRuntime.getApkgInfo().appConfig != null) && (this.appBrandRuntime.getApkgInfo().appConfig.config != null))
    {
      if (this.firstApiMap == null) {
        this.firstApiMap = new HashMap();
      }
      localObject1 = this.appBrandRuntime.getApkgInfo().appConfig.config.whiteList;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            if (QLog.isColorLevel()) {
              QLog.d("BaseJsPluginEngine", 2, "whiteList eventName : " + (String)localObject2);
            }
            this.firstApiMap.put(localObject2, Integer.valueOf(1));
          }
        }
      }
      localObject1 = this.appBrandRuntime.getApkgInfo().appConfig.config.blackList;
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            if (QLog.isColorLevel()) {
              QLog.d("BaseJsPluginEngine", 2, "blackList eventName : " + (String)localObject2);
            }
            this.firstApiMap.put(localObject2, Integer.valueOf(0));
          }
        }
      }
      localObject1 = this.appBrandRuntime.getApkgInfo().appConfig.config.secondApiRightInfoList;
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (SecondApiRightInfo)((Iterator)localObject1).next();
          if (localObject2 != null) {
            if (this.secondApiMap.containsKey(((SecondApiRightInfo)localObject2).apiName))
            {
              if (QLog.isColorLevel()) {
                QLog.d("BaseJsPluginEngine", 2, "config apiName : " + ((SecondApiRightInfo)localObject2).apiName + ", secondName: " + ((SecondApiRightInfo)localObject2).secondName);
              }
              ((HashMap)this.secondApiMap.get(((SecondApiRightInfo)localObject2).apiName)).put(((SecondApiRightInfo)localObject2).secondName, Integer.valueOf(((SecondApiRightInfo)localObject2).right));
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d("BaseJsPluginEngine", 2, "init config apiName : " + ((SecondApiRightInfo)localObject2).apiName + ", secondName: " + ((SecondApiRightInfo)localObject2).secondName);
              }
              HashMap localHashMap = new HashMap();
              localHashMap.put(((SecondApiRightInfo)localObject2).secondName, Integer.valueOf(((SecondApiRightInfo)localObject2).right));
              this.secondApiMap.put(((SecondApiRightInfo)localObject2).apiName, localHashMap);
            }
          }
        }
      }
    }
    this.isPause = false;
    this.isDestory = false;
    if (!this.isCreated)
    {
      this.isCreated = true;
      localObject1 = this.mPluginList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((IJsPlugin)((Iterator)localObject1).next()).onCreate(this);
      }
    }
  }
  
  public void onDestroy()
  {
    this.isPause = true;
    this.isDestory = true;
    this.isCreated = false;
    Iterator localIterator = this.mPluginList.iterator();
    while (localIterator.hasNext()) {
      ((IJsPlugin)localIterator.next()).onDestroy();
    }
    this.mPluginList.clear();
    this.mPluginEventMap.clear();
    if (this.firstApiMap != null) {
      this.firstApiMap.clear();
    }
    this.jobQueue.clear();
    removeAllMessage();
    if (this.authDialog != null)
    {
      this.authDialog.setOnDismissListener(null);
      this.authDialog.dismiss();
      this.authDialog = null;
    }
  }
  
  public void onPause()
  {
    this.isPause = true;
    Iterator localIterator = this.mPluginList.iterator();
    while (localIterator.hasNext()) {
      ((IJsPlugin)localIterator.next()).onPause();
    }
    removeAllMessage();
  }
  
  public void onResume()
  {
    this.isPause = false;
    Iterator localIterator = this.mPluginList.iterator();
    while (localIterator.hasNext()) {
      ((IJsPlugin)localIterator.next()).onResume();
    }
    this.uiHandler.obtainMessage(1).sendToTarget();
    this.uiHandler.obtainMessage(4).sendToTarget();
  }
  
  public void onceSubMsgCallbackFail(JsRuntime paramJsRuntime, String paramString, int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", paramInt1);
      callbackJsEventFail(paramJsRuntime, "subscribeOnceAppMsg", localJSONObject, paramString, paramInt2);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("BaseJsPluginEngine", 1, "onceSubMsgCallbackFail get a JSONException:", localJSONException);
      }
    }
  }
  
  public void onceSubMsgCallbackFail(JsRuntime paramJsRuntime, JSONObject paramJSONObject, int paramInt)
  {
    callbackJsEventFail(paramJsRuntime, "subscribeOnceAppMsg", paramJSONObject, paramInt);
  }
  
  public void onceSubMsgCallbackSuc(JsRuntime paramJsRuntime, List<INTERFACE.StSubscribeMessage> paramList, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errMsg", "subscribeOnceAppMsg:ok");
      int i = 0;
      if (i < paramList.size())
      {
        Object localObject = (INTERFACE.StSubscribeMessage)paramList.get(i);
        String str = ((INTERFACE.StSubscribeMessage)localObject).templateId.get();
        if (((INTERFACE.StSubscribeMessage)localObject).authState.get() == 1) {}
        for (localObject = "accept";; localObject = "reject")
        {
          localJSONObject.put(str, localObject);
          i += 1;
          break;
        }
      }
      return;
    }
    catch (Exception paramList)
    {
      QLog.e("BaseJsPluginEngine", 1, "onceSubMsgCallbackSuc get a Exception:", paramList);
      callbackJsEventOK(paramJsRuntime, "subscribeOnceAppMsg", localJSONObject, paramInt);
    }
  }
  
  public void onceSubMsgCallbackSuc(JsRuntime paramJsRuntime, List<INTERFACE.StSubscribeMessage> paramList1, List<INTERFACE.StSubscribeMessage> paramList2, List<INTERFACE.StSubscribeMessage> paramList3, boolean paramBoolean, int paramInt)
  {
    int k = 0;
    int i = 0;
    JSONObject localJSONObject = new JSONObject();
    label97:
    Object localObject;
    try
    {
      localJSONObject.put("errMsg", "subscribeOnceAppMsg:ok");
      if (!paramBoolean) {
        break label336;
      }
      while (i < paramList1.size())
      {
        paramList2 = (INTERFACE.StSubscribeMessage)paramList1.get(i);
        paramList3 = paramList2.templateId.get();
        if (paramList2.authState.get() != 1) {
          break label329;
        }
        paramList2 = "accept";
        localJSONObject.put(paramList3, paramList2);
        i += 1;
        continue;
        if (i >= paramList1.size()) {
          break label209;
        }
        localObject = (INTERFACE.StSubscribeMessage)paramList1.get(i);
        if (((INTERFACE.StSubscribeMessage)localObject).authState.get() == 1) {
          localJSONObject.put(((INTERFACE.StSubscribeMessage)localObject).templateId.get(), "accept");
        } else if (((INTERFACE.StSubscribeMessage)localObject).authState.get() == 2) {
          localJSONObject.put(((INTERFACE.StSubscribeMessage)localObject).templateId.get(), "reject");
        }
      }
    }
    catch (Exception paramList1)
    {
      QLog.e("BaseJsPluginEngine", 1, "onceSubMsgCallbackSuc get a Exception:", paramList1);
    }
    label196:
    callbackJsEventOK(paramJsRuntime, "subscribeOnceAppMsg", localJSONObject, paramInt);
    return;
    label209:
    i = 0;
    label212:
    int j = k;
    if (i < paramList2.size())
    {
      paramList1 = (INTERFACE.StSubscribeMessage)paramList2.get(i);
      localObject = paramList1.templateId.get();
      if (paramList1.authState.get() != 2) {
        break label351;
      }
    }
    label329:
    label336:
    label351:
    for (paramList1 = "reject";; paramList1 = "accept")
    {
      localJSONObject.put((String)localObject, paramList1);
      i += 1;
      break label212;
      while (j < paramList3.size())
      {
        localJSONObject.put(((INTERFACE.StSubscribeMessage)paramList3.get(j)).templateId.get(), "reject");
        j += 1;
      }
      break label196;
      paramList2 = "reject";
      break;
      i = 0;
      break label97;
      i += 1;
      break label97;
    }
  }
  
  public void registerPlugin(@NonNull IJsPlugin paramIJsPlugin)
  {
    if (paramIJsPlugin == null) {}
    for (;;)
    {
      return;
      this.mPluginList.add(paramIJsPlugin);
      Iterator localIterator = paramIJsPlugin.supportedEvents().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (this.mPluginEventMap.containsKey(str)) {
          QLog.w("BaseJsPluginEngine", 1, "registerJsPlugin, conflict event:" + str);
        }
        this.mPluginEventMap.put(str, paramIJsPlugin);
      }
    }
  }
  
  public void registerPlugins(ArrayList<IJsPlugin> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      registerPlugin((IJsPlugin)paramArrayList.next());
    }
  }
  
  public void reqAuthorize(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    paramJsRuntime = new NativeJobInfo(paramString1, paramString2, paramJsRuntime, paramInt);
    this.jobQueue.offer(paramJsRuntime);
    if ((!this.isPause) && ((this.authDialog == null) || (!this.authDialog.isShowing())))
    {
      paramJsRuntime = this.uiHandler.obtainMessage(2);
      Bundle localBundle = new Bundle();
      localBundle.putString("key_event_name", paramString1);
      localBundle.putString("key_params", paramString2);
      paramJsRuntime.setData(localBundle);
      paramJsRuntime.sendToTarget();
    }
  }
  
  public void reqGrantApiPermission(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt, ReqGantApiPermissionCallback paramReqGantApiPermissionCallback)
  {
    this.mReqGantApiPermissionCallbackMap.put(Integer.valueOf(paramInt), paramReqGantApiPermissionCallback);
    reqGrantApiPermission(paramString1, paramString2, paramJsRuntime, paramInt, false);
  }
  
  public void setAppBrandRuntime(BaseAppBrandRuntime paramBaseAppBrandRuntime)
  {
    this.appBrandRuntime = paramBaseAppBrandRuntime;
  }
  
  public void setCurInputId(int paramInt)
  {
    curInputId = paramInt;
  }
  
  class NativeJobInfo
    implements Serializable
  {
    public int callbackId;
    public String eventName;
    public WeakReference<JsRuntime> jsRuntimeRef;
    public String jsonParams;
    
    public NativeJobInfo(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
    {
      this.eventName = paramString1;
      this.jsonParams = paramString2;
      this.jsRuntimeRef = new WeakReference(paramJsRuntime);
      this.callbackId = paramInt;
    }
  }
  
  public static abstract interface ReqGantApiPermissionCallback
  {
    public abstract void onGrantApiPermission(int paramInt, JSONObject paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine
 * JD-Core Version:    0.7.0.1
 */