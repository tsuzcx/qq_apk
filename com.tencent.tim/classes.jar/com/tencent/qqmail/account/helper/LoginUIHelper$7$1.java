package com.tencent.qqmail.account.helper;

import android.content.Context;
import android.content.Intent;
import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class LoginUIHelper$7$1
  implements QMUIDialogAction.ActionListener
{
  LoginUIHelper$7$1(LoginUIHelper.7 param7) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    Intent localIntent = LoginFragmentActivity.createIntentFor3GLogin(this.this$0.val$account.getId(), this.this$0.val$account.getEmail());
    this.this$0.val$context.startActivity(localIntent);
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.helper.LoginUIHelper.7.1
 * JD-Core Version:    0.7.0.1
 */