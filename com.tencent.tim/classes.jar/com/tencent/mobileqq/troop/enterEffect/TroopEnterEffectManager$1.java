package com.tencent.mobileqq.troop.enterEffect;

import android.os.Handler;
import apdh;
import apdr;
import java.util.concurrent.atomic.AtomicBoolean;

public class TroopEnterEffectManager$1
  implements Runnable
{
  public TroopEnterEffectManager$1(apdr paramapdr, String paramString) {}
  
  public void run()
  {
    this.this$0.b = this.this$0.a();
    if (this.this$0.b.ec.get()) {
      this.this$0.mHandler.post(new TroopEnterEffectManager.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectManager.1
 * JD-Core Version:    0.7.0.1
 */