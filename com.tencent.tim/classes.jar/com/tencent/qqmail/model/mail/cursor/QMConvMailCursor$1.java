package com.tencent.qqmail.model.mail.cursor;

import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.Mail;
import java.util.concurrent.Callable;

class QMConvMailCursor$1
  implements Callable<Mail>
{
  QMConvMailCursor$1(QMConvMailCursor paramQMConvMailCursor) {}
  
  public Mail call()
  {
    if (QMMailManager.sharedInstance().isRemoteSearchMail(QMConvMailCursor.access$000(this.this$0))) {
      return QMMailManager.sharedInstance().readSearchMail(QMConvMailCursor.access$000(this.this$0));
    }
    return QMMailManager.sharedInstance().readMail(QMConvMailCursor.access$000(this.this$0), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMConvMailCursor.1
 * JD-Core Version:    0.7.0.1
 */