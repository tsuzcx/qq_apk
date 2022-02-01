package com.tencent.mobileqq.activity;

import arhz;

class LoginInfoActivity$8
  implements Runnable
{
  LoginInfoActivity$8(LoginInfoActivity paramLoginInfoActivity, int paramInt) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (!this.this$0.isFinishing())
        {
          if ((LoginInfoActivity.a(this.this$0) != null) && (LoginInfoActivity.a(this.this$0).isShowing()))
          {
            LoginInfoActivity.a(this.this$0).dismiss();
            LoginInfoActivity.a(this.this$0).cancel();
            LoginInfoActivity.a(this.this$0, null);
          }
          LoginInfoActivity.a(this.this$0, new arhz(this.this$0.getActivity(), this.this$0.getTitleBarHeight()));
          int i = this.val$type;
          switch (i)
          {
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        continue;
        LoginInfoActivity.a(this.this$0).setMessage(2131696693);
        continue;
      }
      if ((LoginInfoActivity.a(this.this$0) != null) && (!LoginInfoActivity.a(this.this$0).isShowing())) {
        LoginInfoActivity.a(this.this$0).show();
      }
      return;
      LoginInfoActivity.a(this.this$0).setMessage(2131718674);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity.8
 * JD-Core Version:    0.7.0.1
 */