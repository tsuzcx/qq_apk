package com.tencent.qqmail.account.fragment;

import com.tencent.qqmail.account.LoginManager;

class LoginGmailAuthFragment$10
  implements Runnable
{
  LoginGmailAuthFragment$10(LoginGmailAuthFragment paramLoginGmailAuthFragment) {}
  
  public void run()
  {
    LoginManager.shareInstance().fetchAuthCode(this.this$0.getActivity(), this.this$0.userInputEmail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginGmailAuthFragment.10
 * JD-Core Version:    0.7.0.1
 */