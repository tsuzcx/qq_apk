package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.folderlist.FolderDataManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingFtnActivity$3
  implements UITableView.ClickListener
{
  SettingFtnActivity$3(SettingFtnActivity paramSettingFtnActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    boolean bool;
    if (!paramUITableItemView.isChecked())
    {
      bool = true;
      paramUITableItemView.setChecked(bool);
      if (!paramUITableItemView.isChecked()) {
        break label46;
      }
      FolderDataManager.moveAppFromInnerToHomeAndSendToServer(-5);
      DataCollector.logEvent("Event_Ftn_Setting_Show_Home");
    }
    for (;;)
    {
      QMLog.log(4, "SettingFtnActivity", "move app:16842960 to send config");
      return;
      bool = false;
      break;
      label46:
      FolderDataManager.moveAppFromHomeToInnerAndSendToServer(-5);
      FolderDataManager.sharedInstance().syncInnerFtnUnreadCount();
      DataCollector.logEvent("Event_Ftn_Setting_Show_Inner");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingFtnActivity.3
 * JD-Core Version:    0.7.0.1
 */