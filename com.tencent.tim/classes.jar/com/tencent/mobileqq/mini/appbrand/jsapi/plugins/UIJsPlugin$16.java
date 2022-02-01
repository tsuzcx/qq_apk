package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class UIJsPlugin$16
  implements Runnable
{
  UIJsPlugin$16(UIJsPlugin paramUIJsPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt) {}
  
  public void run()
  {
    try
    {
      Object localObject = new JSONObject(this.val$jsonParams);
      int i = ((JSONObject)localObject).optInt("htmlId");
      localObject = ((JSONObject)localObject).optJSONObject("position");
      if (localObject == null) {
        break label269;
      }
      int j = ((JSONObject)localObject).optInt("left");
      int k = ((JSONObject)localObject).optInt("top");
      int m = ((JSONObject)localObject).optInt("width");
      int n = ((JSONObject)localObject).optInt("height");
      localObject = this.this$0.jsPluginEngine.getWebviewContainer(this.val$webview);
      if (localObject != null)
      {
        if (((WebviewContainer)localObject).insertHTMLWebView(i, j, k, m, n))
        {
          this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
          return;
        }
        this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, "create webview failed.", this.val$callbackId);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("[mini] UIJsPlugin", 1, this.val$event + " error.", localException);
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callbackId);
      return;
    }
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callbackId);
    throw new MiniAppException("insertHtmlWebView fail, can not find WebviewContainer, pageWebviewId=" + this.val$webview.getPageWebViewId());
    label269:
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callbackId);
    throw new MiniAppException("insertHtmlWebView fail, position is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.16
 * JD-Core Version:    0.7.0.1
 */