package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;

class QMMailManager$14
  implements Runnable
{
  QMMailManager$14(QMMailManager paramQMMailManager, boolean paramBoolean, Mail paramMail, QMCallback paramQMCallback) {}
  
  public void run()
  {
    QMMailManager.access$500(this.this$0).getMailReminderSetting(this.val$creditOrJourney, this.val$mail, this.val$qmCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.14
 * JD-Core Version:    0.7.0.1
 */