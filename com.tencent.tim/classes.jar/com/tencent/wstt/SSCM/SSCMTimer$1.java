package com.tencent.wstt.SSCM;

import auyd;
import auyd.a;
import auye;
import java.util.TimerTask;

public class SSCMTimer$1
  extends TimerTask
{
  public void run()
  {
    long l;
    int i;
    if (auyd.a(this.this$0))
    {
      l = Long.parseLong(auye.Fk());
      if (l == -1L)
      {
        auyd.a(this.this$0, false);
        i = 0;
      }
    }
    for (;;)
    {
      if (i > 0) {
        auyd.a(this.this$0, 0);
      }
      do
      {
        do
        {
          return;
          i = (int)(l - auyd.a(this.this$0));
          auyd.a(this.this$0, l);
          break;
          auyd.a(this.this$0, auyd.a(this.this$0) + auyd.b(this.this$0));
        } while (auyd.a(this.this$0) < 120000);
        auyd.b(this.this$0, 1);
        cancel();
      } while (auyd.a(this.this$0) == null);
      auyd.a(this.this$0).g(auyd.a(this.this$0));
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.wstt.SSCM.SSCMTimer.1
 * JD-Core Version:    0.7.0.1
 */