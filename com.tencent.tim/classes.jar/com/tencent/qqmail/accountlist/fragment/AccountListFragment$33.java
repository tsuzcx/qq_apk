package com.tencent.qqmail.accountlist.fragment;

import com.tencent.qqmail.model.mail.watcher.SyncPhotoWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.List;

class AccountListFragment$33
  implements SyncPhotoWatcher
{
  AccountListFragment$33(AccountListFragment paramAccountListFragment) {}
  
  public void onError(QMNetworkError paramQMNetworkError) {}
  
  public void onSuccess(List<String> paramList)
  {
    AccountListFragment.access$3900(this.this$0, new AccountListFragment.33.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.33
 * JD-Core Version:    0.7.0.1
 */