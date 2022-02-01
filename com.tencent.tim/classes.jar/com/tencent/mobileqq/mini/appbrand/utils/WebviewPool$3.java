package com.tencent.mobileqq.mini.appbrand.utils;

import android.content.Context;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.ServiceOriginalWebview;
import com.tencent.mobileqq.mini.webview.JsRuntime;

class WebviewPool$3
  implements Runnable
{
  WebviewPool$3(WebviewPool paramWebviewPool, Context paramContext, String paramString) {}
  
  public void run()
  {
    ServiceOriginalWebview localServiceOriginalWebview = new ServiceOriginalWebview(this.val$activity);
    localServiceOriginalWebview.setJsConsoleMessageListener(WebviewPool.access$000(this.this$0).mJsErrorGuard);
    this.this$0.mFirstServiceWebview = localServiceOriginalWebview;
    this.this$0.mFirstServiceWebview.setAppBrandEventInterface(WebviewPool.access$000(this.this$0));
    this.this$0.mFirstServiceWebview.initWAServiceJS(this.val$js);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.WebviewPool.3
 * JD-Core Version:    0.7.0.1
 */