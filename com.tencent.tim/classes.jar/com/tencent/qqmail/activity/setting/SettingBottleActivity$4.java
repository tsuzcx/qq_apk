package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.folderlist.FolderDataManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingBottleActivity$4
  implements UITableView.ClickListener
{
  SettingBottleActivity$4(SettingBottleActivity paramSettingBottleActivity) {}
  
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
      FolderDataManager.moveAppFromInnerToHomeAndSendToServer(-16);
      DataCollector.logEvent("Event_Bottle_Setting_Show_Home");
    }
    for (;;)
    {
      QMLog.log(4, "SettingBottleActivity", "move app:" + -16 + " to send config");
      return;
      bool = false;
      break;
      label69:
      FolderDataManager.moveAppFromHomeToInnerAndSendToServer(-16);
      DataCollector.logEvent("Event_Bottle_Setting_Show_Inner");
      FolderDataManager.sharedInstance().syncInnerBottleUnreadCount();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingBottleActivity.4
 * JD-Core Version:    0.7.0.1
 */