package com.tencent.bugly.crashreport.common.strategy;

import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.Map;

final class a$1
  extends Thread
{
  a$1(a parama) {}
  
  public final void run()
  {
    for (;;)
    {
      try
      {
        Object localObject2 = p.a().a(a.a, null, true);
        if (localObject2 != null)
        {
          localObject1 = (byte[])((Map)localObject2).get("device");
          localObject2 = (byte[])((Map)localObject2).get("gateway");
          if (localObject1 != null) {
            com.tencent.bugly.crashreport.common.info.a.a(a.a(this.a)).f(new String((byte[])localObject1));
          }
          if (localObject2 != null) {
            com.tencent.bugly.crashreport.common.info.a.a(a.a(this.a)).e(new String((byte[])localObject2));
          }
        }
        Object localObject1 = this.a;
        localObject2 = this.a;
        a.a((a)localObject1, a.d());
        if (a.b(this.a) != null)
        {
          if ((z.a(a.e())) || (!z.c(a.e()))) {
            continue;
          }
          a.b(this.a).p = a.e();
          a.b(this.a).q = a.e();
        }
      }
      catch (Throwable localThrowable)
      {
        if (x.a(localThrowable)) {
          continue;
        }
        localThrowable.printStackTrace();
        continue;
      }
      this.a.a(a.b(this.a), false);
      return;
      a.b(this.a).p = StrategyBean.a;
      a.b(this.a).q = StrategyBean.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.common.strategy.a.1
 * JD-Core Version:    0.7.0.1
 */