package com.tencent.qqmail;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.WipeAppWatcher;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;

class BaseActivityImpl$5
  implements WipeAppWatcher
{
  BaseActivityImpl$5(BaseActivityImpl paramBaseActivityImpl) {}
  
  private void gotoOtherPage()
  {
    int i = AccountManager.shareInstance().getAccountList().size();
    QMLog.log(4, "BaseActivityImpl", "after wipe account size:" + i);
    if (i == 0)
    {
      BaseActivityImpl.access$200(this.this$0);
      return;
    }
    if (i == 1)
    {
      BaseActivityImpl.access$300(this.this$0, AccountManager.shareInstance().getAccountList().get(0).getId());
      return;
    }
    BaseActivityImpl.access$400(this.this$0);
  }
  
  public void onWipe()
  {
    QMLog.log(4, "BaseActivityImpl", "onwipe called");
    if (!QMSettingManager.sharedInstance().getWipeAll())
    {
      long l = QMApplicationContext.sharedInstance().getVid();
      if (!QMSettingManager.sharedInstance().isVidWiped(l))
      {
        Threads.runOnMainThread(new BaseActivityImpl.5.3(this));
        QMLog.log(4, "BaseActivityImpl", "wipeWatcher:" + l);
        QMSettingManager.sharedInstance().setWipeAll(true);
        QMPrivateProtocolManager.sharedInstance().wipeEntireApp();
        BaseActivityImpl.access$200(this.this$0);
        QMLog.log(4, "BaseActivityImpl", "wipeWatcher end.");
        QMSettingManager.sharedInstance().setWipeAll(false);
        QMSettingManager.sharedInstance().setVidWiped(l);
        return;
      }
      QMLog.log(4, "BaseActivityImpl", "vid already wiped:" + l);
      return;
    }
    QMLog.log(4, "BaseActivityImpl", "app is wiping all. return");
  }
  
  public void onWipeActiveSync(int paramInt)
  {
    Object localObject = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    if (localObject == null)
    {
      QMLog.log(5, "BaseActivityImpl", "wipe ac account is null");
      return;
    }
    QMLog.log(4, "BaseActivityImpl", "ac wipeWatcher:" + paramInt);
    QMSettingManager.sharedInstance().setWipeActiveSync(paramInt, true);
    QMPrivateProtocolManager.sharedInstance().wipeActiveSyncAccount(paramInt);
    localObject = ((Account)localObject).getEmail();
    Threads.runOnMainThread(new BaseActivityImpl.5.1(this));
    Threads.runOnMainThread(new BaseActivityImpl.5.2(this, (String)localObject), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.5
 * JD-Core Version:    0.7.0.1
 */