package com.tencent.qqmail.calendar.model;

import android.util.Log;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.data.CalendarEventSyncData;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.reminder.QMReminderer;
import com.tencent.qqmail.calendar.sqlite.QMCalendarSQLiteHelper;
import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

class QMCalendarManager$26
  implements MailManagerDelegate.DataCallback
{
  QMCalendarManager$26(QMCalendarManager paramQMCalendarManager, QMCalendarFolder paramQMCalendarFolder, String paramString, Account paramAccount, QMCalendarManager.ILoadEventListCallback paramILoadEventListCallback) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    QMLog.log(4, "QMCalendarManager", "loadEventList success folderId:" + this.val$folder.getId() + " name:" + this.val$folder.getName());
    RequestFilter.resetRequestRunningState(this.val$req);
    CalendarInfo localCalendarInfo = (CalendarInfo)paramObject1;
    Object localObject1 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    CalendarEventSyncData localCalendarEventSyncData;
    ArrayList localArrayList2;
    String[] arrayOfString;
    SQLiteDatabase localSQLiteDatabase;
    if ((paramObject2 != null) && ((paramObject2 instanceof CalendarEventSyncData)))
    {
      localCalendarEventSyncData = (CalendarEventSyncData)paramObject2;
      paramObject1 = localCalendarEventSyncData.getAddEventList();
      localArrayList2 = localCalendarEventSyncData.getModifyEventList();
      arrayOfString = localCalendarEventSyncData.getRemoveEventList();
      k = 0;
      i = 0;
      localSQLiteDatabase = QMCalendarManager.access$1000(this.this$0).getWritableDatabase();
      localSQLiteDatabase.beginTransactionNonExclusive();
      j = i;
      if (paramObject1 != null)
      {
        j = i;
        paramObject2 = localObject3;
        i = k;
      }
    }
    int n;
    int m;
    try
    {
      if (paramObject1.size() > 0)
      {
        n = 1;
        m = 1;
        paramObject2 = localObject3;
        i = n;
        QMCalendarManager.access$1000(this.this$0).deleteEventsByUidAndAccount(localSQLiteDatabase, paramObject1);
        k = 0;
        for (;;)
        {
          j = m;
          paramObject2 = localObject3;
          i = n;
          if (k >= paramObject1.size()) {
            break;
          }
          paramObject2 = localObject3;
          i = n;
          QMCalendarEvent localQMCalendarEvent = (QMCalendarEvent)paramObject1.get(k);
          paramObject2 = localObject3;
          i = n;
          QMCalendarManager.access$1000(this.this$0).insertCalendarEvent(localSQLiteDatabase, localQMCalendarEvent);
          paramObject2 = localObject3;
          i = n;
          QMCalendarManager.access$200(this.this$0).createAndSaveSchedule(localQMCalendarEvent);
          paramObject2 = localObject3;
          i = n;
          QMCalendarManager.access$1200(this.this$0).createRemindersByEvent(localQMCalendarEvent);
          k += 1;
        }
      }
      paramObject1 = localObject1;
      k = j;
      if (localArrayList2 == null) {
        break label729;
      }
      paramObject2 = localObject3;
      i = j;
      paramObject1 = localObject1;
      k = j;
      if (localArrayList2.size() <= 0) {
        break label729;
      }
      n = 1;
      m = 1;
      paramObject2 = localObject3;
      i = m;
      localObject1 = localObject4;
      if (localCalendarInfo.accountType != 2) {
        break label1174;
      }
      paramObject2 = localObject3;
      i = m;
      localObject1 = new String[localArrayList2.size()];
    }
    catch (Exception localException1)
    {
      paramObject1 = paramObject2;
      QMLog.log(6, "QMCalendarManager", Log.getStackTraceString(localException1));
      localSQLiteDatabase.endTransaction();
      if ((localCalendarInfo.accountType != 2) || (paramObject1 == null) || (paramObject1.length <= 0)) {
        break label1120;
      }
      QMCalendarManager.access$1600(this.this$0, paramObject1, this.val$folder, this.val$account);
      if (localCalendarEventSyncData.getReturnCode() != 0) {
        break label665;
      }
      QMWatcherCenter.triggerCalendarLoadEventSuccess(this.val$account.getId(), this.val$folder.getId());
      if (this.val$callback == null) {
        break label665;
      }
      this.val$callback.onComplete(this.val$folder.getId());
      return;
      paramObject2 = localException1;
      i = m;
      long l = QMCalendarManager.access$1000(this.this$0).getEventIdBySvrIdAndAccountId(localSQLiteDatabase, paramObject1.getSvrId(), paramObject1.getAccountId());
      paramObject2 = localException1;
      i = m;
      QMCalendarManager.access$1000(this.this$0).updateAttendeeStatus(localSQLiteDatabase, paramObject1.getAttendees(), l);
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    paramObject2 = localObject1;
    int i = m;
    paramObject1 = localObject1;
    int k = n;
    if (j < localArrayList2.size())
    {
      paramObject2 = localObject1;
      i = m;
      paramObject1 = (QMCalendarEvent)localArrayList2.get(j);
      paramObject2 = localObject1;
      i = m;
      if (localCalendarInfo.accountType == 2)
      {
        paramObject2 = localObject1;
        i = m;
        localObject1[j] = paramObject1.getPath();
        break label1180;
      }
      paramObject2 = localObject1;
      i = m;
      if (paramObject1.getUid() != null)
      {
        paramObject2 = localObject1;
        i = m;
        if (paramObject1.getUid().length() > 0)
        {
          paramObject2 = localObject1;
          i = m;
          QMCalendarManager.access$1000(this.this$0).updateEventAfterSync(localSQLiteDatabase, paramObject1);
          paramObject2 = localObject1;
          i = m;
          QMLog.log(4, "QMCalendarManager", "loadEventList update id:" + paramObject1.getId() + " name:" + paramObject1.getSubject());
          paramObject2 = localObject1;
          i = m;
          QMCalendarManager.access$200(this.this$0).createAndSaveSchedule(paramObject1);
          paramObject2 = localObject1;
          i = m;
          QMCalendarManager.access$1200(this.this$0).createRemindersByEvent(paramObject1);
          break label1180;
        }
      }
    }
    label617:
    int j = k;
    label665:
    label729:
    if (arrayOfString != null)
    {
      paramObject2 = paramObject1;
      i = k;
      j = k;
      if (arrayOfString.length > 0)
      {
        n = 1;
        m = 1;
        k = 0;
      }
    }
    for (;;)
    {
      paramObject2 = paramObject1;
      i = m;
      j = n;
      ArrayList localArrayList1;
      if (k < arrayOfString.length)
      {
        paramObject2 = paramObject1;
        i = m;
        if (StringUtils.isBlank(arrayOfString[k])) {
          break label1189;
        }
        paramObject2 = paramObject1;
        i = m;
        if (localCalendarInfo.accountType == 1)
        {
          paramObject2 = paramObject1;
          i = m;
          localArrayList1 = QMCalendarManager.access$1000(this.this$0).getEventIdsBySvrId(QMCalendarManager.access$1000(this.this$0).getReadableDatabase(), arrayOfString[k]);
        }
      }
      for (;;)
      {
        for (;;)
        {
          if (localArrayList1 == null) {
            break label1189;
          }
          paramObject2 = paramObject1;
          i = m;
          if (localArrayList1.size() <= 0) {
            break label1189;
          }
          j = 0;
          for (;;)
          {
            paramObject2 = paramObject1;
            i = m;
            if (j >= localArrayList1.size()) {
              break;
            }
            paramObject2 = paramObject1;
            i = m;
            QMCalendarManager.access$1000(this.this$0).deleteEvent(localSQLiteDatabase, ((Long)localArrayList1.get(j)).longValue());
            paramObject2 = paramObject1;
            i = m;
            QMLog.log(4, "QMCalendarManager", "loadEventList delete id:" + localArrayList1.get(j));
            j += 1;
          }
          paramObject2 = paramObject1;
          i = m;
          if (localCalendarInfo.accountType != 2) {
            break label1168;
          }
          paramObject2 = paramObject1;
          i = m;
          localArrayList1 = QMCalendarManager.access$1000(this.this$0).getEventIdsByPath(QMCalendarManager.access$1000(this.this$0).getReadableDatabase(), arrayOfString[k]);
          continue;
          i = j;
          try
          {
            if ((localCalendarInfo.accountType == 1) && (!StringUtils.isEmpty(localCalendarEventSyncData.getCalendarFolderSyncKey()))) {
              this.this$0.updateFolderSyncKey(this.val$account.getId(), this.val$folder.getId(), localCalendarEventSyncData.getCalendarFolderSyncKey());
            }
            for (;;)
            {
              localSQLiteDatabase.setTransactionSuccessful();
              localSQLiteDatabase.endTransaction();
              break;
              if ((localCalendarInfo.accountType == 2) && (!StringUtils.isEmpty(localCalendarEventSyncData.getCalendarFolderSyncToken()))) {
                this.this$0.updateFolderSyncToken(this.val$account.getId(), this.val$folder.getId(), localCalendarEventSyncData.getCalendarFolderSyncToken());
              }
            }
          }
          catch (Exception localException2) {}
        }
        label1120:
        if ((localCalendarInfo.accountType != 1) || (i == 0)) {
          break label617;
        }
        QMCalendarManager.access$200(this.this$0).resetScheduleCache();
        QMCalendarManager.access$1200(this.this$0).updateRemindersInBackground();
        this.this$0.triggerUpdateSchedule(null, 0L);
        QMReminderer.reDeploySentinel();
        break label617;
        label1168:
        Object localObject2 = null;
        continue;
        label1174:
        j = 0;
        break;
        label1180:
        j += 1;
        break;
      }
      label1189:
      k += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.26
 * JD-Core Version:    0.7.0.1
 */