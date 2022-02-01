package com.tencent.qqmail;

import com.tencent.qqmail.pushconfig.QMPushConfigUtil;
import com.tencent.qqmail.utilities.log.QMLog;

class QMAPPUpgradeManager$7
  extends QMAPPUpgrade
{
  QMAPPUpgradeManager$7(QMAPPUpgradeManager paramQMAPPUpgradeManager1, QMAPPUpgradeManager paramQMAPPUpgradeManager2)
  {
    super(paramQMAPPUpgradeManager2);
  }
  
  public void doUpgrade(int paramInt)
  {
    QMLog.log(4, "QMAppUpgradeManager", "upgrade setting and popularize");
    QMAPPUpgradeManager.access$100(this.this$0);
    QMAPPUpgradeManager.access$200(this.this$0);
    QMPushConfigUtil.clearPushConfig();
  }
  
  public int getVersion()
  {
    return 5210;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.QMAPPUpgradeManager.7
 * JD-Core Version:    0.7.0.1
 */