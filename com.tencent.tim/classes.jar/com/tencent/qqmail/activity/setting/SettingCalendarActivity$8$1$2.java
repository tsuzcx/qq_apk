package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class SettingCalendarActivity$8$1$2
  implements QMUIDialogAction.ActionListener
{
  SettingCalendarActivity$8$1$2(SettingCalendarActivity.8.1 param1) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    PasswordErrHandling.setUserClickHandle(true);
    paramQMUIDialog.dismiss();
    PasswordErrHandling.setHandling(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCalendarActivity.8.1.2
 * JD-Core Version:    0.7.0.1
 */