package com.tencent.qqmail.widget.notelist;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.timer.WidgetDataChangeTimer.OnDataChangeListener;

class NoteWidgetManager$2
  implements WidgetDataChangeTimer.OnDataChangeListener
{
  NoteWidgetManager$2(NoteWidgetManager paramNoteWidgetManager) {}
  
  public void notifyDataChange()
  {
    QMLog.log(3, "NoteWidgetManager", "notifyAppWidgetViewDataChanged");
    AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance(QMApplicationContext.sharedInstance());
    localAppWidgetManager.notifyAppWidgetViewDataChanged(localAppWidgetManager.getAppWidgetIds(new ComponentName(QMApplicationContext.sharedInstance(), NoteWidgetProvider.class)), 2131372500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.notelist.NoteWidgetManager.2
 * JD-Core Version:    0.7.0.1
 */