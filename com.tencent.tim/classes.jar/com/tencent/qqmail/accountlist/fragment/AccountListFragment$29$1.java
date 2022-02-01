package com.tencent.qqmail.accountlist.fragment;

import com.tencent.qqmail.model.mail.QMMailManager;

class AccountListFragment$29$1
  implements Runnable
{
  AccountListFragment$29$1(AccountListFragment.29 param29, int paramInt) {}
  
  public void run()
  {
    QMMailManager.sharedInstance().markAccountMailAllRead(AccountListFragment.access$100(this.this$1.this$0), this.val$accountId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.29.1
 * JD-Core Version:    0.7.0.1
 */