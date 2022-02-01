package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import aqgz;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupView;
import riw;

class FastWebActivity$2$1
  implements Runnable
{
  FastWebActivity$2$1(FastWebActivity.2 param2, int[] paramArrayOfInt) {}
  
  public void run()
  {
    long l1 = aqgz.getWidth();
    long l2 = FastWebActivity.a(this.a.this$0).getWidth();
    long l3 = riw.dip2px(this.a.this$0, 10.0F);
    int i = this.dy[1];
    int j = riw.dip2px(this.a.this$0, 5.0F);
    FastWebActivity.a(this.a.this$0, FastWebActivity.a(this.a.this$0), (int)(l1 - l2 - l3), i + j, true, true, RIJRedPacketManager.a().jE(), RIJRedPacketManager.a().pa());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.2.1
 * JD-Core Version:    0.7.0.1
 */