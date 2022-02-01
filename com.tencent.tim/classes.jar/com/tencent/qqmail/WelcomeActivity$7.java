package com.tencent.qqmail;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class WelcomeActivity$7
  implements QMUIDialogAction.ActionListener
{
  WelcomeActivity$7(WelcomeActivity paramWelcomeActivity) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    this.this$0.internalRequestRequiredPermission();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.WelcomeActivity.7
 * JD-Core Version:    0.7.0.1
 */