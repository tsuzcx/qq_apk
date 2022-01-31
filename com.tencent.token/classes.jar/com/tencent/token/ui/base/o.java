package com.tencent.token.ui.base;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

class o
  implements Animation.AnimationListener
{
  o(n paramn, DualMsgView paramDualMsgView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    DualMsgView.i(this.b.a).setText(DualMsgView.h(this.b.a).getText());
    DualMsgView.k(this.b.a).setText(DualMsgView.j(this.b.a).getText());
    n.a(this.b).setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.o
 * JD-Core Version:    0.7.0.1
 */