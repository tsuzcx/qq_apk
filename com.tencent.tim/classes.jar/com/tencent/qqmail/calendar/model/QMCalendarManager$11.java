package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.model.MailManagerDelegate;

class QMCalendarManager$11
  implements Runnable
{
  QMCalendarManager$11(QMCalendarManager paramQMCalendarManager, QMCalendarFolder paramQMCalendarFolder) {}
  
  public void run()
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(this.val$calendarFolder.getAccountId());
    MailManagerDelegate localMailManagerDelegate = new MailManagerDelegate();
    localMailManagerDelegate.setOnSuccess(new QMCalendarManager.11.1(this));
    localMailManagerDelegate.setOnError(new QMCalendarManager.11.2(this));
    QMCalendarManager.access$1300(this.this$0).updateCalendarFolder(localAccount, this.val$calendarFolder, false, null, null, null, localMailManagerDelegate);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.11
 * JD-Core Version:    0.7.0.1
 */