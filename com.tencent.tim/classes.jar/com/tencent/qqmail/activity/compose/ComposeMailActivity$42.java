package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.log.QMLog;

class ComposeMailActivity$42
  implements QMUIDialogAction.ActionListener
{
  ComposeMailActivity$42(ComposeMailActivity paramComposeMailActivity, QMUIDialogAction.ActionListener paramActionListener) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    QMLog.log(4, "ComposeMailActivity", "click cancel for download attach");
    ComposeMailActivity.access$5602(this.this$0, true);
    paramQMUIDialog.dismiss();
    if (this.val$sureListener != null) {
      this.val$sureListener.onClick(paramQMUIDialog, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.42
 * JD-Core Version:    0.7.0.1
 */