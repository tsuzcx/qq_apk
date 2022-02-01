package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.folderlist.FolderDataManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingCardActivity$2
  implements UITableView.ClickListener
{
  SettingCardActivity$2(SettingCardActivity paramSettingCardActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    boolean bool;
    if (paramUITableItemView == SettingCardActivity.access$100(this.this$0))
    {
      if (paramUITableItemView.isChecked()) {
        break label70;
      }
      bool = true;
      paramUITableItemView.setChecked(bool);
      if (!paramUITableItemView.isChecked()) {
        break label75;
      }
      FolderDataManager.moveAppFromInnerToHomeAndSendToServer(-23);
    }
    for (;;)
    {
      QMLog.log(4, "SettingCardActivity", "move app:" + -23 + " to send config");
      return;
      label70:
      bool = false;
      break;
      label75:
      FolderDataManager.moveAppFromHomeToInnerAndSendToServer(-23);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCardActivity.2
 * JD-Core Version:    0.7.0.1
 */