package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

class UIJsPlugin$9
  implements Runnable
{
  UIJsPlugin$9(UIJsPlugin paramUIJsPlugin, String paramString, JsRuntime paramJsRuntime, int paramInt) {}
  
  public void run()
  {
    Object localObject = ((AppBrandPageContainer)this.this$0.jsPluginEngine.appBrandRuntime.getContainer()).pageLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((AbsAppBrandPage)((Iterator)localObject).next()).stopPullDownRefresh();
    }
    localObject = ((AppBrandPageContainer)this.this$0.jsPluginEngine.appBrandRuntime.getContainer()).getCurrentWebviewContainer();
    if (localObject == null)
    {
      QLog.w("[mini] UIJsPlugin", 2, "handleNativeRequest event=" + this.val$event + "， top page not found");
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callbackId);
      return;
    }
    ((WebviewContainer)localObject).startPullDownRefresh();
    this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.9
 * JD-Core Version:    0.7.0.1
 */