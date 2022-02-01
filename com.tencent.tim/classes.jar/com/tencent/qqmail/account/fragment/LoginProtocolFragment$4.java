package com.tencent.qqmail.account.fragment;

import com.tencent.qqmail.account.model.Account;

class LoginProtocolFragment$4
  implements Runnable
{
  LoginProtocolFragment$4(LoginProtocolFragment paramLoginProtocolFragment) {}
  
  public void run()
  {
    if (!this.this$0.account.isLogined()) {
      return;
    }
    LoginInfoFragment localLoginInfoFragment = new LoginInfoFragment(this.this$0.account, this.this$0.account.getPwd(), this.this$0.mAccountType, false);
    this.this$0.replaceFragment(this.this$0, localLoginInfoFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginProtocolFragment.4
 * JD-Core Version:    0.7.0.1
 */