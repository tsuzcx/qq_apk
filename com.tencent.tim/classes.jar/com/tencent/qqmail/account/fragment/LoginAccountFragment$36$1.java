package com.tencent.qqmail.account.fragment;

import android.widget.EditText;
import android.widget.TextView;
import com.tencent.qqmail.account.helper.LoginUIHelper.SelectPicker;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.view.EmailEditText;

class LoginAccountFragment$36$1
  implements LoginUIHelper.SelectPicker
{
  LoginAccountFragment$36$1(LoginAccountFragment.36 param36) {}
  
  public void select(int paramInt, Account paramAccount)
  {
    LoginAccountFragment.access$2402(this.this$1.this$0, paramInt);
    this.this$1.this$0.account = paramAccount;
    this.this$1.this$0.mAccountType = AccountType.domainOf(paramAccount, paramAccount.getEmail());
    LoginAccountFragment.access$2500(this.this$1.this$0).setText(paramAccount.getEmail());
    LoginAccountFragment.access$1900(this.this$1.this$0).setText(paramAccount.getEmail());
    LoginAccountFragment.access$1900(this.this$1.this$0).setHint(AccountType.getInputEmailHint(this.this$1.this$0.mAccountType));
    LoginAccountFragment.access$2200(this.this$1.this$0).setText("");
    LoginAccountFragment.access$2200(this.this$1.this$0).setHint(AccountType.getInputPasswordHint(this.this$1.this$0.mAccountType));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginAccountFragment.36.1
 * JD-Core Version:    0.7.0.1
 */