package com.tencent.mobileqq.mini.fake;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aroi;
import arvq;
import arvr;
import asvm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.app.IAppUIProxy;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI3;
import com.tencent.mobileqq.mini.launch.MiniSdkLauncher;
import com.tencent.mobileqq.mini.network.http.MiniOkHttpClientFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.IUIProxy;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniAppStartState;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class FakeSdkBrandUI
  implements IFakeBrandUI
{
  private static final String COOKIE_DOMAIN = "qzone.qq.com";
  private static final String TAG = "minisdk-start_FakeSdkBrandUI";
  private static volatile boolean mHasOKHttpClientInit;
  public static volatile boolean mHasOnCreate;
  private IUIProxy mUIProxy;
  
  public static void initOKHttpClient()
  {
    if (!mHasOKHttpClientInit)
    {
      mHasOKHttpClientInit = true;
      MiniOkHttpClientFactory.init(30000L, 30000L, 30000L);
    }
  }
  
  private void recoveryIntent(Intent paramIntent)
  {
    if (paramIntent == null) {}
    for (;;)
    {
      return;
      try
      {
        if ((MiniAppInfo)paramIntent.getParcelableExtra("KEY_APPINFO") == null)
        {
          MiniAppConfig localMiniAppConfig = (MiniAppConfig)paramIntent.getParcelableExtra("CONFIG");
          if (localMiniAppConfig != null)
          {
            paramIntent.putExtra("KEY_APPINFO", MiniSdkLauncher.convert(localMiniAppConfig));
            QLog.e("minisdk-start_FakeSdkBrandUI", 1, "recoveryIntent from MiniAppConfig succeed!");
            return;
          }
        }
      }
      catch (Throwable paramIntent)
      {
        QLog.e("minisdk-start_FakeSdkBrandUI", 1, "recoveryIntent exception!", paramIntent);
      }
    }
  }
  
  public static void setCookie()
  {
    long l1 = System.currentTimeMillis();
    try
    {
      arvr localarvr = new arvr(aroi.a().getContext());
      arvq localarvq = new arvq();
      localarvq.setAcceptCookie(true);
      long l2 = aroi.a().getUin();
      Object localObject = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
      String str = ((TicketManager)localObject).getSkey(String.valueOf(l2));
      localObject = ((TicketManager)localObject).getPskey(String.valueOf(l2), "qzone.qq.com");
      localarvq.setCookie("qzone.qq.com/", "uin=" + l2 + "; path=/; domain=." + "qzone.qq.com" + ";");
      localarvq.setCookie("qzone.qq.com/", "p_uin=" + l2 + "; path=/; domain=." + "qzone.qq.com" + ";");
      localarvq.setCookie("qzone.qq.com/", "skey=" + str + "; path=/; domain=." + "qzone.qq.com" + ";");
      localarvq.setCookie("qzone.qq.com/", "p_skey=" + (String)localObject + "; path=/; domain=." + "qzone.qq.com" + ";");
      localarvr.sync();
      l2 = System.currentTimeMillis();
      QLog.e(AppBrandUI3.class.getSimpleName(), 1, "setCookie cost:" + (l2 - l1));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public boolean doBeforeOnCreate(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    QLog.i("minisdk-start_FakeSdkBrandUI", 1, "doBeforeOnCreate");
    mHasOnCreate = true;
    MiniSDK.init(paramBaseActivity.getApplicationContext());
    ThreadManager.executeOnSubThread(new FakeSdkBrandUI.1(this));
    Object localObject1 = new RelativeLayout(paramBaseActivity);
    paramBaseActivity.setContentView((View)localObject1);
    FrameLayout localFrameLayout = new FrameLayout(paramBaseActivity);
    ((RelativeLayout)localObject1).addView(localFrameLayout, new RelativeLayout.LayoutParams(-1, -1));
    Intent localIntent = paramBaseActivity.getIntent();
    for (;;)
    {
      try
      {
        recoveryIntent(localIntent);
        localObject1 = (MiniAppInfo)paramBaseActivity.getIntent().getParcelableExtra("KEY_APPINFO");
        Object localObject2 = localObject1;
        if (localObject1 != null) {}
        QLog.e("minisdk-start_FakeSdkBrandUI", 1, "", localThrowable1);
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          MiniAppStartState.setBaseLibLoad(((MiniAppInfo)localObject1).appId, MiniAppStartState.isBaseLibLoaded);
          QLog.w("minisdk-start", 1, "AppBrandUI3.onCreate baseLib pre load:" + MiniAppStartState.isBaseLibLoaded + " appid:" + ((MiniAppInfo)localObject1).appId);
          localObject2 = localObject1;
          this.mUIProxy = AppLoaderFactory.g().getAppUIProxy(localObject2);
          if (this.mUIProxy != null)
          {
            QLog.i("minisdk-start_FakeSdkBrandUI", 1, "UIProxy completed");
            this.mUIProxy.onAttachActivity(paramBaseActivity, paramBundle, localFrameLayout);
            this.mUIProxy.onIntentUpdate(localIntent);
          }
          asvm.registerModule();
          return true;
        }
        catch (Throwable localThrowable2)
        {
          Object localObject3;
          break label216;
        }
        localThrowable1 = localThrowable1;
        localObject1 = null;
      }
      label216:
      localObject3 = localObject1;
    }
  }
  
  public boolean doDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return this.mUIProxy.doDispatchKeyEvent(paramKeyEvent);
  }
  
  public void doOnActivityResult(BaseActivity paramBaseActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.mUIProxy != null) {
      this.mUIProxy.onActivityResult(paramBaseActivity, paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void doOnBackPressed(BaseActivity paramBaseActivity, boolean paramBoolean)
  {
    if (this.mUIProxy != null)
    {
      paramBoolean = this.mUIProxy.onBackPressed(paramBaseActivity);
      if (!paramBoolean) {
        break label28;
      }
    }
    label28:
    while (paramBaseActivity.moveTaskToBack(false))
    {
      return;
      paramBoolean = false;
      break;
    }
    paramBaseActivity.finish();
  }
  
  public boolean doOnCreate(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    return true;
  }
  
  public void doOnDestroy(BaseActivity paramBaseActivity)
  {
    QLog.i("minisdk-start_FakeSdkBrandUI", 1, "doOnDestroy");
    if (this.mUIProxy != null) {
      this.mUIProxy.onDetachActivity(paramBaseActivity);
    }
    asvm.unRegisterModule();
  }
  
  public void doOnNewIntent(BaseActivity paramBaseActivity, Intent paramIntent)
  {
    QLog.i("minisdk-start_FakeSdkBrandUI", 1, "doOnNewIntent");
    if (this.mUIProxy != null) {
      this.mUIProxy.onIntentUpdate(paramIntent);
    }
  }
  
  public void doOnPause(BaseActivity paramBaseActivity)
  {
    QLog.i("minisdk-start_FakeSdkBrandUI", 1, "doOnPause");
    if (this.mUIProxy != null) {
      this.mUIProxy.onMiniPause();
    }
  }
  
  public void doOnResume(BaseActivity paramBaseActivity)
  {
    QLog.i("minisdk-start_FakeSdkBrandUI", 1, "doOnResume");
    if (this.mUIProxy != null) {
      this.mUIProxy.onMiniResume();
    }
    ImmersiveUtils.setStatusTextColor(true, paramBaseActivity.getWindow());
  }
  
  public void doOnStart(BaseActivity paramBaseActivity)
  {
    QLog.i("minisdk-start_FakeSdkBrandUI", 1, "doOnStart");
    if (this.mUIProxy != null) {
      this.mUIProxy.onMiniStart();
    }
  }
  
  public void doOnStop(BaseActivity paramBaseActivity)
  {
    QLog.i("minisdk-start_FakeSdkBrandUI", 1, "doOnStop");
    if (this.mUIProxy != null) {
      this.mUIProxy.onMiniStop();
    }
  }
  
  public void doRefreshMiniBadge(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    if (this.mUIProxy != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("KEY_APPID", paramBundle.getString("miniAppID"));
      localBundle.putInt("KEY_BADGE_COUNT", paramBundle.getInt("param_proc_badge_count"));
      this.mUIProxy.onRefreshMiniBadge(paramBaseActivity, localBundle);
    }
  }
  
  public void finish(BaseActivity paramBaseActivity) {}
  
  public IAppUIProxy getAppUIProxy()
  {
    return null;
  }
  
  public boolean isWrapContent(BaseActivity paramBaseActivity)
  {
    return false;
  }
  
  public boolean moveTaskToBack(BaseActivity paramBaseActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    PageGestureProxy localPageGestureProxy = (PageGestureProxy)AppLoaderFactory.g().getProxyManager().get(PageGestureProxy.class);
    if (localPageGestureProxy != null) {
      localPageGestureProxy.onMoveTaskToBack(paramBaseActivity);
    }
    return false;
  }
  
  public void onProcessBackground(BaseActivity paramBaseActivity, Bundle paramBundle) {}
  
  public void onProcessForeGround(BaseActivity paramBaseActivity, Bundle paramBundle) {}
  
  public void onRefreshMiniBadge(BaseActivity paramBaseActivity, Bundle paramBundle) {}
  
  public void setColorNoteWithOutMoveTaskToBackThisTime() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.fake.FakeSdkBrandUI
 * JD-Core Version:    0.7.0.1
 */