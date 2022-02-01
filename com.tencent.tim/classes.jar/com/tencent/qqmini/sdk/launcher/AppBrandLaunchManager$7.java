package com.tencent.qqmini.sdk.launcher;

import android.util.LruCache;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class AppBrandLaunchManager$7
  implements Runnable
{
  AppBrandLaunchManager$7(AppBrandLaunchManager paramAppBrandLaunchManager, String paramString1, String paramString2) {}
  
  public void run()
  {
    AppBrandLaunchManager.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo = (AppBrandLaunchManager.MiniAppSubProcessorInfo)AppBrandLaunchManager.access$000(this.this$0).get(this.val$processName);
    if (localMiniAppSubProcessorInfo != null)
    {
      QMLog.i("minisdk-start_AppBrandLaunchManager", "set preload BaseLibVersion:" + this.val$baseLibVersion + " to " + localMiniAppSubProcessorInfo);
      localMiniAppSubProcessorInfo.preloadGameBaseLibVersion = this.val$baseLibVersion;
      AppBrandLaunchManager.access$000(this.this$0).put(this.val$processName, localMiniAppSubProcessorInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppBrandLaunchManager.7
 * JD-Core Version:    0.7.0.1
 */