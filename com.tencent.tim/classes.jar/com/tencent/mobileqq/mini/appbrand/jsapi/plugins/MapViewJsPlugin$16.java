package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.MapContext;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class MapViewJsPlugin$16
  implements Runnable
{
  MapViewJsPlugin$16(MapViewJsPlugin paramMapViewJsPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt) {}
  
  public void run()
  {
    try
    {
      int i = new JSONObject(this.val$jsonParams).optInt("mapId", 0);
      Object localObject = this.this$0.jsPluginEngine.getWebviewContainer(this.val$webview);
      if (localObject == null) {
        break label188;
      }
      localObject = ((WebviewContainer)localObject).getMapContext(i);
      if (localObject != null)
      {
        float f = ((MapContext)localObject).getSkew();
        localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("skew", f);
          this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$eventName, (JSONObject)localObject, this.val$callbackId);
          return;
        }
        catch (JSONException localJSONException1)
        {
          localJSONException1.printStackTrace();
          this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, this.val$callbackId);
          return;
        }
      }
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, this.val$callbackId);
    }
    catch (JSONException localJSONException2)
    {
      if (QLog.isColorLevel()) {
        QLog.e("[mini] MapViewJsPlugin", 2, localJSONException2, new Object[0]);
      }
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, this.val$callbackId);
      return;
    }
    return;
    label188:
    QLog.w("[mini] MapViewJsPlugin", 2, "handleNativeRequest eventName=" + this.val$eventName + "，top page not found");
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.MapViewJsPlugin.16
 * JD-Core Version:    0.7.0.1
 */