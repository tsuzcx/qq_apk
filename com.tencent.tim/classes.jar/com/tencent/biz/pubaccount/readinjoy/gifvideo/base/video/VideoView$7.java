package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class VideoView$7
  implements Runnable
{
  VideoView$7(VideoView paramVideoView) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if ((this.this$0.getCurrentState() != 4) && (this.this$0.getCurrentState() != 9) && (this.this$0.getCurrentState() != 10) && (VideoView.a(this.this$0) != VideoView.aOA))
        {
          QLog.d("gifvideo.VideoView", 1, "current state is " + this.this$0.getCurrentState() + ", return");
          return;
        }
        if (!TextUtils.isEmpty(VideoView.b(this.this$0)))
        {
          if (!VideoView.c(this.this$0).equals(VideoView.b(this.this$0)))
          {
            VideoView.a(this.this$0, VideoView.b(this.this$0));
            this.this$0.nf(VideoView.b(this.this$0));
          }
          return;
        }
      }
      finally {}
      if (!TextUtils.isEmpty(VideoView.d(this.this$0))) {
        VideoView.f(this.this$0);
      } else {
        QLog.d("gifvideo.VideoView", 1, "both url and vid is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView.7
 * JD-Core Version:    0.7.0.1
 */