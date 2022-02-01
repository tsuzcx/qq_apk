package com.tencent.qqmail.protocol.calendar;

import com.tencent.qqmail.calendar.model.ActiveSyncInfo;
import com.tencent.qqmail.calendar.model.CalendarInfo;
import com.tencent.qqmail.calendar.model.CalendarResult;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.List;
import java.util.Map;

final class CalendarActiveSyncService$1
  implements QMCallback.ISuccessCallback
{
  CalendarActiveSyncService$1(CalendarInfo paramCalendarInfo, CalendarResult paramCalendarResult, CalendarCallback paramCalendarCallback) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    paramQMNetworkRequest = paramQMNetworkResponse.getResponseHeaders();
    QMLog.log(4, "CalendarActiveSyncService", "login success, response headers: " + paramQMNetworkRequest);
    paramQMNetworkResponse = (List)paramQMNetworkRequest.get("MS-ASProtocolVersions");
    if ((paramQMNetworkResponse != null) && (paramQMNetworkResponse.size() > 0))
    {
      paramQMNetworkResponse = ((String)paramQMNetworkResponse.get(0)).split(",");
      paramQMNetworkResponse = paramQMNetworkResponse[(paramQMNetworkResponse.length - 1)];
      this.val$info.activeSyncInfo.setActiveSyncVersion(paramQMNetworkResponse);
      this.val$result.activeSyncResult.protocolVersion = paramQMNetworkResponse;
      this.val$result.activeSyncResult.serverAddr = this.val$info.activeSyncInfo.getActiveSyncServer();
      this.val$result.activeSyncResult.update_account_ = true;
    }
    paramQMNetworkRequest = (List)paramQMNetworkRequest.get("MS-ASProtocolCommands");
    if (paramQMNetworkRequest == null)
    {
      paramQMNetworkRequest = null;
      if (paramQMNetworkRequest == null) {
        break label254;
      }
      int j = paramQMNetworkRequest.length;
      i = 0;
      label159:
      if (i >= j) {
        break label254;
      }
      if (!"Provision".equals(paramQMNetworkRequest[i])) {
        break label242;
      }
    }
    label242:
    label254:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {}
      for (i = 9;; i = 2)
      {
        if ((!CalendarActiveSyncService.access$000(this.val$info, i, this.val$result, this.val$callback)) && (this.val$callback != null)) {
          this.val$callback.onResult(this.val$result);
        }
        return;
        paramQMNetworkRequest = ((String)paramQMNetworkRequest.get(0)).split(",");
        break;
        i += 1;
        break label159;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.calendar.CalendarActiveSyncService.1
 * JD-Core Version:    0.7.0.1
 */