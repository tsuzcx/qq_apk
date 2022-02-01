package com.tencent.qqmini.sdk.launcher;

import com.tencent.qqmini.sdk.launcher.log.QMLog;

class AppBrandLaunchManager$MiniAppSubProcessorInfo$1
  implements Runnable
{
  AppBrandLaunchManager$MiniAppSubProcessorInfo$1(AppBrandLaunchManager.MiniAppSubProcessorInfo paramMiniAppSubProcessorInfo) {}
  
  public void run()
  {
    if (this.this$1.isForeground) {
      return;
    }
    QMLog.i("minisdk-start_AppBrandLaunchManager", "recycle process=" + this.this$1.processName + " " + this.this$1.allMiniAppInfo);
    this.this$1.this$0.forceKillProcess(this.this$1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppBrandLaunchManager.MiniAppSubProcessorInfo.1
 * JD-Core Version:    0.7.0.1
 */