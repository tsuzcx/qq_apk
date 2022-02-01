package com.tencent.mobileqq.minigame.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.webview.JsRuntime;

class VideoPlugin$4
  implements Runnable
{
  VideoPlugin$4(VideoPlugin paramVideoPlugin, JsRuntime paramJsRuntime, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2) {}
  
  public void run()
  {
    if (this.this$0.operateVideoPlayer(this.val$webview, this.val$videoPlayerId, this.val$type, this.val$jsonParams))
    {
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$eventName, null, this.val$callbackId);
      return;
    }
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.VideoPlugin.4
 * JD-Core Version:    0.7.0.1
 */