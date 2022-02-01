package com.tencent.qqmail.model.uidomain;

import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

class MailUI$3
  implements Callable<Boolean>
{
  MailUI$3(MailUI paramMailUI) {}
  
  public Boolean call()
  {
    if (MailUI.access$000(this.this$0) != 0L) {
      try
      {
        Mail localMail = (Mail)MailUI.access$100(this.this$0).get();
        if (localMail != null) {
          return Boolean.valueOf(localMail.getStatus().isTopped());
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
          Object localObject1 = null;
        }
      }
      catch (ExecutionException localExecutionException)
      {
        for (;;)
        {
          localExecutionException.printStackTrace();
          Object localObject2 = null;
        }
      }
    }
    return Boolean.valueOf(this.this$0.getStatus().isTopped());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.uidomain.MailUI.3
 * JD-Core Version:    0.7.0.1
 */