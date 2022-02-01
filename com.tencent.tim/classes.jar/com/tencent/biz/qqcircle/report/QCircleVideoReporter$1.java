package com.tencent.biz.qqcircle.report;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import pcu;
import pcy;
import qqcircle.QQCircleReport.SingleDcData;

public final class QCircleVideoReporter$1
  implements Runnable
{
  public QCircleVideoReporter$1(Object paramObject, String paramString, List paramList) {}
  
  public void run()
  {
    QQCircleReport.SingleDcData localSingleDcData = new QQCircleReport.SingleDcData();
    localSingleDcData.dcid.set(5530);
    if (this.bf == null)
    {
      QLog.w("QCircleVideoReporter", 1, "feed is null");
      return;
    }
    localSingleDcData.report_data.addAll(pcy.c(this.asx, this.bf));
    if ((this.lx != null) && (!this.lx.isEmpty())) {
      localSingleDcData.report_data.addAll(this.lx);
    }
    pcu.a().a(localSingleDcData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleVideoReporter.1
 * JD-Core Version:    0.7.0.1
 */