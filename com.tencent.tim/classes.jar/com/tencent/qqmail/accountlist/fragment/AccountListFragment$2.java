package com.tencent.qqmail.accountlist.fragment;

import com.tencent.qqmail.model.mail.watcher.MailUnReadWatcher;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class AccountListFragment$2
  implements MailUnReadWatcher
{
  AccountListFragment$2(AccountListFragment paramAccountListFragment) {}
  
  public void onError(long[] paramArrayOfLong, QMNetworkError paramQMNetworkError) {}
  
  public void onProcess(long[] paramArrayOfLong) {}
  
  public void onSuccess(long[] paramArrayOfLong)
  {
    if (AccountListFragment.access$100(this.this$0).canHandleUnread(paramArrayOfLong)) {
      AccountListFragment.access$000(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.2
 * JD-Core Version:    0.7.0.1
 */