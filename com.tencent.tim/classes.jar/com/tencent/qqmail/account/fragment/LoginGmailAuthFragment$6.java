package com.tencent.qqmail.account.fragment;

import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.view.QMTopBar;

class LoginGmailAuthFragment$6
  implements Runnable
{
  LoginGmailAuthFragment$6(LoginGmailAuthFragment paramLoginGmailAuthFragment, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.val$isLogining)
    {
      LoginGmailAuthFragment.access$800(this.this$0).showLoading(true);
      LoginGmailAuthFragment.access$800(this.this$0).setTitle(2131719699);
      return;
    }
    LoginGmailAuthFragment.access$800(this.this$0).showLoading(false);
    LoginGmailAuthFragment.access$800(this.this$0).setTitle(this.this$0.getString(AccountType.gmail.getResId()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginGmailAuthFragment.6
 * JD-Core Version:    0.7.0.1
 */