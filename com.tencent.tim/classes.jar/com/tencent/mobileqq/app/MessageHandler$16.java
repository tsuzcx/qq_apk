package com.tencent.mobileqq.app;

import aegu;
import com.tencent.qphone.base.util.QLog;

class MessageHandler$16
  implements Runnable
{
  MessageHandler$16(MessageHandler paramMessageHandler, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      aegu.B(this.this$0.app, false);
      aegu.A(this.this$0.app, false);
      this.this$0.Fj(this.bIv);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e("Q.msg.MessageHandler", 1, "sendMsgReadedReportInAll error :", localRuntimeException);
      throw localRuntimeException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler.16
 * JD-Core Version:    0.7.0.1
 */