package com.tencent.qqmail;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.account.watcher.QueryProviderWatcher;
import com.tencent.qqmail.provider.MailServiceProvider;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.log.QMLogStream;
import java.util.List;

class BaseActivityImpl$1
  implements QueryProviderWatcher
{
  BaseActivityImpl$1(BaseActivityImpl paramBaseActivityImpl) {}
  
  public void onError(long paramLong, String paramString, AccountType paramAccountType)
  {
    QMLog.log(6, "BaseActivityImpl", "queryProviderWatcher error");
  }
  
  public void onSuccess(long paramLong, String paramString, MailServiceProvider paramMailServiceProvider)
  {
    if (paramLong == 100L)
    {
      if (paramMailServiceProvider != null) {
        break label22;
      }
      QMLog.log(5, "BaseActivityImpl", "queryProviderWatcher. privider null");
    }
    label22:
    int i;
    int j;
    do
    {
      List localList;
      do
      {
        return;
        localList = paramMailServiceProvider.getProviderCompanyEntrys();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("queryProviderWatcher success. email:").append(paramString).append(", provider companys:");
        i = 0;
        if (i < localList.size())
        {
          if (localList.get(i) == null) {}
          for (paramMailServiceProvider = "null";; paramMailServiceProvider = (String)localList.get(i))
          {
            localStringBuilder.append(paramMailServiceProvider).append(";");
            i += 1;
            break;
          }
        }
        QMLog.log(4, "BaseActivityImpl", localStringBuilder.toString());
        paramString = AccountManager.shareInstance().getAccountList().getAccountByEmail(paramString);
      } while ((paramString == null) || (localList == null) || (localList.size() <= 0) || ((!localList.contains("1")) && (!localList.contains("2"))) || (localList.get(0) == null));
      i = paramString.getProtocol();
      j = Integer.parseInt((String)localList.get(0));
    } while (i == j);
    paramMailServiceProvider = new StringBuilder().append("queryProviderWatcher. set ").append(paramString.getEmail()).append(" from protocol ").append(i).append(" to ").append(j);
    paramString.setProtocol(j);
    paramString.save();
    QMLog.log(4, "BaseActivityImpl", paramMailServiceProvider.toString());
    QMLogStream.logWithoutUmaNow(-40023, paramMailServiceProvider.toString(), "Event_Error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.1
 * JD-Core Version:    0.7.0.1
 */