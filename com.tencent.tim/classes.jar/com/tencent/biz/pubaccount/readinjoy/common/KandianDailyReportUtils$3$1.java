package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kvs;
import lbz;

class KandianDailyReportUtils$3$1
  implements Runnable
{
  KandianDailyReportUtils$3$1(KandianDailyReportUtils.3 param3) {}
  
  public void run()
  {
    kvs.access$102(false);
    if (kvs.access$000().isEmpty()) {
      return;
    }
    lbz.a().cb(kvs.access$000());
    QLog.d("KandianDailyReportUtils", 1, "execute feeds 64e export, size : " + kvs.access$000().size());
    kvs.access$000().clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.KandianDailyReportUtils.3.1
 * JD-Core Version:    0.7.0.1
 */