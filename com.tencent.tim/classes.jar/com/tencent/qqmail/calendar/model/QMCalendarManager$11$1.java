package com.tencent.qqmail.calendar.model;

import android.util.Log;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.calendar.data.CalendarFolderChangeSyncData;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.sqlite.QMCalendarSQLiteHelper;
import com.tencent.qqmail.calendar.watcher.CalendarFolderUpdateWatcher;
import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import moai.core.watcher.Watchers;

class QMCalendarManager$11$1
  implements MailManagerDelegate.DataCallback
{
  QMCalendarManager$11$1(QMCalendarManager.11 param11) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    CalendarInfo localCalendarInfo = (CalendarInfo)paramObject1;
    int j;
    if ((paramObject2 != null) && ((paramObject2 instanceof CalendarFolderChangeSyncData)))
    {
      paramObject2 = (CalendarFolderChangeSyncData)paramObject2;
      if (localCalendarInfo.accountType == 1)
      {
        int i = this.this$1.val$calendarFolder.getAccountId();
        j = this.this$1.val$calendarFolder.getId();
        this.this$1.this$0.getCalendarFolder(i, j).setOffLineOptType(0);
        paramObject1 = QMCalendarManager.access$1000(this.this$1.this$0).getWritableDatabase();
        paramObject1.beginTransactionNonExclusive();
      }
    }
    else
    {
      try
      {
        QMCalendarManager.access$1000(this.this$1.this$0).updateCalendarFolderOfflineOptType(paramObject1, j, 0);
        QMLog.log(4, "QMCalendarManager", "updateCalendarFolderByProtocolMgr success id:" + this.this$1.val$calendarFolder.getId() + " name:" + this.this$1.val$calendarFolder.getName());
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
      ((CalendarFolderUpdateWatcher)Watchers.of(CalendarFolderUpdateWatcher.class)).onSuccess(j);
    }
    while (localCalendarInfo.accountType != 2) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.11.1
 * JD-Core Version:    0.7.0.1
 */