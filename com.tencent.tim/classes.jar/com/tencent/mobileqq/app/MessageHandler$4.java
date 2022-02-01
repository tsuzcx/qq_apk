package com.tencent.mobileqq.app;

import acci;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.PbSendMsgReq;

class MessageHandler$4
  extends SendMessageHandler.SendMessageRunnable
{
  MessageHandler$4(MessageHandler paramMessageHandler, MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq, acci paramacci, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "--->sendRichTextMessageWith_MR : resend message");
    }
    MessageHandler.a(this.this$0, this.a, this.b, this.timeout, this.aaU, this.e, this.bIw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler.4
 * JD-Core Version:    0.7.0.1
 */