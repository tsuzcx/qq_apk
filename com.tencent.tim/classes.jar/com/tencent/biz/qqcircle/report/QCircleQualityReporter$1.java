package com.tencent.biz.qqcircle.report;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;
import pcq;
import pcu;
import qqcircle.QQCircleReport.SingleDcData;

public final class QCircleQualityReporter$1
  implements Runnable
{
  public QCircleQualityReporter$1(String paramString, List paramList) {}
  
  public void run()
  {
    QQCircleReport.SingleDcData localSingleDcData = new QQCircleReport.SingleDcData();
    localSingleDcData.dcid.set(5531);
    localSingleDcData.report_data.addAll(pcq.I(this.asx));
    if ((this.lx != null) && (!this.lx.isEmpty())) {
      localSingleDcData.report_data.addAll(this.lx);
    }
    pcu.a().a(localSingleDcData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleQualityReporter.1
 * JD-Core Version:    0.7.0.1
 */