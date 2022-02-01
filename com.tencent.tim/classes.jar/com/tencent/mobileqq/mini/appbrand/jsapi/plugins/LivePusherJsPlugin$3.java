package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;

class LivePusherJsPlugin$3
  implements Runnable
{
  LivePusherJsPlugin$3(LivePusherJsPlugin paramLivePusherJsPlugin, JsRuntime paramJsRuntime, int paramInt1, String paramString, int paramInt2) {}
  
  public void run()
  {
    WebviewContainer localWebviewContainer = this.this$0.jsPluginEngine.getWebviewContainer(this.val$webview);
    if (localWebviewContainer != null)
    {
      localWebviewContainer.removeLivePusher(this.val$livePusherId);
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.LivePusherJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */