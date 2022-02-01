package com.tencent.mobileqq.activity.registerGuideLogin;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import ayxa;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

class TimLoginQQView$15
  implements Runnable
{
  TimLoginQQView$15(TimLoginQQView paramTimLoginQQView) {}
  
  public void run()
  {
    int i = TimLoginQQView.j(this.this$0);
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.TimLoginQQView", 2, "mSizeChangeOpenUpdateRunnable isArrowUP = " + TimLoginQQView.a(this.this$0) + " isScrolled = " + TimLoginQQView.b(this.this$0) + " isDestroyed:" + TimLoginQQView.c(this.this$0) + " current_H:" + i);
    }
    int j = (int)(35.0F * TimLoginQQView.a(this.this$0));
    int k = TimLoginQQView.a(this.this$0) - j;
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.TimLoginQQView", 2, "mSizeChangeOpenUpdateRunnable bottomLine" + TimLoginQQView.a(this.this$0) + " mLoginHelpLayout.bottom:" + k + " curH:" + i);
    }
    if (k > i)
    {
      if (!this.this$0.m.isInMultiWindow())
      {
        j = TimLoginQQView.a(this.this$0);
        k = (int)(5.0F * TimLoginQQView.a(this.this$0));
        TimLoginQQView.b(this.this$0, this.this$0.zF.getScrollY());
        TimLoginQQView.c(this.this$0, j - i - k);
        TimLoginQQView.d(this.this$0, TimLoginQQView.a(this.this$0).topMargin);
        TimLoginQQView.e(this.this$0, (int)(24.0F * TimLoginQQView.a(this.this$0) + 0.5F));
        TimLoginQQView.f(this.this$0, TimLoginQQView.b(this.this$0).topMargin);
        TimLoginQQView.g(this.this$0, (int)(25.0F * TimLoginQQView.a(this.this$0) + 0.5F));
        TimLoginQQView.h(this.this$0, (int)(148.0F * TimLoginQQView.a(this.this$0) + 0.5F));
        TimLoginQQView.d(this.this$0, true);
        TimLoginQQView.b(this.this$0);
        if (TimLoginQQView.a(this.this$0).isRunning()) {
          TimLoginQQView.a(this.this$0).cancel();
        }
        if ((this.this$0.getActivity() != null) && (!ImmersiveUtils.hasNotchInScreen(this.this$0.getActivity())) && (ayxa.isInNotchWhiteList())) {}
        TimLoginQQView.c(this.this$0, true);
        TimLoginQQView.a(this.this$0).start();
      }
      return;
    }
    this.this$0.zF.scrollTo(0, j);
    TimLoginQQView.d(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.TimLoginQQView.15
 * JD-Core Version:    0.7.0.1
 */