package com.tencent.qqmail.widget.calendar;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.timer.WidgetDataChangeTimer.OnDataChangeListener;

class CalendarWidgetManager$2
  implements WidgetDataChangeTimer.OnDataChangeListener
{
  CalendarWidgetManager$2(CalendarWidgetManager paramCalendarWidgetManager) {}
  
  public void notifyDataChange()
  {
    QMLog.log(3, "CalendarWidgetManager", "notifyDataChange");
    Object localObject = AppWidgetManager.getInstance(QMApplicationContext.sharedInstance());
    ((AppWidgetManager)localObject).notifyAppWidgetViewDataChanged(((AppWidgetManager)localObject).getAppWidgetIds(new ComponentName(QMApplicationContext.sharedInstance(), CalendarWidgetProvider.class)), 2131364161);
    localObject = new Intent();
    ((Intent)localObject).setAction("com.tencent.qqmail.widget.month.refresh.ui");
    QMApplicationContext.sharedInstance().sendBroadcast((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.calendar.CalendarWidgetManager.2
 * JD-Core Version:    0.7.0.1
 */