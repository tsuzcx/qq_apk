package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.protocol.calendar.CalendarCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class QMCalendarProtocolManager$9
  extends CalendarCallback
{
  QMCalendarProtocolManager$9(QMCalendarProtocolManager paramQMCalendarProtocolManager, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void onResult(CalendarResult paramCalendarResult)
  {
    QMLog.log(4, "QMCalendarProtocolManager", "updateActiveSyncAppointmentStatus ok? " + paramCalendarResult.code);
    if (paramCalendarResult.code == 0) {
      if (this.val$callback != null) {
        this.val$callback.handleSuccess(paramCalendarResult, null);
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
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarProtocolManager.9
 * JD-Core Version:    0.7.0.1
 */