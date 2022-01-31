package com.tencent.token.global;

import com.tencent.token.cy;
import com.tencent.token.utils.w;
import com.tencent.token.utils.x;

class i
  extends Thread
{
  i(RqdApplication paramRqdApplication) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if ((!cy.a().d()) && (x.e() == 0L)) {
          break label82;
        }
        if (RqdApplication.d < 60)
        {
          RqdApplication.c = 1;
          Thread.sleep(60000L);
          RqdApplication.d = 60;
          continue;
        }
        Thread.sleep(1000L);
      }
      catch (Exception localException)
      {
        h.b(localException.toString());
        localException.printStackTrace();
        return;
      }
      if (w.d())
      {
        RqdApplication.c = 1;
      }
      else
      {
        RqdApplication.c = 0;
        continue;
        label82:
        Thread.sleep(60000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.i
 * JD-Core Version:    0.7.0.1
 */