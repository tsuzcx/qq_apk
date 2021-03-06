package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnInfoListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import org.json.JSONObject;

class VideoEmbeddedWidgetClient$3
  implements IMediaPlayer.OnInfoListener
{
  VideoEmbeddedWidgetClient$3(VideoEmbeddedWidgetClient paramVideoEmbeddedWidgetClient) {}
  
  public boolean onInfo(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    long l2 = 0L;
    QMLog.d("miniapp-embedded", "onInfo what : " + paramInt1 + "; extra : " + paramInt2 + "; isHls : " + VideoEmbeddedWidgetClient.access$400(this.this$0));
    switch (paramInt1)
    {
    }
    for (;;)
    {
      return false;
      if (VideoEmbeddedWidgetClient.access$200(this.this$0) != null)
      {
        label355:
        label361:
        for (;;)
        {
          try
          {
            l1 = VideoEmbeddedWidgetClient.access$500(this.this$0).getDuration();
            if (l1 <= 0L) {
              break label355;
            }
            l1 /= 1000L;
            paramIMediaPlayer = new JSONObject();
            paramIMediaPlayer.put("data", VideoEmbeddedWidgetClient.access$600(this.this$0));
            paramIMediaPlayer.put("videoPlayerId", VideoEmbeddedWidgetClient.access$700(this.this$0));
            if ((VideoEmbeddedWidgetClient.access$400(this.this$0) == null) || (!VideoEmbeddedWidgetClient.access$400(this.this$0).booleanValue())) {
              break label361;
            }
            l1 = l2;
            paramIMediaPlayer.put("duration", l1);
            paramIMediaPlayer.put("width", VideoEmbeddedWidgetClient.access$500(this.this$0).getVideoWidth() / DisplayUtil.getDensity(AppLoaderFactory.g().getContext()));
            paramIMediaPlayer.put("height", VideoEmbeddedWidgetClient.access$500(this.this$0).getVideoHeight() / DisplayUtil.getDensity(AppLoaderFactory.g().getContext()));
            VideoEmbeddedWidgetClient.access$900(this.this$0).evaluateSubscribeJS("onXWebVideoLoadedMetaData", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
            VideoEmbeddedWidgetClient.access$200(this.this$0).evaluateSubscribeJS("onXWebVideoLoadedMetaData", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
            QMLog.d("miniapp-embedded", "evaluateSubcribeJS onXWebVideoLoadedMetaData = " + paramIMediaPlayer.toString());
          }
          catch (Throwable paramIMediaPlayer)
          {
            QMLog.e("miniapp-embedded", "VIDEO_EVENT_LOADED_METADATA  error.", paramIMediaPlayer);
          }
          break;
          long l1 = 0L;
        }
        if (VideoEmbeddedWidgetClient.access$200(this.this$0) != null)
        {
          try
          {
            paramIMediaPlayer = new JSONObject();
            paramIMediaPlayer.put("data", VideoEmbeddedWidgetClient.access$600(this.this$0));
            paramIMediaPlayer.put("videoPlayerId", VideoEmbeddedWidgetClient.access$700(this.this$0));
            VideoEmbeddedWidgetClient.access$900(this.this$0).evaluateSubscribeJS("onXWebVideoWaiting", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
            VideoEmbeddedWidgetClient.access$200(this.this$0).evaluateSubscribeJS("onXWebVideoWaiting", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
            QMLog.d("miniapp-embedded", "evaluateSubcribeJS onXWebVideoWaiting = " + paramIMediaPlayer.toString());
          }
          catch (Throwable paramIMediaPlayer)
          {
            QMLog.e("miniapp-embedded", "VIDEO_EVENT_WAITING  error.", paramIMediaPlayer);
          }
          continue;
          if (VideoEmbeddedWidgetClient.access$200(this.this$0) != null) {
            try
            {
              paramIMediaPlayer = new JSONObject();
              paramIMediaPlayer.put("data", VideoEmbeddedWidgetClient.access$600(this.this$0));
              paramIMediaPlayer.put("videoPlayerId", VideoEmbeddedWidgetClient.access$700(this.this$0));
              paramIMediaPlayer.put("timeStamp", System.currentTimeMillis());
              VideoEmbeddedWidgetClient.access$900(this.this$0).evaluateSubscribeJS("onXWebVideoPlay", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
              VideoEmbeddedWidgetClient.access$200(this.this$0).evaluateSubscribeJS("onXWebVideoPlay", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
              QMLog.d("miniapp-embedded", "evaluateSubcribeJS onXWebVideoPlay = " + paramIMediaPlayer.toString());
            }
            catch (Throwable paramIMediaPlayer)
            {
              QMLog.e("miniapp-embedded", "VIDEO_EVENT_PLAY error.", paramIMediaPlayer);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.VideoEmbeddedWidgetClient.3
 * JD-Core Version:    0.7.0.1
 */