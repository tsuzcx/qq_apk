package com.tencent.qqmail.account.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.view.QMTopBar;

class AccountTypeListActivity$2
  implements View.OnClickListener
{
  AccountTypeListActivity$2(AccountTypeListActivity paramAccountTypeListActivity) {}
  
  public void onClick(View paramView)
  {
    AccountTypeListActivity.access$100(this.this$0).getButtonLeft().setSelected(true);
    this.this$0.finish();
    this.this$0.overridePendingTransition(0, 2130772402);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.activity.AccountTypeListActivity.2
 * JD-Core Version:    0.7.0.1
 */