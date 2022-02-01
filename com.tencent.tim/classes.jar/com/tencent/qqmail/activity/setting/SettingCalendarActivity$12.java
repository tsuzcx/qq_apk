package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.calendar.fragment.CalendarFragmentActivity;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingCalendarActivity$12
  implements UITableView.ClickListener
{
  SettingCalendarActivity$12(SettingCalendarActivity paramSettingCalendarActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    if (paramInt == 0)
    {
      paramUITableItemView = CalendarFragmentActivity.createIntentToCalendarListFromSetting();
      this.this$0.startActivity(paramUITableItemView);
    }
    while (paramInt != 1) {
      return;
    }
    SettingCalendarFragmentActivity.flag = SettingCalendarFragmentActivity.DEFAULT_CALENDAR;
    paramUITableItemView = SettingCalendarFragmentActivity.createIntent();
    this.this$0.startActivity(paramUITableItemView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCalendarActivity.12
 * JD-Core Version:    0.7.0.1
 */