package com.tencent.mobileqq.doutu;

import afdt;
import afdw;
import java.util.List;

public class DoutuManager$5
  implements Runnable
{
  public DoutuManager$5(afdw paramafdw, boolean paramBoolean1, List paramList, boolean paramBoolean2, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.b != null)
    {
      if ((!this.val$isSuccess) || (this.zu.size() < 0)) {
        break label52;
      }
      this.this$0.b.a(this.zu, this.bXE, this.Xr);
    }
    label52:
    while (!this.bXE) {
      return;
    }
    this.this$0.b.jb(this.Xr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuManager.5
 * JD-Core Version:    0.7.0.1
 */