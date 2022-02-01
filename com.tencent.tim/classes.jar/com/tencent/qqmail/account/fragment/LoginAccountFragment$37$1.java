package com.tencent.qqmail.account.fragment;

import com.tencent.androidqqmail.tim.TimMailLoginManager.GetTicketCallback;
import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.helper.QMWtLoginManager;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;

class LoginAccountFragment$37$1
  implements TimMailLoginManager.GetTicketCallback
{
  LoginAccountFragment$37$1(LoginAccountFragment.37 param37) {}
  
  public void onError(String paramString, int paramInt1, int paramInt2)
  {
    if (this.this$1.this$0.getActivity() == null) {
      return;
    }
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.this$1.this$0.getActivity()).setTitle(2131695516)).setMessage(2131695515).addAction(2131696547, new LoginAccountFragment.37.1.1(this))).create().show();
  }
  
  public void onSuccess(String paramString1, String paramString2)
  {
    if (!this.this$1.this$0.isAttachedToActivity()) {
      return;
    }
    LoginAccountFragment.access$2700(this.this$1.this$0, true);
    LoginAccountFragment.access$2800(this.this$1.this$0, paramString1);
    LoginAccountFragment.access$2900(this.this$1.this$0, false);
    this.this$1.this$0.currentLoginId = System.currentTimeMillis();
    LoginAccountFragment.access$3002(this.this$1.this$0, paramString1);
    LoginAccountFragment.access$1302(this.this$1.this$0, false);
    paramString1 = QMWtLoginManager.getInstance().getA2(paramString2);
    LoginAccountFragment localLoginAccountFragment = this.this$1.this$0;
    LoginManager localLoginManager = LoginManager.shareInstance();
    long l = this.this$1.this$0.currentLoginId;
    String str = LoginAccountFragment.access$3000(this.this$1.this$0);
    boolean bool1;
    if (this.this$1.this$0.mAccountType == AccountType.exmail)
    {
      bool1 = true;
      if (this.this$1.this$0.isVerifyAccount) {
        break label192;
      }
    }
    label192:
    for (boolean bool2 = true;; bool2 = false)
    {
      localLoginAccountFragment.account = localLoginManager.verifyQQMailAccountWtlogin(l, str, paramString1, "", paramString2, bool1, bool2);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginAccountFragment.37.1
 * JD-Core Version:    0.7.0.1
 */