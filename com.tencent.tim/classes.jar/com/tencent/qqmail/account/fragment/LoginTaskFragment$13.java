package com.tencent.qqmail.account.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmail.account.model.EmailDomainDefine.DomainType;
import com.tencent.qqmail.activity.webviewexplorer.SimpleWebViewExplorer;
import com.tencent.qqmail.protocol.DataCollector;

class LoginTaskFragment$13
  implements DialogInterface.OnClickListener
{
  LoginTaskFragment$13(LoginTaskFragment paramLoginTaskFragment, EmailDomainDefine.DomainType paramDomainType) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    DataCollector.logEvent("Event_Login_Click_How_To_Open_Imap");
    paramDialogInterface = SimpleWebViewExplorer.createIntent(this.val$domainType.getAuthHelpUrl(), SimpleWebViewExplorer.TOPBAR_LEFT_BUTTON);
    this.this$0.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginTaskFragment.13
 * JD-Core Version:    0.7.0.1
 */