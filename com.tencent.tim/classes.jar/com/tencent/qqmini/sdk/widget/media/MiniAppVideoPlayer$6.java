package com.tencent.qqmini.sdk.widget.media;

import android.app.Activity;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnControllerClickListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.ref.WeakReference;

class MiniAppVideoPlayer$6
  implements AbsVideoPlayer.OnControllerClickListener
{
  MiniAppVideoPlayer$6(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void onAttationClick(AbsVideoPlayer paramAbsVideoPlayer) {}
  
  public void onBackClick(AbsVideoPlayer paramAbsVideoPlayer)
  {
    QMLog.d("MiniAppVideoPlayer", "video player onBackClick");
    if ((Activity)this.this$0.atyRef.get() == null) {}
    while (!this.this$0.isFullScreen) {
      return;
    }
    this.this$0.smallScreen();
  }
  
  public void onBackOnFullScreenClick(AbsVideoPlayer paramAbsVideoPlayer)
  {
    QMLog.d("MiniAppVideoPlayer", "video player onBackOnFullScreenClick");
    if ((Activity)this.this$0.atyRef.get() == null) {}
    while (!this.this$0.isFullScreen) {
      return;
    }
    this.this$0.smallScreen();
  }
  
  public void onCacheClick(AbsVideoPlayer paramAbsVideoPlayer) {}
  
  public void onFeedbackClick(AbsVideoPlayer paramAbsVideoPlayer) {}
  
  public void onFullScreenClick(AbsVideoPlayer paramAbsVideoPlayer)
  {
    if (this.this$0.isFullScreen)
    {
      this.this$0.smallScreen();
      return;
    }
    this.this$0.fullScreen();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoPlayer.6
 * JD-Core Version:    0.7.0.1
 */