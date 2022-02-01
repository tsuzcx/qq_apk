package com.tencent.biz.pubaccount.readinjoy.viola.view;

import awit;
import com.tencent.viola.utils.ViolaUtils;
import kxm;

class ViolaBaseView$19
  implements Runnable
{
  ViolaBaseView$19(ViolaBaseView paramViolaBaseView) {}
  
  public void run()
  {
    if (System.currentTimeMillis() - ((Long)awit.f("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547" + kxm.getAccount(), Long.valueOf(0L))).longValue() > 18000000L)
    {
      ViolaBaseView.d(this.this$0, false);
      awit.H("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547" + kxm.getAccount(), Long.valueOf(System.currentTimeMillis()));
    }
    if ((System.currentTimeMillis() - ((Long)awit.f(ViolaUtils.getPageName(this.this$0.anN) + kxm.getAccount(), Long.valueOf(0L))).longValue() > 7200000L) && (!ViolaBaseView.b(this.this$0)))
    {
      ViolaBaseView.e(this.this$0, false);
      awit.H(ViolaUtils.getPageName(this.this$0.anN) + kxm.getAccount(), Long.valueOf(System.currentTimeMillis()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.19
 * JD-Core Version:    0.7.0.1
 */