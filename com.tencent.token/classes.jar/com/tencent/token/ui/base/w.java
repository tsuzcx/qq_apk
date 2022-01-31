package com.tencent.token.ui.base;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

final class w
  implements Runnable
{
  private View b;
  private Animation c;
  
  public w(DualMsgView paramDualMsgView, View paramView)
  {
    this.b = paramView;
    this.c = AnimationUtils.loadAnimation(DualMsgView.g(paramDualMsgView), 2130968587);
    this.c.setAnimationListener(new x(this, paramDualMsgView));
  }
  
  public final void run()
  {
    this.b.startAnimation(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.w
 * JD-Core Version:    0.7.0.1
 */