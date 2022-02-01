package com.tencent.qqmini.sdk.launcher;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.manager.BaseLibManager.UpdateListener;

class AppBrandLaunchManager$8
  implements BaseLibManager.UpdateListener
{
  AppBrandLaunchManager$8(AppBrandLaunchManager paramAppBrandLaunchManager) {}
  
  public void onUpdateResult(int paramInt)
  {
    QMLog.w("minisdk-start_AppBrandLaunchManager", "updateBaseLib ret=" + paramInt);
    if (paramInt == 0) {
      return;
    }
    if (paramInt == 1)
    {
      QMLog.w("minisdk-start_AppBrandLaunchManager", "基础库无更新.");
      return;
    }
    String str = "基础库更新失败.";
    if (paramInt == 1100) {
      str = "础库更新请求失败.";
    }
    for (;;)
    {
      QMLog.w("minisdk-start_AppBrandLaunchManager", str);
      return;
      if (paramInt == 1101) {
        str = "基础库下载失败.";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppBrandLaunchManager.8
 * JD-Core Version:    0.7.0.1
 */