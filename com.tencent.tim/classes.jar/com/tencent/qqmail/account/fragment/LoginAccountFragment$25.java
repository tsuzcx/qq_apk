package com.tencent.qqmail.account.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import moai.fragment.app.FragmentActivity;

class LoginAccountFragment$25
  implements DialogInterface.OnClickListener
{
  LoginAccountFragment$25(LoginAccountFragment paramLoginAccountFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (LoginAccountFragment.access$1600(this.this$0)) {
      if (this.this$0.getActivity() != null) {
        this.this$0.getActivity().finish();
      }
    }
    while ((!this.this$0.isVerifyAccount) && (!this.this$0.fromGesPwdVerify) && (!this.this$0.fromPwdErrVerify) && (!LoginAccountFragment.access$1300(this.this$0))) {
      return;
    }
    this.this$0.onBackPressed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginAccountFragment.25
 * JD-Core Version:    0.7.0.1
 */