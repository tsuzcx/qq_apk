package com.tencent.qqmail;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.AccountTypeListActivity;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;

class WelcomePagesActivity$1
  implements View.OnClickListener
{
  WelcomePagesActivity$1(WelcomePagesActivity paramWelcomePagesActivity) {}
  
  public void onClick(View paramView)
  {
    if (WelcomePagesActivity.access$000(this.this$0))
    {
      this.this$0.finish();
      this.this$0.overridePendingTransition(2130772430, 2130772025);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    Object localObject = AccountManager.shareInstance().getAccountList();
    if (((AccountList)localObject).size() == 1) {
      localObject = MailFragmentActivity.createIntentToFolderList(((AccountList)localObject).get(0).getId());
    }
    for (;;)
    {
      this.this$0.startActivity((Intent)localObject);
      this.this$0.finishWithNoCheck();
      this.this$0.overridePendingTransition(2130772401, 2130772430);
      break;
      if (((AccountList)localObject).size() > 1) {
        localObject = MailFragmentActivity.createIntentToAccountList();
      } else {
        localObject = AccountTypeListActivity.createIntent();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.WelcomePagesActivity.1
 * JD-Core Version:    0.7.0.1
 */