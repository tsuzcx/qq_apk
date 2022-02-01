package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingCalendarDefaultRemindTimeFragment$2
  implements UITableView.ClickListener
{
  SettingCalendarDefaultRemindTimeFragment$2(SettingCalendarDefaultRemindTimeFragment paramSettingCalendarDefaultRemindTimeFragment) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    if (paramInt == 0)
    {
      paramUITableItemView = new SettingCalendarEventRemindTimeFragment();
      this.this$0.startFragment(paramUITableItemView);
    }
    while (paramInt != 1) {
      return;
    }
    paramUITableItemView = new SettingCalendarAllDayEventRemindTimeFragment();
    this.this$0.startFragment(paramUITableItemView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCalendarDefaultRemindTimeFragment.2
 * JD-Core Version:    0.7.0.1
 */