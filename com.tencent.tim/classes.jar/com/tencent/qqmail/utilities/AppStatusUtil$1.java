package com.tencent.qqmail.utilities;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.pushconfig.QMPushConfigUtil;
import com.tencent.qqmail.utilities.cacheclear.QMClearCacheManager;
import com.tencent.qqmail.utilities.keepalive.KeepAliveManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.log.QMLogStream;
import com.tencent.qqmail.utilities.osslog.QMOssClient;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushMailNotify;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.Iterator;

final class AppStatusUtil$1
  implements Runnable
{
  public void run()
  {
    Object localObject = AccountManager.shareInstance().getAccountList().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Account localAccount = (Account)((Iterator)localObject).next();
      if ((localAccount.isGMail()) && (localAccount.getAccountState() == -6))
      {
        AccountManager.shareInstance().triggerAccountStateChange(localAccount.getId(), -6, "");
        QMLog.log(6, "AppStatusUtil", "Gmail reauth push didGotoForeground called, accountid: " + localAccount.getId());
      }
    }
    QMMailManager.sharedInstance().syncAll();
    QMMailManager.sharedInstance().checkUpdateConfig(false);
    Threads.runInBackground(new AppStatusUtil.1.1(this), 4000L);
    QMMailManager.sharedInstance().checkAccountStateChange();
    AppStatusUtil.access$000();
    AppStatusUtil.access$100();
    QMPushMailNotify.getInstance().clearNewMailFoldNotify();
    QMPushConfigUtil.handleBetaCheckUpgrade();
    AppStatusUtil.logWakeup();
    QMClearCacheManager.reportCacheDaily();
    QMClearCacheManager.shareInstance().clearCacheDaily();
    if ((QMSettingManager.sharedInstance().getBonus()) && (QMSettingManager.sharedInstance().getBonusTest())) {
      QMOssClient.getInstance().showSubmitLogNotification();
    }
    KeepAliveManager.checkStatusBar();
    if (AppStatusUtil.isAppOnForeground()) {}
    for (localObject = "1";; localObject = "0")
    {
      QMLogStream.logWithoutUmaNow(-40006, (String)localObject, "Event_App_State");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.AppStatusUtil.1
 * JD-Core Version:    0.7.0.1
 */