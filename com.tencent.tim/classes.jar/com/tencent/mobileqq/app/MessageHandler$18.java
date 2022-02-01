package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable;
import com.tencent.qphone.base.remote.ToServiceMsg;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;

class MessageHandler$18
  extends SendMessageHandler.SendMessageRunnable
{
  MessageHandler$18(MessageHandler paramMessageHandler, msg_svc.PbMsgReadedReportReq paramPbMsgReadedReportReq, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    ToServiceMsg localToServiceMsg = this.this$0.createToServiceMsg("PbMessageSvc.PbMsgReadedReport");
    localToServiceMsg.putWupBuffer(this.b.toByteArray());
    localToServiceMsg.extraData.putLong("timeOut", this.timeout);
    localToServiceMsg.extraData.putLong("startTime", this.val$startTime);
    localToServiceMsg.extraData.putInt("retryIndex", this.aaU);
    localToServiceMsg.extraData.putLong("msgSeq", this.sP);
    localToServiceMsg.setEnableFastResend(true);
    localToServiceMsg.setTimeout(this.timeout);
    this.this$0.sendPbReq(localToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler.18
 * JD-Core Version:    0.7.0.1
 */