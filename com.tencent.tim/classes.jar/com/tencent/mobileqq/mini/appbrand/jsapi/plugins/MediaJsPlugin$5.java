package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import org.json.JSONObject;

class MediaJsPlugin$5
  implements Runnable
{
  MediaJsPlugin$5(MediaJsPlugin paramMediaJsPlugin, JsRuntime paramJsRuntime, int paramInt1, JSONObject paramJSONObject, String paramString, int paramInt2) {}
  
  public void run()
  {
    WebviewContainer localWebviewContainer = this.this$0.jsPluginEngine.getWebviewContainer(this.val$webview);
    if (localWebviewContainer != null)
    {
      localWebviewContainer.updateVideoPlayer(this.val$videoPlayerId, this.val$jsonObject);
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.MediaJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */