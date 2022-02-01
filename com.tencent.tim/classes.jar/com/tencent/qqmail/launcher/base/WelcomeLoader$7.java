package com.tencent.qqmail.launcher.base;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import java.util.Iterator;

class WelcomeLoader$7
  implements Runnable
{
  WelcomeLoader$7(WelcomeLoader paramWelcomeLoader) {}
  
  public void run()
  {
    if (QMSettingManager.sharedInstance().getWipeAll())
    {
      QMPrivateProtocolManager.sharedInstance().wipeEntireApp();
      QMSettingManager.sharedInstance().setWipeAll(false);
    }
    for (;;)
    {
      if (QMNetworkUtils.isNetworkConnected()) {
        QMMailManager.sharedInstance().checkAlignAccount();
      }
      return;
      Iterator localIterator = AccountManager.shareInstance().getAccountList().iterator();
      while (localIterator.hasNext())
      {
        Account localAccount = (Account)localIterator.next();
        if ((localAccount.isActiveSyncMail()) && (QMSettingManager.sharedInstance().getWipeActiveSync(localAccount.getId()))) {
          QMPrivateProtocolManager.sharedInstance().wipeActiveSyncAccount(localAccount.getId());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.launcher.base.WelcomeLoader.7
 * JD-Core Version:    0.7.0.1
 */