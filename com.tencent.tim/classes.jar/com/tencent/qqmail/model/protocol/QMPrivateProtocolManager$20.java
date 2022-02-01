package com.tencent.qqmail.model.protocol;

import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMGeneralCallback;

class QMPrivateProtocolManager$20
  extends SimpleOnProtocolListener
{
  QMPrivateProtocolManager$20(QMPrivateProtocolManager paramQMPrivateProtocolManager, QMGeneralCallback paramQMGeneralCallback) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    QMLog.log(4, "QMPrivateProtocolManager", "umaLogin error code:" + paramCloudProtocolResult.error_code_);
    if (paramCloudProtocolResult.error_code_ == 0) {
      if (this.val$callback != null) {
        this.val$callback.onSuccess();
      }
    }
    while (this.val$callback == null) {
      return;
    }
    this.val$callback.onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.protocol.QMPrivateProtocolManager.20
 * JD-Core Version:    0.7.0.1
 */