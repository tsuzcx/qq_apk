package com.tencent.qqmail.account;

import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.provider.MailServiceProvider;
import com.tencent.qqmail.utilities.log.QMLog;

class MailServiceManager$3
  implements MailServiceManager.QueryProviderListener
{
  MailServiceManager$3(MailServiceManager paramMailServiceManager, long paramLong, String paramString, AccountType paramAccountType) {}
  
  public void onError(Object paramObject)
  {
    QMLog.log(6, "MailServiceManager", "getProviderFromWeb. err:" + paramObject);
    this.this$0.triggerQueryProviderError(this.val$currentRequestId, this.val$loginAccount, this.val$type);
  }
  
  public void onSuccess(MailServiceProvider paramMailServiceProvider)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("getProviderFromWeb. success:");
    if (paramMailServiceProvider == null) {}
    for (String str = "provider null";; str = paramMailServiceProvider.toString())
    {
      QMLog.log(4, "MailServiceManager", str);
      this.this$0.triggerQueryProviderSuccess(this.val$currentRequestId, this.val$loginAccount, paramMailServiceProvider);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.MailServiceManager.3
 * JD-Core Version:    0.7.0.1
 */