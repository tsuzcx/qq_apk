package com.tencent.token.ui.base;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class v
  implements Animation.AnimationListener
{
  v(u paramu, DualMsgView paramDualMsgView) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    this.b.a.setVisibility(8);
    if (DualMsgView.a(this.b.a) != null) {
      DualMsgView.a(this.b.a).a();
    }
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.v
 * JD-Core Version:    0.7.0.1
 */