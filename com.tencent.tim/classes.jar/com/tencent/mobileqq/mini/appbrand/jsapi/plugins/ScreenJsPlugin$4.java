package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class ScreenJsPlugin$4
  implements Runnable
{
  ScreenJsPlugin$4(ScreenJsPlugin paramScreenJsPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt) {}
  
  public void run()
  {
    try
    {
      if (new JSONObject(this.val$jsonParams).optBoolean("keepScreenOn")) {
        ScreenJsPlugin.keepScreenOn(this.this$0.jsPluginEngine.appBrandRuntime.activity, true);
      }
      for (;;)
      {
        this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$eventName, null, this.val$callbackId);
        return;
        ScreenJsPlugin.keepScreenOn(this.this$0.jsPluginEngine.appBrandRuntime.activity, false);
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
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ScreenJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */