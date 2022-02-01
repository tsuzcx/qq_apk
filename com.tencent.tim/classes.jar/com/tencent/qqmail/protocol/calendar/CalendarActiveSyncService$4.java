package com.tencent.qqmail.protocol.calendar;

import com.tencent.qqmail.calendar.model.CalendarInfo;
import com.tencent.qqmail.calendar.model.CalendarResult;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

final class CalendarActiveSyncService$4
  implements QMCallback.IErrorCallback
{
  CalendarActiveSyncService$4(String paramString1, CalendarInfo paramCalendarInfo, int paramInt, CalendarResult paramCalendarResult, CalendarCallback paramCalendarCallback, String paramString2) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(5, "CalendarActiveSyncService", this.val$tag + " error: " + paramQMNetworkError);
    if ((paramQMNetworkResponse != null) && (CalendarActiveSyncService.access$300(paramQMNetworkResponse, this.val$info, this.val$cmdType, this.val$finalResult) != 0)) {
      CalendarActiveSyncService.access$200(paramQMNetworkResponse, null, this.val$info, this.val$cmdType, this.val$finalResult, this.val$callback);
    }
    while (this.val$callback == null) {
      return;
    }
    this.val$finalResult.code = 5;
    this.val$finalResult.msg = ("network error, cmd: " + this.val$cmd + ", cmdType: " + this.val$cmdType);
    this.val$callback.onResult(this.val$finalResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.calendar.CalendarActiveSyncService.4
 * JD-Core Version:    0.7.0.1
 */