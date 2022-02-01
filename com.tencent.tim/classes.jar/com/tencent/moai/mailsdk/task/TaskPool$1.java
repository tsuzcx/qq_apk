package com.tencent.moai.mailsdk.task;

import com.tencent.moai.mailsdk.protocol.imap.IMAPHandler;
import com.tencent.moai.mailsdk.protocol.pop3.POP3Handler;
import com.tencent.moai.mailsdk.protocol.smtp.SMTPHandler;
import com.tencent.moai.mailsdk.util.log.Logger;

class TaskPool$1
  extends ThreadLocal<Handler>
{
  TaskPool$1(TaskPool paramTaskPool) {}
  
  protected Handler initialValue()
  {
    Logger.log(4, "TaskPool", "initValue:" + TaskPool.access$000(this.this$0) + TaskPool.access$100(this.this$0));
    switch (TaskPool.access$000(this.this$0))
    {
    default: 
      return null;
    case 2: 
      return new IMAPHandler(TaskPool.access$200(this.this$0));
    case 3: 
      return new POP3Handler(TaskPool.access$200(this.this$0));
    }
    return new SMTPHandler(TaskPool.access$200(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.task.TaskPool.1
 * JD-Core Version:    0.7.0.1
 */