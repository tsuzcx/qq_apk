package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_MINI_AD.MiniAppAd.StGetAdReq;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.ShareUtils;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils.OnShareListener;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import com.tencent.mobileqq.minigame.jsapi.callbacks.IGameUI;
import com.tencent.mobileqq.minigame.jsapi.manager.SystemInfoManager;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoaderManager;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import ram;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tkv;
import tzd;
import tzg;
import tzk;

public class DataJsPlugin
  extends BaseJsPlugin
{
  public static final String AD_REF_ID = "biz_src_miniappD";
  public static final String API_ADD_CONTACT = "private_addContact";
  public static final String API_BATCH_GET_CONTACT = "batchGetContact";
  public static final String API_GET_APP_CONFIG = "getAppConfig";
  public static final String API_GET_CLOUD_TICKET = "getCloudTicket";
  public static final String API_GET_LAUNCH_OPTIONS_SYNC = "getLaunchOptionsSync";
  public static final String API_GET_PERFORMANCE = "getPerformance";
  public static final String API_GET_PERMISSION_BYTES = "getPermissionBytes";
  public static final String API_GET_SHARE_INFO = "getShareInfo";
  private static final String API_GET_SYSTEM_INFO = "getSystemInfo";
  private static final String API_GET_SYSTEM_INFO_SYNC = "getSystemInfoSync";
  private static final String API_GET_TEXT_LINEHEIGHT = "getTextLineHeight";
  public static final String API_HIDE_SHARE_MENU = "hideShareMenu";
  public static final String API_INIT_READY = "initReady";
  public static final String API_LOGIN = "login";
  public static final String API_PRIVATE_OPENURL = "private_openUrl";
  public static final String API_PROFILE = "profile";
  public static final String API_REFRESH_SESSION = "refreshSession";
  public static final String API_SET_OFFLINE_RESOURCE_READY = "recordOffLineResourceState";
  public static final String API_SHARE_APP_MSG = "shareAppMessage";
  public static final String API_SHARE_APP_MSG_DIRECTLY = "shareAppMessageDirectly";
  public static final String API_SHARE_APP_MSG_DIRECTLY_TO_FRIEND_LIST = "shareAppMessageDirectlyToFriendList";
  public static final String API_SHARE_APP_PIC_MSG = "shareAppPictureMessage";
  public static final String API_SHARE_APP_PIC_MSG_DIRECTLY = "shareAppPictureMessageDirectly";
  public static final String API_SHARE_APP_PIC_MSG_TO_FRIEND_LIST = "shareAppPictureMessageDirectlyToFriendList";
  public static final String API_SHARE_INVITE = "shareInvite";
  public static final String API_SHOW_SHARE_MENU = "showShareMenu";
  public static final String API_SHOW_SHARE_MENU_WITH_SHARE_TICKET = "showShareMenuWithShareTicket";
  public static final String API_UPDATE_SHARE_MENU = "updateShareMenuShareTicket";
  public static final String API_VERIFY_PLUGIN = "verifyPlugin";
  private static final String CONFIG_SPLIT = ",";
  public static final int ERRCODE_INVITE_CANCEL = 1;
  public static final int ERRCODE_INVITE_REQUIRE = 2;
  public static final String ERRMSG_INVITE_CANCEL = "用户取消";
  public static final String ERRMSG_INVITE_REQUIRE = "分享失败";
  private static final String MINI_APP_STORE_APPID = "1108291530";
  public static final int NEED_HIDE = 0;
  public static final int NEED_SHOW = 1;
  public static final String PREF_NAME = "miniAppLoginSp";
  public static final String PRIVATE_API_NAVIGATE_TO_MINI_PROGRAM_CONFIG = "navigateToMiniProgramConfig";
  public static final String SHARE_ITEM_QQ = "qq";
  public static final String SHARE_ITEM_QZONE = "qzone";
  public static final String SHARE_ITEM_WECHAT_FRIEND = "wechatFriends";
  public static final String SHARE_ITEM_WECHAT_MOMENT = "wechatMoment";
  public static final int SHARE_TARGET_QQ = 0;
  public static final int SHARE_TARGET_QQ_DIRECTLY = 2;
  public static final int SHARE_TARGET_QZONE = 1;
  public static final int SHARE_TARGET_SHARE_CHAT = 5;
  public static final int SHARE_TARGET_TO_FRIEND_LIST = 6;
  public static final int SHARE_TARGET_WECHAT_FRIEND = 3;
  public static final int SHARE_TARGET_WECHAT_MOMENTS = 4;
  private static final Set<String> S_EVENT_MAP = new DataJsPlugin.1();
  private static final String TAG = "[mini] DataJsPlugin";
  public static final int UNDEFINED = -1;
  private static final int WHAT_GET_SHARE_INFO_TIMEOUT = 1;
  private static final String fakeCheckNavigateRightRsp = "{\"action_code\":1,\"skip_local_check\":1,\"wording\":\"\"}";
  private tzg apiManager;
  private Long lastNotRspReqTime = Long.valueOf(0L);
  private List<tzd> loginCallBacks = new LinkedList();
  protected GdtAppReceiver mGgtAppReceiver;
  private SystemInfoManager mSystemInfoManager;
  private ArrayList<String> openUrlDomainWhiteList;
  private String privateOpenUrlDomainWhiteList;
  
  private boolean doShareInvite(JsRuntime paramJsRuntime, String paramString, int paramInt)
  {
    try
    {
      MiniProgramShareUtils.shareUpdatableMsg(this.jsPluginEngine.activityContext, this.jsPluginEngine.appBrandRuntime.appId, this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.config.verType, "657667B4D8C04B3F84E4AAA3D046A903", paramString, paramInt);
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[mini] DataJsPlugin", 1, "shareInvite error, ", localThrowable);
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString, null, paramInt);
    }
    return false;
  }
  
  private void downloadImageByURLDrawable(String paramString, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
    if (paramURLDrawableListener != null)
    {
      if (paramString.getStatus() != 1) {
        break label45;
      }
      ram.d("[mini] DataJsPlugin", "URLDrawable's status is SUCCESSED.");
      paramURLDrawableListener.onLoadSuccessed(paramString);
    }
    for (;;)
    {
      paramString.setURLDrawableListener(paramURLDrawableListener);
      paramString.downloadImediatly();
      return;
      label45:
      ram.d("[mini] DataJsPlugin", "start load URLDrawable.");
    }
  }
  
  private qq_ad_get.QQAdGetRsp.AdInfo getBannerAdInfo(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString).getJSONArray("pos_ads_info").getJSONObject(0);
      int i = Integer.valueOf(((JSONObject)localObject).getString("ret")).intValue();
      ((JSONObject)localObject).getString("msg");
      if (i == 0)
      {
        localObject = ((JSONObject)localObject).getJSONArray("ads_info").getJSONObject(0);
        localObject = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), localObject));
        return localObject;
      }
    }
    catch (Exception localException)
    {
      QLog.i("[mini] DataJsPlugin", 2, "getBannerAdInfo error" + paramString, localException);
      return null;
    }
    return null;
  }
  
  private void getOpenUrlDomainWhiteList()
  {
    if (this.openUrlDomainWhiteList == null)
    {
      String str1 = QzoneConfig.getInstance().getConfig("qqminiapp", "domainWhiteList", "tucao.qq.com,mobile.qzone.qq.com");
      if ((str1 != null) && (!str1.equals(this.privateOpenUrlDomainWhiteList)))
      {
        QLog.i("[mini] DataJsPlugin", 1, "getOpenUrlDomainWhiteList:" + str1);
        this.openUrlDomainWhiteList = new ArrayList();
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
                this.openUrlDomainWhiteList.add(str2);
              }
              i += 1;
            }
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          this.privateOpenUrlDomainWhiteList = str1;
        }
      }
    }
  }
  
  private static SharedPreferences getPreference(String paramString)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      return localBaseApplicationImpl.getSharedPreferences(paramString, 0);
    }
    return null;
  }
  
  private void handleAdApi(JSONObject paramJSONObject, JsRuntime paramJsRuntime, String paramString, int paramInt1, int paramInt2)
  {
    String str3 = paramJSONObject.optJSONObject("data").optString("pos_id");
    if (paramJSONObject.optJSONObject("data").has("adType")) {
      paramInt2 = paramJSONObject.optJSONObject("data").optInt("adType");
    }
    for (;;)
    {
      int i = 1;
      if (paramJSONObject.optJSONObject("data").has("size")) {
        i = paramJSONObject.optJSONObject("data").optInt("size");
      }
      long l = Long.valueOf(this.jsPluginEngine.activityContext.getCurrentAccountUin()).longValue();
      paramJSONObject = null;
      if (this.jsPluginEngine.appBrandRuntime != null) {
        paramJSONObject = this.jsPluginEngine.appBrandRuntime.appId;
      }
      QLog.d("[mini] DataJsPlugin", 2, "getBlockAd appid = " + paramJSONObject);
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        String str4 = AdUtils.getSpAdGdtCookie(paramInt2);
        ApkgInfo localApkgInfo = this.jsPluginEngine.appBrandRuntime.getApkgInfo();
        Object localObject2 = "";
        Object localObject4 = "";
        String str2 = "";
        String str1 = "";
        Object localObject1 = localObject2;
        if (localApkgInfo != null)
        {
          localObject1 = localObject2;
          if (localApkgInfo.appConfig != null)
          {
            localObject1 = localObject2;
            if (localApkgInfo.appConfig.launchParam != null)
            {
              localObject1 = localObject2;
              if (localApkgInfo.appConfig.launchParam.entryPath != null) {
                localObject1 = localApkgInfo.appConfig.launchParam.entryPath;
              }
            }
          }
        }
        Object localObject3 = localObject4;
        localObject2 = str2;
        if (localApkgInfo != null)
        {
          localObject3 = localObject4;
          localObject2 = str2;
          if (localApkgInfo.appConfig != null)
          {
            localObject3 = localObject4;
            localObject2 = str2;
            if (localApkgInfo.appConfig.launchParam != null)
            {
              localObject3 = localApkgInfo.appConfig.launchParam.reportData;
              localObject2 = String.valueOf(localApkgInfo.appConfig.launchParam.scene);
            }
          }
        }
        localObject4 = str1;
        if (localApkgInfo != null)
        {
          localObject4 = str1;
          if (localApkgInfo.appConfig != null)
          {
            localObject4 = str1;
            if (localApkgInfo.appConfig.config != null) {
              localObject4 = localApkgInfo.appConfig.config.via;
            }
          }
        }
        sendAdRequest(AdUtils.createAdRequest(this.jsPluginEngine.activityContext, l, str3, paramJSONObject, 53, paramInt2, 0, str4, (String)localObject1, (String)localObject3, (String)localObject2, (String)localObject4, i), paramJsRuntime, paramString, paramInt1, paramInt2);
      }
      return;
    }
  }
  
  private String handleGameSystemInfo(String paramString, JsRuntime paramJsRuntime, int paramInt)
  {
    MiniGamePkg localMiniGamePkg = null;
    if (this.jsPluginEngine != null) {}
    for (Object localObject1 = this.jsPluginEngine.getActivityContext();; localObject1 = null)
    {
      boolean bool;
      if ((localObject1 instanceof GameActivity)) {
        if (this.mSystemInfoManager == null)
        {
          this.mSystemInfoManager = new SystemInfoManager((Context)localObject1);
          Object localObject2 = GameRuntimeLoaderManager.g().getBindRuntimeLoader(this.jsPluginEngine.appBrandRuntime.activity);
          if (localObject2 != null) {
            localMiniGamePkg = ((GameRuntimeLoader)localObject2).getMiniGamePkg();
          }
          localObject2 = this.mSystemInfoManager;
          if ((localMiniGamePkg == null) || (!localMiniGamePkg.isOrientationLandscape())) {
            break label142;
          }
          bool = true;
          ((SystemInfoManager)localObject2).setLandscape(bool);
          this.mSystemInfoManager.setGameUI((IGameUI)localObject1);
        }
      }
      for (localObject1 = this.mSystemInfoManager.getSystemInfo();; localObject1 = ApiUtil.wrapCallbackFail(paramString, null))
      {
        if (!"getSystemInfoSync".equals(paramString)) {
          break label167;
        }
        return ((JSONObject)localObject1).toString();
        label142:
        bool = false;
        break;
        QLog.e("[mini] DataJsPlugin", 1, "getSystemInfo error, context is not GameActivity");
      }
      label167:
      paramJsRuntime.evaluateCallbackJs(paramInt, ((JSONObject)localObject1).toString());
      return "";
    }
  }
  
  private void initApiManager(int paramInt, String paramString)
  {
    tzk.prepare();
    this.apiManager = tzk.a(this.jsPluginEngine.getActivityContext(), paramInt, paramString);
  }
  
  private void operateGetShareInfo(String paramString1, int paramInt1, JsRuntime paramJsRuntime, String paramString2, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString2, null, "shareTicket can not be null", paramInt2);
      return;
    }
    Object localObject = new HandlerThread("getShareInfoHandlerThread");
    ((HandlerThread)localObject).start();
    localObject = new Handler(((HandlerThread)localObject).getLooper(), new DataJsPlugin.24(this, paramJsRuntime, paramString2, paramInt2));
    ((Handler)localObject).sendEmptyMessageDelayed(1, paramInt1);
    MiniAppCmdUtil.getInstance().getGroupShareInfo(this.jsPluginEngine.appBrandRuntime.appId, paramString1, null, new DataJsPlugin.25(this, paramJsRuntime, paramString2, paramInt2, (Handler)localObject));
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
        QLog.i("[mini] DataJsPlugin", 2, "parseAndSaveCookie save key success, adType = " + paramInt + ", value = " + (String)localObject);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.i("[mini] DataJsPlugin", 2, "parseAndSaveCookie error" + paramString, localException);
    }
  }
  
  private void sendAdRequest(MiniAppAd.StGetAdReq paramStGetAdReq, JsRuntime paramJsRuntime, String paramString, int paramInt1, int paramInt2)
  {
    MiniAppCmdUtil.getInstance().getRewardedVideoADInfo(paramStGetAdReq, new DataJsPlugin.28(this, paramJsRuntime, paramString, paramInt1, paramInt2));
  }
  
  private void startGroupBrowserActivity(Activity paramActivity, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString1);
    paramString1 = new Bundle();
    paramString1.putBoolean("hide_more_button", true);
    localIntent.putExtras(paramString1);
    MiniAppController.getInstance().setActivityResultListener(new DataJsPlugin.29(this, paramJsRuntime, paramString2, paramInt));
    paramActivity.startActivityForResult(localIntent, 9);
  }
  
  private void startShareLocalPicMessage(String paramString1, String paramString2, int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 0: 
      ShareUtils.startSharePicToQQ(this.jsPluginEngine.getActivityContext(), paramString2);
      return;
    case 1: 
      ShareUtils.startSharePicToQzone(this.jsPluginEngine.getActivityContext(), paramString2, this.jsPluginEngine.appBrandRuntime.getApkgInfo().apkgName);
      return;
    case 3: 
      ShareUtils.startSharePicToWeChat(this.jsPluginEngine.getActivityContext(), ShareUtils.getFileUri(this.jsPluginEngine.getActivityContext(), paramString2), true);
      return;
    }
    ShareUtils.startSharePicToWeChat(this.jsPluginEngine.getActivityContext(), ShareUtils.getFileUri(this.jsPluginEngine.getActivityContext(), paramString2), false);
  }
  
  private void startShareNetworkPicMessage(Context paramContext, String paramString1, String paramString2, int paramInt, MiniProgramShareUtils.OnShareListener paramOnShareListener)
  {
    ThreadManager.getUIHandler().post(new DataJsPlugin.30(this, paramContext, paramString2, paramString1, paramInt));
  }
  
  public void getUserInfo(JsRuntime paramJsRuntime, String paramString1, String paramString2, int paramInt, boolean paramBoolean, String paramString3)
  {
    String str = this.jsPluginEngine.appBrandRuntime.appId;
    QLog.d("[mini] DataJsPlugin", 1, "getUserInfo appID:" + str);
    MiniAppCmdUtil.getInstance().getUserInfo(str, paramBoolean, paramString3, new DataJsPlugin.27(this, paramString2, paramJsRuntime, paramString1, paramInt));
  }
  
  /* Error */
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 806	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +50 -> 53
    //   6: ldc 150
    //   8: iconst_2
    //   9: new 398	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 808
    //   19: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc_w 810
    //   29: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_2
    //   33: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc_w 812
    //   39: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: iload 4
    //   44: invokevirtual 688	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 516	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aload_3
    //   54: ifnonnull +18 -> 72
    //   57: ldc 150
    //   59: iconst_4
    //   60: ldc_w 814
    //   63: invokestatic 611	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: ldc_w 524
    //   69: astore_2
    //   70: aload_2
    //   71: areturn
    //   72: aconst_null
    //   73: astore 22
    //   75: aload_0
    //   76: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   79: ifnull +12 -> 91
    //   82: aload_0
    //   83: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   86: invokevirtual 558	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   89: astore 22
    //   91: aload 22
    //   93: ifnull +26 -> 119
    //   96: new 398	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   103: aload_1
    //   104: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload 22
    //   109: invokevirtual 819	java/lang/Object:hashCode	()I
    //   112: invokevirtual 688	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   115: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: pop
    //   119: ldc 35
    //   121: aload_1
    //   122: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   125: ifne +12 -> 137
    //   128: ldc 38
    //   130: aload_1
    //   131: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   134: ifeq +1149 -> 1283
    //   137: aload 22
    //   139: ifnull +1112 -> 1251
    //   142: aload_0
    //   143: getfield 823	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isGameRuntime	Z
    //   146: ifeq +12 -> 158
    //   149: aload_0
    //   150: aload_1
    //   151: aload_3
    //   152: iload 4
    //   154: invokespecial 825	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:handleGameSystemInfo	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;I)Ljava/lang/String;
    //   157: areturn
    //   158: getstatic 830	android/os/Build$VERSION:SDK_INT	I
    //   161: bipush 17
    //   163: if_icmplt +800 -> 963
    //   166: new 832	android/util/DisplayMetrics
    //   169: dup
    //   170: invokespecial 833	android/util/DisplayMetrics:<init>	()V
    //   173: astore_2
    //   174: aload 22
    //   176: ldc_w 835
    //   179: invokevirtual 839	android/app/Activity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   182: checkcast 841	android/view/WindowManager
    //   185: invokeinterface 845 1 0
    //   190: aload_2
    //   191: invokevirtual 851	android/view/Display:getRealMetrics	(Landroid/util/DisplayMetrics;)V
    //   194: getstatic 856	android/os/Build:BRAND	Ljava/lang/String;
    //   197: ldc_w 858
    //   200: invokevirtual 861	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   203: ifeq +772 -> 975
    //   206: aload 22
    //   208: invokestatic 867	com/tencent/mobileqq/mini/util/DisplayUtil:checkNavigationBarShow	(Landroid/content/Context;)Z
    //   211: istore 15
    //   213: aload_2
    //   214: getfield 871	android/util/DisplayMetrics:density	F
    //   217: f2d
    //   218: dstore 5
    //   220: aload_2
    //   221: getfield 874	android/util/DisplayMetrics:widthPixels	I
    //   224: i2d
    //   225: dload 5
    //   227: ddiv
    //   228: invokestatic 880	java/lang/Math:round	(D)J
    //   231: l2f
    //   232: ldc_w 881
    //   235: fadd
    //   236: f2i
    //   237: istore 9
    //   239: aload_2
    //   240: getfield 884	android/util/DisplayMetrics:heightPixels	I
    //   243: i2d
    //   244: dload 5
    //   246: ddiv
    //   247: invokestatic 880	java/lang/Math:round	(D)J
    //   250: l2f
    //   251: ldc_w 881
    //   254: fadd
    //   255: f2i
    //   256: istore 8
    //   258: iload 8
    //   260: istore 7
    //   262: iload 15
    //   264: ifeq +23 -> 287
    //   267: iload 8
    //   269: aload_0
    //   270: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   273: invokevirtual 558	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   276: invokestatic 888	com/tencent/mobileqq/mini/util/DisplayUtil:getNavigationBarHeight	(Landroid/content/Context;)I
    //   279: i2d
    //   280: dload 5
    //   282: ddiv
    //   283: d2i
    //   284: isub
    //   285: istore 7
    //   287: aload 22
    //   289: invokestatic 893	com/tencent/widget/immersive/ImmersiveUtils:getStatusBarHeight	(Landroid/content/Context;)I
    //   292: i2f
    //   293: invokestatic 896	java/lang/Math:round	(F)I
    //   296: i2d
    //   297: dload 5
    //   299: ddiv
    //   300: d2i
    //   301: istore 10
    //   303: ldc_w 897
    //   306: invokestatic 902	aqnm:dpToPx	(F)I
    //   309: i2d
    //   310: dload 5
    //   312: ddiv
    //   313: ldc2_w 903
    //   316: dadd
    //   317: d2i
    //   318: istore 11
    //   320: ldc_w 905
    //   323: invokestatic 902	aqnm:dpToPx	(F)I
    //   326: i2d
    //   327: dload 5
    //   329: ddiv
    //   330: ldc2_w 903
    //   333: dadd
    //   334: d2i
    //   335: istore 8
    //   337: aconst_null
    //   338: astore 20
    //   340: aload_0
    //   341: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   344: ifnull +665 -> 1009
    //   347: aload_0
    //   348: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   351: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   354: ifnull +655 -> 1009
    //   357: aload_0
    //   358: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   361: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   364: invokevirtual 909	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getCurPage	()Lcom/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage;
    //   367: ifnull +642 -> 1009
    //   370: aload_0
    //   371: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   374: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   377: invokevirtual 909	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getCurPage	()Lcom/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage;
    //   380: invokevirtual 914	com/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage:getUrl	()Ljava/lang/String;
    //   383: ifnull +626 -> 1009
    //   386: aload_0
    //   387: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   390: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   393: invokevirtual 909	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getCurPage	()Lcom/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage;
    //   396: invokevirtual 914	com/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage:getUrl	()Ljava/lang/String;
    //   399: astore 20
    //   401: aload 20
    //   403: astore_2
    //   404: aload 20
    //   406: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   409: ifne +10013 -> 10422
    //   412: aload_0
    //   413: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   416: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   419: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   422: invokevirtual 918	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   425: aload 20
    //   427: invokevirtual 924	com/tencent/mobileqq/mini/apkg/AppConfigInfo:getPageInfo	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/apkg/PageInfo;
    //   430: getfield 930	com/tencent/mobileqq/mini/apkg/PageInfo:windowInfo	Lcom/tencent/mobileqq/mini/apkg/WindowInfo;
    //   433: getfield 936	com/tencent/mobileqq/mini/apkg/WindowInfo:navigationBarInfo	Lcom/tencent/mobileqq/mini/apkg/NavigationBarInfo;
    //   436: getfield 941	com/tencent/mobileqq/mini/apkg/NavigationBarInfo:style	Ljava/lang/String;
    //   439: astore 21
    //   441: aload 20
    //   443: astore_2
    //   444: aload_0
    //   445: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   448: ifnull +9968 -> 10416
    //   451: aload_0
    //   452: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   455: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   458: ifnull +9958 -> 10416
    //   461: aload_0
    //   462: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   465: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   468: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   471: ifnull +9945 -> 10416
    //   474: aload_0
    //   475: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   478: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   481: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   484: invokevirtual 918	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   487: ifnull +9929 -> 10416
    //   490: aload_0
    //   491: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   494: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   497: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   500: invokevirtual 918	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   503: getfield 945	com/tencent/mobileqq/mini/apkg/AppConfigInfo:tabBarInfo	Lcom/tencent/mobileqq/mini/apkg/TabBarInfo;
    //   506: ifnull +712 -> 1218
    //   509: aload_0
    //   510: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   513: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   516: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   519: aload_2
    //   520: invokevirtual 948	com/tencent/mobileqq/mini/apkg/ApkgInfo:isTabBarPage	(Ljava/lang/String;)Z
    //   523: ifeq +695 -> 1218
    //   526: aload_0
    //   527: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   530: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   533: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   536: invokevirtual 918	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   539: getfield 945	com/tencent/mobileqq/mini/apkg/AppConfigInfo:tabBarInfo	Lcom/tencent/mobileqq/mini/apkg/TabBarInfo;
    //   542: invokevirtual 953	com/tencent/mobileqq/mini/apkg/TabBarInfo:isShow	()Z
    //   545: ifeq +673 -> 1218
    //   548: iconst_1
    //   549: istore 16
    //   551: ldc_w 955
    //   554: aload 21
    //   556: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   559: ifeq +671 -> 1230
    //   562: iload 16
    //   564: ifeq +660 -> 1224
    //   567: iload 7
    //   569: iload 10
    //   571: isub
    //   572: iload 11
    //   574: isub
    //   575: iload 8
    //   577: isub
    //   578: istore 8
    //   580: invokestatic 958	com/tencent/qphone/base/util/QLog:isDebugVersion	()Z
    //   583: ifeq +63 -> 646
    //   586: ldc 150
    //   588: iconst_1
    //   589: new 398	java/lang/StringBuilder
    //   592: dup
    //   593: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   596: ldc_w 960
    //   599: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: iload 8
    //   604: invokevirtual 688	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   607: ldc_w 962
    //   610: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: aload 21
    //   615: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: ldc_w 964
    //   621: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: iload 16
    //   626: invokevirtual 967	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   629: ldc_w 969
    //   632: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: iload 15
    //   637: invokevirtual 967	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   640: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   643: invokestatic 611	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   646: invokestatic 975	com/tencent/mobileqq/mini/app/AppLoaderFactory:getAppLoaderManager	()Lcom/tencent/mobileqq/mini/app/BaseAppLoaderManager;
    //   649: invokeinterface 981 1 0
    //   654: getfield 986	com/tencent/mobileqq/mini/sdk/BaseLibInfo:baseLibVersion	Ljava/lang/String;
    //   657: astore_2
    //   658: new 348	org/json/JSONObject
    //   661: dup
    //   662: invokespecial 987	org/json/JSONObject:<init>	()V
    //   665: astore 20
    //   667: aload 20
    //   669: ldc_w 989
    //   672: getstatic 856	android/os/Build:BRAND	Ljava/lang/String;
    //   675: invokevirtual 993	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   678: pop
    //   679: aload 20
    //   681: ldc_w 995
    //   684: getstatic 998	android/os/Build:MODEL	Ljava/lang/String;
    //   687: invokevirtual 993	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   690: pop
    //   691: aload 20
    //   693: ldc_w 1000
    //   696: dload 5
    //   698: invokevirtual 1003	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   701: pop
    //   702: aload 20
    //   704: ldc_w 1005
    //   707: iload 9
    //   709: invokevirtual 1008	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   712: pop
    //   713: aload 20
    //   715: ldc_w 1010
    //   718: iload 7
    //   720: invokevirtual 1008	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   723: pop
    //   724: aload 20
    //   726: ldc_w 1012
    //   729: iload 9
    //   731: invokevirtual 1008	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   734: pop
    //   735: aload 20
    //   737: ldc_w 1014
    //   740: iload 8
    //   742: invokevirtual 1008	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   745: pop
    //   746: aload 20
    //   748: ldc_w 1016
    //   751: iload 10
    //   753: invokevirtual 1008	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   756: pop
    //   757: aload 20
    //   759: ldc_w 1018
    //   762: ldc_w 1020
    //   765: invokevirtual 993	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   768: pop
    //   769: aload 20
    //   771: ldc_w 1022
    //   774: invokestatic 1027	aqgz:getQQVersion	()Ljava/lang/String;
    //   777: invokevirtual 993	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   780: pop
    //   781: aload 20
    //   783: ldc_w 1029
    //   786: new 398	java/lang/StringBuilder
    //   789: dup
    //   790: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   793: ldc_w 1031
    //   796: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: getstatic 1034	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   802: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   808: invokevirtual 993	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   811: pop
    //   812: aload 20
    //   814: ldc_w 1036
    //   817: ldc_w 1038
    //   820: invokevirtual 993	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   823: pop
    //   824: aload 20
    //   826: ldc_w 1040
    //   829: bipush 16
    //   831: invokevirtual 1008	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   834: pop
    //   835: aload 20
    //   837: ldc_w 1042
    //   840: aload_2
    //   841: invokevirtual 993	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   844: pop
    //   845: aload 20
    //   847: ldc_w 1044
    //   850: ldc 124
    //   852: invokevirtual 993	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   855: pop
    //   856: aload 20
    //   858: ldc_w 1046
    //   861: aload 22
    //   863: invokestatic 1050	com/tencent/mobileqq/mini/util/DisplayUtil:getDisplayCutoutSafeArea	(Landroid/app/Activity;)Lorg/json/JSONObject;
    //   866: invokevirtual 993	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   869: pop
    //   870: aload_1
    //   871: aload 20
    //   873: invokestatic 1053	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   876: invokevirtual 607	org/json/JSONObject:toString	()Ljava/lang/String;
    //   879: astore 20
    //   881: aload 20
    //   883: astore_2
    //   884: ldc 35
    //   886: aload_1
    //   887: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   890: ifeq -820 -> 70
    //   893: aload_3
    //   894: iload 4
    //   896: aload 20
    //   898: invokeinterface 622 3 0
    //   903: aload 20
    //   905: areturn
    //   906: astore_2
    //   907: ldc 150
    //   909: iconst_1
    //   910: new 398	java/lang/StringBuilder
    //   913: dup
    //   914: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   917: ldc_w 1055
    //   920: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   923: new 245	java/lang/Throwable
    //   926: dup
    //   927: aload_2
    //   928: invokespecial 1058	java/lang/Throwable:<init>	(Ljava/lang/Throwable;)V
    //   931: invokevirtual 1061	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   934: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   937: invokestatic 611	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   940: aload_1
    //   941: aconst_null
    //   942: invokestatic 617	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   945: astore_1
    //   946: aload_3
    //   947: iload 4
    //   949: aload_1
    //   950: invokevirtual 607	org/json/JSONObject:toString	()Ljava/lang/String;
    //   953: invokeinterface 622 3 0
    //   958: aload_1
    //   959: invokevirtual 607	org/json/JSONObject:toString	()Ljava/lang/String;
    //   962: areturn
    //   963: aload 22
    //   965: invokevirtual 1065	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   968: invokevirtual 1071	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   971: astore_2
    //   972: goto -778 -> 194
    //   975: aload 22
    //   977: invokestatic 1074	com/tencent/mobileqq/mini/util/DisplayUtil:hasNavBar	(Landroid/content/Context;)Z
    //   980: ifeq +11 -> 991
    //   983: aload 22
    //   985: invokestatic 1078	com/tencent/mobileqq/mini/util/DisplayUtil:isNavigationBarExist	(Landroid/app/Activity;)Z
    //   988: ifne +9 -> 997
    //   991: invokestatic 1081	com/tencent/mobileqq/mini/util/DisplayUtil:isFlymeOS7NavBarShow	()Z
    //   994: ifeq +9 -> 1003
    //   997: iconst_1
    //   998: istore 15
    //   1000: goto -787 -> 213
    //   1003: iconst_0
    //   1004: istore 15
    //   1006: goto -793 -> 213
    //   1009: aload 20
    //   1011: astore_2
    //   1012: aload_0
    //   1013: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1016: ifnull +9406 -> 10422
    //   1019: aload 20
    //   1021: astore_2
    //   1022: aload_0
    //   1023: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1026: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1029: ifnull +9393 -> 10422
    //   1032: aload 20
    //   1034: astore_2
    //   1035: aload_0
    //   1036: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1039: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1042: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1045: ifnull +9377 -> 10422
    //   1048: aconst_null
    //   1049: astore 20
    //   1051: aload 20
    //   1053: astore_2
    //   1054: aload_0
    //   1055: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1058: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1061: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1064: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   1067: ifnull +45 -> 1112
    //   1070: aload 20
    //   1072: astore_2
    //   1073: aload_0
    //   1074: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1077: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1080: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1083: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   1086: getfield 528	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   1089: ifnull +23 -> 1112
    //   1092: aload_0
    //   1093: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1096: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1099: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1102: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   1105: getfield 528	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   1108: getfield 533	com/tencent/mobileqq/mini/sdk/LaunchParam:entryPath	Ljava/lang/String;
    //   1111: astore_2
    //   1112: aconst_null
    //   1113: astore 20
    //   1115: aload_0
    //   1116: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1119: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1122: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1125: getfield 1085	com/tencent/mobileqq/mini/apkg/ApkgInfo:mAppConfigInfo	Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   1128: ifnull +21 -> 1149
    //   1131: aload_0
    //   1132: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1135: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1138: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1141: getfield 1085	com/tencent/mobileqq/mini/apkg/ApkgInfo:mAppConfigInfo	Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   1144: getfield 1088	com/tencent/mobileqq/mini/apkg/AppConfigInfo:entryPagePath	Ljava/lang/String;
    //   1147: astore 20
    //   1149: aload_0
    //   1150: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1153: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1156: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1159: aload_2
    //   1160: invokevirtual 1091	com/tencent/mobileqq/mini/apkg/ApkgInfo:isUrlFileExist	(Ljava/lang/String;)Z
    //   1163: ifne +49 -> 1212
    //   1166: aload 20
    //   1168: astore_2
    //   1169: aload 20
    //   1171: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1174: ifne +9248 -> 10422
    //   1177: aload_0
    //   1178: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1181: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1184: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1187: invokevirtual 918	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   1190: aload 20
    //   1192: invokevirtual 924	com/tencent/mobileqq/mini/apkg/AppConfigInfo:getPageInfo	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/apkg/PageInfo;
    //   1195: getfield 930	com/tencent/mobileqq/mini/apkg/PageInfo:windowInfo	Lcom/tencent/mobileqq/mini/apkg/WindowInfo;
    //   1198: getfield 936	com/tencent/mobileqq/mini/apkg/WindowInfo:navigationBarInfo	Lcom/tencent/mobileqq/mini/apkg/NavigationBarInfo;
    //   1201: getfield 941	com/tencent/mobileqq/mini/apkg/NavigationBarInfo:style	Ljava/lang/String;
    //   1204: astore 21
    //   1206: aload 20
    //   1208: astore_2
    //   1209: goto -765 -> 444
    //   1212: aload_2
    //   1213: astore 20
    //   1215: goto -49 -> 1166
    //   1218: iconst_0
    //   1219: istore 16
    //   1221: goto -670 -> 551
    //   1224: iconst_0
    //   1225: istore 8
    //   1227: goto -660 -> 567
    //   1230: iload 16
    //   1232: ifeq +13 -> 1245
    //   1235: iload 7
    //   1237: iload 8
    //   1239: isub
    //   1240: istore 8
    //   1242: goto -662 -> 580
    //   1245: iconst_0
    //   1246: istore 8
    //   1248: goto -13 -> 1235
    //   1251: ldc 150
    //   1253: iconst_1
    //   1254: ldc_w 1093
    //   1257: invokestatic 611	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1260: aload_1
    //   1261: aconst_null
    //   1262: invokestatic 617	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1265: astore_1
    //   1266: aload_3
    //   1267: iload 4
    //   1269: aload_1
    //   1270: invokevirtual 607	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1273: invokeinterface 622 3 0
    //   1278: aload_1
    //   1279: invokevirtual 607	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1282: areturn
    //   1283: ldc_w 1095
    //   1286: aload_1
    //   1287: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1290: ifeq +135 -> 1425
    //   1293: iconst_0
    //   1294: istore 8
    //   1296: iload 8
    //   1298: istore 7
    //   1300: aload_2
    //   1301: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1304: ifne +70 -> 1374
    //   1307: new 348	org/json/JSONObject
    //   1310: dup
    //   1311: aload_2
    //   1312: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1315: ldc_w 1097
    //   1318: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1321: astore_1
    //   1322: iload 8
    //   1324: istore 7
    //   1326: aload_1
    //   1327: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1330: ifne +44 -> 1374
    //   1333: iconst_1
    //   1334: istore 7
    //   1336: aload 22
    //   1338: new 705	android/content/Intent
    //   1341: dup
    //   1342: ldc_w 1099
    //   1345: new 398	java/lang/StringBuilder
    //   1348: dup
    //   1349: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   1352: ldc_w 1101
    //   1355: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1358: aload_1
    //   1359: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1362: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1365: invokestatic 1107	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   1368: invokespecial 1110	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   1371: invokevirtual 1114	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   1374: iload 7
    //   1376: ifeq +38 -> 1414
    //   1379: ldc_w 1095
    //   1382: aconst_null
    //   1383: invokestatic 1053	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1386: astore_1
    //   1387: aload_1
    //   1388: ifnull +15 -> 1403
    //   1391: aload_3
    //   1392: iload 4
    //   1394: aload_1
    //   1395: invokevirtual 607	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1398: invokeinterface 622 3 0
    //   1403: ldc_w 524
    //   1406: areturn
    //   1407: astore_1
    //   1408: iconst_0
    //   1409: istore 7
    //   1411: goto -37 -> 1374
    //   1414: ldc_w 1095
    //   1417: aconst_null
    //   1418: invokestatic 617	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1421: astore_1
    //   1422: goto -35 -> 1387
    //   1425: ldc_w 1116
    //   1428: aload_1
    //   1429: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1432: ifeq +190 -> 1622
    //   1435: ldc 150
    //   1437: iconst_2
    //   1438: iconst_2
    //   1439: anewarray 816	java/lang/Object
    //   1442: dup
    //   1443: iconst_0
    //   1444: ldc_w 1117
    //   1447: aastore
    //   1448: dup
    //   1449: iconst_1
    //   1450: aload_2
    //   1451: aastore
    //   1452: invokestatic 1120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1455: new 348	org/json/JSONObject
    //   1458: dup
    //   1459: aload_2
    //   1460: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1463: astore_2
    //   1464: aload_2
    //   1465: ldc_w 479
    //   1468: invokevirtual 483	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1471: astore 20
    //   1473: aload 20
    //   1475: ldc_w 1122
    //   1478: ldc_w 524
    //   1481: invokevirtual 1125	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1484: astore 21
    //   1486: aload 20
    //   1488: ldc_w 1127
    //   1491: iconst_1
    //   1492: invokevirtual 1131	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   1495: pop
    //   1496: ldc_w 1133
    //   1499: aload 21
    //   1501: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1504: ifeq +49 -> 1553
    //   1507: invokestatic 669	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   1510: aload_0
    //   1511: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1514: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1517: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   1520: new 1135	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$2
    //   1523: dup
    //   1524: aload_0
    //   1525: aload_3
    //   1526: aload_1
    //   1527: iload 4
    //   1529: aload_2
    //   1530: invokespecial 1138	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$2:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;ILorg/json/JSONObject;)V
    //   1533: invokevirtual 1141	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getPhoneNumber	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   1536: goto -133 -> 1403
    //   1539: astore_1
    //   1540: ldc 150
    //   1542: iconst_2
    //   1543: ldc_w 1117
    //   1546: aload_1
    //   1547: invokestatic 301	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1550: goto -147 -> 1403
    //   1553: ldc 150
    //   1555: iconst_1
    //   1556: new 398	java/lang/StringBuilder
    //   1559: dup
    //   1560: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   1563: ldc_w 1143
    //   1566: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1569: aload 21
    //   1571: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1574: ldc_w 1145
    //   1577: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1580: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1583: invokestatic 611	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1586: aload_0
    //   1587: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1590: aload_3
    //   1591: aload_1
    //   1592: aconst_null
    //   1593: new 398	java/lang/StringBuilder
    //   1596: dup
    //   1597: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   1600: aload 21
    //   1602: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1605: ldc_w 1145
    //   1608: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1611: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1614: iload 4
    //   1616: invokevirtual 638	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   1619: goto -216 -> 1403
    //   1622: ldc 50
    //   1624: aload_1
    //   1625: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1628: ifeq +86 -> 1714
    //   1631: ldc 150
    //   1633: iconst_2
    //   1634: new 398	java/lang/StringBuilder
    //   1637: dup
    //   1638: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   1641: ldc_w 1147
    //   1644: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1647: iload 4
    //   1649: invokevirtual 688	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1652: ldc_w 1149
    //   1655: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1658: aload_0
    //   1659: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1662: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1665: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1668: getfield 1085	com/tencent/mobileqq/mini/apkg/ApkgInfo:mAppConfigInfo	Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   1671: getfield 1152	com/tencent/mobileqq/mini/apkg/AppConfigInfo:PackageToolVersion	Ljava/lang/String;
    //   1674: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1677: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1680: invokestatic 516	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1683: invokestatic 669	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   1686: aload_0
    //   1687: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1690: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1693: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   1696: new 1154	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$3
    //   1699: dup
    //   1700: aload_0
    //   1701: aload_3
    //   1702: aload_1
    //   1703: iload 4
    //   1705: invokespecial 1155	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$3:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   1708: invokevirtual 1158	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getLoginCode	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   1711: goto -308 -> 1403
    //   1714: ldc_w 1160
    //   1717: aload_1
    //   1718: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1721: ifeq +1286 -> 3007
    //   1724: new 348	org/json/JSONObject
    //   1727: dup
    //   1728: invokespecial 987	org/json/JSONObject:<init>	()V
    //   1731: pop
    //   1732: new 348	org/json/JSONObject
    //   1735: dup
    //   1736: aload_2
    //   1737: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1740: astore 20
    //   1742: aload 20
    //   1744: ldc_w 479
    //   1747: invokevirtual 483	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1750: astore 22
    //   1752: aload 22
    //   1754: ldc_w 1122
    //   1757: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1760: astore 21
    //   1762: ldc_w 1162
    //   1765: aload 21
    //   1767: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1770: ifne +14 -> 1784
    //   1773: ldc_w 1164
    //   1776: aload 21
    //   1778: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1781: ifeq +101 -> 1882
    //   1784: aload 22
    //   1786: ldc_w 1127
    //   1789: invokevirtual 1166	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1792: istore 15
    //   1794: aload 22
    //   1796: ldc_w 1168
    //   1799: aconst_null
    //   1800: invokevirtual 1125	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1803: astore 20
    //   1805: aload 22
    //   1807: ldc_w 479
    //   1810: invokevirtual 483	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1813: astore_2
    //   1814: aload_2
    //   1815: ifnull +49 -> 1864
    //   1818: aload_2
    //   1819: ldc_w 1168
    //   1822: ldc_w 1170
    //   1825: invokevirtual 1125	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1828: astore_2
    //   1829: aload_0
    //   1830: aload_3
    //   1831: aload_1
    //   1832: aload 21
    //   1834: iload 4
    //   1836: iload 15
    //   1838: aload_2
    //   1839: invokevirtual 1172	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getUserInfo	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;)V
    //   1842: goto -439 -> 1403
    //   1845: astore_1
    //   1846: ldc 150
    //   1848: iconst_1
    //   1849: aload_1
    //   1850: iconst_0
    //   1851: anewarray 816	java/lang/Object
    //   1854: invokestatic 1175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1857: aload_1
    //   1858: invokevirtual 1176	java/lang/Exception:printStackTrace	()V
    //   1861: goto -458 -> 1403
    //   1864: aload 20
    //   1866: astore_2
    //   1867: aload 20
    //   1869: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1872: ifeq -43 -> 1829
    //   1875: ldc_w 1170
    //   1878: astore_2
    //   1879: goto -50 -> 1829
    //   1882: ldc_w 1178
    //   1885: aload 21
    //   1887: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1890: ifeq +47 -> 1937
    //   1893: new 1180	Wallet/IsUinFocusMpIdReq
    //   1896: dup
    //   1897: invokestatic 471	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1900: invokevirtual 1184	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   1903: invokevirtual 1189	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   1906: aload_0
    //   1907: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1910: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1913: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   1916: invokespecial 1191	Wallet/IsUinFocusMpIdReq:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1919: new 1193	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$4
    //   1922: dup
    //   1923: aload_0
    //   1924: aload_3
    //   1925: aload_1
    //   1926: iload 4
    //   1928: invokespecial 1194	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$4:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   1931: invokestatic 1199	zyb:a	(Lcom/qq/taf/jce/JceStruct;Lmqq/observer/BusinessObserver;)V
    //   1934: goto -531 -> 1403
    //   1937: ldc_w 1201
    //   1940: aload 21
    //   1942: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1945: ifeq +141 -> 2086
    //   1948: aload 20
    //   1950: ldc_w 1203
    //   1953: invokevirtual 483	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1956: ldc_w 1205
    //   1959: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1962: astore_2
    //   1963: ldc 112
    //   1965: aload_0
    //   1966: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1969: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1972: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   1975: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1978: ifeq +75 -> 2053
    //   1981: ldc 150
    //   1983: iconst_1
    //   1984: ldc_w 1207
    //   1987: invokestatic 516	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1990: new 348	org/json/JSONObject
    //   1993: dup
    //   1994: invokespecial 987	org/json/JSONObject:<init>	()V
    //   1997: astore_2
    //   1998: new 348	org/json/JSONObject
    //   2001: dup
    //   2002: invokespecial 987	org/json/JSONObject:<init>	()V
    //   2005: astore 20
    //   2007: aload 20
    //   2009: ldc_w 479
    //   2012: ldc 156
    //   2014: invokevirtual 993	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2017: pop
    //   2018: aload_2
    //   2019: ldc_w 1209
    //   2022: aload 20
    //   2024: invokevirtual 993	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2027: pop
    //   2028: aload_0
    //   2029: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2032: aload_3
    //   2033: aload_1
    //   2034: aload_2
    //   2035: iload 4
    //   2037: invokevirtual 1212	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   2040: goto -637 -> 1403
    //   2043: astore 20
    //   2045: aload 20
    //   2047: invokevirtual 1213	org/json/JSONException:printStackTrace	()V
    //   2050: goto -22 -> 2028
    //   2053: invokestatic 669	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   2056: aload_0
    //   2057: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2060: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2063: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   2066: aload_2
    //   2067: aconst_null
    //   2068: new 1215	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$5
    //   2071: dup
    //   2072: aload_0
    //   2073: aload_3
    //   2074: aload_1
    //   2075: iload 4
    //   2077: invokespecial 1216	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$5:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   2080: invokevirtual 1219	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:checkNavigateRight	(Ljava/lang/String;Ljava/lang/String;LNS_COMM/COMM$StCommonExt;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   2083: goto -680 -> 1403
    //   2086: ldc_w 1221
    //   2089: aload 21
    //   2091: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2094: ifeq +405 -> 2499
    //   2097: aload 22
    //   2099: ldc_w 479
    //   2102: invokevirtual 483	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2105: ldc_w 485
    //   2108: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2111: astore 26
    //   2113: iconst_2
    //   2114: istore 7
    //   2116: aload 22
    //   2118: ldc_w 479
    //   2121: invokevirtual 483	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2124: ldc_w 490
    //   2127: invokevirtual 494	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2130: ifeq +19 -> 2149
    //   2133: aload 22
    //   2135: ldc_w 479
    //   2138: invokevirtual 483	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2141: ldc_w 490
    //   2144: invokevirtual 498	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2147: istore 7
    //   2149: aload_0
    //   2150: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2153: getfield 255	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   2156: invokevirtual 505	com/tencent/mobileqq/app/BaseActivity:getCurrentAccountUin	()Ljava/lang/String;
    //   2159: invokestatic 508	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   2162: invokevirtual 512	java/lang/Long:longValue	()J
    //   2165: lstore 18
    //   2167: aconst_null
    //   2168: astore_2
    //   2169: aload_0
    //   2170: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2173: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2176: ifnull +14 -> 2190
    //   2179: aload_0
    //   2180: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2183: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2186: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   2189: astore_2
    //   2190: ldc 150
    //   2192: iconst_2
    //   2193: new 398	java/lang/StringBuilder
    //   2196: dup
    //   2197: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   2200: ldc_w 1223
    //   2203: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2206: aload_2
    //   2207: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2210: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2213: invokestatic 516	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2216: aload_2
    //   2217: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2220: ifne -817 -> 1403
    //   2223: iload 7
    //   2225: invokestatic 522	com/tencent/mobileqq/mini/util/AdUtils:getSpAdGdtCookie	(I)Ljava/lang/String;
    //   2228: astore 27
    //   2230: aload_0
    //   2231: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2234: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2237: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   2240: astore 28
    //   2242: ldc_w 524
    //   2245: astore 21
    //   2247: ldc_w 524
    //   2250: astore 23
    //   2252: ldc_w 524
    //   2255: astore 25
    //   2257: ldc_w 524
    //   2260: astore 24
    //   2262: aload 21
    //   2264: astore 20
    //   2266: aload 28
    //   2268: ifnull +61 -> 2329
    //   2271: aload 21
    //   2273: astore 20
    //   2275: aload 28
    //   2277: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2280: ifnull +49 -> 2329
    //   2283: aload 21
    //   2285: astore 20
    //   2287: aload 28
    //   2289: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2292: getfield 528	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2295: ifnull +34 -> 2329
    //   2298: aload 21
    //   2300: astore 20
    //   2302: aload 28
    //   2304: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2307: getfield 528	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2310: getfield 533	com/tencent/mobileqq/mini/sdk/LaunchParam:entryPath	Ljava/lang/String;
    //   2313: ifnull +16 -> 2329
    //   2316: aload 28
    //   2318: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2321: getfield 528	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2324: getfield 533	com/tencent/mobileqq/mini/sdk/LaunchParam:entryPath	Ljava/lang/String;
    //   2327: astore 20
    //   2329: aload 23
    //   2331: astore 22
    //   2333: aload 25
    //   2335: astore 21
    //   2337: aload 28
    //   2339: ifnull +67 -> 2406
    //   2342: aload 23
    //   2344: astore 22
    //   2346: aload 25
    //   2348: astore 21
    //   2350: aload 28
    //   2352: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2355: ifnull +51 -> 2406
    //   2358: aload 23
    //   2360: astore 22
    //   2362: aload 25
    //   2364: astore 21
    //   2366: aload 28
    //   2368: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2371: getfield 528	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2374: ifnull +32 -> 2406
    //   2377: aload 28
    //   2379: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2382: getfield 528	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2385: getfield 536	com/tencent/mobileqq/mini/sdk/LaunchParam:reportData	Ljava/lang/String;
    //   2388: astore 22
    //   2390: aload 28
    //   2392: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2395: getfield 528	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2398: getfield 539	com/tencent/mobileqq/mini/sdk/LaunchParam:scene	I
    //   2401: invokestatic 541	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2404: astore 21
    //   2406: aload 24
    //   2408: astore 23
    //   2410: aload 28
    //   2412: ifnull +43 -> 2455
    //   2415: aload 24
    //   2417: astore 23
    //   2419: aload 28
    //   2421: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2424: ifnull +31 -> 2455
    //   2427: aload 24
    //   2429: astore 23
    //   2431: aload 28
    //   2433: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2436: getfield 280	com/tencent/mobileqq/mini/apkg/MiniAppConfig:config	Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   2439: ifnull +16 -> 2455
    //   2442: aload 28
    //   2444: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2447: getfield 280	com/tencent/mobileqq/mini/apkg/MiniAppConfig:config	Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   2450: getfield 544	com/tencent/mobileqq/mini/apkg/MiniAppInfo:via	Ljava/lang/String;
    //   2453: astore 23
    //   2455: aload_0
    //   2456: aload_0
    //   2457: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2460: getfield 255	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   2463: lload 18
    //   2465: aload 26
    //   2467: aload_2
    //   2468: bipush 53
    //   2470: iload 7
    //   2472: iconst_0
    //   2473: aload 27
    //   2475: aload 20
    //   2477: aload 22
    //   2479: aload 21
    //   2481: aload 23
    //   2483: iconst_1
    //   2484: invokestatic 548	com/tencent/mobileqq/mini/util/AdUtils:createAdRequest	(Landroid/content/Context;JLjava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)LNS_MINI_AD/MiniAppAd$StGetAdReq;
    //   2487: aload_3
    //   2488: aload_1
    //   2489: iload 4
    //   2491: iload 7
    //   2493: invokespecial 552	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:sendAdRequest	(LNS_MINI_AD/MiniAppAd$StGetAdReq;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;II)V
    //   2496: goto -1093 -> 1403
    //   2499: ldc_w 1225
    //   2502: aload 21
    //   2504: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2507: ifeq +360 -> 2867
    //   2510: new 348	org/json/JSONObject
    //   2513: dup
    //   2514: aload_2
    //   2515: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2518: astore 22
    //   2520: ldc_w 524
    //   2523: astore_2
    //   2524: new 348	org/json/JSONObject
    //   2527: dup
    //   2528: invokespecial 987	org/json/JSONObject:<init>	()V
    //   2531: astore 21
    //   2533: aload_2
    //   2534: astore 20
    //   2536: aload 22
    //   2538: ldc_w 479
    //   2541: invokevirtual 494	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2544: ifeq +7866 -> 10410
    //   2547: aload 22
    //   2549: ldc_w 479
    //   2552: invokevirtual 483	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2555: astore 22
    //   2557: aload_2
    //   2558: astore 20
    //   2560: aload 22
    //   2562: ifnull +7848 -> 10410
    //   2565: aload_2
    //   2566: astore 20
    //   2568: aload 22
    //   2570: ldc_w 479
    //   2573: invokevirtual 494	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2576: ifeq +7834 -> 10410
    //   2579: aload 22
    //   2581: ldc_w 479
    //   2584: invokevirtual 483	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2587: astore 22
    //   2589: aload_2
    //   2590: astore 20
    //   2592: aload 22
    //   2594: ifnull +7816 -> 10410
    //   2597: aload 22
    //   2599: ldc_w 381
    //   2602: invokevirtual 494	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2605: ifeq +12 -> 2617
    //   2608: aload 22
    //   2610: ldc_w 381
    //   2613: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2616: astore_2
    //   2617: aload_2
    //   2618: astore 20
    //   2620: aload 22
    //   2622: ldc_w 1227
    //   2625: invokevirtual 494	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2628: ifeq +7782 -> 10410
    //   2631: aload 22
    //   2633: ldc_w 1227
    //   2636: invokevirtual 483	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2639: astore 21
    //   2641: aload_2
    //   2642: astore 20
    //   2644: aload 21
    //   2646: astore_2
    //   2647: new 348	org/json/JSONObject
    //   2650: dup
    //   2651: aload 20
    //   2653: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2656: astore 20
    //   2658: ldc_w 383
    //   2661: new 383	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo
    //   2664: dup
    //   2665: invokespecial 384	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:<init>	()V
    //   2668: aload 20
    //   2670: invokestatic 390	tkv:pbFromJson	(Lcom/tencent/mobileqq/pb/PBField;Ljava/lang/Object;)Lcom/tencent/mobileqq/pb/PBField;
    //   2673: invokevirtual 396	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2676: checkcast 383	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo
    //   2679: astore 21
    //   2681: aload_0
    //   2682: getfield 1229	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:mGgtAppReceiver	Lcom/tencent/gdtad/aditem/GdtAppReceiver;
    //   2685: ifnonnull +45 -> 2730
    //   2688: aload_0
    //   2689: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2692: ifnull +38 -> 2730
    //   2695: aload_0
    //   2696: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2699: invokevirtual 558	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   2702: ifnull +28 -> 2730
    //   2705: aload_0
    //   2706: new 1231	com/tencent/gdtad/aditem/GdtAppReceiver
    //   2709: dup
    //   2710: invokespecial 1232	com/tencent/gdtad/aditem/GdtAppReceiver:<init>	()V
    //   2713: putfield 1229	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:mGgtAppReceiver	Lcom/tencent/gdtad/aditem/GdtAppReceiver;
    //   2716: aload_0
    //   2717: getfield 1229	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:mGgtAppReceiver	Lcom/tencent/gdtad/aditem/GdtAppReceiver;
    //   2720: aload_0
    //   2721: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2724: invokevirtual 558	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   2727: invokevirtual 1235	com/tencent/gdtad/aditem/GdtAppReceiver:register	(Landroid/content/Context;)V
    //   2730: new 1237	com/tencent/gdtad/aditem/GdtHandler$Params
    //   2733: dup
    //   2734: invokespecial 1238	com/tencent/gdtad/aditem/GdtHandler$Params:<init>	()V
    //   2737: astore 20
    //   2739: aload 20
    //   2741: bipush 11
    //   2743: putfield 1241	com/tencent/gdtad/aditem/GdtHandler$Params:processId	I
    //   2746: aload 20
    //   2748: new 1243	java/lang/ref/WeakReference
    //   2751: dup
    //   2752: aload_0
    //   2753: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2756: getfield 255	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   2759: invokespecial 1246	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   2762: putfield 1249	com/tencent/gdtad/aditem/GdtHandler$Params:activity	Ljava/lang/ref/WeakReference;
    //   2765: aload 20
    //   2767: new 1251	com/tencent/gdtad/aditem/GdtAd
    //   2770: dup
    //   2771: aload 21
    //   2773: invokespecial 1254	com/tencent/gdtad/aditem/GdtAd:<init>	(Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;)V
    //   2776: putfield 1258	com/tencent/gdtad/aditem/GdtHandler$Params:ad	Lcom/tencent/gdtad/aditem/GdtAd;
    //   2779: aload 20
    //   2781: iconst_1
    //   2782: putfield 1261	com/tencent/gdtad/aditem/GdtHandler$Params:reportForClick	Z
    //   2785: aload 20
    //   2787: iconst_1
    //   2788: putfield 1264	com/tencent/gdtad/aditem/GdtHandler$Params:aOV	Z
    //   2791: aload 20
    //   2793: new 1243	java/lang/ref/WeakReference
    //   2796: dup
    //   2797: aload_0
    //   2798: getfield 1229	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:mGgtAppReceiver	Lcom/tencent/gdtad/aditem/GdtAppReceiver;
    //   2801: invokespecial 1246	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   2804: putfield 1267	com/tencent/gdtad/aditem/GdtHandler$Params:appReceiver	Ljava/lang/ref/WeakReference;
    //   2807: aload 20
    //   2809: ldc_w 1269
    //   2812: putfield 1273	com/tencent/gdtad/aditem/GdtHandler$Params:p	Ljava/lang/Class;
    //   2815: new 718	android/os/Bundle
    //   2818: dup
    //   2819: invokespecial 719	android/os/Bundle:<init>	()V
    //   2822: astore 21
    //   2824: aload 21
    //   2826: ldc_w 1275
    //   2829: ldc 8
    //   2831: invokevirtual 1278	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2834: aload 20
    //   2836: aload 21
    //   2838: putfield 1282	com/tencent/gdtad/aditem/GdtHandler$Params:extra	Landroid/os/Bundle;
    //   2841: aload 20
    //   2843: aload_2
    //   2844: putfield 1286	com/tencent/gdtad/aditem/GdtHandler$Params:aO	Lorg/json/JSONObject;
    //   2847: aload 20
    //   2849: invokestatic 1291	com/tencent/gdtad/aditem/GdtHandler:a	(Lcom/tencent/gdtad/aditem/GdtHandler$Params;)V
    //   2852: aload_0
    //   2853: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2856: aload_3
    //   2857: aload_1
    //   2858: aconst_null
    //   2859: iload 4
    //   2861: invokevirtual 1212	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   2864: goto -1461 -> 1403
    //   2867: ldc_w 1293
    //   2870: aload 21
    //   2872: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2875: ifeq +18 -> 2893
    //   2878: aload_0
    //   2879: aload 22
    //   2881: aload_3
    //   2882: aload_1
    //   2883: iload 4
    //   2885: bipush 12
    //   2887: invokespecial 1295	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:handleAdApi	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;II)V
    //   2890: goto -1487 -> 1403
    //   2893: ldc_w 1297
    //   2896: aload 21
    //   2898: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2901: ifeq +63 -> 2964
    //   2904: aload 22
    //   2906: ldc_w 479
    //   2909: invokevirtual 483	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2912: ldc_w 1299
    //   2915: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2918: astore_2
    //   2919: aload 22
    //   2921: ldc_w 479
    //   2924: invokevirtual 483	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2927: ldc_w 1301
    //   2930: iconst_0
    //   2931: invokevirtual 1304	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2934: istore 8
    //   2936: iload 8
    //   2938: istore 7
    //   2940: iload 8
    //   2942: ifgt +8 -> 2950
    //   2945: sipush 30000
    //   2948: istore 7
    //   2950: aload_0
    //   2951: aload_2
    //   2952: iload 7
    //   2954: aload_3
    //   2955: aload_1
    //   2956: iload 4
    //   2958: invokespecial 1306	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:operateGetShareInfo	(Ljava/lang/String;ILcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   2961: goto -1558 -> 1403
    //   2964: ldc_w 1308
    //   2967: aload 21
    //   2969: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2972: ifeq -1569 -> 1403
    //   2975: invokestatic 669	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   2978: aload_0
    //   2979: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2982: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   2985: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   2988: aconst_null
    //   2989: new 1310	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$6
    //   2992: dup
    //   2993: aload_0
    //   2994: aload_3
    //   2995: aload_1
    //   2996: iload 4
    //   2998: invokespecial 1311	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$6:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   3001: invokevirtual 1315	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getUserHealthData	(Ljava/lang/String;LNS_COMM/COMM$StCommonExt;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   3004: goto -1601 -> 1403
    //   3007: ldc 59
    //   3009: aload_1
    //   3010: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3013: ifeq +34 -> 3047
    //   3016: invokestatic 669	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   3019: aload_0
    //   3020: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3023: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3026: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   3029: new 1317	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$7
    //   3032: dup
    //   3033: aload_0
    //   3034: aload_3
    //   3035: aload_1
    //   3036: iload 4
    //   3038: invokespecial 1318	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$7:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   3041: invokevirtual 1321	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:checkSession	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   3044: goto -1641 -> 1403
    //   3047: ldc 86
    //   3049: aload_1
    //   3050: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3053: ifne +12 -> 3065
    //   3056: ldc 89
    //   3058: aload_1
    //   3059: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3062: ifeq +771 -> 3833
    //   3065: aload_0
    //   3066: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3069: ifnull +752 -> 3821
    //   3072: aload_0
    //   3073: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3076: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3079: ifnull +688 -> 3767
    //   3082: iconst_m1
    //   3083: istore 9
    //   3085: aload_2
    //   3086: ifnull +23 -> 3109
    //   3089: ldc_w 1323
    //   3092: aload_2
    //   3093: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3096: ifne +13 -> 3109
    //   3099: ldc_w 1325
    //   3102: aload_2
    //   3103: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3106: ifeq +103 -> 3209
    //   3109: iconst_0
    //   3110: istore 15
    //   3112: iconst_1
    //   3113: istore 13
    //   3115: iconst_1
    //   3116: istore 12
    //   3118: iconst_1
    //   3119: istore 9
    //   3121: iconst_1
    //   3122: istore 7
    //   3124: aload_0
    //   3125: invokevirtual 1328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   3128: ifeq +412 -> 3540
    //   3131: aload_0
    //   3132: invokevirtual 1332	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   3135: astore_2
    //   3136: aload_2
    //   3137: ifnull +384 -> 3521
    //   3140: iload 13
    //   3142: iconst_1
    //   3143: if_icmpne +346 -> 3489
    //   3146: aload_2
    //   3147: iconst_1
    //   3148: putfield 1337	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQQ	Z
    //   3151: iload 12
    //   3153: iconst_1
    //   3154: if_icmpne +343 -> 3497
    //   3157: aload_2
    //   3158: iconst_1
    //   3159: putfield 1340	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQzone	Z
    //   3162: iload 9
    //   3164: iconst_1
    //   3165: if_icmpne +340 -> 3505
    //   3168: aload_2
    //   3169: iconst_1
    //   3170: putfield 1343	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatFriend	Z
    //   3173: iload 7
    //   3175: iconst_1
    //   3176: if_icmpne +337 -> 3513
    //   3179: aload_2
    //   3180: iconst_1
    //   3181: putfield 1346	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatMoment	Z
    //   3184: aload_2
    //   3185: iload 15
    //   3187: putfield 1349	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareTicket	Z
    //   3190: aload_0
    //   3191: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3194: aload_3
    //   3195: aload_1
    //   3196: aload_1
    //   3197: aconst_null
    //   3198: invokestatic 1053	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3201: iload 4
    //   3203: invokevirtual 1212	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3206: goto -1803 -> 1403
    //   3209: new 348	org/json/JSONObject
    //   3212: dup
    //   3213: aload_2
    //   3214: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3217: astore_2
    //   3218: aload_2
    //   3219: ldc_w 1350
    //   3222: iconst_0
    //   3223: invokevirtual 1131	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   3226: istore 16
    //   3228: aload_2
    //   3229: ldc_w 1352
    //   3232: invokevirtual 1355	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   3235: checkcast 359	org/json/JSONArray
    //   3238: astore_2
    //   3239: aload_2
    //   3240: ifnonnull +7190 -> 10430
    //   3243: iconst_1
    //   3244: istore 13
    //   3246: iconst_1
    //   3247: istore 12
    //   3249: iconst_1
    //   3250: istore 9
    //   3252: iconst_1
    //   3253: istore 7
    //   3255: iload 16
    //   3257: istore 15
    //   3259: goto -135 -> 3124
    //   3262: iload 10
    //   3264: aload_2
    //   3265: invokevirtual 1358	org/json/JSONArray:length	()I
    //   3268: if_icmpge +76 -> 3344
    //   3271: aload_2
    //   3272: iload 10
    //   3274: invokevirtual 1360	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   3277: astore 20
    //   3279: aload 20
    //   3281: ldc 124
    //   3283: invokevirtual 861	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3286: ifeq +6 -> 3292
    //   3289: iconst_1
    //   3290: istore 11
    //   3292: aload 20
    //   3294: ldc 127
    //   3296: invokevirtual 861	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3299: ifeq +6 -> 3305
    //   3302: iconst_1
    //   3303: istore 7
    //   3305: aload 20
    //   3307: ldc 130
    //   3309: invokevirtual 861	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3312: ifeq +6 -> 3318
    //   3315: iconst_1
    //   3316: istore 9
    //   3318: aload 20
    //   3320: ldc 133
    //   3322: invokevirtual 861	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3325: istore 15
    //   3327: iload 15
    //   3329: ifeq +6 -> 3335
    //   3332: iconst_1
    //   3333: istore 8
    //   3335: iload 10
    //   3337: iconst_1
    //   3338: iadd
    //   3339: istore 10
    //   3341: goto -79 -> 3262
    //   3344: iload 11
    //   3346: istore 10
    //   3348: iload 11
    //   3350: iconst_m1
    //   3351: if_icmpne +6 -> 3357
    //   3354: iconst_0
    //   3355: istore 10
    //   3357: iload 7
    //   3359: istore 11
    //   3361: iload 7
    //   3363: iconst_m1
    //   3364: if_icmpne +6 -> 3370
    //   3367: iconst_0
    //   3368: istore 11
    //   3370: iload 9
    //   3372: iconst_m1
    //   3373: if_icmpne +7030 -> 10403
    //   3376: iconst_0
    //   3377: istore 14
    //   3379: iload 14
    //   3381: istore 9
    //   3383: iload 8
    //   3385: istore 7
    //   3387: iload 11
    //   3389: istore 12
    //   3391: iload 10
    //   3393: istore 13
    //   3395: iload 16
    //   3397: istore 15
    //   3399: iload 8
    //   3401: iconst_m1
    //   3402: if_icmpne -278 -> 3124
    //   3405: iconst_0
    //   3406: istore 7
    //   3408: iload 14
    //   3410: istore 9
    //   3412: iload 11
    //   3414: istore 12
    //   3416: iload 10
    //   3418: istore 13
    //   3420: iload 16
    //   3422: istore 15
    //   3424: goto -300 -> 3124
    //   3427: astore_2
    //   3428: aload_2
    //   3429: invokevirtual 1213	org/json/JSONException:printStackTrace	()V
    //   3432: ldc 150
    //   3434: iconst_1
    //   3435: aload_2
    //   3436: iconst_0
    //   3437: anewarray 816	java/lang/Object
    //   3440: invokestatic 1175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3443: aload_0
    //   3444: invokevirtual 1328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   3447: ifeq +23 -> 3470
    //   3450: aload_0
    //   3451: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3454: aload_3
    //   3455: aload_1
    //   3456: aload_1
    //   3457: aconst_null
    //   3458: invokestatic 617	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3461: iload 4
    //   3463: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3466: ldc_w 524
    //   3469: areturn
    //   3470: aload_0
    //   3471: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3474: aload_3
    //   3475: aload_1
    //   3476: aload_1
    //   3477: aconst_null
    //   3478: invokestatic 617	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3481: iload 4
    //   3483: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3486: goto -20 -> 3466
    //   3489: aload_2
    //   3490: iconst_0
    //   3491: putfield 1337	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQQ	Z
    //   3494: goto -343 -> 3151
    //   3497: aload_2
    //   3498: iconst_0
    //   3499: putfield 1340	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQzone	Z
    //   3502: goto -340 -> 3162
    //   3505: aload_2
    //   3506: iconst_0
    //   3507: putfield 1343	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatFriend	Z
    //   3510: goto -337 -> 3173
    //   3513: aload_2
    //   3514: iconst_0
    //   3515: putfield 1346	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatMoment	Z
    //   3518: goto -334 -> 3184
    //   3521: aload_0
    //   3522: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3525: aload_3
    //   3526: aload_1
    //   3527: aload_1
    //   3528: aconst_null
    //   3529: invokestatic 617	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3532: iload 4
    //   3534: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3537: goto -2134 -> 1403
    //   3540: aload_0
    //   3541: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3544: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3547: invokevirtual 1364	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getContainer	()Landroid/view/View;
    //   3550: ifnull +198 -> 3748
    //   3553: aload_0
    //   3554: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3557: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3560: invokevirtual 1368	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3563: ifnull +185 -> 3748
    //   3566: iload 13
    //   3568: iconst_1
    //   3569: if_icmpne +111 -> 3680
    //   3572: aload_0
    //   3573: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3576: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3579: invokevirtual 1368	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3582: iconst_1
    //   3583: putfield 1371	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQQ	Z
    //   3586: iload 12
    //   3588: iconst_1
    //   3589: if_icmpne +108 -> 3697
    //   3592: aload_0
    //   3593: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3596: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3599: invokevirtual 1368	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3602: iconst_1
    //   3603: putfield 1372	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQzone	Z
    //   3606: iload 9
    //   3608: iconst_1
    //   3609: if_icmpne +105 -> 3714
    //   3612: aload_0
    //   3613: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3616: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3619: invokevirtual 1368	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3622: iconst_1
    //   3623: putfield 1373	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatFriend	Z
    //   3626: iload 7
    //   3628: iconst_1
    //   3629: if_icmpne +102 -> 3731
    //   3632: aload_0
    //   3633: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3636: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3639: invokevirtual 1368	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3642: iconst_1
    //   3643: putfield 1374	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatMoment	Z
    //   3646: aload_0
    //   3647: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3650: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3653: invokevirtual 1368	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3656: iload 15
    //   3658: putfield 1375	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareTicket	Z
    //   3661: aload_0
    //   3662: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3665: aload_3
    //   3666: aload_1
    //   3667: aload_1
    //   3668: aconst_null
    //   3669: invokestatic 1053	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3672: iload 4
    //   3674: invokevirtual 1212	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3677: goto -2274 -> 1403
    //   3680: aload_0
    //   3681: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3684: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3687: invokevirtual 1368	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3690: iconst_0
    //   3691: putfield 1371	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQQ	Z
    //   3694: goto -108 -> 3586
    //   3697: aload_0
    //   3698: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3701: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3704: invokevirtual 1368	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3707: iconst_0
    //   3708: putfield 1372	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQzone	Z
    //   3711: goto -105 -> 3606
    //   3714: aload_0
    //   3715: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3718: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3721: invokevirtual 1368	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3724: iconst_0
    //   3725: putfield 1373	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatFriend	Z
    //   3728: goto -102 -> 3626
    //   3731: aload_0
    //   3732: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3735: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3738: invokevirtual 1368	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   3741: iconst_0
    //   3742: putfield 1374	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatMoment	Z
    //   3745: goto -99 -> 3646
    //   3748: aload_0
    //   3749: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3752: aload_3
    //   3753: aload_1
    //   3754: aload_1
    //   3755: aconst_null
    //   3756: invokestatic 617	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3759: iload 4
    //   3761: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3764: goto -2361 -> 1403
    //   3767: ldc 150
    //   3769: iconst_1
    //   3770: ldc_w 1377
    //   3773: invokestatic 611	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3776: aload_0
    //   3777: invokevirtual 1328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   3780: ifeq +22 -> 3802
    //   3783: aload_0
    //   3784: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3787: aload_3
    //   3788: aload_1
    //   3789: aload_1
    //   3790: aconst_null
    //   3791: invokestatic 617	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3794: iload 4
    //   3796: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3799: goto -2396 -> 1403
    //   3802: aload_0
    //   3803: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3806: aload_3
    //   3807: aload_1
    //   3808: aload_1
    //   3809: aconst_null
    //   3810: invokestatic 617	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3813: iload 4
    //   3815: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3818: goto -2415 -> 1403
    //   3821: ldc 150
    //   3823: iconst_1
    //   3824: ldc_w 1379
    //   3827: invokestatic 611	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3830: goto -2427 -> 1403
    //   3833: ldc 92
    //   3835: aload_1
    //   3836: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3839: ifeq +220 -> 4059
    //   3842: new 348	org/json/JSONObject
    //   3845: dup
    //   3846: aload_2
    //   3847: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3850: astore_2
    //   3851: aload_2
    //   3852: ldc_w 1350
    //   3855: iconst_0
    //   3856: invokevirtual 1131	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   3859: istore 15
    //   3861: aload_2
    //   3862: ldc_w 1381
    //   3865: invokevirtual 1166	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   3868: pop
    //   3869: aload_2
    //   3870: ldc_w 1383
    //   3873: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3876: pop
    //   3877: aload_2
    //   3878: ldc_w 1385
    //   3881: invokevirtual 483	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   3884: pop
    //   3885: aload_0
    //   3886: invokevirtual 1328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   3889: ifeq +91 -> 3980
    //   3892: aload_0
    //   3893: invokevirtual 1332	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   3896: astore_2
    //   3897: aload_2
    //   3898: ifnull +63 -> 3961
    //   3901: aload_2
    //   3902: iload 15
    //   3904: putfield 1349	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareTicket	Z
    //   3907: aload_0
    //   3908: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3911: aload_3
    //   3912: aload_1
    //   3913: aload_1
    //   3914: aconst_null
    //   3915: invokestatic 1053	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3918: iload 4
    //   3920: invokevirtual 1212	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3923: aload_0
    //   3924: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3927: aload_3
    //   3928: aload_1
    //   3929: aload_1
    //   3930: aconst_null
    //   3931: invokestatic 1053	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3934: iload 4
    //   3936: invokevirtual 1212	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3939: goto -2536 -> 1403
    //   3942: astore_1
    //   3943: ldc 150
    //   3945: iconst_1
    //   3946: aload_1
    //   3947: iconst_0
    //   3948: anewarray 816	java/lang/Object
    //   3951: invokestatic 1175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3954: aload_1
    //   3955: invokevirtual 1213	org/json/JSONException:printStackTrace	()V
    //   3958: goto -2555 -> 1403
    //   3961: aload_0
    //   3962: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3965: aload_3
    //   3966: aload_1
    //   3967: aload_1
    //   3968: aconst_null
    //   3969: invokestatic 617	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   3972: iload 4
    //   3974: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   3977: goto -54 -> 3923
    //   3980: aload_0
    //   3981: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3984: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   3987: invokevirtual 1364	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getContainer	()Landroid/view/View;
    //   3990: ifnull +50 -> 4040
    //   3993: aload_0
    //   3994: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   3997: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4000: invokevirtual 1368	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4003: ifnull +37 -> 4040
    //   4006: aload_0
    //   4007: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4010: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4013: invokevirtual 1368	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4016: iload 15
    //   4018: putfield 1375	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareTicket	Z
    //   4021: aload_0
    //   4022: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4025: aload_3
    //   4026: aload_1
    //   4027: aload_1
    //   4028: aconst_null
    //   4029: invokestatic 1053	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   4032: iload 4
    //   4034: invokevirtual 1212	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   4037: goto -114 -> 3923
    //   4040: aload_0
    //   4041: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4044: aload_3
    //   4045: aload_1
    //   4046: aload_1
    //   4047: aconst_null
    //   4048: invokestatic 617	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   4051: iload 4
    //   4053: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   4056: goto -133 -> 3923
    //   4059: ldc 32
    //   4061: aload_1
    //   4062: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4065: ifeq +79 -> 4144
    //   4068: new 348	org/json/JSONObject
    //   4071: dup
    //   4072: aload_2
    //   4073: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4076: astore_2
    //   4077: aload_2
    //   4078: ldc_w 1299
    //   4081: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4084: astore 20
    //   4086: aload_2
    //   4087: ldc_w 1301
    //   4090: iconst_0
    //   4091: invokevirtual 1304	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   4094: istore 8
    //   4096: iload 8
    //   4098: istore 7
    //   4100: iload 8
    //   4102: ifgt +8 -> 4110
    //   4105: sipush 30000
    //   4108: istore 7
    //   4110: aload_0
    //   4111: aload 20
    //   4113: iload 7
    //   4115: aload_3
    //   4116: aload_1
    //   4117: iload 4
    //   4119: invokespecial 1306	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:operateGetShareInfo	(Ljava/lang/String;ILcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   4122: goto -2719 -> 1403
    //   4125: astore_1
    //   4126: ldc 150
    //   4128: iconst_1
    //   4129: aload_1
    //   4130: iconst_0
    //   4131: anewarray 816	java/lang/Object
    //   4134: invokestatic 1175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   4137: aload_1
    //   4138: invokevirtual 1213	org/json/JSONException:printStackTrace	()V
    //   4141: goto -2738 -> 1403
    //   4144: ldc 68
    //   4146: aload_1
    //   4147: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4150: ifne +21 -> 4171
    //   4153: ldc 65
    //   4155: aload_1
    //   4156: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4159: ifne +12 -> 4171
    //   4162: ldc 71
    //   4164: aload_1
    //   4165: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4168: ifeq +1371 -> 5539
    //   4171: iconst_0
    //   4172: istore 15
    //   4174: ldc 68
    //   4176: aload_1
    //   4177: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4180: ifeq +6 -> 4186
    //   4183: iconst_1
    //   4184: istore 15
    //   4186: new 348	org/json/JSONObject
    //   4189: dup
    //   4190: aload_2
    //   4191: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4194: astore 23
    //   4196: aload 23
    //   4198: ldc_w 1387
    //   4201: iconst_m1
    //   4202: invokevirtual 1304	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   4205: istore 9
    //   4207: iconst_m1
    //   4208: istore 7
    //   4210: aconst_null
    //   4211: astore 22
    //   4213: iload 9
    //   4215: ifne +6250 -> 10465
    //   4218: iconst_0
    //   4219: istore 7
    //   4221: aconst_null
    //   4222: astore_2
    //   4223: aload 23
    //   4225: ldc_w 1389
    //   4228: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4231: astore 25
    //   4233: aload 23
    //   4235: ldc_w 1391
    //   4238: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4241: astore 26
    //   4243: ldc 68
    //   4245: aload_1
    //   4246: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4249: ifne +6196 -> 10445
    //   4252: ldc 71
    //   4254: aload_1
    //   4255: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4258: ifeq +29 -> 4287
    //   4261: goto +6184 -> 10445
    //   4264: aload_0
    //   4265: invokevirtual 1328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4268: ifeq +510 -> 4778
    //   4271: aload_0
    //   4272: invokevirtual 1332	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4275: ifnull +503 -> 4778
    //   4278: aload_0
    //   4279: invokevirtual 1332	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4282: iload 8
    //   4284: putfield 1394	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   4287: aload_0
    //   4288: invokevirtual 1328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4291: ifeq +524 -> 4815
    //   4294: aload_0
    //   4295: invokevirtual 1332	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4298: ifnull +517 -> 4815
    //   4301: aload_0
    //   4302: invokevirtual 1332	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4305: aload_1
    //   4306: putfield 1397	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareEvent	Ljava/lang/String;
    //   4309: aload_0
    //   4310: invokevirtual 1332	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4313: iload 4
    //   4315: putfield 1400	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareCallbackId	I
    //   4318: aload 23
    //   4320: ldc_w 1402
    //   4323: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4326: astore 20
    //   4328: aload 20
    //   4330: astore 21
    //   4332: aload 20
    //   4334: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4337: ifeq +13 -> 4350
    //   4340: aload 23
    //   4342: ldc_w 1404
    //   4345: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4348: astore 21
    //   4350: aload 23
    //   4352: ldc_w 1406
    //   4355: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4358: astore 24
    //   4360: aload 23
    //   4362: ldc_w 1408
    //   4365: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4368: astore 27
    //   4370: aload 23
    //   4372: ldc_w 1410
    //   4375: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4378: astore 23
    //   4380: aload 21
    //   4382: astore 20
    //   4384: aload 21
    //   4386: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4389: ifeq +15 -> 4404
    //   4392: aload_0
    //   4393: invokevirtual 1328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4396: ifeq +451 -> 4847
    //   4399: ldc_w 1412
    //   4402: astore 20
    //   4404: new 1414	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$8
    //   4407: dup
    //   4408: aload_0
    //   4409: aload_3
    //   4410: aload_1
    //   4411: iload 4
    //   4413: invokespecial 1415	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$8:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   4416: astore_1
    //   4417: aload_0
    //   4418: invokevirtual 1328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4421: ifeq +21 -> 4442
    //   4424: aload_0
    //   4425: invokevirtual 1332	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4428: ifnull +14 -> 4442
    //   4431: aload_0
    //   4432: invokevirtual 1332	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4435: getfield 1394	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   4438: iconst_1
    //   4439: if_icmpeq +27 -> 4466
    //   4442: aload_0
    //   4443: invokevirtual 1328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4446: ifne +506 -> 4952
    //   4449: aload_0
    //   4450: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4453: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4456: invokevirtual 1368	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4459: getfield 1416	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   4462: iconst_1
    //   4463: if_icmpne +489 -> 4952
    //   4466: aload 27
    //   4468: ldc_w 1418
    //   4471: invokevirtual 1421	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4474: ifne +14 -> 4488
    //   4477: aload 27
    //   4479: ldc_w 1423
    //   4482: invokevirtual 1421	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4485: ifeq +383 -> 4868
    //   4488: aload_0
    //   4489: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4492: invokevirtual 558	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   4495: aload 24
    //   4497: aload 27
    //   4499: aload 20
    //   4501: aload_0
    //   4502: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4505: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4508: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4511: iload 15
    //   4513: invokestatic 1427	com/tencent/mobileqq/mini/appbrand/utils/ShareUtils:startShareToQzone	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;Z)V
    //   4516: goto +5945 -> 10461
    //   4519: iload 9
    //   4521: iconst_2
    //   4522: if_icmpne +5957 -> 10479
    //   4525: iconst_0
    //   4526: istore 7
    //   4528: aload 23
    //   4530: ldc_w 1429
    //   4533: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4536: astore_2
    //   4537: aload_2
    //   4538: ifnull +80 -> 4618
    //   4541: aload_0
    //   4542: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4545: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4548: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4551: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   4554: getfield 528	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   4557: getfield 1433	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   4560: ifnull +58 -> 4618
    //   4563: aload_2
    //   4564: aload_0
    //   4565: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4568: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4571: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4574: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   4577: getfield 528	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   4580: getfield 1433	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   4583: invokevirtual 1438	com/tencent/mobileqq/mini/sdk/EntryModel:getEntryHash	()Ljava/lang/String;
    //   4586: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4589: ifeq +29 -> 4618
    //   4592: aload_0
    //   4593: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4596: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4599: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4602: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   4605: getfield 528	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   4608: getfield 1433	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   4611: astore 22
    //   4613: aconst_null
    //   4614: astore_2
    //   4615: goto -392 -> 4223
    //   4618: ldc 150
    //   4620: iconst_1
    //   4621: new 398	java/lang/StringBuilder
    //   4624: dup
    //   4625: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   4628: ldc_w 1440
    //   4631: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4634: aload_2
    //   4635: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4638: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4641: invokestatic 611	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4644: aconst_null
    //   4645: astore_2
    //   4646: goto -423 -> 4223
    //   4649: iload 9
    //   4651: iconst_5
    //   4652: if_icmpne +102 -> 4754
    //   4655: aload 23
    //   4657: ldc_w 1442
    //   4660: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4663: astore 20
    //   4665: aload_0
    //   4666: invokevirtual 1328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4669: ifeq +37 -> 4706
    //   4672: aload_0
    //   4673: invokevirtual 1332	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4676: ifnull +30 -> 4706
    //   4679: aload_0
    //   4680: invokevirtual 1332	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4683: getfield 1446	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareChatModel	Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;
    //   4686: astore_2
    //   4687: aload_2
    //   4688: ifnull +35 -> 4723
    //   4691: aload_2
    //   4692: invokevirtual 1449	com/tencent/mobileqq/mini/sdk/ShareChatModel:getEntryHash	()Ljava/lang/String;
    //   4695: aload 20
    //   4697: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4700: ifeq +23 -> 4723
    //   4703: goto +5804 -> 10507
    //   4706: aload_0
    //   4707: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4710: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4713: invokevirtual 1368	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4716: getfield 1450	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareChatModel	Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;
    //   4719: astore_2
    //   4720: goto -33 -> 4687
    //   4723: ldc 150
    //   4725: iconst_1
    //   4726: new 398	java/lang/StringBuilder
    //   4729: dup
    //   4730: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   4733: ldc_w 1440
    //   4736: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4739: aconst_null
    //   4740: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4743: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4746: invokestatic 611	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4749: aconst_null
    //   4750: astore_2
    //   4751: goto +5756 -> 10507
    //   4754: iload 9
    //   4756: bipush 6
    //   4758: if_icmpne +5640 -> 10398
    //   4761: ldc 71
    //   4763: aload_1
    //   4764: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4767: ifeq +5631 -> 10398
    //   4770: iconst_0
    //   4771: istore 7
    //   4773: aconst_null
    //   4774: astore_2
    //   4775: goto -552 -> 4223
    //   4778: aload_0
    //   4779: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4782: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4785: invokevirtual 1368	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4788: iload 8
    //   4790: putfield 1416	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   4793: goto -506 -> 4287
    //   4796: astore_1
    //   4797: ldc 150
    //   4799: iconst_1
    //   4800: aload_1
    //   4801: iconst_0
    //   4802: anewarray 816	java/lang/Object
    //   4805: invokestatic 1175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   4808: aload_1
    //   4809: invokevirtual 1213	org/json/JSONException:printStackTrace	()V
    //   4812: goto -3409 -> 1403
    //   4815: aload_0
    //   4816: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4819: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4822: invokevirtual 1368	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4825: aload_1
    //   4826: putfield 1451	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareEvent	Ljava/lang/String;
    //   4829: aload_0
    //   4830: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4833: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4836: invokevirtual 1368	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4839: iload 4
    //   4841: putfield 1452	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareCallbackId	I
    //   4844: goto -526 -> 4318
    //   4847: aload_0
    //   4848: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4851: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4854: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4857: invokevirtual 918	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   4860: getfield 1088	com/tencent/mobileqq/mini/apkg/AppConfigInfo:entryPagePath	Ljava/lang/String;
    //   4863: astore 20
    //   4865: goto -461 -> 4404
    //   4868: aload_0
    //   4869: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4872: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4875: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4878: pop
    //   4879: invokestatic 1457	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   4882: aload 27
    //   4884: invokevirtual 1460	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   4887: astore_1
    //   4888: aload_1
    //   4889: invokestatic 1464	aqmr:isEmpty	(Ljava/lang/String;)Z
    //   4892: ifne +33 -> 4925
    //   4895: aload_0
    //   4896: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4899: invokevirtual 558	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   4902: aload 24
    //   4904: aload_1
    //   4905: aload 20
    //   4907: aload_0
    //   4908: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4911: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4914: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   4917: iload 15
    //   4919: invokestatic 1427	com/tencent/mobileqq/mini/appbrand/utils/ShareUtils:startShareToQzone	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;Z)V
    //   4922: goto +5539 -> 10461
    //   4925: aload_0
    //   4926: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4929: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4932: new 1466	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$9
    //   4935: dup
    //   4936: aload_0
    //   4937: aload 24
    //   4939: aload 20
    //   4941: iload 15
    //   4943: invokespecial 1469	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$9:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Ljava/lang/String;Ljava/lang/String;Z)V
    //   4946: invokevirtual 1473	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getShareScreenshot	(Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime$ShareScreenshotCallback;)V
    //   4949: goto +5512 -> 10461
    //   4952: aload_0
    //   4953: invokevirtual 1328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4956: ifeq +21 -> 4977
    //   4959: aload_0
    //   4960: invokevirtual 1332	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4963: ifnull +14 -> 4977
    //   4966: aload_0
    //   4967: invokevirtual 1332	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   4970: getfield 1394	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   4973: iconst_3
    //   4974: if_icmpeq +27 -> 5001
    //   4977: aload_0
    //   4978: invokevirtual 1328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   4981: ifne +55 -> 5036
    //   4984: aload_0
    //   4985: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   4988: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   4991: invokevirtual 1368	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   4994: getfield 1416	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   4997: iconst_3
    //   4998: if_icmpne +38 -> 5036
    //   5001: aload_0
    //   5002: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5005: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5008: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   5011: astore_1
    //   5012: aload_0
    //   5013: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5016: invokevirtual 558	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   5019: aload 24
    //   5021: aload_1
    //   5022: getfield 1476	com/tencent/mobileqq/mini/apkg/ApkgInfo:iconUrl	Ljava/lang/String;
    //   5025: aload 20
    //   5027: iconst_3
    //   5028: aload_1
    //   5029: invokestatic 1480	com/tencent/mobileqq/mini/appbrand/utils/ShareUtils:startShareToWeChat	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/mini/apkg/ApkgInfo;)V
    //   5032: ldc_w 524
    //   5035: areturn
    //   5036: aload_0
    //   5037: invokevirtual 1328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5040: ifeq +21 -> 5061
    //   5043: aload_0
    //   5044: invokevirtual 1332	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5047: ifnull +14 -> 5061
    //   5050: aload_0
    //   5051: invokevirtual 1332	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5054: getfield 1394	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   5057: iconst_4
    //   5058: if_icmpeq +27 -> 5085
    //   5061: aload_0
    //   5062: invokevirtual 1328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5065: ifne +55 -> 5120
    //   5068: aload_0
    //   5069: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5072: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5075: invokevirtual 1368	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   5078: getfield 1416	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   5081: iconst_4
    //   5082: if_icmpne +38 -> 5120
    //   5085: aload_0
    //   5086: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5089: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5092: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   5095: astore_1
    //   5096: aload_0
    //   5097: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5100: invokevirtual 558	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getActivityContext	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   5103: aload 24
    //   5105: aload_1
    //   5106: getfield 1476	com/tencent/mobileqq/mini/apkg/ApkgInfo:iconUrl	Ljava/lang/String;
    //   5109: aload 20
    //   5111: iconst_4
    //   5112: aload_1
    //   5113: invokestatic 1480	com/tencent/mobileqq/mini/appbrand/utils/ShareUtils:startShareToWeChat	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/mini/apkg/ApkgInfo;)V
    //   5116: ldc_w 524
    //   5119: areturn
    //   5120: aload 27
    //   5122: invokestatic 1485	android/webkit/URLUtil:isHttpUrl	(Ljava/lang/String;)Z
    //   5125: ifne +5388 -> 10513
    //   5128: aload 27
    //   5130: invokestatic 1488	android/webkit/URLUtil:isHttpsUrl	(Ljava/lang/String;)Z
    //   5133: ifeq +5386 -> 10519
    //   5136: goto +5377 -> 10513
    //   5139: aload_0
    //   5140: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5143: ifnull +5382 -> 10525
    //   5146: aload_0
    //   5147: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5150: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5153: ifnull +5372 -> 10525
    //   5156: aload 27
    //   5158: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5161: ifne +5364 -> 10525
    //   5164: new 1490	java/io/File
    //   5167: dup
    //   5168: invokestatic 1457	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   5171: aload 27
    //   5173: invokevirtual 1460	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   5176: invokespecial 1491	java/io/File:<init>	(Ljava/lang/String;)V
    //   5179: invokevirtual 1494	java/io/File:exists	()Z
    //   5182: ifeq +5343 -> 10525
    //   5185: iconst_1
    //   5186: istore 17
    //   5188: aload 27
    //   5190: invokestatic 1464	aqmr:isEmpty	(Ljava/lang/String;)Z
    //   5193: ifne +13 -> 5206
    //   5196: iload 16
    //   5198: ifne +197 -> 5395
    //   5201: iload 17
    //   5203: ifne +192 -> 5395
    //   5206: aload_0
    //   5207: invokevirtual 1328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5210: ifeq +110 -> 5320
    //   5213: aload_0
    //   5214: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5217: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5220: astore_3
    //   5221: invokestatic 1499	com/tencent/mobileqq/minigame/utils/GameWnsUtils:defaultShareImg	()Ljava/lang/String;
    //   5224: astore 21
    //   5226: iload 15
    //   5228: ifeq +5303 -> 10531
    //   5231: bipush 11
    //   5233: istore 4
    //   5235: aload_3
    //   5236: aload 24
    //   5238: aload 21
    //   5240: aload 20
    //   5242: aload 23
    //   5244: aload 25
    //   5246: aload 26
    //   5248: aload 22
    //   5250: aload_2
    //   5251: iload 4
    //   5253: iload 9
    //   5255: ldc_w 524
    //   5258: aload_1
    //   5259: invokevirtual 1503	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:startShare	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/EntryModel;Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;IILjava/lang/String;Lcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5262: ldc 150
    //   5264: iconst_1
    //   5265: new 398	java/lang/StringBuilder
    //   5268: dup
    //   5269: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   5272: ldc_w 1505
    //   5275: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5278: iload 16
    //   5280: invokevirtual 967	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5283: ldc_w 1507
    //   5286: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5289: iload 17
    //   5291: invokevirtual 967	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5294: ldc_w 1509
    //   5297: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5300: aload 27
    //   5302: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5305: ldc_w 1511
    //   5308: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5311: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5314: invokestatic 611	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5317: goto -3914 -> 1403
    //   5320: aload_0
    //   5321: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5324: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5327: ifnull -3924 -> 1403
    //   5330: aload_0
    //   5331: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5334: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5337: getfield 1514	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:isGettingScreenShot	Z
    //   5340: ifeq +16 -> 5356
    //   5343: ldc 150
    //   5345: iconst_1
    //   5346: ldc_w 1516
    //   5349: invokestatic 611	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5352: ldc_w 524
    //   5355: areturn
    //   5356: aload_0
    //   5357: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5360: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5363: new 1518	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$10
    //   5366: dup
    //   5367: aload_0
    //   5368: aload 24
    //   5370: aload 20
    //   5372: aload 23
    //   5374: aload 25
    //   5376: aload 26
    //   5378: aload 22
    //   5380: aload_2
    //   5381: iload 15
    //   5383: iload 9
    //   5385: aload_1
    //   5386: invokespecial 1521	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$10:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/EntryModel;Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;ZILcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5389: invokevirtual 1473	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getShareScreenshot	(Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime$ShareScreenshotCallback;)V
    //   5392: goto -3989 -> 1403
    //   5395: aload 27
    //   5397: ldc_w 1418
    //   5400: invokevirtual 1421	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5403: ifne +14 -> 5417
    //   5406: aload 27
    //   5408: ldc_w 1423
    //   5411: invokevirtual 1421	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5414: ifeq +50 -> 5464
    //   5417: aload_0
    //   5418: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5421: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5424: astore_3
    //   5425: iload 15
    //   5427: ifeq +5111 -> 10538
    //   5430: bipush 11
    //   5432: istore 4
    //   5434: aload_3
    //   5435: aload 24
    //   5437: aload 27
    //   5439: aload 20
    //   5441: aload 23
    //   5443: aload 25
    //   5445: aload 26
    //   5447: aload 22
    //   5449: aload_2
    //   5450: iload 4
    //   5452: iload 9
    //   5454: ldc_w 524
    //   5457: aload_1
    //   5458: invokevirtual 1503	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:startShare	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/EntryModel;Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;IILjava/lang/String;Lcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5461: goto -4058 -> 1403
    //   5464: aload_0
    //   5465: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5468: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5471: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   5474: pop
    //   5475: invokestatic 1457	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   5478: aload 27
    //   5480: invokevirtual 1460	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   5483: astore_3
    //   5484: aload_0
    //   5485: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5488: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5491: astore 21
    //   5493: iload 15
    //   5495: ifeq +37 -> 5532
    //   5498: bipush 11
    //   5500: istore 4
    //   5502: aload 21
    //   5504: aload 24
    //   5506: aload_3
    //   5507: aload 20
    //   5509: aload 23
    //   5511: aload 25
    //   5513: aload 26
    //   5515: aload 22
    //   5517: aload_2
    //   5518: iload 4
    //   5520: iload 9
    //   5522: ldc_w 524
    //   5525: aload_1
    //   5526: invokevirtual 1503	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:startShare	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/EntryModel;Lcom/tencent/mobileqq/mini/sdk/ShareChatModel;IILjava/lang/String;Lcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5529: goto -4126 -> 1403
    //   5532: bipush 12
    //   5534: istore 4
    //   5536: goto -34 -> 5502
    //   5539: ldc 74
    //   5541: aload_1
    //   5542: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5545: ifne +12 -> 5557
    //   5548: ldc 77
    //   5550: aload_1
    //   5551: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5554: ifeq +531 -> 6085
    //   5557: new 348	org/json/JSONObject
    //   5560: dup
    //   5561: aload_2
    //   5562: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5565: astore_2
    //   5566: aload_2
    //   5567: ldc_w 1387
    //   5570: iconst_m1
    //   5571: invokevirtual 1304	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   5574: istore 8
    //   5576: iconst_m1
    //   5577: istore 7
    //   5579: iload 8
    //   5581: ifne +242 -> 5823
    //   5584: iconst_0
    //   5585: istore 7
    //   5587: ldc 77
    //   5589: aload_1
    //   5590: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5593: ifeq +39 -> 5632
    //   5596: iload 7
    //   5598: istore 8
    //   5600: iload 7
    //   5602: iconst_m1
    //   5603: if_icmpne +6 -> 5609
    //   5606: iconst_0
    //   5607: istore 8
    //   5609: aload_0
    //   5610: invokevirtual 1328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5613: ifeq +258 -> 5871
    //   5616: aload_0
    //   5617: invokevirtual 1332	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5620: ifnull +251 -> 5871
    //   5623: aload_0
    //   5624: invokevirtual 1332	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5627: iload 8
    //   5629: putfield 1394	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   5632: aload_0
    //   5633: invokevirtual 1328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5636: ifeq +253 -> 5889
    //   5639: aload_0
    //   5640: invokevirtual 1332	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5643: ifnull +246 -> 5889
    //   5646: aload_0
    //   5647: invokevirtual 1332	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5650: getfield 1394	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:fromShareMenuBtn	I
    //   5653: istore 7
    //   5655: aload_0
    //   5656: invokevirtual 1328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5659: ifeq +248 -> 5907
    //   5662: aload_0
    //   5663: invokevirtual 1332	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5666: ifnull +241 -> 5907
    //   5669: aload_0
    //   5670: invokevirtual 1332	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5673: aload_1
    //   5674: putfield 1397	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareEvent	Ljava/lang/String;
    //   5677: aload_0
    //   5678: invokevirtual 1332	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   5681: iload 4
    //   5683: putfield 1400	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:shareCallbackId	I
    //   5686: new 1523	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$11
    //   5689: dup
    //   5690: aload_0
    //   5691: aload_3
    //   5692: aload_1
    //   5693: iload 4
    //   5695: invokespecial 1524	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$11:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   5698: astore_1
    //   5699: aload_0
    //   5700: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5703: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5706: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   5709: astore_3
    //   5710: aload_2
    //   5711: ldc_w 1406
    //   5714: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5717: astore 20
    //   5719: aload_2
    //   5720: ldc_w 1408
    //   5723: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5726: astore_2
    //   5727: aload_2
    //   5728: invokestatic 1485	android/webkit/URLUtil:isHttpUrl	(Ljava/lang/String;)Z
    //   5731: ifne +4814 -> 10545
    //   5734: aload_2
    //   5735: invokestatic 1488	android/webkit/URLUtil:isHttpsUrl	(Ljava/lang/String;)Z
    //   5738: ifeq +4813 -> 10551
    //   5741: goto +4804 -> 10545
    //   5744: invokestatic 1457	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   5747: aload_2
    //   5748: invokevirtual 1460	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   5751: astore 21
    //   5753: aload_0
    //   5754: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5757: ifnull +4800 -> 10557
    //   5760: aload_0
    //   5761: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5764: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5767: ifnull +4790 -> 10557
    //   5770: aload_2
    //   5771: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5774: ifne +4783 -> 10557
    //   5777: new 1490	java/io/File
    //   5780: dup
    //   5781: aload 21
    //   5783: invokespecial 1491	java/io/File:<init>	(Ljava/lang/String;)V
    //   5786: invokevirtual 1494	java/io/File:exists	()Z
    //   5789: ifeq +4768 -> 10557
    //   5792: iconst_1
    //   5793: istore 8
    //   5795: iload 4
    //   5797: ifeq +142 -> 5939
    //   5800: aload_0
    //   5801: aload 22
    //   5803: aload 20
    //   5805: aload_2
    //   5806: iload 7
    //   5808: aload_1
    //   5809: invokespecial 201	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:startShareNetworkPicMessage	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5812: goto -4409 -> 1403
    //   5815: astore_1
    //   5816: aload_1
    //   5817: invokevirtual 1213	org/json/JSONException:printStackTrace	()V
    //   5820: goto -4417 -> 1403
    //   5823: iload 8
    //   5825: iconst_1
    //   5826: if_icmpne +9 -> 5835
    //   5829: iconst_1
    //   5830: istore 7
    //   5832: goto -245 -> 5587
    //   5835: iload 8
    //   5837: iconst_2
    //   5838: if_icmpne +9 -> 5847
    //   5841: iconst_0
    //   5842: istore 7
    //   5844: goto -257 -> 5587
    //   5847: iload 8
    //   5849: iconst_3
    //   5850: if_icmpne +9 -> 5859
    //   5853: iconst_3
    //   5854: istore 7
    //   5856: goto -269 -> 5587
    //   5859: iload 8
    //   5861: iconst_4
    //   5862: if_icmpne -275 -> 5587
    //   5865: iconst_4
    //   5866: istore 7
    //   5868: goto -281 -> 5587
    //   5871: aload_0
    //   5872: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5875: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5878: invokevirtual 1368	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   5881: iload 8
    //   5883: putfield 1416	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   5886: goto -254 -> 5632
    //   5889: aload_0
    //   5890: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5893: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5896: invokevirtual 1368	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   5899: getfield 1416	com/tencent/mobileqq/mini/appbrand/page/PageWebview:fromShareMenuBtn	I
    //   5902: istore 7
    //   5904: goto -249 -> 5655
    //   5907: aload_0
    //   5908: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5911: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5914: invokevirtual 1368	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   5917: aload_1
    //   5918: putfield 1451	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareEvent	Ljava/lang/String;
    //   5921: aload_0
    //   5922: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   5925: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   5928: invokevirtual 1368	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   5931: iload 4
    //   5933: putfield 1452	com/tencent/mobileqq/mini/appbrand/page/PageWebview:shareCallbackId	I
    //   5936: goto -250 -> 5686
    //   5939: aload_2
    //   5940: invokestatic 1464	aqmr:isEmpty	(Ljava/lang/String;)Z
    //   5943: ifne +13 -> 5956
    //   5946: iload 4
    //   5948: ifne +114 -> 6062
    //   5951: iload 8
    //   5953: ifne +109 -> 6062
    //   5956: aload_0
    //   5957: invokevirtual 1328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   5960: ifeq +37 -> 5997
    //   5963: aload_3
    //   5964: ifnull +21 -> 5985
    //   5967: aload_0
    //   5968: aload 22
    //   5970: aload 20
    //   5972: aload_3
    //   5973: getfield 1476	com/tencent/mobileqq/mini/apkg/ApkgInfo:iconUrl	Ljava/lang/String;
    //   5976: iload 7
    //   5978: aload_1
    //   5979: invokespecial 201	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:startShareNetworkPicMessage	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   5982: goto -4579 -> 1403
    //   5985: ldc 150
    //   5987: iconst_1
    //   5988: ldc_w 1526
    //   5991: invokestatic 611	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5994: goto -4591 -> 1403
    //   5997: aload_0
    //   5998: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6001: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6004: ifnull -4601 -> 1403
    //   6007: aload_0
    //   6008: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6011: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6014: getfield 1514	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:isGettingScreenShot	Z
    //   6017: ifeq +16 -> 6033
    //   6020: ldc 150
    //   6022: iconst_1
    //   6023: ldc_w 1528
    //   6026: invokestatic 611	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   6029: ldc_w 524
    //   6032: areturn
    //   6033: aload_0
    //   6034: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6037: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6040: new 1530	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$12
    //   6043: dup
    //   6044: aload_0
    //   6045: aload_3
    //   6046: aload 22
    //   6048: aload 20
    //   6050: iload 7
    //   6052: aload_1
    //   6053: invokespecial 1533	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$12:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;Landroid/app/Activity;Ljava/lang/String;ILcom/tencent/mobileqq/mini/share/MiniProgramShareUtils$OnShareListener;)V
    //   6056: invokevirtual 1473	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getShareScreenshot	(Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime$ShareScreenshotCallback;)V
    //   6059: goto -4656 -> 1403
    //   6062: iload 4
    //   6064: ifne -4661 -> 1403
    //   6067: iload 8
    //   6069: ifeq -4666 -> 1403
    //   6072: aload_0
    //   6073: aload 20
    //   6075: aload 21
    //   6077: iload 7
    //   6079: invokespecial 207	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:startShareLocalPicMessage	(Ljava/lang/String;Ljava/lang/String;I)V
    //   6082: goto -4679 -> 1403
    //   6085: ldc 44
    //   6087: aload_1
    //   6088: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6091: ifeq +383 -> 6474
    //   6094: aload_0
    //   6095: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6098: ifnull -4695 -> 1403
    //   6101: aload_0
    //   6102: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6105: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6108: ifnull -4705 -> 1403
    //   6111: iconst_m1
    //   6112: istore 7
    //   6114: new 348	org/json/JSONObject
    //   6117: dup
    //   6118: aload_2
    //   6119: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6122: ldc_w 1535
    //   6125: invokevirtual 1355	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   6128: checkcast 359	org/json/JSONArray
    //   6131: astore_2
    //   6132: aload_2
    //   6133: ifnonnull +98 -> 6231
    //   6136: iconst_0
    //   6137: istore 10
    //   6139: iconst_0
    //   6140: istore 9
    //   6142: iconst_0
    //   6143: istore 8
    //   6145: iconst_0
    //   6146: istore 7
    //   6148: aload_0
    //   6149: invokevirtual 1328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   6152: ifeq +182 -> 6334
    //   6155: aload_0
    //   6156: invokevirtual 1332	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getGameBrandRuntime	()Lcom/tencent/mobileqq/minigame/jsapi/GameBrandRuntime;
    //   6159: astore_2
    //   6160: aload_2
    //   6161: ifnull +154 -> 6315
    //   6164: iload 10
    //   6166: ifne +8 -> 6174
    //   6169: aload_2
    //   6170: iconst_0
    //   6171: putfield 1337	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQQ	Z
    //   6174: iload 9
    //   6176: ifne +8 -> 6184
    //   6179: aload_2
    //   6180: iconst_0
    //   6181: putfield 1340	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareQzone	Z
    //   6184: iload 8
    //   6186: ifne +8 -> 6194
    //   6189: aload_2
    //   6190: iconst_0
    //   6191: putfield 1343	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatFriend	Z
    //   6194: iload 7
    //   6196: ifne +8 -> 6204
    //   6199: aload_2
    //   6200: iconst_0
    //   6201: putfield 1346	com/tencent/mobileqq/minigame/jsapi/GameBrandRuntime:withShareWeChatMoment	Z
    //   6204: aload_0
    //   6205: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6208: aload_3
    //   6209: aload_1
    //   6210: aload_1
    //   6211: aconst_null
    //   6212: invokestatic 1053	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   6215: iload 4
    //   6217: invokevirtual 1212	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6220: goto -4817 -> 1403
    //   6223: astore_1
    //   6224: aload_1
    //   6225: invokevirtual 1213	org/json/JSONException:printStackTrace	()V
    //   6228: goto -4825 -> 1403
    //   6231: iconst_m1
    //   6232: istore 8
    //   6234: iconst_m1
    //   6235: istore 9
    //   6237: iconst_m1
    //   6238: istore 10
    //   6240: iconst_0
    //   6241: istore 11
    //   6243: iload 11
    //   6245: aload_2
    //   6246: invokevirtual 1358	org/json/JSONArray:length	()I
    //   6249: if_icmpge +4146 -> 10395
    //   6252: aload_2
    //   6253: iload 11
    //   6255: invokevirtual 1360	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   6258: astore 20
    //   6260: aload 20
    //   6262: ldc 124
    //   6264: invokevirtual 861	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   6267: ifeq +6 -> 6273
    //   6270: iconst_0
    //   6271: istore 10
    //   6273: aload 20
    //   6275: ldc 127
    //   6277: invokevirtual 861	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   6280: ifeq +6 -> 6286
    //   6283: iconst_0
    //   6284: istore 9
    //   6286: aload 20
    //   6288: ldc 130
    //   6290: invokevirtual 861	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   6293: ifeq +6 -> 6299
    //   6296: iconst_0
    //   6297: istore 8
    //   6299: aload 20
    //   6301: ldc 133
    //   6303: invokevirtual 861	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   6306: ifeq +4257 -> 10563
    //   6309: iconst_0
    //   6310: istore 7
    //   6312: goto +4251 -> 10563
    //   6315: aload_0
    //   6316: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6319: aload_3
    //   6320: aload_1
    //   6321: aload_1
    //   6322: aconst_null
    //   6323: invokestatic 617	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   6326: iload 4
    //   6328: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6331: goto -4928 -> 1403
    //   6334: aload_0
    //   6335: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6338: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6341: invokevirtual 1364	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getContainer	()Landroid/view/View;
    //   6344: ifnull +111 -> 6455
    //   6347: aload_0
    //   6348: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6351: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6354: invokevirtual 1368	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6357: ifnull +98 -> 6455
    //   6360: iload 10
    //   6362: ifne +17 -> 6379
    //   6365: aload_0
    //   6366: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6369: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6372: invokevirtual 1368	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6375: iconst_0
    //   6376: putfield 1371	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQQ	Z
    //   6379: iload 9
    //   6381: ifne +17 -> 6398
    //   6384: aload_0
    //   6385: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6388: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6391: invokevirtual 1368	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6394: iconst_0
    //   6395: putfield 1372	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareQzone	Z
    //   6398: iload 8
    //   6400: ifne +17 -> 6417
    //   6403: aload_0
    //   6404: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6407: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6410: invokevirtual 1368	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6413: iconst_0
    //   6414: putfield 1373	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatFriend	Z
    //   6417: iload 7
    //   6419: ifne +17 -> 6436
    //   6422: aload_0
    //   6423: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6426: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6429: invokevirtual 1368	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getPageWebView	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   6432: iconst_0
    //   6433: putfield 1374	com/tencent/mobileqq/mini/appbrand/page/PageWebview:withShareWeChatMoment	Z
    //   6436: aload_0
    //   6437: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6440: aload_3
    //   6441: aload_1
    //   6442: aload_1
    //   6443: aconst_null
    //   6444: invokestatic 1053	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   6447: iload 4
    //   6449: invokevirtual 1212	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6452: goto -5049 -> 1403
    //   6455: aload_0
    //   6456: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6459: aload_3
    //   6460: aload_1
    //   6461: aload_1
    //   6462: aconst_null
    //   6463: invokestatic 617	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   6466: iload 4
    //   6468: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6471: goto -5068 -> 1403
    //   6474: ldc_w 1537
    //   6477: aload_1
    //   6478: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6481: ifeq +298 -> 6779
    //   6484: invokestatic 471	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   6487: invokevirtual 1184	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   6490: astore 20
    //   6492: aload 20
    //   6494: instanceof 1539
    //   6497: ifeq +3892 -> 10389
    //   6500: aload 20
    //   6502: checkcast 1539	com/tencent/mobileqq/mini/MiniAppInterface
    //   6505: astore 20
    //   6507: aload 20
    //   6509: ifnonnull +18 -> 6527
    //   6512: aload_0
    //   6513: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6516: aload_3
    //   6517: aload_1
    //   6518: aconst_null
    //   6519: iload 4
    //   6521: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6524: goto -5121 -> 1403
    //   6527: new 348	org/json/JSONObject
    //   6530: dup
    //   6531: aload_2
    //   6532: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6535: ldc_w 1541
    //   6538: invokevirtual 1544	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   6541: iconst_0
    //   6542: invokevirtual 1360	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   6545: astore 22
    //   6547: aload 22
    //   6549: astore 21
    //   6551: aload 22
    //   6553: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6556: ifne +10 -> 6566
    //   6559: aload 22
    //   6561: invokevirtual 1547	java/lang/String:trim	()Ljava/lang/String;
    //   6564: astore 21
    //   6566: aload 20
    //   6568: aload_0
    //   6569: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6572: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6575: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   6578: invokevirtual 1551	com/tencent/mobileqq/mini/MiniAppInterface:getAuthorizeCenter	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/app/AuthorizeCenter;
    //   6581: astore 20
    //   6583: aload 20
    //   6585: ifnull +179 -> 6764
    //   6588: aload 21
    //   6590: invokestatic 1556	com/tencent/mobileqq/mini/app/AuthorizeCenter:isScopeNameValid	(Ljava/lang/String;)Z
    //   6593: ifeq +171 -> 6764
    //   6596: aload 20
    //   6598: invokevirtual 1559	com/tencent/mobileqq/mini/app/AuthorizeCenter:isAuthorizeSynchronized	()Z
    //   6601: istore 15
    //   6603: aload 21
    //   6605: ldc_w 1561
    //   6608: invokevirtual 1421	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6611: ifeq +59 -> 6670
    //   6614: iload 15
    //   6616: ifne +54 -> 6670
    //   6619: invokestatic 669	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   6622: aconst_null
    //   6623: aload_0
    //   6624: invokevirtual 1564	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getAppId	()Ljava/lang/String;
    //   6627: new 1566	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$13
    //   6630: dup
    //   6631: aload_0
    //   6632: aload 20
    //   6634: aload 21
    //   6636: aload_3
    //   6637: aload_1
    //   6638: iload 4
    //   6640: aload_2
    //   6641: invokespecial 1569	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$13:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/app/AuthorizeCenter;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;ILjava/lang/String;)V
    //   6644: invokevirtual 1573	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getAuthList	(LNS_COMM/COMM$StCommonExt;Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   6647: goto -5244 -> 1403
    //   6650: astore_2
    //   6651: aload_2
    //   6652: invokevirtual 463	java/lang/Throwable:printStackTrace	()V
    //   6655: aload_0
    //   6656: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6659: aload_3
    //   6660: aload_1
    //   6661: aconst_null
    //   6662: iload 4
    //   6664: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6667: goto -5264 -> 1403
    //   6670: aload 20
    //   6672: aload 21
    //   6674: invokevirtual 1576	com/tencent/mobileqq/mini/app/AuthorizeCenter:getAuthFlagFromAuthorize	(Ljava/lang/String;)I
    //   6677: istore 8
    //   6679: iload 8
    //   6681: istore 7
    //   6683: iload 8
    //   6685: iconst_1
    //   6686: if_icmpne +42 -> 6728
    //   6689: aload_0
    //   6690: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6693: invokevirtual 1579	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:apiAuthoritySilent	()Z
    //   6696: ifne +3876 -> 10572
    //   6699: aload_0
    //   6700: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6703: astore 20
    //   6705: iload 8
    //   6707: istore 7
    //   6709: aload_0
    //   6710: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6713: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6716: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   6719: invokestatic 1582	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:isAuthWhiteAppId	(Ljava/lang/String;)Z
    //   6722: ifeq +6 -> 6728
    //   6725: goto +3847 -> 10572
    //   6728: iload 7
    //   6730: iconst_2
    //   6731: if_icmpne +18 -> 6749
    //   6734: aload_0
    //   6735: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6738: aload_3
    //   6739: aload_1
    //   6740: aconst_null
    //   6741: iload 4
    //   6743: invokevirtual 1212	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6746: goto -5343 -> 1403
    //   6749: aload_0
    //   6750: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6753: aload_1
    //   6754: aload_2
    //   6755: aload_3
    //   6756: iload 4
    //   6758: invokevirtual 1586	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:reqAuthorize	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;I)V
    //   6761: goto -5358 -> 1403
    //   6764: aload_0
    //   6765: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6768: aload_3
    //   6769: aload_1
    //   6770: aconst_null
    //   6771: iload 4
    //   6773: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   6776: goto -5373 -> 1403
    //   6779: ldc 56
    //   6781: aload_1
    //   6782: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6785: ifeq +165 -> 6950
    //   6788: new 348	org/json/JSONObject
    //   6791: dup
    //   6792: aload_2
    //   6793: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6796: astore_1
    //   6797: ldc 150
    //   6799: iconst_2
    //   6800: new 398	java/lang/StringBuilder
    //   6803: dup
    //   6804: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   6807: ldc_w 1588
    //   6810: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6813: aload_1
    //   6814: invokevirtual 1061	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6817: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6820: invokestatic 516	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6823: new 705	android/content/Intent
    //   6826: dup
    //   6827: invokespecial 1589	android/content/Intent:<init>	()V
    //   6830: astore_2
    //   6831: aload_2
    //   6832: new 1591	android/content/ComponentName
    //   6835: dup
    //   6836: aload_0
    //   6837: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6840: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6843: getfield 577	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   6846: ldc_w 1593
    //   6849: invokespecial 1594	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   6852: invokevirtual 1598	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   6855: pop
    //   6856: aload_2
    //   6857: ldc_w 1600
    //   6860: aload_1
    //   6861: ldc_w 1600
    //   6864: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6867: invokevirtual 716	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   6870: pop
    //   6871: aload_2
    //   6872: ldc_w 1602
    //   6875: sipush 1008
    //   6878: invokevirtual 1605	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   6881: pop
    //   6882: aload_2
    //   6883: ldc_w 1607
    //   6886: iconst_2
    //   6887: invokevirtual 1605	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   6890: pop
    //   6891: aload_2
    //   6892: ldc_w 1609
    //   6895: aload_1
    //   6896: ldc_w 1611
    //   6899: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6902: invokevirtual 716	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   6905: pop
    //   6906: aload_2
    //   6907: ldc_w 1612
    //   6910: invokevirtual 1616	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   6913: pop
    //   6914: aload_0
    //   6915: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   6918: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   6921: getfield 577	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   6924: aload_2
    //   6925: invokevirtual 1114	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   6928: goto -5525 -> 1403
    //   6931: astore_1
    //   6932: ldc 150
    //   6934: iconst_1
    //   6935: aload_1
    //   6936: iconst_0
    //   6937: anewarray 816	java/lang/Object
    //   6940: invokestatic 1175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   6943: aload_1
    //   6944: invokevirtual 1213	org/json/JSONException:printStackTrace	()V
    //   6947: goto -5544 -> 1403
    //   6950: ldc 11
    //   6952: aload_1
    //   6953: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6956: ifeq +61 -> 7017
    //   6959: new 348	org/json/JSONObject
    //   6962: dup
    //   6963: aload_2
    //   6964: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6967: astore_2
    //   6968: new 1618	Wallet/FocusMpIdReq
    //   6971: dup
    //   6972: invokestatic 471	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   6975: invokevirtual 1184	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   6978: invokevirtual 1189	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   6981: aload_2
    //   6982: ldc_w 1620
    //   6985: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6988: invokespecial 1621	Wallet/FocusMpIdReq:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   6991: new 1623	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$14
    //   6994: dup
    //   6995: aload_0
    //   6996: aload_3
    //   6997: aload_1
    //   6998: iload 4
    //   7000: invokespecial 1624	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$14:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   7003: invokestatic 1199	zyb:a	(Lcom/qq/taf/jce/JceStruct;Lmqq/observer/BusinessObserver;)V
    //   7006: goto -5603 -> 1403
    //   7009: astore_1
    //   7010: aload_1
    //   7011: invokevirtual 1213	org/json/JSONException:printStackTrace	()V
    //   7014: goto -5611 -> 1403
    //   7017: ldc_w 1626
    //   7020: aload_1
    //   7021: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7024: ifeq +34 -> 7058
    //   7027: invokestatic 669	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   7030: aload_0
    //   7031: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7034: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   7037: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   7040: new 1628	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$15
    //   7043: dup
    //   7044: aload_0
    //   7045: aload_3
    //   7046: aload_1
    //   7047: iload 4
    //   7049: invokespecial 1629	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$15:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   7052: invokevirtual 1632	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getFormId	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   7055: goto -5652 -> 1403
    //   7058: ldc 121
    //   7060: aload_1
    //   7061: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7064: ifeq +149 -> 7213
    //   7067: aload_0
    //   7068: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7071: ifnonnull +7 -> 7078
    //   7074: ldc_w 524
    //   7077: areturn
    //   7078: new 348	org/json/JSONObject
    //   7081: dup
    //   7082: aload_2
    //   7083: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7086: ldc_w 1633
    //   7089: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7092: astore_2
    //   7093: invokestatic 573	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:g	()Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager;
    //   7096: aload_0
    //   7097: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7100: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   7103: getfield 577	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   7106: invokevirtual 581	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:getBindRuntimeLoader	(Landroid/content/Context;)Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoader;
    //   7109: astore_1
    //   7110: aload_1
    //   7111: ifnull +3467 -> 10578
    //   7114: aload_1
    //   7115: invokevirtual 587	com/tencent/mobileqq/minigame/manager/GameRuntimeLoader:getMiniGamePkg	()Lcom/tencent/mobileqq/minigame/gpkg/MiniGamePkg;
    //   7118: astore_1
    //   7119: aload_2
    //   7120: aload_1
    //   7121: invokestatic 1639	com/tencent/mobileqq/mini/entry/MiniAppUtils:checkNavigationAppIdListForMiniGame	(Ljava/lang/String;Lcom/tencent/mobileqq/minigame/gpkg/MiniGamePkg;)Z
    //   7124: istore 15
    //   7126: new 348	org/json/JSONObject
    //   7129: dup
    //   7130: invokespecial 987	org/json/JSONObject:<init>	()V
    //   7133: astore_1
    //   7134: aload_1
    //   7135: ldc_w 1641
    //   7138: iload 15
    //   7140: invokevirtual 1644	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   7143: pop
    //   7144: ldc 150
    //   7146: iconst_2
    //   7147: new 398	java/lang/StringBuilder
    //   7150: dup
    //   7151: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   7154: ldc_w 1646
    //   7157: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7160: aload_1
    //   7161: invokevirtual 1061	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7164: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7167: invokestatic 516	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7170: aload_1
    //   7171: invokevirtual 607	org/json/JSONObject:toString	()Ljava/lang/String;
    //   7174: areturn
    //   7175: astore_2
    //   7176: ldc 150
    //   7178: iconst_1
    //   7179: aload_2
    //   7180: iconst_0
    //   7181: anewarray 816	java/lang/Object
    //   7184: invokestatic 1175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   7187: aload_2
    //   7188: invokevirtual 1213	org/json/JSONException:printStackTrace	()V
    //   7191: goto -47 -> 7144
    //   7194: astore_1
    //   7195: ldc 150
    //   7197: iconst_1
    //   7198: aload_1
    //   7199: iconst_0
    //   7200: anewarray 816	java/lang/Object
    //   7203: invokestatic 1175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   7206: aload_1
    //   7207: invokevirtual 1213	org/json/JSONException:printStackTrace	()V
    //   7210: goto -5807 -> 1403
    //   7213: ldc_w 1648
    //   7216: aload_1
    //   7217: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7220: ifeq +222 -> 7442
    //   7223: invokestatic 471	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   7226: invokevirtual 1184	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   7229: astore_1
    //   7230: aload_1
    //   7231: instanceof 1539
    //   7234: ifeq +3150 -> 10384
    //   7237: aload_1
    //   7238: checkcast 1539	com/tencent/mobileqq/mini/MiniAppInterface
    //   7241: astore_1
    //   7242: aload_0
    //   7243: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7246: ifnull +7 -> 7253
    //   7249: aload_1
    //   7250: ifnonnull +26 -> 7276
    //   7253: aload_0
    //   7254: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7257: aload_3
    //   7258: ldc_w 1649
    //   7261: aconst_null
    //   7262: ldc_w 1650
    //   7265: invokestatic 1655	acfp:m	(I)Ljava/lang/String;
    //   7268: iload 4
    //   7270: invokevirtual 638	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7273: goto -5870 -> 1403
    //   7276: aload_1
    //   7277: aload_0
    //   7278: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7281: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   7284: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   7287: invokevirtual 1551	com/tencent/mobileqq/mini/MiniAppInterface:getAuthorizeCenter	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/app/AuthorizeCenter;
    //   7290: astore_1
    //   7291: aload_1
    //   7292: ifnull +121 -> 7413
    //   7295: ldc_w 1657
    //   7298: invokestatic 1556	com/tencent/mobileqq/mini/app/AuthorizeCenter:isScopeNameValid	(Ljava/lang/String;)Z
    //   7301: ifeq +112 -> 7413
    //   7304: aload_1
    //   7305: ldc_w 1657
    //   7308: invokevirtual 1576	com/tencent/mobileqq/mini/app/AuthorizeCenter:getAuthFlagFromAuthorize	(Ljava/lang/String;)I
    //   7311: istore 8
    //   7313: iload 8
    //   7315: istore 7
    //   7317: iload 8
    //   7319: iconst_1
    //   7320: if_icmpne +41 -> 7361
    //   7323: aload_0
    //   7324: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7327: invokevirtual 1579	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:apiAuthoritySilent	()Z
    //   7330: ifne +28 -> 7358
    //   7333: aload_0
    //   7334: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7337: astore_1
    //   7338: iload 8
    //   7340: istore 7
    //   7342: aload_0
    //   7343: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7346: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   7349: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   7352: invokestatic 1582	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:isAuthWhiteAppId	(Ljava/lang/String;)Z
    //   7355: ifeq +6 -> 7361
    //   7358: iconst_2
    //   7359: istore 7
    //   7361: iload 7
    //   7363: iconst_2
    //   7364: if_icmpne +20 -> 7384
    //   7367: aload_0
    //   7368: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7371: aload_3
    //   7372: ldc_w 1649
    //   7375: aconst_null
    //   7376: iload 4
    //   7378: invokevirtual 1212	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   7381: goto -5978 -> 1403
    //   7384: ldc 150
    //   7386: iconst_1
    //   7387: ldc_w 1659
    //   7390: invokestatic 611	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7393: aload_0
    //   7394: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7397: aload_3
    //   7398: ldc_w 1649
    //   7401: aconst_null
    //   7402: ldc_w 1659
    //   7405: iload 4
    //   7407: invokevirtual 638	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7410: goto -6007 -> 1403
    //   7413: aload_0
    //   7414: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7417: aload_3
    //   7418: ldc_w 1649
    //   7421: aconst_null
    //   7422: ldc_w 1661
    //   7425: iload 4
    //   7427: invokevirtual 638	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7430: ldc 150
    //   7432: iconst_1
    //   7433: ldc_w 1663
    //   7436: invokestatic 611	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7439: goto -6036 -> 1403
    //   7442: ldc_w 1665
    //   7445: aload_1
    //   7446: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7449: ifeq +213 -> 7662
    //   7452: new 348	org/json/JSONObject
    //   7455: dup
    //   7456: aload_2
    //   7457: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7460: astore 20
    //   7462: aload 20
    //   7464: ldc_w 1667
    //   7467: invokevirtual 1544	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   7470: astore_2
    //   7471: aload 20
    //   7473: ldc_w 1168
    //   7476: ldc_w 1170
    //   7479: invokevirtual 1125	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   7482: astore 20
    //   7484: aload_2
    //   7485: ifnull -6082 -> 1403
    //   7488: aload_2
    //   7489: invokevirtual 1358	org/json/JSONArray:length	()I
    //   7492: ifle -6089 -> 1403
    //   7495: aload_2
    //   7496: invokevirtual 1358	org/json/JSONArray:length	()I
    //   7499: anewarray 435	java/lang/String
    //   7502: astore 21
    //   7504: iconst_0
    //   7505: istore 7
    //   7507: iload 7
    //   7509: aload_2
    //   7510: invokevirtual 1358	org/json/JSONArray:length	()I
    //   7513: if_icmpge +23 -> 7536
    //   7516: aload 21
    //   7518: iload 7
    //   7520: aload_2
    //   7521: iload 7
    //   7523: invokevirtual 1360	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   7526: aastore
    //   7527: iload 7
    //   7529: iconst_1
    //   7530: iadd
    //   7531: istore 7
    //   7533: goto -26 -> 7507
    //   7536: invokestatic 573	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:g	()Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager;
    //   7539: aload_0
    //   7540: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7543: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   7546: getfield 577	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   7549: invokevirtual 581	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:getBindRuntimeLoader	(Landroid/content/Context;)Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoader;
    //   7552: astore_2
    //   7553: aload_2
    //   7554: ifnonnull +26 -> 7580
    //   7557: aload_1
    //   7558: aconst_null
    //   7559: invokestatic 617	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   7562: astore_2
    //   7563: aload_0
    //   7564: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7567: aload_3
    //   7568: aload_1
    //   7569: aload_2
    //   7570: iload 4
    //   7572: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   7575: aload_2
    //   7576: invokevirtual 607	org/json/JSONObject:toString	()Ljava/lang/String;
    //   7579: areturn
    //   7580: invokestatic 669	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   7583: aload_2
    //   7584: invokevirtual 1671	com/tencent/mobileqq/minigame/manager/GameRuntimeLoader:getGameInfoManager	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager;
    //   7587: invokevirtual 1674	com/tencent/mobileqq/minigame/manager/GameInfoManager:getAppId	()Ljava/lang/String;
    //   7590: aload 20
    //   7592: aload 21
    //   7594: new 1676	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$16
    //   7597: dup
    //   7598: aload_0
    //   7599: aload_2
    //   7600: aload_3
    //   7601: aload_1
    //   7602: iload 4
    //   7604: invokespecial 1679	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$16:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoader;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   7607: invokevirtual 1683	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getUserInfoOpenData	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   7610: goto -6207 -> 1403
    //   7613: astore_2
    //   7614: aload_0
    //   7615: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7618: aload_3
    //   7619: aload_1
    //   7620: aconst_null
    //   7621: iload 4
    //   7623: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   7626: ldc 150
    //   7628: iconst_1
    //   7629: new 398	java/lang/StringBuilder
    //   7632: dup
    //   7633: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   7636: ldc_w 1685
    //   7639: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7642: aload_1
    //   7643: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7646: ldc_w 1687
    //   7649: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7652: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7655: aload_2
    //   7656: invokestatic 301	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   7659: goto -6256 -> 1403
    //   7662: ldc 41
    //   7664: aload_1
    //   7665: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7668: ifeq +424 -> 8092
    //   7671: new 348	org/json/JSONObject
    //   7674: dup
    //   7675: aload_2
    //   7676: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7679: astore_2
    //   7680: aload_2
    //   7681: ldc_w 1689
    //   7684: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7687: astore 23
    //   7689: aload_2
    //   7690: ldc_w 1691
    //   7693: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7696: astore 24
    //   7698: aload_2
    //   7699: ldc_w 1693
    //   7702: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7705: astore 25
    //   7707: aload_2
    //   7708: ldc_w 1695
    //   7711: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7714: astore 21
    //   7716: aload_2
    //   7717: ldc_w 1697
    //   7720: invokevirtual 1700	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   7723: istore 7
    //   7725: ldc_w 1702
    //   7728: aload 24
    //   7730: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7733: ifne +33 -> 7766
    //   7736: ldc_w 1704
    //   7739: aload 24
    //   7741: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7744: ifne +22 -> 7766
    //   7747: aload_0
    //   7748: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7751: aload_3
    //   7752: aload_1
    //   7753: aconst_null
    //   7754: ldc_w 1706
    //   7757: iload 4
    //   7759: invokevirtual 638	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7762: ldc_w 524
    //   7765: areturn
    //   7766: ldc_w 1702
    //   7769: aload 23
    //   7771: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7774: ifne +33 -> 7807
    //   7777: ldc_w 1708
    //   7780: aload 23
    //   7782: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7785: ifne +22 -> 7807
    //   7788: aload_0
    //   7789: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7792: aload_3
    //   7793: aload_1
    //   7794: aconst_null
    //   7795: ldc_w 1710
    //   7798: iload 4
    //   7800: invokevirtual 638	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7803: ldc_w 524
    //   7806: areturn
    //   7807: iload 7
    //   7809: ifgt +22 -> 7831
    //   7812: aload_0
    //   7813: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7816: aload_3
    //   7817: aload_1
    //   7818: aconst_null
    //   7819: ldc_w 1712
    //   7822: iload 4
    //   7824: invokevirtual 638	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7827: ldc_w 524
    //   7830: areturn
    //   7831: aload 21
    //   7833: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7836: ifeq +22 -> 7858
    //   7839: aload_0
    //   7840: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7843: aload_3
    //   7844: aload_1
    //   7845: aconst_null
    //   7846: ldc_w 1714
    //   7849: iload 4
    //   7851: invokevirtual 638	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7854: ldc_w 524
    //   7857: areturn
    //   7858: new 1716	android/graphics/Paint
    //   7861: dup
    //   7862: invokespecial 1717	android/graphics/Paint:<init>	()V
    //   7865: astore 22
    //   7867: aload 22
    //   7869: iload 7
    //   7871: i2f
    //   7872: invokevirtual 1721	android/graphics/Paint:setTextSize	(F)V
    //   7875: aconst_null
    //   7876: astore 20
    //   7878: ldc_w 1702
    //   7881: aload 23
    //   7883: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7886: ifeq +68 -> 7954
    //   7889: ldc_w 1702
    //   7892: aload 24
    //   7894: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7897: ifeq +33 -> 7930
    //   7900: aload 25
    //   7902: iconst_0
    //   7903: invokestatic 1727	android/graphics/Typeface:create	(Ljava/lang/String;I)Landroid/graphics/Typeface;
    //   7906: astore_2
    //   7907: aload_2
    //   7908: ifnonnull +105 -> 8013
    //   7911: aload_0
    //   7912: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   7915: aload_3
    //   7916: aload_1
    //   7917: aconst_null
    //   7918: ldc_w 1729
    //   7921: iload 4
    //   7923: invokevirtual 638	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   7926: ldc_w 524
    //   7929: areturn
    //   7930: aload 20
    //   7932: astore_2
    //   7933: ldc_w 1704
    //   7936: aload 24
    //   7938: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7941: ifeq -34 -> 7907
    //   7944: aload 25
    //   7946: iconst_1
    //   7947: invokestatic 1727	android/graphics/Typeface:create	(Ljava/lang/String;I)Landroid/graphics/Typeface;
    //   7950: astore_2
    //   7951: goto -44 -> 7907
    //   7954: aload 20
    //   7956: astore_2
    //   7957: ldc_w 1708
    //   7960: aload 23
    //   7962: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7965: ifeq -58 -> 7907
    //   7968: ldc_w 1702
    //   7971: aload 24
    //   7973: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7976: ifeq +13 -> 7989
    //   7979: aload 25
    //   7981: iconst_2
    //   7982: invokestatic 1727	android/graphics/Typeface:create	(Ljava/lang/String;I)Landroid/graphics/Typeface;
    //   7985: astore_2
    //   7986: goto -79 -> 7907
    //   7989: aload 20
    //   7991: astore_2
    //   7992: ldc_w 1704
    //   7995: aload 24
    //   7997: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8000: ifeq -93 -> 7907
    //   8003: aload 25
    //   8005: iconst_3
    //   8006: invokestatic 1727	android/graphics/Typeface:create	(Ljava/lang/String;I)Landroid/graphics/Typeface;
    //   8009: astore_2
    //   8010: goto -103 -> 7907
    //   8013: new 1731	android/graphics/Rect
    //   8016: dup
    //   8017: invokespecial 1732	android/graphics/Rect:<init>	()V
    //   8020: astore_2
    //   8021: aload 22
    //   8023: aload 21
    //   8025: iconst_0
    //   8026: aload 21
    //   8028: invokevirtual 1733	java/lang/String:length	()I
    //   8031: aload_2
    //   8032: invokevirtual 1737	android/graphics/Paint:getTextBounds	(Ljava/lang/String;IILandroid/graphics/Rect;)V
    //   8035: aload_0
    //   8036: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8039: aload_3
    //   8040: aload_1
    //   8041: aconst_null
    //   8042: iload 4
    //   8044: invokevirtual 1212	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   8047: new 398	java/lang/StringBuilder
    //   8050: dup
    //   8051: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   8054: ldc_w 524
    //   8057: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8060: aload_2
    //   8061: invokevirtual 1740	android/graphics/Rect:height	()I
    //   8064: invokevirtual 688	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8067: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8070: astore_2
    //   8071: aload_2
    //   8072: areturn
    //   8073: astore_2
    //   8074: aload_0
    //   8075: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8078: aload_3
    //   8079: aload_1
    //   8080: aconst_null
    //   8081: ldc_w 1742
    //   8084: iload 4
    //   8086: invokevirtual 638	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   8089: goto -6686 -> 1403
    //   8092: ldc_w 1744
    //   8095: aload_1
    //   8096: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8099: ifeq +28 -> 8127
    //   8102: invokestatic 669	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   8105: aload_0
    //   8106: invokevirtual 1564	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:getAppId	()Ljava/lang/String;
    //   8109: new 1746	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$17
    //   8112: dup
    //   8113: aload_0
    //   8114: aload_3
    //   8115: aload_1
    //   8116: iload 4
    //   8118: invokespecial 1747	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$17:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   8121: invokevirtual 1749	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getUserInfoExtra	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   8124: goto -6721 -> 1403
    //   8127: ldc 23
    //   8129: aload_1
    //   8130: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8133: ifeq +323 -> 8456
    //   8136: aload_0
    //   8137: invokevirtual 1328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   8140: ifeq -6737 -> 1403
    //   8143: invokestatic 573	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:g	()Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager;
    //   8146: aload_0
    //   8147: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8150: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8153: getfield 577	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   8156: invokevirtual 581	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:getBindRuntimeLoader	(Landroid/content/Context;)Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoader;
    //   8159: astore 20
    //   8161: aload 20
    //   8163: ifnonnull +26 -> 8189
    //   8166: aload_1
    //   8167: aconst_null
    //   8168: invokestatic 617	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   8171: astore_2
    //   8172: aload_0
    //   8173: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8176: aload_3
    //   8177: aload_1
    //   8178: aload_2
    //   8179: iload 4
    //   8181: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   8184: aload_2
    //   8185: invokevirtual 607	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8188: areturn
    //   8189: aload 20
    //   8191: invokevirtual 1671	com/tencent/mobileqq/minigame/manager/GameRuntimeLoader:getGameInfoManager	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager;
    //   8194: invokevirtual 1753	com/tencent/mobileqq/minigame/manager/GameInfoManager:getLaunchOptions	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions;
    //   8197: astore 21
    //   8199: new 348	org/json/JSONObject
    //   8202: dup
    //   8203: invokespecial 987	org/json/JSONObject:<init>	()V
    //   8206: astore 22
    //   8208: new 348	org/json/JSONObject
    //   8211: dup
    //   8212: invokespecial 987	org/json/JSONObject:<init>	()V
    //   8215: astore 23
    //   8217: aload 21
    //   8219: getfield 1758	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:fromMiniAppId	Ljava/lang/String;
    //   8222: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8225: ifeq +170 -> 8395
    //   8228: aconst_null
    //   8229: astore_2
    //   8230: aload 23
    //   8232: ldc_w 1633
    //   8235: aload_2
    //   8236: invokevirtual 993	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8239: pop
    //   8240: aload 21
    //   8242: getfield 1761	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:navigateExtData	Ljava/lang/String;
    //   8245: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8248: ifeq +156 -> 8404
    //   8251: aconst_null
    //   8252: astore_2
    //   8253: aload 23
    //   8255: ldc_w 1763
    //   8258: aload_2
    //   8259: invokevirtual 993	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8262: pop
    //   8263: aload 22
    //   8265: ldc_w 1764
    //   8268: aload 21
    //   8270: getfield 1765	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:scene	I
    //   8273: invokestatic 1771	com/tencent/mobileqq/mini/appbrand/utils/AppBrandUtil:getWikiScene	(I)I
    //   8276: invokevirtual 1008	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   8279: pop
    //   8280: aload 22
    //   8282: ldc_w 1404
    //   8285: aload 21
    //   8287: getfield 1773	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:query	Lorg/json/JSONObject;
    //   8290: invokevirtual 993	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8293: pop
    //   8294: aload 21
    //   8296: getfield 1775	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:shareTicket	Ljava/lang/String;
    //   8299: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8302: ifeq +111 -> 8413
    //   8305: aconst_null
    //   8306: astore_2
    //   8307: aload 22
    //   8309: ldc_w 1299
    //   8312: aload_2
    //   8313: invokevirtual 993	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8316: pop
    //   8317: aload 22
    //   8319: ldc_w 1777
    //   8322: aload 23
    //   8324: invokevirtual 993	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8327: pop
    //   8328: aload 22
    //   8330: ldc_w 1779
    //   8333: aload 20
    //   8335: invokevirtual 1671	com/tencent/mobileqq/minigame/manager/GameRuntimeLoader:getGameInfoManager	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager;
    //   8338: invokevirtual 1782	com/tencent/mobileqq/minigame/manager/GameInfoManager:getExtendData	()Ljava/lang/String;
    //   8341: invokevirtual 993	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8344: pop
    //   8345: aload 22
    //   8347: ldc_w 1429
    //   8350: aload 21
    //   8352: getfield 1784	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:entryDataHash	Ljava/lang/String;
    //   8355: invokevirtual 993	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   8358: pop
    //   8359: ldc 150
    //   8361: iconst_1
    //   8362: new 398	java/lang/StringBuilder
    //   8365: dup
    //   8366: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   8369: ldc_w 1786
    //   8372: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8375: aload 22
    //   8377: invokevirtual 607	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8380: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8383: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8386: invokestatic 444	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   8389: aload 22
    //   8391: invokevirtual 607	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8394: areturn
    //   8395: aload 21
    //   8397: getfield 1758	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:fromMiniAppId	Ljava/lang/String;
    //   8400: astore_2
    //   8401: goto -171 -> 8230
    //   8404: aload 21
    //   8406: getfield 1761	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:navigateExtData	Ljava/lang/String;
    //   8409: astore_2
    //   8410: goto -157 -> 8253
    //   8413: aload 21
    //   8415: getfield 1775	com/tencent/mobileqq/minigame/manager/GameInfoManager$LaunchOptions:shareTicket	Ljava/lang/String;
    //   8418: astore_2
    //   8419: goto -112 -> 8307
    //   8422: astore_2
    //   8423: ldc 150
    //   8425: iconst_1
    //   8426: ldc_w 1788
    //   8429: aload_2
    //   8430: invokestatic 301	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   8433: aload_1
    //   8434: aconst_null
    //   8435: invokestatic 617	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   8438: astore_1
    //   8439: aload_3
    //   8440: iload 4
    //   8442: aload_1
    //   8443: invokevirtual 607	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8446: invokeinterface 622 3 0
    //   8451: aload_1
    //   8452: invokevirtual 607	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8455: areturn
    //   8456: ldc 53
    //   8458: aload_1
    //   8459: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8462: ifeq +648 -> 9110
    //   8465: new 348	org/json/JSONObject
    //   8468: dup
    //   8469: aload_2
    //   8470: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8473: astore_2
    //   8474: ldc 150
    //   8476: iconst_1
    //   8477: new 398	java/lang/StringBuilder
    //   8480: dup
    //   8481: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   8484: ldc_w 1790
    //   8487: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8490: aload_2
    //   8491: invokevirtual 1061	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8494: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8497: invokestatic 516	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8500: aload_2
    //   8501: ldc_w 712
    //   8504: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8507: astore 22
    //   8509: aload 22
    //   8511: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8514: ifeq +20 -> 8534
    //   8517: aload_0
    //   8518: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8521: aload_3
    //   8522: aload_1
    //   8523: aconst_null
    //   8524: ldc_w 1792
    //   8527: iload 4
    //   8529: invokevirtual 638	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   8532: aconst_null
    //   8533: areturn
    //   8534: aload_2
    //   8535: ldc_w 1794
    //   8538: iconst_0
    //   8539: invokevirtual 1131	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   8542: istore 15
    //   8544: aload 22
    //   8546: invokevirtual 1797	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   8549: astore 20
    //   8551: aload 20
    //   8553: invokestatic 1803	com/tencent/mobileqq/mini/apkg/DomainConfig:getDomainConfig	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/apkg/DomainConfig;
    //   8556: astore 21
    //   8558: iload 15
    //   8560: ifne +78 -> 8638
    //   8563: aload_0
    //   8564: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8567: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8570: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   8573: aload 20
    //   8575: iconst_0
    //   8576: invokevirtual 1806	com/tencent/mobileqq/mini/apkg/ApkgInfo:isValidPrefix	(Ljava/lang/String;Z)Z
    //   8579: ifne +20 -> 8599
    //   8582: aload_0
    //   8583: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8586: aload_3
    //   8587: aload_1
    //   8588: aconst_null
    //   8589: ldc_w 1808
    //   8592: iload 4
    //   8594: invokevirtual 638	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   8597: aconst_null
    //   8598: areturn
    //   8599: aload_0
    //   8600: getfield 415	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:openUrlDomainWhiteList	Ljava/util/ArrayList;
    //   8603: ifnull +35 -> 8638
    //   8606: aload_0
    //   8607: getfield 415	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:openUrlDomainWhiteList	Ljava/util/ArrayList;
    //   8610: aload 21
    //   8612: getfield 1811	com/tencent/mobileqq/mini/apkg/DomainConfig:host	Ljava/lang/String;
    //   8615: invokevirtual 1814	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   8618: ifne +20 -> 8638
    //   8621: aload_0
    //   8622: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8625: aload_3
    //   8626: aload_1
    //   8627: aconst_null
    //   8628: ldc_w 1816
    //   8631: iload 4
    //   8633: invokevirtual 638	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   8636: aconst_null
    //   8637: areturn
    //   8638: ldc_w 1818
    //   8641: aload 21
    //   8643: getfield 1811	com/tencent/mobileqq/mini/apkg/DomainConfig:host	Ljava/lang/String;
    //   8646: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8649: ifeq +438 -> 9087
    //   8652: ldc_w 1820
    //   8655: ldc_w 1822
    //   8658: invokestatic 1827	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   8661: astore_2
    //   8662: aload 22
    //   8664: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8667: ifne +402 -> 9069
    //   8670: aload_0
    //   8671: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8674: ifnull +395 -> 9069
    //   8677: aload_0
    //   8678: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8681: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8684: ifnull +385 -> 9069
    //   8687: invokestatic 1832	com/tencent/mobileqq/mini/mainpage/MainPageFragment:getUin	()Ljava/lang/String;
    //   8690: astore 21
    //   8692: aload 21
    //   8694: ifnonnull +1889 -> 10583
    //   8697: ldc_w 524
    //   8700: astore 20
    //   8702: aload 22
    //   8704: ldc_w 1834
    //   8707: aload 20
    //   8709: invokevirtual 1838	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8712: ldc_w 1840
    //   8715: invokestatic 1027	aqgz:getQQVersion	()Ljava/lang/String;
    //   8718: invokevirtual 1838	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8721: ldc_w 1842
    //   8724: ldc_w 1038
    //   8727: invokevirtual 1838	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8730: ldc_w 1844
    //   8733: getstatic 830	android/os/Build$VERSION:SDK_INT	I
    //   8736: invokestatic 541	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   8739: invokevirtual 1838	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8742: ldc_w 1846
    //   8745: invokestatic 1850	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   8748: invokestatic 1856	aqiw:K	(Landroid/content/Context;)Ljava/lang/String;
    //   8751: invokevirtual 1838	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8754: ldc_w 1858
    //   8757: aload_2
    //   8758: invokevirtual 1838	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8761: astore 22
    //   8763: invokestatic 471	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   8766: new 398	java/lang/StringBuilder
    //   8769: dup
    //   8770: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   8773: getstatic 1864	mqq/app/Constants$PropertiesKey:nickName	Lmqq/app/Constants$PropertiesKey;
    //   8776: invokevirtual 1865	mqq/app/Constants$PropertiesKey:toString	()Ljava/lang/String;
    //   8779: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8782: aload 21
    //   8784: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8787: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8790: invokevirtual 1868	com/tencent/common/app/BaseApplicationImpl:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   8793: astore 20
    //   8795: aload 20
    //   8797: astore_2
    //   8798: aload 20
    //   8800: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8803: ifeq +7 -> 8810
    //   8806: ldc_w 524
    //   8809: astore_2
    //   8810: aload 22
    //   8812: ldc_w 1870
    //   8815: aload_2
    //   8816: invokevirtual 1838	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8819: astore_2
    //   8820: invokestatic 806	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8823: ifeq +29 -> 8852
    //   8826: ldc 150
    //   8828: iconst_2
    //   8829: new 398	java/lang/StringBuilder
    //   8832: dup
    //   8833: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   8836: ldc_w 1872
    //   8839: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8842: aload_2
    //   8843: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8846: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8849: invokestatic 516	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8852: new 705	android/content/Intent
    //   8855: dup
    //   8856: aload_0
    //   8857: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8860: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8863: getfield 577	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   8866: ldc_w 707
    //   8869: invokespecial 710	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   8872: astore 20
    //   8874: aload 20
    //   8876: ldc_w 1874
    //   8879: ldc_w 1875
    //   8882: invokestatic 1655	acfp:m	(I)Ljava/lang/String;
    //   8885: invokevirtual 716	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8888: pop
    //   8889: aload 20
    //   8891: ldc_w 721
    //   8894: iconst_1
    //   8895: invokevirtual 1878	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   8898: pop
    //   8899: aload 20
    //   8901: ldc_w 1880
    //   8904: iconst_1
    //   8905: invokevirtual 1878	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   8908: pop
    //   8909: aload 20
    //   8911: ldc_w 712
    //   8914: aload_2
    //   8915: invokevirtual 716	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8918: pop
    //   8919: aload_0
    //   8920: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8923: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8926: getfield 577	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   8929: aload 20
    //   8931: invokevirtual 1114	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   8934: aload_0
    //   8935: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8938: aload_3
    //   8939: aload_1
    //   8940: aconst_null
    //   8941: iload 4
    //   8943: invokevirtual 1212	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   8946: aload_2
    //   8947: ldc_w 1882
    //   8950: invokevirtual 1421	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   8953: ifeq -7550 -> 1403
    //   8956: ldc 150
    //   8958: iconst_2
    //   8959: ldc_w 1884
    //   8962: invokestatic 516	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8965: new 718	android/os/Bundle
    //   8968: dup
    //   8969: invokespecial 719	android/os/Bundle:<init>	()V
    //   8972: astore_1
    //   8973: aload_1
    //   8974: ldc_w 1886
    //   8977: aload_0
    //   8978: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   8981: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   8984: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   8987: invokevirtual 1278	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   8990: invokestatic 1891	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   8993: ldc_w 1893
    //   8996: ldc_w 1895
    //   8999: aload_1
    //   9000: new 1897	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$18
    //   9003: dup
    //   9004: aload_0
    //   9005: invokespecial 1900	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$18:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;)V
    //   9008: invokevirtual 1904	com/tencent/mobileqq/qipc/QIPCClientHelper:callServer	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Leipc/EIPCResultCallback;)V
    //   9011: goto -7608 -> 1403
    //   9014: astore_1
    //   9015: ldc 150
    //   9017: iconst_1
    //   9018: aload_1
    //   9019: iconst_0
    //   9020: anewarray 816	java/lang/Object
    //   9023: invokestatic 1175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   9026: goto -7623 -> 1403
    //   9029: astore_2
    //   9030: ldc 150
    //   9032: iconst_1
    //   9033: new 398	java/lang/StringBuilder
    //   9036: dup
    //   9037: invokespecial 399	java/lang/StringBuilder:<init>	()V
    //   9040: ldc_w 1906
    //   9043: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9046: ldc_w 524
    //   9049: invokevirtual 405	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9052: invokevirtual 409	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9055: invokestatic 611	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   9058: aload_2
    //   9059: invokevirtual 1907	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   9062: ldc_w 524
    //   9065: astore_2
    //   9066: goto -404 -> 8662
    //   9069: aload_0
    //   9070: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9073: aload_3
    //   9074: aload_1
    //   9075: aconst_null
    //   9076: ldc_w 1909
    //   9079: iload 4
    //   9081: invokevirtual 638	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   9084: goto -7681 -> 1403
    //   9087: new 1911	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$19
    //   9090: dup
    //   9091: aload_0
    //   9092: aload_2
    //   9093: aload_3
    //   9094: aload_1
    //   9095: iload 4
    //   9097: invokespecial 1914	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$19:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lorg/json/JSONObject;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   9100: bipush 16
    //   9102: aconst_null
    //   9103: iconst_0
    //   9104: invokestatic 1918	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   9107: goto -7704 -> 1403
    //   9110: ldc 62
    //   9112: aload_1
    //   9113: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9116: ifeq +113 -> 9229
    //   9119: new 348	org/json/JSONObject
    //   9122: dup
    //   9123: aload_2
    //   9124: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9127: ldc_w 1920
    //   9130: iconst_0
    //   9131: invokevirtual 1131	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   9134: istore 15
    //   9136: aload_0
    //   9137: invokevirtual 1328	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:isMiniGameRuntime	()Z
    //   9140: ifeq -7737 -> 1403
    //   9143: invokestatic 573	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:g	()Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager;
    //   9146: aload_0
    //   9147: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9150: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9153: getfield 577	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:activity	Landroid/app/Activity;
    //   9156: invokevirtual 581	com/tencent/mobileqq/minigame/manager/GameRuntimeLoaderManager:getBindRuntimeLoader	(Landroid/content/Context;)Lcom/tencent/mobileqq/minigame/manager/GameRuntimeLoader;
    //   9159: astore_2
    //   9160: aload_2
    //   9161: ifnonnull +26 -> 9187
    //   9164: aload_1
    //   9165: aconst_null
    //   9166: invokestatic 617	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   9169: astore_2
    //   9170: aload_0
    //   9171: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9174: aload_3
    //   9175: aload_1
    //   9176: aload_2
    //   9177: iload 4
    //   9179: invokevirtual 305	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   9182: aload_2
    //   9183: invokevirtual 607	org/json/JSONObject:toString	()Ljava/lang/String;
    //   9186: areturn
    //   9187: aload_2
    //   9188: invokevirtual 1671	com/tencent/mobileqq/minigame/manager/GameRuntimeLoader:getGameInfoManager	()Lcom/tencent/mobileqq/minigame/manager/GameInfoManager;
    //   9191: invokevirtual 1924	com/tencent/mobileqq/minigame/manager/GameInfoManager:getMiniAppConfig	()Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9194: iload 15
    //   9196: invokestatic 1930	com/tencent/mobileqq/minigame/gpkg/GpkgManager:setOfflineResourceContent	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;Z)V
    //   9199: aload_0
    //   9200: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9203: aload_3
    //   9204: aload_1
    //   9205: aconst_null
    //   9206: iload 4
    //   9208: invokevirtual 1212	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   9211: goto -7808 -> 1403
    //   9214: astore_1
    //   9215: ldc 150
    //   9217: iconst_1
    //   9218: aload_1
    //   9219: iconst_0
    //   9220: anewarray 816	java/lang/Object
    //   9223: invokestatic 1175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   9226: goto -7823 -> 1403
    //   9229: ldc 95
    //   9231: aload_1
    //   9232: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9235: ifeq +178 -> 9413
    //   9238: aload_0
    //   9239: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9242: ifnull -7839 -> 1403
    //   9245: new 446	java/util/ArrayList
    //   9248: dup
    //   9249: invokespecial 447	java/util/ArrayList:<init>	()V
    //   9252: astore 20
    //   9254: new 348	org/json/JSONObject
    //   9257: dup
    //   9258: aload_2
    //   9259: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9262: ldc_w 479
    //   9265: invokevirtual 483	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   9268: ldc_w 1932
    //   9271: invokevirtual 1544	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   9274: astore_2
    //   9275: aload_2
    //   9276: ifnull +85 -> 9361
    //   9279: aload_2
    //   9280: invokevirtual 1358	org/json/JSONArray:length	()I
    //   9283: ifle +78 -> 9361
    //   9286: iconst_0
    //   9287: istore 7
    //   9289: iload 7
    //   9291: aload_2
    //   9292: invokevirtual 1358	org/json/JSONArray:length	()I
    //   9295: if_icmpge +66 -> 9361
    //   9298: aload_2
    //   9299: iload 7
    //   9301: invokevirtual 1936	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   9304: checkcast 348	org/json/JSONObject
    //   9307: astore 21
    //   9309: new 1938	com/tencent/mobileqq/mini/apkg/PluginInfo
    //   9312: dup
    //   9313: invokespecial 1939	com/tencent/mobileqq/mini/apkg/PluginInfo:<init>	()V
    //   9316: astore 22
    //   9318: aload 22
    //   9320: aload 21
    //   9322: ldc_w 1941
    //   9325: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9328: invokevirtual 1944	com/tencent/mobileqq/mini/apkg/PluginInfo:setPluginId	(Ljava/lang/String;)V
    //   9331: aload 22
    //   9333: aload 21
    //   9335: ldc_w 1946
    //   9338: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9341: invokevirtual 1949	com/tencent/mobileqq/mini/apkg/PluginInfo:setInnerVersion	(Ljava/lang/String;)V
    //   9344: aload 20
    //   9346: aload 22
    //   9348: invokevirtual 460	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   9351: pop
    //   9352: iload 7
    //   9354: iconst_1
    //   9355: iadd
    //   9356: istore 7
    //   9358: goto -69 -> 9289
    //   9361: invokestatic 669	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   9364: aload_0
    //   9365: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9368: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9371: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   9374: aload 20
    //   9376: new 1951	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$20
    //   9379: dup
    //   9380: aload_0
    //   9381: aload_3
    //   9382: aload_1
    //   9383: iload 4
    //   9385: invokespecial 1952	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$20:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   9388: invokevirtual 1955	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:verifyPlugin	(Ljava/lang/String;Ljava/util/ArrayList;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   9391: goto -7988 -> 1403
    //   9394: astore_2
    //   9395: aload_0
    //   9396: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9399: aload_3
    //   9400: aload_1
    //   9401: aconst_null
    //   9402: ldc_w 1957
    //   9405: iload 4
    //   9407: invokevirtual 638	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   9410: goto -8007 -> 1403
    //   9413: ldc 14
    //   9415: aload_1
    //   9416: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9419: ifeq +127 -> 9546
    //   9422: aload_0
    //   9423: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9426: ifnull -8023 -> 1403
    //   9429: aload_2
    //   9430: ifnull -8027 -> 1403
    //   9433: new 348	org/json/JSONObject
    //   9436: dup
    //   9437: aload_2
    //   9438: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9441: ldc_w 1959
    //   9444: invokevirtual 1544	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   9447: astore_2
    //   9448: new 446	java/util/ArrayList
    //   9451: dup
    //   9452: invokespecial 447	java/util/ArrayList:<init>	()V
    //   9455: astore 20
    //   9457: aload_2
    //   9458: ifnull +46 -> 9504
    //   9461: aload_2
    //   9462: invokevirtual 1358	org/json/JSONArray:length	()I
    //   9465: ifle +39 -> 9504
    //   9468: iconst_0
    //   9469: istore 7
    //   9471: iload 7
    //   9473: aload_2
    //   9474: invokevirtual 1358	org/json/JSONArray:length	()I
    //   9477: if_icmpge +27 -> 9504
    //   9480: aload 20
    //   9482: aload_2
    //   9483: iload 7
    //   9485: invokevirtual 1936	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   9488: invokestatic 1962	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   9491: invokevirtual 460	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   9494: pop
    //   9495: iload 7
    //   9497: iconst_1
    //   9498: iadd
    //   9499: istore 7
    //   9501: goto -30 -> 9471
    //   9504: invokestatic 669	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   9507: aload 20
    //   9509: new 1964	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$21
    //   9512: dup
    //   9513: aload_0
    //   9514: aload_3
    //   9515: aload_1
    //   9516: iload 4
    //   9518: invokespecial 1965	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$21:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   9521: invokevirtual 1968	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:batchGetContact	(Ljava/util/ArrayList;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   9524: goto -8121 -> 1403
    //   9527: astore_2
    //   9528: aload_0
    //   9529: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9532: aload_3
    //   9533: aload_1
    //   9534: aconst_null
    //   9535: ldc_w 1970
    //   9538: iload 4
    //   9540: invokevirtual 638	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   9543: goto -8140 -> 1403
    //   9546: ldc 26
    //   9548: aload_1
    //   9549: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9552: ifeq +60 -> 9612
    //   9555: new 348	org/json/JSONObject
    //   9558: dup
    //   9559: invokespecial 987	org/json/JSONObject:<init>	()V
    //   9562: astore_2
    //   9563: aload_2
    //   9564: ldc_w 365
    //   9567: aload_0
    //   9568: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9571: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9574: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   9577: getfield 1971	com/tencent/mobileqq/mini/apkg/ApkgInfo:appId	Ljava/lang/String;
    //   9580: invokestatic 1976	com/tencent/mobileqq/mini/report/MiniReportManager:getLaunchPerformance	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   9583: invokevirtual 993	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   9586: pop
    //   9587: aload_0
    //   9588: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9591: aload_3
    //   9592: aload_1
    //   9593: aload_2
    //   9594: iload 4
    //   9596: invokevirtual 1212	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   9599: goto -8196 -> 1403
    //   9602: astore 20
    //   9604: aload 20
    //   9606: invokevirtual 1213	org/json/JSONException:printStackTrace	()V
    //   9609: goto -22 -> 9587
    //   9612: ldc_w 1978
    //   9615: aload_1
    //   9616: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9619: ifeq +131 -> 9750
    //   9622: new 348	org/json/JSONObject
    //   9625: dup
    //   9626: invokespecial 987	org/json/JSONObject:<init>	()V
    //   9629: astore_2
    //   9630: aload_0
    //   9631: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9634: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9637: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   9640: astore 20
    //   9642: iconst_0
    //   9643: istore 16
    //   9645: iload 16
    //   9647: istore 15
    //   9649: aload 20
    //   9651: ifnull +64 -> 9715
    //   9654: iload 16
    //   9656: istore 15
    //   9658: aload 20
    //   9660: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9663: ifnull +52 -> 9715
    //   9666: iload 16
    //   9668: istore 15
    //   9670: aload 20
    //   9672: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9675: getfield 528	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9678: ifnull +37 -> 9715
    //   9681: iload 16
    //   9683: istore 15
    //   9685: aload 20
    //   9687: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9690: getfield 528	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9693: getfield 1433	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9696: ifnull +19 -> 9715
    //   9699: aload 20
    //   9701: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9704: getfield 528	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9707: getfield 1433	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9710: getfield 1981	com/tencent/mobileqq/mini/sdk/EntryModel:isAdmin	Z
    //   9713: istore 15
    //   9715: aload_2
    //   9716: ldc_w 1983
    //   9719: iload 15
    //   9721: invokevirtual 1644	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   9724: pop
    //   9725: aload_0
    //   9726: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9729: aload_3
    //   9730: aload_1
    //   9731: aload_2
    //   9732: iload 4
    //   9734: invokevirtual 1212	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   9737: goto -8334 -> 1403
    //   9740: astore 20
    //   9742: aload 20
    //   9744: invokevirtual 1213	org/json/JSONException:printStackTrace	()V
    //   9747: goto -22 -> 9725
    //   9750: ldc_w 1985
    //   9753: aload_1
    //   9754: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9757: ifeq +293 -> 10050
    //   9760: new 348	org/json/JSONObject
    //   9763: dup
    //   9764: aload_2
    //   9765: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9768: ldc_w 1429
    //   9771: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9774: astore_2
    //   9775: aload_0
    //   9776: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9779: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9782: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   9785: astore 20
    //   9787: new 348	org/json/JSONObject
    //   9790: dup
    //   9791: invokespecial 987	org/json/JSONObject:<init>	()V
    //   9794: astore 21
    //   9796: iconst_0
    //   9797: istore 16
    //   9799: iload 16
    //   9801: istore 15
    //   9803: aload 20
    //   9805: ifnull +64 -> 9869
    //   9808: iload 16
    //   9810: istore 15
    //   9812: aload 20
    //   9814: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9817: ifnull +52 -> 9869
    //   9820: iload 16
    //   9822: istore 15
    //   9824: aload 20
    //   9826: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9829: getfield 528	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9832: ifnull +37 -> 9869
    //   9835: iload 16
    //   9837: istore 15
    //   9839: aload 20
    //   9841: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9844: getfield 528	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9847: getfield 1433	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9850: ifnull +19 -> 9869
    //   9853: aload 20
    //   9855: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9858: getfield 528	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9861: getfield 1433	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9864: getfield 1981	com/tencent/mobileqq/mini/sdk/EntryModel:isAdmin	Z
    //   9867: istore 15
    //   9869: aload 21
    //   9871: ldc_w 1983
    //   9874: iload 15
    //   9876: invokevirtual 1644	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   9879: pop
    //   9880: aload 20
    //   9882: ifnull +152 -> 10034
    //   9885: aload 20
    //   9887: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9890: ifnull +144 -> 10034
    //   9893: aload 20
    //   9895: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9898: getfield 528	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9901: ifnull +133 -> 10034
    //   9904: aload 20
    //   9906: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9909: getfield 528	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9912: getfield 1433	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9915: ifnull +119 -> 10034
    //   9918: aload_2
    //   9919: ifnull +115 -> 10034
    //   9922: aload_2
    //   9923: aload 20
    //   9925: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9928: getfield 528	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9931: getfield 1433	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9934: invokevirtual 1438	com/tencent/mobileqq/mini/sdk/EntryModel:getEntryHash	()Ljava/lang/String;
    //   9937: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9940: ifeq +94 -> 10034
    //   9943: aload 20
    //   9945: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9948: getfield 528	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9951: getfield 1433	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9954: getfield 1988	com/tencent/mobileqq/mini/sdk/EntryModel:type	I
    //   9957: iconst_1
    //   9958: if_icmpne +76 -> 10034
    //   9961: invokestatic 669	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   9964: aconst_null
    //   9965: aload_0
    //   9966: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   9969: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   9972: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   9975: aload 20
    //   9977: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9980: getfield 528	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   9983: getfield 1433	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   9986: getfield 1991	com/tencent/mobileqq/mini/sdk/EntryModel:uin	J
    //   9989: invokestatic 1994	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   9992: aload 20
    //   9994: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   9997: getfield 528	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   10000: getfield 1433	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   10003: getfield 1997	com/tencent/mobileqq/mini/sdk/EntryModel:dwGroupClassExt	J
    //   10006: new 1999	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$22
    //   10009: dup
    //   10010: aload_0
    //   10011: aload 21
    //   10013: aload_3
    //   10014: aload_1
    //   10015: iload 4
    //   10017: invokespecial 2000	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$22:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lorg/json/JSONObject;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   10020: invokevirtual 2004	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getUserGroupInfo	(LNS_COMM/COMM$StCommonExt;Ljava/lang/String;Ljava/lang/String;JLcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   10023: goto -8620 -> 1403
    //   10026: astore_1
    //   10027: aload_1
    //   10028: invokevirtual 1213	org/json/JSONException:printStackTrace	()V
    //   10031: goto -8628 -> 1403
    //   10034: aload_0
    //   10035: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   10038: aload_3
    //   10039: aload_1
    //   10040: aload 21
    //   10042: iload 4
    //   10044: invokevirtual 1212	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   10047: goto -8644 -> 1403
    //   10050: ldc_w 2006
    //   10053: aload_1
    //   10054: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10057: ifeq +193 -> 10250
    //   10060: new 348	org/json/JSONObject
    //   10063: dup
    //   10064: aload_2
    //   10065: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10068: astore 20
    //   10070: aload 20
    //   10072: ldc_w 1429
    //   10075: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10078: astore_2
    //   10079: aload 20
    //   10081: ldc_w 712
    //   10084: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10087: astore 20
    //   10089: aload_0
    //   10090: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   10093: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   10096: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   10099: astore 21
    //   10101: aload 21
    //   10103: ifnull -8700 -> 1403
    //   10106: aload 21
    //   10108: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   10111: ifnull -8708 -> 1403
    //   10114: aload 21
    //   10116: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   10119: getfield 528	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   10122: ifnull -8719 -> 1403
    //   10125: aload 21
    //   10127: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   10130: getfield 528	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   10133: getfield 1433	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   10136: ifnull -8733 -> 1403
    //   10139: aload_2
    //   10140: ifnull -8737 -> 1403
    //   10143: aload_2
    //   10144: aload 21
    //   10146: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   10149: getfield 528	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   10152: getfield 1433	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   10155: invokevirtual 1438	com/tencent/mobileqq/mini/sdk/EntryModel:getEntryHash	()Ljava/lang/String;
    //   10158: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10161: ifeq -8758 -> 1403
    //   10164: aload 21
    //   10166: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   10169: getfield 528	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   10172: getfield 1433	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   10175: getfield 1981	com/tencent/mobileqq/mini/sdk/EntryModel:isAdmin	Z
    //   10178: ifeq -8775 -> 1403
    //   10181: aload 20
    //   10183: ifnull -8780 -> 1403
    //   10186: aload 20
    //   10188: ldc_w 2008
    //   10191: invokevirtual 2010	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   10194: ifeq -8791 -> 1403
    //   10197: aload 20
    //   10199: ldc_w 2008
    //   10202: aload 21
    //   10204: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   10207: getfield 528	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   10210: getfield 1433	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   10213: getfield 1991	com/tencent/mobileqq/mini/sdk/EntryModel:uin	J
    //   10216: invokestatic 1994	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   10219: invokevirtual 1838	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   10222: astore_2
    //   10223: aload_0
    //   10224: aload_0
    //   10225: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   10228: getfield 255	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:activityContext	Lcom/tencent/mobileqq/app/BaseActivity;
    //   10231: aload_2
    //   10232: aload_3
    //   10233: aload_1
    //   10234: iload 4
    //   10236: invokespecial 2012	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:startGroupBrowserActivity	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   10239: goto -8836 -> 1403
    //   10242: astore_1
    //   10243: aload_1
    //   10244: invokevirtual 1213	org/json/JSONException:printStackTrace	()V
    //   10247: goto -8844 -> 1403
    //   10250: ldc_w 2014
    //   10253: aload_1
    //   10254: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10257: ifne +13 -> 10270
    //   10260: ldc_w 2016
    //   10263: aload_1
    //   10264: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10267: ifeq +18 -> 10285
    //   10270: aload_0
    //   10271: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   10274: aload_3
    //   10275: aload_1
    //   10276: aconst_null
    //   10277: iload 4
    //   10279: invokevirtual 1212	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   10282: goto -8879 -> 1403
    //   10285: ldc 20
    //   10287: aload_1
    //   10288: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10291: ifeq +72 -> 10363
    //   10294: new 348	org/json/JSONObject
    //   10297: dup
    //   10298: aload_2
    //   10299: invokespecial 351	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10302: ldc_w 2018
    //   10305: invokevirtual 488	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10308: astore_2
    //   10309: aload_2
    //   10310: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10313: ifne -8910 -> 1403
    //   10316: invokestatic 669	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getInstance	()Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdUtil;
    //   10319: aload_0
    //   10320: getfield 249	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   10323: getfield 259	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   10326: getfield 264	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:appId	Ljava/lang/String;
    //   10329: aconst_null
    //   10330: aload_2
    //   10331: new 2020	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$23
    //   10334: dup
    //   10335: aload_0
    //   10336: aload_3
    //   10337: aload_1
    //   10338: iload 4
    //   10340: invokespecial 2021	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin$23:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)V
    //   10343: invokevirtual 2025	com/tencent/mobileqq/mini/reuse/MiniAppCmdUtil:getTcbTicket	(Ljava/lang/String;LNS_COMM/COMM$StCommonExt;Ljava/lang/String;Lcom/tencent/mobileqq/mini/reuse/MiniAppCmdInterface;)V
    //   10346: goto -8943 -> 1403
    //   10349: astore_1
    //   10350: ldc 150
    //   10352: iconst_1
    //   10353: ldc_w 2027
    //   10356: aload_1
    //   10357: invokestatic 301	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   10360: goto -8957 -> 1403
    //   10363: ldc 83
    //   10365: aload_1
    //   10366: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10369: ifeq -8966 -> 1403
    //   10372: aload_0
    //   10373: aload_3
    //   10374: aload_1
    //   10375: iload 4
    //   10377: invokespecial 2029	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/DataJsPlugin:doShareInvite	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;I)Z
    //   10380: pop
    //   10381: goto -8978 -> 1403
    //   10384: aconst_null
    //   10385: astore_1
    //   10386: goto -3144 -> 7242
    //   10389: aconst_null
    //   10390: astore 20
    //   10392: goto -3885 -> 6507
    //   10395: goto -4247 -> 6148
    //   10398: aconst_null
    //   10399: astore_2
    //   10400: goto -6177 -> 4223
    //   10403: iload 9
    //   10405: istore 14
    //   10407: goto -7028 -> 3379
    //   10410: aload 21
    //   10412: astore_2
    //   10413: goto -7766 -> 2647
    //   10416: iconst_0
    //   10417: istore 16
    //   10419: goto -9868 -> 551
    //   10422: ldc_w 955
    //   10425: astore 21
    //   10427: goto -9983 -> 444
    //   10430: iconst_m1
    //   10431: istore 8
    //   10433: iconst_m1
    //   10434: istore 7
    //   10436: iconst_m1
    //   10437: istore 11
    //   10439: iconst_0
    //   10440: istore 10
    //   10442: goto -7180 -> 3262
    //   10445: iload 7
    //   10447: istore 8
    //   10449: iload 7
    //   10451: iconst_m1
    //   10452: if_icmpne -6188 -> 4264
    //   10455: iconst_0
    //   10456: istore 8
    //   10458: goto -6194 -> 4264
    //   10461: ldc_w 524
    //   10464: areturn
    //   10465: iload 9
    //   10467: iconst_1
    //   10468: if_icmpne -5949 -> 4519
    //   10471: iconst_1
    //   10472: istore 7
    //   10474: aconst_null
    //   10475: astore_2
    //   10476: goto -6253 -> 4223
    //   10479: iload 9
    //   10481: iconst_3
    //   10482: if_icmpne +11 -> 10493
    //   10485: iconst_3
    //   10486: istore 7
    //   10488: aconst_null
    //   10489: astore_2
    //   10490: goto -6267 -> 4223
    //   10493: iload 9
    //   10495: iconst_4
    //   10496: if_icmpne -5847 -> 4649
    //   10499: iconst_4
    //   10500: istore 7
    //   10502: aconst_null
    //   10503: astore_2
    //   10504: goto -6281 -> 4223
    //   10507: iconst_0
    //   10508: istore 7
    //   10510: goto -6287 -> 4223
    //   10513: iconst_1
    //   10514: istore 16
    //   10516: goto -5377 -> 5139
    //   10519: iconst_0
    //   10520: istore 16
    //   10522: goto -5383 -> 5139
    //   10525: iconst_0
    //   10526: istore 17
    //   10528: goto -5340 -> 5188
    //   10531: bipush 12
    //   10533: istore 4
    //   10535: goto -5300 -> 5235
    //   10538: bipush 12
    //   10540: istore 4
    //   10542: goto -5108 -> 5434
    //   10545: iconst_1
    //   10546: istore 4
    //   10548: goto -4804 -> 5744
    //   10551: iconst_0
    //   10552: istore 4
    //   10554: goto -4810 -> 5744
    //   10557: iconst_0
    //   10558: istore 8
    //   10560: goto -4765 -> 5795
    //   10563: iload 11
    //   10565: iconst_1
    //   10566: iadd
    //   10567: istore 11
    //   10569: goto -4326 -> 6243
    //   10572: iconst_2
    //   10573: istore 7
    //   10575: goto -3847 -> 6728
    //   10578: aconst_null
    //   10579: astore_1
    //   10580: goto -3461 -> 7119
    //   10583: aload 21
    //   10585: astore 20
    //   10587: goto -1885 -> 8702
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	10590	0	this	DataJsPlugin
    //   0	10590	1	paramString1	String
    //   0	10590	2	paramString2	String
    //   0	10590	3	paramJsRuntime	JsRuntime
    //   0	10590	4	paramInt	int
    //   218	479	5	d	double
    //   260	10314	7	i	int
    //   256	10303	8	j	int
    //   237	10260	9	k	int
    //   301	10140	10	m	int
    //   318	10250	11	n	int
    //   3116	474	12	i1	int
    //   3113	457	13	i2	int
    //   3377	7029	14	i3	int
    //   211	9664	15	bool1	boolean
    //   549	9972	16	bool2	boolean
    //   5186	5341	17	bool3	boolean
    //   2165	299	18	l	long
    //   338	1685	20	localObject1	Object
    //   2043	3	20	localJSONException1	org.json.JSONException
    //   2264	7244	20	localObject2	Object
    //   9602	3	20	localJSONException2	org.json.JSONException
    //   9640	60	20	localApkgInfo1	ApkgInfo
    //   9740	3	20	localJSONException3	org.json.JSONException
    //   9785	801	20	localObject3	Object
    //   439	10145	21	localObject4	Object
    //   73	9274	22	localObject5	Object
    //   2250	6073	23	localObject6	Object
    //   2260	5736	24	str1	String
    //   2255	5749	25	str2	String
    //   2111	3403	26	str3	String
    //   2228	3251	27	str4	String
    //   2240	203	28	localApkgInfo2	ApkgInfo
    // Exception table:
    //   from	to	target	type
    //   646	881	906	java/lang/Exception
    //   884	903	906	java/lang/Exception
    //   1307	1322	1407	java/lang/Exception
    //   1326	1333	1407	java/lang/Exception
    //   1336	1374	1407	java/lang/Exception
    //   1455	1536	1539	org/json/JSONException
    //   1553	1619	1539	org/json/JSONException
    //   1732	1784	1845	java/lang/Exception
    //   1784	1814	1845	java/lang/Exception
    //   1818	1829	1845	java/lang/Exception
    //   1829	1842	1845	java/lang/Exception
    //   1867	1875	1845	java/lang/Exception
    //   1882	1934	1845	java/lang/Exception
    //   1937	2007	1845	java/lang/Exception
    //   2007	2028	1845	java/lang/Exception
    //   2028	2040	1845	java/lang/Exception
    //   2045	2050	1845	java/lang/Exception
    //   2053	2083	1845	java/lang/Exception
    //   2086	2113	1845	java/lang/Exception
    //   2116	2149	1845	java/lang/Exception
    //   2149	2167	1845	java/lang/Exception
    //   2169	2190	1845	java/lang/Exception
    //   2190	2242	1845	java/lang/Exception
    //   2275	2283	1845	java/lang/Exception
    //   2287	2298	1845	java/lang/Exception
    //   2302	2329	1845	java/lang/Exception
    //   2350	2358	1845	java/lang/Exception
    //   2366	2406	1845	java/lang/Exception
    //   2419	2427	1845	java/lang/Exception
    //   2431	2455	1845	java/lang/Exception
    //   2455	2496	1845	java/lang/Exception
    //   2499	2520	1845	java/lang/Exception
    //   2524	2533	1845	java/lang/Exception
    //   2536	2557	1845	java/lang/Exception
    //   2568	2589	1845	java/lang/Exception
    //   2597	2617	1845	java/lang/Exception
    //   2620	2641	1845	java/lang/Exception
    //   2647	2730	1845	java/lang/Exception
    //   2730	2864	1845	java/lang/Exception
    //   2867	2890	1845	java/lang/Exception
    //   2893	2936	1845	java/lang/Exception
    //   2950	2961	1845	java/lang/Exception
    //   2964	3004	1845	java/lang/Exception
    //   2007	2028	2043	org/json/JSONException
    //   3209	3239	3427	org/json/JSONException
    //   3262	3279	3427	org/json/JSONException
    //   3279	3289	3427	org/json/JSONException
    //   3292	3302	3427	org/json/JSONException
    //   3305	3315	3427	org/json/JSONException
    //   3318	3327	3427	org/json/JSONException
    //   3842	3897	3942	org/json/JSONException
    //   3901	3923	3942	org/json/JSONException
    //   3923	3939	3942	org/json/JSONException
    //   3961	3977	3942	org/json/JSONException
    //   3980	4037	3942	org/json/JSONException
    //   4040	4056	3942	org/json/JSONException
    //   4068	4096	4125	org/json/JSONException
    //   4110	4122	4125	org/json/JSONException
    //   4174	4183	4796	org/json/JSONException
    //   4186	4207	4796	org/json/JSONException
    //   4223	4261	4796	org/json/JSONException
    //   4264	4287	4796	org/json/JSONException
    //   4287	4318	4796	org/json/JSONException
    //   4318	4328	4796	org/json/JSONException
    //   4332	4350	4796	org/json/JSONException
    //   4350	4380	4796	org/json/JSONException
    //   4384	4399	4796	org/json/JSONException
    //   4404	4442	4796	org/json/JSONException
    //   4442	4466	4796	org/json/JSONException
    //   4466	4488	4796	org/json/JSONException
    //   4488	4516	4796	org/json/JSONException
    //   4528	4537	4796	org/json/JSONException
    //   4541	4613	4796	org/json/JSONException
    //   4618	4644	4796	org/json/JSONException
    //   4655	4687	4796	org/json/JSONException
    //   4691	4703	4796	org/json/JSONException
    //   4706	4720	4796	org/json/JSONException
    //   4723	4749	4796	org/json/JSONException
    //   4761	4770	4796	org/json/JSONException
    //   4778	4793	4796	org/json/JSONException
    //   4815	4844	4796	org/json/JSONException
    //   4847	4865	4796	org/json/JSONException
    //   4868	4922	4796	org/json/JSONException
    //   4925	4949	4796	org/json/JSONException
    //   4952	4977	4796	org/json/JSONException
    //   4977	5001	4796	org/json/JSONException
    //   5001	5032	4796	org/json/JSONException
    //   5036	5061	4796	org/json/JSONException
    //   5061	5085	4796	org/json/JSONException
    //   5085	5116	4796	org/json/JSONException
    //   5120	5136	4796	org/json/JSONException
    //   5139	5185	4796	org/json/JSONException
    //   5188	5196	4796	org/json/JSONException
    //   5206	5226	4796	org/json/JSONException
    //   5235	5317	4796	org/json/JSONException
    //   5320	5352	4796	org/json/JSONException
    //   5356	5392	4796	org/json/JSONException
    //   5395	5417	4796	org/json/JSONException
    //   5417	5425	4796	org/json/JSONException
    //   5434	5461	4796	org/json/JSONException
    //   5464	5493	4796	org/json/JSONException
    //   5502	5529	4796	org/json/JSONException
    //   5557	5576	5815	org/json/JSONException
    //   5587	5596	5815	org/json/JSONException
    //   5609	5632	5815	org/json/JSONException
    //   5632	5655	5815	org/json/JSONException
    //   5655	5686	5815	org/json/JSONException
    //   5686	5741	5815	org/json/JSONException
    //   5744	5792	5815	org/json/JSONException
    //   5800	5812	5815	org/json/JSONException
    //   5871	5886	5815	org/json/JSONException
    //   5889	5904	5815	org/json/JSONException
    //   5907	5936	5815	org/json/JSONException
    //   5939	5946	5815	org/json/JSONException
    //   5956	5963	5815	org/json/JSONException
    //   5967	5982	5815	org/json/JSONException
    //   5985	5994	5815	org/json/JSONException
    //   5997	6029	5815	org/json/JSONException
    //   6033	6059	5815	org/json/JSONException
    //   6072	6082	5815	org/json/JSONException
    //   6114	6132	6223	org/json/JSONException
    //   6148	6160	6223	org/json/JSONException
    //   6169	6174	6223	org/json/JSONException
    //   6179	6184	6223	org/json/JSONException
    //   6189	6194	6223	org/json/JSONException
    //   6199	6204	6223	org/json/JSONException
    //   6204	6220	6223	org/json/JSONException
    //   6243	6260	6223	org/json/JSONException
    //   6260	6270	6223	org/json/JSONException
    //   6273	6283	6223	org/json/JSONException
    //   6286	6296	6223	org/json/JSONException
    //   6299	6309	6223	org/json/JSONException
    //   6315	6331	6223	org/json/JSONException
    //   6334	6360	6223	org/json/JSONException
    //   6365	6379	6223	org/json/JSONException
    //   6384	6398	6223	org/json/JSONException
    //   6403	6417	6223	org/json/JSONException
    //   6422	6436	6223	org/json/JSONException
    //   6436	6452	6223	org/json/JSONException
    //   6455	6471	6223	org/json/JSONException
    //   6527	6547	6650	java/lang/Throwable
    //   6551	6566	6650	java/lang/Throwable
    //   6566	6583	6650	java/lang/Throwable
    //   6588	6614	6650	java/lang/Throwable
    //   6619	6647	6650	java/lang/Throwable
    //   6670	6679	6650	java/lang/Throwable
    //   6689	6705	6650	java/lang/Throwable
    //   6709	6725	6650	java/lang/Throwable
    //   6734	6746	6650	java/lang/Throwable
    //   6749	6761	6650	java/lang/Throwable
    //   6764	6776	6650	java/lang/Throwable
    //   6788	6928	6931	org/json/JSONException
    //   6959	7006	7009	org/json/JSONException
    //   7134	7144	7175	org/json/JSONException
    //   7078	7110	7194	org/json/JSONException
    //   7114	7119	7194	org/json/JSONException
    //   7119	7134	7194	org/json/JSONException
    //   7144	7175	7194	org/json/JSONException
    //   7176	7191	7194	org/json/JSONException
    //   7452	7484	7613	org/json/JSONException
    //   7488	7504	7613	org/json/JSONException
    //   7507	7527	7613	org/json/JSONException
    //   7536	7553	7613	org/json/JSONException
    //   7557	7580	7613	org/json/JSONException
    //   7580	7610	7613	org/json/JSONException
    //   7671	7762	8073	org/json/JSONException
    //   7766	7803	8073	org/json/JSONException
    //   7812	7827	8073	org/json/JSONException
    //   7831	7854	8073	org/json/JSONException
    //   7858	7875	8073	org/json/JSONException
    //   7878	7907	8073	org/json/JSONException
    //   7911	7926	8073	org/json/JSONException
    //   7933	7951	8073	org/json/JSONException
    //   7957	7986	8073	org/json/JSONException
    //   7992	8010	8073	org/json/JSONException
    //   8013	8071	8073	org/json/JSONException
    //   8217	8228	8422	org/json/JSONException
    //   8230	8251	8422	org/json/JSONException
    //   8253	8305	8422	org/json/JSONException
    //   8307	8395	8422	org/json/JSONException
    //   8395	8401	8422	org/json/JSONException
    //   8404	8410	8422	org/json/JSONException
    //   8413	8419	8422	org/json/JSONException
    //   8465	8532	9014	java/lang/Throwable
    //   8534	8558	9014	java/lang/Throwable
    //   8563	8597	9014	java/lang/Throwable
    //   8599	8636	9014	java/lang/Throwable
    //   8638	8652	9014	java/lang/Throwable
    //   8652	8662	9014	java/lang/Throwable
    //   8662	8692	9014	java/lang/Throwable
    //   8702	8795	9014	java/lang/Throwable
    //   8798	8806	9014	java/lang/Throwable
    //   8810	8852	9014	java/lang/Throwable
    //   8852	9011	9014	java/lang/Throwable
    //   9030	9062	9014	java/lang/Throwable
    //   9069	9084	9014	java/lang/Throwable
    //   9087	9107	9014	java/lang/Throwable
    //   8652	8662	9029	java/io/UnsupportedEncodingException
    //   9119	9160	9214	java/lang/Throwable
    //   9164	9187	9214	java/lang/Throwable
    //   9187	9211	9214	java/lang/Throwable
    //   9245	9275	9394	java/lang/Throwable
    //   9279	9286	9394	java/lang/Throwable
    //   9289	9352	9394	java/lang/Throwable
    //   9361	9391	9394	java/lang/Throwable
    //   9433	9457	9527	java/lang/Throwable
    //   9461	9468	9527	java/lang/Throwable
    //   9471	9495	9527	java/lang/Throwable
    //   9504	9524	9527	java/lang/Throwable
    //   9563	9587	9602	org/json/JSONException
    //   9630	9642	9740	org/json/JSONException
    //   9658	9666	9740	org/json/JSONException
    //   9670	9681	9740	org/json/JSONException
    //   9685	9715	9740	org/json/JSONException
    //   9715	9725	9740	org/json/JSONException
    //   9760	9796	10026	org/json/JSONException
    //   9812	9820	10026	org/json/JSONException
    //   9824	9835	10026	org/json/JSONException
    //   9839	9869	10026	org/json/JSONException
    //   9869	9880	10026	org/json/JSONException
    //   9885	9918	10026	org/json/JSONException
    //   9922	10023	10026	org/json/JSONException
    //   10034	10047	10026	org/json/JSONException
    //   10060	10101	10242	org/json/JSONException
    //   10106	10139	10242	org/json/JSONException
    //   10143	10181	10242	org/json/JSONException
    //   10186	10239	10242	org/json/JSONException
    //   10294	10346	10349	java/lang/Throwable
  }
  
  public void login(tzd paramtzd)
  {
    if (paramtzd == null) {
      return;
    }
    ThreadManager.excute(new DataJsPlugin.26(this, paramtzd), 16, null, false);
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
    getOpenUrlDomainWhiteList();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.mGgtAppReceiver != null) && (this.jsPluginEngine != null) && (this.jsPluginEngine.getActivityContext() != null))
    {
      this.mGgtAppReceiver.unregister(this.jsPluginEngine.getActivityContext());
      this.mGgtAppReceiver = null;
    }
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin
 * JD-Core Version:    0.7.0.1
 */