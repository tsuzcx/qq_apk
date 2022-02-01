package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.model.MailManagerDelegate;

class QMCalendarManager$29
  implements Runnable
{
  QMCalendarManager$29(QMCalendarManager paramQMCalendarManager, QMCalendarEvent paramQMCalendarEvent) {}
  
  public void run()
  {
    int i = this.val$event.getAccountId();
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(i);
    QMCalendarFolder localQMCalendarFolder = this.this$0.getCalendarFolder(i, this.val$event.getCalderFolderId());
    if (localQMCalendarFolder == null) {
      return;
    }
    MailManagerDelegate localMailManagerDelegate = new MailManagerDelegate();
    localMailManagerDelegate.setOnError(new QMCalendarManager.29.1(this));
    localMailManagerDelegate.setOnSuccess(new QMCalendarManager.29.2(this));
    if ((localAccount != null) && (localAccount.isQQMail()) && (this.val$event.isAllDay()) && (this.val$event.getReminder() == 0)) {
      this.val$event.setReminder(-540);
    }
    QMCalendarManager.access$1300(this.this$0).addCalendarEvent(localAccount, localQMCalendarFolder, this.val$event, localMailManagerDelegate);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.29
 * JD-Core Version:    0.7.0.1
 */