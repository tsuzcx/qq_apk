package com.tencent.token.global;

import com.tencent.token.ah;
import com.tencent.token.utils.s;

final class f
  extends Thread
{
  f(RqdApplication paramRqdApplication) {}
  
  public final void run()
  {
    for (;;)
    {
      try
      {
        if (!ah.a().d()) {
          break label74;
        }
        if (RqdApplication.d < 120)
        {
          RqdApplication.c = 1;
          Thread.sleep(120000L);
          RqdApplication.d = 120;
          continue;
        }
        Thread.sleep(1000L);
      }
      catch (Exception localException)
      {
        e.b(localException.toString());
        localException.printStackTrace();
        return;
      }
      if (s.d())
      {
        RqdApplication.c = 1;
      }
      else
      {
        RqdApplication.c = 0;
        continue;
        label74:
        Thread.sleep(120000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.f
 * JD-Core Version:    0.7.0.1
 */