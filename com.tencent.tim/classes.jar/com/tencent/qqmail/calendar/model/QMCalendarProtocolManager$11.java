package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.data.CalendarEventSyncData;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.protocol.calendar.CalendarCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class QMCalendarProtocolManager$11
  extends CalendarCallback
{
  QMCalendarProtocolManager$11(QMCalendarProtocolManager paramQMCalendarProtocolManager, Account paramAccount, QMCalendarFolder paramQMCalendarFolder, CalendarInfo paramCalendarInfo, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void onResult(CalendarResult paramCalendarResult)
  {
    QMLog.log(4, "QMCalendarProtocolManager", "loadMultiCalendarEvent result " + paramCalendarResult.code);
    if ((paramCalendarResult.code == 0) || (paramCalendarResult.code == 3))
    {
      ArrayList localArrayList = new ArrayList();
      CalendarEventSyncData localCalendarEventSyncData = new CalendarEventSyncData();
      localCalendarEventSyncData.setAccountId(this.val$account.getId());
      localCalendarEventSyncData.setModifyEventList(localArrayList);
      localCalendarEventSyncData.setCalendarFolderId(this.val$folder.getId());
      if (this.val$cinfo.accountType == 2)
      {
        paramCalendarResult = paramCalendarResult.calDavResult.updateList;
        if ((paramCalendarResult != null) && (paramCalendarResult.size() > 0))
        {
          paramCalendarResult = paramCalendarResult.iterator();
          while (paramCalendarResult.hasNext())
          {
            CCalendar localCCalendar = (CCalendar)paramCalendarResult.next();
            localArrayList.add(this.this$0.getEventFromProtocolData(this.val$account.getId(), this.val$folder.getId(), this.val$folder.getCategory(), localCCalendar, this.val$cinfo.accountType));
          }
        }
      }
      this.val$callback.handleSuccess(this.val$cinfo, localCalendarEventSyncData);
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
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarProtocolManager.11
 * JD-Core Version:    0.7.0.1
 */