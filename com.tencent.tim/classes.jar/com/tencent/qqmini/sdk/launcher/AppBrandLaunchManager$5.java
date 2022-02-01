package com.tencent.qqmini.sdk.launcher;

import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;

class AppBrandLaunchManager$5
  implements Runnable
{
  AppBrandLaunchManager$5(AppBrandLaunchManager paramAppBrandLaunchManager, MiniAppBaseInfo paramMiniAppBaseInfo) {}
  
  public void run()
  {
    AppBrandLaunchManager localAppBrandLaunchManager = this.this$0;
    if (!this.val$currAppConfig.isEngineTypeMiniGame()) {}
    for (boolean bool = true;; bool = false)
    {
      localAppBrandLaunchManager.preloadExtraMiniApp(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppBrandLaunchManager.5
 * JD-Core Version:    0.7.0.1
 */