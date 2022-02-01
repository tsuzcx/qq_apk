package com.tencent.qqmail.account.fragment;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class LoginGmailWebFragment$3
  implements Runnable
{
  LoginGmailWebFragment$3(LoginGmailWebFragment paramLoginGmailWebFragment, QMNetworkError paramQMNetworkError) {}
  
  public void run()
  {
    if (this.this$0.isActivityResumed())
    {
      LoginGmailWebFragment.access$600(this.this$0, this.val$error.desp);
      this.this$0.refreshTopBar(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginGmailWebFragment.3
 * JD-Core Version:    0.7.0.1
 */