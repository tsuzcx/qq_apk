package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.log.QMLog;

class SettingNightModeActivity$10
  implements QMUIDialogAction.ActionListener
{
  SettingNightModeActivity$10(SettingNightModeActivity paramSettingNightModeActivity) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    QMLog.log(4, "SettingNightModeActivit", "ensureFloatViewPermission click cancel");
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingNightModeActivity.10
 * JD-Core Version:    0.7.0.1
 */