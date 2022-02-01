package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.data.CalendarFolderSyncData;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.protocol.calendar.CalendarCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class QMCalendarProtocolManager$5
  extends CalendarCallback
{
  QMCalendarProtocolManager$5(QMCalendarProtocolManager paramQMCalendarProtocolManager, CalendarInfo paramCalendarInfo, Account paramAccount, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void onResult(CalendarResult paramCalendarResult)
  {
    QMLog.log(4, "QMCalendarProtocolManager", "loadFolderList ok? " + paramCalendarResult.code);
    CalendarFolderSyncData localCalendarFolderSyncData;
    if (paramCalendarResult.code == 0)
    {
      localCalendarFolderSyncData = null;
      if (this.val$cinfo.accountType != 1) {}
    }
    do
    {
      localCalendarFolderSyncData = QMCalendarProtocolManager.access$100(this.this$0, paramCalendarResult, this.val$account.getId());
      for (;;)
      {
        if (this.val$callback != null) {
          this.val$callback.handleSuccess(this.val$cinfo, localCalendarFolderSyncData);
        }
        return;
        if (this.val$cinfo.accountType == 2) {
          localCalendarFolderSyncData = QMCalendarProtocolManager.access$200(this.this$0, paramCalendarResult, this.val$account.getId());
        }
      }
      paramCalendarResult = new QMNetworkError(5, paramCalendarResult.code, paramCalendarResult.msg);
    } while (this.val$callback == null);
    this.val$callback.handleError(paramCalendarResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarProtocolManager.5
 * JD-Core Version:    0.7.0.1
 */