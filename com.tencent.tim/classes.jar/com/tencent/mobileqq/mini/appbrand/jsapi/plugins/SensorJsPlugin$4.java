package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.webview.JsRuntime;
import org.json.JSONException;
import org.json.JSONObject;

class SensorJsPlugin$4
  implements Runnable
{
  SensorJsPlugin$4(SensorJsPlugin paramSensorJsPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt) {}
  
  public void run()
  {
    int i = 1;
    for (;;)
    {
      int j;
      try
      {
        SensorJsPlugin.access$300(this.this$0);
        JSONObject localJSONObject1 = new JSONObject(this.val$jsonParams);
        if (localJSONObject1.optBoolean("enable"))
        {
          j = localJSONObject1.optInt("interval");
          if (j != 20) {
            break label254;
          }
          if (this.this$0.startGyroscope(i))
          {
            SensorJsPlugin.access$502(this.this$0, true);
            this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$eventName, null, this.val$callbackId);
            return;
          }
          this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, this.val$callbackId);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      this.this$0.stopGyroscope();
      if (!SensorJsPlugin.access$500(this.this$0)) {
        this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, ":fail to disable, not enable?", this.val$callbackId);
      }
      for (;;)
      {
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("errMsg", this.val$eventName + ":cancel");
        this.val$webview.evaluateCallbackJs(this.val$callbackId, localJSONObject2.toString());
        return;
        SensorJsPlugin.access$502(this.this$0, false);
        this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$eventName, null, this.val$callbackId);
      }
      label254:
      while (j != 60)
      {
        JSONObject localJSONObject2;
        i = 3;
        break;
      }
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.SensorJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */