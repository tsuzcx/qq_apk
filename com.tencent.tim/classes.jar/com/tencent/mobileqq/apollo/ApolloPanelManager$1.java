package com.tencent.mobileqq.apollo;

import abhs;
import abqs;
import abrg;
import abrj;
import abzy;
import java.util.concurrent.atomic.AtomicInteger;

public class ApolloPanelManager$1
  implements Runnable
{
  public ApolloPanelManager$1(abhs paramabhs, abzy paramabzy) {}
  
  public void run()
  {
    this.this$0.p(this.this$0.aR.get(), true, abhs.a(this.this$0));
    if ((this.this$0.aR.get() == 0) && (!abhs.a(this.this$0)) && (this.this$0.getApp() != null))
    {
      abqs localabqs = abrj.a(this.this$0.getApp()).a();
      if (localabqs != null) {
        localabqs.HN(this.this$0.coT);
      }
    }
    if ((abhs.a(this.this$0)) || (this.this$0.aR.get() > 0)) {
      abhs.a(this.this$0, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloPanelManager.1
 * JD-Core Version:    0.7.0.1
 */