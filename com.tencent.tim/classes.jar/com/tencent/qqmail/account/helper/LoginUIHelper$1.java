package com.tencent.qqmail.account.helper;

import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

final class LoginUIHelper$1
  implements QMUIDialogAction.ActionListener
{
  LoginUIHelper$1(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    if (this.val$okListener != null) {
      this.val$okListener.onClick(paramQMUIDialog, paramInt);
    }
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.helper.LoginUIHelper.1
 * JD-Core Version:    0.7.0.1
 */