package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingMailRemindActivity$3
  implements UITableView.ClickListener
{
  SettingMailRemindActivity$3(SettingMailRemindActivity paramSettingMailRemindActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    paramUITableItemView = SettingSoundActivity.createIntent(paramInt);
    this.this$0.startActivity(paramUITableItemView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingMailRemindActivity.3
 * JD-Core Version:    0.7.0.1
 */