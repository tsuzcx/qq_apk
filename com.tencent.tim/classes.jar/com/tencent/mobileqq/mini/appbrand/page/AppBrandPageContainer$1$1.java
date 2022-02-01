package com.tencent.mobileqq.mini.appbrand.page;

import acfp;
import android.text.TextUtils;
import arhz;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.AppConfigInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.app.MiniAppStateManager;
import com.tencent.mobileqq.mini.app.MiniAppStateManager.MiniAppStateMsg;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class AppBrandPageContainer$1$1
  implements Runnable
{
  AppBrandPageContainer$1$1(AppBrandPageContainer.1 param1, int paramInt, ApkgInfo paramApkgInfo) {}
  
  public void run()
  {
    Object localObject;
    if ((this.val$resCode == 0) && (this.this$1.this$0.appBrandRuntime.apkgInfo.isUrlFileExist(this.this$1.val$url)))
    {
      localObject = (AppBrandPageContainer)this.this$1.val$pageWeakRef.get();
      if (localObject != null)
      {
        if (!"navigateTo".equals(this.this$1.val$fromFunc)) {
          break label88;
        }
        ((AppBrandPageContainer)localObject).navigateTo(this.this$1.val$url);
      }
    }
    for (;;)
    {
      this.this$1.val$dialog.dismiss();
      return;
      label88:
      if ("redirectTo".equals(this.this$1.val$fromFunc))
      {
        ((AppBrandPageContainer)localObject).redirectTo(this.this$1.val$url);
      }
      else if ("appLaunch".equals(this.this$1.val$fromFunc))
      {
        ((AppBrandPageContainer)localObject).launch(this.this$1.val$url, "appLaunch");
      }
      else if ("reLaunch".equals(this.this$1.val$fromFunc))
      {
        ((AppBrandPageContainer)localObject).launch(this.this$1.val$url, "reLaunch");
        continue;
        QQToast.a(this.this$1.val$dialog.getContext(), acfp.m(2131702742), 1).show();
        QLog.e("AppBrandPageContainer", 1, "Page not found." + this.this$1.val$url);
        if ((this.val$apkgInfo != null) && (this.val$apkgInfo.mAppConfigInfo != null) && (this.val$apkgInfo.appConfig != null) && (this.val$apkgInfo.appConfig.config != null))
        {
          localObject = this.val$apkgInfo.mAppConfigInfo.entryPagePath;
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.val$apkgInfo.isUrlFileExist((String)localObject)))
          {
            ((AppBrandPageContainer)this.this$1.val$pageWeakRef.get()).launch((String)localObject, "appLaunch");
          }
          else
          {
            localObject = new MiniAppStateManager.MiniAppStateMsg(-1, this.val$apkgInfo.appId, this.val$apkgInfo.appConfig.config.verType, null);
            MiniAppStateManager.getInstance().notifyChange(localObject);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer.1.1
 * JD-Core Version:    0.7.0.1
 */