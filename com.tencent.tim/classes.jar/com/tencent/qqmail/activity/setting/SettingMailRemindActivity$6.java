package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import java.util.List;

class SettingMailRemindActivity$6
  implements UITableView.ClickListener
{
  SettingMailRemindActivity$6(SettingMailRemindActivity paramSettingMailRemindActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    if (paramInt <= SettingMailRemindActivity.access$1100(this.this$0).size() - 1)
    {
      paramUITableItemView = SettingRemindDetailActivity.createIntent(((Integer)SettingMailRemindActivity.access$1100(this.this$0).get(paramInt)).intValue());
      this.this$0.startActivity(paramUITableItemView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingMailRemindActivity.6
 * JD-Core Version:    0.7.0.1
 */