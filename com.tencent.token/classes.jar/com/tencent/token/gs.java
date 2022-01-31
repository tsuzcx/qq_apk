package com.tencent.token;

import java.util.Vector;

final class gs
  extends Thread
{
  int a = -1;
  volatile boolean b = false;
  
  gs(gr paramgr) {}
  
  public final void run()
  {
    for (;;)
    {
      if (gr.a(this.c))
      {
        synchronized (gr.b(this.c))
        {
          label20:
          int i = gr.c(this.c).size();
          if (i != 0) {}
        }
        try
        {
          gr.b(this.c).wait();
          label45:
          if (gr.a(this.c)) {
            break label20;
          }
          return;
          gt localgt = (gt)gr.c(this.c).firstElement();
          if ((gr.d(this.c)) || (localgt.d() == 1))
          {
            gr.c(this.c).removeElement(localgt);
            this.a = localgt.d();
          }
          try
          {
            for (;;)
            {
              Thread.sleep(100L);
              label118:
              this.b = false;
              gr.a(this.c, localgt, this);
              this.a = -1;
              break;
              try
              {
                gr.b(this.c).wait();
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
 * Qualified Name:     com.tencent.token.gs
 * JD-Core Version:    0.7.0.1
 */