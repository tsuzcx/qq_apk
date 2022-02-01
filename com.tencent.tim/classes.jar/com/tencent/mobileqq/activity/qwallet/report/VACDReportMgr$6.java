package com.tencent.mobileqq.activity.qwallet.report;

import VACDReport.ReportHeader;
import aafo;
import aafp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class VACDReportMgr$6
  implements Runnable
{
  public VACDReportMgr$6(aafp paramaafp, List paramList) {}
  
  public void run()
  {
    if ((this.vi == null) || (this.vi.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VACDReport", 2, "handleReponse headers is null or empty");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VACDReport", 2, "handleReponse, headers= " + this.vi);
    }
    synchronized (aafp.access$000())
    {
      ArrayList localArrayList = new ArrayList(8);
      Iterator localIterator = this.vi.iterator();
      while (localIterator.hasNext())
      {
        ReportHeader localReportHeader = (ReportHeader)localIterator.next();
        if (localReportHeader != null)
        {
          if (localReportHeader.result == 0)
          {
            localArrayList.add(Long.valueOf(localReportHeader.seqno));
            aafp.a(this.this$0).remove(Long.valueOf(localReportHeader.seqno));
          }
          aafp.b(this.this$0).remove(Long.valueOf(localReportHeader.seqno));
        }
      }
    }
    if (!localList.isEmpty()) {
      aafp.a(this.this$0).hz(localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.report.VACDReportMgr.6
 * JD-Core Version:    0.7.0.1
 */