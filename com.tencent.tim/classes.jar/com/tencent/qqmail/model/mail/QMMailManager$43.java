package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.MailManagerDelegate.MailErrorCallback;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.utilities.log.QMLog;

class QMMailManager$43
  implements MailManagerDelegate.MailErrorCallback
{
  QMMailManager$43(QMMailManager paramQMMailManager, ComposeMailUI paramComposeMailUI, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(Object paramObject)
  {
    QMLog.log(5, "QMMailManager", "send mail error, subject: " + this.val$mail.getInformation().getSubject());
    if (this.val$mail.isDraft()) {
      this.this$0.updateMailHiddenAttr(this.val$mail.getDraftMailId(), false);
    }
    if (this.val$callback != null) {
      this.val$callback.handleError(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.43
 * JD-Core Version:    0.7.0.1
 */