package com.tencent.qqmail.account.fragment;

import com.tencent.qqmail.account.LoginManager;
import net.openid.appauth.AuthorizationResponse;

class LoginGmailAuthFragment$9
  implements Runnable
{
  LoginGmailAuthFragment$9(LoginGmailAuthFragment paramLoginGmailAuthFragment, AuthorizationResponse paramAuthorizationResponse) {}
  
  public void run()
  {
    LoginManager.shareInstance().fetchToken(this.val$authorizationResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginGmailAuthFragment.9
 * JD-Core Version:    0.7.0.1
 */