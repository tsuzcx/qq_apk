package com.tencent.qqmail.account;

import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.account.watcher.QueryProviderWatcher;
import moai.core.watcher.Watchers;

class MailServiceManager$1
  implements Runnable
{
  MailServiceManager$1(MailServiceManager paramMailServiceManager, long paramLong, String paramString, AccountType paramAccountType) {}
  
  public void run()
  {
    ((QueryProviderWatcher)Watchers.of(QueryProviderWatcher.class)).onError(this.val$currentRequestId, this.val$loginAccount, this.val$type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.MailServiceManager.1
 * JD-Core Version:    0.7.0.1
 */