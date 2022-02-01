package com.tencent.mobileqq.enterpriseqq;

import afrx;
import afrx.a;
import com.tencent.mobileqq.app.soso.SosoInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class EnterpriseQQManager$1
  implements Runnable
{
  public EnterpriseQQManager$1(afrx paramafrx) {}
  
  public void run()
  {
    if ((afrx.a(this.this$0) != null) && (afrx.a(this.this$0) != null))
    {
      SosoInterface.a(this.this$0.c);
      return;
    }
    synchronized (afrx.access$200())
    {
      if ((afrx.a(this.this$0) == null) || (afrx.a(this.this$0).size() <= 0)) {
        break label144;
      }
      Iterator localIterator = afrx.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        afrx.a locala = (afrx.a)localIterator.next();
        if (locala != null) {
          this.this$0.a(afrx.a(this.this$0), afrx.a(this.this$0), locala.VJ, locala.VK, false, 0.0D, 0.0D);
        }
      }
    }
    afrx.a(this.this$0).clear();
    label144:
    afrx.a(this.this$0, null);
    afrx.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager.1
 * JD-Core Version:    0.7.0.1
 */