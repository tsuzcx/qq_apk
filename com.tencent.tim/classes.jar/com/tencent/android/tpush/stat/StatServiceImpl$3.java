package com.tencent.android.tpush.stat;

import android.content.Context;
import com.tencent.android.tpush.stat.b.c;
import java.util.Map;

final class StatServiceImpl$3
  implements Runnable
{
  StatServiceImpl$3(String paramString, Context paramContext, long paramLong) {}
  
  public void run()
  {
    try
    {
      synchronized ()
      {
        if (StatServiceImpl.g().size() >= d.f())
        {
          StatServiceImpl.d().e("The number of page events exceeds the maximum value " + Integer.toString(d.f()));
          return;
        }
        StatServiceImpl.b(this.a);
        if (StatServiceImpl.g().containsKey(StatServiceImpl.h()))
        {
          StatServiceImpl.d().f("Duplicate PageID : " + StatServiceImpl.h() + ", onResume() repeated?");
          return;
        }
      }
      StatServiceImpl.g().put(StatServiceImpl.h(), Long.valueOf(System.currentTimeMillis()));
    }
    catch (Throwable localThrowable)
    {
      StatServiceImpl.d().b(localThrowable);
      return;
    }
    StatServiceImpl.b(this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.StatServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */