package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.thread.Threads;

class ComposeMailActivity$71
  implements QMUIDialogAction.ActionListener
{
  ComposeMailActivity$71(ComposeMailActivity paramComposeMailActivity, Account paramAccount) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    if (this.val$qqAccount != null) {
      ComposeMailActivity.access$8500(this.this$0);
    }
    for (;;)
    {
      paramQMUIDialog.dismiss();
      return;
      ComposeMailActivity.access$8600(this.this$0).getReceiver().getAddrsViewControl().requestInputAreaFocus();
      Threads.runOnMainThread(new ComposeMailActivity.71.1(this), 300L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.71
 * JD-Core Version:    0.7.0.1
 */