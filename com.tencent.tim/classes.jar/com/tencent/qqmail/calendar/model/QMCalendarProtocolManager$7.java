package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.protocol.calendar.CalendarCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class QMCalendarProtocolManager$7
  extends CalendarCallback
{
  QMCalendarProtocolManager$7(QMCalendarProtocolManager paramQMCalendarProtocolManager, CalendarInfo paramCalendarInfo, Account paramAccount, QMCalendarFolder paramQMCalendarFolder, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void onResult(CalendarResult paramCalendarResult)
  {
    QMLog.log(4, "QMCalendarProtocolManager", "removeEvent ok? " + paramCalendarResult.code);
    if (paramCalendarResult.code == 0)
    {
      if (this.val$cinfo.accountType == 1)
      {
        QMCalendarProtocolManager.access$300(this.this$0, this.val$account, paramCalendarResult.activeSyncResult);
        QMCalendarProtocolManager.access$400(this.this$0, this.val$folder, paramCalendarResult.activeSyncResult);
      }
      if (this.val$callback != null) {
        this.val$callback.handleSuccess(null, null);
      }
    }
    do
    {
      return;
      paramCalendarResult = new QMNetworkError(5, paramCalendarResult.code, paramCalendarResult.msg);
    } while (this.val$callback == null);
    this.val$callback.handleError(paramCalendarResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarProtocolManager.7
 * JD-Core Version:    0.7.0.1
 */