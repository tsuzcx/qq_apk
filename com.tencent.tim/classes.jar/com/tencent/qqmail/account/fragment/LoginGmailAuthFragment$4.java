package com.tencent.qqmail.account.fragment;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class LoginGmailAuthFragment$4
  implements Runnable
{
  LoginGmailAuthFragment$4(LoginGmailAuthFragment paramLoginGmailAuthFragment, QMNetworkError paramQMNetworkError) {}
  
  public void run()
  {
    if (this.this$0.isActivityResumed())
    {
      LoginGmailAuthFragment.access$500(this.this$0, this.val$error.desp);
      this.this$0.refreshTopBar(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginGmailAuthFragment.4
 * JD-Core Version:    0.7.0.1
 */