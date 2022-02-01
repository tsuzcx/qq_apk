package com.tencent.qqmini.miniapp.core;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer;
import com.tencent.qqmini.miniapp.core.service.AbsAppBrandService;
import com.tencent.qqmini.miniapp.core.service.IAppBrandService;
import com.tencent.qqmini.sdk.core.BaseRuntimeImpl;
import com.tencent.qqmini.sdk.core.Preloadable;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.PreCacheManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.manager.BaseLibManager;
import com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine;

public abstract class BaseAppBrandRuntime
  extends BaseRuntimeImpl
  implements Preloadable<IAppBrandService>
{
  private static final String TAG = "minisdk-start_BaseAppBrandRuntime";
  protected IAppBrandService appBrandService;
  protected JsPluginEngine jsPluginEngine;
  protected Activity mActivity;
  protected ApkgInfo mApkgInfo;
  protected String mEntryPath;
  protected EventListener mEventListener = new EventListener(this);
  protected MiniAppInfo mMiniAppInfo;
  protected boolean mPrecacheFetched = false;
  protected ViewGroup mRootLayout;
  protected IAppBrandPageContainer pageContainer;
  
  public BaseAppBrandRuntime(Context paramContext)
  {
    super(paramContext);
  }
  
  public Activity getAttachedActivity()
  {
    return this.mActivity;
  }
  
  public String getBaseLibVersion()
  {
    return BaseLibManager.g().getBaseLibInfo().baseLibVersion;
  }
  
  public Context getContext()
  {
    return AppLoaderFactory.g().getMiniAppEnv().getContext();
  }
  
  public EventListener getEventListener()
  {
    return this.mEventListener;
  }
  
  public JsPluginEngine getJsPluginEngine()
  {
    return this.jsPluginEngine;
  }
  
  public IJsService getJsService()
  {
    return this.appBrandService;
  }
  
  public MiniAppInfo getMiniAppInfo()
  {
    return this.mMiniAppInfo;
  }
  
  public byte[] getNativeBuffer(int paramInt)
  {
    return new byte[0];
  }
  
  public IPage getPage()
  {
    return this.pageContainer;
  }
  
  public ShareState getShareState()
  {
    return null;
  }
  
  public void init(IAppBrandService paramIAppBrandService)
  {
    QMLog.i("minisdk-start_BaseAppBrandRuntime", " [MiniLifecycle] init");
    if (paramIAppBrandService == null)
    {
      QMLog.e("minisdk-start_BaseAppBrandRuntime", "customJsService is null!");
      return;
    }
    this.appBrandService = paramIAppBrandService;
    this.appBrandService.setAppBrandEventInterface(this.mEventListener);
  }
  
  public boolean isMiniGame()
  {
    return false;
  }
  
  public boolean isOrientationLandscape()
  {
    return false;
  }
  
  protected void launchPage(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.pageContainer.cleanup(false);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label111;
      }
      if ((paramMiniAppInfo == null) || (paramMiniAppInfo.apkgInfo == null) || (((ApkgInfo)paramMiniAppInfo.apkgInfo).mAppConfigInfo == null)) {
        break label100;
      }
      paramMiniAppInfo = ((ApkgInfo)paramMiniAppInfo.apkgInfo).mAppConfigInfo.entryPagePath;
    }
    for (;;)
    {
      label66:
      IAppBrandPageContainer localIAppBrandPageContainer = this.pageContainer;
      if (paramBoolean) {}
      for (paramString = "reLaunch";; paramString = "appLaunch")
      {
        localIAppBrandPageContainer.launch(paramMiniAppInfo, paramString);
        return;
        paramString = paramMiniAppInfo.launchParam.entryPath;
        break;
        label100:
        paramMiniAppInfo = null;
        break label66;
      }
      label111:
      paramMiniAppInfo = paramString;
    }
  }
  
  public void loadMiniApp(MiniAppInfo paramMiniAppInfo)
  {
    QMLog.i("minisdk-start_BaseAppBrandRuntime", " [MiniLifecycle] loadMiniApp");
    if (this.mApkgInfo != null) {
      return;
    }
    this.mMiniAppInfo = paramMiniAppInfo;
    this.mApkgInfo = ((ApkgInfo)paramMiniAppInfo.apkgInfo);
    ((MiniAppFileManager)getManager(MiniAppFileManager.class)).initFileManager(this.mApkgInfo, false);
    if (!this.mPrecacheFetched)
    {
      this.mPrecacheFetched = true;
      PreCacheManager.g().fetchPreCacheData(this.mMiniAppInfo);
      PreCacheManager.g().fetchPreResourceIfNeed(this.mMiniAppInfo);
    }
    this.mEntryPath = this.mMiniAppInfo.launchParam.entryPath;
  }
  
  public int newNativeBuffer(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public boolean onBackPress()
  {
    return (this.pageContainer != null) && (this.pageContainer.navigateBack(1, -1));
  }
  
  public void onLoadMiniAppInfo(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, String paramString)
  {
    QMLog.i("minisdk-start_BaseAppBrandRuntime", " [MiniLifecycle] onLoadMiniAppInfo");
    QMLog.i("minisdk-start_BaseAppBrandRuntime", "onLoadMiniAppInfo miniAppInfo=" + paramMiniAppInfo + ",fromReload=" + paramBoolean);
    this.jsPluginEngine.onCreate(this);
    this.pageContainer.setMiniAppInfo(paramMiniAppInfo);
    this.pageContainer.setFromReload(paramBoolean);
    if (((AbsAppBrandService)this.appBrandService).getCurrState() == ((AbsAppBrandService)this.appBrandService).stateLoadSucc)
    {
      AppBrandTask.runTaskOnUiThread(new BaseAppBrandRuntime.1(this, paramMiniAppInfo, paramBoolean, paramString));
      return;
    }
    ((AbsAppBrandService)this.appBrandService).addStateChangeListener(new BaseAppBrandRuntime.2(this, paramMiniAppInfo, paramBoolean, paramString));
    this.appBrandService.setApkgInfo((ApkgInfo)paramMiniAppInfo.apkgInfo);
  }
  
  public void onRuntimeAttachActivity(Activity paramActivity, ViewGroup paramViewGroup)
  {
    QMLog.i("minisdk-start_BaseAppBrandRuntime", " [MiniLifecycle] onRuntimeAttachActivity");
    if ((this.mActivity == paramActivity) && (this.mRootLayout == paramViewGroup)) {
      return;
    }
    this.mActivity = paramActivity;
    this.mRootLayout = paramViewGroup;
    this.pageContainer.onAttachedToActivity(paramActivity);
    if ((this.pageContainer.getContentView() != null) && (this.pageContainer.getContentView().getParent() != null)) {
      ((ViewGroup)this.pageContainer.getContentView().getParent()).removeView(this.pageContainer.getContentView());
    }
    paramViewGroup.addView(this.pageContainer.getContentView(), new ViewGroup.LayoutParams(-1, -1));
  }
  
  public void onRuntimeCreate()
  {
    QMLog.i("minisdk-start_BaseAppBrandRuntime", " [MiniLifecycle] onRuntimeCreate");
    this.jsPluginEngine = new JsPluginEngine(this.mContext);
  }
  
  public void onRuntimeDetachActivity(Activity paramActivity)
  {
    QMLog.i("minisdk-start_BaseAppBrandRuntime", " [MiniLifecycle] onRuntimeDetachActivity");
    if ((this.mRootLayout != null) && (this.pageContainer.getContentView() != null)) {
      this.mRootLayout.removeView(this.pageContainer.getContentView());
    }
    this.mActivity = null;
    this.mRootLayout = null;
  }
  
  public void onRuntimePause()
  {
    QMLog.i("minisdk-start_BaseAppBrandRuntime", " [MiniLifecycle] onRuntimePause");
    if (this.pageContainer != null) {
      this.pageContainer.onPause();
    }
    if (this.jsPluginEngine != null) {
      this.jsPluginEngine.onPause();
    }
  }
  
  public void onRuntimeResume()
  {
    QMLog.i("minisdk-start_BaseAppBrandRuntime", " [MiniLifecycle] onRuntimeResume");
    if (this.pageContainer != null) {
      this.pageContainer.onResume();
    }
    if (this.jsPluginEngine != null) {
      this.jsPluginEngine.onResume();
    }
  }
  
  public void onRuntimeStart()
  {
    QMLog.i("minisdk-start_BaseAppBrandRuntime", " [MiniLifecycle] onRuntimeStart");
  }
  
  public void onRuntimeStop()
  {
    QMLog.i("minisdk-start_BaseAppBrandRuntime", " [MiniLifecycle] onRuntimeStop");
    if (this.pageContainer != null) {
      this.pageContainer.onStop();
    }
  }
  
  public void onUpdateMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    this.pageContainer.setMiniAppInfo(paramMiniAppInfo);
    this.appBrandService.setApkgInfo((ApkgInfo)paramMiniAppInfo.apkgInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.BaseAppBrandRuntime
 * JD-Core Version:    0.7.0.1
 */