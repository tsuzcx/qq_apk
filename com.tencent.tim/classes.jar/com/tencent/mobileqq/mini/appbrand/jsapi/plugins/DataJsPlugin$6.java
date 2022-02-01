package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.jsapi.GameJsPluginEngine;
import org.json.JSONObject;

class DataJsPlugin$6
  implements MiniAppCmdInterface
{
  DataJsPlugin$6(DataJsPlugin paramDataJsPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null)) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if ((this.this$0.jsPluginEngine instanceof GameJsPluginEngine)) {
          localJSONObject.put("data", paramJSONObject);
        }
        for (;;)
        {
          this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, localJSONObject, this.val$callbackId);
          return;
          localJSONObject.put("data", paramJSONObject.toString());
        }
        this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callbackId);
      }
      catch (Throwable paramJSONObject) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */