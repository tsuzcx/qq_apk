package com.tencent.qqmini.miniapp;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class AppRuntimeLoader$2
  implements Runnable
{
  AppRuntimeLoader$2(AppRuntimeLoader paramAppRuntimeLoader, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    QMLog.d("AppRuntimeLoader", "AppBrandRemoteService Task reset begin");
    this.this$0.pause();
    AppRuntimeLoader.access$100(this.this$0, AppRuntimeLoader.access$000(this.this$0));
    AppRuntimeLoader.access$200(this.this$0, this.this$0.serviceCreateTask);
    AppRuntimeLoader.access$400(this.this$0, AppRuntimeLoader.access$300(this.this$0));
    this.this$0.getRuntime().loadMiniApp(this.val$miniAppInfo);
    QMLog.d("AppRuntimeLoader", "AppBrandRemoteService Task reset end ");
    this.this$0.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.AppRuntimeLoader.2
 * JD-Core Version:    0.7.0.1
 */