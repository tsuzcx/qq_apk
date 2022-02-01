package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.data.AddEventReturnData;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.protocol.calendar.CalendarCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.LinkedList;
import org.apache.commons.lang3.StringUtils;

class QMCalendarProtocolManager$6
  extends CalendarCallback
{
  QMCalendarProtocolManager$6(QMCalendarProtocolManager paramQMCalendarProtocolManager, QMCalendarEvent paramQMCalendarEvent, CalendarInfo paramCalendarInfo, Account paramAccount, QMCalendarFolder paramQMCalendarFolder, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void onResult(CalendarResult paramCalendarResult)
  {
    QMLog.log(4, "QMCalendarProtocolManager", "addCalendarEvent : " + this.val$event.getSubject() + "; " + paramCalendarResult.code);
    AddEventReturnData localAddEventReturnData;
    if (paramCalendarResult.code == 0)
    {
      localAddEventReturnData = new AddEventReturnData();
      if (this.val$cinfo.accountType == 1)
      {
        QMCalendarProtocolManager.access$300(this.this$0, this.val$account, paramCalendarResult.activeSyncResult);
        QMCalendarProtocolManager.access$400(this.this$0, this.val$folder, paramCalendarResult.activeSyncResult);
        localAddEventReturnData.setFolderSyncKey(paramCalendarResult.activeSyncResult.syncResult.syncKey);
        paramCalendarResult = paramCalendarResult.activeSyncResult.syncResult.serverIdAddList;
        if ((paramCalendarResult != null) && (paramCalendarResult.size() > 0))
        {
          localAddEventReturnData.setEventSvrId((String)paramCalendarResult.get(0));
          localAddEventReturnData.setEventUid(this.val$event.getUid());
        }
      }
    }
    do
    {
      for (;;)
      {
        if (this.val$callback != null) {
          this.val$callback.handleSuccess(this.val$cinfo, localAddEventReturnData);
        }
        return;
        if (this.val$cinfo.accountType == 2)
        {
          paramCalendarResult = paramCalendarResult.calDavResult;
          if ((paramCalendarResult != null) && (paramCalendarResult.calendarEvent != null))
          {
            paramCalendarResult = paramCalendarResult.calendarEvent;
            String str = paramCalendarResult.uid;
            if (!StringUtils.isBlank(str)) {
              localAddEventReturnData.setEventUid(str);
            }
            str = paramCalendarResult.path_;
            if (!StringUtils.isBlank(str)) {
              localAddEventReturnData.setEventPath(str);
            }
            paramCalendarResult = paramCalendarResult.etag_;
            if (!StringUtils.isBlank(paramCalendarResult)) {
              localAddEventReturnData.seteTag(paramCalendarResult);
            }
          }
        }
      }
      paramCalendarResult = new QMNetworkError(5, paramCalendarResult.code, paramCalendarResult.msg);
    } while (this.val$callback == null);
    this.val$callback.handleError(paramCalendarResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarProtocolManager.6
 * JD-Core Version:    0.7.0.1
 */