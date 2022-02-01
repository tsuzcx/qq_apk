package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import com.tencent.biz.qqstory.base.ErrorMessage;
import qit;
import ram;

class VideoViewVideoHolder$VideoStartSegment$1$1
  implements Runnable
{
  VideoViewVideoHolder$VideoStartSegment$1$1(VideoViewVideoHolder.VideoStartSegment.1 param1) {}
  
  public void run()
  {
    if (this.a.a.isCanceled()) {}
    qit localqit;
    do
    {
      return;
      if ((!this.a.a.this$0.isSelected()) || (this.a.a.this$0.c == null)) {
        break;
      }
      ram.w(this.a.a.this$0.TAG, "VideoStartSegment, wait first not-black frame");
      this.a.a.this$0.au().setVisibility(8);
      this.a.a.this$0.av().setVisibility(8);
      this.a.a.this$0.c.am(true, true);
      VideoViewVideoHolder.a(this.a.a.this$0).b(this.a.a.this$0, this.a.a.this$0.a);
      VideoViewVideoHolder.a(this.a.a.this$0, 12);
      this.a.a.AV = SystemClock.uptimeMillis();
      VideoViewVideoHolder.a(this.a.a.this$0).removeCallbacksAndMessages(null);
      VideoViewVideoHolder.a(this.a.a.this$0).post(this.a.a);
      localqit = (qit)this.a.a.this$0.a(qit.class);
    } while (localqit == null);
    localqit.mItemView.setVisibility(0);
    return;
    ram.e(this.a.a.this$0.TAG, "VideoStartSegment, do not wait first not-black frame");
    VideoViewVideoHolder.VideoStartSegment.a(this.a.a, new ErrorMessage(0, "onPrepared, is not on foreground"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoStartSegment.1.1
 * JD-Core Version:    0.7.0.1
 */