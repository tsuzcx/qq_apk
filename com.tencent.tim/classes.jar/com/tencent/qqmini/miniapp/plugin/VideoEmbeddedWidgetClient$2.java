package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnPreparedListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class VideoEmbeddedWidgetClient$2
  implements IMediaPlayer.OnPreparedListener
{
  VideoEmbeddedWidgetClient$2(VideoEmbeddedWidgetClient paramVideoEmbeddedWidgetClient) {}
  
  public void onPrepared(IMediaPlayer paramIMediaPlayer)
  {
    long l2 = 0L;
    QMLog.d("miniapp-embedded", "onPrepared");
    VideoEmbeddedWidgetClient.access$1002(this.this$0, true);
    this.this$0.sendEvent(Integer.valueOf(5));
    if (VideoEmbeddedWidgetClient.access$500(this.this$0) != null) {}
    try
    {
      long l1 = VideoEmbeddedWidgetClient.access$500(this.this$0).getDuration();
      if (l1 > 0L)
      {
        l1 /= 1000L;
        paramIMediaPlayer = new JSONObject();
        paramIMediaPlayer.put("data", VideoEmbeddedWidgetClient.access$600(this.this$0));
        paramIMediaPlayer.put("position", VideoEmbeddedWidgetClient.access$500(this.this$0).getCurrentPosition() / 1000.0D);
        if ((VideoEmbeddedWidgetClient.access$400(this.this$0) == null) || (!VideoEmbeddedWidgetClient.access$400(this.this$0).booleanValue())) {
          break label242;
        }
        l1 = l2;
      }
      label242:
      for (;;)
      {
        paramIMediaPlayer.put("duration", l1);
        paramIMediaPlayer.put("videoPlayerId", VideoEmbeddedWidgetClient.access$700(this.this$0));
        VideoEmbeddedWidgetClient.access$900(this.this$0).evaluateSubscribeJS("onXWebVideoTimeUpdate", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
        VideoEmbeddedWidgetClient.access$200(this.this$0).evaluateSubscribeJS("onXWebVideoTimeUpdate", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
        QMLog.d("miniapp-embedded", "evaluateSubcribeJS onXWebVideoTimeUpdate onPrepared = " + paramIMediaPlayer.toString());
        return;
        l1 = 0L;
        break;
      }
      return;
    }
    catch (Throwable paramIMediaPlayer)
    {
      QMLog.e("miniapp-embedded", "VIDEO_EVENT_TIME_UPDATE  error.", paramIMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.VideoEmbeddedWidgetClient.2
 * JD-Core Version:    0.7.0.1
 */