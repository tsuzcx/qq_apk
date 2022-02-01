package com.tencent.mobileqq.activity;

import android.app.Dialog;

class RegisterActivity$10
  implements Runnable
{
  RegisterActivity$10(RegisterActivity paramRegisterActivity) {}
  
  public void run()
  {
    if ((this.this$0.dialog != null) && (this.this$0.dialog.isShowing()) && (!this.this$0.isFinishing())) {
      this.this$0.dialog.dismiss();
    }
    this.this$0.dialog = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterActivity.10
 * JD-Core Version:    0.7.0.1
 */