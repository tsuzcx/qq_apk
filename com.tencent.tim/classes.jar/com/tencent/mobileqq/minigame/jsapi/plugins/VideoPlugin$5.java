package com.tencent.mobileqq.minigame.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.webview.JsRuntime;

class VideoPlugin$5
  implements Runnable
{
  VideoPlugin$5(VideoPlugin paramVideoPlugin, int paramInt1, JsRuntime paramJsRuntime, String paramString, int paramInt2) {}
  
  public void run()
  {
    VideoPlugin.access$200(this.this$0, this.val$videoPlayerId);
    this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$eventName, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.VideoPlugin.5
 * JD-Core Version:    0.7.0.1
 */