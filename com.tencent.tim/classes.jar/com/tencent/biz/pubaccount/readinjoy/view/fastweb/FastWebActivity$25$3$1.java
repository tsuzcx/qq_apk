package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupView;
import nkd;
import riw;

class FastWebActivity$25$3$1
  implements Runnable
{
  FastWebActivity$25$3$1(FastWebActivity.25.3 param3) {}
  
  public void run()
  {
    int i = this.a.dy[0];
    int j = FastWebActivity.a(this.a.a.this$0).getWidth() / 2;
    int k = riw.dip2px(this.a.a.this$0, 13.0F);
    int m = this.a.dy[1];
    int n = riw.dip2px(this.a.a.this$0, 3.0F);
    FastWebActivity.a(this.a.a.this$0, FastWebActivity.a(this.a.a.this$0), i - j + k, m + n, false, false, this.a.Vv, RIJRedPacketManager.a().oW());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.25.3.1
 * JD-Core Version:    0.7.0.1
 */