package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class SettingNoteActivity$8
  implements QMUIDialogAction.ActionListener
{
  SettingNoteActivity$8(SettingNoteActivity paramSettingNoteActivity) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    SettingActivity.ADDACCOUNT = SettingActivity.ADDING;
    paramQMUIDialog = LoginFragmentActivity.createIntentToAddPlugInAccount("NOTE");
    this.this$0.startActivity(paramQMUIDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingNoteActivity.8
 * JD-Core Version:    0.7.0.1
 */