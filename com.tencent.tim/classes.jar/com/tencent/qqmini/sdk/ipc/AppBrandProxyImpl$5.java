package com.tencent.qqmini.sdk.ipc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;

class AppBrandProxyImpl$5
  extends ResultReceiver
{
  AppBrandProxyImpl$5(AppBrandProxyImpl paramAppBrandProxyImpl, Handler paramHandler, ResultReceiver paramResultReceiver, Activity paramActivity)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if (paramInt == 1)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      try
      {
        paramBundle = (Intent)paramBundle.getParcelable("LAUNCH_ACTIVITY_INTENT");
        paramBundle.setExtrasClassLoader(getClass().getClassLoader());
        paramBundle.putExtra("receiver", this.val$resultReceiver);
        if (this.val$activity != null)
        {
          this.val$activity.startActivity(paramBundle);
          return;
        }
        AppLoaderFactory.g().getMiniAppEnv().getContext().startActivity(paramBundle);
        return;
      }
      catch (Throwable paramBundle)
      {
        QMLog.e("minisdk-start_AppBrandProxy", "startMiniApp startActivity exception!", paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.AppBrandProxyImpl.5
 * JD-Core Version:    0.7.0.1
 */