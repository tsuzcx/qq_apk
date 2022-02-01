package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.widget.media.live.TXLivePushListenerReflect.OnBGMNotify;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class LivePusherEmbeddedWidgetClient$2
  implements TXLivePushListenerReflect.OnBGMNotify
{
  LivePusherEmbeddedWidgetClient$2(LivePusherEmbeddedWidgetClient paramLivePusherEmbeddedWidgetClient) {}
  
  public void onBGMComplete(int paramInt)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("miniapp-embedded-live-pusher", "onBGMComplete, errCode:" + paramInt);
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("viewId", LivePusherEmbeddedWidgetClient.access$100(this.this$0));
      localJSONObject.put("errCode", paramInt);
      LivePusherEmbeddedWidgetClient.access$300(this.this$0, "onXWebLivePusherBGMComplete", localJSONObject.toString(), LivePusherEmbeddedWidgetClient.access$200(this.this$0));
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void onBGMProgress(long paramLong1, long paramLong2)
  {
    if (QMLog.isColorLevel()) {
      QMLog.e("miniapp-embedded-live-pusher", "onBGMProgress progress:" + paramLong1 + ",duration:" + paramLong2);
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("viewId", LivePusherEmbeddedWidgetClient.access$100(this.this$0));
      localJSONObject.put("progress", paramLong1);
      localJSONObject.put("duration", paramLong2);
      LivePusherEmbeddedWidgetClient.access$300(this.this$0, "onXWebLivePusherBGMProgress", localJSONObject.toString(), LivePusherEmbeddedWidgetClient.access$200(this.this$0));
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void onBGMStart()
  {
    QMLog.e("miniapp-embedded-live-pusher", "onBGMStart");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("viewId", LivePusherEmbeddedWidgetClient.access$100(this.this$0));
      LivePusherEmbeddedWidgetClient.access$300(this.this$0, "onXWebLivePusherBGMStart", localJSONObject.toString(), LivePusherEmbeddedWidgetClient.access$200(this.this$0));
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.LivePusherEmbeddedWidgetClient.2
 * JD-Core Version:    0.7.0.1
 */