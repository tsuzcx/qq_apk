package com.tencent.qqmail.accountlist.fragment;

import com.tencent.qqmail.accountlist.adapter.AccountBaseAdapter;
import com.tencent.qqmail.utilities.log.QMLog;

class AccountListFragment$38
  implements Runnable
{
  AccountListFragment$38(AccountListFragment paramAccountListFragment) {}
  
  public void run()
  {
    QMLog.log(4, "AccountListFragment", "Ftn-unread onactivityresult called account watcher setaccountlist");
    AccountListFragment.access$300(this.this$0).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.38
 * JD-Core Version:    0.7.0.1
 */