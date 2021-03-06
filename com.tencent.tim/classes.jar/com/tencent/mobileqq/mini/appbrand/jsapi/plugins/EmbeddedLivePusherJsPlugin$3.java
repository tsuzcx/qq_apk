package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.ui.NavigationBar;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.TabBarView;

class EmbeddedLivePusherJsPlugin$3
  implements Runnable
{
  EmbeddedLivePusherJsPlugin$3(EmbeddedLivePusherJsPlugin paramEmbeddedLivePusherJsPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void run()
  {
    AbsAppBrandPage localAbsAppBrandPage = ((AppBrandPageContainer)this.this$0.jsPluginEngine.appBrandRuntime.getContainer()).getPageByWebViewId(this.val$webview.getPageWebViewId());
    if (localAbsAppBrandPage != null)
    {
      localAbsAppBrandPage.getNavBar().setVisibility(EmbeddedLivePusherJsPlugin.access$000(this.this$0));
      localAbsAppBrandPage.getTabBar().setVisibility(EmbeddedLivePusherJsPlugin.access$100(this.this$0));
      EmbeddedLivePusherJsPlugin.access$300(this.this$0);
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$eventName, null, this.val$callbackId);
      return;
    }
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.EmbeddedLivePusherJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */