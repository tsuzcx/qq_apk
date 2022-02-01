package com.tencent.qqmail.account.fragment;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.watcher.GMailAuthWatcher;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.stringextention.StringExtention;

class LoginGmailAuthFragment$1
  implements GMailAuthWatcher
{
  LoginGmailAuthFragment$1(LoginGmailAuthFragment paramLoginGmailAuthFragment) {}
  
  public void onGetTokenError(String paramString, QMNetworkError paramQMNetworkError)
  {
    String str;
    if ((paramQMNetworkError != null) && (!StringExtention.isNullOrEmpty(paramQMNetworkError.desp)))
    {
      str = paramQMNetworkError.desp;
      if ((paramQMNetworkError != null) && (paramQMNetworkError.code != 0)) {
        break label104;
      }
    }
    label104:
    for (int i = 1;; i = paramQMNetworkError.code)
    {
      QMLog.log(6, "LoginGmailAuthFragment", "GmailAuth, Get gmail access token watcher error, code:" + paramString + " errdesp: " + str);
      DataCollector.logDetailEvent("DetailEvent_Gmail_Login_AccountInfo", 0L, i, str);
      LoginGmailAuthFragment.access$500(this.this$0, "Gmail授权登录失败");
      this.this$0.refreshTopBar(false);
      return;
      str = "";
      break;
    }
  }
  
  public void onGetTokenSuccess(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5)
  {
    QMLog.log(4, "LoginGmailAuthFragment", "GmailAuth, Get gmail access token watcher success, accessToken: " + paramString2 + " refreshToken: " + paramString4 + " tokenType: " + paramString3 + " expiresIn: " + paramLong + " idToken: " + paramString5);
    DataCollector.logDetailEvent("DetailEvent_Gmail_Login_Accesstoken", 0L, 0L, "Gmail auth, get access token success");
    LoginGmailAuthFragment.access$002(this.this$0, paramString2);
    LoginGmailAuthFragment.access$102(this.this$0, paramString4);
    LoginGmailAuthFragment.access$202(this.this$0, paramString3);
    LoginGmailAuthFragment.access$302(this.this$0, paramLong);
    LoginGmailAuthFragment.access$402(this.this$0, paramString5);
    LoginManager.shareInstance().getGMailUserInfo(paramString2);
    this.this$0.refreshTopBar(true);
  }
  
  public void onGetUserInfoError(String paramString, QMNetworkError paramQMNetworkError)
  {
    String str;
    if ((paramQMNetworkError != null) && (!StringExtention.isNullOrEmpty(paramQMNetworkError.desp)))
    {
      str = paramQMNetworkError.desp;
      if ((paramQMNetworkError != null) && (paramQMNetworkError.code != 0)) {
        break label113;
      }
    }
    label113:
    for (int i = 1;; i = paramQMNetworkError.code)
    {
      QMLog.log(6, "LoginGmailAuthFragment", "GmailAuth, Get user info watcher error, accessToken:" + paramString + " code: " + i + " error desp: " + str);
      DataCollector.logDetailEvent("DetailEvent_Gmail_Login_AccountInfo", 0L, i, str);
      LoginGmailAuthFragment.access$500(this.this$0, "Gmail授权登录失败");
      this.this$0.refreshTopBar(false);
      return;
      str = "";
      break;
    }
  }
  
  public void onGetUserInfoSuccess(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    QMLog.log(4, "LoginGmailAuthFragment", "GmailAuth, Get user info watcher success, accessToken: " + paramString1 + " id: " + paramString2 + " email: " + paramString3 + " name: " + paramString4 + " picture: " + paramString5);
    DataCollector.logDetailEvent("DetailEvent_Gmail_Login_AccountInfo", 0L, 0L, "Gmail auth, get account info success email: " + LoginGmailAuthFragment.access$600(this.this$0));
    LoginGmailAuthFragment.access$602(this.this$0, paramString3);
    if ((this.this$0.isVerifyAccount) && (!this.this$0.fromGesPwdVerify) && (!this.this$0.fromGesPwdVerifyOvertimes) && (this.this$0.account != null) && (!LoginGmailAuthFragment.access$600(this.this$0).equals(this.this$0.account.getEmail())))
    {
      QMLog.log(4, "LoginGmailAuthFragment", "gmail verify difference");
      paramString2 = this.this$0;
      paramString3 = this.this$0.getString(2131695569);
      if (this.this$0.account.getEmail() != null) {}
      for (paramString1 = this.this$0.account.getEmail();; paramString1 = "")
      {
        LoginGmailAuthFragment.access$500(paramString2, paramString3.replace("$email$", paramString1));
        this.this$0.refreshTopBar(false);
        return;
      }
    }
    if (((this.this$0.fromGesPwdVerify) || (this.this$0.fromGesPwdVerifyOvertimes)) && (this.this$0.account != null) && (!AccountManager.shareInstance().getAccountList().isExistEmail(LoginGmailAuthFragment.access$600(this.this$0))))
    {
      if (AccountManager.shareInstance().getAccountList().size() > 1)
      {
        QMLog.log(3, "LoginGmailAuthFragment", "gmail gespwd multi difference " + LoginGmailAuthFragment.access$600(this.this$0));
        LoginGmailAuthFragment.access$500(this.this$0, this.this$0.getString(2131695530));
        this.this$0.refreshTopBar(false);
        return;
      }
      QMLog.log(3, "LoginGmailAuthFragment", "gmail verify difference");
      paramString2 = this.this$0;
      paramString3 = this.this$0.getString(2131695569);
      if (this.this$0.account.getEmail() != null) {}
      for (paramString1 = this.this$0.account.getEmail();; paramString1 = "")
      {
        LoginGmailAuthFragment.access$500(paramString2, paramString3.replace("$email$", paramString1));
        this.this$0.refreshTopBar(false);
        return;
      }
    }
    LoginGmailAuthFragment.access$700(this.this$0);
    this.this$0.refreshTopBar(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginGmailAuthFragment.1
 * JD-Core Version:    0.7.0.1
 */