package com.tencent.qqmail;

import com.tencent.qqmail.protocol.CloudProtocolHelper;
import com.tencent.qqmail.protocol.CloudProtocolInfo;
import com.tencent.qqmail.protocol.CloudProtocolService;
import com.tencent.qqmail.utilities.log.QMLog;

class QMAPPUpgradeManager$4
  extends QMAPPUpgrade
{
  QMAPPUpgradeManager$4(QMAPPUpgradeManager paramQMAPPUpgradeManager1, QMAPPUpgradeManager paramQMAPPUpgradeManager2)
  {
    super(paramQMAPPUpgradeManager2);
  }
  
  public void doUpgrade(int paramInt)
  {
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    if (localCloudProtocolInfo == null)
    {
      QMLog.log(6, "QMAppUpgradeManager", "get user setting info null");
      return;
    }
    CloudProtocolService.GetUserSetting(localCloudProtocolInfo, new QMAPPUpgradeManager.4.1(this, paramInt));
  }
  
  public int getVersion()
  {
    return 5100;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.QMAPPUpgradeManager.4
 * JD-Core Version:    0.7.0.1
 */