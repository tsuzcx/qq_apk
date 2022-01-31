package com.tencent.token.ui.base;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class u
  implements Animation.AnimationListener
{
  u(t paramt, DualMsgView paramDualMsgView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.b.a.setVisibility(8);
    if (DualMsgView.a(this.b.a) != null) {
      DualMsgView.a(this.b.a).a();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.u
 * JD-Core Version:    0.7.0.1
 */