package com.tencent.mobileqq.activity;

import arhz;

class AuthDevRenameActivity$4
  implements Runnable
{
  AuthDevRenameActivity$4(AuthDevRenameActivity paramAuthDevRenameActivity) {}
  
  public void run()
  {
    try
    {
      if ((AuthDevRenameActivity.a(this.this$0) == null) && (!this.this$0.isFinishing())) {
        AuthDevRenameActivity.a(this.this$0, new arhz(this.this$0, this.this$0.getTitleBarHeight()));
      }
      if ((AuthDevRenameActivity.a(this.this$0) != null) && (!AuthDevRenameActivity.a(this.this$0).isShowing()))
      {
        AuthDevRenameActivity.a(this.this$0).setMessage(this.this$0.getString(2131693243));
        AuthDevRenameActivity.a(this.this$0).show();
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
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevRenameActivity.4
 * JD-Core Version:    0.7.0.1
 */