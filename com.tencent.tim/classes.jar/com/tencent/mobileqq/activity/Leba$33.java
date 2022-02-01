package com.tencent.mobileqq.activity;

import acgu;
import aevs;
import android.widget.TextView;
import aneo;
import anpc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.a;
import cooperation.qzone.report.lp.LinkReport;
import java.util.HashMap;
import vqn;

class Leba$33
  implements Runnable
{
  Leba$33(Leba paramLeba, aevs paramaevs) {}
  
  public void run()
  {
    boolean bool = true;
    if ((Leba.a(this.this$0) != null) && (Leba.a(this.this$0).getVisibility() == 0)) {}
    try
    {
      this.this$0.a(null, true, this.c);
      ThreadRegulator.a().JW(4);
      ThreadRegulator.a().ab(4, 2000L);
      Leba.d(this.this$0, true);
      aneo localaneo = (aneo)this.this$0.app.getManager(10);
      if (localaneo != null)
      {
        if ((localaneo.jn(1) <= 0) && (localaneo.jn(2) <= 0))
        {
          Object localObject = new QZoneClickReport.a();
          ((QZoneClickReport.a)localObject).actionType = "1";
          ((QZoneClickReport.a)localObject).cMI = "0";
          ((QZoneClickReport.a)localObject).tabletype = 4;
          ((QZoneClickReport.a)localObject).sourceType = "3";
          ((QZoneClickReport.a)localObject).sourceFrom = "mainEntrance";
          ((QZoneClickReport.a)localObject).sourceTo = "activefeed";
          QZoneClickReport.report(this.this$0.app.getAccount(), (QZoneClickReport.a)localObject, false);
          localObject = new HashMap();
          ((HashMap)localObject).put("source_type", "3");
          ((HashMap)localObject).put("source_from", "mainEntrance");
          ((HashMap)localObject).put("source_to", "activefeed");
          anpc.a(BaseApplicationImpl.getContext()).collectPerformance(this.this$0.app.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject, null);
        }
        if ((this.this$0.app.a() == null) || (!this.this$0.app.a().aav())) {
          break label321;
        }
        vqn.a(localaneo, false, bool);
        if ((Leba.b(this.this$0) != null) && (Leba.b(this.this$0).getVisibility() == 0))
        {
          localaneo.UJ(3);
          localaneo.UJ(61);
          localaneo.UJ(6);
        }
      }
      LinkReport.reportClickQZoneEntry(this.this$0.app.getCurrentUin());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.i("Leba", 1, "clickAction", localException);
        continue;
        label321:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.33
 * JD-Core Version:    0.7.0.1
 */