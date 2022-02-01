package com.tencent.biz.pubaccount.readinjoy.engine;

import android.util.Pair;
import awit;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kxm;
import lcm;

public class ReadinjoySPEventReport$5
  implements Runnable
{
  public ReadinjoySPEventReport$5(lcm paramlcm, int paramInt) {}
  
  public void run()
  {
    int i;
    if (lcm.a(this.this$0) != null)
    {
      if (((Integer)lcm.a(this.this$0).second).intValue() == this.aNv) {
        return;
      }
      if (((Integer)lcm.a(this.this$0).second).intValue() < this.aNv) {
        i = 1;
      }
    }
    for (;;)
    {
      label59:
      int j = lcm.a(this.this$0).size();
      long l1;
      if (j > awit.d(kxm.getAppRuntime())) {
        l1 = j - awit.d(kxm.getAppRuntime());
      }
      for (;;)
      {
        long l2 = l1 - 1L;
        if (l1 > 0L)
        {
          if (lcm.a(this.this$0).size() <= 1) {
            break label824;
          }
          lcm.a(this.this$0).remove(1);
          l1 = l2;
          continue;
          i = 0;
          break label59;
        }
        lcm.a(this.this$0, false);
        if (j == 0) {
          lcm.a(this.this$0).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(0)));
        }
        lcm.a(this.this$0, new Pair(Long.valueOf(System.currentTimeMillis() / 1000L - ((Long)((Pair)lcm.a(this.this$0).get(0)).first).longValue()), Integer.valueOf(this.aNv)));
        lcm.a(this.this$0).add(lcm.a(this.this$0));
        QLog.d(lcm.class.getSimpleName(), 2, "update msg tab total red pnt change, cnt : " + this.aNv);
        j = kxm.nP();
        if (j < 0) {
          break;
        }
        if (j > this.aNv) {
          j = this.aNv;
        }
        for (;;)
        {
          int k = lcm.b(this.this$0).size();
          if (k > awit.e(kxm.getAppRuntime())) {
            l1 = k - awit.e(kxm.getAppRuntime());
          }
          for (;;)
          {
            l2 = l1 - 1L;
            if (l1 > 0L)
            {
              if (lcm.b(this.this$0).size() > 1)
              {
                lcm.b(this.this$0).remove(1);
                l1 = l2;
              }
            }
            else
            {
              if ((lcm.b(this.this$0) != null) && (((Integer)lcm.b(this.this$0).second).intValue() == j)) {
                break;
              }
              if (k == 0) {
                lcm.b(this.this$0).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(0)));
              }
              lcm.b(this.this$0, new Pair(Long.valueOf(System.currentTimeMillis() / 1000L - ((Long)((Pair)lcm.b(this.this$0).get(0)).first).longValue()), Integer.valueOf(j)));
              lcm.b(this.this$0).add(lcm.b(this.this$0));
              QLog.d(lcm.class.getSimpleName(), 2, "update msg tab first screen red pnt change, cnt : " + j);
              j = awit.Qf();
              if ((this.aNv <= j) && (!lcm.a(this.this$0)) && (i == 0))
              {
                if ((lcm.c(this.this$0) != null) && (lcm.c(this.this$0).size() > 0))
                {
                  i = ((Integer)((Pair)lcm.c(this.this$0).get(lcm.c(this.this$0).size() - 1)).second).intValue();
                  l1 = ((Long)((Pair)lcm.c(this.this$0).get(0)).first).longValue();
                  l2 = ((Long)((Pair)lcm.c(this.this$0).get(lcm.c(this.this$0).size() - 1)).first).longValue();
                  if ((System.currentTimeMillis() / 1000L - (l1 + l2) <= 600L) && (i == 1))
                  {
                    lcm.a(this.this$0, true);
                    return;
                  }
                }
                if (lcm.a(this.this$0) != null) {
                  break label804;
                }
                lcm.a(this.this$0, 0);
              }
              for (;;)
              {
                lcm.b(this.this$0, false);
                return;
                label804:
                lcm.a(this.this$0);
              }
            }
            l1 = l2;
          }
        }
        label824:
        l1 = l2;
      }
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.5
 * JD-Core Version:    0.7.0.1
 */