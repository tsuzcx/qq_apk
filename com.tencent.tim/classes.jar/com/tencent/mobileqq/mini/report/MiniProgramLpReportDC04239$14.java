package com.tencent.mobileqq.mini.report;

import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.BaseExposureReport;
import java.util.Iterator;
import java.util.List;

final class MiniProgramLpReportDC04239$14
  implements Runnable
{
  MiniProgramLpReportDC04239$14(List paramList) {}
  
  public void run()
  {
    Iterator localIterator = this.val$appConfigList.iterator();
    while (localIterator.hasNext())
    {
      MiniAppExposureManager.BaseExposureReport localBaseExposureReport = (MiniAppExposureManager.BaseExposureReport)localIterator.next();
      if (localBaseExposureReport != null) {
        localBaseExposureReport.handleReport();
      }
    }
    MiniProgramReporter.getInstance().flush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.14
 * JD-Core Version:    0.7.0.1
 */