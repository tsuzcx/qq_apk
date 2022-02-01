package com.tencent.qqmail.accountlist.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;

class AccountListFragment$19
  implements View.OnClickListener
{
  AccountListFragment$19(AccountListFragment paramAccountListFragment) {}
  
  public void onClick(View paramView)
  {
    AccountListFragment.access$1200(this.this$0).setSelection(0);
    AccountListFragment.access$1200(this.this$0).post(new AccountListFragment.19.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.19
 * JD-Core Version:    0.7.0.1
 */