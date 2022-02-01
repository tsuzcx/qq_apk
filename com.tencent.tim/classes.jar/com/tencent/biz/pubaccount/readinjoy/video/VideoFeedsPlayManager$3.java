package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qphone.base.util.QLog;
import myi;

class VideoFeedsPlayManager$3
  implements Runnable
{
  VideoFeedsPlayManager$3(VideoFeedsPlayManager paramVideoFeedsPlayManager) {}
  
  public void run()
  {
    if (VideoFeedsPlayManager.a(this.this$0) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "innerChangeCoverImageView: getCurVideoPlayer().start() ");
      }
      VideoFeedsPlayManager.a(this.this$0).start();
      if ((!VideoFeedsPlayManager.c(this.this$0)) && (VideoFeedsPlayManager.a(this.this$0) != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoFeedsPlayManager.preplay", 2, "activity become onPause after videoPlayer.start()， so we need to pause it");
        }
        VideoFeedsPlayManager.a(this.this$0).pause();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.3
 * JD-Core Version:    0.7.0.1
 */