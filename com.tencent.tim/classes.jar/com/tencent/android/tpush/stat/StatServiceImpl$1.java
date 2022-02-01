package com.tencent.android.tpush.stat;

import android.content.Context;
import com.tencent.android.tpush.stat.b.c;

final class StatServiceImpl$1
  implements Runnable
{
  StatServiceImpl$1(Context paramContext) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        b.a(StatServiceImpl.c()).e();
        com.tencent.android.tpush.stat.b.b.a(this.a, true);
        f.b(this.a);
        if (d.a() == StatReportStrategy.APP_LAUNCH) {
          StatServiceImpl.commitEvents(this.a, -1);
        }
        if (d.b()) {
          StatServiceImpl.d().h("Init MTA StatService success.");
        }
        String str3 = com.tencent.android.tpush.stat.b.b.d(StatServiceImpl.c());
        if (str3 != null)
        {
          String str1 = str3;
          if (str3.trim().length() != 0)
          {
            str1 = str1 + ".xg.stat.";
            StatServiceImpl.b(this.a.getSharedPreferences("." + str1, 0));
            StatServiceImpl.c(this.a.getSharedPreferences("." + str1 + ".err.", 0));
            StatServiceImpl.d(this.a.getSharedPreferences("." + str1 + ".custom.", 0));
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        StatServiceImpl.d().f("stat init error:");
        StatServiceImpl.d().b(localThrowable);
        return;
      }
      String str2 = "default";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.StatServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */