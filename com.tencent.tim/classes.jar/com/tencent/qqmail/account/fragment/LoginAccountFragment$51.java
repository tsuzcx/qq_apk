package com.tencent.qqmail.account.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmail.activity.webviewexplorer.SimpleWebViewExplorer;
import com.tencent.qqmail.utilities.log.QMLog;

class LoginAccountFragment$51
  implements DialogInterface.OnClickListener
{
  LoginAccountFragment$51(LoginAccountFragment paramLoginAccountFragment, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface = SimpleWebViewExplorer.createIntent(this.val$url, SimpleWebViewExplorer.TOPBAR_LEFT_BUTTON);
      this.this$0.startActivity(paramDialogInterface);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QMLog.log(5, "LoginAccountFragment", ", url: " + this.val$url, paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginAccountFragment.51
 * JD-Core Version:    0.7.0.1
 */