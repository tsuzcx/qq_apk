package com.tencent.mobileqq.mini.launch;

import android.os.Bundle;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;

class AppBrandMainService$AppBrandMainServiceBinder$2
  implements Runnable
{
  AppBrandMainService$AppBrandMainServiceBinder$2(AppBrandMainService.AppBrandMainServiceBinder paramAppBrandMainServiceBinder, String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle) {}
  
  public void run()
  {
    AppBrandLaunchManager.g().onAppStart(this.val$processName, this.val$appConfig, this.val$bundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandMainService.AppBrandMainServiceBinder.2
 * JD-Core Version:    0.7.0.1
 */