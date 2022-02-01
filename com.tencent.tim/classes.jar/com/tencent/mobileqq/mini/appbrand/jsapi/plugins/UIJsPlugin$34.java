package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.jsapi.GameBrandRuntime;

class UIJsPlugin$34
  implements Runnable
{
  UIJsPlugin$34(UIJsPlugin paramUIJsPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.isMiniGameRuntime())
    {
      ((GameBrandRuntime)this.this$0.jsPluginEngine.appBrandRuntime).showRestart = false;
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
      return;
    }
    PageWebview localPageWebview = this.this$0.jsPluginEngine.appBrandRuntime.getPageWebView();
    if (localPageWebview != null)
    {
      localPageWebview.setEnableShowBackHome(false);
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
      return;
    }
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.34
 * JD-Core Version:    0.7.0.1
 */