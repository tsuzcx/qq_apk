package com.tencent.qqmail.account.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.activity.setting.SettingAccountActivity;

class LoginAccountFragment$54
  implements DialogInterface.OnClickListener
{
  LoginAccountFragment$54(LoginAccountFragment paramLoginAccountFragment, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QMActivityManager.shareInstance().finishAllActivity();
    paramDialogInterface = SettingAccountActivity.createIntent(this.val$existAccountId);
    this.this$0.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginAccountFragment.54
 * JD-Core Version:    0.7.0.1
 */