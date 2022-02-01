package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Handler;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import myi;

class VideoFeedsPlayManager$2
  implements Runnable
{
  VideoFeedsPlayManager$2(VideoFeedsPlayManager paramVideoFeedsPlayManager, VideoFeedsPlayManager.b paramb, boolean paramBoolean) {}
  
  public void run()
  {
    this.d.e = VideoFeedsPlayManager.b(this.this$0, this.d);
    if ((this.d.e != null) && (VideoFeedsPlayManager.a(this.this$0) != null) && (this.d.d != null))
    {
      this.d.e.setTag(this.d.d);
      if (this.d.d.Wz != null)
      {
        VideoFeedsPlayManager.a(this.this$0).put(this.d.d.Wz, this.d.e);
        VideoFeedsPlayManager.a(this.this$0).post(new VideoFeedsPlayManager.2.1(this));
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        VideoFeedsPlayManager.a(this.this$0).put(String.valueOf(VideoFeedsPlayManager.a(this.this$0)), this.d.e);
        VideoFeedsPlayManager.b(this.this$0);
      }
    }
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "createVideoPlayerAndPlay aysnc run error : playerParam.videoPlayer = " + this.d.e + ", mUIHandler = " + VideoFeedsPlayManager.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.2
 * JD-Core Version:    0.7.0.1
 */