package com.tencent.mobileqq.mini.webview;

import com.tencent.qphone.base.util.QLog;

class BaseAppBrandWebview$1
  implements Runnable
{
  BaseAppBrandWebview$1(BaseAppBrandWebview paramBaseAppBrandWebview, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    String str = "WeixinJSBridge.subscribeHandler(\"" + this.val$eventName + "\"," + this.val$data + "," + this.val$webviweId + "," + 0 + ")";
    if (QLog.isColorLevel()) {
      QLog.d(BaseAppBrandWebview.access$000(), 2, "evaluateSubcribeJS: eventName:" + this.val$eventName + "  webviewId:" + this.val$webviweId);
    }
    this.this$0.evaluateJavascript(str, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.webview.BaseAppBrandWebview.1
 * JD-Core Version:    0.7.0.1
 */