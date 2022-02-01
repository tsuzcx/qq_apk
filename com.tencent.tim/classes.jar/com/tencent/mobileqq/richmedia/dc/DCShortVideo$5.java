package com.tencent.mobileqq.richmedia.dc;

import alyr;
import alyr.g;
import com.tencent.qphone.base.util.QLog;

public class DCShortVideo$5
  implements Runnable
{
  public DCShortVideo$5(alyr paramalyr, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    alyr.g localg = new alyr.g();
    localg.dAH = this.dAn;
    localg.cBu = this.cBs;
    DataReport.ReportTask localReportTask = new DataReport.ReportTask("RealShortVideo.Record", localg.v("RealShortVideo.Record"));
    DataReport.a().a(localReportTask);
    if (QLog.isDevelopLevel()) {
      QLog.d("DCShortVideo", 4, "cameraID=" + localg.dAH + ",hasMultiSegments=" + localg.cBu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.5
 * JD-Core Version:    0.7.0.1
 */