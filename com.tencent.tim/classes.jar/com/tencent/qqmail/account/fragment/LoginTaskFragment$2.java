package com.tencent.qqmail.account.fragment;

import android.content.Intent;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.helper.Helper;
import com.tencent.qqmail.account.log.AddAccountFailLogUtil;
import com.tencent.qqmail.account.log.AddAccountLocalLogUtil;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.account.model.EmailDomainDefine;
import com.tencent.qqmail.account.model.EmailDomainDefine.DomainType;
import com.tencent.qqmail.account.watcher.AccountLoginWatcher;
import com.tencent.qqmail.activity.setting.PasswordErrHandling;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.log.QMLogStream;
import com.tencent.qqmail.utilities.qmnetwork.QMCGIError;
import com.tencent.qqmail.utilities.qmnetwork.QMCancelError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.login.QMLoginError;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.thread.Threads;
import moai.fragment.app.FragmentActivity;
import moai.oss.KvHelper;
import moai.oss.OssHelper;

class LoginTaskFragment$2
  implements AccountLoginWatcher
{
  LoginTaskFragment$2(LoginTaskFragment paramLoginTaskFragment) {}
  
  public void onError(int paramInt1, long paramLong, QMNetworkError paramQMNetworkError, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    if (this.this$0.userClickAbort) {}
    while ((this.this$0.currentLoginId != paramLong) || ((this.this$0.account != null) && (paramInt1 != this.this$0.account.getId())) || ((paramQMNetworkError instanceof QMCancelError))) {
      return;
    }
    this.this$0.needHandleLoginSuccess = false;
    int i;
    int j;
    label116:
    long l1;
    if (!this.this$0.isVerifyAccount) {
      if (paramBoolean1) {
        if ((paramQMNetworkError instanceof QMLoginError))
        {
          if ((!SharedPreferenceUtil.isWtlogin()) || (this.this$0.mAccountType == AccountType.exmail)) {
            break label541;
          }
          i = 1;
          if (i == 0) {
            break label547;
          }
          j = 2;
          localObject1 = AddAccountFailLogUtil.genAddAccountErrorCode(j, true, 0, ((QMCGIError)paramQMNetworkError).appCode, ((QMLoginError)paramQMNetworkError).loginErrorType);
          l1 = -1L;
        }
      }
    }
    try
    {
      l2 = Long.parseLong((String)localObject1);
      l1 = l2;
    }
    catch (Exception localException1)
    {
      long l2;
      label157:
      Object localObject2;
      break label157;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("DetailEventError -- AccountAddress:").append(paramString).append("&ErrorType:").append((String)localObject1);
    if (i != 0)
    {
      DataCollector.logDetailEvent("DetailEvent_WT_AddAccount", 0L, l1, ((StringBuilder)localObject2).toString());
      if (this.this$0.isMobileQQuickLogin)
      {
        DataCollector.logDetailEvent("DetailEvent_QuickLogin_AddAccount", 0L, l1, ((StringBuilder)localObject2).toString());
        OssHelper.realTimeReport(new Object[] { Long.valueOf(40263L), "", Integer.valueOf(1) });
        label258:
        AddAccountLocalLogUtil.timeLineAccountChange("CGI", "addAccount cgi fail:" + paramString + ". " + ((StringBuilder)localObject2).toString());
        label296:
        if (!(paramQMNetworkError instanceof QMLoginError)) {
          break label1040;
        }
        if (paramQMNetworkError.desp != null) {
          break label1030;
        }
        localObject1 = "";
        label316:
        DataCollector.logException(7, 2, "Event_Error", (String)localObject1, true);
        localObject1 = AccountType.splitDomain(paramString);
        if (!LoginTaskFragment.access$300(this.this$0, (String)localObject1)) {
          break label1075;
        }
        OssHelper.mailLogin(new Object[] { paramString, "ERROR", "AUTO_CONFIG", Long.valueOf(System.currentTimeMillis() - paramLong), "" + paramQMNetworkError });
        KvHelper.loginWithDetectProviderError(new double[0]);
        QMLog.log(4, "LoginAccountBaseFragment", "loginWithDetectProviderError");
        label416:
        if ((this.this$0.mAccountType != AccountType.qqmail) && (("163.com".equals(localObject1)) || ("126.com".equals(localObject1)) || ("yeah.net".equals(localObject1))) && ((paramQMNetworkError instanceof QMLoginError)))
        {
          if (((QMLoginError)paramQMNetworkError).loginErrorType != 5001) {
            break label1135;
          }
          DataCollector.logEvent("Event_Login_Imap_Denied_Error");
        }
      }
    }
    for (;;)
    {
      if ((!LoginTaskFragment.access$500(this.this$0, paramString)) || (!(paramQMNetworkError instanceof QMLoginError))) {
        break label1156;
      }
      localObject2 = (QMLoginError)paramQMNetworkError;
      if ((((QMLoginError)localObject2).loginErrorType == 1) || (((QMLoginError)localObject2).loginErrorType == 5)) {
        break label1156;
      }
      LoginTaskFragment.access$600(this.this$0, paramString);
      return;
      label541:
      i = 0;
      break;
      label547:
      j = 3;
      break label116;
      DataCollector.logDetailEvent("DetailEvent_NormalLogin_AddAccount", 0L, l1, ((StringBuilder)localObject2).toString());
      OssHelper.realTimeReport(new Object[] { Long.valueOf(40262L), "", Integer.valueOf(1) });
      break label258;
      DataCollector.logDetailEvent("DetailEvent_AddAccount", 0L, l1, ((StringBuilder)localObject2).toString());
      break label258;
      if (!(paramQMNetworkError instanceof QMLoginError)) {
        break label296;
      }
      localObject1 = AddAccountFailLogUtil.genAddAccountErrorCode(1, false, paramInt2, 0, ((QMLoginError)paramQMNetworkError).loginErrorType);
      l1 = -1L;
      try
      {
        l2 = Long.parseLong((String)localObject1);
        l1 = l2;
      }
      catch (Exception localException2)
      {
        label655:
        break label655;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("DetailEventError -- AccountAddress:").append(paramString).append("&ErrorCode:").append((String)localObject1).append("&DetailCode:").append(((QMLoginError)paramQMNetworkError).detailCode).append("&ErrMsg:").append(((QMLoginError)paramQMNetworkError).desp);
      DataCollector.logDetailEvent("DetailEvent_WY_AddAccount", 0L, l1, ((StringBuilder)localObject2).toString());
      AddAccountLocalLogUtil.timeLineAccountChange("APP", "addAccount outer fail:" + paramString + ". " + ((StringBuilder)localObject2).toString());
      break label296;
      localObject1 = "verifyAccountfail:";
      if (this.this$0.fromDeviceLock) {
        localObject1 = "deviceLockAccount fail:";
      }
      if (this.this$0.fromGesPwdVerify) {
        localObject1 = "gesPwdAccount fail:";
      }
      if (this.this$0.fromPwdErrVerify) {
        localObject1 = "pwdErrAccount fail:";
      }
      if (this.this$0.fromSettingAccount) {
        localObject1 = "settingAccount fail:";
      }
      if (this.this$0.from3GLoginToggleWT) {
        localObject1 = "3g toggle wt fail:";
      }
      if ((this.this$0.mAccountType == AccountType.qqmail) || (this.this$0.mAccountType == AccountType.exmail))
      {
        localObject2 = new StringBuilder().append((String)localObject1).append(paramString).append(". protocol:");
        if (this.this$0.account == null) {}
        for (localObject1 = "-1";; localObject1 = Integer.valueOf(this.this$0.account.getProtocol()))
        {
          AddAccountLocalLogUtil.timeLineAccountChange("CGI", localObject1);
          break;
        }
      }
      localObject2 = new StringBuilder().append((String)localObject1).append(paramString).append(". protocol:");
      if (this.this$0.account == null) {}
      for (localObject1 = "-1";; localObject1 = Integer.valueOf(this.this$0.account.getProtocol()))
      {
        AddAccountLocalLogUtil.timeLineAccountChange("APP", localObject1);
        break;
      }
      label1030:
      localObject1 = paramQMNetworkError.desp;
      break label316;
      label1040:
      if (paramQMNetworkError.desp == null) {}
      for (localObject1 = "";; localObject1 = paramQMNetworkError.desp)
      {
        QMLogStream.logWithoutUma(-40014, (String)localObject1, "Event_Error");
        break;
      }
      label1075:
      OssHelper.mailLogin(new Object[] { paramString, "ERROR", "WITH_PROVIDER", Long.valueOf(System.currentTimeMillis() - paramLong), "" + paramQMNetworkError });
      break label416;
      label1135:
      if (((QMLoginError)paramQMNetworkError).loginErrorType == 4) {
        DataCollector.logEvent("Event_Login_Imap_Auth_Error");
      }
    }
    label1156:
    Object localObject1 = EmailDomainDefine.getDoaminType((String)localObject1);
    if ((this.this$0.mAccountType != AccountType.qqmail) && (localObject1 != null) && ((paramQMNetworkError instanceof QMLoginError)))
    {
      LoginTaskFragment.access$400(this.this$0);
      LoginTaskFragment.access$700(this.this$0, (QMLoginError)paramQMNetworkError, (EmailDomainDefine.DomainType)localObject1);
      return;
    }
    if ((this.this$0.mAccountType == AccountType.qqmail) && ((paramQMNetworkError instanceof QMLoginError)) && (((QMLoginError)paramQMNetworkError).appCode == -100))
    {
      LoginTaskFragment.access$400(this.this$0);
      this.this$0.handleLoginQQUseProtocol();
      return;
    }
    this.this$0.handleLoginError(paramInt1, paramLong, paramQMNetworkError, paramString, paramBoolean1, paramBoolean2, paramInt2);
  }
  
  public void onProcess(int paramInt, long paramLong)
  {
    if (this.this$0.userClickAbort) {}
    while ((this.this$0.currentLoginId != paramLong) || ((this.this$0.account != null) && (paramInt != this.this$0.account.getId()))) {
      return;
    }
    this.this$0.handleLoginProcess(paramInt, paramLong);
  }
  
  public void onSuccess(int paramInt, long paramLong, boolean paramBoolean)
  {
    int i = 0;
    if (this.this$0.userClickAbort) {}
    while ((this.this$0.currentLoginId != paramLong) || ((this.this$0.account != null) && (paramInt != this.this$0.account.getId()))) {
      return;
    }
    if (this.this$0.account == null)
    {
      QMLog.log(6, "LoginAccountBaseFragment", "login success account null");
      return;
    }
    this.this$0.needHandleLoginSuccess = true;
    this.this$0.needHandleLoginError = false;
    QMLog.log(4, "LoginAccountBaseFragment", "loginWatcher. verify account success : " + this.this$0.account.getId() + ", " + this.this$0.account.getEmail());
    if ((paramBoolean) && (LoginTaskFragment.access$000(this.this$0, this.this$0.account.getEmail()))) {
      KvHelper.digitalLoginErrorJumpSuccess(new double[0]);
    }
    if (this.this$0.fromDeviceLock)
    {
      QMLog.log(4, "LoginAccountBaseFragment", "verify deviceLock success:" + this.this$0.account.getEmail());
      AddAccountLocalLogUtil.timeLineAccountChange("APP", "deviceLockAccount success:" + this.this$0.account.getEmail() + ", id:" + this.this$0.account.getId() + ", protocol:" + this.this$0.account.getProtocol());
      LoginManager.shareInstance().handleAuthSuccess(this.this$0.account, this.this$0.mAccountType, this.this$0.isMobileQQuickLogin);
      Threads.runOnMainThread(new LoginTaskFragment.2.1(this));
      Threads.runOnMainThread(new LoginTaskFragment.2.2(this), 700L);
      return;
    }
    if (this.this$0.from3GLoginToggleWT)
    {
      QMLog.log(4, "LoginAccountBaseFragment", "3GLogin Toggle WT success:" + this.this$0.account.getEmail());
      AddAccountLocalLogUtil.timeLineAccountChange("APP", "3GLogin Toggle WT success:" + this.this$0.account.getEmail() + ", id:" + this.this$0.account.getId() + ", protocol:" + this.this$0.account.getProtocol());
      LoginManager.shareInstance().handleAuthSuccess(this.this$0.account, this.this$0.mAccountType, this.this$0.isMobileQQuickLogin);
      Threads.runOnMainThread(new LoginTaskFragment.2.3(this));
      Threads.runOnMainThread(new LoginTaskFragment.2.4(this), 700L);
      return;
    }
    if (this.this$0.fromSettingPlugin)
    {
      QMLog.log(4, "LoginAccountBaseFragment", "setting account verify success:" + this.this$0.account.getEmail());
      AddAccountLocalLogUtil.timeLineAccountChange("APP", "" + this.this$0.getActivity().getIntent().getStringExtra("plug_in_type") + " setting success:" + this.this$0.account.getEmail() + ", id:" + this.this$0.account.getId() + ", protocol:" + this.this$0.account.getProtocol());
      localObject = LoginManager.shareInstance();
      Account localAccount = this.this$0.account;
      if (this.this$0.userInputPwd == null) {}
      for (paramInt = i;; paramInt = this.this$0.userInputPwd.length())
      {
        ((LoginManager)localObject).initNewAccount(localAccount, paramInt, this.this$0.isMobileQQuickLogin);
        Threads.runOnMainThread(new LoginTaskFragment.2.5(this), 700L);
        return;
      }
    }
    if (this.this$0.fromSettingAccount)
    {
      QMLog.log(4, "LoginAccountBaseFragment", "verify settingaccount success:" + this.this$0.account.getEmail());
      AddAccountLocalLogUtil.timeLineAccountChange("APP", "settingAccount success:" + this.this$0.account.getEmail() + ", id:" + this.this$0.account.getId() + ", protocol:" + this.this$0.account.getProtocol());
      LoginTaskFragment.access$100(this.this$0);
      return;
    }
    if (this.this$0.fromPwdErrVerify)
    {
      QMLog.log(4, "LoginAccountBaseFragment", "verify pswerr success:" + this.this$0.account.getEmail());
      AddAccountLocalLogUtil.timeLineAccountChange("APP", "pwdErrAccount success:" + this.this$0.account.getEmail() + ", id:" + this.this$0.account.getId() + ", protocol:" + this.this$0.account.getProtocol());
      PasswordErrHandling.setHandling(false);
      LoginTaskFragment.access$100(this.this$0);
      return;
    }
    if (this.this$0.fromGesPwdVerify)
    {
      QMLog.log(4, "LoginAccountBaseFragment", "verify gespwd success:" + this.this$0.account.getEmail());
      AddAccountLocalLogUtil.timeLineAccountChange("APP", "gesPwdAccount success:" + this.this$0.account.getEmail() + ", id:" + this.this$0.account.getId() + ", protocol:" + this.this$0.account.getProtocol());
      LoginManager.shareInstance().reSaveAccountAfterVerifyGes(this.this$0.account, this.this$0.isMobileQQuickLogin);
      LoginTaskFragment.access$200(this.this$0);
      return;
    }
    if (AccountManager.shareInstance().getAccountList().hasAccount(paramInt))
    {
      PasswordErrHandling.setHandling(false);
      LoginTaskFragment.access$100(this.this$0);
      return;
    }
    Object localObject = AccountType.splitDomain(this.this$0.account.getEmail());
    if (LoginTaskFragment.access$300(this.this$0, (String)localObject))
    {
      OssHelper.mailLoginConfig(new Object[] { this.this$0.account.getConfigString() });
      KvHelper.loginWithDetectProviderSuccess(new double[0]);
      QMLog.log(4, "LoginAccountBaseFragment", "loginWithDetectProviderSuccess");
    }
    for (;;)
    {
      Helper.logAfterLoginSuccess(this.this$0.account, this.this$0.isMobileQQuickLogin, paramLong);
      LoginTaskFragment.access$400(this.this$0);
      this.this$0.handleLoginSuccess(paramInt, paramLong, paramBoolean);
      return;
      OssHelper.mailLogin(new Object[] { this.this$0.account.getEmail(), "SUCCESS", "WITH_PROVIDER", Long.valueOf(System.currentTimeMillis() - paramLong) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginTaskFragment.2
 * JD-Core Version:    0.7.0.1
 */