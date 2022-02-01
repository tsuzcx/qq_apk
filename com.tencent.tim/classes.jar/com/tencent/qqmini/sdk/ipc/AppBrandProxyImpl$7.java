package com.tencent.qqmini.sdk.ipc;

import com.tencent.qqmini.sdk.launcher.ipc.IAppMainService;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class AppBrandProxyImpl$7
  implements Runnable
{
  AppBrandProxyImpl$7(AppBrandProxyImpl paramAppBrandProxyImpl) {}
  
  public void run()
  {
    try
    {
      AppBrandProxyImpl.access$200(this.this$0).stopAllMiniApp();
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "stopMiniApp exception.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.AppBrandProxyImpl.7
 * JD-Core Version:    0.7.0.1
 */