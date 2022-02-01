package com.tencent.qqmail.accountlist.fragment;

import android.view.View;
import com.tencent.qqmail.activity.setting.SyncErrorActivity;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.view.SyncErrorBar;
import com.tencent.qqmail.view.SyncErrorBar.onBarItemClickListener;

class AccountListFragment$13
  implements SyncErrorBar.onBarItemClickListener
{
  AccountListFragment$13(AccountListFragment paramAccountListFragment) {}
  
  public void onItemClick(View paramView)
  {
    QMLog.log(4, "AccountListFragment", "click sync error bar:" + AccountListFragment.access$1500(this.this$0).getCode());
    paramView = SyncErrorActivity.createIntent(this.this$0.getActivity(), AccountListFragment.access$1500(this.this$0).getCode());
    this.this$0.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.13
 * JD-Core Version:    0.7.0.1
 */