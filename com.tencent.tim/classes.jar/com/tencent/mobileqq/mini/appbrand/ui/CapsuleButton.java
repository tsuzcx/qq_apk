package com.tencent.mobileqq.mini.appbrand.ui;

import acfp;
import aeay;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqux;
import aqvv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMsgIPCClient;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.AppConfigInfo;
import com.tencent.mobileqq.mini.apkg.AppMode;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.mobileqq.mini.app.MiniAppStateManager;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.JsPluginEngine;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.appbrand.utils.ShortcutUtils;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.mainpage.MainPageFragment;
import com.tencent.mobileqq.mini.manager.MiniLoadingAdManager;
import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.ShareChatModel;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.mobileqq.mini.utils.NavigateBackUtils;
import com.tencent.mobileqq.mini.utils.TroopApplicationListUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.jsapi.GameBrandRuntime;
import com.tencent.mobileqq.minigame.jsapi.GameJsPluginEngine;
import com.tencent.mobileqq.minigame.jsapi.GameJsRuntime;
import com.tencent.mobileqq.minigame.manager.GameCloseManager;
import com.tencent.mobileqq.minigame.manager.GameInfoManager;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoaderManager;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.debug.JankTraceLevel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.String;Ljava.lang.Integer;>;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class CapsuleButton
  extends RelativeLayout
  implements Handler.Callback, View.OnClickListener
{
  public static final String KEY_TAP_INDEX_QQ = "tapIndexQQ";
  public static final String KEY_TAP_INDEX_QZONE = "tapIndexQZONE";
  public static final String KEY_TAP_INDEX_WX = "tapIndexWX";
  public static final String KEY_TAP_INDEX_WX_MOMENTS = "tapIndexWXMoments";
  private static final int MINI_APP_INNER_SHARE_BUTTON = 1;
  private static final int MINI_APP_MORE_BUTTON = 0;
  private static final int MINI_GAME_SHOW_RESTART_BTN = 1;
  public static final int MSG_ADD_CURRENT_TROOP = 17;
  public static final int MSG_ADD_SHORTCUT = 11;
  public static final int MSG_BACK_HOME = 10;
  public static final int MSG_COLOR_NOTE_CLICK = 14;
  public static final int MSG_COMPLAINT = 12;
  public static final int MSG_DEBUG_CLICK = 3;
  public static final int MSG_DETAIL_CLICK = 4;
  public static final int MSG_FORWARD_CLICK = 2;
  public static final int MSG_FORWARD_QZONE_CLICK = 6;
  public static final int MSG_FORWARD_SHARE_CHAT_CLICK = 13;
  public static final int MSG_FORWARD_WECHAT_CLICK = 7;
  public static final int MSG_FORWARD_WECHAT_MOMENT_CLICK = 8;
  public static final int MSG_MONITOR_CLICK = 5;
  public static final int MSG_MORE_CLICK = 1;
  public static final int MSG_QIPC_TIMEOUT = 1000;
  public static final int MSG_RESTART_MINIAPP = 15;
  public static final int MSG_SET_TOP = 9;
  public static final int MSG_SET_TO_TROOP = 16;
  public static final int REQUEST_CODE = 1001;
  public static final int REQUEST_CODE_FOR_TROOP = 1002;
  public static final String TAG = "CapsuleButton";
  private static int unReadCount;
  private String KINGCARD_GUIDE_KEY_PREFFIX = "mini_app_kingcard_guide_";
  private int actionSheetCallbackId = -1;
  private ArrayList<Integer> backHomeSceneList = new CapsuleButton.1(this);
  private boolean isMiniMsgTabShow;
  private boolean isOpenMonitorPanel;
  private int launchFrom = -1;
  private aqvv lottieLoader;
  private AppBrandRuntime mAppBrandRuntime;
  private Drawable mCloseBtnBgDrawable;
  private Drawable mCloseBtnWhiteBgDrawable;
  private ImageView mCloseView;
  public onActivityFinishListener mGameActivityFinishListener;
  private GameBrandRuntime mGameBrandRuntime;
  private GameJsPluginEngine mGameJsPluginEngine;
  private Handler mHandler;
  private String mKingCardText;
  private Drawable mMoreBtnBgDrawable;
  private Drawable mMoreBtnWhiteBgDrawable;
  private DiniFlyAnimationView mMoreView;
  private TextView mRedDot;
  private View mSplider;
  private int mStyle = -1;
  private HashMap<String, Integer> tapIndexMap;
  
  public CapsuleButton(Context paramContext)
  {
    super(paramContext);
    initUI();
    this.mHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private void addToCurrentTroop()
  {
    QLog.d("CapsuleButton", 1, "addToCurrentTroop");
    try
    {
      String str2;
      if (isMiniGameRuntime()) {
        str2 = String.valueOf(this.mGameBrandRuntime.getApkgInfo().appConfig.launchParam.entryModel.uin);
      }
      for (String str1 = this.mGameBrandRuntime.getApkgInfo().appConfig.config.appId;; str1 = this.mAppBrandRuntime.apkgInfo.appConfig.config.appId)
      {
        TroopApplicationListUtil.addMiniAppToTroopApplicationList(str2, str1, null);
        return;
        str2 = String.valueOf(this.mAppBrandRuntime.apkgInfo.appConfig.launchParam.entryModel.uin);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("CapsuleButton", 1, "addToCurrentTroop exception: " + Log.getStackTraceString(localException));
    }
  }
  
  private void backToHomePage()
  {
    if (this.mAppBrandRuntime == null) {
      return;
    }
    String str = this.mAppBrandRuntime.apkgInfo.getAppConfigInfo().entryPagePath;
    this.mAppBrandRuntime.reload(str, true);
  }
  
  private Activity getActivity()
  {
    Activity localActivity = null;
    if (isMiniGameRuntime()) {
      if (this.mGameBrandRuntime != null) {
        localActivity = this.mGameBrandRuntime.activity;
      }
    }
    while (this.mAppBrandRuntime == null) {
      return localActivity;
    }
    return this.mAppBrandRuntime.activity;
  }
  
  private View getContainerView()
  {
    this.mMoreView = new DiniFlyAnimationView(getContext());
    this.mMoreView.setId(2131363912);
    this.mMoreView.setContentDescription(acfp.m(2131703404));
    Object localObject = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 40.0F), -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(9, -1);
    this.mMoreView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    addView(this.mMoreView, (ViewGroup.LayoutParams)localObject);
    localObject = new ImageView(getContext());
    ((ImageView)localObject).setId(2131363823);
    ((ImageView)localObject).setContentDescription(acfp.m(2131703400));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 40.0F), -1);
    localLayoutParams.addRule(11, -1);
    localLayoutParams.addRule(1, 2131363912);
    ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    addView((View)localObject, localLayoutParams);
    localObject = new View(getContext());
    ((View)localObject).setId(2131370485);
    localLayoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 0.5F), DisplayUtil.dip2px(getContext(), 18.0F));
    localLayoutParams.addRule(13, -1);
    ((View)localObject).setBackgroundColor(436207616);
    addView((View)localObject, localLayoutParams);
    localObject = new TextView(getContext());
    ((TextView)localObject).setId(2131376088);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, DisplayUtil.dip2px(getContext(), 19.0F));
    localLayoutParams.leftMargin = DisplayUtil.dip2px(getContext(), 21.5F);
    localLayoutParams.topMargin = DisplayUtil.dip2px(getContext(), -9.5F);
    addView((View)localObject, localLayoutParams);
    return this;
  }
  
  private MiniAppInfo getMiniAppInfo()
  {
    Object localObject2 = null;
    Object localObject1;
    if (isMiniGameRuntime())
    {
      localObject1 = localObject2;
      if (this.mGameBrandRuntime != null)
      {
        localObject1 = localObject2;
        if (this.mGameBrandRuntime.getApkgInfo() != null)
        {
          localObject1 = localObject2;
          if (this.mGameBrandRuntime.getApkgInfo().appConfig != null) {
            localObject1 = this.mGameBrandRuntime.getApkgInfo().appConfig.config;
          }
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return localObject1;
          localObject1 = localObject2;
        } while (this.mAppBrandRuntime == null);
        localObject1 = localObject2;
      } while (this.mAppBrandRuntime.apkgInfo == null);
      localObject1 = localObject2;
    } while (this.mAppBrandRuntime.apkgInfo.appConfig == null);
    return this.mAppBrandRuntime.apkgInfo.appConfig.config;
  }
  
  private void handleForwardClick()
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = "onShareAppMessage";
    Object localObject1 = localObject2;
    label213:
    label247:
    do
    {
      do
      {
        for (;;)
        {
          try
          {
            if (this.launchFrom == 1)
            {
              String str = "showActionSheet";
              localObject2 = str;
              localObject1 = str;
              if (this.tapIndexMap == null) {
                continue;
              }
              localObject1 = str;
              localJSONObject.put("tapIndex", this.tapIndexMap.get("tapIndexQQ"));
              localObject1 = "showActionSheet";
              localObject2 = localObject1;
            }
          }
          catch (JSONException localJSONException1) {}
          try
          {
            if (!isMiniGameRuntime())
            {
              localObject2 = localObject1;
              if (this.mAppBrandRuntime != null)
              {
                localObject2 = localObject1;
                if (this.mAppBrandRuntime.pageContainer.getCurrentPage() != null)
                {
                  localJSONObject.put("webViewUrl", this.mAppBrandRuntime.pageContainer.getCurrentPage().getUrl());
                  localObject2 = localObject1;
                }
              }
            }
            if (!isMiniGameRuntime()) {
              break label257;
            }
            this.mGameBrandRuntime.fromShareMenuBtn = 0;
            if ((this.mGameJsPluginEngine == null) || (this.mGameJsPluginEngine.getGameJsRuntime(1) == null)) {
              break label247;
            }
            if (this.launchFrom != 1) {
              break;
            }
            this.mGameJsPluginEngine.callbackJsEventOK(this.mGameJsPluginEngine.getGameJsRuntime(1), (String)localObject2, localJSONObject, this.actionSheetCallbackId);
            return;
          }
          catch (JSONException localJSONException2)
          {
            Object localObject3;
            break label213;
          }
          localObject1 = localObject2;
          localJSONObject.put("fromShareButton", 0);
          localObject1 = localObject2;
          localJSONObject.put("shareTarget", 0);
          localObject1 = localObject2;
          continue;
          QLog.e("CapsuleButton", 1, "on forward aio click exception ", localJSONException1);
          localObject3 = localObject1;
        }
        this.mGameJsPluginEngine.getGameJsRuntime(1).evaluateSubcribeJS(localObject3, localJSONObject.toString(), -1);
        return;
        QLog.e("CapsuleButton", 1, "on forward aio click exception mGameJsPluginEngine==null");
        return;
      } while (this.mAppBrandRuntime == null);
      if (this.launchFrom == 1)
      {
        this.mAppBrandRuntime.jsPluginEngine.callbackJsEventOK(this.mAppBrandRuntime.serviceRuntime, localObject3, localJSONObject, this.actionSheetCallbackId);
        return;
      }
      if (this.mAppBrandRuntime.getPageWebView() != null) {
        this.mAppBrandRuntime.getPageWebView().fromShareMenuBtn = 0;
      }
      localObject1 = this.mAppBrandRuntime.pageContainer.getCurrentPageWebview();
    } while (localObject1 == null);
    label257:
    this.mAppBrandRuntime.serviceRuntime.evaluateSubcribeJS(localObject3, localJSONObject.toString(), ((PageWebview)localObject1).pageWebviewId);
  }
  
  private void handleForwardQZoneClick()
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = "onShareAppMessage";
    Object localObject1 = localObject2;
    label213:
    label247:
    do
    {
      do
      {
        for (;;)
        {
          try
          {
            if (this.launchFrom == 1)
            {
              String str = "showActionSheet";
              localObject2 = str;
              localObject1 = str;
              if (this.tapIndexMap == null) {
                continue;
              }
              localObject1 = str;
              localJSONObject.put("tapIndex", this.tapIndexMap.get("tapIndexQZONE"));
              localObject1 = "showActionSheet";
              localObject2 = localObject1;
            }
          }
          catch (JSONException localJSONException1) {}
          try
          {
            if (!isMiniGameRuntime())
            {
              localObject2 = localObject1;
              if (this.mAppBrandRuntime != null)
              {
                localObject2 = localObject1;
                if (this.mAppBrandRuntime.pageContainer.getCurrentPage() != null)
                {
                  localJSONObject.put("webViewUrl", this.mAppBrandRuntime.pageContainer.getCurrentPage().getUrl());
                  localObject2 = localObject1;
                }
              }
            }
            if (!isMiniGameRuntime()) {
              break label257;
            }
            this.mGameBrandRuntime.fromShareMenuBtn = 1;
            if ((this.mGameJsPluginEngine == null) || (this.mGameJsPluginEngine.getGameJsRuntime(1) == null)) {
              break label247;
            }
            if (this.launchFrom != 1) {
              break;
            }
            this.mGameJsPluginEngine.callbackJsEventOK(this.mGameJsPluginEngine.getGameJsRuntime(1), (String)localObject2, localJSONObject, this.actionSheetCallbackId);
            return;
          }
          catch (JSONException localJSONException2)
          {
            Object localObject3;
            break label213;
          }
          localObject1 = localObject2;
          localJSONObject.put("fromShareButton", 0);
          localObject1 = localObject2;
          localJSONObject.put("shareTarget", 1);
          localObject1 = localObject2;
          continue;
          QLog.e("CapsuleButton", 1, "on forward qzone click exception ", localJSONException1);
          localObject3 = localObject1;
        }
        this.mGameJsPluginEngine.getGameJsRuntime(1).evaluateSubcribeJS(localObject3, localJSONObject.toString(), -1);
        return;
        QLog.e("CapsuleButton", 1, "on forward qzone click exception mGameJsPluginEngine==null");
        return;
      } while (this.mAppBrandRuntime == null);
      if (this.launchFrom == 1)
      {
        this.mAppBrandRuntime.jsPluginEngine.callbackJsEventOK(this.mAppBrandRuntime.serviceRuntime, localObject3, localJSONObject, this.actionSheetCallbackId);
        return;
      }
      if (this.mAppBrandRuntime.getPageWebView() != null) {
        this.mAppBrandRuntime.getPageWebView().fromShareMenuBtn = 1;
      }
      localObject1 = this.mAppBrandRuntime.pageContainer.getCurrentPageWebview();
    } while (localObject1 == null);
    label257:
    this.mAppBrandRuntime.serviceRuntime.evaluateSubcribeJS(localObject3, localJSONObject.toString(), ((PageWebview)localObject1).pageWebviewId);
  }
  
  private void handleForwardWeChatFriends()
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject1 = "onShareAppMessage";
    Object localObject2;
    label214:
    label224:
    do
    {
      do
      {
        try
        {
          if (this.launchFrom == 1)
          {
            localObject2 = "showActionSheet";
            localObject1 = localObject2;
            if (this.tapIndexMap != null)
            {
              localJSONObject.put("tapIndex", this.tapIndexMap.get("tapIndexWX"));
              localObject1 = localObject2;
            }
          }
          for (;;)
          {
            if ((!isMiniGameRuntime()) && (this.mAppBrandRuntime != null) && (this.mAppBrandRuntime.pageContainer.getCurrentPage() != null)) {
              localJSONObject.put("webViewUrl", this.mAppBrandRuntime.pageContainer.getCurrentPage().getUrl());
            }
            if (!isMiniGameRuntime()) {
              break label224;
            }
            this.mGameBrandRuntime.fromShareMenuBtn = 3;
            if ((this.mGameJsPluginEngine == null) || (this.mGameJsPluginEngine.getGameJsRuntime(1) == null)) {
              break label214;
            }
            if (this.launchFrom != 1) {
              break;
            }
            this.mGameJsPluginEngine.callbackJsEventOK(this.mGameJsPluginEngine.getGameJsRuntime(1), (String)localObject1, localJSONObject, this.actionSheetCallbackId);
            return;
            localJSONObject.put("fromShareButton", 0);
            localJSONObject.put("shareTarget", 3);
          }
          this.mGameJsPluginEngine.getGameJsRuntime(1).evaluateSubcribeJS(localJSONException, localJSONObject.toString(), -1);
        }
        catch (JSONException localJSONException)
        {
          QLog.e("CapsuleButton", 1, "on forward wechat friends click exception ", localJSONException);
          return;
        }
        return;
        QLog.e("CapsuleButton", 1, "on forward wechat friends click exception mGameJsPluginEngine==null");
        return;
      } while (this.mAppBrandRuntime == null);
      if (this.launchFrom == 1)
      {
        this.mAppBrandRuntime.jsPluginEngine.callbackJsEventOK(this.mAppBrandRuntime.serviceRuntime, localJSONException, localJSONObject, this.actionSheetCallbackId);
        return;
      }
      if (this.mAppBrandRuntime.getPageWebView() != null) {
        this.mAppBrandRuntime.getPageWebView().fromShareMenuBtn = 3;
      }
      localObject2 = this.mAppBrandRuntime.pageContainer.getCurrentPageWebview();
    } while (localObject2 == null);
    this.mAppBrandRuntime.serviceRuntime.evaluateSubcribeJS(localJSONException, localJSONObject.toString(), ((PageWebview)localObject2).pageWebviewId);
  }
  
  private void handleForwardWeChatMoment()
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = "onShareAppMessage";
    Object localObject1 = localObject2;
    label213:
    label247:
    do
    {
      do
      {
        for (;;)
        {
          try
          {
            if (this.launchFrom == 1)
            {
              String str = "showActionSheet";
              localObject2 = str;
              localObject1 = str;
              if (this.tapIndexMap == null) {
                continue;
              }
              localObject1 = str;
              localJSONObject.put("tapIndex", this.tapIndexMap.get("tapIndexWXMoments"));
              localObject1 = "showActionSheet";
              localObject2 = localObject1;
            }
          }
          catch (JSONException localJSONException1) {}
          try
          {
            if (!isMiniGameRuntime())
            {
              localObject2 = localObject1;
              if (this.mAppBrandRuntime != null)
              {
                localObject2 = localObject1;
                if (this.mAppBrandRuntime.pageContainer.getCurrentPage() != null)
                {
                  localJSONObject.put("webViewUrl", this.mAppBrandRuntime.pageContainer.getCurrentPage().getUrl());
                  localObject2 = localObject1;
                }
              }
            }
            if (!isMiniGameRuntime()) {
              break label257;
            }
            this.mGameBrandRuntime.fromShareMenuBtn = 4;
            if ((this.mGameJsPluginEngine == null) || (this.mGameJsPluginEngine.getGameJsRuntime(1) == null)) {
              break label247;
            }
            if (this.launchFrom != 1) {
              break;
            }
            this.mGameJsPluginEngine.callbackJsEventOK(this.mGameJsPluginEngine.getGameJsRuntime(1), (String)localObject2, localJSONObject, this.actionSheetCallbackId);
            return;
          }
          catch (JSONException localJSONException2)
          {
            Object localObject3;
            break label213;
          }
          localObject1 = localObject2;
          localJSONObject.put("fromShareButton", 0);
          localObject1 = localObject2;
          localJSONObject.put("shareTarget", 4);
          localObject1 = localObject2;
          continue;
          QLog.e("CapsuleButton", 1, "on forward wechat moment exception ", localJSONException1);
          localObject3 = localObject1;
        }
        this.mGameJsPluginEngine.getGameJsRuntime(1).evaluateSubcribeJS(localObject3, localJSONObject.toString(), -1);
        return;
        QLog.e("CapsuleButton", 1, "on forward wechat moment exception mGameJsPluginEngine==null");
        return;
      } while (this.mAppBrandRuntime == null);
      if (this.launchFrom == 1)
      {
        this.mAppBrandRuntime.jsPluginEngine.callbackJsEventOK(this.mAppBrandRuntime.serviceRuntime, localObject3, localJSONObject, this.actionSheetCallbackId);
        return;
      }
      if (this.mAppBrandRuntime.getPageWebView() != null) {
        this.mAppBrandRuntime.getPageWebView().fromShareMenuBtn = 4;
      }
      localObject1 = this.mAppBrandRuntime.pageContainer.getCurrentPageWebview();
    } while (localObject1 == null);
    label257:
    this.mAppBrandRuntime.serviceRuntime.evaluateSubcribeJS(localObject3, localJSONObject.toString(), ((PageWebview)localObject1).pageWebviewId);
  }
  
  private void handleMoreClick()
  {
    QLog.d("CapsuleButton", 1, "handleMoreClick --  isMiniMsgTabShow : " + this.isMiniMsgTabShow);
    if (this.isMiniMsgTabShow) {
      return;
    }
    this.launchFrom = 0;
    int m = 1;
    int i1 = -1;
    boolean bool14 = true;
    boolean bool1 = true;
    boolean bool5 = false;
    boolean bool10 = false;
    boolean bool6 = false;
    boolean bool12 = false;
    boolean bool4 = false;
    boolean bool8 = false;
    boolean bool7 = false;
    boolean bool13 = false;
    boolean bool15 = false;
    int i3 = 0;
    boolean bool9 = false;
    boolean bool3 = false;
    Object localObject2 = "";
    Object localObject1 = "";
    int i4 = 0;
    boolean bool11 = false;
    int i = 0;
    int k = 0;
    int i2 = 0;
    int n = 0;
    Object localObject3 = "light";
    boolean bool2;
    if (isMiniGameRuntime()) {
      if ((this.mGameBrandRuntime != null) && (this.mGameBrandRuntime.activity != null) && (!this.isMiniMsgTabShow))
      {
        if (this.mGameBrandRuntime.getApkgInfo() == null) {
          break label1950;
        }
        if (this.mGameBrandRuntime.getApkgInfo().appConfig.config.verType == 3)
        {
          bool1 = false;
          bool2 = false;
        }
      }
    }
    for (;;)
    {
      label188:
      localObject1 = this.mGameBrandRuntime.getApkgInfo().appId;
      localObject2 = this.mGameBrandRuntime.getApkgInfo().apkgName;
      bool4 = this.mGameBrandRuntime.withShareQQ;
      bool6 = this.mGameBrandRuntime.withShareQzone;
      bool5 = this.mGameBrandRuntime.withShareWeChatFriend;
      bool8 = this.mGameBrandRuntime.withShareWeChatMoment;
      int j = this.mGameBrandRuntime.getApkgInfo().appConfig.config.topType;
      bool3 = ((GameActivity)this.mGameBrandRuntime.activity).getIsOrientationLandscape();
      localObject3 = ((GameActivity)this.mGameBrandRuntime.activity).getMenuStyle();
      bool9 = this.mGameBrandRuntime.getApkgInfo().appConfig.isLimitedAccessApp();
      bool10 = this.mGameBrandRuntime.showRestart;
      label340:
      Object localObject4;
      if (this.mGameBrandRuntime.getApkgInfo().appConfig.launchParam.entryModel != null)
      {
        i = 1;
        if (i == 0) {
          break label1894;
        }
        bool11 = this.mGameBrandRuntime.getApkgInfo().appConfig.launchParam.entryModel.isAdmin;
        bool7 = bool2;
        localObject4 = localObject3;
        bool2 = bool9;
        bool9 = bool5;
        bool5 = bool1;
        bool1 = bool3;
        k = j;
        bool3 = bool4;
        bool4 = bool2;
        j = i;
        bool2 = bool11;
        localObject3 = localObject1;
        i = k;
        localObject1 = localObject4;
      }
      for (;;)
      {
        label415:
        if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_share_to_wx_switcher", 1) != 1)
        {
          bool8 = false;
          bool9 = false;
        }
        for (;;)
        {
          if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_game_capsule_show_restart_btn", 1) == 1)
          {
            k = 1;
            label457:
            if ((k == 0) || (!bool10)) {
              break label1200;
            }
            bool10 = true;
            label469:
            k = n;
            if ((this.mGameBrandRuntime.activity instanceof GameActivity))
            {
              k = n;
              if (!bool4)
              {
                localObject4 = ((GameActivity)this.mGameBrandRuntime.activity).getColorNoteController();
                k = n;
                if (localObject4 != null)
                {
                  bool11 = ((aeay)localObject4).shouldDisplayColorNote();
                  if (!bool11) {
                    break label1874;
                  }
                  if (!((aeay)localObject4).isColorNoteExist()) {
                    break label1206;
                  }
                  k = 2;
                }
              }
            }
          }
          for (;;)
          {
            QLog.d("CapsuleButton", 1, "handleMoreClick, shouldDisplayColorNote : " + bool11);
            n = m;
            bool12 = bool7;
            bool13 = bool10;
            bool7 = bool9;
            localObject4 = localObject2;
            i2 = i;
            bool11 = bool1;
            Object localObject5 = localObject1;
            bool14 = false;
            i1 = -1;
            i = k;
            bool10 = bool5;
            bool9 = bool12;
            bool1 = bool13;
            bool5 = bool3;
            m = j;
            bool3 = bool2;
            localObject2 = localObject3;
            localObject1 = localObject4;
            k = i2;
            localObject3 = localObject5;
            bool2 = bool14;
            j = n;
            label649:
            if (j != 0)
            {
              localObject4 = new Intent();
              ((Intent)localObject4).putExtra("miniAppID", (String)localObject2);
              ((Intent)localObject4).putExtra("miniAppName", (String)localObject1);
              if (!isMiniGameRuntime()) {
                break label1737;
              }
              bool12 = this.isOpenMonitorPanel;
              label697:
              ((Intent)localObject4).putExtra("isOpenMonitorPanel", bool12);
              ((Intent)localObject4).putExtra("debugEnable", getEnableDebug());
              ((Intent)localObject4).putExtra("showDebug", bool10);
              ((Intent)localObject4).putExtra("showMonitor", bool9);
              ((Intent)localObject4).putExtra("menuStyle", (String)localObject3);
              ((Intent)localObject4).putExtra("showShareQQ", bool5);
              ((Intent)localObject4).putExtra("showShareQzone", bool6);
              ((Intent)localObject4).putExtra("showShareWeChatFriends", bool8);
              ((Intent)localObject4).putExtra("showShareWeChatMoment", bool7);
              ((Intent)localObject4).putExtra("topType", k);
              ((Intent)localObject4).putExtra("showDetail", true);
              ((Intent)localObject4).putExtra("showSetting", true);
              ((Intent)localObject4).putExtra("showComplaint", true);
              if (Build.VERSION.SDK_INT < 21) {
                break label1749;
              }
              bool5 = true;
              label849:
              ((Intent)localObject4).putExtra("addShortcut", bool5);
              ((Intent)localObject4).putExtra("showBackHome", i1);
              ((Intent)localObject4).putExtra("isLandscape", bool11);
              ((Intent)localObject4).putExtra("isSpecialMiniApp", bool2);
              ((Intent)localObject4).putExtra("showKingcardTip", shouldShowKingCardTip());
              ((Intent)localObject4).putExtra("key_mini_msgtab_type", 1);
              ((Intent)localObject4).putExtra("key_mini_msgtab_need_action_sheet", true);
              ((Intent)localObject4).putExtra("is_limited_access_app", bool4);
              ((Intent)localObject4).putExtra("showRestartMiniApp", bool1);
              ((Intent)localObject4).putExtra("addToCurrentTroop", bool3);
              if (!isMiniGameRuntime()) {
                break label1755;
              }
              if ((this.mGameBrandRuntime != null) && (this.mGameBrandRuntime.getApkgInfo() != null))
              {
                ((Intent)localObject4).putExtra("key_mini_app_version_type", 1);
                ((Intent)localObject4).putExtra("key_mini_app_config", this.mGameBrandRuntime.getApkgInfo().appConfig);
                ((Intent)localObject4).putExtra("key_mini_app_is_game", true);
                ((Intent)localObject4).putExtra("key_color_note", i);
              }
              if (m == 0) {
                ((Intent)localObject4).putExtra("setToTroop", true);
              }
              MiniAppSecurityUtil.modifyIntentDataWithoutLogin((Intent)localObject4, (String)localObject2);
              if ((!isMiniGameRuntime()) || (this.mGameBrandRuntime.activity == null)) {
                break label1830;
              }
              MiniChatActivity.e(this.mGameBrandRuntime.activity, (Intent)localObject4, 1001);
              label1085:
              this.mRedDot.setVisibility(8);
              this.isMiniMsgTabShow = true;
              unReadCount = 0;
              if (QLog.isColorLevel()) {
                QLog.d("CapsuleButton", 1, "isMiniMsgTabShow true");
              }
              reportClick("open");
              return;
              bool1 = true;
              bool2 = true;
              break label188;
              i = 0;
              break label340;
              m = 0;
              bool1 = false;
              i = 0;
              localObject2 = "";
              localObject3 = "";
              bool2 = false;
              j = 0;
              bool4 = false;
              bool9 = false;
              bool3 = false;
              bool5 = false;
              localObject1 = "light";
              bool7 = false;
              bool8 = false;
              bool6 = false;
              bool10 = true;
              break label415;
              k = 0;
              break label457;
              label1200:
              bool10 = false;
              break label469;
              label1206:
              k = 1;
              continue;
              if ((this.mAppBrandRuntime != null) && (this.mAppBrandRuntime.activity != null) && (!this.isMiniMsgTabShow))
              {
                localObject4 = this.mAppBrandRuntime.pageContainer.getCurrentPageWebview();
                if (this.mAppBrandRuntime.apkgInfo.appConfig.config.verType == 3) {
                  break label1865;
                }
                bool2 = true;
              }
            }
            label1031:
            for (bool3 = true;; bool3 = false)
            {
              bool1 = bool14;
              if (this.mAppBrandRuntime.apkgInfo.isEngineTypeMiniApp())
              {
                bool1 = bool14;
                if (this.mAppBrandRuntime.pageContainer.getCurrentPage() != null)
                {
                  bool1 = bool14;
                  if (this.mAppBrandRuntime.getCurPage().getCurrentPageWebview() != null)
                  {
                    bool1 = bool14;
                    if (!this.mAppBrandRuntime.getCurPage().getCurrentPageWebview().enableShowBackHome()) {
                      bool1 = false;
                    }
                  }
                }
              }
              localObject2 = this.mAppBrandRuntime.apkgInfo.appId;
              localObject1 = this.mAppBrandRuntime.apkgInfo.apkgName;
              if (localObject4 != null)
              {
                bool5 = ((PageWebview)localObject4).withShareQQ;
                bool6 = ((PageWebview)localObject4).withShareQzone;
                bool4 = ((PageWebview)localObject4).withShareWeChatFriend;
                bool7 = ((PageWebview)localObject4).withShareWeChatMoment;
              }
              m = this.mAppBrandRuntime.apkgInfo.appConfig.config.topType;
              bool10 = this.mAppBrandRuntime.apkgInfo.appConfig.config.isSpecialMiniApp();
              if (bool10)
              {
                bool5 = false;
                bool6 = false;
                bool4 = false;
                bool7 = false;
              }
              bool8 = bool4;
              if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_share_to_wx_switcher", 1) != 1)
              {
                bool8 = false;
                bool7 = false;
              }
              bool12 = this.mAppBrandRuntime.apkgInfo.appConfig.isLimitedAccessApp();
              if (this.mAppBrandRuntime.apkgInfo.appConfig.launchParam.entryModel != null)
              {
                j = 1;
                label1520:
                bool4 = bool9;
                if (j != 0) {
                  bool4 = this.mAppBrandRuntime.apkgInfo.appConfig.launchParam.entryModel.isAdmin;
                }
                i = i2;
                if ((this.mAppBrandRuntime.activity instanceof AppBrandUI))
                {
                  i = i2;
                  if (!bool12)
                  {
                    localObject4 = ((AppBrandUI)this.mAppBrandRuntime.activity).getColorNoteController();
                    i = i2;
                    if (localObject4 != null)
                    {
                      bool9 = ((aeay)localObject4).shouldDisplayColorNote();
                      i = k;
                      if (bool9) {
                        if (!((aeay)localObject4).isColorNoteExist()) {
                          break label1691;
                        }
                      }
                    }
                  }
                }
              }
              label1691:
              for (i = 2;; i = 1)
              {
                QLog.d("CapsuleButton", 1, "handleMoreClick, shouldDisplayColorNote : " + bool9);
                n = 1;
                bool9 = bool3;
                bool3 = bool10;
                bool10 = bool2;
                k = m;
                m = j;
                j = n;
                bool2 = bool3;
                bool3 = bool4;
                bool4 = bool12;
                break;
                j = 0;
                break label1520;
              }
              bool14 = false;
              bool2 = false;
              j = 0;
              bool9 = false;
              k = i4;
              m = i3;
              bool4 = bool15;
              bool7 = bool13;
              bool6 = bool12;
              bool5 = bool10;
              bool10 = bool14;
              break label649;
              break;
              label1737:
              bool12 = this.mAppBrandRuntime.isOpenMonitorPanel();
              break label697;
              label1749:
              bool5 = false;
              break label849;
              label1755:
              if ((this.mAppBrandRuntime == null) || (this.mAppBrandRuntime.apkgInfo == null)) {
                break label1031;
              }
              ((Intent)localObject4).putExtra("key_mini_app_version_type", this.mAppBrandRuntime.versionType);
              ((Intent)localObject4).putExtra("key_mini_app_config", this.mAppBrandRuntime.apkgInfo.appConfig);
              ((Intent)localObject4).putExtra("key_mini_app_is_game", false);
              ((Intent)localObject4).putExtra("key_color_note", i);
              break label1031;
              label1830:
              if ((isMiniGameRuntime()) || (this.mAppBrandRuntime.activity == null)) {
                break label1085;
              }
              MiniChatActivity.e(this.mAppBrandRuntime.activity, (Intent)localObject4, 1001);
              break label1085;
              label1865:
              bool2 = false;
            }
            label1874:
            k = 0;
          }
          bool11 = bool9;
          bool9 = bool8;
          bool8 = bool11;
        }
        label1894:
        bool7 = bool2;
        k = i;
        bool12 = bool5;
        bool11 = bool4;
        bool5 = bool1;
        bool1 = bool3;
        i = j;
        localObject4 = localObject1;
        bool2 = false;
        localObject1 = localObject3;
        localObject3 = localObject4;
        j = k;
        bool4 = bool9;
        bool9 = bool12;
        bool3 = bool11;
      }
      label1950:
      bool1 = false;
      bool2 = false;
    }
  }
  
  private void handleShareChatDirectly(Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("key_mini_app_share_chat_uin");
    int i = paramBundle.getInt("key_mini_app_share_chat_type");
    paramBundle = paramBundle.getString("key_mini_app_share_chat_name");
    long l2 = -1L;
    long l1 = l2;
    if (localObject != null) {}
    JSONObject localJSONObject;
    label309:
    label342:
    label352:
    do
    {
      ShareChatModel localShareChatModel;
      do
      {
        for (;;)
        {
          try
          {
            l1 = Long.valueOf((String)localObject).longValue();
            localShareChatModel = new ShareChatModel(i, l1, paramBundle);
            localJSONObject = new JSONObject();
            localObject = "onShareAppMessage";
            paramBundle = (Bundle)localObject;
          }
          catch (Throwable localThrowable)
          {
            try
            {
              if (this.launchFrom == 1)
              {
                String str = "showActionSheet";
                localObject = str;
                paramBundle = str;
                if (this.tapIndexMap == null) {
                  continue;
                }
                paramBundle = str;
                localJSONObject.put("tapIndex", -1);
                paramBundle = "showActionSheet";
              }
            }
            catch (JSONException localJSONException1) {}
            try
            {
              if ((!isMiniGameRuntime()) && (this.mAppBrandRuntime != null) && (this.mAppBrandRuntime.pageContainer.getCurrentPage() != null)) {
                localJSONObject.put("webViewUrl", this.mAppBrandRuntime.pageContainer.getCurrentPage().getUrl());
              }
              localJSONObject.put("chatDataHash", localShareChatModel.getEntryHash());
              if (!isMiniGameRuntime()) {
                break label352;
              }
              this.mGameBrandRuntime.fromShareMenuBtn = 0;
              this.mGameBrandRuntime.shareChatModel = localShareChatModel;
              if ((this.mGameJsPluginEngine == null) || (this.mGameJsPluginEngine.getGameJsRuntime(1) == null)) {
                break label342;
              }
              if (this.launchFrom != 1) {
                break;
              }
              this.mGameJsPluginEngine.callbackJsEventOK(this.mGameJsPluginEngine.getGameJsRuntime(1), paramBundle, localJSONObject, this.actionSheetCallbackId);
              return;
            }
            catch (JSONException localJSONException2)
            {
              PageWebview localPageWebview;
              break label309;
            }
            localThrowable = localThrowable;
            QLog.e("CapsuleButton", 1, "handleShareChatDirectly get an exception ", localThrowable);
            l1 = l2;
            continue;
            paramBundle = localThrowable;
            localJSONObject.put("fromShareButton", 0);
            paramBundle = localThrowable;
            localJSONObject.put("shareTarget", 5);
            paramBundle = localThrowable;
            continue;
          }
          QLog.e("CapsuleButton", 1, "on forward aio click exception ", localJSONException1);
        }
        this.mGameJsPluginEngine.getGameJsRuntime(1).evaluateSubcribeJS(paramBundle, localJSONObject.toString(), -1);
        return;
        QLog.e("CapsuleButton", 1, "on forward aio click exception mGameJsPluginEngine==null");
        return;
      } while (this.mAppBrandRuntime == null);
      if (this.mAppBrandRuntime.getPageWebView() != null) {
        this.mAppBrandRuntime.getPageWebView().shareChatModel = localShareChatModel;
      }
      if (this.launchFrom == 1)
      {
        this.mAppBrandRuntime.jsPluginEngine.callbackJsEventOK(this.mAppBrandRuntime.serviceRuntime, paramBundle, localJSONObject, this.actionSheetCallbackId);
        return;
      }
      if (this.mAppBrandRuntime.getPageWebView() != null) {
        this.mAppBrandRuntime.getPageWebView().fromShareMenuBtn = 0;
      }
      localPageWebview = this.mAppBrandRuntime.pageContainer.getCurrentPageWebview();
    } while (localPageWebview == null);
    this.mAppBrandRuntime.serviceRuntime.evaluateSubcribeJS(paramBundle, localJSONObject.toString(), localPageWebview.pageWebviewId);
  }
  
  private boolean hasKingCardGuideShowed()
  {
    String str = this.KINGCARD_GUIDE_KEY_PREFFIX + BaseApplicationImpl.getApplication().getRuntime().getAccount();
    return StorageUtil.getPreference().getBoolean(str, false);
  }
  
  private void initUI()
  {
    setClipChildren(false);
    getContainerView();
    this.mCloseView = ((ImageView)findViewById(2131363823));
    this.mRedDot = ((TextView)findViewById(2131376088));
    this.mSplider = findViewById(2131370485);
    this.mRedDot.setTextSize(12.0F);
    this.mRedDot.setTextColor(-1);
    this.mRedDot.setGravity(17);
    this.mRedDot.setIncludeFontPadding(false);
    this.mMoreView.setOnClickListener(this);
    this.mCloseView.setOnClickListener(this);
    this.mMoreBtnWhiteBgDrawable = getResources().getDrawable(2130842082);
    this.mCloseBtnWhiteBgDrawable = getResources().getDrawable(2130842076);
    this.mMoreBtnBgDrawable = getResources().getDrawable(2130842079);
    this.mCloseBtnBgDrawable = getResources().getDrawable(2130842073);
    if ((!TextUtils.isEmpty(MiniAppGlobal.CAPSULE_CLOSE_URL)) && (!TextUtils.isEmpty(MiniAppGlobal.CAPSULE_CLOSE_DARK_URL)))
    {
      this.mCloseBtnWhiteBgDrawable = MiniAppUtils.getIcon(getContext(), MiniAppGlobal.CAPSULE_CLOSE_DARK_URL, true, 2130842076, 40, 30);
      this.mCloseBtnBgDrawable = MiniAppUtils.getIcon(getContext(), MiniAppGlobal.CAPSULE_CLOSE_URL, true, 2130842073, 40, 30);
    }
    if (!TextUtils.isEmpty(MiniAppGlobal.KINGCARD_GUIDE_TEXT)) {}
    for (String str = MiniAppGlobal.KINGCARD_GUIDE_TEXT;; str = getResources().getString(2131695913))
    {
      this.mKingCardText = str;
      this.lottieLoader = new aqvv(null, super.getContext());
      int i = (int)(MemoryManager.eS() / 2L);
      this.lottieLoader.hx(i);
      return;
    }
  }
  
  private boolean isMiniGameRuntime()
  {
    return (this.mAppBrandRuntime == null) && (this.mGameBrandRuntime != null);
  }
  
  private void onMoreClick()
  {
    Bundle localBundle = null;
    this.mHandler.sendEmptyMessageDelayed(1000, 500L);
    if (isMiniGameRuntime())
    {
      if (this.mGameBrandRuntime != null) {}
      for (localApkgInfo = this.mGameBrandRuntime.getApkgInfo();; localApkgInfo = null)
      {
        int j = 3;
        int i = j;
        Object localObject = localBundle;
        if (localApkgInfo != null)
        {
          i = j;
          localObject = localBundle;
          if (localApkgInfo.appConfig != null)
          {
            i = j;
            localObject = localBundle;
            if (localApkgInfo.appConfig.config != null)
            {
              i = localApkgInfo.appConfig.config.verType;
              localObject = localApkgInfo.appConfig.config.appId;
            }
          }
        }
        localBundle = new Bundle();
        localBundle.putString("appid", (String)localObject);
        localBundle.putInt("verType", i);
        QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "query_mini_app_data", localBundle, new CapsuleButton.4(this, localApkgInfo));
        return;
      }
    }
    if (this.mAppBrandRuntime != null) {}
    for (ApkgInfo localApkgInfo = this.mAppBrandRuntime.apkgInfo;; localApkgInfo = null) {
      break;
    }
  }
  
  private void performMiniGameClose()
  {
    if (!isMiniGameRuntime()) {}
    Object localObject;
    do
    {
      return;
      localObject = GameRuntimeLoaderManager.g().getBindRuntimeLoader(this.mGameBrandRuntime.activity);
      if (localObject != null) {}
      for (localObject = ((GameRuntimeLoader)localObject).getGameInfoManager().getMiniAppConfig(); localObject == null; localObject = null)
      {
        QLog.e("CapsuleButton", 1, "performMiniGameClose error, currentAppConfig is null!");
        return;
      }
      MiniReportManager.reportEventType((MiniAppConfig)localObject, 1025, "1");
      MiniProgramLpReportDC04239.reportPageView((MiniAppConfig)localObject, "1", null, "close", "inner_page");
      MiniAppReportManager2.reportPageView("2close", "inner_page", null, (MiniAppConfig)localObject);
      Activity localActivity = this.mGameBrandRuntime.activity;
      if ((localActivity instanceof GameActivity)) {
        ((GameActivity)localActivity).doOnBackPressed();
      }
    } while ((((MiniAppConfig)localObject).launchParam == null) || (TextUtils.isEmpty(((MiniAppConfig)localObject).launchParam.fromMiniAppId)));
    NavigateBackUtils.writeTagAppid(((MiniAppConfig)localObject).launchParam.fromMiniAppId);
  }
  
  private void reportClick(String paramString)
  {
    String str1 = null;
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      if (isMiniGameRuntime())
      {
        MiniProgramLpReportDC04239.reportUserClick(this.mGameBrandRuntime.getApkgInfo().appConfig, MiniProgramLpReportDC04239.getAppType(this.mGameBrandRuntime.getApkgInfo().appConfig), null, "user_click", "more_button", paramString);
        return;
      }
    } while ((this.mAppBrandRuntime == null) || (this.mAppBrandRuntime.pageContainer == null) || (this.mAppBrandRuntime.apkgInfo == null));
    PageWebview localPageWebview = this.mAppBrandRuntime.pageContainer.getCurrentPageWebview();
    MiniAppConfig localMiniAppConfig = this.mAppBrandRuntime.apkgInfo.appConfig;
    String str2 = MiniProgramLpReportDC04239.getAppType(this.mAppBrandRuntime.apkgInfo.appConfig);
    if (localPageWebview != null) {
      str1 = localPageWebview.getUrl();
    }
    MiniProgramLpReportDC04239.reportUserClick(localMiniAppConfig, str2, str1, "user_click", "more_button", paramString);
  }
  
  private void restartMiniApp()
  {
    if (isMiniGameRuntime())
    {
      localMiniAppConfig = this.mGameBrandRuntime.getApkgInfo().appConfig;
      if (localMiniAppConfig != null)
      {
        this.mGameActivityFinishListener = new CapsuleButton.6(this, localMiniAppConfig);
        this.mGameBrandRuntime.activity.finish();
      }
    }
    while (this.mAppBrandRuntime == null)
    {
      MiniAppConfig localMiniAppConfig;
      return;
    }
    AppBrandRuntimeContainer.g().cleanup();
    MiniAppController.startApp(null, this.mAppBrandRuntime.apkgInfo.appConfig, null);
  }
  
  private void saveKingCardGuideShowed()
  {
    String str = this.KINGCARD_GUIDE_KEY_PREFFIX + BaseApplicationImpl.getApplication().getRuntime().getAccount();
    StorageUtil.getPreference().edit().putBoolean(str, true).apply();
  }
  
  private void sendSetUserAppTopRequest(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("CapsuleButton", 1, "sendSetUserAppTopRequest, miniAppInfo = " + paramMiniAppInfo);
      }
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", paramMiniAppInfo.appId);
    localBundle.putInt("topType", paramMiniAppInfo.topType);
    localBundle.putInt("verType", paramMiniAppInfo.verType);
    QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "sync_mini_app_data", localBundle, new CapsuleButton.7(this, paramMiniAppInfo));
  }
  
  private void setMiniAppToTroopApplicationList()
  {
    QLog.d("CapsuleButton", 1, "setMiniAppToTroopApplicationList");
    Intent localIntent = new Intent(getActivity(), TroopActivity.class);
    localIntent.putExtra("onlyOneSegement", true);
    localIntent.putExtra("_key_mode", 0);
    localIntent.putExtra("key_tab_mode", 0);
    localIntent.putExtra("is_select_troop", true);
    localIntent.putExtra("key_from", 3);
    getActivity().startActivityForResult(localIntent, 1002);
  }
  
  private void setMiniAppTop(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null)
    {
      QLog.e("CapsuleButton", 1, "setMiniAppTop, miniAppInfo = null.");
      return;
    }
    MiniAppCmdUtil.getInstance().setUserAppTop(paramMiniAppInfo.appId, paramMiniAppInfo.topType, paramMiniAppInfo.verType, null, new CapsuleButton.8(this, paramMiniAppInfo));
  }
  
  private boolean shouldShowKingCardTip()
  {
    boolean bool = true;
    if (!AppNetConnInfo.isMobileConn())
    {
      QLog.i("CapsuleButton", 1, "shouldShowKingCardTip network type is wifi + " + AppNetConnInfo.isWifiConn());
      return false;
    }
    MiniAppInfo localMiniAppInfo = getMiniAppInfo();
    if ((localMiniAppInfo != null) && (localMiniAppInfo.appMode != null) && (localMiniAppInfo.appMode.isWangKa)) {}
    for (int i = 1; i == 0; i = 0)
    {
      QLog.i("CapsuleButton", 1, "shouldShowKingCardTip， not wangka app");
      return false;
    }
    i = aqux.Mv();
    QLog.i("CapsuleButton", 1, "shouldShowKingCardTip， king card status = " + i);
    if (i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private void startReportPage()
  {
    MiniAppConfig localMiniAppConfig;
    Object localObject1;
    if (isMiniGameRuntime())
    {
      if ((this.mGameBrandRuntime.getApkgInfo() == null) || (this.mGameBrandRuntime.getApkgInfo().appConfig == null)) {
        break label351;
      }
      localMiniAppConfig = this.mGameBrandRuntime.getApkgInfo().appConfig;
      localObject1 = this.mGameBrandRuntime.getApkgInfo().appConfig.config;
    }
    for (;;)
    {
      Object localObject3 = this.mGameBrandRuntime.activity;
      Object localObject2 = localObject1;
      localObject1 = localObject3;
      for (;;)
      {
        if ((localObject2 != null) && (localObject1 != null)) {
          localObject3 = "";
        }
        try
        {
          String str = URLEncoder.encode("https://support.qq.com/data/1368/2018/0927/5e6c84b68d1f3ad390e7beeb6c2f83b0.jpeg", "UTF-8");
          localObject3 = str;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            QLog.e("CapsuleButton", 1, "startComplainAndCallback, url = " + "");
            localUnsupportedEncodingException.printStackTrace();
            continue;
            localObject1 = null;
            localMiniAppConfig = null;
          }
          localObject1 = null;
          localObject2 = null;
          localMiniAppConfig = null;
        }
        localObject3 = "https://tucao.qq.com/qq_miniprogram/tucao?appid=" + ((MiniAppInfo)localObject2).appId + "&openid=" + MainPageFragment.getUin() + "&avatar=" + (String)localObject3 + acfp.m(2131703403);
        localObject2 = new Intent((Context)localObject1, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", (String)localObject3);
        localObject3 = new Bundle();
        ((Bundle)localObject3).putBoolean("hide_more_button", true);
        ((Intent)localObject2).putExtras((Bundle)localObject3);
        ((Context)localObject1).startActivity((Intent)localObject2);
        MiniProgramLpReportDC04239.reportUserClick(localMiniAppConfig, MiniProgramLpReportDC04239.getAppType(localMiniAppConfig), null, "user_click", "more_button", "report");
        return;
        if (this.mAppBrandRuntime != null) {
          if ((this.mAppBrandRuntime.apkgInfo != null) && (this.mAppBrandRuntime.apkgInfo.appConfig != null))
          {
            localMiniAppConfig = this.mAppBrandRuntime.apkgInfo.appConfig;
            localObject1 = this.mAppBrandRuntime.apkgInfo.appConfig.config;
            localObject3 = this.mAppBrandRuntime.activity;
            localObject2 = localObject1;
            localObject1 = localObject3;
            continue;
          }
        }
      }
      label351:
      localObject1 = null;
      localMiniAppConfig = null;
    }
  }
  
  public void attachAppBrandRuntime(AppBrandRuntime paramAppBrandRuntime)
  {
    this.mAppBrandRuntime = paramAppBrandRuntime;
  }
  
  public void attachGameBrandRuntime(GameBrandRuntime paramGameBrandRuntime, GameJsPluginEngine paramGameJsPluginEngine)
  {
    this.mGameBrandRuntime = paramGameBrandRuntime;
    this.mGameJsPluginEngine = paramGameJsPluginEngine;
  }
  
  public void changeNavIcon(int paramInt)
  {
    this.mStyle = paramInt;
    if (paramInt == -1)
    {
      this.mMoreView.setImageDrawable(this.mMoreBtnWhiteBgDrawable);
      this.mCloseView.setImageDrawable(this.mCloseBtnWhiteBgDrawable);
      this.mSplider.setBackgroundColor(Color.parseColor("#4DFFFFFF"));
      return;
    }
    this.mMoreView.setImageDrawable(this.mMoreBtnBgDrawable);
    this.mCloseView.setImageDrawable(this.mCloseBtnBgDrawable);
    this.mSplider.setBackgroundColor(Color.parseColor("#1A000000"));
  }
  
  public void detachAppBrandRuntime()
  {
    if (this.mAppBrandRuntime != null) {
      this.mAppBrandRuntime = null;
    }
    if (this.mGameBrandRuntime != null) {
      this.mGameBrandRuntime = null;
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1001)
    {
      this.isMiniMsgTabShow = false;
      QLog.d("CapsuleButton", 1, "isMiniMsgTabShow false");
      if (paramInt2 == -1)
      {
        if ((this.mAppBrandRuntime != null) && (this.mAppBrandRuntime.pageContainer != null)) {
          this.mAppBrandRuntime.pageContainer.reportPageViewShow("bring_to_front");
        }
        localObject = paramIntent.getStringExtra("miniAppID");
        if (((!isMiniGameRuntime()) || (!this.mGameBrandRuntime.appId.equals(localObject))) && ((this.mAppBrandRuntime == null) || (this.mAppBrandRuntime.apkgInfo == null) || (this.mAppBrandRuntime.apkgInfo.appId == null) || (!this.mAppBrandRuntime.apkgInfo.appId.equals(localObject)))) {
          break label544;
        }
        paramInt1 = paramIntent.getIntExtra("clickID", -1);
        localObject = "";
        switch (paramInt1)
        {
        default: 
          paramIntent = (Intent)localObject;
          reportClick(paramIntent);
          updateRedDotVisible();
        }
      }
    }
    label544:
    while ((paramInt1 != 1002) || (paramInt2 != -1))
    {
      do
      {
        for (;;)
        {
          return;
          this.mHandler.sendEmptyMessage(2);
          paramIntent = (Intent)localObject;
          continue;
          this.mHandler.sendEmptyMessage(6);
          paramIntent = (Intent)localObject;
          continue;
          this.mHandler.sendEmptyMessage(7);
          paramIntent = "share_WX";
          continue;
          this.mHandler.sendEmptyMessage(8);
          paramIntent = "share_Moments";
          continue;
          Message localMessage = new Message();
          localMessage.what = 13;
          localMessage.setData(paramIntent.getExtras());
          this.mHandler.sendMessage(localMessage);
          paramIntent = (Intent)localObject;
          continue;
          this.mHandler.sendEmptyMessage(3);
          paramIntent = (Intent)localObject;
          continue;
          this.mHandler.sendEmptyMessage(4);
          paramIntent = "about";
          continue;
          this.mHandler.sendEmptyMessage(5);
          paramIntent = (Intent)localObject;
          continue;
          paramIntent = "cancel";
          continue;
          paramIntent = "cancel_system";
          continue;
          this.mHandler.sendEmptyMessage(9);
          paramIntent = (Intent)localObject;
          continue;
          this.mHandler.sendEmptyMessage(11);
          paramIntent = (Intent)localObject;
          continue;
          this.mHandler.sendEmptyMessage(10);
          paramIntent = "back_home";
          continue;
          this.mHandler.sendEmptyMessage(12);
          paramIntent = (Intent)localObject;
          continue;
          this.mHandler.sendEmptyMessage(14);
          paramIntent = (Intent)localObject;
          continue;
          this.mHandler.sendEmptyMessage(15);
          paramIntent = (Intent)localObject;
          continue;
          this.mHandler.sendEmptyMessage(16);
          paramIntent = (Intent)localObject;
          continue;
          this.mHandler.sendEmptyMessage(17);
          paramIntent = (Intent)localObject;
        }
      } while (!QLog.isColorLevel());
      localObject = new StringBuilder().append("intent appID : ").append((String)localObject).append("; current appid : ");
      if ((this.mAppBrandRuntime != null) && (this.mAppBrandRuntime.apkgInfo != null)) {}
      for (paramIntent = this.mAppBrandRuntime.apkgInfo.appId;; paramIntent = Integer.valueOf(0))
      {
        QLog.d("CapsuleButton", 1, paramIntent);
        return;
      }
    }
    Object localObject = paramIntent.getStringExtra("uin");
    paramIntent = paramIntent.getStringExtra("uinname");
    QLog.d("CapsuleButton", 1, "group uin: " + (String)localObject + ", group name: " + paramIntent);
    try
    {
      if (isMiniGameRuntime())
      {
        TroopApplicationListUtil.addMiniAppToTroopApplicationList((String)localObject, this.mGameBrandRuntime.getApkgInfo().appId, null);
        return;
      }
    }
    catch (Exception paramIntent)
    {
      QLog.e("CapsuleButton", 1, "doOnActvityResult, addMiniAppToTroopApplicationList exception: " + Log.getStackTraceString(paramIntent));
      return;
    }
    TroopApplicationListUtil.addMiniAppToTroopApplicationList((String)localObject, this.mAppBrandRuntime.apkgInfo.appId, null);
  }
  
  public boolean getEnableDebug()
  {
    if (isMiniGameRuntime()) {
      if (this.mGameBrandRuntime != null) {}
    }
    while (this.mAppBrandRuntime == null)
    {
      return false;
      return StorageUtil.getPreference().getBoolean(this.mGameBrandRuntime.getApkgInfo().appId + "_debug", false);
    }
    return StorageUtil.getPreference().getBoolean(this.mAppBrandRuntime.apkgInfo.appId + "_debug", false);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject = null;
    ITTEngine localITTEngine = null;
    if (paramMessage == null) {
      if (QLog.isColorLevel()) {
        QLog.e("CapsuleButton", 2, "handleMessage error, msg is null.");
      }
    }
    label394:
    int i;
    label520:
    do
    {
      do
      {
        boolean bool;
        do
        {
          do
          {
            return false;
            switch (paramMessage.what)
            {
            case 4: 
            default: 
              return false;
            case 1: 
              onMoreClick();
              return false;
            case 1000: 
              handleMoreClick();
              return false;
            case 2: 
              handleForwardClick();
              return false;
            case 6: 
              handleForwardQZoneClick();
              return false;
            case 7: 
              handleForwardWeChatFriends();
              return false;
            case 8: 
              handleForwardWeChatMoment();
              return false;
            case 13: 
              handleShareChatDirectly(paramMessage.getData());
              return false;
            case 3: 
              if (getEnableDebug()) {
                setEnableDebug(false);
              }
              for (;;)
              {
                AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().exitProcess();
                return false;
                setEnableDebug(true);
              }
            case 5: 
              if (!isMiniGameRuntime()) {
                break label394;
              }
            }
          } while ((this.mGameBrandRuntime == null) || (this.mGameBrandRuntime.activity == null));
          paramMessage = this.mGameBrandRuntime.activity;
          if (((paramMessage instanceof GameActivity)) && (((GameActivity)paramMessage).getNavBar() != null))
          {
            ((GameActivity)paramMessage).clickMonitorPanel();
            if (this.isOpenMonitorPanel) {
              break;
            }
            bool = true;
            this.isOpenMonitorPanel = bool;
          }
          setIsOpenMonitorPanel(this.isOpenMonitorPanel);
          localITTEngine = GameRuntimeLoaderManager.g().getBindRuntimeLoader(paramMessage).getGameEngine();
        } while (localITTEngine == null);
        if (this.isOpenMonitorPanel) {}
        for (paramMessage = JankTraceLevel.DETAIL;; paramMessage = JankTraceLevel.NONE)
        {
          localITTEngine.setJankTraceLevel(paramMessage);
          return false;
          bool = false;
          break;
        }
      } while (this.mAppBrandRuntime == null);
      setIsOpenMonitorPanel(((AppBrandPageContainer)this.mAppBrandRuntime.getContainer()).clickMonitorPanel());
      return false;
      if (isMiniGameRuntime())
      {
        paramMessage = this.mGameBrandRuntime.getApkgInfo().appConfig.config;
        if (this.mGameBrandRuntime.getApkgInfo().appConfig.config.topType == 0)
        {
          i = 1;
          paramMessage.topType = i;
          sendSetUserAppTopRequest(this.mGameBrandRuntime.getApkgInfo().appConfig.config);
          if (this.mGameBrandRuntime.getApkgInfo().appConfig.config.topType != 1) {
            break label520;
          }
        }
        for (paramMessage = "settop_on";; paramMessage = "settop_off")
        {
          reportClick(paramMessage);
          return false;
          i = 0;
          break;
        }
      }
    } while (this.mAppBrandRuntime == null);
    paramMessage = this.mAppBrandRuntime.apkgInfo.appConfig.config;
    if (this.mAppBrandRuntime.apkgInfo.appConfig.config.topType == 0)
    {
      i = 1;
      paramMessage.topType = i;
      sendSetUserAppTopRequest(this.mAppBrandRuntime.apkgInfo.appConfig.config);
      if (this.mAppBrandRuntime.apkgInfo.appConfig.config.topType != 1) {
        break label627;
      }
    }
    label627:
    for (paramMessage = "settop_on";; paramMessage = "settop_off")
    {
      reportClick(paramMessage);
      return false;
      i = 0;
      break;
    }
    if (isMiniGameRuntime()) {
      if (this.mGameBrandRuntime.activity != null)
      {
        paramMessage = localITTEngine;
        if ((this.mGameBrandRuntime.activity instanceof BaseActivity)) {
          paramMessage = (BaseActivity)this.mGameBrandRuntime.activity;
        }
        ShortcutUtils.addShortcut(paramMessage, this.mGameBrandRuntime.getApkgInfo());
      }
    }
    for (;;)
    {
      reportClick("add_desktop");
      return false;
      if ((this.mAppBrandRuntime != null) && (this.mAppBrandRuntime.activity != null))
      {
        paramMessage = localObject;
        if ((this.mAppBrandRuntime.activity instanceof BaseActivity)) {
          paramMessage = (BaseActivity)this.mAppBrandRuntime.activity;
        }
        ShortcutUtils.addShortcut(paramMessage, this.mAppBrandRuntime.apkgInfo);
      }
    }
    backToHomePage();
    return false;
    startReportPage();
    return false;
    if (isMiniGameRuntime())
    {
      if ((this.mGameBrandRuntime.activity == null) || (!(this.mGameBrandRuntime.activity instanceof GameActivity))) {
        break label946;
      }
      paramMessage = ((GameActivity)this.mGameBrandRuntime.activity).getColorNoteController();
    }
    while (paramMessage != null)
    {
      if (!paramMessage.isColorNoteExist())
      {
        if (paramMessage.canAddColorNote())
        {
          if ((this.mAppBrandRuntime != null) && ((this.mAppBrandRuntime.getContainer() instanceof AppBrandPageContainer))) {
            ((AppBrandPageContainer)this.mAppBrandRuntime.getContainer()).notifyOnAddColorNote();
          }
          paramMessage.insertColorNote();
          return false;
          if ((this.mAppBrandRuntime != null) && ((this.mAppBrandRuntime.activity instanceof AppBrandUI))) {
            paramMessage = ((AppBrandUI)this.mAppBrandRuntime.activity).getColorNoteController();
          }
        }
        else
        {
          paramMessage.onCannotAdd();
          return false;
        }
      }
      else
      {
        if (!paramMessage.isColorNoteExist()) {
          break;
        }
        paramMessage.deleteColorNote();
        return false;
        restartMiniApp();
        return false;
        setMiniAppToTroopApplicationList();
        return false;
        addToCurrentTroop();
        return false;
      }
      label946:
      paramMessage = null;
    }
  }
  
  public void onClick(View paramView)
  {
    MiniAppConfig localMiniAppConfig = null;
    MiniAppStateManager.getInstance().notifyChange("hideKeyboard");
    switch (paramView.getId())
    {
    default: 
    case 2131363912: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (this.mHandler != null) {
          this.mHandler.sendEmptyMessage(1);
        }
      }
    }
    QLog.e("CapsuleButton", 1, "[btn_close, inner page close]");
    MiniAppStateManager.getInstance().notifyChange("hideInput");
    if (isMiniGameRuntime()) {
      if ((this.mGameBrandRuntime.activity instanceof GameActivity))
      {
        GameActivity localGameActivity = (GameActivity)this.mGameBrandRuntime.activity;
        if (this.mGameBrandRuntime.getApkgInfo() != null) {
          localMiniAppConfig = this.mGameBrandRuntime.getApkgInfo().appConfig;
        }
        if (this.mGameBrandRuntime.isColdBootInCurrentLifeCycle) {
          MiniLoadingAdManager.getInstance().preloadLoadingAd(localMiniAppConfig, MainPageFragment.getUin());
        }
        if ((!GameCloseManager.showAlertViewForBattleGame(localGameActivity, localMiniAppConfig, new CapsuleButton.2(this))) && (!GameCloseManager.showPullDownGuideDialog(localGameActivity, localMiniAppConfig, new CapsuleButton.3(this)))) {
          performMiniGameClose();
        }
      }
    }
    for (;;)
    {
      MiniMsgIPCClient.getInstance().clearBusiness(0);
      break;
      performMiniGameClose();
      continue;
      if (this.mAppBrandRuntime != null)
      {
        if (this.mAppBrandRuntime.apkgInfo != null)
        {
          if (this.mAppBrandRuntime.isColdBootInCurrentLifeCycle) {
            MiniLoadingAdManager.getInstance().preloadLoadingAd(this.mAppBrandRuntime.apkgInfo.appConfig, MainPageFragment.getUin());
          }
          MiniReportManager.reportEventType(this.mAppBrandRuntime.apkgInfo.appConfig, 1025, "0");
          MiniProgramLpReportDC04239.reportPageView(this.mAppBrandRuntime.apkgInfo.appConfig, "0", null, "close", "inner_page");
          MiniAppReportManager2.reportPageView("2close", "inner_page", null, this.mAppBrandRuntime.apkgInfo.appConfig);
          if ((this.mAppBrandRuntime.apkgInfo.appConfig != null) && (this.mAppBrandRuntime.apkgInfo.appConfig.launchParam != null) && (!TextUtils.isEmpty(this.mAppBrandRuntime.apkgInfo.appConfig.launchParam.fromMiniAppId))) {
            NavigateBackUtils.writeTagAppid(this.mAppBrandRuntime.apkgInfo.appConfig.launchParam.fromMiniAppId);
          }
        }
        this.mAppBrandRuntime.moveAppBrandToBack();
      }
    }
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    QLog.i("CapsuleButton", 1, "onNetChangeEvent =" + paramBoolean);
  }
  
  public void setEnableDebug(boolean paramBoolean)
  {
    if (isMiniGameRuntime()) {
      if ((this.mGameBrandRuntime != null) && (this.mGameBrandRuntime.getApkgInfo() != null)) {}
    }
    while (this.mAppBrandRuntime == null)
    {
      return;
      StorageUtil.getPreference().edit().putBoolean(this.mGameBrandRuntime.getApkgInfo().appId + "_debug", paramBoolean).apply();
      return;
    }
    StorageUtil.getPreference().edit().putBoolean(this.mAppBrandRuntime.apkgInfo.appId + "_debug", paramBoolean).apply();
  }
  
  public void setIsOpenMonitorPanel(boolean paramBoolean)
  {
    if (isMiniGameRuntime()) {
      this.isOpenMonitorPanel = paramBoolean;
    }
    while (this.mAppBrandRuntime == null) {
      return;
    }
    this.mAppBrandRuntime.setOpenMonitorPanel(paramBoolean);
  }
  
  public void setUnReadCount(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      unReadCount = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("CapsuleButton", 2, "forceUpdate : " + paramBoolean + "; setUnReadCount : " + paramInt);
      }
    }
    if (this.isMiniMsgTabShow) {
      return;
    }
    unReadCount = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("CapsuleButton", 2, "forceUpdate : " + paramBoolean + "; setUnReadCount : " + paramInt);
    }
    updateRedDotVisible();
  }
  
  public void showKingCardTips()
  {
    QLog.i("CapsuleButton", 1, "showKingCardTips trigger");
    if (getVisibility() != 0) {
      QLog.i("CapsuleButton", 1, "showKingCardTips 小程序官方模式下是 GONE状态，不需要展示");
    }
    Activity localActivity;
    do
    {
      return;
      localActivity = getActivity();
    } while ((this.mMoreView == null) || (localActivity == null) || (localActivity.isFinishing()) || (!shouldShowKingCardTip()));
    AppBrandTask.runTaskOnUiThreadIfNot(new CapsuleButton.9(this, localActivity));
  }
  
  public void showShareMenuForInnerShareButton(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, HashMap<String, Integer> paramHashMap, int paramInt)
  {
    QLog.d("CapsuleButton", 1, "showShareMenuForInnerShareButton --  isMiniMsgTabShow : " + this.isMiniMsgTabShow);
    if (this.isMiniMsgTabShow) {}
    label212:
    label1113:
    label1250:
    for (;;)
    {
      return;
      this.launchFrom = 1;
      this.tapIndexMap = paramHashMap;
      this.actionSheetCallbackId = paramInt;
      int k = 1;
      boolean bool5 = true;
      Object localObject2 = "";
      Object localObject1 = "";
      boolean bool3 = false;
      boolean bool4 = false;
      int i = 0;
      boolean bool2 = false;
      boolean bool1 = false;
      paramHashMap = "light";
      Object localObject3;
      boolean bool6;
      int j;
      if (isMiniGameRuntime()) {
        if ((this.mGameBrandRuntime != null) && (this.mGameBrandRuntime.activity != null) && (!this.isMiniMsgTabShow))
        {
          localObject3 = this.mGameBrandRuntime.getApkgInfo().appId;
          String str1 = this.mGameBrandRuntime.getApkgInfo().apkgName;
          bool4 = ((GameActivity)this.mGameBrandRuntime.activity).getIsOrientationLandscape();
          String str2 = ((GameActivity)this.mGameBrandRuntime.activity).getMenuStyle();
          bool6 = this.mGameBrandRuntime.getApkgInfo().appConfig.isLimitedAccessApp();
          if (this.mGameBrandRuntime.getApkgInfo().appConfig.launchParam.entryModel != null)
          {
            j = 1;
            paramHashMap = str2;
            i = j;
            bool2 = bool6;
            bool3 = bool4;
            localObject1 = str1;
            localObject2 = localObject3;
            paramInt = k;
            if (j != 0)
            {
              bool1 = this.mGameBrandRuntime.getApkgInfo().appConfig.launchParam.entryModel.isAdmin;
              paramInt = k;
              localObject2 = localObject3;
              localObject1 = str1;
              bool3 = bool4;
              bool2 = bool6;
              i = j;
              paramHashMap = str2;
            }
            if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_share_to_wx_switcher", 1) == 1) {
              break label1219;
            }
            paramBoolean3 = false;
            paramBoolean4 = false;
            localObject3 = localObject1;
            k = i;
            i = -1;
            bool4 = false;
            j = paramInt;
            paramInt = k;
            localObject1 = paramHashMap;
            paramHashMap = (HashMap<String, Integer>)localObject3;
          }
        }
      }
      for (;;)
      {
        if (j == 0) {
          break label1250;
        }
        localObject3 = new Intent();
        ((Intent)localObject3).putExtra("miniAppID", (String)localObject2);
        ((Intent)localObject3).putExtra("miniAppName", paramHashMap);
        if (isMiniGameRuntime())
        {
          bool6 = this.isOpenMonitorPanel;
          ((Intent)localObject3).putExtra("isOpenMonitorPanel", bool6);
          ((Intent)localObject3).putExtra("debugEnable", getEnableDebug());
          ((Intent)localObject3).putExtra("showDebug", false);
          ((Intent)localObject3).putExtra("showMonitor", false);
          ((Intent)localObject3).putExtra("menuStyle", (String)localObject1);
          ((Intent)localObject3).putExtra("showShareQQ", paramBoolean1);
          ((Intent)localObject3).putExtra("showShareQzone", paramBoolean2);
          ((Intent)localObject3).putExtra("showShareWeChatFriends", paramBoolean3);
          ((Intent)localObject3).putExtra("showShareWeChatMoment", paramBoolean4);
          ((Intent)localObject3).putExtra("topType", -11);
          ((Intent)localObject3).putExtra("showDetail", false);
          ((Intent)localObject3).putExtra("showSetting", false);
          ((Intent)localObject3).putExtra("showComplaint", false);
          ((Intent)localObject3).putExtra("addShortcut", false);
          ((Intent)localObject3).putExtra("showBackHome", i);
          ((Intent)localObject3).putExtra("isLandscape", bool3);
          ((Intent)localObject3).putExtra("isSpecialMiniApp", bool4);
          ((Intent)localObject3).putExtra("showKingcardTip", shouldShowKingCardTip());
          ((Intent)localObject3).putExtra("key_mini_msgtab_type", 1);
          ((Intent)localObject3).putExtra("key_mini_msgtab_need_action_sheet", true);
          ((Intent)localObject3).putExtra("is_limited_access_app", bool2);
          ((Intent)localObject3).putExtra("showRestartMiniApp", bool5);
          ((Intent)localObject3).putExtra("addToCurrentTroop", bool1);
          if (!isMiniGameRuntime()) {
            break label1113;
          }
          if ((this.mGameBrandRuntime != null) && (this.mGameBrandRuntime.getApkgInfo() != null))
          {
            ((Intent)localObject3).putExtra("key_mini_app_version_type", 1);
            ((Intent)localObject3).putExtra("key_mini_app_config", this.mGameBrandRuntime.getApkgInfo().appConfig);
            ((Intent)localObject3).putExtra("key_mini_app_is_game", true);
          }
          if ((!isMiniGameRuntime()) || (this.mGameBrandRuntime == null) || (this.mGameBrandRuntime.activity == null)) {
            break label1178;
          }
          MiniChatActivity.e(this.mGameBrandRuntime.activity, (Intent)localObject3, 1001);
          label742:
          if (paramInt == 0) {
            ((Intent)localObject3).putExtra("setToTroop", true);
          }
          this.mRedDot.setVisibility(8);
          this.isMiniMsgTabShow = true;
          unReadCount = 0;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("CapsuleButton", 1, "isMiniMsgTabShow true");
          return;
          j = 0;
          break label212;
          paramInt = 0;
          bool2 = bool4;
          break label294;
          if ((this.mAppBrandRuntime != null) && (this.mAppBrandRuntime.activity != null) && (!this.isMiniMsgTabShow))
          {
            if (this.mAppBrandRuntime.pageContainer.getCurrentPageWebview() == null) {
              break;
            }
            if ((!this.mAppBrandRuntime.apkgInfo.isEngineTypeMiniApp()) || (this.mAppBrandRuntime.pageContainer.getCurrentPage() == null) || (this.mAppBrandRuntime.getCurPage().getCurrentPageWebview() == null) || (this.mAppBrandRuntime.getCurPage().getCurrentPageWebview().enableShowBackHome())) {
              break label1213;
            }
          }
        }
        for (bool1 = false;; bool1 = true)
        {
          localObject2 = this.mAppBrandRuntime.apkgInfo.appId;
          paramHashMap = this.mAppBrandRuntime.apkgInfo.apkgName;
          bool4 = this.mAppBrandRuntime.apkgInfo.appConfig.config.isSpecialMiniApp();
          bool3 = this.mAppBrandRuntime.apkgInfo.appConfig.config.isLimitedAccessApp();
          if (this.mAppBrandRuntime.apkgInfo.appConfig.launchParam.entryModel != null) {}
          for (paramInt = 1;; paramInt = 0)
          {
            if (paramInt != 0) {
              bool2 = this.mAppBrandRuntime.apkgInfo.appConfig.launchParam.entryModel.isAdmin;
            }
            if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_share_to_wx_switcher", 1) != 1)
            {
              paramBoolean3 = false;
              paramBoolean4 = false;
            }
            bool5 = bool1;
            bool1 = bool2;
            localObject1 = "light";
            bool2 = bool3;
            bool3 = false;
            j = 1;
            i = -1;
            break;
          }
          paramHashMap = "";
          bool3 = false;
          bool2 = false;
          paramInt = 0;
          bool1 = false;
          localObject1 = "light";
          j = 0;
          i = -1;
          bool4 = false;
          break;
          bool6 = this.mAppBrandRuntime.isOpenMonitorPanel();
          break label395;
          if ((this.mAppBrandRuntime == null) || (this.mAppBrandRuntime.apkgInfo == null)) {
            break label703;
          }
          ((Intent)localObject3).putExtra("key_mini_app_version_type", this.mAppBrandRuntime.versionType);
          ((Intent)localObject3).putExtra("key_mini_app_config", this.mAppBrandRuntime.apkgInfo.appConfig);
          ((Intent)localObject3).putExtra("key_mini_app_is_game", false);
          break label703;
          if ((isMiniGameRuntime()) || (this.mAppBrandRuntime.activity == null)) {
            break label742;
          }
          MiniChatActivity.e(this.mAppBrandRuntime.activity, (Intent)localObject3, 1001);
          break label742;
        }
        localObject3 = paramHashMap;
        j = paramInt;
        k = -1;
        bool4 = false;
        paramHashMap = (HashMap<String, Integer>)localObject1;
        localObject1 = localObject3;
        paramInt = i;
        i = k;
      }
    }
  }
  
  public void updateRedDotVisible()
  {
    AppBrandTask.runTaskOnUiThreadIfNot(new CapsuleButton.5(this));
  }
  
  public void updateStyle(int paramInt)
  {
    if ((this.mMoreView != null) && (this.mCloseView != null) && (this.mSplider != null))
    {
      if (paramInt == -1)
      {
        this.mMoreView.setImageResource(2130842082);
        this.mCloseView.setImageResource(2130842076);
        this.mSplider.setBackgroundColor(Color.parseColor("#4DFFFFFF"));
      }
    }
    else {
      return;
    }
    this.mMoreView.setImageResource(2130842079);
    this.mCloseView.setImageResource(2130842073);
    this.mSplider.setBackgroundColor(Color.parseColor("#1A000000"));
  }
  
  public void updateUI() {}
  
  public static abstract interface onActivityFinishListener
  {
    public abstract void onActivityFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton
 * JD-Core Version:    0.7.0.1
 */