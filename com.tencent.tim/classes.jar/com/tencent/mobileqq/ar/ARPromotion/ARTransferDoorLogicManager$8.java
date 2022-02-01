package com.tencent.mobileqq.ar.ARPromotion;

import acfp;
import adbn;
import com.tencent.mobileqq.ar.view.ARScanEntryView;

public class ARTransferDoorLogicManager$8
  implements Runnable
{
  public ARTransferDoorLogicManager$8(adbn paramadbn) {}
  
  public void run()
  {
    if (this.this$0.b == null) {
      return;
    }
    if (this.this$0.cBM == 2)
    {
      this.this$0.b.Gv(false);
      this.this$0.b.Ll(1);
      return;
    }
    this.this$0.ay(true, acfp.m(2131702888));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.8
 * JD-Core Version:    0.7.0.1
 */