package com.tencent.mobileqq.troop.enterEffect;

import anyk;
import apdj;
import apdj.a;
import apdj.b;
import apdl;
import apdm;
import apdn;
import apdp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;

public class TroopEnterEffectController$3
  implements Runnable
{
  public TroopEnterEffectController$3(apdj paramapdj, apdj.a parama) {}
  
  public void run()
  {
    if (this.this$0.b == null) {
      return;
    }
    apdj.dYM();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    new anyk().a(this.this$0.b.getWidth()).a(apdj.cou + this.a.id).a(new apdp(this)).a(new apdj.b(this.this$0, localQQAppInterface, this.a)).a(new apdn(this, localQQAppInterface)).a(new apdm(this)).a(this.this$0.b, new apdl(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.3
 * JD-Core Version:    0.7.0.1
 */