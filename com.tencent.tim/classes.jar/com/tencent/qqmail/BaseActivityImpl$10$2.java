package com.tencent.qqmail;

import android.app.Activity;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.MailServiceManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.activity.setting.PasswordErrHandling;
import com.tencent.qqmail.launcher.base.LauncherUtils;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.log.QMLogStream;

class BaseActivityImpl$10$2
  implements Runnable
{
  BaseActivityImpl$10$2(BaseActivityImpl.10 param10, int paramInt1, Account paramAccount, String paramString, int paramInt2) {}
  
  private void reviseAccountProtocol(Account paramAccount)
  {
    QMLog.log(4, "BaseActivityImpl", "reviseAccountProtocol." + paramAccount.getEmail());
    Object localObject;
    if (isQQAccount(paramAccount.getEmail())) {
      if (paramAccount.getProtocol() != 1)
      {
        localObject = new StringBuilder().append("set ").append(paramAccount.getEmail()).append(" from protocol ").append(paramAccount.getProtocol()).append(" to ").append(1);
        paramAccount.setProtocol(1);
        paramAccount.save();
        QMLog.log(4, "BaseActivityImpl", ((StringBuilder)localObject).toString());
        QMLogStream.logWithoutUmaNow(-40023, ((StringBuilder)localObject).toString(), "Event_Error");
      }
    }
    String[] arrayOfString;
    do
    {
      do
      {
        return;
        localObject = paramAccount.getEmail();
      } while (localObject == null);
      arrayOfString = ((String)localObject).split("@");
    } while (arrayOfString.length < 2);
    QMLog.log(4, "BaseActivityImpl", (String)localObject + " pwderr go query provider. domain:" + arrayOfString[1]);
    MailServiceManager.getInstance().getProviderFromWeb(100L, paramAccount.getEmail(), arrayOfString[1]);
  }
  
  boolean isQQAccount(String paramString)
  {
    return (paramString != null) && ((paramString.endsWith("@qq.com")) || (paramString.endsWith("@vip.qq.com")) || (paramString.endsWith("@foxmail.com")));
  }
  
  public void run()
  {
    if (BaseActivityImpl.access$000(this.this$1.this$0) == null) {
      return;
    }
    if (PasswordErrHandling.isHandling())
    {
      QMLog.log(4, "BaseActivityImpl", "acc : " + this.val$accountId + " psw err. not show dialog. 2");
      return;
    }
    QMLogStream.logWithoutUmaNow(-40012, this.val$acc.getEmail() + "," + this.val$acc.getProfileString(), "Event_App_Account_Psw_Err");
    String str;
    if ((this.val$tips == null) || (this.val$tips.equals("")))
    {
      str = String.format(BaseActivityImpl.access$000(this.this$1.this$0).getActivity().getString(2131719643), new Object[] { this.val$acc.getEmail() });
      if (this.val$state != -2) {
        break label326;
      }
      str = BaseActivityImpl.access$000(this.this$1.this$0).getActivity().getString(2131695559);
      label183:
      QMLog.log(4, "BaseActivityImpl", "onStateChangestate :" + this.val$state + ", " + str);
      if ((this.val$state != -2) && (this.val$state != -3)) {
        break label519;
      }
      QMLogStream.logWithoutUmaNow(-40020, this.val$acc.getEmail() + "," + this.val$state, "Event_Error");
    }
    for (;;)
    {
      QMLog.log(4, "BaseActivityImpl", "handle psw err. show dialog:" + AccountManager.shareInstance().getAccountList().getHashAccountPwd(this.val$acc.getId()));
      return;
      str = this.val$tips;
      break;
      label326:
      if (this.val$state == -3)
      {
        str = String.format(BaseActivityImpl.access$000(this.this$1.this$0).getActivity().getString(2131719644), new Object[] { this.val$acc.getEmail() });
        break label183;
      }
      if (this.val$state == -4)
      {
        str = String.format(BaseActivityImpl.access$000(this.this$1.this$0).getActivity().getString(2131689643), new Object[] { this.val$acc.getEmail() });
        break label183;
      }
      if (this.val$state != -5) {
        break label183;
      }
      if ((this.val$tips == null) || (this.val$tips.equals("")))
      {
        str = String.format(QMApplicationContext.sharedInstance().getString(2131689621), new Object[] { this.val$acc.getEmail() });
        break label183;
      }
      str = this.val$acc.getEmail() + "," + this.val$tips;
      break label183;
      label519:
      if (this.val$state == -1)
      {
        if ((this.val$acc instanceof QQMailAccount)) {
          reviseAccountProtocol(this.val$acc);
        }
        if ((LauncherUtils.APP_LAUCHER_TYPE == LauncherUtils.LAUCHER_FROM_PASSWARD_ERROR_PUSH) || (LauncherUtils.APP_LAUCHER_TYPE == LauncherUtils.LAUCHER_FROM_LOGIN_INVALID)) {
          LauncherUtils.APP_LAUCHER_TYPE = LauncherUtils.LAUCHER_FROM_MAIN;
        }
        BaseActivityImpl.access$800(this.this$1.this$0, str, this.val$acc, this.val$state);
      }
      else if (this.val$state == -6)
      {
        if ((LauncherUtils.APP_LAUCHER_TYPE == LauncherUtils.LAUCHER_FROM_PASSWARD_ERROR_PUSH) || (LauncherUtils.APP_LAUCHER_TYPE == LauncherUtils.LAUCHER_FROM_LOGIN_INVALID)) {
          LauncherUtils.APP_LAUCHER_TYPE = LauncherUtils.LAUCHER_FROM_MAIN;
        }
        BaseActivityImpl.access$800(this.this$1.this$0, str, this.val$acc, this.val$state);
      }
      else if (this.val$state == -4)
      {
        if ((LauncherUtils.APP_LAUCHER_TYPE == LauncherUtils.LAUCHER_FROM_PASSWARD_ERROR_PUSH) || (LauncherUtils.APP_LAUCHER_TYPE == LauncherUtils.LAUCHER_FROM_LOGIN_INVALID)) {
          LauncherUtils.APP_LAUCHER_TYPE = LauncherUtils.LAUCHER_FROM_MAIN;
        }
        BaseActivityImpl.access$800(this.this$1.this$0, str, this.val$acc, this.val$state);
      }
      else if (this.val$state == -5)
      {
        QMLog.log(4, "BaseActivityImpl", "ACCOUNT_STATE_DEVICE_LOCK:" + str);
        DataCollector.logDetailEvent("DetailEvent_WakeUp_Dev_Lock_Result", 0L, 0L, this.val$acc.getEmail());
        BaseActivityImpl.access$800(this.this$1.this$0, str, this.val$acc, this.val$state);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.10.2
 * JD-Core Version:    0.7.0.1
 */