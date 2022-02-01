package com.tencent.util;

import anpc;
import aurh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ProfilePerformanceReport$1
  implements Runnable
{
  public ProfilePerformanceReport$1(aurh paramaurh, String paramString, long paramLong, HashMap paramHashMap) {}
  
  public void run()
  {
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance(this.val$uin, aurh.a(this.this$0), true, this.val$duration, 0L, this.nu, "");
    if (QLog.isDevelopLevel()) {
      QLog.i("ProfilePerformanceReport", 4, "end of report");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.util.ProfilePerformanceReport.1
 * JD-Core Version:    0.7.0.1
 */