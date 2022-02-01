package com.tencent.qqmail.accountlist.fragment;

import com.tencent.qqmail.model.mail.watcher.SyncWatcher;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.thread.Threads;

class AccountListFragment$32
  implements SyncWatcher
{
  private Runnable mUpdatePullDataTask = new AccountListFragment.32.1(this);
  
  AccountListFragment$32(AccountListFragment paramAccountListFragment) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError)
  {
    DataCollector.logPerformanceEnd("Performance_Check_New_Mail_MailboxList", "");
    AccountListFragment.access$000(this.this$0);
  }
  
  public void onSuccess(int paramInt)
  {
    DataCollector.logPerformanceEnd("Performance_Check_New_Mail_MailboxList", "");
    AccountListFragment.access$000(this.this$0);
  }
  
  public void onSyncBegin(int paramInt, boolean paramBoolean) {}
  
  public void onSyncEnd(int paramInt, boolean paramBoolean)
  {
    Threads.runOnMainThreadIfNotExist(this.mUpdatePullDataTask, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.32
 * JD-Core Version:    0.7.0.1
 */