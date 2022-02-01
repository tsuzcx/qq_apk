package com.tencent.qqmail;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.calendar.model.QMCalendarProtocolManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushService;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;

class QMAPPUpgradeManager$1
  extends QMAPPUpgrade
{
  QMAPPUpgradeManager$1(QMAPPUpgradeManager paramQMAPPUpgradeManager1, QMAPPUpgradeManager paramQMAPPUpgradeManager2)
  {
    super(paramQMAPPUpgradeManager2);
  }
  
  public void doUpgrade(int paramInt)
  {
    int k = 0;
    QMApplicationContext.sharedInstance().startService(QMPushService.createChangeSessionKeyIntent());
    QMLog.log(4, "QMAppUpgradeManager", "notify push service to force requesting a new sessionkey");
    AccountList localAccountList = AccountManager.shareInstance().getAccountList();
    int i = 0;
    int j = 0;
    while (i < localAccountList.size())
    {
      if ((localAccountList.get(i).isQQMail()) || (localAccountList.get(i).isTencentDotCom()))
      {
        QMCalendarManager.getInstance().login(localAccountList.get(i), QMCalendarProtocolManager.getLoginType(localAccountList.get(i), 1), null);
        j = 1;
      }
      i += 1;
    }
    if (j == 0)
    {
      if (paramInt != 0) {
        QMSettingManager.sharedInstance().setCalendarNew(true);
      }
      QMSettingManager.sharedInstance().setCalendarDisplay(false);
      QMSettingManager.sharedInstance().setNoteDisplay(false);
      QMSettingManager.sharedInstance().setFtnDisplay(false);
    }
    if (QMPrivateProtocolManager.sharedInstance() != null) {
      QMPrivateProtocolManager.sharedInstance().setGlobalUserSetting();
    }
    if (!SharedPreferenceUtil.isWtlogin())
    {
      paramInt = k;
      while (paramInt < localAccountList.size())
      {
        Account localAccount = localAccountList.get(paramInt);
        if ((localAccount.isQQMail()) && (!localAccount.isBizMail()))
        {
          QMLog.log(4, "QMAppUpgradeManager", "doUpgrade. " + localAccount.getId() + " go auto login");
          ((QQMailAccount)localAccount).autoLogin();
        }
        paramInt += 1;
      }
    }
  }
  
  public int getVersion()
  {
    return 4000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.QMAPPUpgradeManager.1
 * JD-Core Version:    0.7.0.1
 */