package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.contact.QMContactManager;

class QMMailCGIManager$2$1
  implements Runnable
{
  QMMailCGIManager$2$1(QMMailCGIManager.2 param2) {}
  
  public void run()
  {
    QMContactManager.sharedInstance().loadAccountContacts(new int[] { this.this$1.val$accountId });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.2.1
 * JD-Core Version:    0.7.0.1
 */