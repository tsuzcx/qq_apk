package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.protocol.calendar.CalendarCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class QMCalendarProtocolManager$4
  extends CalendarCallback
{
  QMCalendarProtocolManager$4(QMCalendarProtocolManager paramQMCalendarProtocolManager, CalendarInfo paramCalendarInfo, Account paramAccount, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void onResult(CalendarResult paramCalendarResult)
  {
    QMLog.log(4, "QMCalendarProtocolManager", "updateCalendarFolder ok? " + paramCalendarResult.code);
    Object localObject;
    if (paramCalendarResult.code == 0)
    {
      localObject = null;
      if (this.val$cinfo.accountType == 1)
      {
        paramCalendarResult = QMCalendarProtocolManager.access$000(this.this$0, paramCalendarResult, this.val$account.getId());
        if (this.val$callback != null) {
          this.val$callback.handleSuccess(this.val$cinfo, paramCalendarResult);
        }
      }
    }
    do
    {
      return;
      paramCalendarResult = localObject;
      if (this.val$cinfo.accountType != 2) {
        break;
      }
      paramCalendarResult = localObject;
      break;
      paramCalendarResult = new QMNetworkError(5, paramCalendarResult.code, paramCalendarResult.msg);
    } while (this.val$callback == null);
    this.val$callback.handleError(paramCalendarResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarProtocolManager.4
 * JD-Core Version:    0.7.0.1
 */