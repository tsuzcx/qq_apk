package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingActivity$4
  implements UITableView.ClickListener
{
  SettingActivity$4(SettingActivity paramSettingActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    paramUITableItemView = SettingMailRemindActivity.createIntent();
    this.this$0.startActivity(paramUITableItemView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingActivity.4
 * JD-Core Version:    0.7.0.1
 */