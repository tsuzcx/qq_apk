package com.tencent.mobileqq.activity;

import arhz;

class LoginVerifyCodeActivity2$4
  implements Runnable
{
  public void run()
  {
    try
    {
      if ((LoginVerifyCodeActivity2.a(this.this$0) == null) && (!this.this$0.isFinishing()))
      {
        LoginVerifyCodeActivity2.a(this.this$0, new arhz(this.this$0.getActivity(), this.this$0.getTitleBarHeight()));
        LoginVerifyCodeActivity2.a(this.this$0).setMessage(2131696693);
      }
      if ((LoginVerifyCodeActivity2.a(this.this$0) != null) && (!LoginVerifyCodeActivity2.a(this.this$0).isShowing())) {
        LoginVerifyCodeActivity2.a(this.this$0).show();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginVerifyCodeActivity2.4
 * JD-Core Version:    0.7.0.1
 */