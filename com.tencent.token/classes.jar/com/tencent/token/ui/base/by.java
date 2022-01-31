package com.tencent.token.ui.base;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class by
  implements Animation.AnimationListener
{
  by(bw parambw, LockPatternVerifyView paramLockPatternVerifyView) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    this.b.a.setVisibility(8);
    if (LockPatternVerifyView.a(this.b.a) != null) {
      LockPatternVerifyView.a(this.b.a).a();
    }
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.by
 * JD-Core Version:    0.7.0.1
 */