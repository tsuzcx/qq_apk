package com.tencent.qqmini.sdk.plugins.engine;

import NS_MINI_INTERFACE.INTERFACE.StGetUserSettingRsp;
import NS_MINI_INTERFACE.INTERFACE.StSubscribeMessage;
import NS_MINI_INTERFACE.INTERFACE.StUserSettingInfo;
import alle;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.action.PhoneNumberAction.PhoneNumberActionCallback;
import com.tencent.qqmini.sdk.auth.AuthFilterList;
import com.tencent.qqmini.sdk.auth.AuthState;
import com.tencent.qqmini.sdk.auth.PermissionInfo;
import com.tencent.qqmini.sdk.auth.PermissionManager;
import com.tencent.qqmini.sdk.auth.PermissionParser;
import com.tencent.qqmini.sdk.auth.parser.LocalPermissionParser;
import com.tencent.qqmini.sdk.auth.parser.RemotePermissionParser;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent.Builder;
import com.tencent.qqmini.sdk.launcher.core.plugins.engine.IJsPluginEngine;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.widget.AuthDialog;
import com.tencent.qqmini.sdk.widget.AuthDialog.AuthDialogResBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseJsPluginEngine
  implements IJsPluginEngine
{
  private static final String EVENT_AUTHORIZE = "authorize";
  private static final String EVENT_OPERATE_WXDATA = "operateWXData";
  private static final String EVENT_SUBSCRIBE_APP_MSG = "subscribeAppMsg";
  private static final String EVENT_SUBSCRIBE_ONCE_APP_MSG = "subscribeOnceAppMsg";
  private static final String KEY_CALLBACK_ID = "key_callback_id";
  private static final String KEY_EVENT_NAME = "key_event_name";
  public static final String KEY_ONCE_SUB_RSP_DATA = "key_once_sub_rsp_data";
  private static final String KEY_PARAMS = "key_params";
  private static final String KEY_SCOPE_NAME = "key_scope_name";
  private static final String TAG = "JsPluginEngine[AuthGuard]";
  private static final int WHAT_NOTIFY_SCOPE_PERMISSION_QUEUE = 1;
  private static final int WHAT_SHOW_AUTH_DIALOG = 2;
  private final int SUBSCRIBE_CODE_FAIL_OTHER = -2;
  private final int SUBSCRIBE_CODE_REJECT = -1;
  private final int SUBSCRIBE_CODE_REJECT_FIRST = 0;
  private final int SUBSCRIBE_CODE_SUC = 1;
  AuthDialog authDialog;
  private DialogInterface.OnDismissListener dismissListener = new BaseJsPluginEngine.2(this);
  private boolean isFirstTimeRequestAuth;
  private Handler mHandler = new Handler(Looper.getMainLooper(), new BaseJsPluginEngine.3(this));
  protected IMiniAppContext mMiniAppContext;
  private Map<Integer, PhoneNumberAction.PhoneNumberActionCallback> mPhoneNumberActionCallbackMap = new ConcurrentHashMap();
  DialogInterface.OnDismissListener onceSubDismissListener = new BaseJsPluginEngine.1(this);
  private RequestEvent onceSubMsgReq;
  ConcurrentLinkedQueue<RequestEvent> scopePermissionQueue = new ConcurrentLinkedQueue();
  
  public BaseJsPluginEngine(Context paramContext)
  {
    initPermissionParser(paramContext);
  }
  
  private String checkRequestScopePermission(RequestEvent paramRequestEvent)
  {
    boolean bool4 = false;
    boolean bool3 = true;
    String str1 = paramRequestEvent.event;
    String str2 = paramRequestEvent.jsonParams;
    if ("subscribeAppMsg".equals(str1)) {
      return reqGrantSubscribeApiPermission(paramRequestEvent);
    }
    if ("subscribeOnceAppMsg".equals(str1))
    {
      reqGrantOnceSubscribeApiPermission(paramRequestEvent);
      return "";
    }
    String str3 = getAppId();
    AuthState localAuthState = MiniAppEnv.g().getAuthSate(str3);
    String str4 = getRequestScopePermission(str1, str2);
    if ((localAuthState.getAuthFlag(str4) == 1) && ((AuthFilterList.apiAuthoritySilent(this.mMiniAppContext.getMiniAppInfo())) || (AuthFilterList.isAppInWhiteList(str3)))) {
      setScopePermissionAuthState(str4, true);
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      boolean bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (isOpenDataEvent(str1, str2)) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (isScopePermissionGranted(str4)) {
          bool2 = true;
        }
      }
      if ((!bool2) && (shouldAskEveryTime(str4))) {}
      for (bool1 = bool4;; bool1 = bool2)
      {
        if ((!bool1) && (isMakeReuqestFirstEvent(str1))) {
          bool1 = bool3;
        }
        for (;;)
        {
          if (!bool1) {
            QMLog.e("JsPluginEngine[AuthGuard]", "checkRequestScopePermission granted=" + bool1 + ",eventName=" + str1);
          }
          if (bool1)
          {
            if ("authorize".equals(paramRequestEvent.event)) {
              return handleAuthorizeEvent(paramRequestEvent);
            }
            return dispatchRequestEvent(paramRequestEvent);
          }
          showRequestPermissionDialog(paramRequestEvent, str4);
          return "";
        }
      }
    }
  }
  
  private RequestEvent createRequestEvent(String paramString1, String paramString2, IJsService paramIJsService, int paramInt)
  {
    return new RequestEvent.Builder().setEvent(paramString1).setJsonParams(paramString2).setJsService(paramIJsService).setCallbackId(paramInt).build();
  }
  
  private static String extractApiNameInJsonParams(String paramString)
  {
    String str1 = "";
    try
    {
      paramString = new JSONObject(paramString).optString("api_name");
      String str2 = paramString;
      str1 = paramString;
      if (!TextUtils.isEmpty(paramString))
      {
        str1 = paramString;
        str2 = paramString.trim();
      }
      return str2;
    }
    catch (Throwable paramString) {}
    return str1;
  }
  
  private static String extractScopeNameInJsonParams(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("scope").getString(0);
      String str = paramString;
      localThrowable1.printStackTrace();
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString)) {
          str = paramString.trim();
        }
        return str;
      }
      catch (Throwable localThrowable2)
      {
        break label39;
      }
      localThrowable1 = localThrowable1;
      paramString = "";
    }
    label39:
    return paramString;
  }
  
  private static String getRequestScopePermission(String paramString1, String paramString2)
  {
    if ("authorize".equals(paramString1))
    {
      String str = extractScopeNameInJsonParams(paramString2);
      if (isScopePermissionValid(str)) {
        return str;
      }
    }
    paramString2 = extractApiNameInJsonParams(paramString2);
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      return PermissionManager.g().getScopePermissionByEvent(paramString1);
      paramString1 = paramString1 + "." + paramString2;
    }
  }
  
  private static String getRequestSystemPermission(String paramString1, String paramString2)
  {
    if ("authorize".equals(paramString1))
    {
      paramString1 = extractScopeNameInJsonParams(paramString2);
      paramString1 = PermissionManager.g().getEventByScopePermission(paramString1);
      return PermissionManager.g().getEventRequestSystemPermission(paramString1);
    }
    return PermissionManager.g().getEventRequestSystemPermission(paramString1);
  }
  
  private String handleAuthorizeEvent(RequestEvent paramRequestEvent)
  {
    for (;;)
    {
      try
      {
        str1 = getAppId();
        localAuthState = MiniAppEnv.g().getAuthSate(str1);
        str2 = extractScopeNameInJsonParams(paramRequestEvent.jsonParams);
        if ((localAuthState == null) || (!isScopePermissionValid(str2))) {
          continue;
        }
        bool = localAuthState.isSynchronized();
        if ((!str2.startsWith("setting")) || (bool)) {
          continue;
        }
        ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAuthList(str1, new BaseJsPluginEngine.5(this, localAuthState, str2, str1, paramRequestEvent));
      }
      catch (Throwable localThrowable)
      {
        String str1;
        AuthState localAuthState;
        String str2;
        boolean bool;
        QMLog.e("JsPluginEngine[AuthGuard]", localThrowable.getMessage(), localThrowable);
        paramRequestEvent.fail();
        continue;
        sendShowAuthDialogMessage(paramRequestEvent, str2);
        continue;
        QMLog.w("JsPluginEngine[AuthGuard]", "handleAuthorizeEvent, authState is null or scope invalid, scope = " + str2);
        paramRequestEvent.fail();
        continue;
      }
      return "";
      bool = localAuthState.isPermissionGranted(str2);
      if (AuthFilterList.isAppInWhiteList(str1)) {
        bool = true;
      }
      if (!bool) {
        continue;
      }
      paramRequestEvent.ok();
    }
  }
  
  private void handleOnceSubscribeResponse(RequestEvent paramRequestEvent, boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean) {}
    for (;;)
    {
      Object localObject2;
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      ArrayList localArrayList3;
      int i;
      Object localObject3;
      try
      {
        if (!"setting.onceMsgSubscribed".equals(paramJSONObject.optString("settingItem")))
        {
          QMLog.e("JsPluginEngine[AuthGuard]", "handleOnceSubscribeResponse settingItem is no 'setting.onceMsgSubscribed'!");
          return;
        }
        Object localObject1 = paramJSONObject.opt("originalData");
        localObject2 = new INTERFACE.StGetUserSettingRsp();
        if ((localObject1 instanceof byte[]))
        {
          localObject1 = (byte[])localObject1;
          ((INTERFACE.StGetUserSettingRsp)localObject2).mergeFrom((byte[])localObject1);
          localObject2 = ((INTERFACE.StGetUserSettingRsp)localObject2).setting.subItems.get();
          localArrayList1 = new ArrayList();
          localArrayList2 = new ArrayList();
          localArrayList3 = new ArrayList();
          i = 0;
          if (i >= ((List)localObject2).size()) {
            break label235;
          }
          localObject3 = (INTERFACE.StSubscribeMessage)((List)localObject2).get(i);
          if (((INTERFACE.StSubscribeMessage)localObject3).authState.get() == 0) {
            localArrayList1.add(localObject3);
          } else if (((INTERFACE.StSubscribeMessage)localObject3).authState.get() == 1) {
            localArrayList2.add(localObject3);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("JsPluginEngine[AuthGuard]", "handleOnceSubscribeResponse get an Error:", localThrowable);
      }
      onceSubMsgCallbackFail(paramRequestEvent, paramJSONObject);
      return;
      if (((INTERFACE.StSubscribeMessage)localObject3).authState.get() == 2)
      {
        localArrayList3.add(localObject3);
        break label340;
        label235:
        localObject3 = MiniAppEnv.g().getAuthSate(getAppId());
        if ((localArrayList2.size() > 0) || (localArrayList3.size() > 0)) {
          ((AuthState)localObject3).updateIsOnceSubMsgMaintain(true);
        }
        if ((localArrayList1.size() > 0) && (localArrayList1.size() <= 3))
        {
          showOnceSubMsgReqDialog(paramRequestEvent, localThrowable);
          return;
        }
        if (localArrayList2.size() > 0)
        {
          ((AuthState)localObject3).updateOnceSubMsgSetting(true, localArrayList2, new BaseJsPluginEngine.7(this, paramRequestEvent, (List)localObject2));
          return;
        }
        onceSubMsgCallbackSuc(paramRequestEvent, (List)localObject2);
        return;
      }
      label340:
      i += 1;
    }
  }
  
  private boolean isMakeReuqestFirstEvent(String paramString)
  {
    return "getPhoneNumber".equals(paramString);
  }
  
  private static boolean isOpenDataEvent(String paramString1, String paramString2)
  {
    if ("operateWXData".equals(paramString1)) {
      try
      {
        paramString1 = new JSONObject(paramString2).optJSONObject("data").optString("api_name");
        if ((!"webapi_getuserinfo_opendata".equals(paramString1)) && (!"webapi_getadvert".equals(paramString1)) && (!"webapi_getwerunstep_history".equals(paramString1)) && (!"advert_tap".equals(paramString1)) && (!"getBlockAd".equals(paramString1)))
        {
          boolean bool = "webapi_getnavigatewxaappinfo".equals(paramString1);
          if (!bool) {}
        }
        else
        {
          return true;
        }
      }
      catch (Throwable paramString1) {}
    }
    return false;
  }
  
  private boolean isScopePermissionGranted(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    String str = getAppId();
    return MiniAppEnv.g().getAuthSate(str).isPermissionGranted(paramString);
  }
  
  private static boolean isScopePermissionValid(String paramString)
  {
    return PermissionManager.g().isScopePermissionValid(paramString);
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
  
  private void notifyScopePermissionQueue(Message paramMessage)
  {
    Iterator localIterator = this.scopePermissionQueue.iterator();
    if ((paramMessage.arg1 == 3) || (paramMessage.arg1 == 2))
    {
      paramMessage = (String)paramMessage.obj;
      if ((!TextUtils.isEmpty(paramMessage)) && (!paramMessage.equals("setting.appMsgSubscribed")))
      {
        if (paramMessage.equals("scope.camera")) {
          this.mMiniAppContext.performAction(ServiceSubscribeEvent.obtain("onCameraNeedAuthCancel", null, 0));
        }
        while (localIterator.hasNext())
        {
          RequestEvent localRequestEvent = (RequestEvent)localIterator.next();
          if (paramMessage.equals(getRequestScopePermission(localRequestEvent.event, localRequestEvent.jsonParams)))
          {
            localIterator.remove();
            localRequestEvent.fail("auth deny");
          }
        }
      }
    }
    paramMessage = (RequestEvent)this.scopePermissionQueue.peek();
    if (paramMessage != null)
    {
      this.scopePermissionQueue.remove(paramMessage);
      if ("subscribeAppMsg".equals(paramMessage.event)) {
        reqGrantSubscribeApiPermission(paramMessage);
      }
    }
    else
    {
      return;
    }
    dispatchRequestEvent(paramMessage);
  }
  
  private void removeAllMessage()
  {
    this.mHandler.removeMessages(1);
    this.mHandler.removeMessages(2);
  }
  
  private void reqGrantOnceSubscribeApiPermission(RequestEvent paramRequestEvent)
  {
    JSONArray localJSONArray;
    ArrayList localArrayList;
    try
    {
      localJSONArray = new JSONObject(paramRequestEvent.jsonParams).optJSONArray("tmplIds");
      if (localJSONArray == null) {
        break label160;
      }
      localArrayList = new ArrayList();
      if (localJSONArray.length() > 3)
      {
        onceSubMsgCallbackFail(paramRequestEvent, "Templates count out of max bounds", 20003);
        return;
      }
      if (localJSONArray.length() == 0)
      {
        onceSubMsgCallbackFail(paramRequestEvent, "TmplIds can't be empty", 10001);
        return;
      }
    }
    catch (Exception paramRequestEvent)
    {
      QMLog.e("JsPluginEngine[AuthGuard]", "reqGrantOnceSubscribeApiPermission get an Exception:" + paramRequestEvent);
      return;
    }
    int i = 0;
    while (i < localJSONArray.length())
    {
      localArrayList.add(localJSONArray.getString(i));
      i += 1;
    }
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getUserSetting(getAppId(), "", "setting.onceMsgSubscribed", localArrayList, new BaseJsPluginEngine.6(this, paramRequestEvent));
    return;
    label160:
    QMLog.e("JsPluginEngine[AuthGuard]", "reqGrantOnceSubscribeApiPermission: tmplIdJsonArr is null!");
    onceSubMsgCallbackFail(paramRequestEvent, "TmplIds can't be empty", 10001);
  }
  
  private String reqGrantSubscribeApiPermission(RequestEvent paramRequestEvent)
  {
    Object localObject2 = MiniAppEnv.g().getAuthSate(getAppId());
    Object localObject1 = getRequestScopePermission(paramRequestEvent.event, paramRequestEvent.jsonParams);
    if (QMLog.isColorLevel()) {
      QMLog.d("JsPluginEngine[AuthGuard]", "reqGrantSubscribeApiPermission scopePermission=" + (String)localObject1);
    }
    if ((!QUAUtil.isQQApp()) && (!QUAUtil.isDemoApp()))
    {
      QMLog.w("JsPluginEngine[AuthGuard]", "Invalid SDK host, reject all subscribeAppMsg");
      ((AuthState)localObject2).setAuthState((String)localObject1, false);
      paramRequestEvent.fail("Invalid SDK host, no permission");
      return "";
    }
    if (((AuthState)localObject2).getAuthFlag((String)localObject1) == 1)
    {
      this.isFirstTimeRequestAuth = true;
      this.scopePermissionQueue.offer(paramRequestEvent);
      if ((this.authDialog == null) || (!this.authDialog.isShowing()))
      {
        localObject2 = this.mHandler.obtainMessage(2);
        Bundle localBundle = new Bundle();
        localBundle.putString("key_event_name", paramRequestEvent.event);
        localBundle.putString("key_params", paramRequestEvent.jsonParams);
        localBundle.putString("key_scope_name", (String)localObject1);
        localBundle.putInt("key_callback_id", paramRequestEvent.callbackId);
        ((Message)localObject2).setData(localBundle);
        ((Message)localObject2).sendToTarget();
      }
    }
    for (;;)
    {
      return "";
      if (((AuthState)localObject2).isPermissionGranted((String)localObject1))
      {
        this.isFirstTimeRequestAuth = false;
        ((AuthState)localObject2).setAuthState((String)localObject1, true);
        localObject1 = new JSONObject();
        try
        {
          ((JSONObject)localObject1).put("subscribeAppMsgCode", 1);
          paramRequestEvent.ok((JSONObject)localObject1);
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            localJSONException1.printStackTrace();
          }
        }
      }
      localObject1 = new JSONObject();
      try
      {
        if (this.isFirstTimeRequestAuth) {
          ((JSONObject)localObject1).put("subscribeAppMsgCode", 0);
        }
        for (;;)
        {
          paramRequestEvent.fail((JSONObject)localObject1, "no permission");
          this.isFirstTimeRequestAuth = false;
          break;
          ((JSONObject)localObject1).put("subscribeAppMsgCode", -1);
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          localJSONException2.printStackTrace();
        }
      }
    }
  }
  
  private void sendShowAuthDialogMessage(RequestEvent paramRequestEvent, String paramString)
  {
    this.scopePermissionQueue.offer(paramRequestEvent);
    if ((this.authDialog == null) || (!this.authDialog.isShowing()))
    {
      Message localMessage = this.mHandler.obtainMessage(2);
      Bundle localBundle = new Bundle();
      localBundle.putString("key_event_name", paramRequestEvent.event);
      localBundle.putString("key_params", paramRequestEvent.jsonParams);
      localBundle.putString("key_scope_name", paramString);
      localBundle.putInt("key_callback_id", paramRequestEvent.callbackId);
      localMessage.setData(localBundle);
      localMessage.sendToTarget();
    }
  }
  
  private void setScopePermissionAuthState(String paramString, boolean paramBoolean)
  {
    String str = getAppId();
    MiniAppEnv.g().getAuthSate(str).setAuthState(paramString, paramBoolean);
  }
  
  private boolean shouldAskEveryTime(String paramString)
  {
    String str = getAppId();
    return MiniAppEnv.g().getAuthSate(str).shouldAskEveryTime(paramString);
  }
  
  private void showAuthDialog(Bundle paramBundle)
  {
    Object localObject1 = this.mMiniAppContext.getAttachedActivity();
    if ((localObject1 == null) || (((Activity)localObject1).isFinishing())) {
      QMLog.w("JsPluginEngine[AuthGuard]", "showAuthDialog(). Do nothing, activity is null or finishing");
    }
    Object localObject2;
    int i;
    label65:
    label101:
    Object localObject4;
    do
    {
      return;
      str1 = paramBundle.getString("key_event_name", "");
      localObject2 = paramBundle.getString("key_params", "");
      i = 1;
      if (!"getPhoneNumber".equals(str1)) {
        break;
      }
      i = 2;
      if (this.authDialog == null)
      {
        this.authDialog = new AuthDialog((Activity)localObject1, i);
        if (i != 3) {
          break label280;
        }
        this.authDialog.setOnDismissListener(this.onceSubDismissListener);
      }
      this.authDialog.bindData(paramBundle);
      localObject4 = paramBundle.getString("key_scope_name", "");
    } while (localObject4 == null);
    paramBundle = PermissionManager.g().getScopePermission((String)localObject4);
    localObject1 = "";
    String str1 = "";
    if (paramBundle != null)
    {
      localObject1 = paramBundle.name;
      str1 = paramBundle.description;
    }
    for (paramBundle = paramBundle.rejectDescription;; paramBundle = "")
    {
      Context localContext = this.mMiniAppContext.getContext();
      Object localObject5 = getApkgInfo();
      ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
      if (localObject5 == null) {
        break;
      }
      String str2 = ((ApkgInfo)localObject5).iconUrl;
      String str3 = ((ApkgInfo)localObject5).apkgName;
      if ("scope.userInfo".equals(localObject4))
      {
        localChannelProxy.getUserInfo(((ApkgInfo)localObject5).appId, false, "en", new BaseJsPluginEngine.8(this, localMiniAppProxy, localContext, str2, str3, (String)localObject1, str1));
        return;
        if (!"subscribeOnceAppMsg".equals(str1)) {
          break label65;
        }
        i = 3;
        break label65;
        label280:
        this.authDialog.setOnDismissListener(this.dismissListener);
        break label101;
      }
      if (this.authDialog == null) {
        break;
      }
      localObject4 = null;
      try
      {
        localObject5 = new JSONObject((String)localObject2).optJSONObject("getPhoneNumber");
        localObject2 = localObject4;
        if (localObject5 != null)
        {
          localObject2 = localObject4;
          if (((JSONObject)localObject5).has("phoneLists")) {
            localObject2 = ((JSONObject)localObject5).optJSONArray("phoneLists");
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QMLog.e("JsPluginEngine[AuthGuard]", "get phoneNumberList error,", localThrowable);
          Object localObject3 = localObject4;
        }
      }
      localObject4 = new AuthDialog.AuthDialogResBuilder();
      ((AuthDialog.AuthDialogResBuilder)localObject4).setMiniAppIconUrl(localMiniAppProxy.getDrawable(localContext, str2, 0, 0, null)).setMiniAppName(str3).setAuthTitle((String)localObject1).setAuthDesc(str1).setLeftBtnText(paramBundle).setLeftBtnClickListener(new BaseJsPluginEngine.10(this)).setRightBtnText("允许").setRightBtnClickListener(new BaseJsPluginEngine.9(this));
      if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0)) {
        ((AuthDialog.AuthDialogResBuilder)localObject4).setPhoneNumberList((JSONArray)localObject2);
      }
      this.authDialog.show((AuthDialog.AuthDialogResBuilder)localObject4);
      return;
    }
  }
  
  private void showOnceSubMsgReqDialog(RequestEvent paramRequestEvent, byte[] paramArrayOfByte)
  {
    if ((this.authDialog == null) || (!this.authDialog.isShowing()))
    {
      this.onceSubMsgReq = paramRequestEvent;
      Message localMessage = this.mHandler.obtainMessage(2);
      Bundle localBundle = new Bundle();
      localBundle.putString("key_event_name", "subscribeOnceAppMsg");
      localBundle.putString("key_params", paramRequestEvent.jsonParams);
      localBundle.putByteArray("key_once_sub_rsp_data", paramArrayOfByte);
      localMessage.setData(localBundle);
      localMessage.sendToTarget();
    }
  }
  
  private void showRequestPermissionDialog(RequestEvent paramRequestEvent, String paramString)
  {
    Object localObject = paramRequestEvent.event;
    String str = paramRequestEvent.jsonParams;
    boolean bool1;
    if (!isOpenDataEvent((String)localObject, str))
    {
      bool1 = isScopePermissionGranted(paramString);
      QMLog.d("JsPluginEngine[AuthGuard]", "handleNativeRequest hasRefused=" + bool1);
      if ((bool1) && (!shouldAskEveryTime(paramString))) {
        break label167;
      }
      bool1 = true;
    }
    for (;;)
    {
      try
      {
        if (!"operateWXData".equals(localObject)) {
          continue;
        }
        localObject = new JSONObject(str).optJSONObject("data");
        str = ((JSONObject)localObject).optString("api_name");
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
        label167:
        boolean bool3;
        QMLog.e("JsPluginEngine[AuthGuard]", Log.getStackTraceString(localThrowable));
        boolean bool2 = bool1;
        continue;
        QMLog.d("JsPluginEngine[AuthGuard]", "handleNativeRequest callbackJsEventFail");
        paramRequestEvent.fail("auth deny");
        this.mHandler.obtainMessage(1).sendToTarget();
      }
      if (!bool2) {
        continue;
      }
      sendShowAuthDialogMessage(paramRequestEvent, paramString);
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      bool2 = bool1;
      if ("authorize".equals(localObject))
      {
        bool3 = "scope.userInfo".equals(extractScopeNameInJsonParams(str));
        bool2 = bool1;
        if (bool3) {
          bool2 = false;
        }
      }
    }
  }
  
  public String checkAuthorization(RequestEvent paramRequestEvent)
  {
    String str2 = paramRequestEvent.event;
    String str3 = paramRequestEvent.jsonParams;
    String str1;
    if (AuthFilterList.isEventInSecondaryApiList(str2)) {
      str1 = extractApiNameInJsonParams(str3);
    }
    while (!AuthFilterList.isEventNameRight(str2, str1))
    {
      QMLog.e("JsPluginEngine[AuthGuard]", "eventname : " + str2 + "; apiName : " + str1 + " request failed.");
      if (str2.endsWith("Sync"))
      {
        return ApiUtil.wrapCallbackFail(str2, null, "no permission").toString();
        str1 = "";
      }
      else
      {
        paramRequestEvent.fail("no permission");
        return "";
      }
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      str1 = getRequestSystemPermission(str2, str3);
      if (!StringUtil.isEmpty(str1))
      {
        Activity localActivity = this.mMiniAppContext.getAttachedActivity();
        if (localActivity == null)
        {
          QMLog.w("JsPluginEngine[AuthGuard]", "Activity is null. Ignore event " + str2);
          return "";
        }
        if (localActivity.checkSelfPermission(str1) == 0) {}
        for (int i = 1; i == 0; i = 0)
        {
          ActivityResultManager.g().addRequestPermissionResultListener(new BaseJsPluginEngine.4(this, str1, str2, str3, paramRequestEvent));
          alle.requestPermissions(localActivity, new String[] { str1 }, 9527);
          return "";
        }
        return checkRequestScopePermission(paramRequestEvent);
      }
      return checkRequestScopePermission(paramRequestEvent);
    }
    return checkRequestScopePermission(paramRequestEvent);
  }
  
  abstract String dispatchRequestEvent(RequestEvent paramRequestEvent);
  
  protected ApkgInfo getApkgInfo()
  {
    if ((this.mMiniAppContext != null) && (this.mMiniAppContext.getMiniAppInfo() != null)) {
      return (ApkgInfo)this.mMiniAppContext.getMiniAppInfo().apkgInfo;
    }
    return null;
  }
  
  protected String getAppId()
  {
    if (getApkgInfo() != null) {
      return getApkgInfo().appId;
    }
    return null;
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, IJsService paramIJsService, int paramInt)
  {
    if (this.mMiniAppContext == null) {
      return "";
    }
    return checkAuthorization(createRequestEvent(paramString1, paramString2, paramIJsService, paramInt));
  }
  
  public void initPermissionParser(Context paramContext)
  {
    LocalPermissionParser localLocalPermissionParser = new LocalPermissionParser(paramContext);
    paramContext = new RemotePermissionParser(paramContext);
    PermissionManager.g().startParse(new PermissionParser[] { localLocalPermissionParser, paramContext });
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    QMLog.i("JsPluginEngine[AuthGuard]", "onCreate");
    this.mMiniAppContext = paramIMiniAppContext;
    paramIMiniAppContext = this.mMiniAppContext.getMiniAppInfo();
    if (paramIMiniAppContext != null)
    {
      AuthFilterList.updateEventRemoteList(paramIMiniAppContext.blackList, paramIMiniAppContext.whiteList);
      AuthFilterList.updateEventSecondaryApiList(paramIMiniAppContext.secondApiRightInfoList);
    }
  }
  
  public void onDestroy()
  {
    QMLog.i("JsPluginEngine[AuthGuard]", "onDestroy");
    AuthFilterList.reset();
    this.scopePermissionQueue.clear();
    if (this.authDialog != null)
    {
      this.authDialog.setOnDismissListener(null);
      this.authDialog.dismiss();
      this.authDialog = null;
    }
  }
  
  public void onPause()
  {
    QMLog.i("JsPluginEngine[AuthGuard]", "onPause");
    removeAllMessage();
  }
  
  public void onResume()
  {
    QMLog.i("JsPluginEngine[AuthGuard]", "onResume");
    this.mHandler.obtainMessage(1).sendToTarget();
  }
  
  public void onceSubMsgCallbackFail(RequestEvent paramRequestEvent, String paramString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", paramInt);
      if (paramRequestEvent != null) {
        paramRequestEvent.fail(localJSONObject, paramString);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QMLog.e("JsPluginEngine[AuthGuard]", "onceSubMsgCallbackFail get a JSONException:", localJSONException);
      }
    }
  }
  
  public void onceSubMsgCallbackFail(RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    if (paramRequestEvent != null) {
      paramRequestEvent.fail(paramJSONObject, null);
    }
  }
  
  public void onceSubMsgCallbackSuc(RequestEvent paramRequestEvent, List<INTERFACE.StSubscribeMessage> paramList)
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
      QMLog.e("JsPluginEngine[AuthGuard]", "onceSubMsgCallbackSuc get a Exception:", paramList);
      if (paramRequestEvent != null) {
        paramRequestEvent.ok(localJSONObject);
      }
    }
  }
  
  public void onceSubMsgCallbackSuc(RequestEvent paramRequestEvent, List<INTERFACE.StSubscribeMessage> paramList1, List<INTERFACE.StSubscribeMessage> paramList2, List<INTERFACE.StSubscribeMessage> paramList3, boolean paramBoolean)
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
        break label334;
      }
      while (i < paramList1.size())
      {
        paramList2 = (INTERFACE.StSubscribeMessage)paramList1.get(i);
        paramList3 = paramList2.templateId.get();
        if (paramList2.authState.get() != 1) {
          break label327;
        }
        paramList2 = "accept";
        localJSONObject.put(paramList3, paramList2);
        i += 1;
        continue;
        if (i >= paramList1.size()) {
          break label207;
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
      QMLog.e("JsPluginEngine[AuthGuard]", "onceSubMsgCallbackSuc get a Exception:", paramList1);
    }
    label195:
    if (paramRequestEvent != null) {
      paramRequestEvent.ok(localJSONObject);
    }
    return;
    label207:
    i = 0;
    label210:
    int j = k;
    if (i < paramList2.size())
    {
      paramList1 = (INTERFACE.StSubscribeMessage)paramList2.get(i);
      localObject = paramList1.templateId.get();
      if (paramList1.authState.get() != 2) {
        break label349;
      }
    }
    label327:
    label334:
    label349:
    for (paramList1 = "reject";; paramList1 = "accept")
    {
      localJSONObject.put((String)localObject, paramList1);
      i += 1;
      break label210;
      while (j < paramList3.size())
      {
        localJSONObject.put(((INTERFACE.StSubscribeMessage)paramList3.get(j)).templateId.get(), "reject");
        j += 1;
      }
      break label195;
      paramList2 = "reject";
      break;
      i = 0;
      break label97;
      i += 1;
      break label97;
    }
  }
  
  public void requestAuthorize(RequestEvent paramRequestEvent)
  {
    this.scopePermissionQueue.offer(paramRequestEvent);
    if ((this.authDialog == null) || (!this.authDialog.isShowing()))
    {
      Message localMessage = this.mHandler.obtainMessage(2);
      Bundle localBundle = new Bundle();
      localBundle.putString("key_event_name", paramRequestEvent.event);
      localBundle.putString("key_params", paramRequestEvent.jsonParams);
      localMessage.setData(localBundle);
      localMessage.sendToTarget();
    }
  }
  
  public void showRequestPermissionDialog(RequestEvent paramRequestEvent, PhoneNumberAction.PhoneNumberActionCallback paramPhoneNumberActionCallback)
  {
    this.mPhoneNumberActionCallbackMap.put(Integer.valueOf(paramRequestEvent.callbackId), paramPhoneNumberActionCallback);
    showRequestPermissionDialog(paramRequestEvent, getRequestScopePermission(paramRequestEvent.event, paramRequestEvent.jsonParams));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine
 * JD-Core Version:    0.7.0.1
 */