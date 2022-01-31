package com.tencent.token.ui.base;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

class aw
  implements Runnable
{
  private View b;
  private Animation c;
  
  public aw(GameLoginSndConfirmView paramGameLoginSndConfirmView, View paramView)
  {
    this.b = paramView;
    this.c = AnimationUtils.loadAnimation(GameLoginSndConfirmView.g(paramGameLoginSndConfirmView), 2131034137);
    this.c.setAnimationListener(new ax(this, paramGameLoginSndConfirmView));
  }
  
  public void run()
  {
    this.b.startAnimation(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.aw
 * JD-Core Version:    0.7.0.1
 */