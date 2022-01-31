package com.tencent.token.ui.base;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import com.tencent.token.ui.IndexActivity;

final class s
  implements Runnable
{
  private View b;
  private View c;
  private View d;
  private View e;
  private TranslateAnimation f;
  private TranslateAnimation g;
  private TranslateAnimation h;
  private TranslateAnimation i;
  
  public s(DualMsgView paramDualMsgView, View paramView1, View paramView2, View paramView3, View paramView4)
  {
    this.b = paramView1;
    this.c = paramView2;
    this.d = paramView3;
    this.e = paramView4;
    int j = (int)(IndexActivity.S_DENSITY * 40.0F);
    this.h = new TranslateAnimation(0.0F, 0.0F, DualMsgView.b(paramDualMsgView), 0.0F);
    this.h.setDuration(400L);
    this.h.setInterpolator(new AccelerateDecelerateInterpolator());
    this.i = new TranslateAnimation(0.0F, 0.0F, j + -DualMsgView.c(paramDualMsgView), 0.0F);
    this.i.setDuration(400L);
    this.i.setInterpolator(new AccelerateDecelerateInterpolator());
    this.f = new TranslateAnimation(0.0F, 0.0F, DualMsgView.b(paramDualMsgView), 0.0F);
    this.f.setDuration(500L);
    this.g = new TranslateAnimation(0.0F, 0.0F, -DualMsgView.c(paramDualMsgView), 0.0F);
    this.g.setDuration(500L);
    this.g.setAnimationListener(new t(this, paramDualMsgView));
  }
  
  public final void run()
  {
    DualMsgView.d(this.a).setVisibility(0);
    DualMsgView.e(this.a).setEnabled(true);
    DualMsgView.f(this.a).setEnabled(true);
    this.c.startAnimation(this.f);
    this.b.startAnimation(this.g);
    this.e.startAnimation(this.h);
    this.d.startAnimation(this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.s
 * JD-Core Version:    0.7.0.1
 */