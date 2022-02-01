package com.tencent.qqmail.account.model;

import android.app.Activity;
import android.content.Context;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.callback.LoginCallback;
import com.tencent.qqmail.account.helper.LoginUIHelper;
import com.tencent.qqmail.account.log.AddAccountLocalLogUtil;
import com.tencent.qqmail.model.mail.PasswordErrHandler;
import com.tencent.qqmail.network.filter.BackOffFilter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.NetworkManager;
import com.tencent.qqmail.utilities.qmnetwork.NetworkManager.SessionTask;
import com.tencent.qqmail.utilities.qmnetwork.QMCGIError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.login.QMLoginError;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class LoginUser$6
  extends LoginUser.Callback
{
  LoginUser$6(LoginUser paramLoginUser, LoginCallback paramLoginCallback)
  {
    super(paramLoginUser, null);
  }
  
  public void onError(QMNetworkError paramQMNetworkError)
  {
    Object localObject2 = new StringBuilder().append("autologinFail:").append(LoginUser.access$1700(this.this$0).getEmail()).append(".err:");
    Object localObject1;
    label77:
    label120:
    QMLoginError localQMLoginError;
    int i;
    if (paramQMNetworkError == null)
    {
      localObject1 = "err-is-null";
      AddAccountLocalLogUtil.timeLineAccountChange("CGI", (String)localObject1);
      localObject2 = new StringBuilder().append("doAutoLogin onError:");
      if (paramQMNetworkError != null) {
        break label401;
      }
      localObject1 = "err-is-null";
      QMLog.log(4, "LoginUser", (String)localObject1);
      boolean bool = paramQMNetworkError instanceof QMLoginError;
      if (!bool) {
        break label410;
      }
      if (!((QMLoginError)paramQMNetworkError).isNeedRetryAutologin()) {
        LoginUser.access$1400(this.this$0, paramQMNetworkError);
      }
      if (!bool) {
        break label790;
      }
      localObject2 = "";
      localQMLoginError = (QMLoginError)paramQMNetworkError;
      i = localQMLoginError.loginErrorType;
      localObject1 = localObject2;
      if (i == 1)
      {
        localObject1 = localObject2;
        if (localQMLoginError.tips != null)
        {
          localObject1 = localObject2;
          if (!localQMLoginError.tips.equals("")) {
            localObject1 = localQMLoginError.tips;
          }
        }
        AccountManager.shareInstance().saveAccountState(LoginUser.access$1700(this.this$0).getId(), -1);
      }
      if (i == 6) {
        AccountManager.shareInstance().saveAccountState(LoginUser.access$1700(this.this$0).getId(), -2);
      }
      if (i == 8)
      {
        QMLog.log(4, "LoginUser", "doAutoLogin. account suspend");
        AccountManager.shareInstance().saveAccountState(LoginUser.access$1700(this.this$0).getId(), -4);
      }
      if (i == 10)
      {
        QMLog.log(4, "LoginUser", "doAutoLogin. account not exist");
        AccountManager.shareInstance().saveAccountState(LoginUser.access$1700(this.this$0).getId(), -1);
      }
      if (i != -62) {
        break label453;
      }
      if (LoginUser.access$1500(this.this$0) < LoginUser.access$1800(this.this$0)) {
        break label421;
      }
      QMLog.log(4, "LoginUser", "autologin too many times:" + LoginUser.access$1500(this.this$0) + "," + LoginUser.access$1800(this.this$0));
      LoginUser.access$1502(this.this$0, 0);
      LoginUser.access$1400(this.this$0, paramQMNetworkError);
      if (this.val$loginCallback != null) {
        this.val$loginCallback.loginFail();
      }
    }
    label401:
    label410:
    label421:
    label453:
    label597:
    label627:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject1 = paramQMNetworkError.toString();
            break;
            localObject1 = paramQMNetworkError.toString();
            break label77;
            LoginUser.access$1400(this.this$0, paramQMNetworkError);
            break label120;
            LoginUser.access$1502(this.this$0, LoginUser.access$1500(this.this$0) + 1);
            LoginUser.access$1300(this.this$0, false, "", this.val$loginCallback);
            return;
            if ((i != -63) && (i != -15) && (i != -64)) {
              break label627;
            }
            QMLog.log(4, "LoginUser", "loginError.wtlogin loginErrorType:" + localQMLoginError.loginErrorType);
            if (LoginUser.access$1600(this.this$0) < LoginUser.access$1800(this.this$0)) {
              break label597;
            }
            QMLog.log(4, "LoginUser", "autologin wtlogin too many times:" + LoginUser.access$1600(this.this$0) + "," + LoginUser.access$1800(this.this$0));
            LoginUser.access$1602(this.this$0, 0);
            LoginUser.access$1400(this.this$0, paramQMNetworkError);
          } while (this.val$loginCallback == null);
          this.val$loginCallback.loginFail();
          return;
          LoginUser.access$1602(this.this$0, LoginUser.access$1600(this.this$0) + 1);
          LoginUser.access$1900(this.this$0, paramQMNetworkError, this.val$loginCallback);
          return;
          QMLog.log(4, "LoginUser", "loginError.loginErrorType : " + localQMLoginError.loginErrorType);
          if (i == 4)
          {
            QMLog.log(4, "LoginUser", "need second psw:" + LoginUser.access$1700(this.this$0).getId());
            PasswordErrHandler.saveStateAndShowErr(LoginUser.access$1700(this.this$0).getId(), -3);
            return;
          }
          if (i == 6)
          {
            QMLog.log(4, "LoginUser", "second psw err:" + LoginUser.access$1700(this.this$0).getId());
            PasswordErrHandler.saveStateAndShowErr(LoginUser.access$1700(this.this$0).getId(), -2);
            return;
          }
          QMLog.log(4, "LoginUser", "retryAutoLogin again");
          LoginUser.access$1300(this.this$0, true, (String)localObject1, this.val$loginCallback);
          return;
          if (!(paramQMNetworkError instanceof QMCGIError)) {
            break label873;
          }
          if (QMActivityManager.shareInstance().getVisibleActivity() != null)
          {
            LoginUIHelper.processCGIError(LoginUser.access$1700(this.this$0), (QMCGIError)paramQMNetworkError, QMActivityManager.shareInstance().getVisibleActivity(), null, null);
            LoginManager.shareInstance().triggerLoginError(LoginUser.access$1700(this.this$0).getId(), 0L, paramQMNetworkError, LoginUser.access$2000(this.this$0), true, true, -1);
          }
        } while (this.val$loginCallback == null);
        this.val$loginCallback.loginFail();
        return;
        if (paramQMNetworkError == null) {
          break label948;
        }
        localObject1 = QMActivityManager.shareInstance().getVisibleActivity();
        if (localObject1 != null)
        {
          Threads.runOnMainThread(new LoginUser.6.1(this, (Activity)localObject1));
          LoginManager.shareInstance().triggerLoginError(LoginUser.access$1700(this.this$0).getId(), 0L, paramQMNetworkError, LoginUser.access$2000(this.this$0), true, true, -1);
        }
      } while (this.val$loginCallback == null);
      this.val$loginCallback.loginFail();
      return;
      localObject1 = QMActivityManager.shareInstance().getVisibleActivity();
      if (localObject1 != null)
      {
        LoginUIHelper.processUnknownError((Context)localObject1, ((Activity)localObject1).getString(2131695520), null, null);
        LoginManager.shareInstance().triggerLoginError(LoginUser.access$1700(this.this$0).getId(), 0L, paramQMNetworkError, LoginUser.access$2000(this.this$0), true, true, -1);
      }
    } while (this.val$loginCallback == null);
    label790:
    label873:
    this.val$loginCallback.loginFail();
    label948:
  }
  
  public void onSuccess(String arg1)
  {
    LoginUser.access$1502(this.this$0, 0);
    LoginUser.access$1602(this.this$0, 0);
    AccountManager.shareInstance().saveAccountState(LoginUser.access$1700(this.this$0).getId(), 0);
    synchronized (((QQMailAccount)LoginUser.access$1700(this.this$0)).requestWaitingForSession)
    {
      Object localObject1 = ((QQMailAccount)LoginUser.access$1700(this.this$0)).requestWaitingForSession;
      Object localObject3 = new ArrayList((Collection)localObject1);
      ((ArrayList)localObject1).clear();
      localObject1 = ((ArrayList)localObject3).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject3 = (NetworkManager.SessionTask)((Iterator)localObject1).next();
        ((NetworkManager.SessionTask)localObject3).networkMgr.executeTask((NetworkManager.SessionTask)localObject3);
      }
    }
    QMLog.log(4, "Login", "login success.");
    BackOffFilter.resetError(BackOffFilter.genLoginBussinesId(LoginUser.access$1700(this.this$0).getId()));
    LoginUser.access$200(this.this$0, 0L, true);
    if (this.val$loginCallback != null) {
      this.val$loginCallback.loginSuccess();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.model.LoginUser.6
 * JD-Core Version:    0.7.0.1
 */