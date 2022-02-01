package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class SettingCalendarActivity$5
  implements QMUIDialogAction.ActionListener
{
  SettingCalendarActivity$5(SettingCalendarActivity paramSettingCalendarActivity, SettingCalendarActivity.ActionCallback paramActionCallback) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    if (this.val$callback != null) {
      this.val$callback.doAction();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCalendarActivity.5
 * JD-Core Version:    0.7.0.1
 */