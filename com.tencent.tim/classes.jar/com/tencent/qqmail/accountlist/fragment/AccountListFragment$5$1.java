package com.tencent.qqmail.accountlist.fragment;

import com.tencent.qqmail.accountlist.adapter.AccountBaseAdapter;
import com.tencent.qqmail.utilities.log.QMLog;

class AccountListFragment$5$1
  implements Runnable
{
  AccountListFragment$5$1(AccountListFragment.5 param5) {}
  
  public void run()
  {
    QMLog.log(4, "AccountListFragment", "Ftn-expunread called account watcher setaccountlist");
    AccountListFragment.access$300(this.this$1.this$0).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.5.1
 * JD-Core Version:    0.7.0.1
 */