package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingFtnActivity$4
  implements UITableView.ClickListener
{
  SettingFtnActivity$4(SettingFtnActivity paramSettingFtnActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    paramUITableItemView = SettingSelectAccountActivity.createFtnIntent(SettingFtnActivity.access$000(this.this$0));
    this.this$0.startActivity(paramUITableItemView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingFtnActivity.4
 * JD-Core Version:    0.7.0.1
 */