package com.tencent.mobileqq.activity.aio.item;

import java.lang.ref.WeakReference;
import xef;
import xeg;

public class IPCSSODataRequest$1$1
  implements Runnable
{
  public IPCSSODataRequest$1$1(xeg paramxeg, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    xef localxef = (xef)this.a.ei.get();
    if (localxef == null) {
      return;
    }
    localxef.v(this.bTi, this.bTj, this.aUV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.IPCSSODataRequest.1.1
 * JD-Core Version:    0.7.0.1
 */