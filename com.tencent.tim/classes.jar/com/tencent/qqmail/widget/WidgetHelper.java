package com.tencent.qqmail.widget;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.widget.calendar.CalendarWidgetManager;
import com.tencent.qqmail.widget.calendar.MonthWidgetManager;
import com.tencent.qqmail.widget.inbox.InboxWidgetManager;
import com.tencent.qqmail.widget.notelist.NoteWidgetManager;

public class WidgetHelper
{
  private static final String TAG = "WidgetHelper";
  
  public static void preInitWidget()
  {
    QMLog.log(4, "WidgetHelper", "preInitWidget");
    if (SharedPreferenceUtil.isExistedNoteWidget()) {
      NoteWidgetManager.getInstance().init();
    }
    if (SharedPreferenceUtil.isExistedInboxWidget()) {
      InboxWidgetManager.getInstance().init();
    }
    if (SharedPreferenceUtil.isExistedMonthWidget()) {
      MonthWidgetManager.getInstance().init();
    }
    if (SharedPreferenceUtil.isExistedCalendarWidget()) {
      CalendarWidgetManager.getInstance().init();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.WidgetHelper
 * JD-Core Version:    0.7.0.1
 */