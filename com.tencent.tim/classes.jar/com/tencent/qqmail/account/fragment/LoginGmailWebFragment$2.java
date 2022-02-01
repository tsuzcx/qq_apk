package com.tencent.qqmail.account.fragment;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.AccountType;

class LoginGmailWebFragment$2
  implements Runnable
{
  LoginGmailWebFragment$2(LoginGmailWebFragment paramLoginGmailWebFragment) {}
  
  public void run()
  {
    if (!this.this$0.account.isLogined()) {
      return;
    }
    this.this$0.refreshTopBar(false);
    LoginInfoFragment localLoginInfoFragment = new LoginInfoFragment(this.this$0.account, "", AccountType.gmail, false);
    this.this$0.replaceFragment(this.this$0, localLoginInfoFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginGmailWebFragment.2
 * JD-Core Version:    0.7.0.1
 */