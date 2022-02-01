package com.tencent.qqmail.account.fragment;

import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.view.QMTopBar;

class LoginGmailWebFragment$5
  implements Runnable
{
  LoginGmailWebFragment$5(LoginGmailWebFragment paramLoginGmailWebFragment, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.val$isLogining)
    {
      LoginGmailWebFragment.access$900(this.this$0).showLoading(true);
      LoginGmailWebFragment.access$900(this.this$0).setTitle(2131719699);
      return;
    }
    LoginGmailWebFragment.access$900(this.this$0).showLoading(false);
    LoginGmailWebFragment.access$900(this.this$0).setTitle(this.this$0.getString(AccountType.gmail.getResId()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginGmailWebFragment.5
 * JD-Core Version:    0.7.0.1
 */