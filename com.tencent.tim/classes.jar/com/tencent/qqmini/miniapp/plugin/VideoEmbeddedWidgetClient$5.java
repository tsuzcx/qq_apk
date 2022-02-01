package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.util.TextureRender.VideoTextureRenderer;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnVideoSizeChangedListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class VideoEmbeddedWidgetClient$5
  implements IMediaPlayer.OnVideoSizeChangedListener
{
  VideoEmbeddedWidgetClient$5(VideoEmbeddedWidgetClient paramVideoEmbeddedWidgetClient) {}
  
  public void onVideoSizeChanged(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    QMLog.i("miniapp-embedded", "onVideoSizeChanged : w - " + paramInt1 + "; h - " + paramInt2);
    VideoEmbeddedWidgetClient.access$1102(this.this$0, paramInt1);
    VideoEmbeddedWidgetClient.access$1202(this.this$0, paramInt2);
    if (VideoEmbeddedWidgetClient.access$1300(this.this$0) != null)
    {
      VideoEmbeddedWidgetClient.access$1300(this.this$0).setVideoSize(paramInt1, paramInt2, VideoEmbeddedWidgetClient.access$1400(this.this$0));
      return;
    }
    QMLog.e("miniapp-embedded", "setOnVideoSizeChangedListener renderer is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.VideoEmbeddedWidgetClient.5
 * JD-Core Version:    0.7.0.1
 */