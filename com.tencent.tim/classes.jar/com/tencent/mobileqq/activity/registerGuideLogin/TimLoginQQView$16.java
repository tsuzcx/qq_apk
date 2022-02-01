package com.tencent.mobileqq.activity.registerGuideLogin;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class TimLoginQQView$16
  implements Runnable
{
  TimLoginQQView$16(TimLoginQQView paramTimLoginQQView) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.TimLoginQQView", 2, "mSizeChangeCloseUpdateRunnable isArrowUP = " + TimLoginQQView.a(this.this$0) + " isScrolled = " + TimLoginQQView.b(this.this$0) + " isDestroyed:" + TimLoginQQView.c(this.this$0) + " isInMultiWindow:" + this.this$0.m.isInMultiWindow());
    }
    if (TimLoginQQView.c(this.this$0)) {}
    while (TimLoginQQView.b(this.this$0) != true) {
      return;
    }
    TimLoginQQView.d(this.this$0, false);
    TimLoginQQView.b(this.this$0, this.this$0.zF.getScrollY());
    TimLoginQQView.c(this.this$0, 0);
    TimLoginQQView.d(this.this$0, TimLoginQQView.a(this.this$0).topMargin);
    TimLoginQQView.e(this.this$0, (int)(57.0F * TimLoginQQView.a(this.this$0) + 0.5F));
    TimLoginQQView.f(this.this$0, TimLoginQQView.b(this.this$0).topMargin);
    TimLoginQQView.g(this.this$0, (int)(32.0F * TimLoginQQView.a(this.this$0) + 0.5F));
    TimLoginQQView.h(this.this$0, (int)(108.0F * TimLoginQQView.a(this.this$0) + 0.5F));
    TimLoginQQView.b(this.this$0);
    if (TimLoginQQView.a(this.this$0).isRunning()) {
      TimLoginQQView.a(this.this$0).cancel();
    }
    TimLoginQQView.a(this.this$0).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.TimLoginQQView.16
 * JD-Core Version:    0.7.0.1
 */