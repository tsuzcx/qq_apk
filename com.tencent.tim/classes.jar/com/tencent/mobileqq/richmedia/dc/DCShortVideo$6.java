package com.tencent.mobileqq.richmedia.dc;

import alyr;
import alyr.f;
import com.tencent.qphone.base.util.QLog;

public class DCShortVideo$6
  implements Runnable
{
  public DCShortVideo$6(alyr paramalyr, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong) {}
  
  public void run()
  {
    alyr.f localf = new alyr.f();
    localf.supportProgressive = this.cBt;
    localf.dAC = this.dAo;
    localf.dAD = this.dAp;
    localf.dAE = this.dAq;
    localf.durationTime = this.dAr;
    localf.fileSize = this.val$fileSize;
    localf.dAF = this.dAs;
    localf.dAG = this.dAt;
    localf.aif = this.aie;
    DataReport.ReportTask localReportTask = new DataReport.ReportTask("actStreamingVideoPlay", localf.v("actStreamingVideoPlay"));
    DataReport.a().a(localReportTask);
    if (QLog.isColorLevel()) {
      QLog.d("DCShortVideo", 2, "reportProgressivePlayData():" + localf.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.6
 * JD-Core Version:    0.7.0.1
 */