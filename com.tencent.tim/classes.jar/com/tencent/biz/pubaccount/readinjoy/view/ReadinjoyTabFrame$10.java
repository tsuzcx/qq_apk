package com.tencent.biz.pubaccount.readinjoy.view;

import anpc;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;

class ReadinjoyTabFrame$10
  implements Runnable
{
  ReadinjoyTabFrame$10(ReadinjoyTabFrame paramReadinjoyTabFrame, ReadInJoyBaseFragment paramReadInJoyBaseFragment) {}
  
  public void run()
  {
    if (this.c.getActivity() != null) {
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "FragmentOnStartError", true, NetConnInfoCenter.getServerTimeMillis() - ReadinjoyTabFrame.a(this.this$0), 0L, null, "", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.10
 * JD-Core Version:    0.7.0.1
 */