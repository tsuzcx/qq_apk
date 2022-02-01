package com.tencent.mobileqq.activity.miniaio;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import wtc;
import znp;
import zof;

public class MiniECommerceExposeDataReportHelper$1
  implements Runnable
{
  public MiniECommerceExposeDataReportHelper$1(znp paramznp) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ECommerceExposeDataReportHelper", 2, "mRunOnShow 800");
    }
    znp.a(this.this$0, true);
    ThreadManager.getUIHandler().removeCallbacks(znp.a(this.this$0));
    znp.a(this.this$0).a(znp.a(this.this$0).mApp, znp.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniECommerceExposeDataReportHelper.1
 * JD-Core Version:    0.7.0.1
 */