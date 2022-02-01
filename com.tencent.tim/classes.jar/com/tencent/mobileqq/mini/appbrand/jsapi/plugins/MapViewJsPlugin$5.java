package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.MapContext;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class MapViewJsPlugin$5
  implements Runnable
{
  MapViewJsPlugin$5(MapViewJsPlugin paramMapViewJsPlugin, JsRuntime paramJsRuntime, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.this$0.jsPluginEngine.getWebviewContainer(this.val$webview);
    if (localObject != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.val$jsonParams);
        localObject = ((WebviewContainer)localObject).getMapContext(localJSONObject.optInt("mapId"));
        if (localObject != null)
        {
          ((MapContext)localObject).addMapCircles(localJSONObject);
          this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$eventName, null, this.val$callbackId);
          return;
        }
        this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, this.val$callbackId);
        return;
      }
      catch (JSONException localJSONException)
      {
        QLog.e("[mini] MapViewJsPlugin", 1, this.val$eventName + " error.", localJSONException);
        this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, this.val$callbackId);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.MapViewJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */