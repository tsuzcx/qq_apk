package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class DataJsPlugin$2
  implements MiniAppCmdInterface
{
  DataJsPlugin$2(DataJsPlugin paramDataJsPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt, JSONObject paramJSONObject) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QLog.d("[mini] DataJsPlugin", 1, "phonenumber onCmdListener, isSuc : " + paramBoolean + "; ret : " + paramJSONObject);
    JSONArray localJSONArray = new JSONArray();
    String str;
    if (paramJSONObject != null)
    {
      str = paramJSONObject.optString("errMsg");
      localJSONArray = paramJSONObject.optJSONArray("phoneLists");
    }
    for (;;)
    {
      if (paramBoolean)
      {
        if ((localJSONArray == null) || (localJSONArray.length() == 0))
        {
          this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.this$0.jsPluginEngine.activityContext.getString(2131695912), this.val$callbackId);
          return;
        }
        try
        {
          this.val$params.put("getPhoneNumber", paramJSONObject);
          this.this$0.jsPluginEngine.reqGrantApiPermission(this.val$event, this.val$params.toString(), this.val$webview, this.val$callbackId, new DataJsPlugin.2.1(this, paramJSONObject));
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, str, this.val$callbackId);
      return;
      str = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */