package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.utilities.log.QMLog;

class QMMailManager$35
  implements MailManagerDelegate.DataCallback
{
  QMMailManager$35(QMMailManager paramQMMailManager, ComposeMailUI paramComposeMailUI, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    if ((this.val$mail.isDraft()) && (this.val$mail.getOriginAccountId() != this.val$mail.getInformation().getAccountId()))
    {
      QMLog.log(4, "QMMailManager", "mail draft change sender " + this.val$mail.getDraftId());
      this.val$callback.handleSuccess(Long.valueOf(Mail.generateId(this.val$mail.getInformation().getAccountId(), this.val$mail.getComposeId())), null);
      return;
    }
    if (this.val$mail.isDraft())
    {
      QMLog.log(4, "QMMailManager", "mail draft save " + this.val$mail.getDraftId());
      QMMailManager.access$1000(this.this$0, this.val$mail, this.val$callback);
      return;
    }
    long l = Mail.generateId(this.val$mail.getInformation().getAccountId(), this.val$mail.getComposeId());
    QMLog.log(4, "QMMailManager", "mail draft new " + l);
    this.val$callback.handleSuccess(Long.valueOf(l), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.35
 * JD-Core Version:    0.7.0.1
 */