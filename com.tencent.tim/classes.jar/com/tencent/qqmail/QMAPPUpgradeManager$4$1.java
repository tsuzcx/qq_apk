package com.tencent.qqmail;

import com.tencent.qqmail.folderlist.FolderDataManager;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.protocol.UMA.UserSetting;
import com.tencent.qqmail.protocol.UMA.UserSetting.Global;
import com.tencent.qqmail.utilities.log.QMLog;

class QMAPPUpgradeManager$4$1
  extends SimpleOnProtocolListener
{
  QMAPPUpgradeManager$4$1(QMAPPUpgradeManager.4 param4, int paramInt) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    if (paramCloudProtocolResult.error_code_ == 0)
    {
      paramCloudProtocolResult = paramCloudProtocolResult.user_setting_;
      if (paramCloudProtocolResult != null)
      {
        paramCloudProtocolResult = paramCloudProtocolResult.global();
        if (paramCloudProtocolResult != null)
        {
          QMLog.log(4, "QMAppUpgradeManager", "upgrade application_in_home:" + paramCloudProtocolResult.application_in_home() + " from:" + this.val$prevVersion);
          FolderDataManager.sharedInstance().setHasSync(false);
          FolderDataManager.sharedInstance().saveApplicationShowInHome(paramCloudProtocolResult.application_in_home());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.QMAPPUpgradeManager.4.1
 * JD-Core Version:    0.7.0.1
 */