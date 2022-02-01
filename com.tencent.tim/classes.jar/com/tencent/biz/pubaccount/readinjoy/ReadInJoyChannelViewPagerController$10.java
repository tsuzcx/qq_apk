package com.tencent.biz.pubaccount.readinjoy;

import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager;
import com.tencent.biz.widgets.TabLayout;
import java.util.List;
import kfv;
import kfx;
import lbz;

public class ReadInJoyChannelViewPagerController$10
  implements Runnable
{
  public ReadInJoyChannelViewPagerController$10(kfv paramkfv, int paramInt) {}
  
  public void run()
  {
    kfv.b(this.this$0, true);
    kfv.a(this.this$0).setSwappingAnimation();
    TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)kfv.b(this.this$0).get(this.aIw);
    kfv.b(this.this$0, localTabChannelCoverInfo);
    kfv.a(this.this$0).c(localTabChannelCoverInfo.mChannelCoverId, 4, false, true);
    kfv.a(this.this$0).setCurrentItem(kfv.aIs, false);
    kfv.a(this.this$0).b(this.aIw, kfv.aIs, new kfx(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.10
 * JD-Core Version:    0.7.0.1
 */