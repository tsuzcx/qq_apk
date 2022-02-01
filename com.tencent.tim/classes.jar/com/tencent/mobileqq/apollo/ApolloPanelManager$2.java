package com.tencent.mobileqq.apollo;

import abhs;
import abqs;
import abrg;
import abrj;
import java.util.concurrent.atomic.AtomicInteger;

public class ApolloPanelManager$2
  implements Runnable
{
  public ApolloPanelManager$2(abhs paramabhs) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    int i = this.this$0.aR.get();
    if (this.this$0.a != null) {}
    for (boolean bool = true;; bool = false)
    {
      ((abhs)localObject).p(i, bool, abhs.a(this.this$0));
      if ((this.this$0.aR.get() == 0) && (!abhs.a(this.this$0)) && (this.this$0.getApp() != null) && (this.this$0.a != null))
      {
        localObject = abrj.a(this.this$0.getApp()).a();
        if (localObject != null) {
          ((abqs)localObject).HN(this.this$0.coT);
        }
      }
      if (((abhs.a(this.this$0)) || (this.this$0.aR.get() > 0)) && (this.this$0.a != null)) {
        abhs.a(this.this$0, this.this$0.a);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloPanelManager.2
 * JD-Core Version:    0.7.0.1
 */