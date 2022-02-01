package com.tencent.mobileqq.mini.appbrand.page.embedded;

import android.os.Bundle;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.media.live.TXLivePlayerJSAdapter.IPlayOuterListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class LivePlayerEmbeddedWidgetClient$1
  implements TXLivePlayerJSAdapter.IPlayOuterListener
{
  LivePlayerEmbeddedWidgetClient$1(LivePlayerEmbeddedWidgetClient paramLivePlayerEmbeddedWidgetClient) {}
  
  public void onNetStatus(Bundle paramBundle)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("VIDEO_BITRATE", paramBundle.get("VIDEO_BITRATE"));
      localJSONObject2.put("AUDIO_BITRATE", paramBundle.get("AUDIO_BITRATE"));
      localJSONObject2.put("VIDEO_FPS", paramBundle.get("VIDEO_FPS"));
      localJSONObject2.put("VIDEO_GOP", paramBundle.get("VIDEO_GOP"));
      localJSONObject2.put("NET_SPEED", paramBundle.get("NET_SPEED"));
      localJSONObject2.put("NET_JITTER", paramBundle.get("NET_JITTER"));
      localJSONObject2.put("VIDEO_WIDTH", paramBundle.get("VIDEO_WIDTH"));
      localJSONObject2.put("VIDEO_HEIGHT", paramBundle.get("VIDEO_HEIGHT"));
      localJSONObject1.put("type", "onXWebLivePlayerNetStatus");
      localJSONObject1.put("viewId", LivePlayerEmbeddedWidgetClient.access$000(this.this$0));
      localJSONObject1.put("info", localJSONObject2);
      LivePlayerEmbeddedWidgetClient.access$200(this.this$0).evaluateSubcribeJS("xWebLivePlayerStateChange", localJSONObject1.toString(), LivePlayerEmbeddedWidgetClient.access$100(this.this$0));
      QLog.e("miniapp-embedded-live-player", 4, "operate start evaluateSubcribeJS onLivePlayerNetStatus = " + localJSONObject1.toString());
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    QLog.d("miniapp-embedded-live-player", 1, "onPlayEvent code:" + paramInt);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("viewId", LivePlayerEmbeddedWidgetClient.access$000(this.this$0));
      localJSONObject.put("errCode", paramInt);
      localJSONObject.put("errMsg", paramBundle.get("EVT_MSG"));
      localJSONObject.put("type", "onXWebLivePlayerEvent");
      LivePlayerEmbeddedWidgetClient.access$200(this.this$0).evaluateSubcribeJS("xWebLivePlayerStateChange", localJSONObject.toString(), LivePlayerEmbeddedWidgetClient.access$100(this.this$0));
      QLog.e("miniapp-embedded-live-player", 1, "operate start evaluateSubcribeJS onLivePlayerEvent = " + localJSONObject.toString());
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.embedded.LivePlayerEmbeddedWidgetClient.1
 * JD-Core Version:    0.7.0.1
 */