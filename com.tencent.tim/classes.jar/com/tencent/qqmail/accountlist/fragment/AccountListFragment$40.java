package com.tencent.qqmail.accountlist.fragment;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.QMSyncErrorManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import java.util.Timer;
import java.util.TimerTask;

class AccountListFragment$40
  extends TimerTask
{
  AccountListFragment$40(AccountListFragment paramAccountListFragment) {}
  
  public void run()
  {
    QMLog.log(4, "AccountListFragment", "run ping timer");
    if (!QMSyncErrorManager.sharedInstance().isNetworkUnavailable())
    {
      QMLog.log(4, "AccountListFragment", "network available to cancel ping timer");
      if (AccountListFragment.access$4200(this.this$0) != null) {
        AccountListFragment.access$4200(this.this$0).cancel();
      }
      AccountListFragment.access$4202(this.this$0, null);
      return;
    }
    if (QMNetworkUtils.isNetworkAvailable())
    {
      QMLog.log(4, "AccountListFragment", "socket connect success to cancel ping timer");
      QMSyncErrorManager.sharedInstance().setNetworkUnavailable(false);
      QMWatcherCenter.triggerRenderSyncErrorBar();
      if (AccountListFragment.access$4200(this.this$0) != null) {
        AccountListFragment.access$4200(this.this$0).cancel();
      }
      AccountListFragment.access$4202(this.this$0, null);
      return;
    }
    QMLog.log(4, "AccountListFragment", "socket connect fail to continue ping timer");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.40
 * JD-Core Version:    0.7.0.1
 */