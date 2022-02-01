package com.tencent.mobileqq.videoplatform;

import com.tencent.mobileqq.videoplatform.util.LogUtil;
import com.tencent.superplayer.api.ISuperPlayer;

class VideoPlayerProxy$2
  implements Runnable
{
  VideoPlayerProxy$2(VideoPlayerProxy paramVideoPlayerProxy) {}
  
  public void run()
  {
    try
    {
      if ((VideoPlayerProxy.access$000(this.this$0) != null) && (VideoPlayerProxy.access$000(this.this$0).isPlaying()))
      {
        if (LogUtil.isColorLevel()) {
          LogUtil.d(this.this$0.getLogTag(), 2, "mMediaPlayer.pause()");
        }
        VideoPlayerProxy.access$000(this.this$0).pause();
        VideoPlayerProxy.access$200(this.this$0);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.VideoPlayerProxy.2
 * JD-Core Version:    0.7.0.1
 */