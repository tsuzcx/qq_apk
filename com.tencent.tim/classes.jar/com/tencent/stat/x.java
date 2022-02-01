package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.common.StatLogger;

final class x
  implements Runnable
{
  x(Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo) {}
  
  public void run()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.stat.x
 * JD-Core Version:    0.7.0.1
 */