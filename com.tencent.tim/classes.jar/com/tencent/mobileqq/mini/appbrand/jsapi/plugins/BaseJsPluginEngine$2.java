package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class BaseJsPluginEngine$2
  implements MiniAppCmdInterface
{
  BaseJsPluginEngine$2(BaseJsPluginEngine paramBaseJsPluginEngine, JsRuntime paramJsRuntime, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.e("BaseJsPluginEngine", 2, "setAuthorize() onCmdListener isSuccess: " + paramBoolean + "   ; ret: " + paramJSONObject);
    }
    if (paramJSONObject != null)
    {
      if (paramJSONObject.optLong("retCode") == -101510007L) {}
      try
      {
        paramJSONObject.put("SubscribeAppMsgCode", -2);
        this.this$0.callbackJsEventFail(this.val$webview, "subscribeAppMsg", paramJSONObject, "no login", this.val$callbackId);
        return;
      }
      catch (JSONException localJSONException)
      {
        JSONObject localJSONObject;
        QLog.e("BaseJsPluginEngine", 1, "reqGrantSubscribeApiPermission - authorizeListener get a JSONException:", localJSONException);
        this.this$0.callbackJsEventFail(this.val$webview, "subscribeAppMsg", paramJSONObject, this.val$callbackId);
        return;
      }
      if (paramBoolean)
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("SubscribeAppMsgCode", 1);
        this.this$0.callbackJsEventOK(this.val$webview, "subscribeAppMsg", localJSONObject, this.val$callbackId);
        return;
      }
      paramJSONObject.put("SubscribeAppMsgCode", -2);
      this.this$0.callbackJsEventFail(this.val$webview, "subscribeAppMsg", paramJSONObject, this.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine.2
 * JD-Core Version:    0.7.0.1
 */