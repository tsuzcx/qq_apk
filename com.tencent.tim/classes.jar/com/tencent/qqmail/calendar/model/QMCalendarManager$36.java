package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.MailManagerDelegate.MailErrorCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.Set;

class QMCalendarManager$36
  implements MailManagerDelegate.MailErrorCallback
{
  QMCalendarManager$36(QMCalendarManager paramQMCalendarManager, Account paramAccount, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(Object paramObject)
  {
    boolean bool = QMCalendarManager.access$1900(this.this$0).remove(Integer.valueOf(this.val$account.getId()));
    QMLog.log(6, "QMCalendarManager", "calendar login error email:" + this.val$account.getEmail() + " cancel:" + bool);
    if ((!bool) && (this.val$callback != null)) {
      this.val$callback.handleError(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.36
 * JD-Core Version:    0.7.0.1
 */