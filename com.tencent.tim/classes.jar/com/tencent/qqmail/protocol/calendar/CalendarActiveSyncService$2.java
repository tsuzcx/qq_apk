package com.tencent.qqmail.protocol.calendar;

import com.tencent.qqmail.calendar.model.CalendarResult;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

final class CalendarActiveSyncService$2
  implements QMCallback.IErrorCallback
{
  CalendarActiveSyncService$2(CalendarResult paramCalendarResult, CalendarCallback paramCalendarCallback) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(5, "CalendarActiveSyncService", "login error: " + paramQMNetworkError);
    if (paramQMNetworkError.getCode() == -600) {}
    for (this.val$result.code = 10;; this.val$result.code = 5)
    {
      this.val$result.msg = "network error, cmd: OPTIONS";
      if (this.val$callback != null) {
        this.val$callback.onResult(this.val$result);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.calendar.CalendarActiveSyncService.2
 * JD-Core Version:    0.7.0.1
 */