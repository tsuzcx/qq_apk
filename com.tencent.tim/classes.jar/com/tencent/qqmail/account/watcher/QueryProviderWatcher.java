package com.tencent.qqmail.account.watcher;

import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.provider.MailServiceProvider;
import moai.core.watcher.Watchers.Watcher;

public abstract interface QueryProviderWatcher
  extends Watchers.Watcher
{
  public abstract void onError(long paramLong, String paramString, AccountType paramAccountType);
  
  public abstract void onSuccess(long paramLong, String paramString, MailServiceProvider paramMailServiceProvider);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.watcher.QueryProviderWatcher
 * JD-Core Version:    0.7.0.1
 */