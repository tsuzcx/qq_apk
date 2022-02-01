package com.tencent.qqmail.calendar.model;

import android.util.Log;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.calendar.data.CalendarFolderChangeSyncData;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.sqlite.QMCalendarSQLiteHelper;
import com.tencent.qqmail.calendar.watcher.CalendarFolderCreateWatcher;
import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import moai.core.watcher.Watchers;

class QMCalendarManager$9$1
  implements MailManagerDelegate.DataCallback
{
  QMCalendarManager$9$1(QMCalendarManager.9 param9) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    CalendarInfo localCalendarInfo = (CalendarInfo)paramObject1;
    CalendarFolderChangeSyncData localCalendarFolderChangeSyncData;
    int j;
    QMCalendarFolder localQMCalendarFolder;
    if ((paramObject2 != null) && ((paramObject2 instanceof CalendarFolderChangeSyncData)))
    {
      localCalendarFolderChangeSyncData = (CalendarFolderChangeSyncData)paramObject2;
      if (localCalendarInfo.accountType == 1)
      {
        int i = this.this$1.val$calendarFolder.getAccountId();
        j = this.this$1.val$calendarFolder.getId();
        paramObject2 = localCalendarFolderChangeSyncData.getFolder();
        localQMCalendarFolder = this.this$1.this$0.getCalendarFolder(i, j);
        localQMCalendarFolder.setCollectionId(paramObject2.getCollectionId());
        localQMCalendarFolder.setSyncKey(paramObject2.getSyncKey());
        localQMCalendarFolder.setOffLineOptType(0);
        localQMCalendarFolder.setId(QMCalendarFolder.generateId(localQMCalendarFolder));
        QMCalendarManager.access$800(this.this$1.this$0, i, j);
        QMCalendarManager.access$900(this.this$1.this$0, localQMCalendarFolder);
        paramObject1 = QMCalendarManager.access$1000(this.this$1.this$0).getWritableDatabase();
        paramObject1.beginTransactionNonExclusive();
      }
    }
    else
    {
      try
      {
        QMCalendarManager.access$1000(this.this$1.this$0).deleteCalendarFolder(paramObject1, j);
        QMCalendarManager.access$1000(this.this$1.this$0).insertCalendarFolder(paramObject1, localQMCalendarFolder);
        QMLog.log(4, "QMCalendarManager", "addCalendarFolderByProtocolMgr success id:" + localQMCalendarFolder.getId() + " name:" + localQMCalendarFolder.getName());
        QMCalendarManager.access$1100(this.this$1.this$0, paramObject1, localCalendarFolderChangeSyncData, localCalendarInfo.accountType);
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
      QMCalendarManager.access$200(this.this$1.this$0).resetScheduleCache();
      QMCalendarManager.access$1200(this.this$1.this$0).updateRemindersInBackground();
      ((CalendarFolderCreateWatcher)Watchers.of(CalendarFolderCreateWatcher.class)).onSuccess(j, paramObject2.getId());
    }
    while (localException.accountType != 2) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.9.1
 * JD-Core Version:    0.7.0.1
 */