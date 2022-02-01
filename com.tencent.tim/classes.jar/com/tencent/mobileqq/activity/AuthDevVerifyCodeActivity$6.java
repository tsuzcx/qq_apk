package com.tencent.mobileqq.activity;

import arhz;

class AuthDevVerifyCodeActivity$6
  implements Runnable
{
  AuthDevVerifyCodeActivity$6(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity) {}
  
  public void run()
  {
    try
    {
      if ((AuthDevVerifyCodeActivity.a(this.this$0) == null) && (!this.this$0.isFinishing()))
      {
        AuthDevVerifyCodeActivity.a(this.this$0, new arhz(this.this$0.getActivity(), this.this$0.getTitleBarHeight()));
        AuthDevVerifyCodeActivity.a(this.this$0).setMessage(2131696693);
        AuthDevVerifyCodeActivity.a(this.this$0).setBackAndSearchFilter(true);
      }
      if ((AuthDevVerifyCodeActivity.a(this.this$0) != null) && (!AuthDevVerifyCodeActivity.a(this.this$0).isShowing())) {
        AuthDevVerifyCodeActivity.a(this.this$0).show();
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
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity.6
 * JD-Core Version:    0.7.0.1
 */