package com.tencent.mobileqq.startup.step;

import afal;
import afek;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.DTReportComponent;
import com.tencent.qqlive.module.videoreport.dtreport.DTReportComponent.Builder;

public class DtSdkInitStep
  extends AsyncStep
{
  public static void dRJ()
  {
    ThreadManager.executeOnSubThread(new DtSdkInitStep.1());
  }
  
  public int od()
  {
    if ((1 != BaseApplicationImpl.sProcessId) && (7 != BaseApplicationImpl.sProcessId)) {
      return 0;
    }
    long l = System.currentTimeMillis();
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null)
    {
      VideoReport.startWithComponent(localBaseApplicationImpl, DTReportComponent.builder(new afal()).enableDebug(false).dtReport(afek.a()).independentPageOut(true).build());
      VideoReport.setDetectionMode(2);
      QLog.d("DtSdkInitStep", 1, "initDTCost : " + (System.currentTimeMillis() - l) + " ms");
    }
    for (;;)
    {
      dRJ();
      return super.od();
      QLog.i("DtSdkInitStep", 1, "application is null, init DT sdk fail !");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.DtSdkInitStep
 * JD-Core Version:    0.7.0.1
 */