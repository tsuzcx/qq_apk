package com.tencent.mobileqq.activity.registerGuideLogin;

import arhz;
import com.tencent.mobileqq.app.BaseActivity;

class TimLoginQQView$12$1
  implements Runnable
{
  TimLoginQQView$12$1(TimLoginQQView.12 param12) {}
  
  public void run()
  {
    if ((this.a.K != null) && (this.a.K.isShowing()) && (!this.a.this$0.m.isFinishing()))
    {
      this.a.K.dismiss();
      this.a.K.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.TimLoginQQView.12.1
 * JD-Core Version:    0.7.0.1
 */