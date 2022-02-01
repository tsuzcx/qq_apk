package com.tencent.qqmail.account.fragment;

import com.tencent.qqmail.BaseActivityImpl;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class LoginAccountFragment$46
  implements QMUIDialogAction.ActionListener
{
  LoginAccountFragment$46(LoginAccountFragment paramLoginAccountFragment) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    this.this$0.abortLogin();
    paramQMUIDialog.dismiss();
    LoginAccountFragment.access$3600(this.this$0).finishWithNoCheck();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginAccountFragment.46
 * JD-Core Version:    0.7.0.1
 */