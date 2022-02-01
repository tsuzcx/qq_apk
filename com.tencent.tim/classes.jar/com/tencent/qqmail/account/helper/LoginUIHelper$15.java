package com.tencent.qqmail.account.helper;

import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

final class LoginUIHelper$15
  implements QMUIDialogAction.ActionListener
{
  LoginUIHelper$15(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    
    if (this.val$cancelListener != null) {
      this.val$cancelListener.onClick(paramQMUIDialog, paramInt);
    }
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.helper.LoginUIHelper.15
 * JD-Core Version:    0.7.0.1
 */