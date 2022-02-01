package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

class RegisterBaseActivity$4
  implements Runnable
{
  RegisterBaseActivity$4(RegisterBaseActivity paramRegisterBaseActivity, int paramInt) {}
  
  public void run()
  {
    this.this$0.dialog = new ReportDialog(this.this$0, 2131756467);
    this.this$0.dialog.setContentView(2131558460);
    ((TextView)this.this$0.dialog.findViewById(2131365863)).setText(this.this$0.getString(this.bKA));
    this.this$0.dialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterBaseActivity.4
 * JD-Core Version:    0.7.0.1
 */