package com.tencent.qqmail.account.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmail.activity.webviewexplorer.SimpleWebViewExplorer;
import moai.oss.KvHelper;

class LoginAccountFragment$59$1
  implements DialogInterface.OnClickListener
{
  LoginAccountFragment$59$1(LoginAccountFragment.59 param59) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = SimpleWebViewExplorer.createIntent("https://i.mail.qq.com/app/app_register_help/phonenumber_account.html", SimpleWebViewExplorer.TOPBAR_LEFT_BUTTON);
    this.this$1.this$0.startActivity(paramDialogInterface);
    KvHelper.eventLoginRecoverNumberErrorClickHelp(new double[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginAccountFragment.59.1
 * JD-Core Version:    0.7.0.1
 */