package com.tencent.biz.pubaccount.readinjoy;

import android.view.View;
import kfv;

public class ReadInJoyChannelViewPagerController$8
  implements Runnable
{
  public ReadInJoyChannelViewPagerController$8(kfv paramkfv, View paramView1, View paramView2) {}
  
  public void run()
  {
    if (this.this$0.getScrollState() != 0)
    {
      if (this.jy != null) {
        this.jy.findViewById(2131369473).setVisibility(4);
      }
      if (this.jz != null) {
        this.jz.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.8
 * JD-Core Version:    0.7.0.1
 */