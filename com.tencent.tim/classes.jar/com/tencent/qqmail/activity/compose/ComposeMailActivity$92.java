package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.observer.QMNotification;

class ComposeMailActivity$92
  implements QMUIDialogAction.ActionListener
{
  ComposeMailActivity$92(ComposeMailActivity paramComposeMailActivity) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    QMNotification.postNotification("focus_addr_edittext", Boolean.valueOf(true));
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.92
 * JD-Core Version:    0.7.0.1
 */