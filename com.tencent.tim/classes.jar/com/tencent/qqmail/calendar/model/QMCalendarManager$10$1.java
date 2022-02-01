package com.tencent.qqmail.calendar.model;

import android.util.Log;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.calendar.data.CalendarFolderChangeSyncData;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.sqlite.QMCalendarSQLiteHelper;
import com.tencent.qqmail.calendar.watcher.CalendarFolderDeleteWatcher;
import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import moai.core.watcher.Watchers;

class QMCalendarManager$10$1
  implements MailManagerDelegate.DataCallback
{
  QMCalendarManager$10$1(QMCalendarManager.10 param10) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    CalendarInfo localCalendarInfo = (CalendarInfo)paramObject1;
    int i;
    if ((paramObject2 instanceof CalendarFolderChangeSyncData))
    {
      paramObject2 = (CalendarFolderChangeSyncData)paramObject2;
      if (localCalendarInfo.accountType == 1)
      {
        this.this$1.val$calendarFolder.getAccountId();
        i = this.this$1.val$calendarFolder.getId();
        paramObject1 = QMCalendarManager.access$1000(this.this$1.this$0).getWritableDatabase();
        paramObject1.beginTransactionNonExclusive();
      }
    }
    else
    {
      try
      {
        QMCalendarManager.access$1000(this.this$1.this$0).deleteCalendarFolder(paramObject1, i);
        QMLog.log(4, "QMCalendarManager", "removeCalendarFolderByProtocolMgr success id:" + this.this$1.val$calendarFolder.getId() + " name:" + this.this$1.val$calendarFolder.getName());
        QMCalendarManager.access$1100(this.this$1.this$0, paramObject1, paramObject2, localCalendarInfo.accountType);
        paramObject1.setTransactionSuccessful();
      }
      catch (Exception paramObject2)
      {
        for (;;)
        {
          QMLog.log(6, "QMCalendarManager", Log.getStackTraceString(paramObject2));
          paramObject1.endTransaction();
        }
      }
      finally
      {
        paramObject1.endTransaction();
      }
      QMCalendarManager.access$200(this.this$1.this$0).resetScheduleCache();
      QMCalendarManager.access$1200(this.this$1.this$0).updateRemindersInBackground();
      ((CalendarFolderDeleteWatcher)Watchers.of(CalendarFolderDeleteWatcher.class)).onSuccess(i);
    }
    while (localCalendarInfo.accountType != 2) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.10.1
 * JD-Core Version:    0.7.0.1
 */