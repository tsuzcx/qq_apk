package com.tencent.mobileqq.activity.aio.item;

import acfp;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.MessageForShortVideo;

class ShortVideoItemBuilder$CompressUpdateListenerImpl$1
  implements Runnable
{
  ShortVideoItemBuilder$CompressUpdateListenerImpl$1(ShortVideoItemBuilder.a parama, MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean, ShortVideoItemBuilder.b paramb) {}
  
  public void run()
  {
    String str = this.h.frienduin + this.h.uniseq;
    if (this.bhM)
    {
      this.a.a.setDrawStatus(1);
      this.a.a.setAnimProgress(acfp.m(2131714517), str);
      this.a.a.mProgress = 10;
      this.a.a.setVideoCompressStatus(true);
      return;
    }
    this.a.a.f(str, 1.0F);
    this.a.a.setAnimProgress(10, str);
    this.a.a.setVideoCompressStatus(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.CompressUpdateListenerImpl.1
 * JD-Core Version:    0.7.0.1
 */