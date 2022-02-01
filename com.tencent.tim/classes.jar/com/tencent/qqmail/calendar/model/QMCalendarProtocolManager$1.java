package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.protocol.calendar.CalendarCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMSslError;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import org.apache.commons.lang3.StringUtils;

class QMCalendarProtocolManager$1
  extends CalendarCallback
{
  QMCalendarProtocolManager$1(QMCalendarProtocolManager paramQMCalendarProtocolManager, Account paramAccount, CalendarInfo paramCalendarInfo, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void onResult(CalendarResult paramCalendarResult)
  {
    Object localObject = new StringBuilder().append("ok? ").append(paramCalendarResult.code).append("; ").append(this.val$account.getEmail()).append("; ");
    boolean bool;
    if (this.val$cinfo.accountType == 1)
    {
      bool = true;
      QMLog.log(4, "QMCalendarProtocolManager", bool);
      if (paramCalendarResult.code != 0) {
        break label353;
      }
      localObject = new CalendarAccountConfig();
      ((CalendarAccountConfig)localObject).setId(CalendarAccountConfig.generateId(this.val$account.getId(), this.val$cinfo.accountType));
      ((CalendarAccountConfig)localObject).setAccountId(this.val$account.getId());
      ((CalendarAccountConfig)localObject).setPwd(this.val$account.getPwd());
      ((CalendarAccountConfig)localObject).setHost(this.val$cinfo.host);
      ((CalendarAccountConfig)localObject).setProtocol(this.val$cinfo.accountType);
      if (this.val$cinfo.accountType == 1)
      {
        ActiveSyncResult localActiveSyncResult = paramCalendarResult.activeSyncResult;
        if ((localActiveSyncResult != null) && (localActiveSyncResult.errorCode == 0))
        {
          if (!StringUtils.isBlank(paramCalendarResult.activeSyncResult.serverAddr)) {
            ((CalendarAccountConfig)localObject).setHost(paramCalendarResult.activeSyncResult.serverAddr);
          }
          ((CalendarAccountConfig)localObject).setProtocolVersion(paramCalendarResult.activeSyncResult.protocolVersion);
        }
      }
      this.this$0.setAccountConfig((CalendarAccountConfig)localObject);
      if (this.val$cinfo.accountType != 1) {
        break label302;
      }
      paramCalendarResult = paramCalendarResult.activeSyncResult;
      if ((paramCalendarResult == null) || (paramCalendarResult.errorCode != 0)) {
        break label294;
      }
      ((CalendarAccountConfig)localObject).setPolicyKey(paramCalendarResult.policyKey);
      ((CalendarAccountConfig)localObject).setIsSslSupport(this.val$cinfo.activeSyncInfo.isActiveSyncUsingSSL());
      label269:
      if (this.val$callback != null) {
        this.val$callback.handleSuccess(localObject, this.val$cinfo);
      }
    }
    label294:
    label302:
    label353:
    label502:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              bool = false;
              break;
              ValidateHelper.throwExceptionInDebug("wrong activesync result");
              break label269;
              paramCalendarResult = paramCalendarResult.calDavResult;
              if ((paramCalendarResult != null) && (paramCalendarResult.errorCode == 0))
              {
                ((CalendarAccountConfig)localObject).setHomeSetPath(paramCalendarResult.calendarHomeSetPath);
                ((CalendarAccountConfig)localObject).setAuthToken(paramCalendarResult.icloudAuthToken);
                ((CalendarAccountConfig)localObject).setSyncToken(paramCalendarResult.sync_token_);
                break label269;
              }
              ValidateHelper.throwExceptionInDebug("wrong caldav result");
              break label269;
              if (paramCalendarResult.code != 5) {
                break label387;
              }
              paramCalendarResult = new QMNetworkError(5, 5);
            } while (this.val$callback == null);
            this.val$callback.handleError(paramCalendarResult);
            return;
            if (paramCalendarResult.code != 10) {
              break label434;
            }
            paramCalendarResult = new QMSslError(5, 10, "", "", this.val$cinfo.host);
          } while (this.val$callback == null);
          this.val$callback.handleError(paramCalendarResult);
          return;
          if (paramCalendarResult.code != 4) {
            break label468;
          }
          paramCalendarResult = new QMNetworkError(5, 4);
        } while (this.val$callback == null);
        this.val$callback.handleError(paramCalendarResult);
        return;
        if (paramCalendarResult.code != 2) {
          break label502;
        }
        paramCalendarResult = new QMNetworkError(5, 2);
      } while (this.val$callback == null);
      this.val$callback.handleError(paramCalendarResult);
      return;
      paramCalendarResult = new QMNetworkError(5, paramCalendarResult.code, paramCalendarResult.msg);
    } while (this.val$callback == null);
    label387:
    label434:
    label468:
    this.val$callback.handleError(paramCalendarResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarProtocolManager.1
 * JD-Core Version:    0.7.0.1
 */