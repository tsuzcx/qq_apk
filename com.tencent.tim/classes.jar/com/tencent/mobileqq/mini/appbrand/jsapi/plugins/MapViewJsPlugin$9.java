package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.MapContext;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class MapViewJsPlugin$9
  implements Runnable
{
  MapViewJsPlugin$9(MapViewJsPlugin paramMapViewJsPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.val$jsonParams);
        i = localJSONObject.optInt("mapId", 0);
        Object localObject = this.this$0.jsPluginEngine.getWebviewContainer(this.val$webview);
        if (localObject != null)
        {
          localObject = ((WebviewContainer)localObject).getMapContext(i);
          if (localObject == null) {
            break label186;
          }
          ((MapContext)localObject).translateMapMarker(localJSONObject);
          i = 1;
          if (i != 0) {
            this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$eventName, null, this.val$callbackId);
          }
        }
        else
        {
          QLog.w("[mini] MapViewJsPlugin", 2, "handleNativeRequest eventName=" + this.val$eventName + "，top page not found");
          break label186;
        }
        this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, this.val$callbackId);
        return;
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("[mini] MapViewJsPlugin", 2, localJSONException, new Object[0]);
        }
        this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, this.val$callbackId);
        return;
      }
      label186:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.MapViewJsPlugin.9
 * JD-Core Version:    0.7.0.1
 */