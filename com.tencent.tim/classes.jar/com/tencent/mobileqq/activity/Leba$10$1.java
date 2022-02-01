package com.tencent.mobileqq.activity;

import aevs;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import zjo;

class Leba$10$1
  implements Runnable
{
  Leba$10$1(Leba.10 param10, List paramList) {}
  
  public void run()
  {
    if (Leba.a(this.a.this$0) == null) {
      Leba.a(this.a.this$0, new ArrayList());
    }
    Iterator localIterator1 = Leba.a(this.a.this$0).iterator();
    while (localIterator1.hasNext())
    {
      aevs localaevs1 = (aevs)localIterator1.next();
      if ((localaevs1 != null) && (localaevs1.bCp != null) && (localaevs1.a != null))
      {
        Iterator localIterator2 = this.qQ.iterator();
        while (localIterator2.hasNext())
        {
          aevs localaevs2 = (aevs)localIterator2.next();
          if ((localaevs2 != null) && (localaevs2.a != null) && (localaevs2.a.strPkgName.equals(localaevs1.a.strPkgName))) {
            localaevs2.bCp = localaevs1.bCp;
          }
        }
      }
    }
    Leba.a(this.a.this$0).clear();
    Leba.a(this.a.this$0).addAll(this.qQ);
    QLog.i("Q.lebatab.leba", 1, "refreshLebaConfig. lebaData size=" + Leba.a(this.a.this$0).size());
    if (Leba.a(this.a.this$0) != null)
    {
      Leba.a(this.a.this$0).BI(true);
      Leba.a(this.a.this$0).notifyDataSetChanged();
      if (QLog.isColorLevel()) {
        QLog.i("Q.lebatab.leba", 2, "refreshLebaConfig. notifyData.");
      }
      Leba.c(this.a.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.10.1
 * JD-Core Version:    0.7.0.1
 */