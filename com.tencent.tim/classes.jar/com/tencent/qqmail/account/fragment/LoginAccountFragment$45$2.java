package com.tencent.qqmail.account.fragment;

import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class LoginAccountFragment$45$2
  implements QMUIDialogAction.ActionListener
{
  LoginAccountFragment$45$2(LoginAccountFragment.45 param45) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.setOnDismissListener(null);
    paramQMUIDialog.dismiss();
    this.this$1.this$0.mAccountType = this.this$1.val$loginAccountType;
    if (this.this$1.this$0.mAccountType == AccountType.gmail)
    {
      LoginAccountFragment.access$3200(this.this$1.this$0);
      return;
    }
    this.this$1.this$0.refreshTopBar(true);
    LoginAccountFragment.access$3500(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginAccountFragment.45.2
 * JD-Core Version:    0.7.0.1
 */