package com.tencent.qqmail.accountlist.fragment;

import com.tencent.qqmail.model.mail.watcher.LoadListWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class AccountListFragment$31
  implements LoadListWatcher
{
  AccountListFragment$31(AccountListFragment paramAccountListFragment) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError)
  {
    AccountListFragment.access$000(this.this$0);
  }
  
  public void onPopIn(long paramLong, String paramString) {}
  
  public void onProcess(int paramInt, boolean paramBoolean) {}
  
  public void onSuccess(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AccountListFragment.access$000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.31
 * JD-Core Version:    0.7.0.1
 */