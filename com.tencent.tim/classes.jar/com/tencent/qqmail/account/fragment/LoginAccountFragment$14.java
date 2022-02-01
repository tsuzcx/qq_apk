package com.tencent.qqmail.account.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class LoginAccountFragment$14
  implements DialogInterface.OnDismissListener
{
  LoginAccountFragment$14(LoginAccountFragment paramLoginAccountFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    LoginAccountFragment.access$1200(this.this$0, true, true, false, false);
    if ((LoginAccountFragment.access$1300(this.this$0)) || (!LoginAccountFragment.access$1400(this.this$0))) {
      this.this$0.onBackPressed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginAccountFragment.14
 * JD-Core Version:    0.7.0.1
 */