package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;

class FastWebActivity$23
  implements Runnable
{
  FastWebActivity$23(FastWebActivity paramFastWebActivity) {}
  
  public void run()
  {
    if (FastWebActivity.d(this.this$0) <= RIJRedPacketManager.a().oV())
    {
      FastWebActivity.e(this.this$0, FastWebActivity.d(this.this$0) + FastWebActivity.aZL);
      FastWebActivity.a(this.this$0).post(new FastWebActivity.23.1(this));
    }
    for (;;)
    {
      FastWebActivity.a(this.this$0).postDelayed(FastWebActivity.a(this.this$0), FastWebActivity.aZL);
      return;
      FastWebActivity.a(this.this$0).stopTiming();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.23
 * JD-Core Version:    0.7.0.1
 */