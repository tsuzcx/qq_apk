package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.utilities.badge.BadgeUtil;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingMailRemindActivity$5
  implements UITableView.ClickListener
{
  SettingMailRemindActivity$5(SettingMailRemindActivity paramSettingMailRemindActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramInt = 0;
    if (paramUITableItemView == SettingMailRemindActivity.access$900(this.this$0)) {
      if (!paramUITableItemView.isChecked())
      {
        paramUITableItemView.setChecked(bool1);
        SharedPreferenceUtil.setBadgeOpen(bool1);
        BadgeUtil.getInstance().setBadgeAccordingQMAccount();
        paramUITableItemView = SettingMailRemindActivity.access$1000(this.this$0);
        if (!bool1) {
          break label64;
        }
        paramUITableItemView.setVisibility(paramInt);
      }
    }
    label64:
    while (paramUITableItemView != SettingMailRemindActivity.access$1000(this.this$0)) {
      for (;;)
      {
        return;
        bool1 = false;
        continue;
        paramInt = 8;
      }
    }
    if (!paramUITableItemView.isChecked()) {}
    for (bool1 = bool2;; bool1 = false)
    {
      paramUITableItemView.setChecked(bool1);
      SharedPreferenceUtil.setBadgeIncrement(bool1);
      BadgeUtil.getInstance().setBadgeAccordingQMAccount();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingMailRemindActivity.5
 * JD-Core Version:    0.7.0.1
 */