package com.tencent.mobileqq.mini.appbrand.page;

import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.OnLoadServiceWebvieJsListener;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;

class ServiceWebview$3$1
  implements ValueCallback
{
  ServiceWebview$3$1(ServiceWebview.3 param3) {}
  
  public void onReceiveValue(Object paramObject)
  {
    QLog.i("miniapp-start", 1, "---end initAppServiceJs----");
    MiniReportManager.reportEventType(this.this$1.val$apkgInfo.appConfig, 105, this.this$1.this$0.getUrl(), null, null, 0);
    if (this.this$1.val$listener != null) {
      this.this$1.val$listener.onLoadFinish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ServiceWebview.3.1
 * JD-Core Version:    0.7.0.1
 */