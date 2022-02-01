package com.tencent.mobileqq.mini.webview;

import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;

class BaseAppBrandWebview$4
  implements ValueCallback
{
  BaseAppBrandWebview$4(BaseAppBrandWebview paramBaseAppBrandWebview, ValueCallback paramValueCallback) {}
  
  public void onReceiveValue(Object paramObject)
  {
    QLog.i("miniapp-start", 1, "---initJSDefaultConfig finished --- webviewid:" + this.this$0.pageWebviewId);
    if (this.val$callback != null) {
      this.val$callback.onReceiveValue(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.webview.BaseAppBrandWebview.4
 * JD-Core Version:    0.7.0.1
 */