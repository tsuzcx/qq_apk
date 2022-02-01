package com.tencent.biz.pubaccount.readinjoy.imageopt;

import lgl;
import noz;

public final class RIJImageOptReport$1
  implements Runnable
{
  public RIJImageOptReport$1(noz paramnoz, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    noz localnoz;
    if (lgl.b(this.b))
    {
      lgl.a(6, this.b);
      localnoz = this.b;
      if (!this.val$isSuccess) {
        break label57;
      }
    }
    label57:
    for (int i = 0;; i = -1)
    {
      localnoz.failCode = i;
      this.b.errMsg = this.val$errMsg;
      lgl.e(this.b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptReport.1
 * JD-Core Version:    0.7.0.1
 */