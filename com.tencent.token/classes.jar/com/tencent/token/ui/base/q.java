package com.tencent.token.ui.base;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

final class q
  implements Runnable
{
  private View b;
  private View c;
  private Animation d;
  private Animation e;
  
  public q(DualMsgView paramDualMsgView, View paramView1, View paramView2)
  {
    this.b = paramView1;
    this.c = paramView2;
    this.d = AnimationUtils.loadAnimation(DualMsgView.g(paramDualMsgView), 2130968583);
    this.e = AnimationUtils.loadAnimation(DualMsgView.g(paramDualMsgView), 2130968586);
    this.e.setAnimationListener(new r(this, paramDualMsgView));
  }
  
  public final void run()
  {
    this.c.setVisibility(0);
    this.b.startAnimation(this.e);
    this.c.startAnimation(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.q
 * JD-Core Version:    0.7.0.1
 */