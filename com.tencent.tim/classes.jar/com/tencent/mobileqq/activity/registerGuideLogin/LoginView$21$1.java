package com.tencent.mobileqq.activity.registerGuideLogin;

import com.tencent.mobileqq.widget.NewStyleDropdownView;

class LoginView$21$1
  implements Runnable
{
  LoginView$21$1(LoginView.21 param21, Object paramObject) {}
  
  public void run()
  {
    if (this.cf != null)
    {
      this.a.this$0.a.bE(true, this.cf);
      return;
    }
    if (LoginView.f(this.a.this$0))
    {
      this.a.this$0.a.bE(true, null);
      return;
    }
    this.a.this$0.a.bE(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.21.1
 * JD-Core Version:    0.7.0.1
 */