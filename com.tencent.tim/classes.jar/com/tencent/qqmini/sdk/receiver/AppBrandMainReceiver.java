package com.tencent.qqmini.sdk.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LoginInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.launcher.shell.IReceiverProxy;

public class AppBrandMainReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject1 = paramIntent.getAction();
    QMLog.i("minisdk-start", "AppBrandTaskPreloadReceiver onReceive action: " + (String)localObject1);
    MiniSDK.init(paramContext.getApplicationContext());
    try
    {
      localObject1 = (LoginInfo)paramIntent.getParcelableExtra("KEY_LOGININFO");
      if (localObject1 != null) {
        AppLoaderFactory.g().getMiniAppEnv().setLoginInfo((LoginInfo)localObject1);
      }
      localObject1 = AppLoaderFactory.g().getReceiverProxy();
      if (localObject1 != null) {
        ((IReceiverProxy)localObject1).onReceive(paramContext, paramIntent);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.i("minisdk-start", "parse loginInfo error", localException);
        Object localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver
 * JD-Core Version:    0.7.0.1
 */