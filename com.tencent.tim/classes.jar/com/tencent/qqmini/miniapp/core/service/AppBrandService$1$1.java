package com.tencent.qqmini.miniapp.core.service;

import com.tencent.qqmini.sdk.launcher.log.QMLog;

class AppBrandService$1$1
  implements Runnable
{
  AppBrandService$1$1(AppBrandService.1 param1) {}
  
  public void run()
  {
    try
    {
      this.this$1.this$0.init(this.this$1.val$context);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("AppBrandService", "onCoreInitFinished exception in thread --> " + this.this$1.this$0.threadName, localThrowable);
      this.this$1.this$0.setCurrState(this.this$1.this$0.stateInitFailed);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.service.AppBrandService.1.1
 * JD-Core Version:    0.7.0.1
 */