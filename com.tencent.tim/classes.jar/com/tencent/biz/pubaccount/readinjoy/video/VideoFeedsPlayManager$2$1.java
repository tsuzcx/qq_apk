package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qphone.base.util.QLog;

class VideoFeedsPlayManager$2$1
  implements Runnable
{
  VideoFeedsPlayManager$2$1(VideoFeedsPlayManager.2 param2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo miss cache");
    }
    VideoFeedsPlayManager.b(this.a.this$0, this.a.d, this.a.apv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.2.1
 * JD-Core Version:    0.7.0.1
 */