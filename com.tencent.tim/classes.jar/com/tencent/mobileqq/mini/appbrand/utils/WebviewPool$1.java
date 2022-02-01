package com.tencent.mobileqq.mini.appbrand.utils;

import android.content.Context;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.ServiceOriginalWebview;
import com.tencent.mobileqq.mini.appbrand.page.ServiceWebview.Callback;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.webview.JsRuntime;

class WebviewPool$1
  implements Runnable
{
  WebviewPool$1(WebviewPool paramWebviewPool, Context paramContext, ServiceWebview.Callback paramCallback) {}
  
  public void run()
  {
    ServiceOriginalWebview localServiceOriginalWebview = new ServiceOriginalWebview(this.val$activity);
    localServiceOriginalWebview.setJsConsoleMessageListener(WebviewPool.access$000(this.this$0).mJsErrorGuard);
    localServiceOriginalWebview.setJsErrorListener(WebviewPool.access$000(this.this$0).mJsErrorListener);
    this.this$0.mFirstServiceWebview = localServiceOriginalWebview;
    this.this$0.mFirstServiceWebview.setAppBrandEventInterface(WebviewPool.access$000(this.this$0));
    if (this.val$callback != null) {
      this.val$callback.onJscoreInited();
    }
    MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 700, "system_normal_video", "0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.WebviewPool.1
 * JD-Core Version:    0.7.0.1
 */