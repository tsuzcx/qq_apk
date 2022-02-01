package com.tencent.qqmini.sdk.launcher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.manager.ObserverManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.ICapsuleButton;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy;
import com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager;
import com.tencent.qqmini.sdk.manager.MiniLoadingAdManager;
import com.tencent.qqmini.sdk.report.MiniAppPrelaunchRecorder;
import com.tencent.qqmini.sdk.report.MiniAppStartState;
import com.tencent.qqmini.sdk.report.MiniGdtReporter;
import com.tencent.qqmini.sdk.report.MiniReportManager;

public abstract class BaseUIProxy
  implements IUIProxy
{
  protected static final String TAG = "minisdk-start_UIProxy";
  protected boolean hasCompletedLoading = false;
  protected long loadCompleteTimeForLoadingAdReport;
  public Activity mActivity;
  protected BaseRuntimeLoader mCurrRuntimeLoader;
  protected Handler mMainHandler = new Handler(Looper.getMainLooper());
  protected PageGestureProxy mPageGestureProxy;
  public ViewGroup mRootLayout;
  
  protected BaseRuntimeLoader.OnAppRuntimeLoadListener createRuntimeLoaderListener()
  {
    return new BaseUIProxy.1(this);
  }
  
  public MiniAppInfo getMiniAppInfo()
  {
    if (this.mCurrRuntimeLoader != null) {
      return this.mCurrRuntimeLoader.getMiniAppInfo();
    }
    return null;
  }
  
  public BaseRuntime getRuntime()
  {
    if (this.mCurrRuntimeLoader != null) {
      return this.mCurrRuntimeLoader.getRuntime();
    }
    return null;
  }
  
  protected abstract void hideLoading();
  
  public void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    QMLog.i("minisdk-start_UIProxy", "onActivityResult requestCode=" + paramInt1 + " resultCode=" + paramInt2);
    ActivityResultManager.g().notifyActivityResultListener(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttachActivity(Activity paramActivity, Bundle paramBundle, ViewGroup paramViewGroup)
  {
    QMLog.i("minisdk-start_UIProxy", " [MiniLifecycle] onAttachActivity");
    paramBundle = paramActivity.getWindow();
    if (paramBundle != null) {
      paramBundle.setSoftInputMode(18);
    }
    if (this.mActivity != null) {}
    this.mActivity = paramActivity;
    this.mRootLayout = paramViewGroup;
    MiniGdtReporter.prepareReport();
    this.mPageGestureProxy = ((PageGestureProxy)ProxyManager.get(PageGestureProxy.class));
    if (this.mPageGestureProxy != null) {
      this.mPageGestureProxy.onActivityCreate(paramActivity);
    }
  }
  
  public boolean onBackPressed(Activity paramActivity)
  {
    QMLog.i("minisdk-start_UIProxy", " [MiniLifecycle] onBackPressed");
    if (this.mCurrRuntimeLoader != null) {}
    for (boolean bool = this.mCurrRuntimeLoader.getRuntime().onBackPress();; bool = false)
    {
      AppRuntimeLoaderManager.g().notifyRuntimeEvent(25, new Object[0]);
      return bool;
    }
  }
  
  public void onDetachActivity(Activity paramActivity)
  {
    QMLog.i("minisdk-start_UIProxy", " [MiniLifecycle] onDetachActivity");
    if (this.mActivity != paramActivity)
    {
      QMLog.e("minisdk-start_UIProxy", "onDetachActivity. activity is mismatch. mActivity=" + this.mActivity + " activity=" + paramActivity);
      return;
    }
    if (this.mCurrRuntimeLoader != null) {
      this.mCurrRuntimeLoader.onDetachActivity(paramActivity);
    }
    this.mCurrRuntimeLoader = null;
    if (this.mPageGestureProxy != null) {
      this.mPageGestureProxy.onActivityDestroy(paramActivity);
    }
    this.mActivity = null;
    this.mRootLayout = null;
  }
  
  public void onIntentUpdate(Intent paramIntent)
  {
    QMLog.i("minisdk-start_UIProxy", " [MiniLifecycle] onIntentUpdate");
    MiniAppInfo localMiniAppInfo = (MiniAppInfo)paramIntent.getParcelableExtra("KEY_APPINFO");
    if (localMiniAppInfo == null)
    {
      QMLog.e("minisdk-start_UIProxy", "onIntentUpdate MiniAppInfo is Null!");
      return;
    }
    if (localMiniAppInfo.canDebug()) {
      localMiniAppInfo.forceReroad = 3;
    }
    AppLoaderFactory.g().getAppBrandProxy().onAppStart(localMiniAppInfo, null);
    startMiniAppInfo(localMiniAppInfo, paramIntent.getExtras());
    MiniGdtReporter.prepareReport();
  }
  
  public void onMiniPause()
  {
    if (this.mCurrRuntimeLoader == null) {
      QMLog.e("minisdk-start_UIProxy", "onMiniPause current runtime loader is null!");
    }
    do
    {
      do
      {
        return;
        QMLog.i("minisdk-start_UIProxy", " [MiniLifecycle] onMiniPause");
        this.mCurrRuntimeLoader.onMiniPause();
      } while (this.mCurrRuntimeLoader.getMiniAppInfo() == null);
      GameGrowthGuardianManager.executeEnd(this.mActivity, this.mCurrRuntimeLoader.getMiniAppInfo());
    } while (this.mPageGestureProxy == null);
    this.mPageGestureProxy.onActivityPause(this.mActivity);
  }
  
  public void onMiniResume()
  {
    if (this.mCurrRuntimeLoader == null) {
      QMLog.e("minisdk-start_UIProxy", "onMiniResume current runtime loader is null!");
    }
    ChannelProxy localChannelProxy;
    do
    {
      do
      {
        return;
        QMLog.i("minisdk-start_UIProxy", " [MiniLifecycle] onMiniResume");
        this.mCurrRuntimeLoader.onMiniResume();
        AppRuntimeLoaderManager.g().onEnterForeground();
      } while (this.mCurrRuntimeLoader.getMiniAppInfo() == null);
      AppLoaderFactory.g().getAppBrandProxy().onAppForeground(this.mCurrRuntimeLoader.getMiniAppInfo(), null);
      GameGrowthGuardianManager.executeBegin(this.mActivity, this.mCurrRuntimeLoader.getMiniAppInfo());
      if (this.mPageGestureProxy != null)
      {
        this.mPageGestureProxy.onActivityResume(this.mActivity);
        this.mPageGestureProxy.onCreateMiniAppInfo(this.mCurrRuntimeLoader.getMiniAppInfo());
      }
      localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    } while (localChannelProxy == null);
    localChannelProxy.syncForceGroundAndRefreshBadge(this.mActivity, this.mCurrRuntimeLoader.getMiniAppInfo().appId, AppLoaderFactory.g().getProcessName());
  }
  
  public void onMiniStart()
  {
    if (this.mCurrRuntimeLoader == null) {
      QMLog.e("minisdk-start_UIProxy", "onMiniStart current runtime loader is null!");
    }
    do
    {
      return;
      QMLog.i("minisdk-start_UIProxy", " [MiniLifecycle] onMiniStart");
    } while (this.mCurrRuntimeLoader == null);
    this.mCurrRuntimeLoader.onMiniStart();
  }
  
  public void onMiniStop()
  {
    if (this.mCurrRuntimeLoader == null) {
      QMLog.e("minisdk-start_UIProxy", "onMiniStop current runtime loader is null!");
    }
    do
    {
      return;
      QMLog.i("minisdk-start_UIProxy", " [MiniLifecycle] onMiniStop");
      this.mCurrRuntimeLoader.onMiniStop();
      AppRuntimeLoaderManager.g().onEnterBackground();
      if (this.mCurrRuntimeLoader.getMiniAppInfo() != null) {
        AppLoaderFactory.g().getAppBrandProxy().onAppBackground(this.mCurrRuntimeLoader.getMiniAppInfo(), null);
      }
    } while ((this.mPageGestureProxy == null) || (this.mActivity == null));
    this.mPageGestureProxy.onActivityStop(this.mActivity);
  }
  
  public void onRefreshMiniBadge(Activity paramActivity, Bundle paramBundle)
  {
    Object localObject = null;
    QMLog.i("minisdk-start_UIProxy", "onRefreshMiniBadge");
    MiniAppInfo localMiniAppInfo;
    if (this.mCurrRuntimeLoader != null)
    {
      paramActivity = this.mCurrRuntimeLoader.getRuntime();
      if (this.mCurrRuntimeLoader == null) {
        break label65;
      }
      localMiniAppInfo = this.mCurrRuntimeLoader.getMiniAppInfo();
      label42:
      if ((paramActivity != null) && (localMiniAppInfo != null)) {
        break label71;
      }
      QMLog.e("minisdk-start_UIProxy", "Failed to refreshMiniBadge, runtime or miniappinfo is null");
    }
    label65:
    label71:
    int i;
    do
    {
      String str;
      do
      {
        do
        {
          return;
          paramActivity = null;
          break;
          localMiniAppInfo = null;
          break label42;
        } while (paramBundle == null);
        str = paramBundle.getString("KEY_APPID");
        if (QMLog.isColorLevel()) {
          QMLog.d("TAG", "onRefreshMiniBadge appID : " + str);
        }
      } while (!localMiniAppInfo.appId.equals(str));
      i = paramBundle.getInt("KEY_BADGE_COUNT");
      if (QMLog.isColorLevel()) {
        QMLog.e("minisdk-start_UIProxy", "onRefreshMiniBadge badge : " + i);
      }
      paramBundle = paramActivity.getPage();
      paramActivity = localObject;
      if (paramBundle != null) {
        paramActivity = paramBundle.getCapsuleButton();
      }
    } while (paramActivity == null);
    paramActivity.setUnReadCount(i, false);
  }
  
  public void onRequestPermissionsResult(Activity paramActivity, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QMLog.i("minisdk-start_UIProxy", "onRequestPermissionsResult requestCode=" + paramInt + " permissions=" + paramArrayOfString + "grantResults=" + paramArrayOfInt);
    ActivityResultManager.g().notifyRequestPermissionResultListener(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  protected void onRuntimeFail(int paramInt, String paramString)
  {
    QMLog.e("minisdk-start_UIProxy", " [MiniLifecycle] onRuntimeFail. Whoops, failed to load the runtime, retCode = " + paramInt + ", msg = " + paramString);
    this.mMainHandler.postDelayed(new BaseUIProxy.3(this, paramInt, paramString), 1000L);
  }
  
  protected void onRuntimeReady()
  {
    QMLog.i("minisdk-start_UIProxy", " [MiniLifecycle] onRuntimeReady. Here we go, start the runtime lifecycle");
    AppBrandTask.runTaskOnUiThread(new BaseUIProxy.2(this));
  }
  
  protected void processSelectLoadingAdLogic(Activity paramActivity, MiniAppInfo paramMiniAppInfo)
  {
    String str = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAccount();
    long l = System.currentTimeMillis();
    MiniLoadingAdManager.getInstance().selectAd(paramActivity, paramMiniAppInfo, str, new BaseUIProxy.4(this, l, paramMiniAppInfo, paramActivity));
  }
  
  public void quit()
  {
    if (this.mActivity != null) {
      this.mActivity.finish();
    }
  }
  
  protected void reloadMiniAppInfoIfNeed(BaseRuntimeLoader paramBaseRuntimeLoader, MiniAppInfo paramMiniAppInfo)
  {
    if (paramBaseRuntimeLoader.isLoadSucceed())
    {
      if (!paramMiniAppInfo.isShortcutFakeApp()) {
        paramBaseRuntimeLoader.setMiniAppInfo(paramMiniAppInfo);
      }
      paramBaseRuntimeLoader.onAttachActivity(this.mActivity, null, this.mRootLayout);
      hideLoading();
    }
    do
    {
      return;
      showLoading(paramMiniAppInfo);
      paramBaseRuntimeLoader.setRuntimeLoadListener(createRuntimeLoaderListener());
    } while (paramBaseRuntimeLoader.isRunning());
    paramBaseRuntimeLoader.start();
  }
  
  protected abstract void showLoading(MiniAppInfo paramMiniAppInfo);
  
  protected void startMiniAppInfo(MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    if (paramMiniAppInfo == null) {
      QMLog.e("minisdk-start_UIProxy", "Failed to start. miniAppInfo is null");
    }
    label335:
    label479:
    label484:
    label493:
    for (;;)
    {
      return;
      MiniAppPrelaunchRecorder.get().onMiniAppStart(paramMiniAppInfo.appId);
      BaseRuntimeLoader localBaseRuntimeLoader3 = this.mCurrRuntimeLoader;
      if ((localBaseRuntimeLoader3 != null) && (localBaseRuntimeLoader3.getRuntime() != null)) {
        ((ObserverManager)localBaseRuntimeLoader3.getRuntime().getManager(ObserverManager.class)).notifyChange("resetPlayer");
      }
      QMLog.i("minisdk-start_UIProxy", " [MiniLifecycle] startMiniAppInfo ");
      QMLog.i("minisdk-start_UIProxy", "startMiniAppInfo " + paramMiniAppInfo.toDetailString());
      BaseRuntimeLoader localBaseRuntimeLoader2 = AppRuntimeLoaderManager.g().queryAppRunTimeLoader(paramMiniAppInfo);
      BaseRuntimeLoader localBaseRuntimeLoader1 = localBaseRuntimeLoader2;
      if (localBaseRuntimeLoader2 != null)
      {
        localBaseRuntimeLoader1 = localBaseRuntimeLoader2;
        if (paramMiniAppInfo.forceReroad != 0)
        {
          QMLog.i("minisdk-start_UIProxy", "startMiniAppInfo. There is a existing runtime loader but need force Reroad. " + localBaseRuntimeLoader2.toSimpleString());
          AppRuntimeLoaderManager.g().removeRuntimeLoader(localBaseRuntimeLoader2);
          localBaseRuntimeLoader1 = null;
        }
      }
      int i;
      if (localBaseRuntimeLoader1 != null)
      {
        QMLog.i("minisdk-start_UIProxy", "startMiniAppInfo. Resume the existing runtime of existing runtime loader = " + localBaseRuntimeLoader1.toSimpleString());
        this.mCurrRuntimeLoader = localBaseRuntimeLoader1;
        AppRuntimeLoaderManager.g().bringToFront(localBaseRuntimeLoader1);
        localBaseRuntimeLoader1.notifyRuntimeEvent(20, new Object[0]);
        if (localBaseRuntimeLoader3 != localBaseRuntimeLoader1) {
          showLoading(paramMiniAppInfo);
        }
        reloadMiniAppInfoIfNeed(localBaseRuntimeLoader1, paramMiniAppInfo);
        if ((localBaseRuntimeLoader3 != null) && (localBaseRuntimeLoader3 != this.mCurrRuntimeLoader))
        {
          if (localBaseRuntimeLoader3.isRunning())
          {
            QMLog.i("minisdk-start_UIProxy", "pause last runtime loader:" + localBaseRuntimeLoader3);
            localBaseRuntimeLoader3.pause();
          }
          localBaseRuntimeLoader3.onDetachActivity(this.mActivity, false);
        }
        if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramMiniAppInfo.appId))) {
          continue;
        }
        if (paramBundle == null) {
          break label479;
        }
        i = paramBundle.getInt("start_mode", 3);
        if (i != 3) {
          break label484;
        }
        MiniAppStartState.setProcessLoad(paramMiniAppInfo.appId, false);
      }
      for (;;)
      {
        if (this.mPageGestureProxy == null) {
          break label493;
        }
        this.mPageGestureProxy.onCreateMiniAppInfo(paramMiniAppInfo);
        return;
        showLoading(paramMiniAppInfo);
        MiniReportManager.reportEventType(paramMiniAppInfo, 1013, "1");
        localBaseRuntimeLoader1 = AppRuntimeLoaderManager.g().createAppRuntimeLoader(paramMiniAppInfo, createRuntimeLoaderListener(), paramBundle);
        if (paramMiniAppInfo.forceReroad != 0)
        {
          localBaseRuntimeLoader1.resetAndStart(paramMiniAppInfo);
          this.mCurrRuntimeLoader = localBaseRuntimeLoader1;
          localBaseRuntimeLoader1.notifyRuntimeEvent(20, new Object[0]);
          break;
        }
        this.mCurrRuntimeLoader = localBaseRuntimeLoader1;
        QMLog.i("minisdk-start_UIProxy", "startMiniAppInfo. Create a new runtime loader = " + localBaseRuntimeLoader1);
        localBaseRuntimeLoader1.start();
        localBaseRuntimeLoader1.notifyRuntimeEvent(20, new Object[0]);
        break;
        i = 3;
        break label335;
        MiniAppStartState.setProcessLoad(paramMiniAppInfo.appId, true);
      }
    }
  }
  
  protected void updateLoadingAdUI(Activity paramActivity, MiniAppInfo paramMiniAppInfo, String paramString, long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.BaseUIProxy
 * JD-Core Version:    0.7.0.1
 */