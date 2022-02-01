package com.tencent.qqmail.protocol.calendar;

import com.tencent.qqmail.calendar.model.CalendarInfo;
import com.tencent.qqmail.calendar.model.CalendarResult;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

final class CalendarActiveSyncService$3
  implements QMCallback.ISuccessCallback
{
  CalendarActiveSyncService$3(String paramString, CalendarInfo paramCalendarInfo, int paramInt, CalendarResult paramCalendarResult, CalendarCallback paramCalendarCallback) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    QMLog.log(4, "CalendarActiveSyncService", this.val$tag + " success, response headers: " + paramQMNetworkResponse.getResponseHeaders());
    paramQMNetworkRequest = paramQMNetworkResponse.getResponseData();
    if ((paramQMNetworkRequest != null) && (paramQMNetworkRequest.length > 0)) {
      CalendarActiveSyncService.access$200(paramQMNetworkResponse, CalendarActiveSyncService.access$100(paramQMNetworkRequest), this.val$info, this.val$cmdType, this.val$finalResult, this.val$callback);
    }
    while (this.val$callback == null) {
      return;
    }
    this.val$callback.onResult(this.val$finalResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.calendar.CalendarActiveSyncService.3
 * JD-Core Version:    0.7.0.1
 */