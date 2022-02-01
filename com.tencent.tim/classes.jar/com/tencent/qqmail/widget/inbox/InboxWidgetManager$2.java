package com.tencent.qqmail.widget.inbox;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.timer.WidgetDataChangeTimer.OnDataChangeListener;

class InboxWidgetManager$2
  implements WidgetDataChangeTimer.OnDataChangeListener
{
  InboxWidgetManager$2(InboxWidgetManager paramInboxWidgetManager) {}
  
  public void notifyDataChange()
  {
    QMLog.log(4, "InboxWidgetManager", "inner notifyDataChange");
    AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance(QMApplicationContext.sharedInstance());
    localAppWidgetManager.notifyAppWidgetViewDataChanged(localAppWidgetManager.getAppWidgetIds(new ComponentName(QMApplicationContext.sharedInstance(), InboxWidgetProvider.class)), 2131369127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.inbox.InboxWidgetManager.2
 * JD-Core Version:    0.7.0.1
 */