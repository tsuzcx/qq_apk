package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class VideoView$5
  implements Runnable
{
  VideoView$5(VideoView paramVideoView) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        QLog.d("gifvideo.VideoView", 1, "startPlay");
        VideoView.a(this.this$0, System.currentTimeMillis());
        if (this.this$0.getCurrentState() == 6)
        {
          if ((!TextUtils.isEmpty(VideoView.a(this.this$0))) && (VideoView.a(this.this$0).equals(VideoView.b(this.this$0))))
          {
            QLog.d("gifvideo.VideoView", 1, "has opened");
            VideoView.c(this.this$0);
            return;
          }
          QLog.d("gifvideo.VideoView", 1, "not current url");
          continue;
        }
        if (this.this$0.getCurrentState() != 4) {
          break label129;
        }
      }
      finally {}
      QLog.d("gifvideo.VideoView", 1, "has inited, just start");
      VideoView.d(this.this$0);
      continue;
      label129:
      if (this.this$0.getCurrentState() == 9)
      {
        QLog.d("gifvideo.VideoView", 1, "now is stop, so start again");
        VideoView.d(this.this$0);
      }
      else if (this.this$0.getCurrentState() == 8)
      {
        this.this$0.resume();
      }
      else
      {
        QLog.d("gifvideo.VideoView", 1, "current state is " + this.this$0.getCurrentState() + ", do nothing");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView.5
 * JD-Core Version:    0.7.0.1
 */