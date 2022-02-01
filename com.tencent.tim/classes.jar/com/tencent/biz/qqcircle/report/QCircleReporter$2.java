package com.tencent.biz.qqcircle.report;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import pcr;
import pcu;
import qqcircle.QQCircleReport.SingleDcData;

public class QCircleReporter$2
  implements Runnable
{
  public QCircleReporter$2(pcu parampcu, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (pcu.a(this.this$0).size() == 0) {
      return;
    }
    QLog.w("QCircleReporter", 2, "reportCacheDataListToServer size:" + pcu.a(this.this$0).size());
    Iterator localIterator = pcu.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((QQCircleReport.SingleDcData)localIterator.next()).byteExtinfo.add(pcr.a("SessionID", this.bz));
    }
    pcu.a(this.this$0, pcu.a(this.this$0));
    pcu.a(this.this$0).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleReporter.2
 * JD-Core Version:    0.7.0.1
 */