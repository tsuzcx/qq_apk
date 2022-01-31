package com.tencent.token.ui.base;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

class n
  implements Runnable
{
  private View b;
  private View c;
  private Animation d;
  private Animation e;
  
  public n(DualMsgView paramDualMsgView, View paramView1, View paramView2)
  {
    this.b = paramView1;
    this.c = paramView2;
    this.d = AnimationUtils.loadAnimation(DualMsgView.g(paramDualMsgView), 2131034133);
    this.e = AnimationUtils.loadAnimation(DualMsgView.g(paramDualMsgView), 2131034136);
    this.e.setAnimationListener(new o(this, paramDualMsgView));
  }
  
  public void run()
  {
    this.c.setVisibility(0);
    this.b.startAnimation(this.e);
    this.c.startAnimation(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.n
 * JD-Core Version:    0.7.0.1
 */