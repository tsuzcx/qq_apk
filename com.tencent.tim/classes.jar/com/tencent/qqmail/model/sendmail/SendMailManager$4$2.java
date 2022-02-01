package com.tencent.qqmail.model.sendmail;

import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.MailManagerDelegate.EventCallback;
import java.util.concurrent.atomic.AtomicInteger;

class SendMailManager$4$2
  implements MailManagerDelegate.EventCallback
{
  SendMailManager$4$2(SendMailManager.4 param4) {}
  
  public void run(Object paramObject)
  {
    this.this$1.val$step.set(8);
    if (this.this$1.val$newCallback != null) {
      this.this$1.val$newCallback.handleComplete(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.4.2
 * JD-Core Version:    0.7.0.1
 */