package com.tencent.mobileqq.mini.launch;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.qphone.base.util.QLog;

class AppBrandProxyImpl$2
  implements Runnable
{
  AppBrandProxyImpl$2(AppBrandProxyImpl paramAppBrandProxyImpl, MiniAppConfig paramMiniAppConfig, ResultReceiver paramResultReceiver, Activity paramActivity) {}
  
  public void run()
  {
    try
    {
      AppBrandProxyImpl.access$000(this.this$0).startMiniApp(this.val$appConfig, new AppBrandProxyImpl.2.1(this, new Handler(Looper.getMainLooper())));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("miniapp-process_AppBrandProxy", 1, "startMiniApp exception.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandProxyImpl.2
 * JD-Core Version:    0.7.0.1
 */