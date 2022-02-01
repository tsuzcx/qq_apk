package com.tencent.qqmail.model.protocol;

import android.content.SharedPreferences.Editor;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMUMAError;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;

class QMPrivateProtocolManager$10
  extends SimpleOnProtocolListener
{
  QMPrivateProtocolManager$10(QMPrivateProtocolManager paramQMPrivateProtocolManager, String paramString) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    QMLog.log(4, "QMPrivateProtocolManager", "syncAdStat error code:" + paramCloudProtocolResult.error_code_);
    if (paramCloudProtocolResult.error_code_ == 0)
    {
      SPManager.getEditor("user_info").putString("configtype_7", "").apply();
      QMLog.log(4, "QMPrivateProtocolManager", "configtype_7 cleared.");
      return;
    }
    new QMUMAError(paramCloudProtocolResult.error_code_, "CloudProtocolService.AddADBWContact:" + this.val$address);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.protocol.QMPrivateProtocolManager.10
 * JD-Core Version:    0.7.0.1
 */