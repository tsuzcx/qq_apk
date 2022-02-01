package com.tencent.mobileqq.app;

import accb;
import acci;
import android.os.SystemClock;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import mqq.os.MqqHandler;

public class BaseBusinessHandler$1
  implements Runnable
{
  public BaseBusinessHandler$1(accb paramaccb, acci paramacci, int paramInt, MqqHandler paramMqqHandler, boolean paramBoolean, Object paramObject) {}
  
  public void run()
  {
    long l2 = 0L;
    long l1 = l2;
    if (UnifiedMonitor.a().whetherReportDuringThisStartup(1))
    {
      l1 = l2;
      if (this.a == accb.access$000()) {
        l1 = SystemClock.uptimeMillis();
      }
    }
    this.d.onUpdate(this.val$type, this.val$isSuccess, this.val$data);
    if ((UnifiedMonitor.a().whetherReportDuringThisStartup(1)) && (this.a == accb.access$000()))
    {
      l1 = SystemClock.uptimeMillis() - l1;
      if (accb.access$100() == -1) {
        accb.access$102(UnifiedMonitor.a().getThreshold(1));
      }
      if (l1 > accb.access$100())
      {
        if (UnifiedMonitor.a().whetherReportThisTime(1)) {
          UnifiedMonitor.a().addEvent(1, this.d.getClass().getName(), (int)l1, accb.access$200(), null);
        }
        accb.access$202(0);
      }
    }
    else
    {
      return;
    }
    accb.access$208();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseBusinessHandler.1
 * JD-Core Version:    0.7.0.1
 */