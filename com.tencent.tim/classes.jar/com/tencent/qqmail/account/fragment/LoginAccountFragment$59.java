package com.tencent.qqmail.account.fragment;

import android.text.SpannableString;
import android.text.style.StyleSpan;
import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.helper.LoginUIHelper;
import com.tencent.qqmail.account.helper.QMWtLoginManager;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.register.CheckPhoneWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import moai.oss.KvHelper;

class LoginAccountFragment$59
  implements CheckPhoneWatcher
{
  LoginAccountFragment$59(LoginAccountFragment paramLoginAccountFragment) {}
  
  private void showRecoverNumberError(String paramString)
  {
    this.this$0.refreshTopBar(false);
    SpannableString localSpannableString = new SpannableString(paramString);
    String str = this.this$0.getString(2131695554);
    int i = paramString.indexOf(str);
    localSpannableString.setSpan(new StyleSpan(1), i, str.length() + i, 33);
    LoginUIHelper.processRecoverMobileError(this.this$0.getActivity(), localSpannableString, new LoginAccountFragment.59.1(this), new LoginAccountFragment.59.2(this), new LoginAccountFragment.59.3(this));
    KvHelper.eventLoginRecoverNumberErrorDialog(new double[0]);
  }
  
  public void onError(String paramString1, String paramString2, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "LoginAccountFragment", "checkPhoneWatcher on error");
    LoginAccountFragment.access$4200(this.this$0, this.this$0.getString(2131695511));
  }
  
  public void onSuccess(String paramString1, String paramString2, String paramString3)
  {
    QMLog.log(4, "LoginAccountFragment", "checkPhoneWatcher on success:" + paramString1 + "," + paramString2 + "," + paramString3);
    String str1 = LoginAccountFragment.access$4000(this.this$0).getA2(paramString2);
    this.this$0.currentLoginId = System.currentTimeMillis();
    int i = -1;
    switch (paramString3.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        LoginAccountFragment.access$4200(this.this$0, this.this$0.getString(2131695511));
        return;
        if (paramString3.equals("0"))
        {
          i = 0;
          continue;
          if (paramString3.equals("1"))
          {
            i = 1;
            continue;
            if (paramString3.equals("2")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    showRecoverNumberError(String.format(this.this$0.getString(2131695555), new Object[] { paramString1 }));
    return;
    paramString3 = this.this$0;
    LoginManager localLoginManager = LoginManager.shareInstance();
    long l = this.this$0.currentLoginId;
    paramString1 = paramString1 + "@qq.com";
    boolean bool1;
    if (this.this$0.mAccountType == AccountType.exmail)
    {
      bool1 = true;
      if (this.this$0.isVerifyAccount) {
        break label311;
      }
    }
    label311:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramString3.account = localLoginManager.verifyQQMailAccountWtlogin(l, paramString1, str1, "", paramString2, bool1, bool2);
      return;
      bool1 = false;
      break;
    }
    LoginAccountFragment.access$4102(this.this$0, true);
    paramString3 = this.this$0;
    localLoginManager = LoginManager.shareInstance();
    l = this.this$0.currentLoginId;
    String str2 = paramString1 + "@qq.com";
    if (this.this$0.mAccountType == AccountType.exmail)
    {
      bool1 = true;
      if (this.this$0.isVerifyAccount) {
        break label426;
      }
    }
    label426:
    for (bool2 = true;; bool2 = false)
    {
      paramString3.account = localLoginManager.verifyQQMailAccountWtlogin(l, str2, str1, "", paramString2, bool1, bool2, true, paramString1);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginAccountFragment.59
 * JD-Core Version:    0.7.0.1
 */