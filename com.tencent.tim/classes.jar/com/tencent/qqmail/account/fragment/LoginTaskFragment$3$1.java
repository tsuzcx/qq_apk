package com.tencent.qqmail.account.fragment;

import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import moai.oss.KvHelper;

class LoginTaskFragment$3$1
  implements QMUIDialogAction.ActionListener
{
  LoginTaskFragment$3$1(LoginTaskFragment.3 param3) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    KvHelper.digitalLoginErrorJump(new double[0]);
    LoginTaskFragment.access$800().add(this.this$1.val$autoCorrectEmail);
    paramQMUIDialog.dismiss();
    this.this$1.this$0.recoverFocus();
    this.this$1.this$0.refreshTopBar(true);
    this.this$1.this$0.mAccountType = AccountType.qqmail;
    this.this$1.this$0.userInputEmail = this.this$1.val$autoCorrectEmail;
    this.this$1.this$0.reLogin();
    QMLog.log(4, "LoginAccountBaseFragment", "digital login jump");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginTaskFragment.3.1
 * JD-Core Version:    0.7.0.1
 */