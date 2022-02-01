package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingAccountActivity$11
  implements UITableView.ClickListener
{
  SettingAccountActivity$11(SettingAccountActivity paramSettingAccountActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    if (paramUITableItemView == SettingAccountActivity.access$2000(this.this$0)) {
      if (paramUITableItemView.isChecked()) {
        break label43;
      }
    }
    label43:
    for (boolean bool = true;; bool = false)
    {
      paramUITableItemView.setChecked(bool);
      SettingAccountActivity.access$2100(this.this$0, new SettingAccountActivity.11.1(this, paramUITableItemView));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAccountActivity.11
 * JD-Core Version:    0.7.0.1
 */