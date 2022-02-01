package com.tencent.mobileqq.activity.history;

import android.app.Dialog;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

class ChatHistoryBaseFragment$4
  implements Runnable
{
  ChatHistoryBaseFragment$4(ChatHistoryBaseFragment paramChatHistoryBaseFragment, DialogInterface.OnCancelListener paramOnCancelListener, CharSequence paramCharSequence) {}
  
  public void run()
  {
    if ((this.this$0.getActivity() != null) && (!this.this$0.getActivity().isFinishing()))
    {
      if (this.this$0.g != null) {
        break label175;
      }
      this.this$0.a = new ChatHistoryBaseFragment.ProgressView(this.this$0.getActivity());
      this.this$0.g = new ReportDialog(this.this$0.getActivity());
      this.this$0.g.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      this.this$0.g.setCanceledOnTouchOutside(false);
      this.this$0.g.requestWindowFeature(1);
      this.this$0.g.setContentView(this.this$0.a);
      this.this$0.g.setOnCancelListener(this.c);
    }
    for (;;)
    {
      this.this$0.a.setProgressText(this.j);
      this.this$0.g.show();
      return;
      label175:
      this.this$0.g.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBaseFragment.4
 * JD-Core Version:    0.7.0.1
 */