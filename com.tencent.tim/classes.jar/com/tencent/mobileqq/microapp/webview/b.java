package com.tencent.mobileqq.microapp.webview;

import com.tencent.qphone.base.util.QLog;

final class b
  implements Runnable
{
  b(BaseAppBrandWebview paramBaseAppBrandWebview, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    String str = "WeixinJSBridge.subscribeHandler(\"" + this.a + "\"," + this.b + "," + 0 + ",\"" + this.c + "\")";
    if (QLog.isColorLevel()) {
      QLog.d(BaseAppBrandWebview.access$000(), 2, "evaluateSubcribeJSInService: " + str);
    }
    this.d.evaluateJavascript(str, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.webview.b
 * JD-Core Version:    0.7.0.1
 */