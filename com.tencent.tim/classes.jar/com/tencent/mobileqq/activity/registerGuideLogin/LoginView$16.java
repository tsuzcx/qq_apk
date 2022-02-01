package com.tencent.mobileqq.activity.registerGuideLogin;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import ayxa;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

class LoginView$16
  implements Runnable
{
  LoginView$16(LoginView paramLoginView) {}
  
  public void run()
  {
    int i = LoginView.j(this.this$0);
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "mSizeChangeOpenUpdateRunnable isArrowUP = " + LoginView.a(this.this$0) + " isScrolled = " + LoginView.b(this.this$0) + " isDestroyed:" + LoginView.c(this.this$0) + " current_H:" + i);
    }
    if ((LoginView.d(this.this$0)) || (LoginView.e(this.this$0)) || (LoginView.f(this.this$0))) {
      LoginView.a(this.this$0).setVisibility(8);
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(7, 2131370175);
    localLayoutParams.addRule(5, 2131370175);
    localLayoutParams.setMargins(0, (int)(13.0F * LoginView.a(this.this$0) + 0.5F), 0, 0);
    localLayoutParams.addRule(3, 2131370877);
    this.this$0.rm.setLayoutParams(localLayoutParams);
    int j = (int)(35.0F * LoginView.a(this.this$0));
    int k = LoginView.a(this.this$0) - j;
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "mSizeChangeOpenUpdateRunnable bottomLine" + LoginView.a(this.this$0) + " mLoginHelpLayout.bottom:" + k + " curH:" + i);
    }
    if (k > i) {
      if (!this.this$0.m.isInMultiWindow())
      {
        j = LoginView.a(this.this$0);
        k = (int)(5.0F * LoginView.a(this.this$0));
        LoginView.b(this.this$0, this.this$0.zF.getScrollY());
        LoginView.c(this.this$0, j - i + k);
        LoginView.d(this.this$0, LoginView.a(this.this$0).topMargin);
        LoginView.e(this.this$0, (int)(24.0F * LoginView.a(this.this$0) + 0.5F));
        LoginView.f(this.this$0, LoginView.b(this.this$0).topMargin);
        LoginView.g(this.this$0, (int)(25.0F * LoginView.a(this.this$0) + 0.5F));
        LoginView.h(this.this$0, LoginView.c(this.this$0).topMargin);
        LoginView.i(this.this$0, (int)(148.0F * LoginView.a(this.this$0) + 0.5F));
        LoginView.d(this.this$0, true);
        LoginView.b(this.this$0);
        if (LoginView.a(this.this$0).isRunning()) {
          LoginView.a(this.this$0).cancel();
        }
        if ((this.this$0.getActivity() == null) || ((!ImmersiveUtils.hasNotchInScreen(this.this$0.getActivity())) && (!ayxa.isInNotchWhiteList()))) {
          break label655;
        }
      }
    }
    label655:
    for (i = 40;; i = 0)
    {
      j = LoginView.d(this.this$0);
      k = LoginView.b(this.this$0);
      if (j < (int)((i + 12) * LoginView.a(this.this$0) + 0.5F) + k) {
        LoginView.e(this.this$0, true);
      }
      for (;;)
      {
        LoginView.f(this.this$0, true);
        this.this$0.a.cvs();
        LoginView.c(this.this$0, true);
        LoginView.a(this.this$0).start();
        return;
        LoginView.e(this.this$0, false);
      }
      this.this$0.zF.scrollTo(0, j);
      LoginView.d(this.this$0, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.16
 * JD-Core Version:    0.7.0.1
 */