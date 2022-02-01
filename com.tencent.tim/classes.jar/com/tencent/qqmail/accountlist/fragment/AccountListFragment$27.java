package com.tencent.qqmail.accountlist.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.qqmail.utilities.log.QMLog;

class AccountListFragment$27
  implements AdapterView.OnItemLongClickListener
{
  AccountListFragment$27(AccountListFragment paramAccountListFragment) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    QMLog.log(4, "AccountListFragment", "onItemLongClick toggleEditMode");
    AccountListFragment.access$1102(this.this$0, false);
    AccountListFragment.access$1900(this.this$0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.27
 * JD-Core Version:    0.7.0.1
 */