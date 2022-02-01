package com.tencent.mobileqq.mini.appbrand.page;

import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.JsErrorListener;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.JsContext;
import com.tencent.smtt.sdk.JsContext.ExceptionHandler;
import com.tencent.smtt.sdk.JsError;

class ServiceWebview$2
  implements JsContext.ExceptionHandler
{
  ServiceWebview$2(ServiceWebview paramServiceWebview) {}
  
  public void handleException(JsContext paramJsContext, JsError paramJsError)
  {
    if (this.this$0.mJsErrorListener != null) {
      this.this$0.mJsErrorListener.onJsError();
    }
    QLog.e("miniapp-start", 1, "X5Exception:" + paramJsError.getMessage());
    if (this.this$0.getApkgInfo() != null) {
      MiniReportManager.reportEventType(this.this$0.getApkgInfo().appConfig, 23, this.this$0.getUrl(), paramJsError.getMessage() + "\n" + paramJsError.getStack(), null, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ServiceWebview.2
 * JD-Core Version:    0.7.0.1
 */