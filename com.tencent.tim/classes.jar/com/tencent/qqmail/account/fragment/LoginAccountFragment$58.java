package com.tencent.qqmail.account.fragment;

import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.helper.QMWtLoginManager;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.register.RegisterWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;

class LoginAccountFragment$58
  implements RegisterWatcher
{
  LoginAccountFragment$58(LoginAccountFragment paramLoginAccountFragment) {}
  
  public void onError(String paramString1, String paramString2, String paramString3)
  {
    QMLog.log(6, "LoginAccountFragment", "register watcher error. errCode:" + paramString3 + ",phone:" + paramString1 + ",uin:" + paramString2);
    if (this.this$0.userClickAbort) {
      return;
    }
    DataCollector.logEvent("Event_Register_Mobile_Mail_Bind_Uin_Fail");
    Threads.runOnMainThread(new LoginAccountFragment.58.1(this));
  }
  
  public void onSuccess(String paramString1, String paramString2)
  {
    QMLog.log(4, "LoginAccountFragment", "register watcher success.");
    if (this.this$0.userClickAbort) {
      return;
    }
    String str = LoginAccountFragment.access$4000(this.this$0).getA2(paramString2);
    this.this$0.currentLoginId = System.currentTimeMillis();
    LoginAccountFragment localLoginAccountFragment = this.this$0;
    LoginManager localLoginManager = LoginManager.shareInstance();
    long l = this.this$0.currentLoginId;
    paramString1 = paramString1 + "@qq.com";
    boolean bool1;
    if (this.this$0.mAccountType == AccountType.exmail)
    {
      bool1 = true;
      if (this.this$0.isVerifyAccount) {
        break label147;
      }
    }
    label147:
    for (boolean bool2 = true;; bool2 = false)
    {
      localLoginAccountFragment.account = localLoginManager.verifyQQMailAccountWtlogin(l, paramString1, str, "", paramString2, bool1, bool2);
      LoginAccountFragment.access$4102(this.this$0, true);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginAccountFragment.58
 * JD-Core Version:    0.7.0.1
 */