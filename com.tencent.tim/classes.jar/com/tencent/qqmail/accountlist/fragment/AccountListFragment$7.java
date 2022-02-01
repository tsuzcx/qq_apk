package com.tencent.qqmail.accountlist.fragment;

import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.observer.ICallBack;

class AccountListFragment$7
  implements ICallBack
{
  AccountListFragment$7(AccountListFragment paramAccountListFragment) {}
  
  public void callback(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof QMFolder)))
    {
      AccountListFragment.access$802(this.this$0, true);
      AccountListFragment.access$902(this.this$0, (QMFolder)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.7
 * JD-Core Version:    0.7.0.1
 */