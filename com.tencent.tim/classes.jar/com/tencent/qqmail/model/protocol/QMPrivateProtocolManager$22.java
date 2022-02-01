package com.tencent.qqmail.model.protocol;

import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMUMAError;

class QMPrivateProtocolManager$22
  extends SimpleOnProtocolListener
{
  QMPrivateProtocolManager$22(QMPrivateProtocolManager paramQMPrivateProtocolManager, String paramString) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    QMLog.log(4, "QMPrivateProtocolManager", "addRelatedAccount error code:" + paramCloudProtocolResult.error_code_);
    if ((paramCloudProtocolResult.error_code_ == 0) || (paramCloudProtocolResult.error_code_ == -10009))
    {
      this.this$0.loadEmailIconDirectly(this.val$relMail);
      return;
    }
    new QMUMAError(paramCloudProtocolResult.error_code_, "CloudProtocolService.AddAccount:" + this.val$relMail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.protocol.QMPrivateProtocolManager.22
 * JD-Core Version:    0.7.0.1
 */