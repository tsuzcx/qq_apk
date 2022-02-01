package com.tencent.qqmail.widget.calendar;

import android.util.Log;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.model.mail.watcher.CalendarScheduleTableHookWatcher;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.widget.model.CalendarWidgetScheduleInfo;
import java.util.Calendar;

class CalendarWidgetManager$1
  implements CalendarScheduleTableHookWatcher
{
  CalendarWidgetManager$1(CalendarWidgetManager paramCalendarWidgetManager) {}
  
  public void updateHook(int paramInt)
  {
    Log.i("CalendarWidgetManager", "updateHook");
    Calendar localCalendar = Calendar.getInstance();
    if (CalendarWidgetScheduleInfo.generateHash(QMCalendarManager.getInstance().getScheduleListInThisYear(localCalendar)) != SharedPreferenceUtil.getWidgetScheduleHash()) {
      this.this$0.notifyDataChange();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.calendar.CalendarWidgetManager.1
 * JD-Core Version:    0.7.0.1
 */