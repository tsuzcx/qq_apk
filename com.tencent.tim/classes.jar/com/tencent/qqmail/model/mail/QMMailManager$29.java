package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.MailManagerDelegate.MailErrorCallback;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter.MailOperationType;

class QMMailManager$29
  implements MailManagerDelegate.MailErrorCallback
{
  QMMailManager$29(QMMailManager paramQMMailManager, long[] paramArrayOfLong) {}
  
  public void run(Object paramObject)
  {
    QMWatcherCenter.triggerMailOpertionSuccess(QMWatcherCenter.MailOperationType.DELETE, this.val$clockSendMailIds);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.29
 * JD-Core Version:    0.7.0.1
 */