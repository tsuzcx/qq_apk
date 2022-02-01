package com.tencent.biz.pubaccount.readinjoy;

import awit;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import kfa;
import kfh;
import lbz;

public class DailyDynamicHeaderViewController$5$1
  implements Runnable
{
  public DailyDynamicHeaderViewController$5$1(kfh paramkfh, int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo) {}
  
  public void run()
  {
    if ((this.val$errCode == 0) && (this.b != null) && (this.b.a != null))
    {
      String str1 = this.b.a.cityCode;
      String str2 = this.b.a.city;
      QLog.i("DailyHeaderViewController", 1, "[onLocationFinish] adCode=" + str1 + " cityName=" + str2);
      awit.H("sp_key_daily_dynamic_header_last_refresh_time", Long.valueOf(System.currentTimeMillis()));
      lbz.a().aJA();
      return;
    }
    kfa.a(this.a.this$0, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.DailyDynamicHeaderViewController.5.1
 * JD-Core Version:    0.7.0.1
 */