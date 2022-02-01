package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class DataJsPlugin$5
  implements MiniAppCmdInterface
{
  DataJsPlugin$5(DataJsPlugin paramDataJsPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[mini] DataJsPlugin", 2, "call checkNavigateRight ： " + paramJSONObject.toString());
      }
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject2.put("data", paramJSONObject.toString());
        localJSONObject1.put("respData", localJSONObject2);
        QLog.d("[mini] DataJsPlugin", 1, "call checkNavigateRight real： " + localJSONObject1.toString());
        this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, localJSONObject1, this.val$callbackId);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          paramJSONObject.printStackTrace();
        }
      }
    }
    QLog.d("[mini] DataJsPlugin", 1, "call checkNavigateRight failed. ");
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */