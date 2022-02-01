package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.ShortcutUtility;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingCalendarActivity$10
  implements UITableView.ClickListener
{
  SettingCalendarActivity$10(SettingCalendarActivity paramSettingCalendarActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    if (!paramUITableItemView.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramUITableItemView.setChecked(bool);
      if (!bool) {
        break;
      }
      ShortcutUtility.addApplicationShortcut(this.this$0.getString(2131690401), 2130839106);
      DataCollector.logEvent("Event_Add_Calendar_Shortcut_In_Setting");
      QMLog.log(4, "SettingCalendarActivity", "add Calendar ShortCut");
      return;
    }
    ShortcutUtility.deleteApplicationShortcut(this.this$0.getString(2131690401));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCalendarActivity.10
 * JD-Core Version:    0.7.0.1
 */