package com.tencent.qqmail;

import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.UninstallWatcherHelper;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.service.UninstallService;

class QMAPPUpgradeManager$3
  extends QMAPPUpgrade
{
  QMAPPUpgradeManager$3(QMAPPUpgradeManager paramQMAPPUpgradeManager1, QMAPPUpgradeManager paramQMAPPUpgradeManager2)
  {
    super(paramQMAPPUpgradeManager2);
  }
  
  public void doUpgrade(int paramInt)
  {
    QMAPPUpgradeManager.access$000(this.this$0);
    if (paramInt >= 4000) {
      QMSettingManager.sharedInstance().setCalendarNew(false);
    }
    QMLog.log(4, "QMAppUpgradeManager", "upgrade for watchdog for start push service:" + paramInt);
    UninstallWatcherHelper.killUninstallWatchProcess();
    UninstallService.copyWatchDogForce();
    UninstallWatcherHelper.initWatchDog(true);
  }
  
  public int getVersion()
  {
    return 4120;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.QMAPPUpgradeManager.3
 * JD-Core Version:    0.7.0.1
 */