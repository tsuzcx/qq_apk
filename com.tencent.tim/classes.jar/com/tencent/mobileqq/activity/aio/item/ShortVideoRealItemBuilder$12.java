package com.tencent.mobileqq.activity.aio.item;

import android.os.Handler;
import com.tencent.mobileqq.data.MessageForShortVideo;

class ShortVideoRealItemBuilder$12
  implements Runnable
{
  ShortVideoRealItemBuilder$12(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder, boolean paramBoolean1, ShortVideoRealItemBuilder.a parama, MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean2) {}
  
  public void run()
  {
    if ((this.bhU) && (this.a != null) && (this.i.progressTask == null))
    {
      this.i.progressTask = new ShortVideoRealItemBuilder.12.1(this);
      ShortVideoRealItemBuilder.a(this.this$0).removeCallbacks(this.i.progressTask);
      ShortVideoRealItemBuilder.a(this.this$0).post(this.i.progressTask);
    }
    if (this.bhV) {
      ShortVideoRealItemBuilder.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.12
 * JD-Core Version:    0.7.0.1
 */