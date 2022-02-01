package com.tencent.qqmail.calendar.model;

import android.util.Log;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.data.QMCalendarShare;
import com.tencent.qqmail.calendar.sqlite.QMCalendarSQLiteHelper;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import org.apache.commons.lang3.StringUtils;

class QMCalendarManager$12$2
  implements MailManagerDelegate.DataCallback
{
  QMCalendarManager$12$2(QMCalendarManager.12 param12) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    int i = 0;
    QMLog.log(4, "QMCalendarManager", "shareCalendarFolder success folder:" + this.this$1.val$calendarFolder.getName() + " email:" + StringUtils.join(this.this$1.val$emails, "^"));
    paramObject1 = QMCalendarManager.access$1000(this.this$1.this$0).getWritableDatabase();
    paramObject2 = QMCalendarManager.access$1000(this.this$1.this$0).getReadableDatabase();
    for (;;)
    {
      try
      {
        paramObject1.beginTransaction();
        String[] arrayOfString = this.this$1.val$emails;
        int j = arrayOfString.length;
        if (i < j)
        {
          String str = arrayOfString[i];
          QMCalendarShare localQMCalendarShare = new QMCalendarShare();
          localQMCalendarShare.setCalendarFolderId(this.this$1.val$calendarFolder.getId());
          localQMCalendarShare.setEmail(str);
          localQMCalendarShare.setName(str);
          localQMCalendarShare.setState(0);
          localQMCalendarShare.setId(QMCalendarShare.generateId(localQMCalendarShare.getCalendarFolderId(), localQMCalendarShare.getEmail()));
          if (QMCalendarManager.access$1000(this.this$1.this$0).isExistShare(paramObject2, localQMCalendarShare.getId())) {
            break label316;
          }
          QMCalendarManager.access$1000(this.this$1.this$0).insertShare(paramObject1, localQMCalendarShare);
          break label316;
        }
        paramObject1.setTransactionSuccessful();
      }
      catch (Exception paramObject2)
      {
        QMLog.log(6, "QMCalendarManager", Log.getStackTraceString(paramObject2));
        paramObject1.endTransaction();
        continue;
      }
      finally
      {
        paramObject1.endTransaction();
      }
      paramObject1 = AccountManager.shareInstance().getAccountList().getAccountById(this.this$1.val$calendarFolder.getAccountId());
      paramObject2 = new MailManagerDelegate();
      paramObject2.setOnSuccess(new QMCalendarManager.12.2.1(this));
      paramObject2.setOnError(new QMCalendarManager.12.2.2(this));
      this.this$1.this$0.syncCalendarAfterSync(paramObject1, paramObject2);
      return;
      label316:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.12.2
 * JD-Core Version:    0.7.0.1
 */