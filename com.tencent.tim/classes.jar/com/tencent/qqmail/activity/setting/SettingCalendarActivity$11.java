package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingCalendarActivity$11
  implements UITableView.ClickListener
{
  SettingCalendarActivity$11(SettingCalendarActivity paramSettingCalendarActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    if (paramUITableItemView == SettingCalendarActivity.access$1500(this.this$0)) {
      if (paramUITableItemView.isChecked()) {
        break label45;
      }
    }
    label45:
    for (boolean bool = true;; bool = false)
    {
      paramUITableItemView.setChecked(bool);
      SettingCalendarActivity.access$100(this.this$0).setShowLunarCalendar(bool);
      this.this$0.refreshData();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCalendarActivity.11
 * JD-Core Version:    0.7.0.1
 */