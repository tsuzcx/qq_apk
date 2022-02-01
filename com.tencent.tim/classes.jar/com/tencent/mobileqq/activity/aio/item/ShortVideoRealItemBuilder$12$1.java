package com.tencent.mobileqq.activity.aio.item;

import android.widget.TextView;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.MessageProgressView;

class ShortVideoRealItemBuilder$12$1
  implements Runnable
{
  ShortVideoRealItemBuilder$12$1(ShortVideoRealItemBuilder.12 param12) {}
  
  public void run()
  {
    if (this.a.i.progress <= 0) {
      this.a.i.progress = this.a.i.videoFileProgress;
    }
    if ((ShortVideoUtils.aL(this.a.i.videoFileProgress, 10) > 60) || (this.a.i.progress > 60))
    {
      this.a.a.a.setDrawStatus(1);
      this.a.a.a.setAnimProgress(60, this.a.i.frienduin + this.a.i.uniseq);
      this.a.a.a.setVisibility(0);
      this.a.a.mTextView.setVisibility(8);
    }
    this.a.this$0.a(this.a.i, this.a.a, this.a.i.videoFileProgress, this.a.i.progress);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.12.1
 * JD-Core Version:    0.7.0.1
 */