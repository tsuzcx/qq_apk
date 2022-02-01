package com.tencent.qqmini.sdk.plugins;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.auth.AuthFilterList;
import com.tencent.qqmini.sdk.auth.AuthState;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.PluginInfo;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.AdUtil;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.widget.MiniToast;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class DataJsPlugin
  extends BaseJsPlugin
{
  private static final String MINI_APP_STORE_APPID = "1108291530";
  private static final String TAG = "DataJsPlugin";
  private static final int WHAT_GET_SHARE_INFO_TIMEOUT = 1;
  private static final String fakeCheckNavigateRightRsp = "{\"action_code\":1,\"skip_local_check\":1,\"wording\":\"\"}";
  private ChannelProxy mChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
  private MiniAppProxy mMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
  
  private void advertReport(RequestEvent paramRequestEvent)
  {
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramRequestEvent.jsonParams);
        int i = ((JSONObject)localObject).getJSONObject("data").getJSONObject("data").getInt("report_type");
        String str = ((JSONObject)localObject).getJSONObject("data").getJSONObject("data").get("ads_info").toString();
        localObject = ((JSONObject)localObject).getJSONObject("data").getJSONObject("data").get("pos_id").toString();
        AdProxy localAdProxy = (AdProxy)ProxyManager.get(AdProxy.class);
        if ((localAdProxy != null) && (i == 0))
        {
          bool = localAdProxy.adExposure(this.mMiniAppContext.getAttachedActivity(), str, (String)localObject);
          if (bool)
          {
            paramRequestEvent.ok();
            QMLog.i("DataJsPlugin", "advertExposure " + str + ", posId = " + (String)localObject);
            return;
          }
          paramRequestEvent.fail();
          continue;
        }
        boolean bool = false;
      }
      catch (Exception localException)
      {
        paramRequestEvent.fail();
        QMLog.e("DataJsPlugin", "advertExposure, data is wrong " + paramRequestEvent.jsonParams);
        return;
      }
    }
  }
  
  private void advertTap(RequestEvent paramRequestEvent)
  {
    for (;;)
    {
      try
      {
        new JSONObject(paramRequestEvent.jsonParams);
        AdProxy localAdProxy = (AdProxy)ProxyManager.get(AdProxy.class);
        if (localAdProxy != null)
        {
          bool = localAdProxy.adClick(this.mMiniAppContext.getAttachedActivity(), paramRequestEvent.jsonParams, "");
          if (bool)
          {
            paramRequestEvent.ok();
            return;
          }
          paramRequestEvent.fail();
          return;
        }
      }
      catch (Exception localException)
      {
        paramRequestEvent.fail();
        QMLog.e("DataJsPlugin", "advert_tap, data is wrong " + paramRequestEvent.jsonParams);
        return;
      }
      boolean bool = false;
    }
  }
  
  @JsEvent({"getGroupInfo"})
  private void getGroupInfo(RequestEvent paramRequestEvent)
  {
    JSONObject localJSONObject = new JSONObject();
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.mMiniAppInfo != null)
      {
        bool1 = bool2;
        if (this.mMiniAppInfo.launchParam != null)
        {
          bool1 = bool2;
          if (this.mMiniAppInfo.launchParam.entryModel != null) {
            bool1 = this.mMiniAppInfo.launchParam.entryModel.isAdmin;
          }
        }
      }
      localJSONObject.put("isGroupManager", bool1);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    paramRequestEvent.ok(localJSONObject);
  }
  
  @JsEvent({"getGroupInfoExtra"})
  private void getGroupInfoExtra(RequestEvent paramRequestEvent)
  {
    try
    {
      String str = new JSONObject(paramRequestEvent.jsonParams).optString("entryDataHash");
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (this.mMiniAppInfo != null)
      {
        bool1 = bool2;
        if (this.mMiniAppInfo.launchParam != null)
        {
          bool1 = bool2;
          if (this.mMiniAppInfo.launchParam.entryModel != null) {
            bool1 = this.mMiniAppInfo.launchParam.entryModel.isAdmin;
          }
        }
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("isGroupManager", bool1);
      if ((this.mMiniAppInfo != null) && (this.mMiniAppInfo.launchParam != null) && (this.mMiniAppInfo.launchParam.entryModel != null) && (str != null) && (str.equals(this.mMiniAppInfo.launchParam.entryModel.getEntryHash())) && (this.mMiniAppInfo.launchParam.entryModel.type == 1))
      {
        str = this.mApkgInfo.appId;
        long l1 = this.mMiniAppInfo.launchParam.entryModel.uin;
        long l2 = this.mMiniAppInfo.launchParam.entryModel.dwGroupClassExt;
        this.mChannelProxy.getUserGroupInfo(null, str, String.valueOf(l1), l2, new DataJsPlugin.2(this, localJSONObject, paramRequestEvent));
      }
      return;
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
  }
  
  @JsEvent({"getNativeUserInfo"})
  private void getNativeUserInfo(RequestEvent paramRequestEvent)
  {
    if ((MiniAppEnv.g().getAuthSate(this.mMiniAppContext.getMiniAppInfo().appId).isPermissionGranted("scope.userInfo")) || (AuthFilterList.isAppInWhiteList(this.mMiniAppContext.getMiniAppInfo().appId)) || (AuthFilterList.apiAuthoritySilent(this.mMiniAppContext.getMiniAppInfo())))
    {
      paramRequestEvent.evaluateCallbackJs(ApiUtil.wrapCallbackOk("getUserInfo", null).toString());
      return;
    }
    QMLog.e("DataJsPlugin", "getUserInfo已弃用，请使用createUserInfoButton");
    paramRequestEvent.evaluateCallbackJs(ApiUtil.wrapCallbackFail("getUserInfo", null, "getUserInfo已弃用，请使用createUserInfoButton").toString());
  }
  
  @JsEvent({"getNativeWeRunData", "openWeRunSetting"})
  private void getNativeWeRunData(RequestEvent paramRequestEvent)
  {
    paramRequestEvent.ok();
  }
  
  private void getUserInfo(RequestEvent paramRequestEvent, String paramString1, boolean paramBoolean, String paramString2)
  {
    String str = this.mApkgInfo.appId;
    QMLog.d("DataJsPlugin", "getUserInfo appID:" + str);
    this.mChannelProxy.getUserInfo(str, paramBoolean, paramString2, new DataJsPlugin.12(this, paramString1, paramRequestEvent));
  }
  
  @JsEvent({"getTextLineHeight"})
  private String handleGetTextLineHeight(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject1 = new JSONObject(paramRequestEvent.jsonParams);
      String str2 = ((JSONObject)localObject1).optString("fontStyle");
      String str3 = ((JSONObject)localObject1).optString("fontWeight");
      String str4 = ((JSONObject)localObject1).optString("fontFamily");
      String str1 = ((JSONObject)localObject1).optString("text");
      int i = ((JSONObject)localObject1).getInt("fontSize");
      if ((!"normal".equals(str3)) && (!"bold".equals(str3)))
      {
        paramRequestEvent.fail("fontWeight is illegal");
        return "";
      }
      if ((!"normal".equals(str2)) && (!"italic".equals(str2)))
      {
        paramRequestEvent.fail("fontStyle is illegal");
        return "";
      }
      if (i <= 0)
      {
        paramRequestEvent.fail("jsPluginEngine is illegal");
        return "";
      }
      if (TextUtils.isEmpty(str1))
      {
        paramRequestEvent.fail("text is empty");
        return "";
      }
      Paint localPaint = new Paint();
      localPaint.setTextSize(i);
      Object localObject2 = null;
      if ("normal".equals(str2)) {
        if ("normal".equals(str3)) {
          localObject1 = Typeface.create(str4, 0);
        }
      }
      while (localObject1 == null)
      {
        paramRequestEvent.fail("cannot create this font");
        return "";
        localObject1 = localObject2;
        if ("bold".equals(str3))
        {
          localObject1 = Typeface.create(str4, 1);
          continue;
          localObject1 = localObject2;
          if ("italic".equals(str2)) {
            if ("normal".equals(str3))
            {
              localObject1 = Typeface.create(str4, 2);
            }
            else
            {
              localObject1 = localObject2;
              if ("bold".equals(str3)) {
                localObject1 = Typeface.create(str4, 3);
              }
            }
          }
        }
      }
      localObject1 = new Rect();
      localPaint.getTextBounds(str1, 0, str1.length(), (Rect)localObject1);
      paramRequestEvent.ok();
      localObject1 = "" + ((Rect)localObject1).height();
      return localObject1;
    }
    catch (JSONException localJSONException)
    {
      paramRequestEvent.fail("json exception");
    }
    return "";
  }
  
  @JsEvent({"invokeGroupJSApi"})
  private void invokeGroupJSApi(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = ((JSONObject)localObject).optString("entryDataHash");
      localObject = ((JSONObject)localObject).optString("url");
      if ((this.mMiniAppInfo != null) && (this.mMiniAppInfo.launchParam != null) && (this.mMiniAppInfo.launchParam.entryModel != null) && (str != null) && (str.equals(this.mMiniAppInfo.launchParam.entryModel.getEntryHash())) && (this.mMiniAppInfo.launchParam.entryModel.isAdmin) && (localObject != null) && (((String)localObject).contains("{{gid}}"))) {
        startGroupBrowserActivity(((String)localObject).replace("{{gid}}", String.valueOf(this.mMiniAppInfo.launchParam.entryModel.uin)), paramRequestEvent);
      }
      return;
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
  }
  
  private void operateGetShareInfo(String paramString, int paramInt, RequestEvent paramRequestEvent)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramRequestEvent.fail("shareTicket can not be null");
      return;
    }
    Object localObject = new HandlerThread("getShareInfoHandlerThread");
    ((HandlerThread)localObject).start();
    localObject = new Handler(((HandlerThread)localObject).getLooper(), new DataJsPlugin.13(this, paramRequestEvent));
    ((Handler)localObject).sendEmptyMessageDelayed(1, paramInt);
    String str = this.mApkgInfo.appId;
    this.mChannelProxy.getGroupShareInfo(str, paramString, new DataJsPlugin.14(this, paramRequestEvent, (Handler)localObject));
  }
  
  @JsEvent({"private_addContact"})
  private void private_addContact(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      if (!((ChannelProxy)ProxyManager.get(ChannelProxy.class)).addPublicAccount(LoginManager.getInstance().getAccount(), localJSONObject.optString("mpid"), new DataJsPlugin.3(this, paramRequestEvent)))
      {
        MiniToast.makeText(this.mMiniAppContext.getAttachedActivity(), 0, "暂不支持在" + QUAUtil.getApplicationName(this.mContext) + "中关注公众号", 1);
        paramRequestEvent.fail();
      }
      return;
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
  }
  
  @JsEvent({"profile"})
  private void profile(RequestEvent paramRequestEvent)
  {
    try
    {
      paramRequestEvent = new JSONObject(paramRequestEvent.jsonParams);
      QMLog.d("DataJsPlugin", "查看公众号: " + paramRequestEvent);
      if (!((ChannelProxy)ProxyManager.get(ChannelProxy.class)).jump2PublicAccount(this.mMiniAppContext.getAttachedActivity(), paramRequestEvent.optString("uin"), paramRequestEvent.optString("pubName"))) {
        MiniToast.makeText(this.mMiniAppContext.getAttachedActivity(), 0, "暂不支持在" + QUAUtil.getApplicationName(this.mContext) + "中打开公众号", 1);
      }
      return;
    }
    catch (JSONException paramRequestEvent)
    {
      QMLog.e("DataJsPlugin", "profile", paramRequestEvent);
      paramRequestEvent.printStackTrace();
    }
  }
  
  private void saveAdCookie(String paramString, int paramInt)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      if (((JSONObject)localObject).has("gdt_cookie"))
      {
        localObject = ((JSONObject)localObject).getString("gdt_cookie");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return;
        }
        AdUtil.putSpAdGdtCookie(paramInt, (String)localObject);
        QMLog.i("DataJsPlugin", "parseAndSaveCookie save key success, adType = " + paramInt + ", value = " + (String)localObject);
        return;
      }
    }
    catch (Exception localException)
    {
      QMLog.i("DataJsPlugin", "parseAndSaveCookie error" + paramString, localException);
    }
  }
  
  @JsEvent({"scanCode"})
  private void scanCode(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      if (!this.mMiniAppProxy.enterQRCode(this.mMiniAppContext.getAttachedActivity(), localJSONObject.optBoolean("onlyFromCamera", false), new DataJsPlugin.1(this, paramRequestEvent)))
      {
        MiniToast.makeText(this.mMiniAppContext.getAttachedActivity(), 0, "暂不支持在" + QUAUtil.getApplicationName(this.mContext) + "中扫码二维码", 1);
        paramRequestEvent.fail();
      }
      return;
    }
    catch (Throwable paramRequestEvent) {}
  }
  
  private void startGroupBrowserActivity(String paramString, RequestEvent paramRequestEvent)
  {
    if (!((ChannelProxy)ProxyManager.get(ChannelProxy.class)).openGroup(this.mMiniAppContext.getAttachedActivity(), paramString, new DataJsPlugin.15(this, paramRequestEvent)))
    {
      MiniToast.makeText(this.mContext, 0, "暂不支持在" + QUAUtil.getApplicationName(this.mContext) + "中打开QQ群", 1);
      paramRequestEvent.fail("app not implement");
    }
  }
  
  @JsEvent({"batchGetContact"})
  public void batchGetContact(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONArray localJSONArray = new JSONObject(paramRequestEvent.jsonParams).optJSONArray("appIds");
      ArrayList localArrayList = new ArrayList();
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        int i = 0;
        while (i < localJSONArray.length())
        {
          localArrayList.add(String.valueOf(localJSONArray.get(i)));
          i += 1;
        }
      }
      this.mChannelProxy.batchGetContact(localArrayList, new DataJsPlugin.6(this, paramRequestEvent));
      return;
    }
    catch (Throwable localThrowable)
    {
      paramRequestEvent.fail("batchGetContact failed.");
    }
  }
  
  @JsEvent({"getCloudTicket"})
  public void getCloudTicket(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = this.mApkgInfo.appId;
      localObject = ((JSONObject)localObject).optString("envId");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.mChannelProxy.getTcbTicket(str, (String)localObject, new DataJsPlugin.5(this, paramRequestEvent));
      }
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QMLog.e("DataJsPlugin", "API_GET_CLOUD_TICKET error, ", paramRequestEvent);
    }
  }
  
  @JsEvent({"getPerformance"})
  public void getPerformance(RequestEvent paramRequestEvent)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ret", MiniReportManager.getLaunchPerformance(this.mMiniAppInfo.appId));
      paramRequestEvent.ok(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  @JsEvent({"getShareInfo"})
  public void getShareInfo(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = localJSONObject.optString("shareTicket");
      int j = localJSONObject.optInt("timeout", 0);
      int i = j;
      if (j <= 0) {
        i = 30000;
      }
      operateGetShareInfo(str, i, paramRequestEvent);
      return;
    }
    catch (JSONException paramRequestEvent)
    {
      QMLog.e("DataJsPlugin", paramRequestEvent.getMessage(), paramRequestEvent);
      paramRequestEvent.printStackTrace();
    }
  }
  
  @JsEvent({"getUserInfoExtra"})
  public void getUserInfoExtra(RequestEvent paramRequestEvent)
  {
    ApkgInfo localApkgInfo = this.mApkgInfo;
    this.mChannelProxy.getUserInfoExtra(localApkgInfo.appId, new DataJsPlugin.10(this, paramRequestEvent));
  }
  
  @JsEvent({"operateWXData"})
  public void operateWXData(RequestEvent paramRequestEvent)
  {
    Object localObject3;
    String str2;
    try
    {
      localObject3 = new JSONObject(paramRequestEvent.jsonParams);
      Object localObject1 = ((JSONObject)localObject3).optJSONObject("data");
      str2 = ((JSONObject)localObject1).optString("api_name");
      if (("webapi_getuserinfo".equals(str2)) || ("webapi_getuserinfo_opendata".equals(str2)))
      {
        boolean bool = ((JSONObject)localObject1).optBoolean("with_credentials");
        localObject3 = ((JSONObject)localObject1).optString("lang", null);
        localObject1 = ((JSONObject)localObject1).optJSONObject("data");
        if (localObject1 != null) {
          localObject1 = ((JSONObject)localObject1).optString("lang", "en");
        }
        for (;;)
        {
          getUserInfo(paramRequestEvent, str2, bool, (String)localObject1);
          return;
          localObject1 = localObject3;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            localObject1 = "en";
          }
        }
      }
      if ("webapi_wxa_subscribe_biz".equals(str2))
      {
        QMLog.e("DataJsPlugin", "webapi_wxa_subscribe_biz IN DEVELOPMENT");
        return;
      }
    }
    catch (JSONException localJSONException1)
    {
      paramRequestEvent.fail("json exception");
      return;
    }
    Object localObject2;
    if ("webapi_getnavigatewxaappinfo".equals(str2))
    {
      localObject2 = ((JSONObject)localObject3).optJSONObject("reqData").optString("target_appid");
      if ("1108291530".equals(this.mApkgInfo.appId))
      {
        QMLog.d("DataJsPlugin", "MINI_APP_STORE skip checkNavigateRight");
        localObject2 = new JSONObject();
        localObject3 = new JSONObject();
        try
        {
          ((JSONObject)localObject3).put("data", "{\"action_code\":1,\"skip_local_check\":1,\"wording\":\"\"}");
          ((JSONObject)localObject2).put("respData", localObject3);
          paramRequestEvent.ok((JSONObject)localObject2);
          return;
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            localJSONException2.printStackTrace();
          }
        }
      }
      this.mChannelProxy.checkNavigateRight(this.mApkgInfo.appId, (String)localObject2, new DataJsPlugin.8(this, paramRequestEvent));
      return;
    }
    if ("webapi_getadvert".equals(str2))
    {
      webapiGetadvert(paramRequestEvent, (JSONObject)localObject2, 2);
      return;
    }
    if ("advert_tap".equals(str2))
    {
      advertTap(paramRequestEvent);
      return;
    }
    if ("advert_report".equals(str2))
    {
      advertReport(paramRequestEvent);
      return;
    }
    if ("getBlockAd".equals(str2))
    {
      webapiGetadvert(paramRequestEvent, (JSONObject)localObject2, 12);
      return;
    }
    if ("webapi_getshareinfo".equals(str2))
    {
      String str1 = ((JSONObject)localObject2).optJSONObject("data").optString("shareTicket");
      int j = ((JSONObject)localObject2).optJSONObject("data").optInt("timeout", 0);
      int i = j;
      if (j <= 0) {
        i = 30000;
      }
      operateGetShareInfo(str1, i, paramRequestEvent);
      return;
    }
    if ("webapi_getwerunstep_history".equals(str2))
    {
      localObject2 = this.mApkgInfo.appId;
      this.mChannelProxy.getUserHealthData((String)localObject2, new DataJsPlugin.9(this, paramRequestEvent));
    }
  }
  
  @JsEvent({"reportSubmitForm"})
  public void reportSubmitForm(RequestEvent paramRequestEvent)
  {
    String str = this.mApkgInfo.appId;
    this.mChannelProxy.getFormId(str, new DataJsPlugin.4(this, paramRequestEvent));
  }
  
  @JsEvent({"verifyPlugin"})
  public void verifyPlugin(RequestEvent paramRequestEvent)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject = new JSONObject(paramRequestEvent.jsonParams).optJSONObject("data").optJSONArray("plugins");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = (JSONObject)((JSONArray)localObject).get(i);
          PluginInfo localPluginInfo = new PluginInfo();
          localPluginInfo.setPluginId(localJSONObject.optString("provider"));
          localPluginInfo.setInnerVersion(localJSONObject.optString("inner_version"));
          localArrayList.add(localPluginInfo);
          i += 1;
        }
      }
      localObject = this.mApkgInfo.appId;
      this.mChannelProxy.verifyPlugin((String)localObject, localArrayList, new DataJsPlugin.7(this, paramRequestEvent));
      return;
    }
    catch (Throwable localThrowable)
    {
      paramRequestEvent.fail("verifyPlugin failed.");
    }
  }
  
  /* Error */
  public void webapiGetadvert(RequestEvent paramRequestEvent, JSONObject paramJSONObject, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc 79
    //   3: invokevirtual 615	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   6: ldc 102
    //   8: invokevirtual 198	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11: astore 12
    //   13: aload_2
    //   14: ldc 79
    //   16: invokevirtual 615	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   19: ldc_w 713
    //   22: invokevirtual 492	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   25: ifeq +371 -> 396
    //   28: aload_2
    //   29: ldc 79
    //   31: invokevirtual 615	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   34: ldc_w 713
    //   37: invokevirtual 715	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   40: istore_3
    //   41: iconst_1
    //   42: istore 4
    //   44: aload_2
    //   45: ldc 79
    //   47: invokevirtual 615	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   50: ldc_w 717
    //   53: invokevirtual 492	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   56: ifeq +17 -> 73
    //   59: aload_2
    //   60: ldc 79
    //   62: invokevirtual 615	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   65: ldc_w 717
    //   68: invokevirtual 715	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   71: istore 4
    //   73: invokestatic 437	com/tencent/qqmini/sdk/manager/LoginManager:getInstance	()Lcom/tencent/qqmini/sdk/manager/LoginManager;
    //   76: invokevirtual 440	com/tencent/qqmini/sdk/manager/LoginManager:getAccount	()Ljava/lang/String;
    //   79: invokestatic 722	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   82: invokevirtual 726	java/lang/Long:longValue	()J
    //   85: lstore 5
    //   87: aload_0
    //   88: getfield 161	com/tencent/qqmini/sdk/plugins/DataJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   91: getfield 251	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:appId	Ljava/lang/String;
    //   94: astore 13
    //   96: ldc 12
    //   98: new 119	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   105: ldc_w 728
    //   108: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload 13
    //   113: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 298	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload 13
    //   124: invokestatic 339	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   127: ifne +212 -> 339
    //   130: iload_3
    //   131: invokestatic 732	com/tencent/qqmini/sdk/utils/AdUtil:getSpAdGdtCookie	(I)Ljava/lang/String;
    //   134: astore 14
    //   136: aload_0
    //   137: getfield 161	com/tencent/qqmini/sdk/plugins/DataJsPlugin:mMiniAppInfo	Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   140: astore 15
    //   142: ldc 146
    //   144: astore 9
    //   146: ldc 146
    //   148: astore 10
    //   150: ldc 146
    //   152: astore 11
    //   154: aload 9
    //   156: astore_2
    //   157: aload 10
    //   159: astore 7
    //   161: aload 11
    //   163: astore 8
    //   165: aload 15
    //   167: ifnull +73 -> 240
    //   170: aload 9
    //   172: astore_2
    //   173: aload 10
    //   175: astore 7
    //   177: aload 11
    //   179: astore 8
    //   181: aload 15
    //   183: getfield 167	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   186: ifnull +54 -> 240
    //   189: aload 15
    //   191: getfield 167	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   194: getfield 735	com/tencent/qqmini/sdk/launcher/model/LaunchParam:entryPath	Ljava/lang/String;
    //   197: ifnull +143 -> 340
    //   200: aload 15
    //   202: getfield 167	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   205: getfield 735	com/tencent/qqmini/sdk/launcher/model/LaunchParam:entryPath	Ljava/lang/String;
    //   208: astore_2
    //   209: aload 15
    //   211: getfield 167	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   214: ifnull +185 -> 399
    //   217: aload 15
    //   219: getfield 167	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   222: getfield 738	com/tencent/qqmini/sdk/launcher/model/LaunchParam:reportData	Ljava/lang/String;
    //   225: astore 7
    //   227: aload 15
    //   229: getfield 167	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:launchParam	Lcom/tencent/qqmini/sdk/launcher/model/LaunchParam;
    //   232: getfield 741	com/tencent/qqmini/sdk/launcher/model/LaunchParam:scene	I
    //   235: invokestatic 743	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   238: astore 8
    //   240: aload 15
    //   242: ifnull +104 -> 346
    //   245: aload 15
    //   247: getfield 746	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:via	Ljava/lang/String;
    //   250: ifnull +96 -> 346
    //   253: aload 15
    //   255: getfield 746	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:via	Ljava/lang/String;
    //   258: astore 9
    //   260: ldc 104
    //   262: invokestatic 34	com/tencent/qqmini/sdk/core/proxy/ProxyManager:get	(Ljava/lang/Class;)Ljava/lang/Object;
    //   265: checkcast 104	com/tencent/qqmini/sdk/launcher/core/proxy/AdProxy
    //   268: astore 11
    //   270: aload 11
    //   272: ifnull +67 -> 339
    //   275: aload_0
    //   276: getfield 47	com/tencent/qqmini/sdk/plugins/DataJsPlugin:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   279: invokeinterface 110 1 0
    //   284: ifnull +69 -> 353
    //   287: aload_0
    //   288: getfield 47	com/tencent/qqmini/sdk/plugins/DataJsPlugin:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   291: invokeinterface 110 1 0
    //   296: astore 10
    //   298: aload 11
    //   300: aload 10
    //   302: lload 5
    //   304: invokestatic 230	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   307: aload 12
    //   309: aload 13
    //   311: bipush 53
    //   313: iload_3
    //   314: iconst_0
    //   315: aload 14
    //   317: aload_2
    //   318: aload 7
    //   320: aload 8
    //   322: aload 9
    //   324: iload 4
    //   326: new 748	com/tencent/qqmini/sdk/plugins/DataJsPlugin$11
    //   329: dup
    //   330: aload_0
    //   331: aload_1
    //   332: iload_3
    //   333: invokespecial 751	com/tencent/qqmini/sdk/plugins/DataJsPlugin$11:<init>	(Lcom/tencent/qqmini/sdk/plugins/DataJsPlugin;Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;I)V
    //   336: invokevirtual 755	com/tencent/qqmini/sdk/launcher/core/proxy/AdProxy:requestAdInfo	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$ICmdListener;)V
    //   339: return
    //   340: ldc 146
    //   342: astore_2
    //   343: goto -134 -> 209
    //   346: ldc 146
    //   348: astore 9
    //   350: goto -90 -> 260
    //   353: invokestatic 246	com/tencent/qqmini/sdk/core/MiniAppEnv:g	()Lcom/tencent/qqmini/sdk/core/MiniAppEnv;
    //   356: invokevirtual 759	com/tencent/qqmini/sdk/core/MiniAppEnv:getContext	()Landroid/content/Context;
    //   359: astore 10
    //   361: goto -63 -> 298
    //   364: astore_2
    //   365: aload_1
    //   366: invokevirtual 138	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:fail	()Ljava/lang/String;
    //   369: pop
    //   370: ldc 12
    //   372: ldc_w 761
    //   375: aload_2
    //   376: invokestatic 487	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   379: return
    //   380: astore_2
    //   381: aload_1
    //   382: invokevirtual 138	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:fail	()Ljava/lang/String;
    //   385: pop
    //   386: ldc 12
    //   388: ldc_w 763
    //   391: aload_2
    //   392: invokestatic 487	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   395: return
    //   396: goto -355 -> 41
    //   399: ldc 146
    //   401: astore 7
    //   403: goto -176 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	406	0	this	DataJsPlugin
    //   0	406	1	paramRequestEvent	RequestEvent
    //   0	406	2	paramJSONObject	JSONObject
    //   0	406	3	paramInt	int
    //   42	283	4	i	int
    //   85	218	5	l	long
    //   159	243	7	localObject1	Object
    //   163	158	8	localObject2	Object
    //   144	205	9	str1	String
    //   148	212	10	localObject3	Object
    //   152	147	11	localObject4	Object
    //   11	297	12	str2	String
    //   94	216	13	str3	String
    //   134	182	14	str4	String
    //   140	114	15	localMiniAppInfo	MiniAppInfo
    // Exception table:
    //   from	to	target	type
    //   275	298	364	java/lang/Throwable
    //   298	339	364	java/lang/Throwable
    //   353	361	364	java/lang/Throwable
    //   0	41	380	java/lang/Exception
    //   44	73	380	java/lang/Exception
    //   73	142	380	java/lang/Exception
    //   181	209	380	java/lang/Exception
    //   209	227	380	java/lang/Exception
    //   227	240	380	java/lang/Exception
    //   245	260	380	java/lang/Exception
    //   260	270	380	java/lang/Exception
    //   275	298	380	java/lang/Exception
    //   298	339	380	java/lang/Exception
    //   353	361	380	java/lang/Exception
    //   365	379	380	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.DataJsPlugin
 * JD-Core Version:    0.7.0.1
 */