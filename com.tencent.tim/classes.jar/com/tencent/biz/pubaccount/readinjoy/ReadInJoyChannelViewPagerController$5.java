package com.tencent.biz.pubaccount.readinjoy;

import android.view.View;
import android.view.ViewGroup;
import kfv;

public class ReadInJoyChannelViewPagerController$5
  implements Runnable
{
  public ReadInJoyChannelViewPagerController$5(kfv paramkfv, float paramFloat, int paramInt, ViewGroup paramViewGroup, View paramView) {}
  
  public void run()
  {
    if (this.iA >= kfv.a(this.this$0))
    {
      kfv.a(this.this$0, this.aIx);
      kfv.a(this.this$0, this.aN, this.jy);
      return;
    }
    kfv.a(this.this$0, this.aIx - 1);
    kfv.a(this.this$0, this.jy, this.aN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.5
 * JD-Core Version:    0.7.0.1
 */