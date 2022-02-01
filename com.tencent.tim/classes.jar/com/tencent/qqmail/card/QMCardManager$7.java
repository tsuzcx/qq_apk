package com.tencent.qqmail.card;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMUMAError;

class QMCardManager$7
  extends SimpleOnProtocolListener
{
  QMCardManager$7(QMCardManager paramQMCardManager, String paramString) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    QMLog.log(4, "QMCardManager", "delete card: " + paramCloudProtocolResult.error_code_);
    if (paramCloudProtocolResult.error_code_ == 0)
    {
      QMWatcherCenter.triggerDeleteCardSuccess(this.val$cardId);
      return;
    }
    QMWatcherCenter.triggerDeleteCardError(this.val$cardId, new QMUMAError(paramCloudProtocolResult.error_code_, "DeleteGreetingCard"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.QMCardManager.7
 * JD-Core Version:    0.7.0.1
 */