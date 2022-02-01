package com.tencent.qqmail.account.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qqmail.view.GmailAuthWebView;

class LoginGmailWebFragment$6
  implements DialogInterface.OnDismissListener
{
  LoginGmailWebFragment$6(LoginGmailWebFragment paramLoginGmailWebFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (LoginGmailWebFragment.access$1000(this.this$0) != null) {
      LoginGmailWebFragment.access$1000(this.this$0).backToLogin();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginGmailWebFragment.6
 * JD-Core Version:    0.7.0.1
 */