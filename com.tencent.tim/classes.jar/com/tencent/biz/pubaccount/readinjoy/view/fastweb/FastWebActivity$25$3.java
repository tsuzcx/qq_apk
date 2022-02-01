package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupView;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import nkd;

public class FastWebActivity$25$3
  implements Runnable
{
  public FastWebActivity$25$3(nkd paramnkd, int[] paramArrayOfInt, String paramString) {}
  
  public void run()
  {
    FastWebActivity.a(this.a.this$0).getLocationInWindow(this.dy);
    FastWebActivity.a(this.a.this$0).nO(false);
    FastWebActivity.a(this.a.this$0).nP(false);
    FastWebActivity.a(this.a.this$0).setText(this.Vv);
    FastWebActivity.a(this.a.this$0).setVisibility(4);
    FastWebActivity.a(this.a.this$0).post(new FastWebActivity.25.3.1(this));
    FastWebActivity.d(this.a.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.25.3
 * JD-Core Version:    0.7.0.1
 */