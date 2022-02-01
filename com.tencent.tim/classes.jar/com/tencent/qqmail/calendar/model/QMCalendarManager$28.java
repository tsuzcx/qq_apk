package com.tencent.qqmail.calendar.model;

import android.util.Log;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.calendar.data.CalendarEventSyncData;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.reminder.QMReminderer;
import com.tencent.qqmail.calendar.sqlite.QMCalendarSQLiteHelper;
import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;

class QMCalendarManager$28
  implements MailManagerDelegate.DataCallback
{
  QMCalendarManager$28(QMCalendarManager paramQMCalendarManager) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (CalendarInfo)paramObject1;
    if ((paramObject2 != null) && ((paramObject2 instanceof CalendarEventSyncData)))
    {
      paramObject2 = ((CalendarEventSyncData)paramObject2).getModifyEventList();
      paramObject1 = QMCalendarManager.access$1000(this.this$0).getWritableDatabase();
      paramObject1.beginTransactionNonExclusive();
      if (paramObject2 == null) {}
    }
    try
    {
      if (paramObject2.size() > 0)
      {
        int i = 0;
        while (i < paramObject2.size())
        {
          QMCalendarEvent localQMCalendarEvent = (QMCalendarEvent)paramObject2.get(i);
          QMCalendarManager.access$1000(this.this$0).deleteEvent(paramObject1, localQMCalendarEvent.getId());
          QMCalendarManager.access$1000(this.this$0).deleteSchedulesByEventId(paramObject1, localQMCalendarEvent.getId());
          QMCalendarManager.access$1000(this.this$0).insertCalendarEvent(paramObject1, localQMCalendarEvent);
          QMLog.log(4, "QMCalendarManager", "loadDetailEventForCalDav add id:" + localQMCalendarEvent.getId() + " name:" + localQMCalendarEvent.getSubject());
          QMCalendarManager.access$200(this.this$0).createAndSaveSchedule(localQMCalendarEvent);
          QMCalendarManager.access$1200(this.this$0).createRemindersByEvent(localQMCalendarEvent);
          i += 1;
        }
      }
      paramObject1.setTransactionSuccessful();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(6, "QMCalendarManager", Log.getStackTraceString(localException));
        paramObject1.endTransaction();
      }
    }
    finally
    {
      paramObject1.endTransaction();
    }
    if ((paramObject2 != null) && (paramObject2.size() > 0))
    {
      QMCalendarManager.access$200(this.this$0).resetScheduleCache();
      QMCalendarManager.access$1200(this.this$0).updateRemindersInBackground();
      this.this$0.triggerUpdateSchedule(null, 0L);
      QMReminderer.reDeploySentinel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.28
 * JD-Core Version:    0.7.0.1
 */