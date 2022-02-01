package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.common.StatLogger;

final class v
  implements Runnable
{
  v(Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo) {}
  
  public void run()
  {
    try
    {
      StatServiceImpl.stopSession();
      StatServiceImpl.a(this.a, true, this.b);
      return;
    }
    catch (Throwable localThrowable)
    {
      StatServiceImpl.f().e(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.stat.v
 * JD-Core Version:    0.7.0.1
 */