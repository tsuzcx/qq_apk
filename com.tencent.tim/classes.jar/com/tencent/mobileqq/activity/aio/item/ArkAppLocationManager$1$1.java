package com.tencent.mobileqq.activity.aio.item;

import adno;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import wzl;
import wzl.a;
import wzl.b;
import wzm;

public class ArkAppLocationManager$1$1
  implements Runnable
{
  public ArkAppLocationManager$1$1(wzm paramwzm, boolean paramBoolean, SosoInterface.SosoLbsInfo paramSosoLbsInfo) {}
  
  public void run()
  {
    double d2 = 0.0D;
    double d1;
    if ((this.di) && (this.e != null)) {
      if ((Math.abs(this.e.a.cf) > 1.0E-006D) && (Math.abs(this.e.a.cg) > 1.0E-006D))
      {
        d1 = this.e.a.cf;
        d2 = this.e.a.cg;
      }
    }
    for (;;)
    {
      synchronized (wzl.a(this.a.a))
      {
        Object localObject2 = new ArrayList(wzl.a(this.a.a));
        if (((ArrayList)localObject2).size() == 0) {
          SosoInterface.c(wzl.a(this.a.a));
        }
        ??? = ((ArrayList)localObject2).iterator();
        if (((Iterator)???).hasNext())
        {
          localObject2 = (wzl.b)((Iterator)???).next();
          ((wzl.b)localObject2).a(this.di, d1, d2);
          if (this.di) {
            continue;
          }
          ((wzl.b)localObject2).cdA();
          continue;
          if ((Math.abs(this.e.a.cd) <= 1.0E-006D) || (Math.abs(this.e.a.ce) <= 1.0E-006D)) {
            break label567;
          }
          ??? = adno.b(this.e.a.ce, this.e.a.cd);
          d2 = ???[0];
          d1 = ???[1];
          this.e.a.cf = d1;
          this.e.a.cg = d2;
        }
      }
      if (!this.di) {
        synchronized (wzl.a(this.a.a))
        {
          wzl.a(this.a.a).clear();
        }
      }
      synchronized (wzl.b(this.a.a))
      {
        Object localObject4 = new ArrayList(wzl.b(this.a.a));
        wzl.b(this.a.a).removeAll((Collection)localObject4);
        ??? = ((ArrayList)localObject4).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject4 = (wzl.b)((Iterator)???).next();
          ((wzl.b)localObject4).a(this.di, d1, d2);
          ((wzl.b)localObject4).cdA();
          continue;
          localObject5 = finally;
          throw localObject5;
        }
      }
      synchronized (wzl.c(this.a.a))
      {
        ArrayList localArrayList = new ArrayList(wzl.c(this.a.a));
        wzl.c(this.a.a).removeAll(localArrayList);
        ??? = localArrayList.iterator();
        if (((Iterator)???).hasNext()) {
          ((wzl.a)((Iterator)???).next()).a(this.di, this.e);
        }
      }
      return;
      label567:
      d1 = 0.0D;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppLocationManager.1.1
 * JD-Core Version:    0.7.0.1
 */