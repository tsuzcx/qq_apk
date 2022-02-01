package com.tencent.qqmini.miniapp.core.page;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;
import java.lang.ref.WeakReference;

class AppBrandPageContainer$3$1
  implements Runnable
{
  AppBrandPageContainer$3$1(AppBrandPageContainer.3 param3, ApkgInfo paramApkgInfo) {}
  
  public void run()
  {
    Object localObject;
    if ((this.val$apkgInfo != null) && (this.val$apkgInfo.isUrlFileExist(this.this$1.val$path)))
    {
      localObject = (AppBrandPageContainer)this.this$1.val$pageWeakRef.get();
      if (localObject != null)
      {
        if (!"navigateTo".equals(this.this$1.val$openType)) {
          break label70;
        }
        ((AppBrandPageContainer)localObject).navigateTo(this.this$1.val$path, -1);
      }
    }
    label70:
    do
    {
      do
      {
        do
        {
          return;
          if ("redirectTo".equals(this.this$1.val$openType))
          {
            ((AppBrandPageContainer)localObject).redirectTo(this.this$1.val$path, -1);
            return;
          }
          if ("appLaunch".equals(this.this$1.val$openType))
          {
            ((AppBrandPageContainer)localObject).launch(this.this$1.val$path, "appLaunch");
            return;
          }
        } while (!"reLaunch".equals(this.this$1.val$openType));
        ((AppBrandPageContainer)localObject).launch(this.this$1.val$path, "reLaunch");
        return;
        QMLog.e("minisdk-start-AppBrandPageContainer", "Page not found." + this.this$1.val$path);
      } while ((this.val$apkgInfo == null) || (this.val$apkgInfo.mAppConfigInfo == null));
      localObject = this.val$apkgInfo.mAppConfigInfo.entryPagePath;
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.val$apkgInfo.isUrlFileExist((String)localObject)))
      {
        ((AppBrandPageContainer)this.this$1.val$pageWeakRef.get()).launch((String)localObject, "appLaunch");
        return;
      }
    } while ((AppBrandPageContainer.access$000(this.this$1.this$0) == null) || (AppBrandPageContainer.access$000(this.this$1.this$0).getAttachedActivity() == null) || (AppBrandPageContainer.access$000(this.this$1.this$0).getAttachedActivity().isFinishing()));
    AppBrandPageContainer.access$000(this.this$1.this$0).getAttachedActivity().moveTaskToBack(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.3.1
 * JD-Core Version:    0.7.0.1
 */