package com.tencent.qqmail.account.fragment;

import android.widget.Button;
import android.widget.TextView;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class LoginAccountFragment$13
  implements Runnable
{
  LoginAccountFragment$13(LoginAccountFragment paramLoginAccountFragment, QMNetworkError paramQMNetworkError) {}
  
  public void run()
  {
    this.this$0.refreshTopBar(false);
    LoginAccountFragment.access$900(this.this$0).setEnabled(true);
    LoginAccountFragment.access$1000(this.this$0).setEnabled(true);
    if ((this.this$0.mAccountType == AccountType.qqmail) || (this.this$0.mAccountType == AccountType.exmail))
    {
      LoginAccountFragment.access$1100(this.this$0, this.val$error);
      return;
    }
    LoginAccountFragment.access$800(this.this$0, this.val$error);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginAccountFragment.13
 * JD-Core Version:    0.7.0.1
 */