package com.tencent.mobileqq.activity.aio.item;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.data.MessageForShortVideo;

class ShortVideoItemBuilder$11
  implements Runnable
{
  ShortVideoItemBuilder$11(ShortVideoItemBuilder paramShortVideoItemBuilder, MessageForShortVideo paramMessageForShortVideo) {}
  
  public void run()
  {
    ShortVideoItemBuilder.b localb = ShortVideoItemBuilder.a(this.this$0, this.b.uniseq);
    if (localb != null)
    {
      localb.progressBar.setVisibility(8);
      localb.JP.setVisibility(8);
      ShortVideoItemBuilder.a(this.this$0, localb, 2131718875);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.11
 * JD-Core Version:    0.7.0.1
 */