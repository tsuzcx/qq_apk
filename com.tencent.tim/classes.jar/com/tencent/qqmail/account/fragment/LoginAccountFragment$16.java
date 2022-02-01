package com.tencent.qqmail.account.fragment;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class LoginAccountFragment$16
  implements QMUIDialogAction.ActionListener
{
  LoginAccountFragment$16(LoginAccountFragment paramLoginAccountFragment) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    this.this$0.goToLoginProtocolPage();
    paramQMUIDialog.dismiss();
    LoginAccountFragment.access$1200(this.this$0, true, false, false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginAccountFragment.16
 * JD-Core Version:    0.7.0.1
 */