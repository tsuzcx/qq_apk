package com.tencent.qqmail.account.fragment;

import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.account.watcher.QueryProviderWatcher;
import com.tencent.qqmail.provider.MailServiceProvider;
import moai.oss.OssHelper;

class LoginTaskFragment$1
  implements QueryProviderWatcher
{
  LoginTaskFragment$1(LoginTaskFragment paramLoginTaskFragment) {}
  
  public void onError(long paramLong, String paramString, AccountType paramAccountType)
  {
    if (this.this$0.userClickAbort) {}
    while (this.this$0.currentLoginId != paramLong) {
      return;
    }
    OssHelper.mailQueryProvider(new Object[] { AccountType.splitDomain(paramString), "ERROR", Long.valueOf(System.currentTimeMillis() - paramLong) });
    this.this$0.handleQueryProviderError(paramLong, paramAccountType);
  }
  
  public void onSuccess(long paramLong, String paramString, MailServiceProvider paramMailServiceProvider)
  {
    if (this.this$0.userClickAbort) {}
    while (this.this$0.currentLoginId != paramLong) {
      return;
    }
    OssHelper.mailQueryProvider(new Object[] { AccountType.splitDomain(paramString), "SUCCESS", Long.valueOf(System.currentTimeMillis() - paramLong) });
    this.this$0.handleQueryProviderSuccess(paramLong, paramString, paramMailServiceProvider);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginTaskFragment.1
 * JD-Core Version:    0.7.0.1
 */