package com.tencent.qqmail.utilities.qmnetwork.service;

import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.utilities.log.QMLog;

class QMServiceManager$5
  implements Runnable
{
  QMServiceManager$5(QMServiceManager paramQMServiceManager, int paramInt, String paramString) {}
  
  public void run()
  {
    QMLog.log(4, "webpush", "run uploadDebugLog. duration:" + this.val$duration);
    QMPrivateProtocolManager.sharedInstance().handleUploadDebugLog(this.val$duration, this.val$params);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.QMServiceManager.5
 * JD-Core Version:    0.7.0.1
 */