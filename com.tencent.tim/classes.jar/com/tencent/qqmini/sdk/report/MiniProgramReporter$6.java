package com.tencent.qqmini.sdk.report;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import java.util.Collection;
import java.util.Iterator;

class MiniProgramReporter$6
  implements Runnable
{
  MiniProgramReporter$6(MiniProgramReporter paramMiniProgramReporter, Collection paramCollection) {}
  
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
    MiniProgramReporter.access$300(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramReporter.6
 * JD-Core Version:    0.7.0.1
 */