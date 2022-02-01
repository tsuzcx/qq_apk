package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_MINI_AD.MiniAppAd.StGetAdReq;
import android.text.TextUtils;
import aqnm;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.data.BannerAdPosInfo;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tkv;

public class BannerAdPlugin
  extends BaseJsPlugin
{
  private static final HashMap<Integer, String> AD_ERROR_MSG = PluginConst.AdConst.CodeMsgMap;
  public static final String API_AD_CREATE_BANNER_AD = "createBannerAd";
  public static final String API_AD_OPERATE_BANNER_AD = "operateBannerAd";
  public static final String API_AD_UPDATE_BANNER_AD_SIZE = "updateBannerAdSize";
  public static final String EVENT_BANNER_AD_SHOW_DONE = "onBannerAdShowDone";
  public static final String EVENT_BANNER_AD_STATE_CHANGE = "onBannerAdStateChange";
  private static final Set<String> S_EVENT_MAP = new BannerAdPlugin.1();
  private static final String TAG = "[minigame] BannerAdPlugin";
  
  private void bannerErrorStateCallback(JsRuntime paramJsRuntime, int paramInt, String paramString)
  {
    if (paramJsRuntime == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", "error");
      localJSONObject.put("errMsg", paramString);
      localJSONObject.put("errCode", paramInt);
      informJs(paramJsRuntime, localJSONObject, "onBannerAdStateChange");
      return;
    }
    catch (JSONException paramJsRuntime)
    {
      QLog.e("[minigame] BannerAdPlugin", 1, "bannerErrorStateCallback error", paramJsRuntime);
    }
  }
  
  private void bannerErrorStateCallbackDelay(JsRuntime paramJsRuntime, int paramInt1, String paramString, int paramInt2)
  {
    if (paramJsRuntime == null) {
      return;
    }
    AppBrandTask.runTaskOnUiThreadDelay(new BannerAdPlugin.6(this, paramString, paramInt1, paramJsRuntime), paramInt2);
  }
  
  private qq_ad_get.QQAdGetRsp.AdInfo getBannerAdInfo(JsRuntime paramJsRuntime, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString).getJSONArray("pos_ads_info").getJSONObject(0);
      int i = Integer.valueOf(localJSONObject.getString("ret")).intValue();
      String str = localJSONObject.getString("msg");
      if (i == 0)
      {
        localJSONObject = localJSONObject.getJSONArray("ads_info").getJSONObject(0);
        return (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), localJSONObject));
      }
      if (paramJsRuntime != null)
      {
        bannerErrorStateCallback(paramJsRuntime, 1004, (String)AD_ERROR_MSG.get(Integer.valueOf(1004)));
        QLog.i("[minigame] BannerAdPlugin", 2, "getBannerAdInfo error, ret = " + i + ", msg = " + str);
      }
      return null;
    }
    catch (Exception localException)
    {
      bannerErrorStateCallback(paramJsRuntime, 1004, (String)AD_ERROR_MSG.get(Integer.valueOf(1004)));
      QLog.i("[minigame] BannerAdPlugin", 2, "getBannerAdInfo error" + paramString, localException);
    }
    return null;
  }
  
  private void informJs(JsRuntime paramJsRuntime, JSONObject paramJSONObject, String paramString)
  {
    if (paramJsRuntime != null) {
      paramJsRuntime.evaluateSubcribeJS(paramString, paramJSONObject.toString(), 0);
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
        AdUtils.putSpAdGdtCookie(paramInt, (String)localObject);
        QLog.i("[minigame] BannerAdPlugin", 2, "parseAndSaveCookie save key success, adType = " + paramInt + ", value = " + (String)localObject);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.i("[minigame] BannerAdPlugin", 2, "parseAndSaveCookie error" + paramString, localException);
    }
  }
  
  private void updateBannerSize(JsRuntime paramJsRuntime, String paramString)
  {
    int n = 1;
    int i;
    int j;
    int k;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (localJSONObject.has("left"))
        {
          i = localJSONObject.getInt("left");
          j = 1;
          break label527;
        }
        if (localJSONObject.has("top"))
        {
          i = localJSONObject.getInt("top");
          j = 2;
          break label527;
        }
        if (!localJSONObject.has("width")) {
          break label521;
        }
        float f = aqnm.getDensity();
        j = aqnm.getScreenWidth();
        i = aqnm.getScreenHeight();
        if (!(this.jsPluginEngine.activityContext instanceof GameActivity)) {
          break label513;
        }
        f = ((GameActivity)this.jsPluginEngine.activityContext).getGameDensity();
        if (((GameActivity)this.jsPluginEngine.activityContext).getIsOrientationLandscape())
        {
          i = 90;
          j = ((GameActivity)this.jsPluginEngine.activityContext).getGameWidth();
          int m = ((GameActivity)this.jsPluginEngine.activityContext).getGameHeight();
          paramString = ((GameActivity)this.jsPluginEngine.activityContext).getBannerAdPosInfo();
          k = i;
          i = m;
          m = localJSONObject.getInt("width");
          i = BannerAdPosInfo.calculateLegalWidth(m, k, f, j, i);
          if ((paramString == null) || (m == paramString.mAdWidth) || (i != paramString.mAdRealWidth)) {
            break label507;
          }
          paramString.mAdWidth = m;
          try
          {
            localJSONObject = new JSONObject();
            localJSONObject.put("state", "resize");
            localJSONObject.put("width", paramString.mAdRealWidth);
            localJSONObject.put("height", paramString.mAdRealHeight);
            informJs(paramJsRuntime, localJSONObject, "onBannerAdStateChange");
            return;
          }
          catch (JSONException paramJsRuntime)
          {
            QLog.e("[minigame] BannerAdPlugin", 1, "updateBannerAd informJs error", paramJsRuntime);
            return;
          }
        }
        i = 0;
      }
      catch (JSONException paramJsRuntime)
      {
        QLog.e("[minigame] BannerAdPlugin", 2, "handle updateBannerAdSize parse json error", paramJsRuntime);
        return;
      }
      continue;
      label322:
      if (i < 0)
      {
        bannerErrorStateCallback(paramJsRuntime, 1003, (String)AD_ERROR_MSG.get(Integer.valueOf(1003)));
        return;
      }
      if ((j == -1) || (!(this.jsPluginEngine.activityContext instanceof GameActivity))) {
        break label533;
      }
      paramString = ((GameActivity)this.jsPluginEngine.activityContext).getBannerAdPosInfo();
      if (paramString != null) {
        switch (j)
        {
        }
      }
    }
    for (;;)
    {
      if (k == 0)
      {
        if (QLog.isColorLevel())
        {
          QLog.i("[minigame] BannerAdPlugin", 1, "updateBannerAd no need to resize");
          return;
          if (paramString.mAdLeft == i) {
            break label544;
          }
          k = 1;
          break label541;
          k = n;
          if (paramString.mAdTop != i) {
            continue;
          }
          k = 0;
          continue;
          k = n;
          if (paramString.mAdRealWidth != i) {
            continue;
          }
          k = 0;
        }
      }
      else
      {
        AppBrandTask.runTaskOnUiThread(new BannerAdPlugin.5(this, j, i, paramJsRuntime));
        return;
        label507:
        j = 3;
        break label527;
        label513:
        k = 0;
        paramString = null;
        break;
        label521:
        i = -1;
        j = -1;
        label527:
        if (j != -1) {
          break label322;
        }
      }
      label533:
      return;
      k = n;
    }
    for (;;)
    {
      label541:
      break;
      label544:
      k = 0;
    }
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.i("[minigame] BannerAdPlugin", 2, "handleNativeRequest jsonParams : " + paramString2 + " event:" + paramString1);
    Object localObject1 = this.jsPluginEngine.appBrandRuntime.activity;
    if ("createBannerAd".equals(paramString1))
    {
      QLog.i("[minigame] BannerAdPlugin", 2, "receive createBannerAd event");
      if (this.jsPluginEngine == null)
      {
        QLog.i("[minigame] BannerAdPlugin", 2, "handle createBannerAd event, jsPluginEngine == null");
        return "";
      }
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject2 = BannerAdPosInfo.parseBannerAdPosInfoFromJson(paramString2);
        if (localObject2 == null)
        {
          bannerErrorStateCallbackDelay(paramJsRuntime, 1001, (String)AD_ERROR_MSG.get(Integer.valueOf(1001)), 300);
          QLog.i("[minigame] BannerAdPlugin", 2, "handle createBannerAd error params" + paramString2);
          return "";
        }
        String str3 = this.jsPluginEngine.activityContext.getCurrentAccountUin();
        localObject1 = null;
        int k = 0;
        float f = aqnm.getDensity();
        int j = aqnm.getScreenWidth();
        i = aqnm.getScreenWidth();
        if ((this.jsPluginEngine.activityContext instanceof GameActivity))
        {
          localObject1 = ((GameActivity)this.jsPluginEngine.activityContext).getMiniGameAppId();
          if (!((GameActivity)this.jsPluginEngine.activityContext).getIsOrientationLandscape()) {
            break label1159;
          }
          i = 90;
          f = ((GameActivity)this.jsPluginEngine.activityContext).getGameDensity();
          j = ((GameActivity)this.jsPluginEngine.activityContext).getGameWidth();
          int m = ((GameActivity)this.jsPluginEngine.activityContext).getGameHeight();
          k = i;
          i = m;
        }
        QLog.i("[minigame] BannerAdPlugin", 2, "handle createBannerAd appId = " + (String)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          bannerErrorStateCallbackDelay(paramJsRuntime, 1001, (String)AD_ERROR_MSG.get(Integer.valueOf(1001)), 300);
          return "";
        }
        BannerAdPosInfo localBannerAdPosInfo = BannerAdPosInfo.buildFormatInfo((BannerAdPosInfo)localObject2, k, f, j, i);
        if ((localBannerAdPosInfo == null) || (!localBannerAdPosInfo.isValid()))
        {
          bannerErrorStateCallbackDelay(paramJsRuntime, 1001, (String)AD_ERROR_MSG.get(Integer.valueOf(1001)), 300);
          QLog.i("[minigame] BannerAdPlugin", 2, "handle createBannerAd invalid adInfo = " + localBannerAdPosInfo);
          return "";
        }
        String str4 = AdUtils.getSpAdGdtCookie(0);
        ApkgInfo localApkgInfo = this.jsPluginEngine.appBrandRuntime.getApkgInfo();
        Object localObject3 = "";
        Object localObject5 = "";
        String str2 = "";
        String str1 = "";
        localObject2 = localObject3;
        if (localApkgInfo != null)
        {
          localObject2 = localObject3;
          if (localApkgInfo.appConfig != null)
          {
            localObject2 = localObject3;
            if (localApkgInfo.appConfig.launchParam != null)
            {
              localObject2 = localObject3;
              if (localApkgInfo.appConfig.launchParam.entryPath != null) {
                localObject2 = localApkgInfo.appConfig.launchParam.entryPath;
              }
            }
          }
        }
        Object localObject4 = localObject5;
        localObject3 = str2;
        if (localApkgInfo != null)
        {
          localObject4 = localObject5;
          localObject3 = str2;
          if (localApkgInfo.appConfig != null)
          {
            localObject4 = localObject5;
            localObject3 = str2;
            if (localApkgInfo.appConfig.launchParam != null)
            {
              localObject4 = localApkgInfo.appConfig.launchParam.reportData;
              localObject3 = String.valueOf(localApkgInfo.appConfig.launchParam.scene);
            }
          }
        }
        localObject5 = str1;
        if (localApkgInfo != null)
        {
          localObject5 = str1;
          if (localApkgInfo.appConfig != null)
          {
            localObject5 = str1;
            if (localApkgInfo.appConfig.config != null) {
              localObject5 = localApkgInfo.appConfig.config.via;
            }
          }
        }
        localObject1 = AdUtils.createAdRequest(this.jsPluginEngine.activityContext, Long.valueOf(str3).longValue(), localBannerAdPosInfo.mAdUnitId, (String)localObject1, 53, 0, k, str4, (String)localObject2, (String)localObject4, (String)localObject3, (String)localObject5, 1);
        MiniAppCmdUtil.getInstance().getRewardedVideoADInfo((MiniAppAd.StGetAdReq)localObject1, new BannerAdPlugin.2(this, paramJsRuntime, localBannerAdPosInfo));
        return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
      }
      catch (Exception localException)
      {
        localObject1 = ApiUtil.wrapCallbackFail(paramString1, null);
        if (localObject1 == null) {}
      }
      for (localObject1 = ((JSONObject)localObject1).toString();; localObject1 = "")
      {
        bannerErrorStateCallback(paramJsRuntime, 1003, (String)AD_ERROR_MSG.get(Integer.valueOf(1003)));
        QLog.i("[minigame] BannerAdPlugin", 2, "handle createBannerAd parse json error" + paramString2, localException);
        if (localObject1 == null) {
          break;
        }
        return localObject1;
      }
      if ("operateBannerAd".equals(paramString1))
      {
        if (QLog.isColorLevel()) {
          QLog.i("[minigame] BannerAdPlugin", 2, "receive operateBannerAd event");
        }
        if (this.jsPluginEngine == null)
        {
          QLog.i("[minigame] BannerAdPlugin", 2, "handle operateBannerAd event, jsPluginEngine == null");
          return "";
        }
        try
        {
          localObject1 = new JSONObject(paramString2).getString("type");
          QLog.i("[minigame] BannerAdPlugin", 2, "handle operateBannerAd type = " + (String)localObject1);
          if (!"show".equals(localObject1)) {
            break label973;
          }
          if (!(this.jsPluginEngine.activityContext instanceof GameActivity)) {
            continue;
          }
          AppBrandTask.runTaskOnUiThreadDelay(new BannerAdPlugin.3(this, paramJsRuntime), 300L);
        }
        catch (JSONException localJSONException)
        {
          QLog.i("[minigame] BannerAdPlugin", 2, "handle operateBannerAd parse json error", localJSONException);
        }
        continue;
        label973:
        if ("hide".equals(localJSONException))
        {
          if ((this.jsPluginEngine.activityContext instanceof GameActivity)) {
            AppBrandTask.runTaskOnUiThread(new BannerAdPlugin.4(this));
          }
        }
        else if ("destroy".equals(localJSONException))
        {
          if ((this.jsPluginEngine.activityContext instanceof GameActivity)) {
            ((GameActivity)this.jsPluginEngine.activityContext).destroyBannerAd();
          }
        }
        else {
          QLog.i("[minigame] BannerAdPlugin", 2, "handle operateBannerAd not define type = " + localJSONException);
        }
      }
      else if ("updateBannerAdSize".equals(paramString1))
      {
        QLog.i("[minigame] BannerAdPlugin", 2, "updateBannerAdSize " + paramString2);
        if ((this.jsPluginEngine == null) || (this.jsPluginEngine.activityContext == null) || (paramJsRuntime == null))
        {
          QLog.i("[minigame] BannerAdPlugin", 2, "handle updateBannerAdSize event, jsPluginEngine == null");
          return "";
        }
        updateBannerSize(paramJsRuntime, paramString2);
        continue;
        label1159:
        i = 0;
      }
    }
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BannerAdPlugin
 * JD-Core Version:    0.7.0.1
 */