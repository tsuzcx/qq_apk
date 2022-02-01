package com.tencent.qqmail.account.fragment;

import com.tencent.androidqqmail.tim.TimMailLoginManager.GetTicketCallback;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.helper.QMWtLoginManager;
import com.tencent.qqmail.account.log.AddAccountLocalLogUtil;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.Iterator;

class LoginAccountFragment$43
  implements TimMailLoginManager.GetTicketCallback
{
  LoginAccountFragment$43(LoginAccountFragment paramLoginAccountFragment) {}
  
  public void onError(String paramString, int paramInt1, int paramInt2)
  {
    if (this.this$0.getActivity() == null) {
      return;
    }
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.this$0.getActivity()).setTitle(2131695516)).setMessage(2131695515).addAction(2131696547, new LoginAccountFragment.43.1(this))).create().show();
  }
  
  public void onSuccess(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    if (!this.this$0.isVerifyAccount)
    {
      localObject1 = AccountManager.shareInstance().getAccountList().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Account)((Iterator)localObject1).next();
        if ((((Account)localObject2).isQQMail()) && (((Account)localObject2).getUin().equals(paramString2)))
        {
          AddAccountLocalLogUtil.logAddAccountLocalFail(this.this$0.userInputEmail, this.this$0.mAccountType, 5);
          LoginAccountFragment.access$3400(this.this$0, ((Account)localObject2).getId(), ((Account)localObject2).getEmail());
          QMLog.log(6, "LoginAccountFragment", "exist account uin:" + ((Account)localObject2).getUin());
          return;
        }
      }
    }
    this.this$0.currentLoginId = System.currentTimeMillis();
    LoginAccountFragment.access$3002(this.this$0, paramString1);
    LoginAccountFragment.access$1302(this.this$0, false);
    paramString1 = QMWtLoginManager.getInstance().getA2(paramString2);
    Object localObject1 = this.this$0;
    Object localObject2 = LoginManager.shareInstance();
    long l = this.this$0.currentLoginId;
    String str = LoginAccountFragment.access$3000(this.this$0);
    if (this.this$0.mAccountType == AccountType.exmail) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!this.this$0.isVerifyAccount) {
        bool2 = true;
      }
      ((LoginAccountFragment)localObject1).account = ((LoginManager)localObject2).verifyQQMailAccountWtlogin(l, str, paramString1, "", paramString2, bool1, bool2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginAccountFragment.43
 * JD-Core Version:    0.7.0.1
 */