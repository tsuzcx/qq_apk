package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class UIJsPlugin$27
  implements Runnable
{
  UIJsPlugin$27(UIJsPlugin paramUIJsPlugin, JsRuntime paramJsRuntime, JSONObject paramJSONObject, String paramString, int paramInt) {}
  
  public void run()
  {
    WebviewContainer localWebviewContainer = this.this$0.jsPluginEngine.getWebviewContainer(this.val$webview);
    if (localWebviewContainer != null) {
      try
      {
        localWebviewContainer.updateTextView(this.val$jsonObject);
        this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("[mini] UIJsPlugin", 1, this.val$event + " error.", localThrowable);
        }
      }
    }
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, "container is null", this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.27
 * JD-Core Version:    0.7.0.1
 */