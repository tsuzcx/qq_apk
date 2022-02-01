package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class ScreenJsPlugin$3
  implements Runnable
{
  ScreenJsPlugin$3(ScreenJsPlugin paramScreenJsPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.val$jsonParams);
      if (localJSONObject.has("value"))
      {
        double d = localJSONObject.optDouble("value");
        ScreenJsPlugin.setScreenBrightness(this.this$0.jsPluginEngine.appBrandRuntime.activity, (float)d);
        this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$eventName, null, this.val$callbackId);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[mini] ScreenJsPlugin", 2, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ScreenJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */