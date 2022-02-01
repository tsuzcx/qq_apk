package com.tencent.mobileqq.mini.report;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import java.util.Collection;
import java.util.Iterator;

class MiniProgramReporter$7
  implements Runnable
{
  MiniProgramReporter$7(MiniProgramReporter paramMiniProgramReporter, Collection paramCollection) {}
  
  public void run()
  {
    if (this.val$data != null)
    {
      Iterator localIterator = this.val$data.iterator();
      while (localIterator.hasNext())
      {
        APP_REPORT_TRANSFER.SingleDcData localSingleDcData = (APP_REPORT_TRANSFER.SingleDcData)localIterator.next();
        this.this$0.addData(localSingleDcData);
      }
    }
    MiniProgramReporter.access$400(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramReporter.7
 * JD-Core Version:    0.7.0.1
 */