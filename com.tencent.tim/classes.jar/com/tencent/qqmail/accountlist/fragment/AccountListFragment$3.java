package com.tencent.qqmail.accountlist.fragment;

import com.tencent.qqmail.model.mail.watcher.MailDeleteWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class AccountListFragment$3
  implements MailDeleteWatcher
{
  AccountListFragment$3(AccountListFragment paramAccountListFragment) {}
  
  public void onError(long[] paramArrayOfLong, QMNetworkError paramQMNetworkError) {}
  
  public void onProcess(long[] paramArrayOfLong) {}
  
  public void onSuccess(long[] paramArrayOfLong)
  {
    AccountListFragment.access$000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.3
 * JD-Core Version:    0.7.0.1
 */