package com.tencent.token.ui.base;

import android.view.View;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;

class bp
  implements Runnable
{
  private View b;
  private View c;
  private View d;
  
  public bp(LockPatternVerifyView paramLockPatternVerifyView, View paramView1, View paramView2, View paramView3)
  {
    this.b = paramView1;
    this.c = paramView2;
    this.d = paramView3;
    LockPatternVerifyView.a(paramLockPatternVerifyView, new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F));
    LockPatternVerifyView.e(paramLockPatternVerifyView).setDuration(250L);
    LockPatternVerifyView.a(paramLockPatternVerifyView, new TranslateAnimation(0.0F, 0.0F, 0.0F, -LockPatternVerifyView.f(paramLockPatternVerifyView)));
    LockPatternVerifyView.g(paramLockPatternVerifyView).setDuration(500L);
    LockPatternVerifyView.b(paramLockPatternVerifyView, new TranslateAnimation(0.0F, 0.0F, 0.0F, LockPatternVerifyView.h(paramLockPatternVerifyView)));
    LockPatternVerifyView.i(paramLockPatternVerifyView).setDuration(500L);
    LockPatternVerifyView.e(paramLockPatternVerifyView).setAnimationListener(new bq(this, paramLockPatternVerifyView));
    LockPatternVerifyView.i(paramLockPatternVerifyView).setAnimationListener(new br(this, paramLockPatternVerifyView));
  }
  
  public void run()
  {
    this.d.startAnimation(LockPatternVerifyView.e(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.bp
 * JD-Core Version:    0.7.0.1
 */