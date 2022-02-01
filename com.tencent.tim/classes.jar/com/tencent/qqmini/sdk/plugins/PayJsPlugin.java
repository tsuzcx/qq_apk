package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.launcher.utils.MD5Utils;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class PayJsPlugin
  extends BaseJsPlugin
{
  public static final int COME_FROM_MINI = 9;
  public static final String KEY_MINI_GAME_PAY_ENV = "keyMiniGamePayEnv";
  public static final String KEY_MINI_GAME_PAY_ENV_APPID_VERTYPE = "keyMiniGamePayEnvAppidVertype";
  public static final String PAYJSON_KEY_MINI_APP_VERTYPE_STR = "miniAppVertypeStr";
  public static final String PAYJSON_KEY_SET_MIDAS_ENV = "setMidasEnv";
  public static final int PAY_CHANNEL_WECHAT = 8;
  public static final int PAY_DISABLE = 2;
  public static final int PAY_ENABLE = 1;
  public static final int PAY_TYPE_BUILDIN_H5 = 1;
  public static final int PAY_UNKNOWN = 0;
  public static final int SET_MIDAS_ENV_VAL_RELEASE = 0;
  public static final int SET_MIDAS_ENV_VAL_TEST = 1;
  private static final String TAG = "PayJsPlugin";
  public static final String URL_PAY_BY_H5 = WnsConfig.getConfig("qqminiapp", "mini_game_pay_by_h5_url", "https://h5.qzone.qq.com/miniapp/act/midasPay?offerId={offerId}&prepayId={prepayId}&starCurrency={starCurrency}&setEnv={setEnv}&appid={appid}&_proxy=1&_wv=17301504&_wwv=1");
  public static final String URL_PAY_BY_H5_LANDSCAPE = WnsConfig.getConfig("qqminiapp", "mini_game_pay_by_h5_url_landscape", "https://h5.qzone.qq.com/miniapp/act/midasPay?offerId={offerId}&prepayId={prepayId}&starCurrency={starCurrency}&setEnv={setEnv}&appid={appid}&_proxy=1&_wv=17303552&_wwv=1");
  protected String mRealOfferId = "";
  
  private String appendPayComeFrom(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      ((JSONObject)localObject).put("comeForm", 9);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return paramString;
  }
  
  private String getSDKH5Url(String paramString)
  {
    String str1 = paramString;
    if (!QUAUtil.isQQApp())
    {
      str1 = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppName();
      if ((this.mMiniAppInfo == null) || (this.mMiniAppInfo.launchParam == null)) {
        break label174;
      }
      str1 = str1 + "_" + this.mMiniAppInfo.launchParam.scene;
    }
    label174:
    for (;;)
    {
      String str2 = LoginManager.getInstance().getAccount();
      if (TextUtils.isEmpty(str2)) {
        str2 = "null";
      }
      for (;;)
      {
        paramString = new StringBuilder(paramString);
        String str3 = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getPlatformId();
        paramString.append("&").append("refer=").append(str1).append("&").append("shareuid=").append(str2).append("&").append("platform=").append(str3).append("&").append("fromSDK=1");
        str1 = paramString.toString();
        return str1;
      }
    }
  }
  
  private String getSDKPf(String paramString)
  {
    Object localObject2 = "null";
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString)) {
      localObject1 = localObject2;
    }
    int i;
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject(paramString).optString("prepayId");
        paramString = (String)localObject2;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          paramString = "null";
        }
        localObject2 = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppName();
        localObject1 = localObject2;
        if (this.mMiniAppInfo != null)
        {
          localObject1 = localObject2;
          if (this.mMiniAppInfo.launchParam != null) {
            localObject1 = (String)localObject2 + "_" + this.mMiniAppInfo.launchParam.scene;
          }
        }
        String str = LoginManager.getInstance().getAccount();
        localObject2 = str;
        if (TextUtils.isEmpty(str)) {
          localObject2 = "null";
        }
        i = LoginManager.getInstance().getLoginType();
        if ((i != 2) && (i != 3)) {
          break;
        }
        return "qq_m_qq-20031-android-2011-" + this.mMiniAppInfo.appId + "-" + paramString + "-" + (String)localObject1 + "-" + (String)localObject2;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      paramString = (String)localObject1;
    }
    if (i == 1) {
      return "qq_m_wx-20031-android-2011-" + this.mMiniAppInfo.appId + "-" + paramString + "-" + (String)localObject1 + "-" + (String)localObject2;
    }
    return "";
  }
  
  private void handleMidasGoodsPay(Activity paramActivity, JSONObject paramJSONObject, RequestEvent paramRequestEvent)
    throws JSONException
  {
    Object localObject1 = paramJSONObject.optString("offerId", "");
    Object localObject3 = paramJSONObject.getJSONObject("payInfo");
    Object localObject2 = paramJSONObject.getString("userId");
    String str1 = ((JSONObject)localObject3).getString("tokenUrl");
    String str2 = ((JSONObject)localObject3).optString("aid", "");
    String str3 = ((JSONObject)localObject3).optString("zoneId", "1");
    String str4 = ((JSONObject)localObject3).optString("numberVisible", "");
    String str5 = ((JSONObject)localObject3).optString("unit", "");
    String str6 = ((JSONObject)localObject3).optString("discountId", "");
    localObject3 = ((JSONObject)localObject3).optString("other", "");
    int i = paramRequestEvent.callbackId;
    paramJSONObject = new JSONObject();
    paramJSONObject.put("offerId", localObject1);
    paramJSONObject.put("userId", localObject2);
    paramJSONObject.put("tokenUrl", str1);
    paramJSONObject.put("zoneId", str3);
    paramJSONObject.put("numberVisible", str4);
    paramJSONObject.put("unit", str5);
    paramJSONObject.put("aid", str2);
    paramJSONObject.put("discountId", str6);
    paramJSONObject.put("other", localObject3);
    paramJSONObject.put("comeForm", 9);
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("payparmas_callback_sn", String.valueOf(i));
    ((Bundle)localObject1).putString("payparmas_json", paramJSONObject.toString());
    ((Bundle)localObject1).putInt("payparmas_paytype", 1);
    ((Bundle)localObject1).putLong("payparmas_h5_start", System.currentTimeMillis());
    ((Bundle)localObject1).putInt("payparmas_request_code", 7);
    ((Bundle)localObject1).putString("payparmas_sdk_pf", getSDKPf(paramJSONObject.toString()));
    if (paramActivity != null)
    {
      localObject2 = (PayProxy)ProxyManager.get(PayProxy.class);
      if (localObject2 == null)
      {
        handleNativeResponseFail(paramRequestEvent, null, "not support pay");
        return;
      }
    }
    for (paramActivity = ((PayProxy)localObject2).midasPay(paramActivity, paramJSONObject.toString(), new PayJsPlugin.8(this, paramRequestEvent), (Bundle)localObject1);; paramActivity = null)
    {
      if (paramActivity != null) {}
      for (i = paramActivity.getInt("retCode", 0); (paramActivity != null) && (i != 0); i = 0)
      {
        handleNativeResponseFail(paramRequestEvent, null, "");
        return;
      }
      break;
    }
  }
  
  private void handleMidasMonthCardPay(Activity paramActivity, String paramString, RequestEvent paramRequestEvent)
  {
    int i = paramRequestEvent.callbackId;
    Bundle localBundle = new Bundle();
    localBundle.putString("payparmas_callback_sn", String.valueOf(i));
    localBundle.putString("payparmas_json", paramString);
    localBundle.putInt("payparmas_paytype", 1);
    localBundle.putLong("payparmas_h5_start", System.currentTimeMillis());
    localBundle.putInt("payparmas_request_code", 14);
    localBundle.putString("payparmas_sdk_pf", getSDKPf(paramString));
    PayProxy localPayProxy;
    if (paramActivity != null)
    {
      localPayProxy = (PayProxy)ProxyManager.get(PayProxy.class);
      if (localPayProxy == null)
      {
        handleNativeResponseFail(paramRequestEvent, null, "not support pay");
        return;
      }
    }
    for (paramActivity = localPayProxy.midasPay(paramActivity, paramString, new PayJsPlugin.7(this, paramRequestEvent), localBundle);; paramActivity = null)
    {
      if (paramActivity != null) {}
      for (i = paramActivity.getInt("retCode", 0); (paramActivity != null) && (i != 0); i = 0)
      {
        handleNativeResponseFail(paramRequestEvent, null, "");
        return;
      }
      break;
    }
  }
  
  private void handleNativeResponseCancel(RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    if (paramRequestEvent != null) {
      paramRequestEvent.cancel(paramJSONObject);
    }
  }
  
  private void handleNativeResponseFail(RequestEvent paramRequestEvent, JSONObject paramJSONObject, String paramString)
  {
    if (paramRequestEvent != null) {
      paramRequestEvent.fail(paramJSONObject, paramString);
    }
  }
  
  private void handleNativeResponseOk(RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    if (paramRequestEvent != null) {
      paramRequestEvent.ok(paramJSONObject);
    }
  }
  
  private void handleQQPay(RequestEvent paramRequestEvent)
    throws JSONException
  {
    Object localObject1 = new JSONObject(paramRequestEvent.jsonParams);
    Object localObject3 = ((JSONObject)localObject1).optString("prepayId", "");
    Object localObject4 = ((JSONObject)localObject1).getJSONObject("payInfo");
    Object localObject2 = ((JSONObject)localObject4).optString("miniAppId", "");
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.mApkgInfo.appId;
    }
    String str = ((JSONObject)localObject4).optString("bargainor_id", "");
    localObject4 = ((JSONObject)localObject4).optString("channel", "");
    localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("tokenId", localObject3);
    ((JSONObject)localObject2).put("comeForm", 9);
    ((JSONObject)localObject2).put("appInfo", "appid#" + (String)localObject1 + "|bargainor_id#" + str + "|channel#" + (String)localObject4);
    int i = paramRequestEvent.callbackId;
    localObject3 = new Bundle();
    ((Bundle)localObject3).putString("payparmas_callback_sn", String.valueOf(i));
    ((Bundle)localObject3).putString("payparmas_json", ((JSONObject)localObject2).toString());
    ((Bundle)localObject3).putInt("payparmas_paytype", 1);
    ((Bundle)localObject3).putLong("payparmas_h5_start", System.currentTimeMillis());
    ((Bundle)localObject3).putInt("payparmas_request_code", 9);
    ((Bundle)localObject3).putString("payparmas_sdk_pf", getSDKPf(((JSONObject)localObject2).toString()));
    if (this.mMiniAppContext != null) {}
    for (localObject1 = this.mMiniAppContext.getAttachedActivity();; localObject1 = null)
    {
      if (localObject1 == null) {
        break label362;
      }
      localObject4 = (PayProxy)ProxyManager.get(PayProxy.class);
      if (localObject4 != null) {
        break;
      }
      handleNativeResponseFail(paramRequestEvent, null, "not support pay");
      return;
    }
    label362:
    for (localObject1 = ((PayProxy)localObject4).midasPay((Activity)localObject1, ((JSONObject)localObject2).toString(), new PayJsPlugin.9(this, paramRequestEvent), (Bundle)localObject3);; localObject1 = null)
    {
      if (localObject1 != null) {}
      for (i = ((Bundle)localObject1).getInt("retCode", 0); (localObject1 != null) && (i != 0); i = 0)
      {
        handleNativeResponseFail(paramRequestEvent, null, "");
        return;
      }
      break;
    }
  }
  
  private void putAid(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (paramJSONObject == null) {
      return;
    }
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = "null";
    }
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = "null";
    }
    paramString2 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString2 = "null";
    }
    paramString3 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString3 = "null";
    }
    paramString4 = paramString5;
    if (TextUtils.isEmpty(paramString5)) {
      paramString4 = "null";
    }
    paramString1 = String.format("%s-%s-%s-%s-%s", new Object[] { str, paramString1, paramString2, paramString3, paramString4 });
    try
    {
      paramJSONObject.put("aid", paramString1);
      label120:
      QMLog.d("PayJsPlugin", "putAid, aid = " + paramString1);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      break label120;
    }
  }
  
  private void reChargeStarCurrency(RequestEvent paramRequestEvent, boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      String str2 = localJSONObject.optString("prepayId", null);
      int i = localJSONObject.optInt("balanceAmount", -1);
      int j = localJSONObject.optInt("topupAmount", -1);
      int k = localJSONObject.optInt("starCurrency", -1);
      int m = localJSONObject.optInt("setEnv", 0);
      String str1 = localJSONObject.optString("aid", "");
      Object localObject = str1;
      if (!TextUtils.isEmpty(str1))
      {
        localObject = str1;
        if (str1.contains("{appid}")) {
          localObject = str1.replace("{appid}", this.mApkgInfo.appId);
        }
      }
      localJSONObject.put("userId", LoginManager.getInstance().getAccount());
      localJSONObject.put("aid", localObject);
      localJSONObject.put("comeForm", 9);
      localJSONObject.put("setMidasEnv", m);
      if (this.mIsMiniGame)
      {
        localObject = this.mMiniAppInfo;
        if (localObject != null)
        {
          localObject = this.mApkgInfo.appId + "_" + ((MiniAppInfo)localObject).verType;
          str1 = MD5Utils.encodeHexStr((String)localObject);
          this.mContext.getSharedPreferences("keyMiniGamePayEnv", 4).edit().putString("keyMiniGamePayEnvAppidVertype", str1).commit();
          localJSONObject.put("miniAppVertypeStr", localObject);
        }
      }
      str1 = String.valueOf(paramRequestEvent.callbackId);
      localObject = str1;
      if (i != -1)
      {
        localObject = str1;
        if (j != -1)
        {
          localObject = str1;
          if (k != -1)
          {
            localObject = new JSONObject();
            ((JSONObject)localObject).put("appId", this.mApkgInfo.appId);
            ((JSONObject)localObject).put("prepayId", str2);
            ((JSONObject)localObject).put("balanceAmount", i);
            ((JSONObject)localObject).put("topupAmount", j);
            ((JSONObject)localObject).put("starCurrency", k);
            ((JSONObject)localObject).put("seq", paramRequestEvent.callbackId);
            ((JSONObject)localObject).put("setEnv", m);
            localObject = ((JSONObject)localObject).toString();
          }
        }
      }
      if (!TextUtils.isEmpty(this.mRealOfferId)) {
        localJSONObject.put("offerId", this.mRealOfferId);
      }
      handleRechargeGame(paramRequestEvent, this.mMiniAppContext.getAttachedActivity(), localJSONObject.toString(), (String)localObject, paramBoolean);
      return;
    }
    catch (JSONException paramRequestEvent)
    {
      QMLog.e("PayJsPlugin", "API_RECHARGE_STAR_CURRENCY JSONException ", paramRequestEvent);
    }
  }
  
  private void setCookieIfNeed(Bundle paramBundle)
  {
    if (!QUAUtil.isQQApp())
    {
      int i = LoginManager.getInstance().getLoginType();
      String str1 = LoginManager.getInstance().getPayOpenId();
      String str3 = LoginManager.getInstance().getPayOpenKey();
      String str4 = LoginManager.getInstance().getPayAccessToken();
      String str2 = LoginManager.getInstance().getAppId();
      str1 = "openid=" + str1;
      str3 = "openkey=" + str3;
      str4 = "accesstoken=" + str4;
      String str5 = "login_type=" + i;
      str2 = "login_appid=" + str2;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str1).append(";");
      localStringBuilder.append(str3).append(";");
      localStringBuilder.append(str4).append(";");
      localStringBuilder.append(str5).append(";");
      localStringBuilder.append(str2);
      paramBundle.putString("cookie", localStringBuilder.toString());
    }
  }
  
  private void startPayBrowserActivity(Activity paramActivity, RequestEvent paramRequestEvent, String paramString)
  {
    ActivityResultManager.g().addActivityResultListener(new PayJsPlugin.3(this, paramRequestEvent));
    paramRequestEvent = new Bundle();
    setCookieIfNeed(paramRequestEvent);
    paramRequestEvent.putBoolean("hide_title_bar", true);
    ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    paramString = getSDKH5Url(paramString);
    localChannelProxy.startTransparentBrowserActivityForResult(paramActivity, paramString, paramRequestEvent, 3003);
    QMLog.i("PayJsPlugin", "startPayBrowserActivity, url=" + paramString);
  }
  
  @JsEvent({"checkH5PayStatus"})
  public void checkH5PayStatus(RequestEvent paramRequestEvent)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if ((!QUAUtil.isAlienApp()) && (!QUAUtil.isMicroApp())) {
          continue;
        }
        localJSONObject.put("resultCode", WnsConfig.getConfig("qqminiapp", "mini_game_pay_by_h5", 0));
      }
      catch (JSONException localJSONException)
      {
        QMLog.e("PayJsPlugin", "checkH5PayStatus JSONException ", localJSONException);
        continue;
      }
      handleNativeResponseOk(paramRequestEvent, localJSONObject);
      return;
      localJSONObject.put("resultCode", WnsConfig.getConfig("qqminiapp", "mini_game_pay_by_h5", 1));
    }
  }
  
  @JsEvent({"consumeStarCurrency"})
  public void consumeStarCurrency(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramRequestEvent.jsonParams);
      String str = localJSONObject1.optString("prepayId");
      int i = localJSONObject1.optInt("starCurrency");
      int j = localJSONObject1.optInt("balanceAmount");
      int k = localJSONObject1.optInt("topupAmount");
      int m = localJSONObject1.optInt("payChannel");
      int n = localJSONObject1.optInt("setEnv", 0);
      invokeMidasConsume(paramRequestEvent, this.mApkgInfo.appId, str, i, j, k, m, n);
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("PayJsPlugin", "consumestarcurrency error = ", localJSONException);
      JSONObject localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject2.put("resultCode", 1000);
        handleNativeResponseFail(paramRequestEvent, localJSONObject2, "参数错误");
        return;
      }
      catch (JSONException paramRequestEvent)
      {
        QMLog.e("PayJsPlugin", "handleNativeResponse error = ", paramRequestEvent);
      }
    }
  }
  
  public void handleRechargeGame(RequestEvent paramRequestEvent, Activity paramActivity, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramActivity == null)
    {
      handleNativeResponseFail(paramRequestEvent, null, "activity is null");
      return;
    }
    AppBrandTask.runTaskOnUiThread(new PayJsPlugin.10(this, paramString2, paramString1, paramRequestEvent, paramActivity, paramBoolean));
  }
  
  public void invokeMidasConsume(RequestEvent paramRequestEvent, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    QMLog.i("PayJsPlugin", "invokeMidasConsume prepayId= " + paramString2 + " starCurrency=" + String.valueOf(paramInt1));
    if ((TextUtils.isEmpty(paramString2)) || (paramInt1 <= 0) || (TextUtils.isEmpty(paramString1)))
    {
      paramString1 = new JSONObject();
      try
      {
        paramString1.put("resultCode", -4);
        paramString1.put("resultMsg", "消耗参数错误");
        handleNativeResponseFail(paramRequestEvent, paramString1, "");
        return;
      }
      catch (JSONException paramRequestEvent)
      {
        QMLog.e("PayJsPlugin", "invokeMidasConsume JSONException ", paramRequestEvent);
        return;
      }
    }
    String str2 = "";
    String str1 = str2;
    if (this.mMiniAppInfo != null)
    {
      str1 = str2;
      if (this.mMiniAppInfo.launchParam != null) {
        str1 = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppName() + "_" + this.mMiniAppInfo.launchParam.scene;
      }
    }
    if ((this.mMiniAppInfo != null) && (this.mMiniAppInfo.via != null)) {}
    for (str2 = this.mMiniAppInfo.via;; str2 = "")
    {
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getMidasConsumeResult(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, str1, str2, new PayJsPlugin.5(this, paramRequestEvent));
      return;
    }
  }
  
  public void invokeMidasQuery(String paramString1, String paramString2, int paramInt1, int paramInt2, IStarQueryListener paramIStarQueryListener)
  {
    QMLog.i("PayJsPlugin", "invokeMidasQuery prepayId= " + paramString1 + " starCurrency=" + String.valueOf(paramInt1) + " setEnv:" + paramInt2);
    if ((TextUtils.isEmpty(paramString1)) || (paramInt1 <= 0) || (TextUtils.isEmpty(paramString2)))
    {
      paramString1 = new JSONObject();
      try
      {
        paramString1.put("resultCode", 1000);
        paramString1.put("errMsg", "参数错误");
        if (paramIStarQueryListener != null) {
          paramIStarQueryListener.onResult(false, paramString1);
        }
        return;
      }
      catch (JSONException paramString1)
      {
        QMLog.e("PayJsPlugin", "invokeMidasQuery JSONException ", paramString1);
        return;
      }
    }
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).queryCurrency(paramString1, paramString2, paramInt1, paramInt2, new PayJsPlugin.6(this, paramIStarQueryListener));
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
  }
  
  public boolean onInterceptJsEvent(RequestEvent paramRequestEvent)
  {
    Object localObject = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    if ((localObject != null) && (((ChannelProxy)localObject).isGooglePlayVersion()))
    {
      int i;
      if (WnsConfig.getConfig("qqminiapp", "mini_app_google_play_pay_switch", 0) == 1) {
        i = 1;
      }
      for (;;)
      {
        if (i == 0)
        {
          localObject = new JSONObject();
          try
          {
            ((JSONObject)localObject).put("retCode", -123);
            ((JSONObject)localObject).put("errMsg", "googlePlay PayAPI no supported!");
            handleNativeResponseFail(paramRequestEvent, (JSONObject)localObject, "googlePlay PayAPI no supported!");
            return true;
            i = 0;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
    }
    return super.onInterceptJsEvent(paramRequestEvent);
  }
  
  @JsEvent({"queryStarCurrency"})
  public void queryStarCurrency(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramRequestEvent.jsonParams);
      String str = localJSONObject1.optString("prepayId");
      int i = localJSONObject1.optInt("starCurrency");
      int j = localJSONObject1.optInt("setEnv", 0);
      invokeMidasQuery(str, this.mApkgInfo.appId, i, j, new PayJsPlugin.4(this, paramRequestEvent));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("PayJsPlugin", "querystarcurrency error = ", localJSONException);
      JSONObject localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject2.put("resultCode", 1000);
        handleNativeResponseFail(paramRequestEvent, null, "参数错误");
        return;
      }
      catch (JSONException paramRequestEvent)
      {
        QMLog.e("PayJsPlugin", "handleNativeResponse error = ", paramRequestEvent);
      }
    }
  }
  
  @JsEvent({"rechargeAndConsumeStarCurrency"})
  public void rechargeAndConsumeStarCurrency(RequestEvent paramRequestEvent)
  {
    reChargeStarCurrency(paramRequestEvent, true);
  }
  
  @JsEvent({"rechargeStarCurrency"})
  public void rechargeStarCurrency(RequestEvent paramRequestEvent)
  {
    reChargeStarCurrency(paramRequestEvent, false);
  }
  
  @JsEvent({"requestMidasGoodsPay"})
  public void requestMidasGoodsPay(RequestEvent paramRequestEvent)
  {
    try
    {
      String str = LoginManager.getInstance().getAccount();
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      localJSONObject.put("userId", str);
      handleMidasGoodsPay(this.mMiniAppContext.getAttachedActivity(), localJSONObject, paramRequestEvent);
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("PayJsPlugin", paramRequestEvent.event + " error.", localJSONException);
      handleNativeResponseFail(paramRequestEvent, null, "");
    }
  }
  
  @JsEvent({"requestMidasMonthCardPay"})
  public void requestMidasMonthCardPay(RequestEvent paramRequestEvent)
  {
    try
    {
      String str = LoginManager.getInstance().getAccount();
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      localJSONObject.put("userId", str);
      handleMidasMonthCardPay(this.mMiniAppContext.getAttachedActivity(), localJSONObject.toString(), paramRequestEvent);
      return;
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
  }
  
  @JsEvent({"requestMidasPayment"})
  public void requestMidasPayment(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      String str1 = localJSONObject.optString("offerId");
      localJSONObject.put("userId", LoginManager.getInstance().getAccount());
      localJSONObject.put("comeForm", 9);
      String str2 = this.mApkgInfo.appId;
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).checkOfferId(str2, str1, new PayJsPlugin.2(this, localJSONObject, paramRequestEvent));
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("PayJsPlugin", " error,", localException);
      handleNativeResponseFail(paramRequestEvent, null, "");
    }
  }
  
  @JsEvent({"requestMidasPaymentByH5"})
  public void requestMidasPaymentByH5(RequestEvent paramRequestEvent)
  {
    int i = 0;
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      String str1 = ((JSONObject)localObject).optString("prepayId");
      int j = ((JSONObject)localObject).optInt("starCurrency");
      int k = ((JSONObject)localObject).optInt("setEnv", 0);
      String str2 = ((JSONObject)localObject).optString("offerId", "1450023163");
      localObject = URL_PAY_BY_H5;
      if (AppLoaderFactory.g().getMiniAppEnv().getContext().getResources().getConfiguration().orientation == 2) {
        i = 1;
      }
      if (i != 0) {
        localObject = URL_PAY_BY_H5_LANDSCAPE;
      }
      localObject = ((String)localObject).replace("{offerId}", str2).replace("{prepayId}", str1).replace("{starCurrency}", j + "").replace("{setEnv}", k + "").replace("{appid}", this.mMiniAppInfo.appId);
      startPayBrowserActivity(this.mMiniAppContext.getAttachedActivity(), paramRequestEvent, (String)localObject);
      return;
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
  }
  
  @JsEvent({"requestPayment"})
  public void requestPayment(RequestEvent paramRequestEvent)
  {
    ActivityResultManager.g().addActivityResultListener(new PayJsPlugin.1(this, paramRequestEvent));
    try
    {
      handleQQPay(paramRequestEvent);
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("PayJsPlugin", paramRequestEvent.event + " error,", localException);
      handleNativeResponseFail(paramRequestEvent, null, "");
    }
  }
  
  static abstract interface IStarQueryListener
  {
    public abstract void onResult(boolean paramBoolean, JSONObject paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.PayJsPlugin
 * JD-Core Version:    0.7.0.1
 */