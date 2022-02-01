package com.tencent.qqmail.account.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.widget.Button;
import android.widget.TextView;

class LoginAccountFragment$49
  implements DialogInterface.OnDismissListener
{
  LoginAccountFragment$49(LoginAccountFragment paramLoginAccountFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    LoginAccountFragment.access$1200(this.this$0, true, true, false, false);
    this.this$0.refreshTopBar(false);
    LoginAccountFragment.access$900(this.this$0).setEnabled(true);
    LoginAccountFragment.access$1000(this.this$0).setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginAccountFragment.49
 * JD-Core Version:    0.7.0.1
 */