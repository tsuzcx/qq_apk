package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import org.json.JSONObject;

class BaseJsPluginEngine$3
  implements MiniAppCmdInterface
{
  BaseJsPluginEngine$3(BaseJsPluginEngine paramBaseJsPluginEngine, String paramString, JsRuntime paramJsRuntime, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    BaseJsPluginEngine.access$200(this.this$0, this.val$jsonParams, this.val$webview, this.val$callbackId, paramBoolean, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine.3
 * JD-Core Version:    0.7.0.1
 */