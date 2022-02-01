package com.tencent.qqmail.account.fragment;

import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.AccountTypeListActivity;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;

class LoginTaskFragment$5
  implements Runnable
{
  LoginTaskFragment$5(LoginTaskFragment paramLoginTaskFragment, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.val$existLocalAccountWithSameEmail)
    {
      QMActivityManager.shareInstance().finishAllActivity();
      int i = AccountManager.shareInstance().getAccountList().size();
      if (i <= 0)
      {
        this.this$0.startActivity(AccountTypeListActivity.createIntent());
        return;
      }
      if (i == 1)
      {
        AccountManager.shareInstance().setDefaultMailAccount(AccountManager.shareInstance().getAccountList().get(0).getId());
        this.this$0.startActivity(MailFragmentActivity.createIntentToFolderList(AccountManager.shareInstance().getAccountList().get(0).getId()));
        return;
      }
      this.this$0.startActivity(MailFragmentActivity.createIntentToAccountList());
      return;
    }
    this.this$0.onBackPressed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginTaskFragment.5
 * JD-Core Version:    0.7.0.1
 */