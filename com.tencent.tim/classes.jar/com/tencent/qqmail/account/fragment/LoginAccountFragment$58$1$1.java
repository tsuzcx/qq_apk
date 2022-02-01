package com.tencent.qqmail.account.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.register.RegisterManager;

class LoginAccountFragment$58$1$1
  implements DialogInterface.OnClickListener
{
  LoginAccountFragment$58$1$1(LoginAccountFragment.58.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    RegisterManager.registerByCGI(LoginAccountFragment.access$1700(this.this$2.this$1.this$0), LoginAccountFragment.access$1800(this.this$2.this$1.this$0), "");
    this.this$2.this$1.this$0.refreshTopBar(true);
    DataCollector.logEvent("Event_Register_Mobile_Mail_Bind_Uin_Fail_And_Click_Login");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginAccountFragment.58.1.1
 * JD-Core Version:    0.7.0.1
 */