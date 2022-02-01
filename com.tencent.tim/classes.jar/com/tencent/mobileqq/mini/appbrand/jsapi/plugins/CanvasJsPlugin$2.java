package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import org.json.JSONObject;

class CanvasJsPlugin$2
  implements Runnable
{
  CanvasJsPlugin$2(CanvasJsPlugin paramCanvasJsPlugin, JsRuntime paramJsRuntime, int paramInt1, JSONObject paramJSONObject1, boolean paramBoolean, String paramString, JSONObject paramJSONObject2, int paramInt2) {}
  
  public void run()
  {
    WebviewContainer localWebviewContainer = this.this$0.jsPluginEngine.getWebviewContainer(this.val$webview);
    if (localWebviewContainer != null)
    {
      localWebviewContainer.updateCanvas(this.val$canvasId, this.val$postionObj, this.val$hide);
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, this.val$result, this.val$callbackId);
      return;
    }
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, "container is null", this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.CanvasJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */