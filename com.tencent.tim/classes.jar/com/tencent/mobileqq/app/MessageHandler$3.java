package com.tencent.mobileqq.app;

import anaz;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class MessageHandler$3
  implements Runnable
{
  MessageHandler$3(MessageHandler paramMessageHandler, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if (this.this$0.app.a().aR(this.a))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MsgSend", 4, "delay notify: " + MessageHandler.cwL);
      }
      this.this$0.notifyUI(8022, true, new String[] { this.a.frienduin });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler.3
 * JD-Core Version:    0.7.0.1
 */