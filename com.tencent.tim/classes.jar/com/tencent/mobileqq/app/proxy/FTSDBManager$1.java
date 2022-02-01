package com.tencent.mobileqq.app.proxy;

import acxu;
import acyc;
import aqoe;
import com.tencent.mobileqq.app.ThreadRegulator;

public class FTSDBManager$1
  implements Runnable
{
  public FTSDBManager$1(acxu paramacxu) {}
  
  public void run()
  {
    if (this.this$0.hasInit()) {}
    do
    {
      do
      {
        do
        {
          return;
          if (aqoe.cm(acxu.a(this.this$0)))
          {
            acxu.a(this.this$0);
            return;
          }
        } while ((!aqoe.cn(acxu.a(this.this$0))) || (this.this$0.isDestroyed));
        acxu.a(this.this$0);
        ThreadRegulator.a().checkInNextBusiness();
      } while (acxu.a(this.this$0));
      if ((acxu.b(this.this$0) > 10) || (acxu.c(this.this$0) == 1))
      {
        acxu.a(this.this$0);
        return;
      }
    } while (acxu.c(this.this$0) != -1);
    this.this$0.a.postDelayed(this, 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.FTSDBManager.1
 * JD-Core Version:    0.7.0.1
 */