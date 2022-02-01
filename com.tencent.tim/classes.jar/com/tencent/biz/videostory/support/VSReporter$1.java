package com.tencent.biz.videostory.support;

import NS_MINI_REPORT.REPORT.SingleDcData;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniProgramReporter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;
import sqn;

public final class VSReporter$1
  implements Runnable
{
  public VSReporter$1(String paramString, List paramList) {}
  
  public void run()
  {
    REPORT.SingleDcData localSingleDcData = new REPORT.SingleDcData();
    localSingleDcData.dcid.set(5);
    localSingleDcData.type.set(String.valueOf(2));
    localSingleDcData.report_data.add(MiniProgramReportHelper.newEntry("event", this.asx));
    localSingleDcData.report_data.addAll(sqn.newUserInfoEntries());
    if ((this.lx != null) && (!this.lx.isEmpty())) {
      localSingleDcData.report_data.addAll(this.lx);
    }
    MiniProgramReporter.getInstance().add(localSingleDcData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.support.VSReporter.1
 * JD-Core Version:    0.7.0.1
 */