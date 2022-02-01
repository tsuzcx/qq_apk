package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import acfp;
import android.view.View;
import aqiw;
import com.tencent.biz.qqstory.base.ErrorMessage;
import ram;

class VideoViewVideoHolder$VideoInfoSegment$2
  implements Runnable
{
  VideoViewVideoHolder$VideoInfoSegment$2(VideoViewVideoHolder.h paramh) {}
  
  public void run()
  {
    if (this.a.isCanceled()) {
      return;
    }
    ram.e(this.a.this$0.TAG, "response FAILED get video info of %s", new Object[] { this.a.vid });
    VideoViewVideoHolder.a(this.a.this$0, acfp.m(2131716483));
    ram.w(this.a.this$0.TAG, "get video info failed, hide loading view");
    VideoViewVideoHolder.c(this.a.this$0, 6);
    VideoViewVideoHolder.a(this.a.this$0, false);
    if (!aqiw.isNetworkAvailable(this.a.this$0.mItemView.getContext())) {
      VideoViewVideoHolder.b(this.a.this$0, 880001);
    }
    VideoViewVideoHolder.h.b(this.a, new ErrorMessage(VideoViewVideoHolder.b(this.a.this$0), "get video info failed"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoInfoSegment.2
 * JD-Core Version:    0.7.0.1
 */