package com.tencent.qqmail.accountlist.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.log.QMLog;

class AccountListFragment$16
  implements View.OnClickListener
{
  AccountListFragment$16(AccountListFragment paramAccountListFragment) {}
  
  public void onClick(View paramView)
  {
    QMLog.log(4, "AccountListFragment", "dragSearchBarBtnRightClick toggleEditMode");
    AccountListFragment.access$1900(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.16
 * JD-Core Version:    0.7.0.1
 */