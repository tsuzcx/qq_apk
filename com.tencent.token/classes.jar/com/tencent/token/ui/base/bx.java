package com.tencent.token.ui.base;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.token.ai;
import com.tencent.token.global.RqdApplication;

final class bx
  implements Animation.AnimationListener
{
  bx(bw parambw, LockPatternVerifyView paramLockPatternVerifyView) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    bw.a(this.b).setVisibility(4);
    bw.b(this.b).startAnimation(LockPatternVerifyView.g(this.b.a));
    bw.c(this.b).startAnimation(LockPatternVerifyView.i(this.b.a));
    ai.a(RqdApplication.i()).a();
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.bx
 * JD-Core Version:    0.7.0.1
 */