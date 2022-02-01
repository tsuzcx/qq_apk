package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.common.StatLogger;
import java.util.Map;

final class t
  implements Runnable
{
  t(String paramString, Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo) {}
  
  public void run()
  {
    try
    {
      synchronized ()
      {
        if (StatServiceImpl.g().size() >= StatConfig.getMaxParallelTimmingEvents())
        {
          StatServiceImpl.f().error("The number of page events exceeds the maximum value " + Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
          return;
        }
        StatServiceImpl.b(this.a);
        if (StatServiceImpl.g().containsKey(StatServiceImpl.h()))
        {
          StatServiceImpl.f().e("Duplicate PageID : " + StatServiceImpl.h() + ", onResume() repeated?");
          return;
        }
      }
      StatServiceImpl.g().put(StatServiceImpl.h(), Long.valueOf(System.currentTimeMillis()));
    }
    catch (Throwable localThrowable)
    {
      StatServiceImpl.f().e(localThrowable);
      return;
    }
    StatServiceImpl.a(this.b, true, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.stat.t
 * JD-Core Version:    0.7.0.1
 */