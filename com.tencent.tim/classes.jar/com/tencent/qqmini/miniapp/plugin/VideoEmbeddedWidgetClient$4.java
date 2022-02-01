package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnBufferingUpdateListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class VideoEmbeddedWidgetClient$4
  implements IMediaPlayer.OnBufferingUpdateListener
{
  VideoEmbeddedWidgetClient$4(VideoEmbeddedWidgetClient paramVideoEmbeddedWidgetClient) {}
  
  public void onBufferingUpdate(IMediaPlayer paramIMediaPlayer, int paramInt)
  {
    if ((VideoEmbeddedWidgetClient.access$200(this.this$0) != null) && (!VideoEmbeddedWidgetClient.access$100(this.this$0))) {}
    try
    {
      paramIMediaPlayer = new JSONObject();
      paramIMediaPlayer.put("data", VideoEmbeddedWidgetClient.access$600(this.this$0));
      paramIMediaPlayer.put("buffered", paramInt);
      paramIMediaPlayer.put("videoPlayerId", VideoEmbeddedWidgetClient.access$700(this.this$0));
      VideoEmbeddedWidgetClient.access$900(this.this$0).evaluateSubscribeJS("onXWebVideoProgress", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
      VideoEmbeddedWidgetClient.access$200(this.this$0).evaluateSubscribeJS("onXWebVideoProgress", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
      QMLog.d("miniapp-embedded", "evaluateSubcribeJS onXWebVideoProgress = " + paramIMediaPlayer.toString());
      return;
    }
    catch (Throwable paramIMediaPlayer)
    {
      QMLog.e("miniapp-embedded", "VIDEO_EVENT_PROGRESS  error.", paramIMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.VideoEmbeddedWidgetClient.4
 * JD-Core Version:    0.7.0.1
 */