package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.os.Bundle;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;
import com.tencent.mobileqq.mini.webview.JsRuntime;

class NavigationPlugin$7
  implements MiniAppLauncher.MiniAppLaunchListener
{
  NavigationPlugin$7(NavigationPlugin paramNavigationPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
      return;
    }
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.NavigationPlugin.7
 * JD-Core Version:    0.7.0.1
 */