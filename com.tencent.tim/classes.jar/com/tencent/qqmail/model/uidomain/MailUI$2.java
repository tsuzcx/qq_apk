package com.tencent.qqmail.model.uidomain;

import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

class MailUI$2
  implements Callable<Boolean>
{
  MailUI$2(MailUI paramMailUI) {}
  
  public Boolean call()
  {
    if (this.this$0.getStatus().isAdMail()) {
      return Boolean.valueOf(false);
    }
    if (this.this$0.getStatus().isSubscribeMail()) {
      return Boolean.valueOf(false);
    }
    if (QMFolderManager.sharedInstance().getSentFolderId(this.this$0.getInformation().getAccountId()) == this.this$0.getInformation().getFolderId()) {
      return Boolean.valueOf(false);
    }
    if (MailUI.access$000(this.this$0) != 0L) {
      try
      {
        Mail localMail = (Mail)MailUI.access$100(this.this$0).get();
        if ((localMail != null) && (localMail.getStatus().isAdMail())) {
          return Boolean.valueOf(false);
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
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.uidomain.MailUI.2
 * JD-Core Version:    0.7.0.1
 */