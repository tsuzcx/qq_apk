package com.tencent.mobileqq.minigame.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import org.json.JSONObject;

class VideoPlugin$2
  implements Runnable
{
  VideoPlugin$2(VideoPlugin paramVideoPlugin, GameActivity paramGameActivity, JsRuntime paramJsRuntime, int paramInt1, JSONObject paramJSONObject1, String paramString, JSONObject paramJSONObject2, int paramInt2) {}
  
  public void run()
  {
    VideoPlugin.access$000(this.this$0, this.val$activity, this.val$webview, this.val$videoPlayerId, this.val$jsonObject);
    this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$eventName, this.val$result, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.VideoPlugin.2
 * JD-Core Version:    0.7.0.1
 */