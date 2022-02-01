package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.MailManagerDelegate.EventCallback;
import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.utilities.log.QMLog;

class QMCalendarManager$6
  implements MailManagerDelegate.EventCallback
{
  QMCalendarManager$6(QMCalendarManager paramQMCalendarManager, Account paramAccount, String paramString) {}
  
  public void run(Object paramObject)
  {
    QMLog.log(4, "QMCalendarManager", "loadCalendarFolders complete account:" + this.val$account.getEmail());
    RequestFilter.resetRequestRunningState(this.val$req);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.6
 * JD-Core Version:    0.7.0.1
 */