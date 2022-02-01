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

class QMCalendarProtocolManager$10
  extends CalendarCallback
{
  QMCalendarProtocolManager$10(QMCalendarProtocolManager paramQMCalendarProtocolManager, Account paramAccount, CalendarInfo paramCalendarInfo, QMCalendarFolder paramQMCalendarFolder, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void onResult(CalendarResult paramCalendarResult)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    QMLog.log(4, "QMCalendarProtocolManager", " loadCalendarEventList ok? " + paramCalendarResult.code);
    CalendarEventSyncData localCalendarEventSyncData;
    Object localObject3;
    if ((paramCalendarResult.code == 0) || (paramCalendarResult.code == 3))
    {
      localCalendarEventSyncData = new CalendarEventSyncData();
      localCalendarEventSyncData.setReturnCode(paramCalendarResult.code);
      localCalendarEventSyncData.setAccountId(this.val$account.getId());
      if (this.val$cinfo.accountType == 1)
      {
        if (paramCalendarResult.activeSyncResult == null) {
          break label772;
        }
        QMCalendarProtocolManager.access$300(this.this$0, this.val$account, paramCalendarResult.activeSyncResult);
        QMCalendarProtocolManager.access$400(this.this$0, this.val$folder, paramCalendarResult.activeSyncResult);
        localObject3 = paramCalendarResult.activeSyncResult.syncResult;
        if (localObject3 == null) {
          break label785;
        }
        localCalendarEventSyncData.setCalendarFolderSyncKey(((CActiveSyncSyncResult)localObject3).syncKey);
        QMLog.log(4, "QMCalendarProtocolManager", "update list syncKey : " + ((CActiveSyncSyncResult)localObject3).syncKey);
        paramCalendarResult = ((CActiveSyncSyncResult)localObject3).addList;
        localObject1 = ((CActiveSyncSyncResult)localObject3).updateList;
        localObject2 = ((CActiveSyncSyncResult)localObject3).deleteList;
      }
    }
    for (;;)
    {
      localObject3 = paramCalendarResult;
      paramCalendarResult = (CalendarResult)localObject2;
      localObject2 = localObject3;
      for (;;)
      {
        if ((localObject2 != null) && (((LinkedList)localObject2).size() > 0))
        {
          QMLog.log(4, "QMCalendarProtocolManager", "LoadCalendarEventList add : " + this.val$account.getEmail() + "; " + this.val$folder.getName() + "; " + ((LinkedList)localObject2).size());
          localObject3 = new ArrayList();
          localCalendarEventSyncData.setAddEventList((ArrayList)localObject3);
          localObject2 = ((LinkedList)localObject2).iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              CCalendar localCCalendar = (CCalendar)((Iterator)localObject2).next();
              ((ArrayList)localObject3).add(this.this$0.getEventFromProtocolData(this.val$account.getId(), this.val$folder.getId(), this.val$folder.getCategory(), localCCalendar, this.val$cinfo.accountType));
              continue;
              if (this.val$cinfo.accountType != 2) {
                break label772;
              }
              paramCalendarResult = paramCalendarResult.calDavResult;
              if (paramCalendarResult == null) {
                break label772;
              }
              localCalendarEventSyncData.setCalendarFolderSyncToken(paramCalendarResult.sync_token_);
              QMLog.log(4, "QMCalendarProtocolManager", "update list syncToken : " + this.val$folder.getSyncToken() + "/" + paramCalendarResult.sync_token_ + "; " + this.val$folder.getPath() + "; " + paramCalendarResult.calendarHomeSetPath);
              localObject2 = paramCalendarResult.addList;
              localObject1 = paramCalendarResult.updateList;
              paramCalendarResult = paramCalendarResult.removeList;
              break;
            }
          }
        }
        if ((localObject1 != null) && (((LinkedList)localObject1).size() > 0))
        {
          QMLog.log(4, "QMCalendarProtocolManager", "LoadCalendarEventList update : " + this.val$account.getEmail() + "; " + this.val$folder.getName() + "; " + ((LinkedList)localObject1).size());
          localObject2 = new ArrayList();
          localCalendarEventSyncData.setModifyEventList((ArrayList)localObject2);
          localObject1 = ((LinkedList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (CCalendar)((Iterator)localObject1).next();
            ((ArrayList)localObject2).add(this.this$0.getEventFromProtocolData(this.val$account.getId(), this.val$folder.getId(), this.val$folder.getCategory(), (CCalendar)localObject3, this.val$cinfo.accountType));
          }
        }
        if ((paramCalendarResult != null) && (paramCalendarResult.size() > 0))
        {
          QMLog.log(4, "QMCalendarProtocolManager", "LoadCalendarEventList remove : " + this.val$account.getEmail() + "; " + this.val$folder.getName() + "; " + paramCalendarResult.size());
          localCalendarEventSyncData.setRemoveEventList((String[])paramCalendarResult.toArray(new String[paramCalendarResult.size()]));
        }
        if (this.val$callback != null) {
          this.val$callback.handleSuccess(this.val$cinfo, localCalendarEventSyncData);
        }
        do
        {
          return;
          paramCalendarResult = new QMNetworkError(5, paramCalendarResult.code, paramCalendarResult.msg);
        } while (this.val$callback == null);
        this.val$callback.handleError(paramCalendarResult);
        return;
        label772:
        paramCalendarResult = null;
        localObject3 = null;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      label785:
      localObject1 = null;
      paramCalendarResult = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarProtocolManager.10
 * JD-Core Version:    0.7.0.1
 */