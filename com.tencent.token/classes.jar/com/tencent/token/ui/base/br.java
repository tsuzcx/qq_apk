package com.tencent.token.ui.base;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class br
  implements Animation.AnimationListener
{
  br(bp parambp, LockPatternVerifyView paramLockPatternVerifyView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.b.a.setVisibility(8);
    if (LockPatternVerifyView.a(this.b.a) != null) {
      LockPatternVerifyView.a(this.b.a).a();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.br
 * JD-Core Version:    0.7.0.1
 */