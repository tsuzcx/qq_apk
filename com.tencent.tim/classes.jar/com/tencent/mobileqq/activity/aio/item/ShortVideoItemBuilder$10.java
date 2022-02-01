package com.tencent.mobileqq.activity.aio.item;

import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

class ShortVideoItemBuilder$10
  implements Runnable
{
  ShortVideoItemBuilder$10(ShortVideoItemBuilder paramShortVideoItemBuilder, boolean paramBoolean, ShortVideoItemBuilder.b paramb) {}
  
  public void run()
  {
    if (this.bhL) {
      this.a.JP.setVisibility(8);
    }
    for (;;)
    {
      this.this$0.a(this.a);
      this.a.progressBar.setVisibility(0);
      this.a.bottomBar.setVisibility(8);
      return;
      this.a.JP.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.10
 * JD-Core Version:    0.7.0.1
 */