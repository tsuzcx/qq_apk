package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingRemindSubAccountActivity$2
  implements UITableView.ClickListener
{
  SettingRemindSubAccountActivity$2(SettingRemindSubAccountActivity paramSettingRemindSubAccountActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    boolean bool;
    if (!paramUITableItemView.isChecked())
    {
      bool = true;
      paramUITableItemView.setChecked(bool);
      if (!paramUITableItemView.isChecked()) {
        break label70;
      }
      SettingRemindSubAccountActivity.access$408(this.this$0);
    }
    for (;;)
    {
      if (SettingRemindSubAccountActivity.access$400(this.this$0) <= 0)
      {
        SettingRemindSubAccountActivity.access$600(this.this$0).setChecked(false);
        SettingRemindSubAccountActivity.access$100(this.this$0).setVisibility(8);
      }
      return;
      bool = false;
      break;
      label70:
      SettingRemindSubAccountActivity.access$410(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingRemindSubAccountActivity.2
 * JD-Core Version:    0.7.0.1
 */