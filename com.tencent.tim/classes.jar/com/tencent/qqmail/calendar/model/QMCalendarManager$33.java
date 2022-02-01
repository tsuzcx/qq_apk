package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;

class QMCalendarManager$33
  implements Runnable
{
  QMCalendarManager$33(QMCalendarManager paramQMCalendarManager, long paramLong) {}
  
  public void run()
  {
    QMCalendarEvent localQMCalendarEvent = this.this$0.getCalendarEventById(this.val$calendarId);
    int i = localQMCalendarEvent.getAccountId();
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(i);
    QMCalendarFolder localQMCalendarFolder = this.this$0.getCalendarFolder(i, localQMCalendarEvent.getCalderFolderId());
    QMCalendarManager.access$1800(this.this$0, localAccount, localQMCalendarFolder, localQMCalendarEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.33
 * JD-Core Version:    0.7.0.1
 */