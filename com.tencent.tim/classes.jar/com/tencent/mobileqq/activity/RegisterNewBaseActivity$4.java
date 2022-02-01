package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

class RegisterNewBaseActivity$4
  implements Runnable
{
  RegisterNewBaseActivity$4(RegisterNewBaseActivity paramRegisterNewBaseActivity, int paramInt) {}
  
  public void run()
  {
    this.this$0.dialog = new ReportDialog(this.this$0, 2131756467);
    this.this$0.dialog.setContentView(2131562055);
    ((TextView)this.this$0.dialog.findViewById(2131365863)).setText(this.this$0.getString(this.bKA));
    this.this$0.dialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterNewBaseActivity.4
 * JD-Core Version:    0.7.0.1
 */