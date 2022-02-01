package com.tencent.qqmail.protocol;

import android.util.Log;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.qmnetwork.QMCGIError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

public class DataCollectorHelper
{
  public static String getConversationViewLog()
  {
    AccountList localAccountList = AccountManager.shareInstance().getAccountList();
    StringBuilder localStringBuilder = new StringBuilder();
    QMSettingManager localQMSettingManager = QMSettingManager.sharedInstance();
    if (localAccountList != null)
    {
      int i = 0;
      if (i < localAccountList.size())
      {
        if (localAccountList.get(i) != null)
        {
          if (!localQMSettingManager.getAggregateSubject(localAccountList.get(i).getId())) {
            break label98;
          }
          localStringBuilder.append(localAccountList.get(i).getId()).append("#1");
        }
        for (;;)
        {
          if (i != localAccountList.size() - 1) {
            localStringBuilder.append("%");
          }
          i += 1;
          break;
          label98:
          localStringBuilder.append(localAccountList.get(i).getId()).append("#0");
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String getNewMailTipsLog()
  {
    AccountList localAccountList = AccountManager.shareInstance().getAccountList();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < localAccountList.size())
    {
      if (QMSettingManager.sharedInstance().getNotifyAccountMail(localAccountList.get(i).getId())) {
        localStringBuilder.append(localAccountList.get(i).getId()).append("#1");
      }
      for (;;)
      {
        if (i != localAccountList.size() - 1) {
          localStringBuilder.append("%");
        }
        i += 1;
        break;
        localStringBuilder.append(localAccountList.get(i).getId()).append("#0");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static void writeRenderMailListLog(String paramString1, QMNetworkError paramQMNetworkError, String paramString2)
  {
    if (paramQMNetworkError == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2).append("####");
    if ((paramQMNetworkError instanceof QMCGIError)) {
      localStringBuilder.append("appcode:").append(((QMCGIError)paramQMNetworkError).appCode).append("####desp:").append(paramQMNetworkError.desp);
    }
    for (;;)
    {
      Log.v("mason", paramString1 + ". render error:" + localStringBuilder.toString());
      DataCollector.logDetailEvent(paramString1, 0L, 1L, localStringBuilder.toString());
      return;
      if ((paramQMNetworkError instanceof QMNetworkError)) {
        localStringBuilder.append("code:").append(paramQMNetworkError.code).append("####desp:").append(paramQMNetworkError.desp);
      } else {
        localStringBuilder.append(paramQMNetworkError.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.DataCollectorHelper
 * JD-Core Version:    0.7.0.1
 */