package com.tencent.androidqqmail.tim;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.account.model.AccountType;

class MockMainActivity$2
  implements View.OnClickListener
{
  MockMainActivity$2(MockMainActivity paramMockMainActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = LoginFragmentActivity.createIntentForA2AddAccount(AccountType.qqmail.name(), "1526814160@qq.com", "a21234567890", "skey1234567890");
    this.this$0.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.androidqqmail.tim.MockMainActivity.2
 * JD-Core Version:    0.7.0.1
 */