package com.tencent.qqmini.miniapp.core.page;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.qqmini.miniapp.R.anim;
import com.tencent.qqmini.miniapp.core.EventListener;
import com.tencent.qqmini.miniapp.core.page.pool.AppBrandPagePool;
import com.tencent.qqmini.miniapp.plugin.EmbeddedWidgetClientFactory;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.Preloadable;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper;
import com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.SoftKeyboardStateListener;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.AppPageInfo;
import com.tencent.qqmini.sdk.launcher.core.model.AppPageInfo.Builder;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.manager.ApkgManager;
import com.tencent.qqmini.sdk.monitor.ui.MiniAppMonitorInfoView;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import com.tencent.qqmini.sdk.widget.CapsuleButton;
import com.tencent.qqmini.sdk.widget.CoverView;
import com.tencent.qqmini.sdk.widget.CoverView.JsRuntimeListener;
import com.tencent.qqmini.sdk.widget.NavigationBar;
import com.tencent.qqmini.sdk.widget.TabBar;
import com.tencent.qqmini.sdk.widget.TabBar.OnTabItemClickListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@MiniKeep
public class AppBrandPageContainer
  extends FrameLayout
  implements IAppBrandPageContainer, Preloadable, TabBar.OnTabItemClickListener
{
  public static final String KEY_APPID = "appId";
  public static final String KEY_SCENE = "scene";
  public static final int MAX_AliveWebViewCount = 10;
  public static final String ON_APP_ENTER_BACKGROUND = "onAppEnterBackground";
  public static final String ON_APP_ENTER_FOREGROUND = "onAppEnterForeground";
  public static final String ON_KEYBOARD_HEIGHT_CHANGE = "onKeyboardHeightChange";
  private static final String TAG = "minisdk-start-AppBrandPageContainer";
  public int aliveWebViewCount = 0;
  private LinkedList<AppBrandPage> appBrandPages = new LinkedList();
  private int curShowingInputId = -1;
  private Activity mActivity;
  private ApkgInfo mApkgInfo;
  private AppBrandPagePool mAppBrandPagePool;
  private MonitorBroadcastReceiver mBroadcastReceiver;
  private IMiniAppContext mContext;
  EventListener mEventListener;
  private boolean mFromReload = false;
  private MiniAppInfo mMiniAppInfo;
  private MiniAppMonitorInfoView mMiniAppMonitorInfoView;
  private SoftKeyboardStateHelper mSoftKeyboardStateHelper;
  private List<SoftKeyboardStateHelper.SoftKeyboardStateListener> mSoftKeyboardStateListenerList = new CopyOnWriteArrayList();
  
  public AppBrandPageContainer(IMiniAppContext paramIMiniAppContext, EventListener paramEventListener)
  {
    super(paramIMiniAppContext.getContext());
    this.mContext = paramIMiniAppContext;
    this.mEventListener = paramEventListener;
    this.mSoftKeyboardStateHelper = new SoftKeyboardStateHelper(this);
    this.mAppBrandPagePool = new AppBrandPagePool(paramIMiniAppContext);
    this.mSoftKeyboardStateHelper.addSoftKeyboardStateListener(new AppBrandPageContainer.1(this));
  }
  
  private void executeDownSubPackage(String paramString1, String paramString2)
  {
    WeakReference localWeakReference = new WeakReference(this);
    ApkgManager.getInstance().downloadSubPack(this.mApkgInfo, this.mContext.getMiniAppInfo(), paramString1, new AppBrandPageContainer.3(this, paramString1, localWeakReference, paramString2));
  }
  
  private AppBrandPage getBrandPage()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.appBrandPages != null)
    {
      localObject1 = localObject2;
      if (this.appBrandPages.size() > 0)
      {
        localObject2 = (AppBrandPage)this.appBrandPages.poll();
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          ((AppBrandPage)localObject2).onPause();
          localObject1 = localObject2;
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = this.mAppBrandPagePool.getAppBrandPage(this.mContext, this);
      addView((View)localObject2, new FrameLayout.LayoutParams(-1, -1));
    }
    return localObject2;
  }
  
  private String getMenuButtonBoundingClientRect(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    Object localObject = getCapsuleButton();
    int j;
    int i;
    if (localObject != null)
    {
      j = (int)(((View)localObject).getWidth() / DisplayUtil.getDensity(this.mActivity));
      i = (int)(((View)localObject).getHeight() / DisplayUtil.getDensity(this.mActivity));
      int k = (int)(((View)localObject).getLeft() / DisplayUtil.getDensity(this.mActivity));
      int m = (int)(((View)localObject).getTop() / DisplayUtil.getDensity(this.mActivity));
      int n = (int)(((View)localObject).getRight() / DisplayUtil.getDensity(this.mActivity));
      int i1 = (int)(((View)localObject).getBottom() / DisplayUtil.getDensity(this.mActivity));
      localObject = new Rect(267, 34, 347, 64);
      if (j == 0) {
        break label328;
      }
      localObject = new Rect(k, m, n, i1);
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("width", j);
        localJSONObject.put("height", i);
        localJSONObject.put("top", ((Rect)localObject).top);
        localJSONObject.put("right", ((Rect)localObject).right);
        localJSONObject.put("bottom", ((Rect)localObject).bottom);
        localJSONObject.put("left", ((Rect)localObject).left);
        paramNativeViewRequestEvent.ok();
        QMLog.d("minisdk-start-AppBrandPageContainer", "getMenuButtonBoundingClientRect : " + localJSONObject.toString());
        localObject = localJSONObject.toString();
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        QMLog.e("minisdk-start-AppBrandPageContainer", paramNativeViewRequestEvent.event + " error.", localJSONException);
        return "";
      }
      QMLog.e("minisdk-start-AppBrandPageContainer", "EVENT_GET_MENU_BUTTON_RECT view is null.");
      paramNativeViewRequestEvent.fail();
      return getMenuButtonDefaultValue();
      label328:
      i = 30;
      j = 80;
    }
  }
  
  private String getMenuButtonDefaultValue()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("width", 80);
      ((JSONObject)localObject).put("height", 30);
      ((JSONObject)localObject).put("top", 34);
      ((JSONObject)localObject).put("right", 347);
      ((JSONObject)localObject).put("bottom", 64);
      ((JSONObject)localObject).put("left", 267);
      QMLog.d("minisdk-start-AppBrandPageContainer", "getMenuButtonDefaultValue : " + ((JSONObject)localObject).toString());
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("minisdk-start-AppBrandPageContainer", "getDefaultValue error.", localJSONException);
    }
    return "";
  }
  
  private NativeViewContainer getNativeViewContainer()
  {
    PageWebviewContainer localPageWebviewContainer = getPageWebviewContainer();
    if (localPageWebviewContainer == null) {
      return null;
    }
    return localPageWebviewContainer.getNativeViewContainer();
  }
  
  private PageWebviewContainer getPageWebviewContainer()
  {
    AppBrandPage localAppBrandPage = getShowingPage();
    if (localAppBrandPage == null) {
      return null;
    }
    return localAppBrandPage.getPageWebviewContainer();
  }
  
  private void handleOnTabItemTap(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("index", paramInt);
      localJSONObject.put("pagePath", paramString1);
      localJSONObject.put("text", paramString2);
      this.mContext.performAction(ServiceSubscribeEvent.obtain("onTabItemTap", localJSONObject.toString(), getShowingPageWebViewId()));
      return;
    }
    catch (Throwable paramString1)
    {
      QMLog.e("minisdk-start-AppBrandPageContainer", "onTabItemClick error,", paramString1);
    }
  }
  
  private String handlePageEvent(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    if ("setEnableDebug".equals(paramNativeViewRequestEvent.event))
    {
      try
      {
        boolean bool = new JSONObject(paramNativeViewRequestEvent.jsonParams).optBoolean("enableDebug");
        if (bool != Boolean.valueOf(StorageUtil.getPreference().getBoolean(this.mContext.getMiniAppInfo().appId + "_debug", false)).booleanValue()) {
          this.mContext.getAttachedActivity().runOnUiThread(new AppBrandPageContainer.4(this, bool));
        } else {
          paramNativeViewRequestEvent.ok();
        }
      }
      catch (JSONException localJSONException)
      {
        paramNativeViewRequestEvent.fail();
      }
    }
    else if ("setBackgroundTextStyle".equals(paramNativeViewRequestEvent.event))
    {
      AppBrandTask.runTaskOnUiThread(new AppBrandPageContainer.5(this, paramNativeViewRequestEvent));
    }
    else if ("setBackgroundColor".equals(paramNativeViewRequestEvent.event))
    {
      AppBrandTask.runTaskOnUiThread(new AppBrandPageContainer.6(this, paramNativeViewRequestEvent));
    }
    else
    {
      if ("getMenuButtonBoundingClientRect".equals(paramNativeViewRequestEvent.event)) {
        return getMenuButtonBoundingClientRect(paramNativeViewRequestEvent);
      }
      if ("reportKeyValue".equals(paramNativeViewRequestEvent.event)) {
        reportKeyValue(paramNativeViewRequestEvent);
      }
    }
    return null;
  }
  
  private void initMonitor()
  {
    if (this.mActivity == null) {
      return;
    }
    this.mBroadcastReceiver = new MonitorBroadcastReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action.qq.miniapp.show.monitorview");
    this.mActivity.registerReceiver(this.mBroadcastReceiver, localIntentFilter);
  }
  
  private boolean isMonitorViewShowing()
  {
    return (this.mMiniAppMonitorInfoView != null) && (this.mMiniAppMonitorInfoView.getVisibility() == 0);
  }
  
  private boolean isUrlReady(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mApkgInfo != null)
    {
      bool1 = bool2;
      if (this.mApkgInfo.isUrlResReady(paramString, this.mContext.getMiniAppInfo()))
      {
        bool1 = bool2;
        if (this.mApkgInfo.isUrlFileExist(paramString)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void reportKeyValue(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    for (;;)
    {
      int i;
      Object localObject;
      int j;
      long l;
      try
      {
        MiniAppInfo localMiniAppInfo = this.mContext.getMiniAppInfo();
        JSONArray localJSONArray = new JSONObject(paramNativeViewRequestEvent.jsonParams).getJSONArray("dataArray");
        i = 0;
        if (i < localJSONArray.length())
        {
          localObject = localJSONArray.getJSONObject(i);
          j = ((JSONObject)localObject).getInt("key");
          if (15496 == j)
          {
            localObject = ((JSONObject)localObject).getString("value").split(",");
            if ((localObject.length > 8) && (!localObject[0].equals("2")))
            {
              j = Integer.parseInt(localObject[7]);
              if (j > 0)
              {
                QMLog.e("minisdk-start-AppBrandPageContainer", paramNativeViewRequestEvent.event + " REPORT_EVENT_Display: " + j);
                MiniReportManager.reportEventType(localMiniAppInfo, 638, null, null, null, 0, "0", j, null);
              }
            }
          }
          else if (13544 == j)
          {
            localObject = ((JSONObject)localObject).getString("value").split(",");
            j = Integer.parseInt(localObject[0]);
            if ((9 != j) && (6 != j)) {
              break label416;
            }
            l = Long.parseLong(localObject[1]);
            l = Long.parseLong(localObject[4]) - l;
            if (l <= 0L) {
              break label416;
            }
            QMLog.e("minisdk-start-AppBrandPageContainer", paramNativeViewRequestEvent.event + " REPORT_EVENT_Speed: " + l);
            if (9 == j) {
              MiniReportManager.reportEventType(localMiniAppInfo, 636, null, null, null, 0, "0", l, null);
            }
          }
        }
      }
      catch (Exception localException1)
      {
        QMLog.e("minisdk-start-AppBrandPageContainer", paramNativeViewRequestEvent.event + " error.", localException1);
      }
      return;
      MiniReportManager.reportEventType(localException1, 637, null, null, null, 0, "0", l, null);
      break label416;
      if (13582 == j)
      {
        localObject = ((JSONObject)localObject).getString("value");
        try
        {
          MiniReportManager.reportJsError(localException1, getCurrentPageUrl(), (String)localObject);
        }
        catch (Exception localException2)
        {
          QMLog.e("minisdk-start-AppBrandPageContainer", paramNativeViewRequestEvent.event + " REPORT_EVENT_JS_EXCEPTION: failed:", localException2);
        }
      }
      label416:
      i += 1;
    }
  }
  
  private void sendBackGroundToJs()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("scene", this.mMiniAppInfo.launchParam.scene);
      localJSONObject.put("appId", this.mContext.getMiniAppInfo().appId);
      if (this.mEventListener != null) {
        this.mEventListener.onWebViewEvent("onAppEnterBackground", localJSONObject.toString(), 0);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        QMLog.w("minisdk-start-AppBrandPageContainer", "onPause,paramsObj", localJSONException);
      }
    }
  }
  
  private void sendForegroundToJs()
  {
    boolean bool;
    Object localObject1;
    if ((this.mFromReload) && (this.mEventListener != null) && (this.mEventListener.isFirstDomReady()) && (!TextUtils.isEmpty(this.mMiniAppInfo.launchParam.entryPath)))
    {
      bool = true;
      localObject1 = this.mMiniAppInfo.launchParam.entryPath;
      this.mFromReload = false;
    }
    for (;;)
    {
      if ((this.mEventListener != null) && (this.mEventListener.isFirstDomReady()))
      {
        Object localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = localObject1;
          if (getShowingPage() != null) {
            localObject2 = getShowingPage().getCurShowingUrl();
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = AppBrandUtil.getAppLaunchInfo((String)localObject2, this.mMiniAppInfo);
        }
      }
      try
      {
        ((JSONObject)localObject1).put("reLaunch", bool);
        QMLog.i("minisdk-start-AppBrandPageContainer", "appLaunchInfo : " + ((JSONObject)localObject1).toString());
        this.mEventListener.onWebViewEvent("onAppEnterForeground", ((JSONObject)localObject1).toString(), 0);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QMLog.e("minisdk-start-AppBrandPageContainer", "appLaunchInfo error.", localThrowable);
        }
      }
      localObject1 = null;
      bool = false;
    }
  }
  
  public boolean addCoverView(int paramInt1, int paramInt2, CoverView paramCoverView, boolean paramBoolean)
  {
    NativeViewContainer localNativeViewContainer = getNativeViewContainer();
    if (localNativeViewContainer != null) {
      return localNativeViewContainer.addCoverView(paramInt1, paramInt2, paramCoverView, paramBoolean);
    }
    return false;
  }
  
  public boolean addNativeView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramView == null) {}
    NativeViewContainer localNativeViewContainer;
    do
    {
      return false;
      localNativeViewContainer = getNativeViewContainer();
    } while (localNativeViewContainer == null);
    if (paramLayoutParams != null) {
      localNativeViewContainer.addView(paramView, paramLayoutParams);
    }
    for (;;)
    {
      return true;
      localNativeViewContainer.addView(paramView);
    }
  }
  
  public void cleanup(boolean paramBoolean)
  {
    Iterator localIterator = this.appBrandPages.iterator();
    while (localIterator.hasNext())
    {
      AppBrandPage localAppBrandPage = (AppBrandPage)localIterator.next();
      if ((localAppBrandPage != null) && ((!paramBoolean) || (this.mApkgInfo == null) || (!this.mApkgInfo.isTabBarPage(localAppBrandPage.getCurShowingUrl()))))
      {
        localAppBrandPage.onPause();
        localAppBrandPage.cleanUp();
        removeView(localAppBrandPage);
        localIterator.remove();
      }
    }
  }
  
  public String dispatchEventToNativeView(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramNativeViewRequestEvent.dispatchTarget == 3) {
      localObject1 = handlePageEvent(paramNativeViewRequestEvent);
    }
    Object localObject3;
    do
    {
      do
      {
        do
        {
          do
          {
            return localObject1;
            localObject3 = getShowingPage();
            localObject1 = localObject2;
          } while (localObject3 == null);
          if (paramNativeViewRequestEvent.dispatchTarget == 0) {
            return ((AppBrandPage)localObject3).handleNativeUIEvent(paramNativeViewRequestEvent);
          }
          localObject3 = ((AppBrandPage)localObject3).getPageWebviewContainer();
          localObject1 = localObject2;
        } while (localObject3 == null);
        if (paramNativeViewRequestEvent.dispatchTarget == 1) {
          return ((PageWebviewContainer)localObject3).handleNativeUIEvent(paramNativeViewRequestEvent);
        }
        localObject3 = ((PageWebviewContainer)localObject3).getNativeViewContainer();
        localObject1 = localObject2;
      } while (localObject3 == null);
      localObject1 = localObject2;
    } while (paramNativeViewRequestEvent.dispatchTarget != 2);
    return ((NativeViewContainer)localObject3).handleNativeUIEvent(paramNativeViewRequestEvent);
  }
  
  public void dispatchEventToWebView(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
      paramArrayOfInt = this.appBrandPages.iterator();
    }
    while (paramArrayOfInt.hasNext())
    {
      Object localObject = (AppBrandPage)paramArrayOfInt.next();
      if ((localObject != null) && (((AppBrandPage)localObject).getBrandPageWebview() != null))
      {
        ((AppBrandPage)localObject).getBrandPageWebview().evaluateSubscribeJSInService(paramString1, paramString2, ((AppBrandPage)localObject).getPageWebviewId());
        continue;
        int j = paramArrayOfInt.length;
        int i = 0;
        while (i < j)
        {
          int k = paramArrayOfInt[i];
          localObject = this.appBrandPages.iterator();
          while (((Iterator)localObject).hasNext())
          {
            AppBrandPage localAppBrandPage = (AppBrandPage)((Iterator)localObject).next();
            if ((localAppBrandPage.getBrandPageWebview() != null) && (k == localAppBrandPage.getPageWebviewId())) {
              localAppBrandPage.getBrandPageWebview().evaluateSubscribeJSInService(paramString1, paramString2, k);
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public boolean doDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    try
    {
      getShowingPage().getBrandPageWebview().doDispatchKeyEvent(paramKeyEvent);
      return false;
    }
    catch (Throwable paramKeyEvent)
    {
      for (;;)
      {
        QMLog.e("minisdk-start-AppBrandPageContainer", "doDispatchKeyEvent error,", paramKeyEvent);
      }
    }
  }
  
  public AppBrandPagePool getAppBrandPagePool()
  {
    return this.mAppBrandPagePool;
  }
  
  public CapsuleButton getCapsuleButton()
  {
    AppBrandPage localAppBrandPage = getShowingPage();
    if (localAppBrandPage != null) {
      return localAppBrandPage.getCapsuleButton();
    }
    return null;
  }
  
  public View getContentView()
  {
    return this;
  }
  
  public CoverView getCoverView(int paramInt)
  {
    NativeViewContainer localNativeViewContainer = getNativeViewContainer();
    if (localNativeViewContainer != null) {
      return localNativeViewContainer.getCoverView(paramInt);
    }
    return null;
  }
  
  public int getCurShowingInputId()
  {
    return this.curShowingInputId;
  }
  
  public String getCurrentPageUrl()
  {
    if (getShowingPage() != null) {
      return getShowingPage().getCurShowingUrl();
    }
    return "";
  }
  
  public EmbeddedWidgetClientFactory getCurrentX5EmbeddedWidgetClientFactory()
  {
    AbsAppBrandPage localAbsAppBrandPage = (AbsAppBrandPage)this.appBrandPages.peek();
    if ((localAbsAppBrandPage != null) && (localAbsAppBrandPage.getCurrentPageWebview() != null)) {
      return localAbsAppBrandPage.getCurrentPageWebview().getEmbeddedWidgetClientFactory();
    }
    return null;
  }
  
  public CoverView.JsRuntimeListener getJsRuntimeListener()
  {
    return getPageWebviewContainer();
  }
  
  public String getNaviBarStyle()
  {
    Object localObject = (AppBrandPage)this.appBrandPages.peek();
    if (localObject != null)
    {
      localObject = ((AppBrandPage)localObject).getNavBar();
      if (localObject != null) {
        return ((NavigationBar)localObject).getNavbarStyle();
      }
      return "default";
    }
    return "default";
  }
  
  public int getNaviBarTextStyle()
  {
    Object localObject = (AppBrandPage)this.appBrandPages.peek();
    if (localObject != null)
    {
      localObject = ((AppBrandPage)localObject).getNavBar();
      if (localObject != null) {
        return ((NavigationBar)localObject).getStatusNavigationBarTextStyle();
      }
      return -1;
    }
    return -1;
  }
  
  public int getNaviBarVisibility()
  {
    Object localObject = (AppBrandPage)this.appBrandPages.peek();
    if (localObject != null)
    {
      localObject = ((AppBrandPage)localObject).getNavBar();
      if (localObject != null) {
        return ((NavigationBar)localObject).getVisibility();
      }
      return 8;
    }
    return 8;
  }
  
  public int getPageCount()
  {
    if (this.appBrandPages != null) {
      return this.appBrandPages.size();
    }
    return 0;
  }
  
  public AppPageInfo getPageInfo(int paramInt)
  {
    AppPageInfo.Builder localBuilder = new AppPageInfo.Builder();
    Object localObject = (AbsAppBrandPage)this.appBrandPages.peek();
    if ((AppPageInfo.enableGetPageId(paramInt)) && (localObject != null) && (((AbsAppBrandPage)localObject).getCurrentPageWebview() != null)) {
      localBuilder.setPageId(((AbsAppBrandPage)localObject).getCurrentPageWebview().getPageWebViewId());
    }
    if (AppPageInfo.enableGetPageUrl(paramInt)) {
      if (localObject == null) {
        break label114;
      }
    }
    label114:
    for (localObject = ((AbsAppBrandPage)localObject).getCurShowingUrl();; localObject = null)
    {
      localBuilder.setPageUrl((String)localObject);
      if (AppPageInfo.enableGetPageWindowWidth(paramInt)) {
        localBuilder.setWindowWidth(getPageWebviewContainer().getWidth());
      }
      if (AppPageInfo.enableGetPageWindowHeight(paramInt)) {
        localBuilder.setWindowHeight(getPageWebviewContainer().getHeight());
      }
      return localBuilder.build();
    }
  }
  
  public String getPageOrientation()
  {
    PageWebviewContainer localPageWebviewContainer = getPageWebviewContainer();
    if (localPageWebviewContainer != null) {
      return localPageWebviewContainer.getPageOrientation();
    }
    return "";
  }
  
  public AppBrandPage getShowingPage()
  {
    if (getPageCount() > 0) {
      return (AppBrandPage)this.appBrandPages.peek();
    }
    return null;
  }
  
  public int getShowingPageWebViewId()
  {
    if ((this.appBrandPages != null) && (this.appBrandPages.peek() != null)) {
      return ((AppBrandPage)this.appBrandPages.peek()).getPageWebviewId();
    }
    return -1;
  }
  
  public int getTabBarVisibility()
  {
    Object localObject = (AppBrandPage)this.appBrandPages.peek();
    if (localObject != null)
    {
      localObject = ((AppBrandPage)localObject).getTabBar();
      if (localObject != null) {
        return ((TabBar)localObject).getVisibility();
      }
      return 8;
    }
    return 8;
  }
  
  public void hideSoftInput(View paramView)
  {
    if (paramView != null)
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)paramView.getContext().getSystemService("input_method");
      if (localInputMethodManager != null) {
        localInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      }
    }
  }
  
  public void init(Object paramObject)
  {
    if (this.mAppBrandPagePool != null) {
      this.mAppBrandPagePool.preLoadAppBrandPage(this.mContext, this);
    }
  }
  
  public void initBaseJs(BaselibLoader.BaselibContent paramBaselibContent)
  {
    if (this.mAppBrandPagePool != null) {
      this.mAppBrandPagePool.initBaseJs(this, paramBaselibContent);
    }
  }
  
  public boolean isCurrentTabBarPage()
  {
    AppBrandPage localAppBrandPage = getShowingPage();
    if (localAppBrandPage != null) {
      return localAppBrandPage.isTabBarPage();
    }
    return false;
  }
  
  public void launch(String paramString1, String paramString2)
  {
    QMLog.i("minisdk-start-AppBrandPageContainer", "launch url : " + paramString1 + "; type : " + paramString2);
    if (!isUrlReady(paramString1))
    {
      executeDownSubPackage(paramString1, paramString2);
      return;
    }
    AppBrandPage localAppBrandPage = this.mAppBrandPagePool.getAppBrandPage(this.mContext, this);
    this.appBrandPages.push(localAppBrandPage);
    localAppBrandPage.loadUrl(paramString1, paramString2, this.mEventListener);
    addView(localAppBrandPage, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public boolean navigateBack(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    QMLog.i("minisdk-start-AppBrandPageContainer", "navigateBack delta : " + paramInt1);
    Object localObject = getShowingPage();
    boolean bool1;
    if ((localObject != null) && (((AppBrandPage)localObject).handleBackPressed())) {
      bool1 = true;
    }
    int i;
    do
    {
      do
      {
        return bool1;
        i = getPageCount();
        bool1 = bool2;
      } while (i < 2);
      bool1 = bool2;
    } while (paramInt1 < 1);
    paramInt2 = paramInt1;
    if (paramInt1 >= i) {
      paramInt2 = i - 1;
    }
    localObject = this.appBrandPages.iterator();
    paramInt1 = 0;
    for (;;)
    {
      if ((paramInt1 >= paramInt2) || (this.appBrandPages.size() < 1))
      {
        localObject = (AppBrandPage)this.appBrandPages.peek();
        if (localObject != null)
        {
          ((AppBrandPage)localObject).onResume(true);
          if ((this.mContext != null) && (this.mContext.getAttachedActivity() != null) && (!this.mContext.getAttachedActivity().isFinishing())) {
            ((AppBrandPage)localObject).updateWidowInfo(this.mContext.getAttachedActivity());
          }
          this.mEventListener.onWebViewReady("navigateBack", ((AppBrandPage)localObject).getCurShowingUrl(), ((AppBrandPage)localObject).getPageWebviewId());
        }
        return true;
      }
      if (((Iterator)localObject).hasNext())
      {
        AppBrandPage localAppBrandPage = (AppBrandPage)((Iterator)localObject).next();
        if (localAppBrandPage != null)
        {
          Animation localAnimation = AnimationUtils.loadAnimation(AppLoaderFactory.g().getMiniAppEnv().getContext(), R.anim.mini_sdk_page_slide_out_to_right);
          localAnimation.setDuration(200L);
          localAnimation.setAnimationListener(new AppBrandPageContainer.2(this, localAppBrandPage));
          localAppBrandPage.startAnimation(localAnimation);
          localAppBrandPage.onPause();
          ((Iterator)localObject).remove();
        }
      }
      paramInt1 += 1;
    }
  }
  
  public void navigateTo(String paramString, int paramInt)
  {
    QMLog.i("minisdk-start-AppBrandPageContainer", "navigateTo url : " + paramString);
    if (this.aliveWebViewCount > 10)
    {
      Toast.makeText(getContext(), "打开页面超过上限，请返回", 0).show();
      QMLog.e("minisdk-start-AppBrandPageContainer", "打开WebView数量超过上限");
      return;
    }
    if (!isUrlReady(paramString))
    {
      executeDownSubPackage(paramString, "navigateTo");
      return;
    }
    AppBrandPage localAppBrandPage = (AppBrandPage)this.appBrandPages.peek();
    if (localAppBrandPage != null) {
      localAppBrandPage.onPause();
    }
    localAppBrandPage = this.mAppBrandPagePool.getAppBrandPage(this.mContext, this);
    this.appBrandPages.push(localAppBrandPage);
    localAppBrandPage.loadUrl(paramString, "navigateTo", this.mEventListener);
    if (!localAppBrandPage.isHomePage()) {
      localAppBrandPage.setVisibility(4);
    }
    addView(localAppBrandPage, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public void notifyOnAddColorNote()
  {
    NativeViewContainer localNativeViewContainer = getNativeViewContainer();
    if (localNativeViewContainer != null) {
      localNativeViewContainer.notifyOnColorNoteAnimStart();
    }
  }
  
  public void notifyOnPageWebViewDestory()
  {
    NativeViewContainer localNativeViewContainer = getNativeViewContainer();
    if (localNativeViewContainer != null) {
      localNativeViewContainer.notifyOnPageWebViewDestory();
    }
  }
  
  public void notifyOnPageWebViewPause()
  {
    NativeViewContainer localNativeViewContainer = getNativeViewContainer();
    if (localNativeViewContainer != null) {
      localNativeViewContainer.notifyOnPageWebViewPause();
    }
  }
  
  public void notifyOnPageWebViewResume()
  {
    NativeViewContainer localNativeViewContainer = getNativeViewContainer();
    if (localNativeViewContainer != null) {
      localNativeViewContainer.notifyOnPageWebViewResume();
    }
  }
  
  public void onAttachedToActivity(Activity paramActivity)
  {
    this.mActivity = paramActivity;
    initMonitor();
    AppBrandPage localAppBrandPage = (AppBrandPage)this.appBrandPages.peek();
    if (localAppBrandPage != null) {
      localAppBrandPage.updateWidowInfo(paramActivity);
    }
  }
  
  public void onDestroy()
  {
    if (this.mAppBrandPagePool != null)
    {
      this.mAppBrandPagePool.destroyCachePage();
      this.mAppBrandPagePool = null;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.mBroadcastReceiver != null) && (this.mActivity != null))
    {
      this.mActivity.unregisterReceiver(this.mBroadcastReceiver);
      this.mBroadcastReceiver = null;
    }
  }
  
  public void onPause()
  {
    if (this.mMiniAppInfo == null) {
      return;
    }
    AppBrandPage localAppBrandPage = (AppBrandPage)this.appBrandPages.peek();
    if (localAppBrandPage != null) {
      localAppBrandPage.onPause();
    }
    sendBackGroundToJs();
  }
  
  public void onResume()
  {
    sendForegroundToJs();
    AppBrandPage localAppBrandPage = (AppBrandPage)this.appBrandPages.peek();
    if (localAppBrandPage != null) {
      localAppBrandPage.onResume(false);
    }
  }
  
  public void onStop() {}
  
  public void onTabItemClick(int paramInt, String paramString1, String paramString2)
  {
    switchTab(paramString1);
    handleOnTabItemTap(paramInt, paramString1, paramString2);
  }
  
  public boolean operateCustomButton(String paramString, long paramLong, JSONObject paramJSONObject, View.OnClickListener paramOnClickListener)
  {
    return false;
  }
  
  public void recyclePreLoadAppBrandPage()
  {
    if (this.mAppBrandPagePool != null) {
      this.mAppBrandPagePool.destroyPageWebviewCache();
    }
  }
  
  public void redirectTo(String paramString, int paramInt)
  {
    QMLog.i("minisdk-start-AppBrandPageContainer", "redirectTo url : " + paramString);
    if (!isUrlReady(paramString))
    {
      executeDownSubPackage(paramString, "redirectTo");
      return;
    }
    if ((this.appBrandPages != null) && (this.appBrandPages.size() > 0))
    {
      localAppBrandPage = (AppBrandPage)this.appBrandPages.poll();
      if (localAppBrandPage != null)
      {
        localAppBrandPage.onPause();
        localAppBrandPage.cleanUp();
        removeView(localAppBrandPage);
      }
    }
    AppBrandPage localAppBrandPage = this.mAppBrandPagePool.getAppBrandPage(this.mContext, this);
    this.appBrandPages.push(localAppBrandPage);
    localAppBrandPage.loadUrl(paramString, "redirectTo", this.mEventListener);
    if (!localAppBrandPage.isHomePage()) {
      localAppBrandPage.setVisibility(4);
    }
    addView(localAppBrandPage, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public boolean removeCoverView(int paramInt)
  {
    NativeViewContainer localNativeViewContainer = getNativeViewContainer();
    if (localNativeViewContainer != null) {
      return localNativeViewContainer.removeCoverView(paramInt);
    }
    return false;
  }
  
  public boolean removeNativeView(View paramView)
  {
    if (paramView == null) {}
    NativeViewContainer localNativeViewContainer;
    do
    {
      return false;
      localNativeViewContainer = getNativeViewContainer();
    } while (localNativeViewContainer == null);
    localNativeViewContainer.removeView(paramView);
    return true;
  }
  
  public void removeSoftKeyboardStateListener(SoftKeyboardStateHelper.SoftKeyboardStateListener paramSoftKeyboardStateListener)
  {
    if ((paramSoftKeyboardStateListener == null) || (this.mSoftKeyboardStateListenerList == null)) {
      return;
    }
    this.mSoftKeyboardStateListenerList.remove(paramSoftKeyboardStateListener);
  }
  
  public void resetCurShowingInputId()
  {
    this.curShowingInputId = -1;
  }
  
  public void setCurShowingInputId(int paramInt)
  {
    this.curShowingInputId = paramInt;
  }
  
  public void setFromReload(boolean paramBoolean)
  {
    this.mFromReload = paramBoolean;
  }
  
  public boolean setMiniAIOEntranceVisible(boolean paramBoolean, JSONObject paramJSONObject)
  {
    AppBrandPage localAppBrandPage = getShowingPage();
    if (localAppBrandPage == null) {
      return false;
    }
    if (paramBoolean) {
      return localAppBrandPage.showMiniAIOEntrance(paramJSONObject);
    }
    localAppBrandPage.hideMiniAIOEntrance();
    return true;
  }
  
  public void setMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    this.mMiniAppInfo = paramMiniAppInfo;
    this.mApkgInfo = ((ApkgInfo)paramMiniAppInfo.apkgInfo);
  }
  
  public void setNaviBarStyle(String paramString)
  {
    Object localObject = (AppBrandPage)this.appBrandPages.peek();
    if (localObject != null)
    {
      localObject = ((AppBrandPage)localObject).getNavBar();
      if (localObject != null) {
        ((NavigationBar)localObject).setBarStyle(paramString);
      }
    }
  }
  
  public void setNaviVisibility(int paramInt)
  {
    Object localObject = (AppBrandPage)this.appBrandPages.peek();
    if (localObject != null)
    {
      localObject = ((AppBrandPage)localObject).getNavBar();
      if (localObject != null) {
        ((NavigationBar)localObject).setVisibility(paramInt);
      }
    }
  }
  
  public void setSoftKeyboardStateListener(SoftKeyboardStateHelper.SoftKeyboardStateListener paramSoftKeyboardStateListener)
  {
    if (paramSoftKeyboardStateListener == null) {
      return;
    }
    if (this.mSoftKeyboardStateListenerList == null) {
      this.mSoftKeyboardStateListenerList = new ArrayList();
    }
    this.mSoftKeyboardStateListenerList.add(paramSoftKeyboardStateListener);
  }
  
  public void setTabBarVisibility(int paramInt)
  {
    Object localObject = (AppBrandPage)this.appBrandPages.peek();
    if (localObject != null)
    {
      localObject = ((AppBrandPage)localObject).getTabBar();
      if (localObject != null) {
        ((TabBar)localObject).setVisibility(paramInt);
      }
    }
  }
  
  public void showSoftInput(View paramView)
  {
    if (paramView != null)
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)paramView.getContext().getSystemService("input_method");
      if (localInputMethodManager != null) {
        localInputMethodManager.showSoftInput(paramView, 0);
      }
    }
  }
  
  public void switchTab(String paramString)
  {
    QMLog.i("minisdk-start-AppBrandPageContainer", "switchTab url : " + paramString);
    cleanup(true);
    AppBrandPage localAppBrandPage = getBrandPage();
    this.appBrandPages.push(localAppBrandPage);
    localAppBrandPage.loadUrl(paramString, "switchTab", this.mEventListener);
  }
  
  public boolean toggleDebugPanel()
  {
    MiniAppInfo localMiniAppInfo;
    if (this.mContext != null)
    {
      localMiniAppInfo = this.mContext.getMiniAppInfo();
      if (DebugUtil.getDebugEnabled(localMiniAppInfo)) {
        break label38;
      }
    }
    label38:
    for (boolean bool = true;; bool = false)
    {
      DebugUtil.setDebugEnabled(localMiniAppInfo, bool);
      return bool;
      localMiniAppInfo = null;
      break;
    }
  }
  
  public boolean toggleMonitorPanel()
  {
    Activity localActivity = this.mContext.getAttachedActivity();
    if (localActivity != null)
    {
      if (this.mMiniAppMonitorInfoView != null) {
        break label82;
      }
      this.mMiniAppMonitorInfoView = new MiniAppMonitorInfoView(localActivity, null, 0);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 53;
      localActivity.addContentView(this.mMiniAppMonitorInfoView, localLayoutParams);
      this.mMiniAppMonitorInfoView.setVisibility(0);
      this.mMiniAppMonitorInfoView.startRefreshMonitorUi();
    }
    for (;;)
    {
      return isMonitorViewShowing();
      label82:
      if (this.mMiniAppMonitorInfoView.getVisibility() == 0)
      {
        this.mMiniAppMonitorInfoView.stopRefreshMonitorUi();
        this.mMiniAppMonitorInfoView.setVisibility(8);
      }
      else
      {
        this.mMiniAppMonitorInfoView.startRefreshMonitorUi();
        this.mMiniAppMonitorInfoView.setVisibility(0);
      }
    }
  }
  
  class MonitorBroadcastReceiver
    extends BroadcastReceiver
  {
    MonitorBroadcastReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      boolean bool;
      if ((paramIntent != null) && (paramIntent.getAction() != null) && (paramIntent.getAction().equals("action.qq.miniapp.show.monitorview")))
      {
        bool = paramIntent.getBooleanExtra("show", true);
        paramIntent = new StringBuilder().append("onReceive action action.qq.miniapp.show.monitorview, ");
        if (!bool) {
          break label89;
        }
      }
      label89:
      for (paramContext = "show";; paramContext = "hide")
      {
        QMLog.d("minisdk-start-AppBrandPageContainer", paramContext + " monitor view!");
        if (AppBrandPageContainer.this.isMonitorViewShowing() != bool) {
          AppBrandPageContainer.this.toggleMonitorPanel();
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer
 * JD-Core Version:    0.7.0.1
 */