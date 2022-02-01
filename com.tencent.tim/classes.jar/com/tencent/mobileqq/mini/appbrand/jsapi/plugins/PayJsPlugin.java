package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_COMM.COMM.StCommonExt;
import acfp;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import arwv;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.appbrand.utils.MiniLog;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.BridgeInfo;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.util.JSONUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.manager.GameInfoManager;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoaderManager;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class PayJsPlugin
  extends BaseJsPlugin
{
  public static final String KEY_MINI_GAME_PAY_ENV = "keyMiniGamePayEnv";
  public static final String KEY_MINI_GAME_PAY_ENV_APPID_VERTYPE = "keyMiniGamePayEnvAppidVertype";
  public static final int PAY_CHANNEL_WX = 8;
  public static final int PAY_DISABLE = 2;
  public static final int PAY_ENABLE = 1;
  public static final int PAY_INVOKER_BUY_GOODS = 7;
  public static final int PAY_INVOKER_PAY = 9;
  public static final int PAY_INVOKER_RECHARGE_GAME_CURRENCY = 6;
  public static final int PAY_INVOKER_SUBSCRIBE_MONTH_CARD = 14;
  public static final int PAY_UNKNOWN = 0;
  private static final Set<String> S_EVENT_MAP = new PayJsPlugin.1();
  private static final String TAG = "PayJsPlugin";
  public static final String TYPE_QQ_BUY_GOODS = "QQBuyGoods";
  public static final String TYPE_QQ_PAY = "QQPay";
  public static final String TYPE_QQ_PAY_GOODS = "QQPayGoods";
  private ConcurrentHashMap<Integer, BridgeInfo> bridgeMap;
  private boolean miniGameAutoConsume;
  PayResultRecevicer payRecevicer;
  
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
  
  private void handleMidasGoodsPay(Activity paramActivity, String paramString, JSONObject paramJSONObject, int paramInt)
    throws JSONException
  {
    String str1 = paramJSONObject.optString("offerId", "");
    JSONObject localJSONObject = paramJSONObject.getJSONObject("payInfo");
    paramJSONObject = paramJSONObject.getString("userId");
    String str2 = localJSONObject.getString("tokenUrl");
    String str3 = localJSONObject.optString("aid", "");
    String str4 = localJSONObject.optString("zoneId", "1");
    String str5 = localJSONObject.optString("numberVisible", "");
    String str6 = localJSONObject.optString("unit", "");
    String str7 = localJSONObject.optString("discountId", "");
    String str8 = localJSONObject.optString("other", "");
    localJSONObject = new JSONObject();
    localJSONObject.put("offerId", str1);
    localJSONObject.put("userId", paramJSONObject);
    localJSONObject.put("tokenUrl", str2);
    localJSONObject.put("zoneId", str4);
    localJSONObject.put("numberVisible", str5);
    localJSONObject.put("unit", str6);
    localJSONObject.put("aid", str3);
    localJSONObject.put("discountId", str7);
    localJSONObject.put("other", str8);
    localJSONObject.put("comeForm", 9);
    paramJSONObject = new Bundle();
    paramJSONObject.putString("payparmas_callback_sn", String.valueOf(paramInt));
    paramJSONObject.putString("payparmas_json", localJSONObject.toString());
    paramJSONObject.putInt("payparmas_paytype", 1);
    paramJSONObject.putLong("payparmas_h5_start", System.currentTimeMillis());
    if (PayBridgeActivity.newPay(AppLoaderFactory.getAppLoaderManager().getMiniAppInterface(), paramActivity, this.payRecevicer, 7, paramJSONObject).getInt("retCode", -1) != 0) {
      handleNativeResponseFail(paramInt, paramString, null, "");
    }
  }
  
  private void handleMidasMonthCardPay(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("payparmas_callback_sn", String.valueOf(paramInt));
    localBundle.putString("payparmas_json", paramString2);
    localBundle.putInt("payparmas_paytype", 1);
    localBundle.putLong("payparmas_h5_start", System.currentTimeMillis());
    if (PayBridgeActivity.newPay(AppLoaderFactory.getAppLoaderManager().getMiniAppInterface(), paramActivity, this.payRecevicer, 14, localBundle).getInt("retCode", -1) != 0) {
      handleNativeResponseFail(paramInt, paramString1, null, "");
    }
  }
  
  private void handleNativeResponseCancel(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (this.bridgeMap != null)
    {
      BridgeInfo localBridgeInfo = (BridgeInfo)this.bridgeMap.remove(Integer.valueOf(paramInt));
      if ((localBridgeInfo != null) && (this.jsPluginEngine != null)) {
        this.jsPluginEngine.callbackJsEventCancel(localBridgeInfo.getWebView(), paramString, paramJSONObject, localBridgeInfo.callbackId);
      }
    }
  }
  
  private void handleNativeResponseFail(int paramInt, String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    if (this.bridgeMap != null)
    {
      BridgeInfo localBridgeInfo = (BridgeInfo)this.bridgeMap.remove(Integer.valueOf(paramInt));
      if ((localBridgeInfo != null) && (this.jsPluginEngine != null)) {
        this.jsPluginEngine.callbackJsEventFail(localBridgeInfo.getWebView(), paramString1, paramJSONObject, paramString2, localBridgeInfo.callbackId);
      }
    }
  }
  
  private void handleNativeResponseOk(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (this.bridgeMap != null)
    {
      BridgeInfo localBridgeInfo = (BridgeInfo)this.bridgeMap.remove(Integer.valueOf(paramInt));
      if ((localBridgeInfo != null) && (this.jsPluginEngine != null)) {
        this.jsPluginEngine.callbackJsEventOK(localBridgeInfo.getWebView(), paramString, paramJSONObject, localBridgeInfo.callbackId);
      }
    }
  }
  
  private void handleQQPay(Activity paramActivity, String paramString1, String paramString2, JSONObject paramJSONObject, int paramInt)
    throws JSONException
  {
    String str1 = paramJSONObject.optString("prepayId", "");
    JSONObject localJSONObject = paramJSONObject.getJSONObject("payInfo");
    if (MiniLog.isColorLevel(paramString1)) {
      MiniLog.d("PayJsPlugin", 2, paramString1, "handleQQPay seq = " + paramInt + " appid=" + paramString1 + " payInfo = " + localJSONObject);
    }
    paramJSONObject = localJSONObject.optString("miniAppId", "");
    if (TextUtils.isEmpty(paramJSONObject)) {}
    for (;;)
    {
      paramJSONObject = localJSONObject.optString("bargainor_id", "");
      String str2 = localJSONObject.optString("channel", "");
      localJSONObject = new JSONObject();
      localJSONObject.put("tokenId", str1);
      localJSONObject.put("comeForm", 9);
      localJSONObject.put("appInfo", "appid#" + paramString1 + "|bargainor_id#" + paramJSONObject + "|channel#" + str2);
      paramString1 = new Bundle();
      paramString1.putString("payparmas_callback_sn", String.valueOf(paramInt));
      paramString1.putString("payparmas_json", localJSONObject.toString());
      paramString1.putInt("payparmas_paytype", 1);
      paramString1.putLong("payparmas_h5_start", System.currentTimeMillis());
      if (PayBridgeActivity.newPay(AppLoaderFactory.getAppLoaderManager().getMiniAppInterface(), paramActivity, this.payRecevicer, 9, paramString1).getInt("retCode", -1) != 0) {
        handleNativeResponseFail(paramInt, paramString2, null, "");
      }
      return;
      paramString1 = paramJSONObject;
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
      label124:
      QLog.d("PayJsPlugin", 1, "putAid, aid = " + paramString1);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      break label124;
    }
  }
  
  private void startPayBrowserActivity(Activity paramActivity, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt, JSONObject paramJSONObject)
  {
    paramJSONObject = new Intent(paramActivity, QQTranslucentBrowserActivity.class);
    paramJSONObject.putExtra("url", paramString1);
    paramString1 = new Bundle();
    paramString1.putBoolean("hide_left_button", true);
    paramString1.putBoolean("hide_more_button", true);
    paramJSONObject.putExtras(paramString1);
    paramString1 = GameRuntimeLoaderManager.g().getBindRuntimeLoader(this.jsPluginEngine.appBrandRuntime.activity);
    if (paramString1 != null) {}
    for (paramString1 = paramString1.getGameInfoManager().getMiniAppConfig();; paramString1 = null)
    {
      MiniAppController.getInstance().setActivityResultListener(new PayJsPlugin.5(this, paramInt, paramString1, paramJsRuntime, paramString2));
      paramActivity.startActivityForResult(paramJSONObject, 3003);
      return;
    }
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("PayJsPlugin", 2, "handleNativeRequest event=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt + ",webview=" + paramJsRuntime);
    Object localObject = new BridgeInfo(paramJsRuntime, paramInt);
    if (this.bridgeMap != null) {
      this.bridgeMap.put(Integer.valueOf(paramInt), localObject);
    }
    if ("requestPayment".equals(paramString1)) {
      MiniAppController.getInstance().setActivityResultListener(new PayJsPlugin.3(this, paramInt, paramString1));
    }
    int i;
    int j;
    String str1;
    for (;;)
    {
      try
      {
        paramString2 = new JSONObject(paramString2);
        handleQQPay(this.jsPluginEngine.getActivityContext(), this.jsPluginEngine.appBrandRuntime.appId, paramString1, paramString2, paramInt);
        return "";
      }
      catch (Exception paramString2)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PayJsPlugin", 2, paramString1 + " error,", paramString2);
        }
        handleNativeResponseFail(paramInt, paramString1, null, "");
        continue;
      }
      if ("requestMidasPayment".equals(paramString1))
      {
        try
        {
          paramString2 = new JSONObject(paramString2);
          paramJsRuntime = paramString2.optString("offerId");
          paramString2.put("userId", AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getCurrentAccountUin());
          paramString2.put("comeForm", 9);
          MiniAppCmdUtil.getInstance().checkOfferId(this.jsPluginEngine.appBrandRuntime.appId, paramJsRuntime, null, new PayJsPlugin.4(this, paramString2, paramString1, paramInt));
        }
        catch (Exception paramString2)
        {
          QLog.e("PayJsPlugin", 1, paramString1 + " error,", paramString2);
          handleNativeResponseFail(paramInt, paramString1, null, "");
        }
      }
      else
      {
        int k;
        int m;
        if ("consumeStarCurrency".equals(paramString1))
        {
          try
          {
            paramString2 = new JSONObject(paramString2);
            paramJsRuntime = paramString2.optString("prepayId");
            i = paramString2.optInt("starCurrency");
            j = paramString2.optInt("balanceAmount");
            k = paramString2.optInt("topupAmount");
            m = paramString2.optInt("payChannel");
            int n = paramString2.optInt("setEnv", 0);
            invokeMidasConsume(this.jsPluginEngine.appBrandRuntime.appId, paramJsRuntime, i, j, k, m, null, paramString1, paramInt, n);
          }
          catch (JSONException paramString2)
          {
            QLog.e("PayJsPlugin", 1, "consumestarcurrency error = ", paramString2);
            paramString2 = new JSONObject();
            try
            {
              paramString2.put("resultCode", 1000);
              handleNativeResponseFail(paramInt, paramString1, paramString2, acfp.m(2131709418));
            }
            catch (JSONException paramString1)
            {
              QLog.e("PayJsPlugin", 1, "handleNativeResponse error = ", paramString1);
            }
          }
        }
        else if ("queryStarCurrency".equals(paramString1))
        {
          try
          {
            paramString2 = new JSONObject(paramString2);
            paramJsRuntime = paramString2.optString("prepayId");
            i = paramString2.optInt("starCurrency");
            j = paramString2.optInt("setEnv", 0);
            this.miniGameAutoConsume = false;
            invokeMidasQuery(paramJsRuntime, this.jsPluginEngine.appBrandRuntime.appId, i, null, paramString1, paramInt, j);
          }
          catch (JSONException paramString2)
          {
            QLog.e("PayJsPlugin", 1, "querystarcurrency error = ", paramString2);
            paramString2 = new JSONObject();
            try
            {
              paramString2.put("resultCode", 1000);
              handleNativeResponseFail(paramInt, paramString1, null, acfp.m(2131709416));
            }
            catch (JSONException paramString1)
            {
              QLog.e("PayJsPlugin", 1, "handleNativeResponse error = ", paramString1);
            }
          }
        }
        else
        {
          if (("rechargeStarCurrency".equals(paramString1)) || ("rechargeAndConsumeStarCurrency".equals(paramString1)))
          {
            if ("rechargeAndConsumeStarCurrency".equals(paramString1)) {
              this.miniGameAutoConsume = true;
            }
            for (;;)
            {
              try
              {
                localObject = new JSONObject(paramString2);
                str1 = ((JSONObject)localObject).optString("prepayId", null);
                i = ((JSONObject)localObject).optInt("balanceAmount", -1);
                j = ((JSONObject)localObject).optInt("topupAmount", -1);
                k = ((JSONObject)localObject).optInt("starCurrency", -1);
                m = ((JSONObject)localObject).optInt("setEnv", 0);
                paramJsRuntime = ((JSONObject)localObject).optString("aid", "");
                paramString2 = paramJsRuntime;
                if (!TextUtils.isEmpty(paramJsRuntime))
                {
                  paramString2 = paramJsRuntime;
                  if (paramJsRuntime.contains("{appid}")) {
                    paramString2 = paramJsRuntime.replace("{appid}", this.jsPluginEngine.appBrandRuntime.appId);
                  }
                }
                ((JSONObject)localObject).put("userId", AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getCurrentAccountUin());
                ((JSONObject)localObject).put("aid", paramString2);
                ((JSONObject)localObject).put("comeForm", 9);
                ((JSONObject)localObject).put("setMidasEnv", m);
                if ((this.jsPluginEngine.getActivityContext() instanceof GameActivity))
                {
                  paramString2 = GameRuntimeLoaderManager.g().getBindRuntimeLoader(this.jsPluginEngine.appBrandRuntime.activity);
                  if (paramString2 == null) {
                    break label1137;
                  }
                  paramString2 = paramString2.getGameInfoManager().getMiniAppConfig();
                  if ((paramString2 != null) && (paramString2.config != null))
                  {
                    paramString2 = this.jsPluginEngine.appBrandRuntime.appId + "_" + paramString2.config.verType;
                    paramJsRuntime = arwv.encodeHexStr(paramString2);
                    AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getApp().getSharedPreferences("keyMiniGamePayEnv", 4).edit().putString("keyMiniGamePayEnvAppidVertype", paramJsRuntime).commit();
                    ((JSONObject)localObject).put("miniAppVertypeStr", paramString2);
                  }
                }
                paramJsRuntime = String.valueOf(paramInt);
                paramString2 = paramJsRuntime;
                if (i != -1)
                {
                  paramString2 = paramJsRuntime;
                  if (j != -1)
                  {
                    paramString2 = paramJsRuntime;
                    if (k != -1)
                    {
                      paramString2 = new JSONObject();
                      paramString2.put("appId", this.jsPluginEngine.appBrandRuntime.appId);
                      paramString2.put("prepayId", str1);
                      paramString2.put("balanceAmount", i);
                      paramString2.put("topupAmount", j);
                      paramString2.put("starCurrency", k);
                      paramString2.put("seq", paramInt);
                      paramString2.put("setEnv", m);
                      paramString2 = paramString2.toString();
                    }
                  }
                }
                handleRechargeGame(this.jsPluginEngine.getActivityContext(), paramString1, ((JSONObject)localObject).toString(), paramString2, paramInt, this.miniGameAutoConsume);
              }
              catch (JSONException paramString1)
              {
                QLog.e("PayJsPlugin", 1, "API_RECHARGE_STAR_CURRENCY JSONException ", paramString1);
              }
              break;
              label1137:
              paramString2 = null;
            }
          }
          if ("requestMidasGoodsPay".equals(paramString1))
          {
            try
            {
              paramString2 = new JSONObject(paramString2);
              paramString2.put("userId", AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getCurrentAccountUin());
              handleMidasGoodsPay(this.jsPluginEngine.getActivityContext(), paramString1, paramString2, paramInt);
            }
            catch (JSONException paramString2)
            {
              QLog.e("PayJsPlugin", 1, paramString1 + " error.", paramString2);
              handleNativeResponseFail(paramInt, paramString1, null, "");
            }
          }
          else
          {
            if (!"requestMidasMonthCardPay".equals(paramString1)) {
              break;
            }
            try
            {
              paramString2 = new JSONObject(paramString2);
              paramString2.put("userId", AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getCurrentAccountUin());
              handleMidasMonthCardPay(this.jsPluginEngine.getActivityContext(), paramString1, paramString2.toString(), paramInt);
            }
            catch (JSONException paramString1)
            {
              paramString1.printStackTrace();
            }
          }
        }
      }
    }
    if ("requestMidasPaymentByH5".equals(paramString1)) {}
    label1598:
    for (;;)
    {
      for (;;)
      {
        try
        {
          localObject = new JSONObject(paramString2);
          str1 = ((JSONObject)localObject).optString("prepayId");
          i = ((JSONObject)localObject).optInt("starCurrency");
          j = ((JSONObject)localObject).optInt("setEnv", 0);
          String str2 = ((JSONObject)localObject).optString("offerId", "1450023163");
          paramString2 = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_game_pay_by_h5_url", "https://h5.qzone.qq.com/miniapp/act/midasPay?offerId={offerId}&prepayId={prepayId}&starCurrency={starCurrency}&setEnv={setEnv}&appid={appid}&_proxy=1&_wv=17301504&_wwv=1");
          if ((!(this.jsPluginEngine.getActivityContext() instanceof GameActivity)) || (!((GameActivity)this.jsPluginEngine.getActivityContext()).getIsOrientationLandscape())) {
            break label1598;
          }
          paramString2 = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_game_pay_by_h5_url_landscape", "https://h5.qzone.qq.com/miniapp/act/midasPay?offerId={offerId}&prepayId={prepayId}&starCurrency={starCurrency}&setEnv={setEnv}&appid={appid}&_proxy=1&_wv=17303552&_wwv=1");
          paramString2 = paramString2.replace("{offerId}", str2).replace("{prepayId}", str1).replace("{starCurrency}", i + "").replace("{setEnv}", j + "").replace("{appid}", getAppId());
          startPayBrowserActivity(this.jsPluginEngine.getActivityContext(), paramString2, paramJsRuntime, paramString1, paramInt, (JSONObject)localObject);
        }
        catch (JSONException paramString1)
        {
          paramString1.printStackTrace();
        }
        break;
        if (!"checkH5PayStatus".equals(paramString1)) {
          break;
        }
        paramString2 = new JSONObject();
        try
        {
          paramString2.put("resultCode", QzoneConfig.getInstance().getConfig("qqminiapp", "mini_game_pay_by_h5", 1));
          handleNativeResponseOk(paramInt, paramString1, paramString2);
        }
        catch (JSONException paramJsRuntime)
        {
          for (;;)
          {
            paramJsRuntime.printStackTrace();
          }
        }
      }
    }
  }
  
  public void handleRechargeGame(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    AppBrandTask.runTaskOnUiThread(new PayJsPlugin.6(this, paramString3, paramString2, paramBoolean, paramInt, paramString1, paramActivity));
  }
  
  public void invokeMidasConsume(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, COMM.StCommonExt paramStCommonExt, String paramString3, int paramInt5, int paramInt6)
  {
    QLog.d("PayJsPlugin", 1, "invokeMidasConsume prepayId= " + paramString2 + " starCurrency=" + String.valueOf(paramInt1));
    if ((TextUtils.isEmpty(paramString2)) || (paramInt1 <= 0) || (TextUtils.isEmpty(paramString1)))
    {
      paramString1 = new JSONObject();
      try
      {
        paramString1.put("resultCode", -4);
        paramString1.put("resultMsg", acfp.m(2131709415));
        handleNativeResponseFail(paramInt5, paramString3, paramString1, "");
        return;
      }
      catch (JSONException paramString1)
      {
        QLog.e("PayJsPlugin", 1, "invokeMidasConsume JSONException ", paramString1);
        return;
      }
    }
    MiniAppCmdUtil.getInstance().getMidasConsumeResult(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt6, paramStCommonExt, new PayJsPlugin.8(this, paramInt5, paramString3));
  }
  
  public void invokeMidasQuery(String paramString1, String paramString2, int paramInt1, COMM.StCommonExt paramStCommonExt, String paramString3, int paramInt2, int paramInt3)
  {
    QLog.d("PayJsPlugin", 1, "invokeMidasQuery prepayId= " + paramString1 + " starCurrency=" + String.valueOf(paramInt1) + " setEnv:" + paramInt3);
    if ((TextUtils.isEmpty(paramString1)) || (paramInt1 <= 0) || (TextUtils.isEmpty(paramString2)))
    {
      paramString1 = new JSONObject();
      try
      {
        paramString1.put("resultCode", 1000);
        handleNativeResponseFail(paramInt2, paramString3, null, acfp.m(2131709417));
        return;
      }
      catch (JSONException paramString1)
      {
        QLog.e("PayJsPlugin", 1, "invokeMidasQuery JSONException ", paramString1);
        return;
      }
    }
    MiniAppCmdUtil.getInstance().getMidasQueryResult(paramString1, paramString2, paramInt1, paramInt3, paramStCommonExt, new PayJsPlugin.7(this, paramInt2, paramString3));
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
    this.bridgeMap = new ConcurrentHashMap();
    this.payRecevicer = new PayResultRecevicer(new Handler(Looper.getMainLooper()));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.bridgeMap != null) {
      this.bridgeMap.clear();
    }
  }
  
  @NonNull
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
  
  class PayResultRecevicer
    extends ResultReceiver
  {
    public PayResultRecevicer(Handler paramHandler)
    {
      super();
    }
    
    private void handlePayResult(int paramInt, Bundle paramBundle, String paramString)
    {
      String str4 = paramBundle.getString("result");
      String str3 = paramBundle.getString("callbackSn");
      String str1 = null;
      localJSONObject1 = null;
      localObject2 = null;
      localJSONObject2 = null;
      int i3 = -1;
      int i2 = -1;
      n = -1;
      int i5 = 0;
      int i4 = -1;
      paramBundle = localJSONObject1;
      Object localObject1 = localJSONObject2;
      int j = n;
      int k = i3;
      int m = i2;
      i = i4;
      int i1 = i5;
      if (!TextUtils.isEmpty(str3))
      {
        if (!JSONUtil.isJson(str3)) {
          break label656;
        }
        paramBundle = str1;
        localObject1 = localObject2;
        j = n;
        k = i3;
        m = i2;
        i = i4;
      }
      for (;;)
      {
        try
        {
          localJSONObject1 = new JSONObject(str3);
          paramBundle = str1;
          localObject1 = localObject2;
          j = n;
          k = i3;
          m = i2;
          i = i4;
          i4 = localJSONObject1.optInt("seq", -1);
          paramBundle = str1;
          localObject1 = localObject2;
          j = n;
          k = i3;
          m = i2;
          i = i4;
          str1 = localJSONObject1.optString("appId", null);
          paramBundle = str1;
          localObject1 = localObject2;
          j = n;
          k = i3;
          m = i2;
          i = i4;
          localObject2 = localJSONObject1.optString("prepayId", null);
          paramBundle = str1;
          localObject1 = localObject2;
          j = n;
          k = i3;
          m = i2;
          i = i4;
          i3 = localJSONObject1.optInt("balanceAmount", -1);
          paramBundle = str1;
          localObject1 = localObject2;
          j = n;
          k = i3;
          m = i2;
          i = i4;
          i2 = localJSONObject1.optInt("topupAmount", -1);
          paramBundle = str1;
          localObject1 = localObject2;
          j = n;
          k = i3;
          m = i2;
          i = i4;
          n = localJSONObject1.optInt("starCurrency", -1);
          paramBundle = str1;
          localObject1 = localObject2;
          j = n;
          k = i3;
          m = i2;
          i = i4;
          i1 = localJSONObject1.optInt("setEnv", 0);
          i = i4;
          m = i2;
          k = i3;
          j = n;
          localObject1 = localObject2;
          paramBundle = str1;
        }
        catch (JSONException localJSONException2)
        {
          QLog.e("PayJsPlugin", 1, localJSONException2, new Object[0]);
          i1 = i5;
          continue;
        }
        QLog.d("PayJsPlugin", 2, "onReceiveResult seq = " + i + " callbackSn=" + str3 + " result = " + str4);
        localJSONObject1 = new JSONObject();
        try
        {
          localJSONObject2 = new JSONObject(str4);
          localObject2 = null;
          if (localJSONObject2 == null) {
            break label944;
          }
          n = localJSONObject2.optInt("resultCode", -1);
          str1 = localJSONObject2.optString("resultMsg", "");
          localObject2 = localJSONObject2.optJSONObject("data");
        }
        catch (Throwable localThrowable1)
        {
          paramBundle = localJSONObject1;
          for (;;)
          {
            QLog.e("PayJsPlugin", 1, localThrowable1, new Object[0]);
            try
            {
              if (PayJsPlugin.this.miniGameAutoConsume) {
                paramBundle.put("resultCode", -3);
              }
              for (;;)
              {
                PayJsPlugin.this.handleNativeResponseFail(i, paramString, paramBundle, "");
                return;
                if ((paramInt == 9) && (localObject2 != null)) {
                  localJSONObject1.put("data", localObject2);
                }
                PayJsPlugin.this.handleNativeResponseOk(i, paramString, localJSONObject1);
                return;
                if (n == -1) {}
                for (paramBundle = ApiUtil.wrapCallbackCancel(paramString, null, localJSONException2);; paramBundle = ApiUtil.wrapCallbackFail(paramString, localJSONObject2, localJSONException2))
                {
                  try
                  {
                    if (PayJsPlugin.this.miniGameAutoConsume) {
                      paramBundle.put("resultCode", -3);
                    }
                    if (n != -1) {
                      break label908;
                    }
                    PayJsPlugin.this.handleNativeResponseCancel(i, paramString, paramBundle);
                    return;
                  }
                  catch (Throwable localThrowable2) {}
                  break;
                }
                PayJsPlugin.this.handleNativeResponseFail(i, paramString, localJSONObject2, localJSONException2);
                return;
                paramBundle.put("resultCode", -1);
              }
            }
            catch (JSONException localJSONException1)
            {
              for (;;)
              {
                localJSONException1.printStackTrace();
              }
            }
          }
          n = -1;
          String str2 = "";
          continue;
        }
        QLog.d("PayJsPlugin", 1, "onReceiveResult seq = " + i + " callbackSn=" + str3 + " ret = " + n + " miniGameAutoConsume = " + PayJsPlugin.this.miniGameAutoConsume);
        localJSONObject1.put("resultCode", n);
        if (n != 0) {
          break label840;
        }
        if (!PayJsPlugin.this.miniGameAutoConsume) {
          break label806;
        }
        paramInt = localJSONObject2.optInt("payChannel", -1);
        if ((TextUtils.isEmpty(paramBundle)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (j == -1) || (m == -1) || (k == -1) || (paramInt == -1)) {
          break;
        }
        PayJsPlugin.this.invokeMidasConsume(paramBundle, (String)localObject1, j, k, m, paramInt, null, paramString, i, i1);
        return;
        try
        {
          label656:
          i = Integer.parseInt(str3);
          paramBundle = localJSONObject1;
          localObject1 = localJSONObject2;
          j = n;
          k = i3;
          m = i2;
          i1 = i5;
        }
        catch (NumberFormatException paramBundle)
        {
          QLog.e("PayJsPlugin", 1, paramBundle, new Object[0]);
          paramBundle = localJSONObject1;
          localObject1 = localJSONObject2;
          j = n;
          k = i3;
          m = i2;
          i = i4;
          i1 = i5;
        }
      }
      localJSONObject1.put("resultCode", -4);
      PayJsPlugin.this.handleNativeResponseFail(i, paramString, localJSONObject1, localJSONException2);
    }
    
    protected void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      QLog.d("PayJsPlugin", 2, "onReceiveResult resultCode = " + paramInt + " resultData = " + paramBundle);
      switch (paramInt)
      {
      case 8: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      default: 
        return;
      case 6: 
        handlePayResult(paramInt, paramBundle, "requestMidasPayment");
        return;
      case 9: 
        handlePayResult(paramInt, paramBundle, "requestPayment");
        return;
      case 7: 
        handlePayResult(paramInt, paramBundle, "requestMidasGoodsPay");
        return;
      }
      handlePayResult(paramInt, paramBundle, "requestMidasMonthCardPay");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.PayJsPlugin
 * JD-Core Version:    0.7.0.1
 */