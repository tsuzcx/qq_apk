package com.tencent.qqmail.calendar.view;

import com.tencent.qqmail.calendar.util.QMCalendarUtil;
import com.tencent.qqmail.calendar.watcher.ScheduleLoadWatcher;
import java.util.Calendar;

class CalendarViewGroup$1
  implements ScheduleLoadWatcher
{
  CalendarViewGroup$1(CalendarViewGroup paramCalendarViewGroup) {}
  
  public void onLoadSuccess(Calendar paramCalendar, boolean paramBoolean)
  {
    if ((QMCalendarUtil.isSameDate(this.this$0.getSelectedDay(), paramCalendar)) || (paramBoolean)) {
      CalendarViewGroup.access$200(this.this$0).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.CalendarViewGroup.1
 * JD-Core Version:    0.7.0.1
 */