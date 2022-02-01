package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class SettingCalendarActivity$8$1$1
  implements QMUIDialogAction.ActionListener
{
  SettingCalendarActivity$8$1$1(SettingCalendarActivity.8.1 param1) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    PasswordErrHandling.setUserClickHandle(true);
    Intent localIntent = LoginFragmentActivity.createIntentForVerifyPswError(this.this$2.this$1.val$account.getId(), this.this$2.this$1.val$account.getEmail());
    this.this$2.this$1.this$0.startActivity(localIntent);
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCalendarActivity.8.1.1
 * JD-Core Version:    0.7.0.1
 */