package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.sqlite.QMCalendarSQLiteHelper;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.Map;
import java.util.Set;

class QMCalendarManager$37
  implements MailManagerDelegate.DataCallback
{
  QMCalendarManager$37(QMCalendarManager paramQMCalendarManager, Account paramAccount, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    boolean bool = QMCalendarManager.access$1900(this.this$0).remove(Integer.valueOf(this.val$account.getId()));
    QMLog.log(4, "QMCalendarManager", "calendar login success email:" + this.val$account.getEmail() + " cancel:" + bool);
    if (!bool)
    {
      paramObject1 = (CalendarAccountConfig)paramObject1;
      paramObject2 = (CalendarInfo)paramObject2;
      QMCalendarManager.access$1000(this.this$0).insertCalendarAccountConfig(QMCalendarManager.access$1000(this.this$0).getWritableDatabase(), paramObject1);
      paramObject1.initFromProfileString(paramObject1.getProfileString());
      if ((this.val$account.getProtocol() != 14) || (paramObject2.accountType != 1)) {
        break label214;
      }
      paramObject1 = this.this$0.getCalendarFoldersByAccountId(this.val$account.getId());
      if ((paramObject1 == null) || (paramObject1.isEmpty())) {
        QMCalendarManager.access$2000(this.this$0, this.val$account, this.val$callback);
      }
    }
    for (;;)
    {
      this.this$0.openDefaultAccount(this.val$account);
      if (this.val$callback != null) {
        this.val$callback.handleSuccess(this.val$account, null);
      }
      QMMailManager.sharedInstance().setNotifyCalendarReminderMail(this.val$account.getId(), false);
      return;
      label214:
      this.this$0.loadCalendarFolders(this.val$account, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.37
 * JD-Core Version:    0.7.0.1
 */