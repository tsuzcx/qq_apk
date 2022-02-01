package com.tencent.mobileqq.mini.appbrand.page.embedded;

import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.media.live.TXLivePushListenerReflect.OnBGMNotify;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class LivePusherEmbeddedWidgetClient$2
  implements TXLivePushListenerReflect.OnBGMNotify
{
  LivePusherEmbeddedWidgetClient$2(LivePusherEmbeddedWidgetClient paramLivePusherEmbeddedWidgetClient, JsRuntime paramJsRuntime) {}
  
  public void onBGMComplete(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("miniapp-embedded-live-pusher", 2, "onBGMComplete, errCode:" + paramInt);
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("viewId", LivePusherEmbeddedWidgetClient.access$100(this.this$0));
      localJSONObject.put("errCode", paramInt);
      this.val$webview.evaluateSubcribeJS("onXWebLivePusherBGMComplete", localJSONObject.toString(), LivePusherEmbeddedWidgetClient.access$200(this.this$0));
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void onBGMProgress(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("miniapp-embedded-live-pusher", 1, "onBGMProgress progress:" + paramLong1 + ",duration:" + paramLong2);
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("viewId", LivePusherEmbeddedWidgetClient.access$100(this.this$0));
      localJSONObject.put("progress", paramLong1);
      localJSONObject.put("duration", paramLong2);
      this.val$webview.evaluateSubcribeJS("onXWebLivePusherBGMProgress", localJSONObject.toString(), LivePusherEmbeddedWidgetClient.access$200(this.this$0));
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void onBGMStart()
  {
    QLog.e("miniapp-embedded-live-pusher", 1, "onBGMStart");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("viewId", LivePusherEmbeddedWidgetClient.access$100(this.this$0));
      this.val$webview.evaluateSubcribeJS("onXWebLivePusherBGMStart", localJSONObject.toString(), LivePusherEmbeddedWidgetClient.access$200(this.this$0));
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.embedded.LivePusherEmbeddedWidgetClient.2
 * JD-Core Version:    0.7.0.1
 */