package com.tencent.biz.qqstory.storyHome;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import ram;

class QQStoryBaseActivity$2
  implements Runnable
{
  QQStoryBaseActivity$2(QQStoryBaseActivity paramQQStoryBaseActivity, Context paramContext, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean, CharSequence paramCharSequence) {}
  
  public void run()
  {
    if (this.this$0.isFinishing())
    {
      ram.w("Q.qqstory.QQStoryBaseActivity", "Activity has been destroy.");
      return;
    }
    if (this.this$0.g == null)
    {
      this.this$0.a = new QQStoryBaseActivity.ProgressView(this.val$context);
      this.this$0.g = new ReportDialog(this.val$context);
      this.this$0.g.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      this.this$0.g.setCanceledOnTouchOutside(false);
      this.this$0.g.requestWindowFeature(1);
      this.this$0.g.setContentView(this.this$0.a);
      this.this$0.g.setOnDismissListener(this.val$dismissListener);
    }
    for (;;)
    {
      this.this$0.g.setCancelable(this.aEs);
      this.this$0.a.setProgressText(this.j);
      this.this$0.g.show();
      return;
      this.this$0.g.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity.2
 * JD-Core Version:    0.7.0.1
 */