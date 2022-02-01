package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class SettingFtnActivity$2$1
  implements QMUIDialogAction.ActionListener
{
  SettingFtnActivity$2$1(SettingFtnActivity.2 param2) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    SettingActivity.ADDACCOUNT = SettingActivity.ADDING;
    paramQMUIDialog = LoginFragmentActivity.createIntentToAddPlugInAccount("FTN");
    this.this$1.this$0.startActivity(paramQMUIDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingFtnActivity.2.1
 * JD-Core Version:    0.7.0.1
 */