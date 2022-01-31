package com.tencent.token.ui.base;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

final class r
  implements Animation.AnimationListener
{
  r(q paramq, DualMsgView paramDualMsgView) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    DualMsgView.i(this.b.a).setText(DualMsgView.h(this.b.a).getText());
    DualMsgView.k(this.b.a).setText(DualMsgView.j(this.b.a).getText());
    q.a(this.b).setVisibility(4);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.r
 * JD-Core Version:    0.7.0.1
 */