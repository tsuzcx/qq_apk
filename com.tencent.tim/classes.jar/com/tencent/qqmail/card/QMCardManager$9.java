package com.tencent.qqmail.card;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMUMAError;

class QMCardManager$9
  extends SimpleOnProtocolListener
{
  QMCardManager$9(QMCardManager paramQMCardManager, String paramString, long paramLong) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    QMLog.log(4, "QMCardManager", "thank card list: " + paramCloudProtocolResult.error_code_);
    if (paramCloudProtocolResult.error_code_ == 0)
    {
      QMWatcherCenter.triggerThankCardSuccess(this.val$cardId, this.val$uin);
      return;
    }
    QMWatcherCenter.triggerThankCardError(this.val$cardId, this.val$uin, new QMUMAError(paramCloudProtocolResult.error_code_, "ThankGreetingCard"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.QMCardManager.9
 * JD-Core Version:    0.7.0.1
 */