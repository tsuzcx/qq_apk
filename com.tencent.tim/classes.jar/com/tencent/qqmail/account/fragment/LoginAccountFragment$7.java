package com.tencent.qqmail.account.fragment;

import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.utilities.log.QMLog;

class LoginAccountFragment$7
  implements Runnable
{
  LoginAccountFragment$7(LoginAccountFragment paramLoginAccountFragment, AccountType paramAccountType) {}
  
  public void run()
  {
    this.this$0.refreshTopBar(false);
    LoginAccountFragment.access$200(this.this$0, String.format(this.this$0.getString(2131689752), new Object[] { this.this$0.getString(this.val$type.getResId()) }), AccountType.other);
    QMLog.log(4, "LoginAccountFragment", "handleQueryProviderError. gotoOtherLoginType");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginAccountFragment.7
 * JD-Core Version:    0.7.0.1
 */