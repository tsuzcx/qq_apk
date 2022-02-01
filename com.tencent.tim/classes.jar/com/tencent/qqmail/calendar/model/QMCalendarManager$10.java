package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.model.MailManagerDelegate;

class QMCalendarManager$10
  implements Runnable
{
  QMCalendarManager$10(QMCalendarManager paramQMCalendarManager, QMCalendarFolder paramQMCalendarFolder) {}
  
  public void run()
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(this.val$calendarFolder.getAccountId());
    MailManagerDelegate localMailManagerDelegate = new MailManagerDelegate();
    localMailManagerDelegate.setOnSuccess(new QMCalendarManager.10.1(this));
    localMailManagerDelegate.setOnError(new QMCalendarManager.10.2(this));
    QMCalendarManager.access$1300(this.this$0).removeCalendarFolder(localAccount, this.val$calendarFolder, localMailManagerDelegate);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.10
 * JD-Core Version:    0.7.0.1
 */