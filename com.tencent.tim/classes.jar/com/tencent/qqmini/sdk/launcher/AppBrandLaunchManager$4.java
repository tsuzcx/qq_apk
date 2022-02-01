package com.tencent.qqmini.sdk.launcher;

import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class AppBrandLaunchManager$4
  implements Runnable
{
  AppBrandLaunchManager$4(AppBrandLaunchManager paramAppBrandLaunchManager) {}
  
  public void run()
  {
    QMLog.i("minisdk-start_AppBrandLaunchManager", "zzconfig start to loadServer");
    WnsConfigProxy localWnsConfigProxy = (WnsConfigProxy)ProxyManager.get(WnsConfigProxy.class);
    if (localWnsConfigProxy != null) {
      localWnsConfigProxy.loadConfigFromServer();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppBrandLaunchManager.4
 * JD-Core Version:    0.7.0.1
 */