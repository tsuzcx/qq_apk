package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.PbSendMsgReq;

class MessageHandler$1
  extends SendMessageHandler.SendMessageRunnable
{
  MessageHandler$1(MessageHandler paramMessageHandler, msg_svc.PbSendMsgReq paramPbSendMsgReq, int paramInt, long paramLong) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "sendReceiptMessageRead.prepareRetryRunnable: " + this.timeout + " / " + this.aaU);
    }
    ToServiceMsg localToServiceMsg = this.this$0.createToServiceMsg("MessageSvc.PbReceiptRead", null);
    localToServiceMsg.putWupBuffer(this.a.toByteArray());
    localToServiceMsg.extraData.putLong("msgSeq", this.cwT);
    localToServiceMsg.extraData.putInt("msgtype", 1);
    localToServiceMsg.extraData.putString("uin", Long.toString(this.ki));
    localToServiceMsg.extraData.putLong("timeOut", this.timeout);
    localToServiceMsg.extraData.putInt("retryIndex", this.aaU);
    localToServiceMsg.setTimeout(this.timeout);
    this.this$0.sendPbReq(localToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler.1
 * JD-Core Version:    0.7.0.1
 */