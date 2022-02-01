package com.tencent.biz.pubaccount.readinjoy.engine;

import android.util.Pair;
import awit;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kxm;
import lcm;

public class ReadinjoySPEventReport$6
  implements Runnable
{
  public ReadinjoySPEventReport$6(lcm paramlcm, int paramInt, List paramList) {}
  
  public void run()
  {
    for (;;)
    {
      long l2;
      try
      {
        int i = lcm.c(this.this$0).size();
        if (i > awit.f(kxm.getAppRuntime()))
        {
          l1 = i - awit.f(kxm.getAppRuntime());
          l2 = l1 - 1L;
          if (l1 > 0L)
          {
            if (lcm.c(this.this$0).size() <= 1) {
              break label301;
            }
            lcm.c(this.this$0).remove(1);
            l1 = l2;
            continue;
          }
        }
        if (i == 0) {
          lcm.c(this.this$0).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(0)));
        }
        lcm.c(this.this$0).add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000L - ((Long)((Pair)lcm.c(this.this$0).get(0)).first).longValue()), Integer.valueOf(this.val$type)));
        QLog.d(lcm.class.getSimpleName(), 2, "add aio enter or out info, type : " + this.val$type);
        if (this.hn != null) {
          lcm.a(this.this$0, lcm.a(this.this$0, this.hn));
        }
        if ((this.val$type != 0) || (!lcm.b(this.this$0))) {
          break;
        }
        lcm.a(this.this$0, false);
        if (lcm.a(this.this$0) != null)
        {
          lcm.a(this.this$0);
          return;
        }
        lcm.a(this.this$0, 0);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      label301:
      long l1 = l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.6
 * JD-Core Version:    0.7.0.1
 */