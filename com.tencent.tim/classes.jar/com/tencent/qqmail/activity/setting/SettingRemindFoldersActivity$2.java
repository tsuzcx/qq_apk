package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingRemindFoldersActivity$2
  implements UITableView.ClickListener
{
  SettingRemindFoldersActivity$2(SettingRemindFoldersActivity paramSettingRemindFoldersActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    boolean bool;
    if (!paramUITableItemView.isChecked())
    {
      bool = true;
      paramUITableItemView.setChecked(bool);
      if (paramUITableItemView.isChecked()) {
        break label78;
      }
      SettingRemindFoldersActivity.access$010(this.this$0);
    }
    for (;;)
    {
      if (SettingRemindFoldersActivity.access$000(this.this$0) <= 0)
      {
        SettingRemindFoldersActivity.access$600(this.this$0).setChecked(false);
        SettingRemindFoldersActivity.access$400(this.this$0, false);
        SettingRemindFoldersActivity.access$200(this.this$0).setVisibility(8);
      }
      return;
      bool = false;
      break;
      label78:
      SettingRemindFoldersActivity.access$008(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingRemindFoldersActivity.2
 * JD-Core Version:    0.7.0.1
 */