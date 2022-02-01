package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import android.animation.ObjectAnimator;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.qphone.base.util.QLog;

class VideoView$9
  implements Runnable
{
  VideoView$9(VideoView paramVideoView) {}
  
  public void run()
  {
    if ((VideoView.a(this.this$0) != null) && (VideoView.b(this.this$0) != null))
    {
      QLog.d("gifvideo.VideoView", 2, this.this$0.getTag() + " displaycover");
      if (VideoView.a(this.this$0) != null) {
        VideoView.a(this.this$0).cancel();
      }
      if (VideoView.b(this.this$0) != null) {
        VideoView.b(this.this$0).cancel();
      }
      VideoView.a(this.this$0).setVisibility(0);
      VideoView.a(this.this$0).setAlpha(1.0F);
      VideoView.g(this.this$0);
      if (VideoView.a(this.this$0))
      {
        VideoView.b(this.this$0).clearAnimation();
        VideoView.b(this.this$0).setVisibility(0);
        VideoView.b(this.this$0).setAlpha(1.0F);
        VideoView.h(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView.9
 * JD-Core Version:    0.7.0.1
 */