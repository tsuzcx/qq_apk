package com.tencent.qqmail.account.fragment;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.helper.Helper;
import com.tencent.qqmail.account.helper.QMWtLoginManager;
import com.tencent.qqmail.account.log.AddAccountLocalLogUtil;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.account.watcher.WtLoginVerifySMSWatcher;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.register.RegisterManager;
import com.tencent.qqmail.register.util.RegisterUtil;
import com.tencent.qqmail.utilities.common.CommUtils;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import moai.core.watcher.Watchers;
import moai.oss.KvHelper;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper.QuickLoginParam;
import oicq.wlogin_sdk.request.WtloginListener;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class LoginAccountFragment$60
  extends WtloginListener
{
  LoginAccountFragment$60(LoginAccountFragment paramLoginAccountFragment) {}
  
  private void handleNeedSms(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public void OnCheckSMSAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    QMLog.log(4, "LoginAccountFragment", "OnCheckSMSAndGetSt userAccount:" + paramString + ",ret:" + paramInt + ",userInputAccountFromSDK:" + LoginAccountFragment.access$3000(this.this$0) + ",errMsg:" + paramErrMsg);
    ((WtLoginVerifySMSWatcher)Watchers.of(WtLoginVerifySMSWatcher.class)).OnCheckSMSAndGetSt(paramString, paramArrayOfByte, paramWUserSigInfo, paramInt, paramErrMsg);
    if (paramInt == 0)
    {
      KvHelper.eventNewWtLoginSuccess(new double[0]);
      if (this.this$0.isVerifyAccount) {}
      for (paramArrayOfByte = "DetailEvent_WakeUp_Dev_Lock_Result";; paramArrayOfByte = "DetailEvent_Login_Dev_Lock_Result")
      {
        DataCollector.logDetailEvent(paramArrayOfByte, 0L, 0L, paramString);
        paramArrayOfByte = LoginAccountFragment.access$4000(this.this$0).getBasicUserInfo(paramString);
        if (paramArrayOfByte != null) {
          break;
        }
        QMLog.log(5, "LoginAccountFragment", "basicUserInfo null: " + paramString);
        return;
      }
      this.this$0.refreshTopBar(true);
      paramArrayOfByte = String.valueOf(paramArrayOfByte._uin);
      paramWUserSigInfo = LoginAccountFragment.access$4000(this.this$0).getA2(paramArrayOfByte);
      QMLog.log(4, "LoginAccountFragment", "OnCheckSMSAndGetSt uin:" + paramArrayOfByte + ", userAccount:" + paramString);
      if (StringExtention.isNullOrEmpty(LoginAccountFragment.access$3000(this.this$0))) {
        LoginAccountFragment.access$3002(this.this$0, paramString);
      }
      this.this$0.currentLoginId = System.currentTimeMillis();
      boolean bool1;
      if (CommUtils.isPureNumber(LoginAccountFragment.access$3000(this.this$0)))
      {
        if (RegisterUtil.isMobiPhoneNum(LoginAccountFragment.access$3000(this.this$0)))
        {
          LoginAccountFragment.access$1702(this.this$0, LoginAccountFragment.access$3000(this.this$0));
          LoginAccountFragment.access$1802(this.this$0, paramArrayOfByte);
          LoginAccountFragment.access$3002(this.this$0, LoginAccountFragment.access$3000(this.this$0) + "@qq.com");
          RegisterManager.checkPhoneAndUinRelationship(LoginAccountFragment.access$1700(this.this$0), paramArrayOfByte);
          return;
        }
        LoginAccountFragment.access$3002(this.this$0, LoginAccountFragment.access$3000(this.this$0) + "@qq.com");
        paramString = this.this$0;
        paramErrMsg = LoginManager.shareInstance();
        l = this.this$0.currentLoginId;
        str = LoginAccountFragment.access$3000(this.this$0);
        if (this.this$0.mAccountType == AccountType.exmail)
        {
          bool1 = true;
          if (this.this$0.isVerifyAccount) {
            break label466;
          }
        }
        label466:
        for (bool2 = true;; bool2 = false)
        {
          paramString.account = paramErrMsg.verifyQQMailAccountWtlogin(l, str, paramWUserSigInfo, "", paramArrayOfByte, bool1, bool2);
          return;
          bool1 = false;
          break;
        }
      }
      paramString = this.this$0;
      paramErrMsg = LoginManager.shareInstance();
      long l = this.this$0.currentLoginId;
      String str = LoginAccountFragment.access$3000(this.this$0);
      if (this.this$0.mAccountType == AccountType.exmail)
      {
        bool1 = true;
        if (this.this$0.isVerifyAccount) {
          break label557;
        }
      }
      label557:
      for (boolean bool2 = true;; bool2 = false)
      {
        paramString.account = paramErrMsg.verifyQQMailAccountWtlogin(l, str, paramWUserSigInfo, "", paramArrayOfByte, bool1, bool2);
        return;
        bool1 = false;
        break;
      }
    }
    KvHelper.eventNewWtLoginFail(new double[0]);
    this.this$0.refreshTopBar(false);
    if (paramInt == 160)
    {
      handleNeedSms(paramString);
      if (this.this$0.isVerifyAccount) {
        break label841;
      }
      Helper.logWtLoginError(paramInt, this.this$0.userInputEmail, this.this$0.isMobileQQuickLogin);
      paramArrayOfByte = new StringBuilder().append(paramString).append(":").append(paramInt).append(":");
      if (paramErrMsg != null) {
        break label832;
      }
    }
    label832:
    for (paramString = "";; paramString = paramErrMsg.getMessage())
    {
      DataCollector.logDetailEvent("DetailEvent_Login_Dev_Lock_Result", 0L, 1L, paramString);
      return;
      if (paramInt == 40)
      {
        LoginAccountFragment.access$4600(this.this$0, this.this$0.getString(2131689507), this.this$0.getString(2131689511), "http://aq.qq.com/007");
        break;
      }
      if (paramInt == 32)
      {
        LoginAccountFragment.access$4600(this.this$0, this.this$0.getString(2131689507), this.this$0.getString(2131689510), "http://zc.qq.com");
        break;
      }
      if (paramInt == 42)
      {
        LoginAccountFragment.access$4600(this.this$0, this.this$0.getString(2131689488), this.this$0.getString(2131689509), "http://aq.qq.com/mp");
        break;
      }
      if ((paramErrMsg.getMessage() != null) && (!paramErrMsg.getMessage().equals(""))) {}
      for (paramArrayOfByte = paramErrMsg.getMessage();; paramArrayOfByte = this.this$0.getString(2131695511))
      {
        LoginAccountFragment.access$4200(this.this$0, paramArrayOfByte);
        break;
      }
    }
    label841:
    paramArrayOfByte = new StringBuilder().append(paramString).append(":").append(paramInt).append(":");
    if (paramErrMsg == null) {}
    for (paramString = "";; paramString = paramErrMsg.getMessage())
    {
      DataCollector.logDetailEvent("DetailEvent_WakeUp_Dev_Lock_Result", 0L, 1L, paramString);
      return;
    }
  }
  
  public void OnRefreshSMSData(String paramString, long paramLong, WUserSigInfo paramWUserSigInfo, int paramInt1, int paramInt2, int paramInt3, ErrMsg paramErrMsg)
  {
    QMLog.log(4, "LoginAccountFragment", "OnRefreshSMSData userAccount:" + paramString + ",smsAppId:" + paramLong + ",remainMsgCnt" + paramInt1 + ",timeLimit:" + paramInt2 + ",ret:" + paramInt3 + ",errMsg:" + paramErrMsg);
    ((WtLoginVerifySMSWatcher)Watchers.of(WtLoginVerifySMSWatcher.class)).OnRefreshSMSData(paramString, paramLong, paramWUserSigInfo, paramInt1, paramInt2, paramInt3, paramErrMsg);
    if (paramInt3 != 0)
    {
      this.this$0.refreshTopBar(false);
      Helper.logWtLoginError(paramInt3, paramString, this.this$0.isMobileQQuickLogin);
      LoginAccountFragment.access$4700(this.this$0, new LoginAccountFragment.60.1(this, paramErrMsg));
    }
  }
  
  public void onQuickLogin(String paramString, WtloginHelper.QuickLoginParam paramQuickLoginParam, int paramInt, ErrMsg paramErrMsg)
  {
    QMLog.log(4, "LoginAccountFragment", "onQuickLogin account:" + paramString + ", ret:" + paramInt + ", errMsg:" + paramErrMsg);
    if (paramQuickLoginParam.userSigInfo.userSeq == LoginTaskFragment.wtloginSeq)
    {
      QMLog.log(4, "LoginAccountFragment", "wtlogin right callback seq");
      KvHelper.detaileventNewWtLoginOnQuickResult(paramInt + "_end", new double[0]);
      if (paramInt != 0) {
        break label767;
      }
      KvHelper.eventNewWtLoginSuccess(new double[0]);
      paramQuickLoginParam = LoginAccountFragment.access$4000(this.this$0).getBasicUserInfo(paramString);
      if (paramQuickLoginParam == null) {
        QMLog.log(5, "LoginAccountFragment", "basicUserInfo null: " + paramString);
      }
    }
    else
    {
      QMLog.log(6, "LoginAccountFragment", "wt seq error:" + paramQuickLoginParam.userSigInfo.userSeq + " " + LoginTaskFragment.wtloginSeq);
      KvHelper.wtLoginDifferentSeq(new double[0]);
      return;
    }
    paramQuickLoginParam = String.valueOf(paramQuickLoginParam._uin);
    paramErrMsg = LoginAccountFragment.access$4000(this.this$0).getA2(paramQuickLoginParam);
    QMLog.log(4, "LoginAccountFragment", "onQuickLogin uin:" + paramQuickLoginParam + ", userAccount:" + paramString + ",userInputAccountFromSDK:" + LoginAccountFragment.access$3000(this.this$0));
    AccountManager.shareInstance().getAccountList();
    Object localObject = AccountManager.shareInstance().getAccountList().getQQMailAccountByUin(paramQuickLoginParam);
    if ((!this.this$0.isVerifyAccount) && (localObject != null))
    {
      AddAccountLocalLogUtil.logAddAccountLocalFail(this.this$0.userInputEmail, this.this$0.mAccountType, 5);
      LoginAccountFragment.access$3400(this.this$0, ((QQMailAccount)localObject).getId(), ((QQMailAccount)localObject).getEmail());
      return;
    }
    if ((this.this$0.isVerifyAccount) && (this.this$0.account != null) && (!paramQuickLoginParam.equals(this.this$0.account.getUin())))
    {
      LoginAccountFragment.access$4300(this.this$0, this.this$0.account.getEmail());
      return;
    }
    this.this$0.refreshTopBar(true);
    if (StringExtention.isNullOrEmpty(LoginAccountFragment.access$3000(this.this$0))) {
      LoginAccountFragment.access$3002(this.this$0, paramString);
    }
    this.this$0.currentLoginId = System.currentTimeMillis();
    boolean bool1;
    if (CommUtils.isPureNumber(LoginAccountFragment.access$3000(this.this$0)))
    {
      if (RegisterUtil.isMobiPhoneNum(LoginAccountFragment.access$3000(this.this$0)))
      {
        LoginAccountFragment.access$1702(this.this$0, LoginAccountFragment.access$3000(this.this$0));
        LoginAccountFragment.access$1802(this.this$0, paramQuickLoginParam);
        LoginAccountFragment.access$3002(this.this$0, LoginAccountFragment.access$3000(this.this$0) + "@qq.com");
        RegisterManager.checkPhoneAndUinRelationship(LoginAccountFragment.access$1700(this.this$0), paramQuickLoginParam);
        return;
      }
      LoginAccountFragment.access$3002(this.this$0, LoginAccountFragment.access$3000(this.this$0) + "@qq.com");
      paramString = this.this$0;
      localObject = LoginManager.shareInstance();
      l = this.this$0.currentLoginId;
      str = LoginAccountFragment.access$3000(this.this$0);
      if (this.this$0.mAccountType == AccountType.exmail)
      {
        bool1 = true;
        if (this.this$0.isVerifyAccount) {
          break label650;
        }
      }
      label650:
      for (bool2 = true;; bool2 = false)
      {
        paramString.account = ((LoginManager)localObject).verifyQQMailAccountWtlogin(l, str, paramErrMsg, "", paramQuickLoginParam, bool1, bool2);
        return;
        bool1 = false;
        break;
      }
    }
    LoginAccountFragment.access$4402(this.this$0, paramErrMsg);
    LoginAccountFragment.access$4502(this.this$0, paramQuickLoginParam);
    paramString = this.this$0;
    localObject = LoginManager.shareInstance();
    long l = this.this$0.currentLoginId;
    String str = LoginAccountFragment.access$3000(this.this$0);
    if (this.this$0.mAccountType == AccountType.exmail)
    {
      bool1 = true;
      if (this.this$0.isVerifyAccount) {
        break label761;
      }
    }
    label761:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramString.account = ((LoginManager)localObject).verifyQQMailAccountWtlogin(l, str, paramErrMsg, "", paramQuickLoginParam, bool1, bool2);
      return;
      bool1 = false;
      break;
    }
    label767:
    KvHelper.eventNewWtLoginFail(new double[0]);
    this.this$0.refreshTopBar(false);
    DataCollector.logDetailEvent("DetailEvent_WT_Get_Ticket_Error", 0L, 1L, paramString + "#" + QMWtLoginManager.GET_TICKET_ERR_NEW_USER + "#" + paramInt);
    Helper.logWtLoginError(paramInt, paramString, this.this$0.isMobileQQuickLogin);
    AddAccountLocalLogUtil.timeLineAccountChange("SDK", "addAccount wt fail: userAccount:" + paramString + ", ret:" + paramInt);
    if (paramInt == 160)
    {
      handleNeedSms(paramString);
      return;
    }
    if (paramInt == 40)
    {
      LoginAccountFragment.access$4600(this.this$0, this.this$0.getString(2131689507), this.this$0.getString(2131689511), "http://aq.qq.com/007");
      return;
    }
    if (paramInt == 32)
    {
      LoginAccountFragment.access$4600(this.this$0, this.this$0.getString(2131689507), this.this$0.getString(2131689510), "http://zc.qq.com");
      return;
    }
    if (paramInt == 42)
    {
      LoginAccountFragment.access$4600(this.this$0, this.this$0.getString(2131689488), this.this$0.getString(2131689509), "http://aq.qq.com/mp");
      return;
    }
    if ((paramErrMsg.getMessage() != null) && (!paramErrMsg.getMessage().equals(""))) {}
    for (paramString = paramErrMsg.getMessage();; paramString = this.this$0.getString(2131695511))
    {
      LoginAccountFragment.access$4200(this.this$0, paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginAccountFragment.60
 * JD-Core Version:    0.7.0.1
 */