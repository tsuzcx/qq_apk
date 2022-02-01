package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;

class QMMailManager$32
  implements MailManagerDelegate.DataCallback
{
  QMMailManager$32(QMMailManager paramQMMailManager, long paramLong) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    this.this$0.deleteMails(new long[] { this.val$mailId }, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.32
 * JD-Core Version:    0.7.0.1
 */