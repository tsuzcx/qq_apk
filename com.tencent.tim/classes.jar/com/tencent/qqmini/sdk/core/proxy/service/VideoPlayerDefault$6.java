package com.tencent.qqmini.sdk.core.proxy.service;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnInfoListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnInfoListener;

class VideoPlayerDefault$6
  implements MediaPlayer.OnInfoListener
{
  VideoPlayerDefault$6(VideoPlayerDefault paramVideoPlayerDefault, AbsVideoPlayer.OnInfoListener paramOnInfoListener) {}
  
  public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (this.val$listener != null) {
      this.val$listener.onInfo(this.this$0, paramInt1, paramInt2);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.VideoPlayerDefault.6
 * JD-Core Version:    0.7.0.1
 */