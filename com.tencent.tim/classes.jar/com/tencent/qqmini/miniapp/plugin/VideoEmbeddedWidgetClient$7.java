package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayerUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import org.json.JSONObject;

class VideoEmbeddedWidgetClient$7
  implements Runnable
{
  VideoEmbeddedWidgetClient$7(VideoEmbeddedWidgetClient paramVideoEmbeddedWidgetClient) {}
  
  public void run()
  {
    QMLog.d("miniapp-embedded", "VideoManager probeContentFlag getSubThreadHandler start. " + VideoEmbeddedWidgetClient.access$1600(this.this$0));
    long l1 = System.currentTimeMillis();
    IMediaPlayerUtil localIMediaPlayerUtil = VideoEmbeddedWidgetClient.access$1800(this.this$0);
    Object localObject;
    if (VideoEmbeddedWidgetClient.access$1700(this.this$0) != null) {
      localObject = ((MiniAppFileManager)VideoEmbeddedWidgetClient.access$1700(this.this$0).getManager(MiniAppFileManager.class)).getAbsolutePath(VideoEmbeddedWidgetClient.access$1600(this.this$0));
    }
    for (;;)
    {
      localObject = localIMediaPlayerUtil.getUrl((String)localObject);
      int i = VideoEmbeddedWidgetClient.access$1800(this.this$0).getContentFlag((String)localObject);
      QMLog.d("miniapp-embedded", "VideoManager probeContentFlag const : " + (System.currentTimeMillis() - l1));
      localObject = this.this$0;
      boolean bool;
      if (i == 5)
      {
        bool = true;
        label150:
        VideoEmbeddedWidgetClient.access$402((VideoEmbeddedWidgetClient)localObject, Boolean.valueOf(bool));
        QMLog.d("miniapp-embedded", "VideoManager probeContentFlag isHls : " + VideoEmbeddedWidgetClient.access$400(this.this$0) + "; flag : " + i);
        if (VideoEmbeddedWidgetClient.access$200(this.this$0) == null) {}
      }
      try
      {
        l1 = VideoEmbeddedWidgetClient.access$500(this.this$0).getDuration();
        if (l1 > 0L) {}
        for (l1 /= 1000L;; l1 = 0L)
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("data", VideoEmbeddedWidgetClient.access$600(this.this$0));
          ((JSONObject)localObject).put("videoPlayerId", VideoEmbeddedWidgetClient.access$700(this.this$0));
          long l2 = l1;
          if (VideoEmbeddedWidgetClient.access$400(this.this$0) != null)
          {
            l2 = l1;
            if (VideoEmbeddedWidgetClient.access$400(this.this$0).booleanValue()) {
              l2 = 0L;
            }
          }
          ((JSONObject)localObject).put("duration", l2);
          ((JSONObject)localObject).put("width", VideoEmbeddedWidgetClient.access$500(this.this$0).getVideoWidth() / DisplayUtil.getDensity(AppLoaderFactory.g().getContext()));
          ((JSONObject)localObject).put("height", VideoEmbeddedWidgetClient.access$500(this.this$0).getVideoHeight() / DisplayUtil.getDensity(AppLoaderFactory.g().getContext()));
          VideoEmbeddedWidgetClient.access$900(this.this$0).evaluateSubscribeJS("onXWebVideoLoadedMetaData", ((JSONObject)localObject).toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
          VideoEmbeddedWidgetClient.access$200(this.this$0).evaluateSubscribeJS("onXWebVideoLoadedMetaData", ((JSONObject)localObject).toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
          QMLog.d("miniapp-embedded", "MSG_IS_HLS evaluateSubcribeJS onXWebVideoLoadedMetaData = " + ((JSONObject)localObject).toString());
          return;
          localObject = "";
          break;
          bool = false;
          break label150;
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("miniapp-embedded", "VIDEO_EVENT_LOADED_METADATA error.", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.VideoEmbeddedWidgetClient.7
 * JD-Core Version:    0.7.0.1
 */