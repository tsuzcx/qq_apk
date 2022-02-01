package com.tencent.mobileqq.ark;

import adrm;
import adrm.a;
import java.lang.ref.WeakReference;

public class ArkTipsManager$4
  implements Runnable
{
  public ArkTipsManager$4(adrm paramadrm, long paramLong) {}
  
  public void run()
  {
    if ((adrm.a(this.this$0) != null) && (this.rJ == adrm.a(this.this$0).msgUniseq))
    {
      adrm.a(this.this$0, this.rJ);
      adrm.a(this.this$0, new WeakReference(adrm.a(this.this$0).b));
      this.this$0.hideTips();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkTipsManager.4
 * JD-Core Version:    0.7.0.1
 */