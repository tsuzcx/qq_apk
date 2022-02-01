package com.tencent.qqmail;

import com.tencent.qqmail.utilities.UninstallWatcherHelper;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.service.UninstallService;

class QMAPPUpgradeManager$2
  extends QMAPPUpgrade
{
  QMAPPUpgradeManager$2(QMAPPUpgradeManager paramQMAPPUpgradeManager1, QMAPPUpgradeManager paramQMAPPUpgradeManager2)
  {
    super(paramQMAPPUpgradeManager2);
  }
  
  public void doUpgrade(int paramInt)
  {
    QMLog.log(4, "QMAppUpgradeManager", "upgrade for watchdog:" + paramInt);
    UninstallWatcherHelper.killUninstallWatchProcess();
    UninstallService.copyWatchDogForce();
    UninstallWatcherHelper.initWatchDog(true);
  }
  
  public int getVersion()
  {
    return 4100;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.QMAPPUpgradeManager.2
 * JD-Core Version:    0.7.0.1
 */