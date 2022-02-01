package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.data.MessageForShortVideo;
import java.lang.ref.WeakReference;

class ShortVideoRealItemBuilder$1
  implements Runnable
{
  ShortVideoRealItemBuilder$1(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder, MessageForShortVideo paramMessageForShortVideo, WeakReference paramWeakReference) {}
  
  public void run()
  {
    if (this.i.progress <= 0) {
      this.i.progress = this.i.videoFileProgress;
    }
    if ((this.eo != null) && (this.eo.get() != null)) {
      this.this$0.a(this.i, (ShortVideoRealItemBuilder.a)this.eo.get(), this.i.videoFileProgress, this.i.progress);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */