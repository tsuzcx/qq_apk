package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class BannerAdPlugin$6
  implements Runnable
{
  BannerAdPlugin$6(BannerAdPlugin paramBannerAdPlugin, String paramString, int paramInt, JsRuntime paramJsRuntime) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("state", "error");
      localJSONObject.put("errMsg", this.val$errMsg);
      localJSONObject.put("errCode", this.val$errorCode);
      BannerAdPlugin.access$300(this.this$0, this.val$webview, localJSONObject, "onBannerAdStateChange");
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("[minigame] BannerAdPlugin", 1, "bannerErrorStateCallback error", localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BannerAdPlugin.6
 * JD-Core Version:    0.7.0.1
 */