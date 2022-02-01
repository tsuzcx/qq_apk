package com.tencent.qqmail.account.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AccountTypeListActivity$4
  implements View.OnClickListener
{
  AccountTypeListActivity$4(AccountTypeListActivity paramAccountTypeListActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.finish();
    this.this$0.overridePendingTransition(2130772421, 2130772420);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.activity.AccountTypeListActivity.4
 * JD-Core Version:    0.7.0.1
 */