package com.tencent.mobileqq.mini.appbrand.page;

import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;

class ServiceWebview$4
  implements ValueCallback
{
  ServiceWebview$4(ServiceWebview paramServiceWebview, String paramString) {}
  
  public void onReceiveValue(Object paramObject)
  {
    QLog.i("miniapp-start", 1, "---end service default config----");
    this.this$0.evaluteJs(this.val$waServiceJsStr, new ServiceWebview.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ServiceWebview.4
 * JD-Core Version:    0.7.0.1
 */