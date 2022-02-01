package com.tencent.qqmail.calendar.model;

import android.util.Log;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.data.QMCalendarShare;
import com.tencent.qqmail.calendar.sqlite.QMCalendarSQLiteHelper;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;
import com.tencent.qqmail.utilities.log.QMLog;

class QMCalendarManager$15$1
  implements MailManagerDelegate.DataCallback
{
  QMCalendarManager$15$1(QMCalendarManager.15 param15, Account paramAccount) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    QMLog.log(4, "QMCalendarManager", "stopShareCalendarFolder success folder:" + this.this$1.val$calendarFolder.getName() + " email:" + this.this$1.val$email);
    paramObject1 = QMCalendarManager.access$1000(this.this$1.this$0).getWritableDatabase();
    try
    {
      paramObject1.beginTransaction();
      paramObject2 = new QMCalendarShare();
      paramObject2.setCalendarFolderId(this.this$1.val$calendarFolder.getId());
      paramObject2.setEmail(this.this$1.val$email);
      paramObject2.setName(this.this$1.val$email);
      paramObject2.setState(0);
      paramObject2.setId(QMCalendarShare.generateId(paramObject2.getCalendarFolderId(), paramObject2.getEmail()));
      QMCalendarManager.access$1000(this.this$1.this$0).deleteShare(paramObject1, paramObject2.getId());
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
    paramObject1 = new MailManagerDelegate();
    paramObject1.setOnSuccess(new QMCalendarManager.15.1.1(this));
    paramObject1.setOnError(new QMCalendarManager.15.1.2(this));
    this.this$1.this$0.syncCalendarAfterSync(this.val$account, paramObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.15.1
 * JD-Core Version:    0.7.0.1
 */