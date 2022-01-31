package com.tencent.token.ui.base;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.token.cz;
import com.tencent.token.global.RqdApplication;

class bq
  implements Animation.AnimationListener
{
  bq(bp parambp, LockPatternVerifyView paramLockPatternVerifyView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    bp.a(this.b).setVisibility(4);
    bp.b(this.b).startAnimation(LockPatternVerifyView.g(this.b.a));
    bp.c(this.b).startAnimation(LockPatternVerifyView.i(this.b.a));
    cz.a(RqdApplication.l()).a();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.bq
 * JD-Core Version:    0.7.0.1
 */