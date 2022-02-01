package com.tencent.mobileqq.app;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;

class MessageHandler$12
  implements Runnable
{
  MessageHandler$12(MessageHandler paramMessageHandler, long paramLong1, String paramString1, String paramString2, byte paramByte, String paramString3, long paramLong2, long paramLong3) {}
  
  public void run()
  {
    long l1 = 480000L;
    long l2 = 3L - this.Qn;
    if (this.Qn == 0L) {
      if (this.this$0.app.b().a(this.Lw, 1001).hasReply) {
        break label105;
      }
    }
    label105:
    for (boolean bool = true;; bool = false)
    {
      MessageHandler.a(this.this$0, this.Lw, this.val$msg, this.bc, bool, this.boB, this.Qo, this.rJ, l1);
      return;
      l1 = l2 * 480000L / 3L - l2 * 2000L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler.12
 * JD-Core Version:    0.7.0.1
 */