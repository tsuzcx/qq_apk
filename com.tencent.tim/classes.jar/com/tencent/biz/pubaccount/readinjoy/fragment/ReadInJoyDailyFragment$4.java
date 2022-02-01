package com.tencent.biz.pubaccount.readinjoy.fragment;

import awit;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import kbp;
import kct;
import kvs;
import kxm.b;
import kxy;

class ReadInJoyDailyFragment$4
  implements Runnable
{
  ReadInJoyDailyFragment$4(ReadInJoyDailyFragment paramReadInJoyDailyFragment, String paramString1, String paramString2) {}
  
  public void run()
  {
    kxm.b localb = new kxm.b();
    localb.b("folder_status", this.YW);
    localb.b("entry_time", "" + ReadInJoyDailyFragment.a().cp() / 1000L);
    localb.b("postset_time", "" + NetConnInfoCenter.getServerTime());
    localb.b("version", kct.XU);
    localb.b("os", "1");
    localb.b("cmd", awit.Hf());
    localb.b("channel_id", kvs.getChannelId());
    kbp.a(null, null, this.aeB, this.aeB, 0, 0, "" + ReadInJoyDailyFragment.a().cq() / 1000L, "", "", localb.build(), false);
    QLog.d("ReadInJoyDailyFragment", 2, "reportDuringTime time is" + ReadInJoyDailyFragment.a().cq() / 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment.4
 * JD-Core Version:    0.7.0.1
 */