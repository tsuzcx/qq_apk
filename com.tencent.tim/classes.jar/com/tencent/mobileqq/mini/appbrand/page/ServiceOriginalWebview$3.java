package com.tencent.mobileqq.mini.appbrand.page;

import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;

class ServiceOriginalWebview$3
  implements ValueCallback
{
  ServiceOriginalWebview$3(ServiceOriginalWebview paramServiceOriginalWebview, String paramString) {}
  
  public void onReceiveValue(Object paramObject)
  {
    QLog.i("ServiceOriginalWebview", 1, "---end service default config----");
    ServiceOriginalWebview.access$300(this.this$0, this.val$waServiceJsStr, new ServiceOriginalWebview.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ServiceOriginalWebview.3
 * JD-Core Version:    0.7.0.1
 */