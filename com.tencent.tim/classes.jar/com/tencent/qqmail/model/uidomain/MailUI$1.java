package com.tencent.qqmail.model.uidomain;

import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.Mail;
import java.util.concurrent.Callable;

class MailUI$1
  implements Callable<Mail>
{
  MailUI$1(MailUI paramMailUI) {}
  
  public Mail call()
  {
    if (MailUI.access$000(this.this$0) != 0L) {
      return QMMailManager.sharedInstance().readMailInfo(MailUI.access$000(this.this$0));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.uidomain.MailUI.1
 * JD-Core Version:    0.7.0.1
 */