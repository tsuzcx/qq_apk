package com.tencent.mobileqq.ar.ARPromotion;

import adbn;
import adii;
import adii.b;

public class ARTransferDoorLogicManager$2
  implements Runnable
{
  public ARTransferDoorLogicManager$2(adbn paramadbn) {}
  
  public void run()
  {
    if (adbn.a(this.this$0).a.state == 0) {
      this.this$0.Kx(5);
    }
    for (;;)
    {
      adbn.a(this.this$0, 0L);
      return;
      if (adbn.a(this.this$0).a.cGv == 0) {
        this.this$0.cPN();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.2
 * JD-Core Version:    0.7.0.1
 */