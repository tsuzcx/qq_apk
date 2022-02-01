package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.event.b;
import com.tencent.stat.event.c;

final class aa
  implements Runnable
{
  aa(Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo, c paramc) {}
  
  public void run()
  {
    try
    {
      b localb = new b(this.a, StatServiceImpl.a(this.a, false, this.b), this.c.a, this.b);
      localb.b().b = this.c.b;
      new ab(localb).a();
      return;
    }
    catch (Throwable localThrowable)
    {
      StatServiceImpl.f().e(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.stat.aa
 * JD-Core Version:    0.7.0.1
 */