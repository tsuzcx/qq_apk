package com.tencent.qqmail.utilities.qmnetwork.service;

import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMUMAError;

class QMPushService$6
  extends SimpleOnProtocolListener
{
  QMPushService$6(QMPushService paramQMPushService, int paramInt, long paramLong) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    if (paramCloudProtocolResult.error_code_ != 0) {
      new QMUMAError(paramCloudProtocolResult.error_code_, "CloudProtocolService.CheckPendingTips");
    }
    for (;;)
    {
      QMLog.log(4, "QMPushService", "pullMail_tips:" + paramCloudProtocolResult.error_code_);
      return;
      QMPushService.access$3200(this.this$0, this.val$seqId);
      QMPushService.access$3300(this.this$0, this.val$now);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.QMPushService.6
 * JD-Core Version:    0.7.0.1
 */