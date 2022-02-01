package com.tencent.mobileqq.mini.launch;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class AppBrandProxyImpl$5
  implements Runnable
{
  AppBrandProxyImpl$5(AppBrandProxyImpl paramAppBrandProxyImpl, String paramString, CmdCallback paramCmdCallback, Bundle paramBundle) {}
  
  public void run()
  {
    if (this.this$0.getService() == null)
    {
      QLog.e("miniapp-process_AppBrandProxy", 1, "sendCmd IAppBrandService Connection is Null 1. cmd=" + this.val$cmd);
      if (this.val$callback != null) {}
      try
      {
        this.val$callback.onCmdResult(false, new Bundle());
        return;
      }
      catch (Throwable localThrowable1)
      {
        QLog.e("miniapp-process_AppBrandProxy", 1, "sendCmd exception.", localThrowable1);
        return;
      }
    }
    try
    {
      AppBrandProxyImpl.access$000(this.this$0).sendCmd(this.val$cmd, this.val$bundle, this.val$callback);
      return;
    }
    catch (Throwable localThrowable2)
    {
      QLog.e("miniapp-process_AppBrandProxy", 1, "sendCmd exception.", localThrowable2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandProxyImpl.5
 * JD-Core Version:    0.7.0.1
 */