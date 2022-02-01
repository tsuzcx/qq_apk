package com.tencent.mobileqq.troop.enterEffect;

import apdj;
import apdj.a;
import apdq;
import com.tencent.qphone.base.util.QLog;

public class TroopEnterEffectController$4$1
  implements Runnable
{
  public TroopEnterEffectController$4$1(apdq paramapdq, int paramInt, apdj.a parama) {}
  
  public void run()
  {
    QLog.d("TroopEnterEffect.Controller", 2, "download Res isAIO = " + this.a.this$0.cQa);
    if (this.a.this$0.cQa)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect.Controller", 2, "download Res callback success id = " + this.val$id + " showAnimation");
      }
      this.a.this$0.c(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.4.1
 * JD-Core Version:    0.7.0.1
 */