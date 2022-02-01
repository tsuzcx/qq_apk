package com.tencent.android.tpush.stat;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.android.tpush.stat.b.b;
import com.tencent.android.tpush.stat.lifecycle.a;
import java.util.Iterator;
import java.util.List;

final class StatServiceImpl$6
  implements a
{
  StatServiceImpl$6(long paramLong) {}
  
  public void a(Activity paramActivity) {}
  
  public void a(Activity paramActivity, Bundle paramBundle) {}
  
  public void b(Activity paramActivity) {}
  
  public void b(Activity paramActivity, Bundle paramBundle) {}
  
  public void c(Activity paramActivity)
  {
    int i = 0;
    if (!d.c()) {}
    for (;;)
    {
      return;
      StatServiceImpl.inerTrackBeginPage(paramActivity, b.h(paramActivity), this.a);
      StatServiceImpl.a(false);
      if (!StatServiceImpl.j()) {
        i = 1;
      }
      StatServiceImpl.b(true);
      if (StatServiceImpl.k() != null) {
        StatServiceImpl.l().removeCallbacks(StatServiceImpl.k());
      }
      if (i == 0) {
        break;
      }
      StatServiceImpl.d().b("went foreground");
      StatServiceImpl.a(System.currentTimeMillis());
      paramActivity = StatServiceImpl.m().iterator();
      while (paramActivity.hasNext())
      {
        c localc = (c)paramActivity.next();
        try
        {
          localc.a();
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
    }
    StatServiceImpl.d().b("still foreground");
  }
  
  public void d(Activity paramActivity)
  {
    if (!d.c()) {
      return;
    }
    StatServiceImpl.a(paramActivity, b.h(paramActivity), this.a, 0L, 0L);
    StatServiceImpl.a(true);
    if (StatServiceImpl.k() != null) {
      StatServiceImpl.l().removeCallbacks(StatServiceImpl.k());
    }
    StatServiceImpl.l().postDelayed(StatServiceImpl.a(new StatServiceImpl.6.1(this)), StatServiceImpl.o());
  }
  
  public void e(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.StatServiceImpl.6
 * JD-Core Version:    0.7.0.1
 */