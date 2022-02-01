package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.folderlist.FolderDataManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingContactActivity$2
  implements UITableView.ClickListener
{
  SettingContactActivity$2(SettingContactActivity paramSettingContactActivity) {}
  
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
      FolderDataManager.moveAppFromInnerToHomeAndSendToServer(-22);
      DataCollector.logEvent("Event_Addressbook_Setting_Show_Home");
    }
    for (;;)
    {
      QMLog.log(4, "SettingContactActivity", "move app:16842960 to send config");
      return;
      bool = false;
      break;
      label46:
      FolderDataManager.moveAppFromHomeToInnerAndSendToServer(-22);
      DataCollector.logEvent("Event_Addressbook_Setting_Show_Inner");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingContactActivity.2
 * JD-Core Version:    0.7.0.1
 */