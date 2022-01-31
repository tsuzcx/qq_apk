package com.tencent.token.ui.base;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import com.tencent.token.ui.IndexActivity;

class r
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
  
  public r(DualMsgView paramDualMsgView, View paramView1, View paramView2, View paramView3, View paramView4)
  {
    this.b = paramView1;
    this.c = paramView2;
    this.d = paramView3;
    this.e = paramView4;
    this.h = new TranslateAnimation(0.0F, 0.0F, 0.0F, (int)(IndexActivity.S_DENSITY * 40.0F) + -DualMsgView.c(paramDualMsgView));
    this.h.setDuration(600L);
    this.h.setInterpolator(new v(paramDualMsgView, null));
    this.i = new TranslateAnimation(0.0F, 0.0F, 0.0F, DualMsgView.b(paramDualMsgView));
    this.i.setDuration(600L);
    this.i.setInterpolator(new v(paramDualMsgView, null));
    this.f = new TranslateAnimation(0.0F, 0.0F, 0.0F, -DualMsgView.c(paramDualMsgView));
    this.f.setDuration(600L);
    this.f.setInterpolator(new AccelerateInterpolator());
    this.f.setFillAfter(true);
    this.g = new TranslateAnimation(0.0F, 0.0F, 0.0F, DualMsgView.b(paramDualMsgView));
    this.g.setDuration(600L);
    this.g.setInterpolator(new AccelerateInterpolator());
    this.g.setFillAfter(true);
    this.i.setAnimationListener(new s(this, paramDualMsgView));
  }
  
  public void run()
  {
    DualMsgView.e(this.a).setEnabled(false);
    DualMsgView.f(this.a).setEnabled(false);
    this.b.startAnimation(this.f);
    this.c.startAnimation(this.g);
    this.d.startAnimation(this.h);
    this.e.startAnimation(this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.r
 * JD-Core Version:    0.7.0.1
 */