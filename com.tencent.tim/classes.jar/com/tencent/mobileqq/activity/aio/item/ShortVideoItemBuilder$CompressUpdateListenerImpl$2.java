package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.MessageForShortVideo;

class ShortVideoItemBuilder$CompressUpdateListenerImpl$2
  implements Runnable
{
  ShortVideoItemBuilder$CompressUpdateListenerImpl$2(ShortVideoItemBuilder.a parama, MessageForShortVideo paramMessageForShortVideo, int paramInt) {}
  
  public void run()
  {
    ShortVideoItemBuilder.b localb = ShortVideoItemBuilder.a(this.b.this$0, this.h);
    String str;
    if (localb != null)
    {
      str = this.h.frienduin + this.h.uniseq;
      if (this.bVv == 1)
      {
        localb.a.f(str, 1.0F);
        localb.a.setAnimProgress(10, str);
        localb.a.setVideoCompressStatus(false);
      }
    }
    else
    {
      return;
    }
    localb.a.setVideoCompressPercent(str, 0.0F);
    localb.a.setVideoCompressStatus(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.CompressUpdateListenerImpl.2
 * JD-Core Version:    0.7.0.1
 */