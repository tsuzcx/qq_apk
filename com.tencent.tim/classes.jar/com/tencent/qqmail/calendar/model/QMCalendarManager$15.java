package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.sqlite.QMCalendarSQLiteHelper;
import com.tencent.qqmail.calendar.watcher.CalendarStopShareWatcher;
import com.tencent.qqmail.model.MailManagerDelegate;
import java.util.ArrayList;
import moai.core.watcher.Watchers;

class QMCalendarManager$15
  implements Runnable
{
  QMCalendarManager$15(QMCalendarManager paramQMCalendarManager, QMCalendarFolder paramQMCalendarFolder, String paramString) {}
  
  public void run()
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(this.val$calendarFolder.getAccountId());
    ((CalendarStopShareWatcher)Watchers.of(CalendarStopShareWatcher.class)).onProcess(this.val$calendarFolder.getId(), this.val$email);
    MailManagerDelegate localMailManagerDelegate = new MailManagerDelegate();
    localMailManagerDelegate.setOnSuccess(new QMCalendarManager.15.1(this, localAccount));
    localMailManagerDelegate.setOnError(new QMCalendarManager.15.2(this));
    ArrayList localArrayList = QMCalendarManager.access$1000(this.this$0).getShareListByEmails(QMCalendarManager.access$1000(this.this$0).getReadableDatabase(), this.val$calendarFolder.getId(), this.val$email);
    QMCalendarManager.access$1300(this.this$0).updateCalendarFolder(localAccount, this.val$calendarFolder, true, null, null, localArrayList, localMailManagerDelegate);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.15
 * JD-Core Version:    0.7.0.1
 */