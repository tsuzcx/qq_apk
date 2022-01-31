package com.tencent.token;

import java.util.Vector;

class gh
  extends Thread
{
  int a = -1;
  volatile boolean b = false;
  
  gh(gg paramgg) {}
  
  public void run()
  {
    for (;;)
    {
      if (gg.a(this.c))
      {
        synchronized (gg.b(this.c))
        {
          label20:
          int i = gg.c(this.c).size();
          if (i != 0) {}
        }
        try
        {
          gg.b(this.c).wait();
          label45:
          if (gg.a(this.c)) {
            break label20;
          }
          return;
          gi localgi = (gi)gg.c(this.c).firstElement();
          if ((gg.d(this.c)) || (localgi.d() == 1))
          {
            gg.c(this.c).removeElement(localgi);
            this.a = localgi.d();
          }
          try
          {
            for (;;)
            {
              Thread.sleep(100L);
              label118:
              this.b = false;
              gg.a(this.c, localgi, this, false);
              this.a = -1;
              break;
              try
              {
                gg.b(this.c).wait();
              }
              catch (InterruptedException localInterruptedException2) {}
            }
            break label45;
            localObject = finally;
            throw localObject;
          }
          catch (InterruptedException localInterruptedException1)
          {
            break label118;
          }
        }
        catch (InterruptedException localInterruptedException3)
        {
          break label45;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gh
 * JD-Core Version:    0.7.0.1
 */