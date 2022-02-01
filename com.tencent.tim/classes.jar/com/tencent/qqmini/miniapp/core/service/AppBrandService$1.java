package com.tencent.qqmini.miniapp.core.service;

import android.content.Context;
import android.os.Handler;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.sdk.QbSdk.PreInitCallback;

class AppBrandService$1
  implements QbSdk.PreInitCallback
{
  AppBrandService$1(AppBrandService paramAppBrandService, Context paramContext) {}
  
  public void onCoreInitFinished()
  {
    QMLog.e("AppBrandService", "onCoreInitFinished in thread --> " + this.this$0.threadName);
    AppBrandService.access$002(true);
    AppBrandService.mThreadHandler.post(new AppBrandService.1.1(this));
  }
  
  public void onViewInitFinished(boolean paramBoolean)
  {
    QMLog.e("AppBrandService", "onViewInitFinished isX5Core:" + paramBoolean + " in thread --> " + this.this$0.threadName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.service.AppBrandService.1
 * JD-Core Version:    0.7.0.1
 */