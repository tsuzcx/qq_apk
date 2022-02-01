package com.tencent.qqmini.miniapp.core.page;

import android.os.Handler;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.manager.ApkgManager.OnInitApkgListener;
import java.lang.ref.WeakReference;

class AppBrandPageContainer$3
  implements ApkgManager.OnInitApkgListener
{
  AppBrandPageContainer$3(AppBrandPageContainer paramAppBrandPageContainer, String paramString1, WeakReference paramWeakReference, String paramString2) {}
  
  public void onInitApkgInfo(int paramInt, ApkgInfo paramApkgInfo, String paramString)
  {
    if (paramInt == 0)
    {
      ThreadManager.getUIHandler().post(new AppBrandPageContainer.3.1(this, paramApkgInfo));
      return;
    }
    QMLog.e("minisdk-start-AppBrandPageContainer", "executeDownSubPackage failed." + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.3
 * JD-Core Version:    0.7.0.1
 */