package com.tencent.mobileqq.activity;

import arhz;

class VerifyPhoneNumActivity$7
  implements Runnable
{
  VerifyPhoneNumActivity$7(VerifyPhoneNumActivity paramVerifyPhoneNumActivity) {}
  
  public void run()
  {
    try
    {
      if ((VerifyPhoneNumActivity.a(this.this$0) == null) && (!this.this$0.isFinishing()))
      {
        VerifyPhoneNumActivity.a(this.this$0, new arhz(this.this$0.getActivity(), this.this$0.getTitleBarHeight()));
        VerifyPhoneNumActivity.a(this.this$0).setMessage(2131696693);
      }
      if ((VerifyPhoneNumActivity.a(this.this$0) != null) && (!VerifyPhoneNumActivity.a(this.this$0).isShowing())) {
        VerifyPhoneNumActivity.a(this.this$0).show();
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
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyPhoneNumActivity.7
 * JD-Core Version:    0.7.0.1
 */