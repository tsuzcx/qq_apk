package com.tencent.qqmail.account.fragment;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class LoginAccountFragment$12
  implements Runnable
{
  LoginAccountFragment$12(LoginAccountFragment paramLoginAccountFragment, QMNetworkError paramQMNetworkError) {}
  
  public void run()
  {
    this.this$0.refreshTopBar(false);
    LoginAccountFragment.access$800(this.this$0, this.val$error);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginAccountFragment.12
 * JD-Core Version:    0.7.0.1
 */