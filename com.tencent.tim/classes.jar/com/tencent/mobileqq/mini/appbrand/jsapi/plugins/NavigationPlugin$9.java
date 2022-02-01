package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;
import com.tencent.qphone.base.util.QLog;

class NavigationPlugin$9
  extends ResultReceiver
{
  NavigationPlugin$9(NavigationPlugin paramNavigationPlugin, Handler paramHandler, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if (paramInt == 0)
    {
      if (this.val$listener != null) {
        this.val$listener.onLaunchResult(true, null);
      }
      if ((this.this$0.jsPluginEngine.appBrandRuntime.activity != null) && (!this.this$0.jsPluginEngine.appBrandRuntime.activity.isFinishing()))
      {
        QLog.d("[mini] NavigationPlugin", 1, "navigateBackMiniApp ok, finish current.");
        this.this$0.jsPluginEngine.appBrandRuntime.activity.finish();
      }
    }
    do
    {
      return;
      QLog.e("[mini] NavigationPlugin", 1, "navigateBackMiniApp failed");
    } while (this.val$listener == null);
    this.val$listener.onLaunchResult(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.NavigationPlugin.9
 * JD-Core Version:    0.7.0.1
 */