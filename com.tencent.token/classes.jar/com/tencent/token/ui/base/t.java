package com.tencent.token.ui.base;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

class t
  implements Runnable
{
  private View b;
  private Animation c;
  
  public t(DualMsgView paramDualMsgView, View paramView)
  {
    this.b = paramView;
    this.c = AnimationUtils.loadAnimation(DualMsgView.g(paramDualMsgView), 2131034137);
    this.c.setAnimationListener(new u(this, paramDualMsgView));
  }
  
  public void run()
  {
    this.b.startAnimation(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.t
 * JD-Core Version:    0.7.0.1
 */