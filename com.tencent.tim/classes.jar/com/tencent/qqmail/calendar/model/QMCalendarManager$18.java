package com.tencent.qqmail.calendar.model;

import android.util.Log;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.sqlite.QMCalendarSQLiteHelper;
import com.tencent.qqmail.utilities.log.QMLog;

class QMCalendarManager$18
  implements Runnable
{
  QMCalendarManager$18(QMCalendarManager paramQMCalendarManager, Account paramAccount, boolean paramBoolean) {}
  
  public void run()
  {
    int j = 1;
    for (;;)
    {
      int i;
      try
      {
        CalendarAccountConfig localCalendarAccountConfig = QMCalendarManager.access$1300(this.this$0).getAccountConfig(this.val$account.getId());
        if (localCalendarAccountConfig == null) {
          return;
        }
        if (System.currentTimeMillis() - localCalendarAccountConfig.getRefreshTime() >= 5000L)
        {
          i = j;
          if ((i == 0) && (!this.val$force)) {
            break;
          }
          QMCalendarManager.access$1500(this.this$0, this.val$account, localCalendarAccountConfig, null);
          localCalendarAccountConfig.setRefreshTime(System.currentTimeMillis());
          QMCalendarManager.access$1000(this.this$0).updateConfigRefreshTime(QMCalendarManager.access$1000(this.this$0).getWritableDatabase(), localCalendarAccountConfig);
          return;
        }
      }
      catch (Exception localException)
      {
        QMLog.log(6, "QMCalendarManager", Log.getStackTraceString(localException));
        return;
      }
      if (!QMCalendarManager.access$1400(this.this$0).hasFolders(this.val$account.getId()))
      {
        i = j;
        if (!this.val$account.isQQMail())
        {
          boolean bool = this.val$account.isTencentDotCom();
          i = j;
          if (bool) {}
        }
      }
      else
      {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.18
 * JD-Core Version:    0.7.0.1
 */