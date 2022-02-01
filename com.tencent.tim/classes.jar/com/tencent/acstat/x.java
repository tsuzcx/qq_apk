package com.tencent.acstat;

import android.content.Context;
import com.tencent.acstat.common.StatLogger;

final class x
  implements Runnable
{
  x(Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo) {}
  
  public final void run()
  {
    try
    {
      StatServiceImpl.a(this.a, false, this.b);
      return;
    }
    catch (Throwable localThrowable)
    {
      StatServiceImpl.f().e(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.acstat.x
 * JD-Core Version:    0.7.0.1
 */