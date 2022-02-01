package com.tencent.mobileqq.mini.appbrand;

import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.JsPluginEngine;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;

class AppBrandRuntime$11
  implements Runnable
{
  AppBrandRuntime$11(AppBrandRuntime paramAppBrandRuntime, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    this.this$0.pageContainer.navigateTo(this.val$url);
    this.this$0.jsPluginEngine.callbackJsEventOK(this.this$0.serviceRuntime, this.val$eventName, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.11
 * JD-Core Version:    0.7.0.1
 */