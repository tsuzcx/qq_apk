package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.qmdomain.Mail;

class QMMailManager$13
  implements Runnable
{
  QMMailManager$13(QMMailManager paramQMMailManager, Mail paramMail, String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    QMMailManager.access$500(this.this$0).setMailReminder(this.val$mail, this.val$type, this.val$ahead, this.val$open);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.13
 * JD-Core Version:    0.7.0.1
 */