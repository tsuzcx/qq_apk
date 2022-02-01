package com.tencent.qqmail.account.fragment;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.view.EmailEditText;
import com.tencent.qqmail.view.QMTopBar;

class LoginAccountFragment$42
  implements Runnable
{
  LoginAccountFragment$42(LoginAccountFragment paramLoginAccountFragment, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.isLogining = this.val$isLoading;
    LoginAccountFragment.access$300(this.this$0).showLoading(this.val$isLoading);
    LoginAccountFragment.access$300(this.this$0).setTitle(LoginAccountFragment.access$3300(this.this$0, this.val$isLoading));
    View localView = LoginAccountFragment.access$300(this.this$0).getButtonRight();
    if (this.this$0.mAccountType == AccountType.qqmail) {}
    for (int i = 8;; i = 0)
    {
      localView.setVisibility(i);
      if (!this.val$isLoading) {
        break label282;
      }
      if (this.this$0.mAccountType != AccountType.qqmail) {
        break;
      }
      LoginAccountFragment.access$300(this.this$0).getButtonRight().setVisibility(8);
      return;
    }
    if ((QMSettingManager.sharedInstance().isEnableSettingDomainConfig()) && (this.this$0.mAccountType == AccountType.other))
    {
      LoginAccountFragment.access$300(this.this$0).setButtonRightBlue(2131696727);
      return;
    }
    if ((this.this$0.fromPwdErrVerify) || (this.this$0.fromSettingAccount) || (this.this$0.isVerifyAccount)) {
      LoginAccountFragment.access$300(this.this$0).setButtonRightBlue(2131693745);
    }
    for (;;)
    {
      LoginAccountFragment.access$300(this.this$0).getButtonRight().setEnabled(false);
      return;
      if (this.this$0.fromGesPwdVerify)
      {
        if (this.this$0.fromGesPwdVerifyOvertimes) {
          LoginAccountFragment.access$300(this.this$0).setButtonRightNormal(2131691246);
        } else {
          LoginAccountFragment.access$300(this.this$0).setButtonRightBlue(2131721664);
        }
      }
      else {
        LoginAccountFragment.access$300(this.this$0).setButtonRightBlue(2131695506);
      }
    }
    label282:
    localView = LoginAccountFragment.access$300(this.this$0).getButtonRight();
    boolean bool;
    if ((LoginAccountFragment.access$1900(this.this$0).getText().length() > 0) && (LoginAccountFragment.access$2200(this.this$0).getText().length() > 0))
    {
      bool = true;
      localView.setEnabled(bool);
      if (!this.this$0.fromGesPwdVerify) {
        break label376;
      }
      LoginAccountFragment.access$300(this.this$0).setButtonRightBlue(2131721664);
    }
    for (;;)
    {
      LoginAccountFragment.access$1200(this.this$0, true, false, false, false);
      return;
      bool = false;
      break;
      label376:
      if (this.this$0.isVerifyAccount) {
        LoginAccountFragment.access$300(this.this$0).setButtonRightBlue(2131693745);
      } else if (this.this$0.mAccountType == AccountType.other) {
        LoginAccountFragment.access$300(this.this$0).setButtonRightBlue(2131696317);
      } else {
        LoginAccountFragment.access$300(this.this$0).setButtonRightBlue(2131695506);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginAccountFragment.42
 * JD-Core Version:    0.7.0.1
 */