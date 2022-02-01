package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.folderlist.FolderDataManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingCalendarActivity$3
  implements UITableView.ClickListener
{
  SettingCalendarActivity$3(SettingCalendarActivity paramSettingCalendarActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    boolean bool;
    if (!paramUITableItemView.isChecked())
    {
      bool = true;
      paramUITableItemView.setChecked(bool);
      if (!paramUITableItemView.isChecked()) {
        break label69;
      }
      FolderDataManager.moveAppFromInnerToHomeAndSendToServer(-18);
      DataCollector.logEvent("Event_Calendar_Setting_Show_Home");
    }
    for (;;)
    {
      QMLog.log(4, "SettingCalendarActivity", "move app:" + -18 + " to send config");
      return;
      bool = false;
      break;
      label69:
      FolderDataManager.moveAppFromHomeToInnerAndSendToServer(-18);
      DataCollector.logEvent("Event_Calendar_Setting_Show_Inner");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCalendarActivity.3
 * JD-Core Version:    0.7.0.1
 */