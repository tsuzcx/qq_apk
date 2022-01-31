package com.tencent.token.ui.base;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class bn
  implements Animation.AnimationListener
{
  bn(LockPatternVerifyView paramLockPatternVerifyView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setVisibility(8);
    if (LockPatternVerifyView.a(this.a) != null) {
      LockPatternVerifyView.a(this.a).a();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.bn
 * JD-Core Version:    0.7.0.1
 */