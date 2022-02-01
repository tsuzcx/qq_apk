package com.tencent.qqmail.account.fragment;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.log.QMLog;
import moai.oss.KvHelper;

class LoginTaskFragment$3$2
  implements QMUIDialogAction.ActionListener
{
  LoginTaskFragment$3$2(LoginTaskFragment.3 param3) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    KvHelper.digitalLoginErrorCancel(new double[0]);
    paramQMUIDialog.dismiss();
    this.this$1.this$0.recoverFocus();
    QMLog.log(4, "LoginAccountBaseFragment", "digital login cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginTaskFragment.3.2
 * JD-Core Version:    0.7.0.1
 */