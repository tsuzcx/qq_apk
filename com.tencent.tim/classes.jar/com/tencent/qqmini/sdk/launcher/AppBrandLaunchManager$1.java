package com.tencent.qqmini.sdk.launcher;

import android.text.TextUtils;
import java.util.List;

class AppBrandLaunchManager$1
  implements Runnable
{
  AppBrandLaunchManager$1(AppBrandLaunchManager paramAppBrandLaunchManager, AppBrandLaunchManager.MiniAppSubProcessorInfo paramMiniAppSubProcessorInfo) {}
  
  public void run()
  {
    AppBrandLaunchManager localAppBrandLaunchManager;
    if ((this.val$preloadProcess != null) && (!this.val$preloadProcess.allMiniAppInfo.isEmpty()))
    {
      localAppBrandLaunchManager = this.this$0;
      if (TextUtils.equals(this.val$preloadProcess.preloadType, "preload_game")) {
        break label50;
      }
    }
    label50:
    for (boolean bool = true;; bool = false)
    {
      localAppBrandLaunchManager.preloadExtraMiniApp(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppBrandLaunchManager.1
 * JD-Core Version:    0.7.0.1
 */