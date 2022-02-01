package com.tencent.mobileqq.mini.appbrand.page.embedded;

import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener;

class VideoEmbeddedWidgetClient$3
  implements IMediaPlayer.OnInfoListener
{
  VideoEmbeddedWidgetClient$3(VideoEmbeddedWidgetClient paramVideoEmbeddedWidgetClient) {}
  
  public boolean onInfo(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    long l2 = 0L;
    QLog.d("miniapp-embedded", 2, "onInfo what : " + paramInt1 + "; extra : " + paramInt2 + "; isHls : " + VideoEmbeddedWidgetClient.access$400(this.this$0));
    switch (paramInt1)
    {
    }
    for (;;)
    {
      return false;
      if (VideoEmbeddedWidgetClient.access$200(this.this$0) != null)
      {
        label375:
        label381:
        for (;;)
        {
          try
          {
            l1 = VideoEmbeddedWidgetClient.access$500(this.this$0).getDuration();
            if (l1 <= 0L) {
              break label375;
            }
            l1 /= 1000L;
            paramIMediaPlayer = new JSONObject();
            paramIMediaPlayer.put("data", VideoEmbeddedWidgetClient.access$600(this.this$0));
            paramIMediaPlayer.put("videoPlayerId", VideoEmbeddedWidgetClient.access$700(this.this$0));
            if ((VideoEmbeddedWidgetClient.access$400(this.this$0) == null) || (!VideoEmbeddedWidgetClient.access$400(this.this$0).booleanValue())) {
              break label381;
            }
            l1 = l2;
            paramIMediaPlayer.put("duration", l1);
            paramIMediaPlayer.put("width", VideoEmbeddedWidgetClient.access$500(this.this$0).getVideoWidth() / DisplayUtil.getDensity(VideoEmbeddedWidgetClient.access$200(this.this$0).getContextEx()));
            paramIMediaPlayer.put("height", VideoEmbeddedWidgetClient.access$500(this.this$0).getVideoHeight() / DisplayUtil.getDensity(VideoEmbeddedWidgetClient.access$200(this.this$0).getContextEx()));
            ((AppBrandRuntime)VideoEmbeddedWidgetClient.access$900(this.this$0)).serviceRuntime.evaluateSubcribeJS("onXWebVideoLoadedMetaData", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
            VideoEmbeddedWidgetClient.access$200(this.this$0).evaluateSubcribeJS("onXWebVideoLoadedMetaData", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
            QLog.d("miniapp-embedded", 2, "evaluateSubcribeJS onXWebVideoLoadedMetaData = " + paramIMediaPlayer.toString());
          }
          catch (Throwable paramIMediaPlayer)
          {
            QLog.e("miniapp-embedded", 1, "VIDEO_EVENT_LOADED_METADATA  error.", paramIMediaPlayer);
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
            ((AppBrandRuntime)VideoEmbeddedWidgetClient.access$900(this.this$0)).serviceRuntime.evaluateSubcribeJS("onXWebVideoWaiting", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
            VideoEmbeddedWidgetClient.access$200(this.this$0).evaluateSubcribeJS("onXWebVideoWaiting", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
            QLog.d("miniapp-embedded", 2, "evaluateSubcribeJS onXWebVideoWaiting = " + paramIMediaPlayer.toString());
          }
          catch (Throwable paramIMediaPlayer)
          {
            QLog.e("miniapp-embedded", 1, "VIDEO_EVENT_WAITING  error.", paramIMediaPlayer);
          }
          continue;
          if (VideoEmbeddedWidgetClient.access$200(this.this$0) != null) {
            try
            {
              paramIMediaPlayer = new JSONObject();
              paramIMediaPlayer.put("data", VideoEmbeddedWidgetClient.access$600(this.this$0));
              paramIMediaPlayer.put("videoPlayerId", VideoEmbeddedWidgetClient.access$700(this.this$0));
              paramIMediaPlayer.put("timeStamp", System.currentTimeMillis());
              ((AppBrandRuntime)VideoEmbeddedWidgetClient.access$900(this.this$0)).serviceRuntime.evaluateSubcribeJS("onXWebVideoPlay", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
              VideoEmbeddedWidgetClient.access$200(this.this$0).evaluateSubcribeJS("onXWebVideoPlay", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
              QLog.d("miniapp-embedded", 2, "evaluateSubcribeJS onXWebVideoPlay = " + paramIMediaPlayer.toString());
            }
            catch (Throwable paramIMediaPlayer)
            {
              QLog.e("miniapp-embedded", 1, "VIDEO_EVENT_PLAY error.", paramIMediaPlayer);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.embedded.VideoEmbeddedWidgetClient.3
 * JD-Core Version:    0.7.0.1
 */