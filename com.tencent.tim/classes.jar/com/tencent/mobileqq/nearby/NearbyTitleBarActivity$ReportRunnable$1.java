package com.tencent.mobileqq.nearby;

import ajrb;
import ajrk;
import anpc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import zsz;

class NearbyTitleBarActivity$ReportRunnable$1
  implements Runnable
{
  NearbyTitleBarActivity$ReportRunnable$1(NearbyTitleBarActivity.ReportRunnable paramReportRunnable) {}
  
  public void run()
  {
    try
    {
      ajrb.MR(this.this$0.mUin);
      long l1 = this.this$0.adi - this.this$0.ie;
      long l2 = this.this$0.zn - this.this$0.ie;
      long l3 = this.this$0.Oi;
      long l4 = this.this$0.ie;
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_DeviceType", zsz.getDeviceType() + "");
      localHashMap.put("param_PreloadType", this.this$0.mFrom + "");
      if ((l1 > 0L) && (l1 < 60000L) && (l2 > 0L) && (l2 < 60000L))
      {
        if (this.this$0.mState != 0) {
          break label261;
        }
        anpc.a(BaseApplicationImpl.getContext()).collectPerformance(this.this$0.mUin, "actEnterNearbyActCost", false, l2, l1, localHashMap, "");
      }
      while (QLog.isColorLevel())
      {
        ajrk.m("NearbyProcessPerf", new Object[] { Integer.valueOf(this.this$0.mState), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3 - l4), Integer.valueOf(this.this$0.mFrom) });
        return;
        label261:
        if (this.this$0.mState == 1) {
          anpc.a(BaseApplicationImpl.getContext()).collectPerformance(this.this$0.mUin, "actEnterNearbyActCost", true, l2, l1, localHashMap, "");
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyTitleBarActivity.ReportRunnable.1
 * JD-Core Version:    0.7.0.1
 */