package com.tencent.android.tpush.stat;

import android.content.Context;
import com.tencent.android.tpush.stat.b.c;
import com.tencent.android.tpush.stat.event.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class StatServiceImpl$4
  implements Runnable
{
  StatServiceImpl$4(String paramString, Context paramContext, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void run()
  {
    try
    {
      synchronized ()
      {
        Object localObject2 = (Long)StatServiceImpl.g().remove(this.a);
        if (localObject2 != null)
        {
          localObject2 = Long.valueOf((System.currentTimeMillis() - ((Long)localObject2).longValue()) / 1000L);
          ??? = localObject2;
          if (((Long)localObject2).longValue() <= 0L) {
            ??? = Long.valueOf(1L);
          }
          String str = StatServiceImpl.i();
          localObject2 = str;
          if (str != null)
          {
            localObject2 = str;
            if (str.equals(this.a)) {
              localObject2 = "-";
            }
          }
          ??? = new f(this.b, (String)localObject2, this.a, StatServiceImpl.b(this.b, this.c), ((Long)???).longValue(), this.c);
          if (this.d > 0L) {
            ((f)???).a = this.d;
          }
          if (this.e > 0L) {
            ((f)???).a = this.e;
          }
          if (!this.a.equals(StatServiceImpl.h())) {
            StatServiceImpl.d().c("Invalid invocation since previous onResume on diff page.");
          }
          localObject2 = new ArrayList();
          ((List)localObject2).add(???);
          StatServiceImpl.a((List)localObject2);
          StatServiceImpl.c(this.a);
          return;
        }
      }
      StatServiceImpl.d().f("Starttime for PageID:" + this.a + " not found, lost onResume()?");
    }
    catch (Throwable localThrowable)
    {
      StatServiceImpl.d().b(localThrowable);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.StatServiceImpl.4
 * JD-Core Version:    0.7.0.1
 */