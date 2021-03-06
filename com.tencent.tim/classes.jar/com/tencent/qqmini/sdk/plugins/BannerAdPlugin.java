package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBannerAdView;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.manager.BannerAdViolationManager;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.utils.AdUtil;
import com.tencent.qqmini.sdk.utils.BannerAdPosInfo;
import com.tencent.qqmini.sdk.utils.MiniSDKConst.AdConst;
import com.tencent.qqmini.sdk.utils.ViewUtils;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class BannerAdPlugin
  extends BaseJsPlugin
{
  private static final HashMap<Integer, String> AD_ERROR_MSG = MiniSDKConst.AdConst.CodeMsgMap;
  public static final String API_AD_CREATE_BANNER_AD = "createBannerAd";
  public static final String API_AD_OPERATE_BANNER_AD = "operateBannerAd";
  public static final String API_AD_UPDATE_BANNER_AD_SIZE = "updateBannerAdSize";
  public static final String EVENT_BANNER_AD_SHOW_DONE = "onBannerAdShowDone";
  public static final String EVENT_BANNER_AD_STATE_CHANGE = "onBannerAdStateChange";
  private static final String TAG = "BannerAdPlugin";
  private FrameLayout mBannerAdContainer;
  private BannerAdPosInfo mBannerAdPosInfo;
  private AdProxy.AbsBannerAdView mBannerAdView;
  private float mGameDensity = -1.0F;
  private int mGameHeight = 0;
  private int mGameWidth = 0;
  private boolean mHasNewAd = false;
  
  private void bannerErrorStateCallbackDelay(RequestEvent paramRequestEvent, int paramInt1, String paramString, int paramInt2)
  {
    AppBrandTask.runTaskOnUiThreadDelay(new BannerAdPlugin.7(this, paramString, paramInt1, paramRequestEvent), paramInt2);
  }
  
  private void destroyBannerAd()
  {
    try
    {
      if (this.mBannerAdContainer != null) {
        this.mBannerAdContainer.removeAllViews();
      }
      if (this.mBannerAdView != null)
      {
        this.mBannerAdView.destroy(this.mMiniAppContext.getAttachedActivity());
        this.mBannerAdView = null;
      }
      this.mBannerAdContainer = null;
      this.mBannerAdPosInfo = null;
      return;
    }
    finally {}
  }
  
  private int gameDpTopx(float paramFloat)
  {
    return Math.round(this.mGameDensity * paramFloat);
  }
  
  private void informJs(RequestEvent paramRequestEvent, JSONObject paramJSONObject, String paramString)
  {
    paramRequestEvent.jsService.evaluateSubscribeJS(paramString, paramJSONObject.toString(), 0);
  }
  
  private boolean makeSureContainerAdded()
  {
    if ((this.mBannerAdContainer != null) && (this.mBannerAdContainer.getParent() != null)) {
      return true;
    }
    ViewGroup localViewGroup = (ViewGroup)this.mMiniAppContext.getAttachedActivity().getWindow().getDecorView();
    if (localViewGroup == null)
    {
      QMLog.e("BannerAdPlugin", "makeSureContainerAdded, root view is null");
      return false;
    }
    if (this.mBannerAdContainer == null) {
      this.mBannerAdContainer = new FrameLayout(this.mMiniAppContext.getAttachedActivity());
    }
    if ((localViewGroup instanceof FrameLayout)) {
      localViewGroup.addView(this.mBannerAdContainer, new FrameLayout.LayoutParams(-1, -1));
    }
    for (;;)
    {
      return true;
      if ((localViewGroup instanceof RelativeLayout)) {
        localViewGroup.addView(this.mBannerAdContainer, new RelativeLayout.LayoutParams(-1, -1));
      }
    }
  }
  
  private void reportBannerAd(String paramString)
  {
    QMLog.i("BannerAdPlugin", "reportBannerAd reportUrl = " + paramString);
    if ((TextUtils.isEmpty(paramString)) || (!URLUtil.isNetworkUrl(paramString))) {
      return;
    }
    ThreadManager.executeOnNetworkIOThreadPool(new BannerAdPlugin.5(this, paramString));
  }
  
  private boolean showBannerAd()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        if ((this.mBannerAdView == null) || (this.mBannerAdView.getView() == null) || (this.mBannerAdPosInfo == null))
        {
          QMLog.e("BannerAdPlugin", "showBannerAd error, data is null");
          return bool;
        }
        if (!this.mBannerAdPosInfo.isValid())
        {
          QMLog.e("BannerAdPlugin", "showBannerAd error, adPosInfo is invalid." + this.mBannerAdPosInfo);
          continue;
        }
        if (this.mMiniAppContext == null) {
          break label104;
        }
      }
      finally {}
      if (this.mMiniAppContext.getAttachedActivity() == null)
      {
        label104:
        QMLog.e("BannerAdPlugin", "showBannerAd error, mGdtBannerView == null");
      }
      else
      {
        makeSureContainerAdded();
        if ((!this.mHasNewAd) && (this.mBannerAdContainer.getChildCount() > 0))
        {
          this.mBannerAdContainer.setVisibility(0);
          BannerAdViolationManager.scheduleViolationDetectTask(this.mApkgInfo.appId, this.mBannerAdView.getAdID(), this.mBannerAdView.getView());
          bool = true;
        }
        else
        {
          this.mBannerAdContainer.removeAllViews();
          if ((this.mBannerAdView != null) && (this.mBannerAdView.getView() != null))
          {
            Object localObject2 = new FrameLayout.LayoutParams(gameDpTopx(this.mBannerAdPosInfo.mAdRealWidth), gameDpTopx(this.mBannerAdPosInfo.mAdRealHeight));
            ((FrameLayout.LayoutParams)localObject2).leftMargin = gameDpTopx(this.mBannerAdPosInfo.mAdLeft);
            ((FrameLayout.LayoutParams)localObject2).topMargin = gameDpTopx(this.mBannerAdPosInfo.mAdTop);
            this.mBannerAdContainer.addView(this.mBannerAdView.getView(), (ViewGroup.LayoutParams)localObject2);
            this.mBannerAdContainer.setVisibility(0);
            localObject2 = this.mBannerAdView.getReportUrl();
            if ((this.mHasNewAd) && (this.mBannerAdPosInfo != null) && (!TextUtils.isEmpty((CharSequence)localObject2)))
            {
              reportBannerAd((String)localObject2);
              this.mBannerAdView.onExposure();
            }
            BannerAdViolationManager.scheduleViolationDetectTask(this.mApkgInfo.appId, this.mBannerAdView.getAdID(), this.mBannerAdView.getView());
            this.mHasNewAd = false;
            bool = true;
          }
          else
          {
            QMLog.e("BannerAdPlugin", "showBannerAd error, mGdtBannerView is null");
          }
        }
      }
    }
  }
  
  private void updateBannerSize(RequestEvent paramRequestEvent)
  {
    int n = 1;
    int i;
    int j;
    float f1;
    BannerAdPosInfo localBannerAdPosInfo;
    int k;
    int m;
    float f2;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      if (localJSONObject.has("left"))
      {
        i = localJSONObject.getInt("left");
        j = 1;
        break label541;
      }
      if (localJSONObject.has("top"))
      {
        i = localJSONObject.getInt("top");
        j = 2;
        break label541;
      }
      if (!localJSONObject.has("width")) {
        break label535;
      }
      f1 = ViewUtils.getDensity();
      i = ViewUtils.getScreenWidth();
      j = ViewUtils.getScreenHeight();
      localBannerAdPosInfo = this.mBannerAdPosInfo;
      Activity localActivity = this.mMiniAppContext.getAttachedActivity();
      if (localActivity == null) {
        break label523;
      }
      int i1 = AppLoaderFactory.g().getMiniAppEnv().getContext().getResources().getConfiguration().orientation;
      initActivitySize(localActivity);
      if (this.mGameDensity > 0.0F) {
        f1 = this.mGameDensity;
      }
      if (this.mGameWidth > 0) {
        i = this.mGameWidth;
      }
      k = i;
      m = i1;
      f2 = f1;
      if (this.mGameHeight > 0)
      {
        j = this.mGameHeight;
        f2 = f1;
        m = i1;
        k = i;
      }
      i1 = localJSONObject.getInt("width");
      i = BannerAdPosInfo.calculateLegalWidth(i1, m, f2, k, j);
      if ((localBannerAdPosInfo == null) || (i1 == localBannerAdPosInfo.mAdWidth) || (i != localBannerAdPosInfo.mAdRealWidth)) {
        break label517;
      }
      localBannerAdPosInfo.mAdWidth = i1;
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("state", "resize");
        localJSONObject.put("width", localBannerAdPosInfo.mAdRealWidth);
        localJSONObject.put("height", localBannerAdPosInfo.mAdRealHeight);
        informJs(paramRequestEvent, localJSONObject, "onBannerAdStateChange");
        return;
      }
      catch (JSONException paramRequestEvent)
      {
        QMLog.e("BannerAdPlugin", "updateBannerAd informJs error", paramRequestEvent);
        return;
      }
      if (i >= 0) {
        break label372;
      }
    }
    catch (JSONException paramRequestEvent)
    {
      QMLog.e("BannerAdPlugin", "handle updateBannerAdSize parse json error", paramRequestEvent);
      return;
    }
    label342:
    bannerErrorStateCallbackDelay(paramRequestEvent, 1003, (String)AD_ERROR_MSG.get(Integer.valueOf(1003)), 0);
    return;
    label372:
    if ((j != -1) && (this.mIsMiniGame))
    {
      localBannerAdPosInfo = this.mBannerAdPosInfo;
      if (localBannerAdPosInfo != null) {
        switch (j)
        {
        }
      }
    }
    for (;;)
    {
      if (k == 0)
      {
        if (QMLog.isColorLevel())
        {
          QMLog.i("BannerAdPlugin", "updateBannerAd no need to resize");
          return;
          if (localBannerAdPosInfo.mAdLeft == i) {
            break label558;
          }
          k = 1;
          break label555;
          k = n;
          if (localBannerAdPosInfo.mAdTop != i) {
            continue;
          }
          k = 0;
          continue;
          k = n;
          if (localBannerAdPosInfo.mAdRealWidth != i) {
            continue;
          }
          k = 0;
        }
      }
      else
      {
        AppBrandTask.runTaskOnUiThread(new BannerAdPlugin.6(this, j, i, paramRequestEvent));
        return;
        label517:
        j = 3;
        break label541;
        label523:
        m = 1;
        k = i;
        f2 = f1;
        break;
        label535:
        i = -1;
        j = -1;
        label541:
        if (j != -1) {
          break label342;
        }
      }
      return;
      k = n;
    }
    for (;;)
    {
      label555:
      break;
      label558:
      k = 0;
    }
  }
  
  @JsEvent({"createBannerAd"})
  public String createBannerAd(RequestEvent paramRequestEvent)
  {
    Object localObject1;
    int k;
    for (;;)
    {
      label202:
      try
      {
        QMLog.i("BannerAdPlugin", "receive createBannerAd event");
        try
        {
          localObject1 = BannerAdPosInfo.parseBannerAdPosInfoFromJson(paramRequestEvent.jsonParams);
          if (localObject1 != null) {
            continue;
          }
          bannerErrorStateCallbackDelay(paramRequestEvent, 1001, (String)AD_ERROR_MSG.get(Integer.valueOf(1001)), 300);
          QMLog.i("BannerAdPlugin", "handle createBannerAd error params, " + paramRequestEvent.jsonParams);
          paramRequestEvent = "";
        }
        catch (Exception localException)
        {
          String str4;
          float f;
          int i;
          int j;
          String str3;
          Object localObject2;
          BannerAdPosInfo localBannerAdPosInfo;
          String str5;
          Object localObject4;
          localObject1 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null);
          if (localObject1 == null) {
            continue;
          }
          localObject1 = ((JSONObject)localObject1).toString();
          bannerErrorStateCallbackDelay(paramRequestEvent, 1003, (String)AD_ERROR_MSG.get(Integer.valueOf(1003)), 0);
          QMLog.i("BannerAdPlugin", "handle createBannerAd parse json error" + paramRequestEvent.jsonParams, localException);
          if (localObject1 == null) {
            continue;
          }
          paramRequestEvent = (RequestEvent)localObject1;
          continue;
          localObject1 = "";
          continue;
        }
        return paramRequestEvent;
      }
      finally {}
      str4 = LoginManager.getInstance().getAccount();
      f = ViewUtils.getDensity();
      i = ViewUtils.getScreenWidth();
      j = ViewUtils.getScreenWidth();
      str3 = this.mApkgInfo.appId;
      localObject2 = this.mMiniAppContext.getAttachedActivity();
      if (localObject2 == null) {
        break label756;
      }
      k = AppLoaderFactory.g().getMiniAppEnv().getContext().getResources().getConfiguration().orientation;
      initActivitySize((Activity)localObject2);
      if (this.mGameDensity > 0.0F) {
        f = this.mGameDensity;
      }
      if (this.mGameWidth > 0) {
        i = this.mGameWidth;
      }
      if (this.mGameHeight <= 0) {
        break label762;
      }
      j = this.mGameHeight;
      break label762;
      QMLog.i("BannerAdPlugin", "handle createBannerAd appId = " + str3 + ", posid = " + ((BannerAdPosInfo)localObject1).mAdUnitId);
      if ((TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(((BannerAdPosInfo)localObject1).mAdUnitId)))
      {
        bannerErrorStateCallbackDelay(paramRequestEvent, 1001, (String)AD_ERROR_MSG.get(Integer.valueOf(1001)), 300);
        paramRequestEvent = "";
      }
      else
      {
        localBannerAdPosInfo = BannerAdPosInfo.buildFormatInfo((BannerAdPosInfo)localObject1, k, f, i, j);
        if ((localBannerAdPosInfo == null) || (!localBannerAdPosInfo.isValid()))
        {
          bannerErrorStateCallbackDelay(paramRequestEvent, 1001, (String)AD_ERROR_MSG.get(Integer.valueOf(1001)), 300);
          QMLog.i("BannerAdPlugin", "handle createBannerAd invalid adInfo = " + localBannerAdPosInfo);
          paramRequestEvent = "";
        }
        else
        {
          this.mBannerAdPosInfo = localBannerAdPosInfo;
          str5 = AdUtil.getSpAdGdtCookie(0);
          localObject4 = this.mMiniAppInfo;
          if ((localObject4 != null) && (((MiniAppInfo)localObject4).launchParam != null)) {
            if (((MiniAppInfo)localObject4).launchParam.entryPath != null)
            {
              localObject1 = ((MiniAppInfo)localObject4).launchParam.entryPath;
              label431:
              if (((MiniAppInfo)localObject4).launchParam == null) {
                break label765;
              }
            }
          }
        }
      }
    }
    label490:
    label631:
    String str1;
    label756:
    label762:
    label765:
    for (localObject2 = ((MiniAppInfo)localObject4).launchParam.reportData;; str1 = "")
    {
      String str2 = String.valueOf(((MiniAppInfo)localObject4).launchParam.scene);
      Object localObject3 = localObject1;
      localObject1 = str2;
      for (;;)
      {
        if ((localObject4 != null) && (((MiniAppInfo)localObject4).via != null))
        {
          str2 = ((MiniAppInfo)localObject4).via;
          localObject4 = new Bundle();
          ((Bundle)localObject4).putString(AdProxy.KEY_ACCOUNT, str4);
          ((Bundle)localObject4).putInt(AdProxy.KEY_AD_TYPE, 0);
          str4 = AdProxy.KEY_ORIENTATION;
          if (k != 2) {
            break label631;
          }
        }
        for (i = 90;; i = 0)
        {
          ((Bundle)localObject4).putInt(str4, i);
          ((Bundle)localObject4).putString(AdProxy.KEY_GDT_COOKIE, str5);
          ((Bundle)localObject4).putString(AdProxy.KEY_ENTRY_PATH, (String)localObject3);
          ((Bundle)localObject4).putString(AdProxy.KEY_REPORT_DATA, (String)localObject2);
          ((Bundle)localObject4).putString(AdProxy.KEY_REFER, (String)localObject1);
          ((Bundle)localObject4).putString(AdProxy.KEY_VIA, str2);
          AppBrandTask.runTaskOnUiThread(new BannerAdPlugin.1(this, paramRequestEvent, str3, localBannerAdPosInfo, (Bundle)localObject4));
          paramRequestEvent = "";
          break;
          localObject1 = "";
          break label431;
          str2 = "";
          break label490;
        }
        localObject1 = "";
        str1 = "";
        localObject3 = "";
      }
      k = 1;
      break label202;
      break label202;
    }
  }
  
  /* Error */
  public boolean hideBannerAd()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 89	com/tencent/qqmini/sdk/plugins/BannerAdPlugin:mBannerAdView	Lcom/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$AbsBannerAdView;
    //   8: ifnonnull +17 -> 25
    //   11: ldc 27
    //   13: ldc_w 577
    //   16: invokestatic 190	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: iload_2
    //   20: istore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: iload_1
    //   24: ireturn
    //   25: iload_2
    //   26: istore_1
    //   27: aload_0
    //   28: getfield 121	com/tencent/qqmini/sdk/plugins/BannerAdPlugin:mBannerAdContainer	Landroid/widget/FrameLayout;
    //   31: ifnull -10 -> 21
    //   34: iload_2
    //   35: istore_1
    //   36: aload_0
    //   37: getfield 121	com/tencent/qqmini/sdk/plugins/BannerAdPlugin:mBannerAdContainer	Landroid/widget/FrameLayout;
    //   40: ifnull -19 -> 21
    //   43: iload_2
    //   44: istore_1
    //   45: aload_0
    //   46: getfield 121	com/tencent/qqmini/sdk/plugins/BannerAdPlugin:mBannerAdContainer	Landroid/widget/FrameLayout;
    //   49: invokevirtual 580	android/widget/FrameLayout:getVisibility	()I
    //   52: ifne -31 -> 21
    //   55: aload_0
    //   56: getfield 121	com/tencent/qqmini/sdk/plugins/BannerAdPlugin:mBannerAdContainer	Landroid/widget/FrameLayout;
    //   59: bipush 8
    //   61: invokevirtual 271	android/widget/FrameLayout:setVisibility	(I)V
    //   64: iconst_1
    //   65: istore_1
    //   66: goto -45 -> 21
    //   69: astore_3
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_3
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	BannerAdPlugin
    //   20	46	1	bool1	boolean
    //   1	43	2	bool2	boolean
    //   69	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	19	69	finally
    //   27	34	69	finally
    //   36	43	69	finally
    //   45	64	69	finally
  }
  
  public void initActivitySize(Activity paramActivity)
  {
    if ((this.mGameDensity > 0.0F) && (this.mGameWidth > 0) && (this.mGameHeight > 0)) {
      return;
    }
    DisplayMetrics localDisplayMetrics = paramActivity.getResources().getDisplayMetrics();
    if (Build.VERSION.SDK_INT >= 17)
    {
      localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay().getRealMetrics(localDisplayMetrics);
    }
    this.mGameDensity = localDisplayMetrics.density;
    this.mGameWidth = localDisplayMetrics.widthPixels;
    this.mGameHeight = localDisplayMetrics.heightPixels;
    QMLog.i("BannerAdPlugin", "density = " + localDisplayMetrics.density + ", ViewUtils.density = " + ViewUtils.getDensity() + ", screenW = " + localDisplayMetrics.widthPixels + ", screenH = " + localDisplayMetrics.heightPixels);
  }
  
  public void onDestroy()
  {
    if ((this.mBannerAdView != null) && (this.mMiniAppContext != null) && (this.mMiniAppContext.getAttachedActivity() != null)) {
      this.mBannerAdView.destroy(this.mMiniAppContext.getAttachedActivity());
    }
    AdProxy localAdProxy = (AdProxy)ProxyManager.get(AdProxy.class);
    if ((localAdProxy != null) && (this.mMiniAppContext != null) && (this.mMiniAppContext.getAttachedActivity() != null)) {
      localAdProxy.destroy(this.mMiniAppContext.getAttachedActivity());
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    if ((this.mBannerAdView != null) && (this.mMiniAppContext != null) && (this.mMiniAppContext.getAttachedActivity() != null)) {
      this.mBannerAdView.pause(this.mMiniAppContext.getAttachedActivity());
    }
  }
  
  public void onResume()
  {
    if ((this.mBannerAdView != null) && (this.mMiniAppContext != null) && (this.mMiniAppContext.getAttachedActivity() != null)) {
      this.mBannerAdView.resume(this.mMiniAppContext.getAttachedActivity());
    }
  }
  
  @JsEvent({"operateBannerAd"})
  public String operateBannerAd(RequestEvent paramRequestEvent)
  {
    QMLog.i("BannerAdPlugin", "receive operateBannerAd event");
    try
    {
      str = new JSONObject(paramRequestEvent.jsonParams).getString("type");
      QMLog.i("BannerAdPlugin", "handle operateBannerAd type = " + str);
      if ("show".equals(str)) {
        AppBrandTask.runTaskOnUiThreadDelay(new BannerAdPlugin.2(this, paramRequestEvent), 300L);
      }
      for (;;)
      {
        return "";
        if (!"hide".equals(str)) {
          break;
        }
        AppBrandTask.runTaskOnUiThread(new BannerAdPlugin.3(this));
      }
    }
    catch (JSONException paramRequestEvent)
    {
      for (;;)
      {
        String str;
        QMLog.i("BannerAdPlugin", "handle operateBannerAd parse json error", paramRequestEvent);
        continue;
        if ("destroy".equals(str)) {
          AppBrandTask.runTaskOnUiThread(new BannerAdPlugin.4(this));
        } else {
          QMLog.i("BannerAdPlugin", "handle operateBannerAd not define type = " + str);
        }
      }
    }
  }
  
  public boolean updateBannerAdPosition(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        QMLog.i("BannerAdPlugin", "updateBannerAdPosition");
        if ((this.mBannerAdView == null) || (this.mBannerAdPosInfo == null))
        {
          QMLog.e("BannerAdPlugin", "updateBannerAdPosition error, no data");
          return bool;
        }
        switch (paramInt1)
        {
        default: 
          if ((this.mBannerAdContainer == null) || (this.mBannerAdContainer.getChildCount() <= 0)) {
            break label261;
          }
          View localView = this.mBannerAdContainer.getChildAt(0);
          FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
          localLayoutParams.leftMargin = gameDpTopx(this.mBannerAdPosInfo.mAdLeft);
          localLayoutParams.topMargin = gameDpTopx(this.mBannerAdPosInfo.mAdTop);
          localLayoutParams.width = gameDpTopx(this.mBannerAdPosInfo.mAdRealWidth);
          localLayoutParams.height = gameDpTopx(this.mBannerAdPosInfo.mAdRealHeight);
          this.mBannerAdView.setSize(gameDpTopx(this.mBannerAdPosInfo.mAdRealWidth), gameDpTopx(this.mBannerAdPosInfo.mAdRealHeight));
          localView.setLayoutParams(localLayoutParams);
        }
      }
      finally {}
      this.mBannerAdPosInfo.mAdLeft = paramInt2;
      continue;
      this.mBannerAdPosInfo.mAdTop = paramInt2;
      continue;
      this.mBannerAdPosInfo.mAdRealWidth = paramInt2;
      this.mBannerAdPosInfo.mAdRealHeight = BannerAdPosInfo.getHeight(paramInt2);
      continue;
      label261:
      bool = true;
    }
  }
  
  @JsEvent({"updateBannerAdSize"})
  public void updateBannerAdSize(RequestEvent paramRequestEvent)
  {
    QMLog.i("BannerAdPlugin", "updateBannerAdSize " + paramRequestEvent.jsonParams);
    updateBannerSize(paramRequestEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.BannerAdPlugin
 * JD-Core Version:    0.7.0.1
 */