package com.tencent.biz.pubaccount.readinjoy.viola.videonew;

import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import myi;

class VideoPlayManager$1
  implements Runnable
{
  VideoPlayManager$1(VideoPlayManager paramVideoPlayManager, VideoPlayManager.c paramc) {}
  
  public void run()
  {
    VideoPlayManager.c.a(this.b, VideoPlayManager.a(this.this$0, this.b));
    if ((VideoPlayManager.c.b(this.b) != null) && (VideoPlayManager.a(this.this$0) != null))
    {
      VideoPlayManager.c.b(this.b).setTag(this.b.b);
      VideoPlayManager.a(this.this$0).add(VideoPlayManager.c.b(this.b));
      VideoPlayManager.a(this.this$0).post(new VideoPlayManager.1.1(this));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Viola.VideoPlayManager", 2, "createVideoPlayerAndPlay aysnc run error : playerParam.videoPlayer = " + VideoPlayManager.c.b(this.b) + ", mUIHandler = " + VideoPlayManager.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager.1
 * JD-Core Version:    0.7.0.1
 */