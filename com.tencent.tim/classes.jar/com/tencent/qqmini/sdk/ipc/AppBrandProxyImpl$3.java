package com.tencent.qqmini.sdk.ipc;

import android.os.RemoteException;
import com.tencent.qqmini.sdk.launcher.ipc.IAppMainService;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class AppBrandProxyImpl$3
  implements Runnable
{
  AppBrandProxyImpl$3(AppBrandProxyImpl paramAppBrandProxyImpl, IAppMainService paramIAppMainService, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    try
    {
      this.val$service.preloadDownloadPackage(this.val$appInfo);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "preloadPackage exception.", localRemoteException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.AppBrandProxyImpl.3
 * JD-Core Version:    0.7.0.1
 */