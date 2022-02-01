package com.tencent.mobileqq.mini.appbrand;

import acfp;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.AppConfigInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.app.MiniAppStateManager;
import com.tencent.mobileqq.mini.app.MiniAppStateManager.MiniAppStateMsg;
import com.tencent.mobileqq.mini.appbrand.page.BrandPagePool;
import com.tencent.mobileqq.mini.appbrand.ui.DebugLayout;
import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.webview.BaseAppBrandWebview;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public final class AppBrandRuntimeContainer
  implements AppBrandRuntimeContainerInterface
{
  public static final int APPRUNTIME_LIMIT = 10;
  public static final String TAG = "miniapp-start_AppBrandRuntimeContainer";
  private static AppBrandRuntimeContainer instance;
  private LinkedList<AppBrandRuntime> appBrandRuntimeLinkedList = new LinkedList();
  private WeakReference<Activity> mActivity;
  private DebugLayout mDebugLayout;
  private TextView mDebugText;
  private AppBrandRuntime mEmptyAppRuntime;
  private FrameLayout root;
  
  public static AppBrandRuntimeContainer g()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new AppBrandRuntimeContainer();
      }
      return instance;
    }
    finally {}
  }
  
  private void reportMiniAppCatchCrashOnInit(ApkgInfo paramApkgInfo, Throwable paramThrowable)
  {
    if ((paramApkgInfo == null) || (paramThrowable == null)) {}
    do
    {
      return;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("scene", "AppBrandRuntimeContainer init");
        localJSONObject.put("miniAppId", paramApkgInfo.appId);
        if (paramApkgInfo.mAppConfigInfo != null) {
          localJSONObject.put("page", paramApkgInfo.mAppConfigInfo.entryPagePath);
        }
        paramApkgInfo = new StringBuilder(256);
        paramApkgInfo.append(paramThrowable.toString());
        if (paramThrowable.getStackTrace() != null)
        {
          StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
          int i = 0;
          while ((i < arrayOfStackTraceElement.length) && (i < 16))
          {
            paramApkgInfo.append("\n ");
            paramApkgInfo.append(arrayOfStackTraceElement[i].toString());
            i += 1;
          }
        }
        paramApkgInfo = paramApkgInfo.toString();
        VACDReportUtil.a(localJSONObject.toString(), "MiniAppStat", "MiniAppCrashReport", "Catch", null, 88888, paramApkgInfo);
        return;
      }
      catch (Throwable paramApkgInfo) {}
    } while (!QLog.isColorLevel());
    QLog.e("miniapp-start_AppBrandRuntimeContainer", 2, paramThrowable, new Object[0]);
  }
  
  public final void addAppBrandRunTime(AppBrandRuntime paramAppBrandRuntime)
  {
    AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)this.appBrandRuntimeLinkedList.peekLast();
    if (QLog.isColorLevel()) {
      QLog.d("miniapp-start_AppBrandRuntimeContainer", 2, "addAppBrandRunTime currSize=" + getAppBrandRuntimeSize() + ",insertAppBrandRunTime=" + paramAppBrandRuntime + ",lastAppBrandRuntime=" + localAppBrandRuntime);
    }
    this.appBrandRuntimeLinkedList.push(paramAppBrandRuntime);
    this.root.addView(paramAppBrandRuntime.pageContainer);
    if ((getAppBrandRuntimeSize() > 10) && (localAppBrandRuntime != null)) {
      localAppBrandRuntime.finish();
    }
  }
  
  public void attachToActivity(Activity paramActivity)
  {
    this.mActivity = new WeakReference(paramActivity);
  }
  
  public void bringToFront(AppBrandRuntime paramAppBrandRuntime, FrameLayout paramFrameLayout)
  {
    if (QLog.isColorLevel()) {
      QLog.d("miniapp-start_AppBrandRuntimeContainer", 2, "bringToFront appBrandRuntime=" + paramAppBrandRuntime);
    }
    if (paramAppBrandRuntime != null)
    {
      this.appBrandRuntimeLinkedList.remove(paramAppBrandRuntime);
      this.appBrandRuntimeLinkedList.push(paramAppBrandRuntime);
      if (this.root != paramFrameLayout)
      {
        QLog.i("miniapp-start_AppBrandRuntimeContainer", 1, "---AppBrandRuntime root changed!----");
        this.root = paramFrameLayout;
        if ((ViewGroup)paramAppBrandRuntime.getContainer().getParent() != null) {
          ((ViewGroup)paramAppBrandRuntime.getContainer().getParent()).removeView(paramAppBrandRuntime.getContainer());
        }
        this.root.addView(paramAppBrandRuntime.getContainer());
      }
    }
  }
  
  public final void cleanup()
  {
    if (QLog.isColorLevel()) {
      QLog.d("miniapp-start_AppBrandRuntimeContainer", 2, "cleanup appRunTime size = " + getAppBrandRuntimeSize());
    }
    BrandPagePool.g().cleanup();
    Iterator localIterator = this.appBrandRuntimeLinkedList.iterator();
    while (localIterator.hasNext())
    {
      AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)localIterator.next();
      if ((localAppBrandRuntime.apkgInfo != null) && (localAppBrandRuntime.apkgInfo.appConfig != null) && (localAppBrandRuntime.apkgInfo.appConfig.config != null) && (localAppBrandRuntime.apkgInfo.appConfig.isInternalApp()) && (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_runtime_alive_ids_internal", "1109875297").contains(localAppBrandRuntime.apkgInfo.appConfig.config.appId)))
      {
        QLog.d("miniapp-start_AppBrandRuntimeContainer", 1, "RunTime will not be cleaned.  appid=" + localAppBrandRuntime.apkgInfo.appConfig.config.appId);
      }
      else if (localAppBrandRuntime != null)
      {
        if ((localAppBrandRuntime.apkgInfo != null) && (localAppBrandRuntime.apkgInfo.appConfig != null))
        {
          MiniProgramLpReportDC04239.reportPageView(localAppBrandRuntime.apkgInfo.appConfig, "0", null, "unload", null);
          MiniAppReportManager2.reportPageView("2unload", null, null, localAppBrandRuntime.apkgInfo.appConfig);
        }
        this.root.removeView(localAppBrandRuntime.pageContainer);
        localAppBrandRuntime.cleanup();
        localIterator.remove();
      }
    }
  }
  
  public void detachFromActivity(Activity paramActivity)
  {
    if ((this.mActivity != null) && (this.mActivity.get() == paramActivity)) {
      this.mActivity = null;
    }
  }
  
  public void disableBreak()
  {
    new Handler(Looper.getMainLooper()).post(new AppBrandRuntimeContainer.3(this));
  }
  
  public void enableBreak()
  {
    new Handler(Looper.getMainLooper()).post(new AppBrandRuntimeContainer.2(this));
  }
  
  public void finish()
  {
    cleanup();
  }
  
  public Activity getActivity()
  {
    if (this.mActivity != null) {
      return (Activity)this.mActivity.get();
    }
    return null;
  }
  
  public AppBrandRuntime getAppBrandRunTime(MiniAppInfo paramMiniAppInfo)
  {
    Object localObject;
    if (paramMiniAppInfo == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      if (QLog.isColorLevel()) {
        QLog.d("miniapp-start_AppBrandRuntimeContainer", 2, "getAppBrandRunTime appId=" + paramMiniAppInfo.appId + ", versionType=" + paramMiniAppInfo.verType + " version=" + paramMiniAppInfo.version + "  versionId=" + paramMiniAppInfo.versionId);
      }
      try
      {
        Iterator localIterator = new ArrayList(this.appBrandRuntimeLinkedList).iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)localIterator.next();
            if ((localAppBrandRuntime.apkgInfo != null) && (localAppBrandRuntime.apkgInfo.appConfig != null) && (localAppBrandRuntime.apkgInfo.appConfig.config.appId.equals(paramMiniAppInfo.appId)) && (localAppBrandRuntime.apkgInfo.appConfig.config.versionId.equals(paramMiniAppInfo.versionId)))
            {
              localObject = localAppBrandRuntime;
              if (localAppBrandRuntime.apkgInfo.appConfig.config.verType == paramMiniAppInfo.verType) {
                break;
              }
              int i = paramMiniAppInfo.verType;
              if (i == -1) {
                return localAppBrandRuntime;
              }
            }
          }
        }
      }
      catch (Throwable paramMiniAppInfo)
      {
        QLog.e("miniapp-start_AppBrandRuntimeContainer", 1, "getAppBrandRunTime exception!", paramMiniAppInfo);
      }
    }
    return null;
  }
  
  public AppBrandRuntime getAppBrandRunTime(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("miniapp-start_AppBrandRuntimeContainer", 2, "getAppBrandRunTime appId=" + paramString + ",versionType=" + paramInt);
    }
    Iterator localIterator = new ArrayList(this.appBrandRuntimeLinkedList).iterator();
    while (localIterator.hasNext())
    {
      AppBrandRuntime localAppBrandRuntime = (AppBrandRuntime)localIterator.next();
      if ((localAppBrandRuntime.appId.equals(paramString)) && ((paramInt == localAppBrandRuntime.versionType) || (paramInt == -1))) {
        return localAppBrandRuntime;
      }
    }
    return null;
  }
  
  public final int getAppBrandRuntimeSize()
  {
    return this.appBrandRuntimeLinkedList.size();
  }
  
  public final AppBrandRuntime getBehindAppBrandRunTime(AppBrandRuntime paramAppBrandRuntime)
  {
    int i = this.appBrandRuntimeLinkedList.indexOf(paramAppBrandRuntime);
    int j = this.appBrandRuntimeLinkedList.size();
    if ((i == -1) || (i >= j - 1)) {
      return null;
    }
    return (AppBrandRuntime)this.appBrandRuntimeLinkedList.get(i + 1);
  }
  
  public AppBrandRuntime getCurrentAppBrandRuntime()
  {
    if (this.appBrandRuntimeLinkedList.size() > 0) {
      return (AppBrandRuntime)this.appBrandRuntimeLinkedList.peek();
    }
    return null;
  }
  
  public AppBrandRuntime getEmptyAppRuntime()
  {
    return this.mEmptyAppRuntime;
  }
  
  public AppBrandRuntime getSecond()
  {
    if (this.appBrandRuntimeLinkedList.size() < 2) {
      return null;
    }
    return (AppBrandRuntime)this.appBrandRuntimeLinkedList.get(1);
  }
  
  public final void init(ApkgInfo paramApkgInfo, String paramString, FrameLayout paramFrameLayout)
  {
    if ((paramApkgInfo == null) || (paramFrameLayout == null)) {
      return;
    }
    this.root = paramFrameLayout;
    AppBrandRuntime localAppBrandRuntime = getAppBrandRunTime(paramApkgInfo.appConfig.config);
    if (localAppBrandRuntime != null)
    {
      if (this.root != localAppBrandRuntime.getContainer().getParent())
      {
        QLog.i("miniapp-start_AppBrandRuntimeContainer", 1, "---AppBrandRuntime root changed!----");
        if ((ViewGroup)localAppBrandRuntime.getContainer().getParent() != null) {
          ((ViewGroup)localAppBrandRuntime.getContainer().getParent()).removeView(localAppBrandRuntime.getContainer());
        }
        this.root.addView(localAppBrandRuntime.getContainer());
      }
      localAppBrandRuntime.updateApkgInfo(paramApkgInfo);
      return;
    }
    if ((localAppBrandRuntime == null) && (this.appBrandRuntimeLinkedList.size() > 0))
    {
      cleanup();
      BrandPagePool.g().cleanup();
    }
    QLog.i("miniapp-start_AppBrandRuntimeContainer", 1, "---start AppBrandRuntime----");
    for (;;)
    {
      try
      {
        QLog.i("miniapp-start_AppBrandRuntimeContainer", 1, "---AppBrandRuntime create start----");
        if (this.mEmptyAppRuntime == null) {
          continue;
        }
        localAppBrandRuntime = this.mEmptyAppRuntime;
        this.mEmptyAppRuntime = null;
        localAppBrandRuntime.onAttachWindow((Activity)this.mActivity.get());
        localAppBrandRuntime.onAppCreate(paramApkgInfo, paramString, false);
        QLog.i("miniapp-start_AppBrandRuntimeContainer", 1, "---AppBrandRuntime create end----");
        QLog.i("miniapp-start_AppBrandRuntimeContainer", 1, "---PageWebView count:" + BaseAppBrandWebview.aliveWebViewCount + "----");
        addAppBrandRunTime(localAppBrandRuntime);
        MiniProgramLpReportDC04239.reportPageView(paramApkgInfo.appConfig, "0", null, "load", null);
        MiniAppReportManager2.reportPageView("2load", null, null, paramApkgInfo.appConfig);
        StringBuilder localStringBuilder = new StringBuilder().append("--- report load appid:");
        if ((paramApkgInfo.appConfig == null) || (paramApkgInfo.appConfig.config == null)) {
          continue;
        }
        paramString = paramApkgInfo.appConfig.config.appId;
        QLog.i("miniapp-start_AppBrandRuntimeContainer", 1, paramString);
        localAppBrandRuntime.setBootState(1);
        initDebugUI();
        if (this.mDebugLayout.getParent() != null) {
          ((ViewGroup)this.mDebugLayout.getParent()).removeView(this.mDebugLayout);
        }
        this.mDebugText.setText(acfp.m(2131702738));
        paramFrameLayout.addView(this.mDebugLayout, new ViewGroup.LayoutParams(-1, -1));
        this.mDebugLayout.setVisibility(4);
      }
      catch (Throwable paramString)
      {
        QLog.e("miniapp-start_AppBrandRuntimeContainer", 1, "AppBrandRuntime init exception!", paramString);
        reportMiniAppCatchCrashOnInit(paramApkgInfo, paramString);
        paramApkgInfo = new MiniAppStateManager.MiniAppStateMsg(-1, paramApkgInfo.appConfig.config.appId, paramApkgInfo.appConfig.config.verType, null);
        MiniAppStateManager.getInstance().notifyChange(paramApkgInfo);
        continue;
      }
      QLog.i("miniapp-start_AppBrandRuntimeContainer", 1, "---end AppBrandRuntime----");
      return;
      localAppBrandRuntime = new AppBrandRuntime(this);
      continue;
      paramString = Integer.valueOf(0);
    }
  }
  
  public void initDebugUI()
  {
    if (this.mDebugLayout != null) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new AppBrandRuntimeContainer.1(this));
  }
  
  public final AppBrandRuntime peek()
  {
    return (AppBrandRuntime)this.appBrandRuntimeLinkedList.peek();
  }
  
  public void preloadEmptyRuntime()
  {
    if (this.mEmptyAppRuntime != null) {
      return;
    }
    QLog.i("miniapp-start_AppBrandRuntimeContainer", 1, "preloadEmptyRuntime begin");
    try
    {
      this.mEmptyAppRuntime = new AppBrandRuntime(this);
      Activity localActivity = getActivity();
      if (localActivity != null) {
        this.mEmptyAppRuntime.onAttachWindow(localActivity);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("miniapp-start_AppBrandRuntimeContainer", 1, "preloadEmptyRuntime exception!", localThrowable);
        this.mEmptyAppRuntime = null;
      }
    }
    QLog.i("miniapp-start_AppBrandRuntimeContainer", 1, "preloadEmptyRuntime end");
  }
  
  public void reload(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("miniapp-start_AppBrandRuntimeContainer", 1, "reload appBrandRuntime=" + paramAppBrandRuntime + ",entryPath=" + paramString);
    }
    if (paramAppBrandRuntime != null)
    {
      bringToFront(paramAppBrandRuntime, this.root);
      paramAppBrandRuntime.reload(paramString, false);
    }
  }
  
  public final void removeAppBrandRunTime(AppBrandRuntime paramAppBrandRuntime)
  {
    if (QLog.isColorLevel()) {
      QLog.d("miniapp-start_AppBrandRuntimeContainer", 2, "removeAppBrandRunTime r=" + paramAppBrandRuntime);
    }
    if (paramAppBrandRuntime != null)
    {
      this.root.removeView(paramAppBrandRuntime.pageContainer);
      paramAppBrandRuntime.cleanup();
      this.appBrandRuntimeLinkedList.remove(paramAppBrandRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer
 * JD-Core Version:    0.7.0.1
 */