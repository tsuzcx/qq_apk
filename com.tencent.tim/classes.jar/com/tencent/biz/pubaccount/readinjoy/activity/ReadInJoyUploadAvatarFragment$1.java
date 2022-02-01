package com.tencent.biz.pubaccount.readinjoy.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import kje;

public class ReadInJoyUploadAvatarFragment$1
  implements Runnable
{
  ReadInJoyUploadAvatarFragment$1(ReadInJoyUploadAvatarFragment paramReadInJoyUploadAvatarFragment, Activity paramActivity) {}
  
  public void run()
  {
    if (this.val$activity.isFinishing()) {
      return;
    }
    this.this$0.d = new ReportProgressDialog(this.val$activity, 2131756467);
    this.this$0.d.setCancelable(true);
    this.this$0.d.show();
    this.this$0.d.setContentView(2131559761);
    TextView localTextView = (TextView)this.this$0.d.findViewById(2131373180);
    this.this$0.d.setOnCancelListener(new kje(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarFragment.1
 * JD-Core Version:    0.7.0.1
 */