package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.webview.JsRuntime;

class InternalJSPlugin$2
  implements InternalJSPlugin.openUrlCallback
{
  InternalJSPlugin$2(InternalJSPlugin paramInternalJSPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void openResult(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if ((this.this$0.jsPluginEngine.appBrandRuntime instanceof AppBrandRuntime)) {
        ((AppBrandRuntime)this.this$0.jsPluginEngine.appBrandRuntime).onPauseByOpenUrl();
      }
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$eventName, null, this.val$callbackId);
      return;
    }
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, paramString, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.InternalJSPlugin.2
 * JD-Core Version:    0.7.0.1
 */