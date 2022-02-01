package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;

class QMCalendarManager$30
  implements Runnable
{
  QMCalendarManager$30(QMCalendarManager paramQMCalendarManager, QMCalendarEvent paramQMCalendarEvent) {}
  
  public void run()
  {
    int i = this.val$event.getAccountId();
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(i);
    QMCalendarFolder localQMCalendarFolder = this.this$0.getCalendarFolder(i, this.val$event.getCalderFolderId());
    QMCalendarManager.access$1700(this.this$0, localAccount, localQMCalendarFolder, this.val$event);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.30
 * JD-Core Version:    0.7.0.1
 */