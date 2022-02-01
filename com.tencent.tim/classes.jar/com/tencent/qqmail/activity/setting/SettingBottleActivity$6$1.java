package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class SettingBottleActivity$6$1
  implements QMUIDialogAction.ActionListener
{
  SettingBottleActivity$6$1(SettingBottleActivity.6 param6) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    SettingActivity.ADDACCOUNT = SettingActivity.ADDING;
    paramQMUIDialog = LoginFragmentActivity.createIntentToAddPlugInAccount("BOTTLE");
    this.this$1.this$0.startActivity(paramQMUIDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingBottleActivity.6.1
 * JD-Core Version:    0.7.0.1
 */