package com.tencent.mobileqq.activity;

import arhz;

class RegisterQQNumberActivity$5
  implements Runnable
{
  RegisterQQNumberActivity$5(RegisterQQNumberActivity paramRegisterQQNumberActivity) {}
  
  public void run()
  {
    try
    {
      if ((RegisterQQNumberActivity.a(this.this$0) == null) && (!this.this$0.isFinishing()))
      {
        RegisterQQNumberActivity.a(this.this$0, new arhz(this.this$0.getActivity(), this.this$0.getTitleBarHeight()));
        RegisterQQNumberActivity.a(this.this$0).setMessage(2131696693);
      }
      if ((RegisterQQNumberActivity.a(this.this$0) != null) && (!RegisterQQNumberActivity.a(this.this$0).isShowing())) {
        RegisterQQNumberActivity.a(this.this$0).show();
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
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterQQNumberActivity.5
 * JD-Core Version:    0.7.0.1
 */