package com.tencent.mobileqq.mini.launch;

import acfp;
import android.app.Activity;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class AppBrandLaunchManager$7
  implements Runnable
{
  AppBrandLaunchManager$7(AppBrandLaunchManager paramAppBrandLaunchManager, MiniAppConfig paramMiniAppConfig, Activity paramActivity) {}
  
  public void run()
  {
    if (this.val$appConfig.config == null) {
      QLog.e("miniapp-process_AppBrandLaunchManager", 1, "启动失败, Appid 为空 appConfig.config==null Activity=" + this.val$activity);
    }
    for (;;)
    {
      QQToast.a(AppBrandLaunchManager.access$100(this.this$0), acfp.m(2131702745), 2000).show();
      return;
      QLog.e("miniapp-process_AppBrandLaunchManager", 1, "启动失败, Appid 为空" + this.val$appConfig.config.toString() + " Activity=" + this.val$activity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.7
 * JD-Core Version:    0.7.0.1
 */