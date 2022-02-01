package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter.MailOperationType;

class QMMailManager$28
  implements MailManagerDelegate.DataCallback
{
  QMMailManager$28(QMMailManager paramQMMailManager, int paramInt, long[] paramArrayOfLong, boolean paramBoolean) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    QMMailManager.access$800(this.this$0, this.val$accountId, true, this.val$clockSendMailIds, this.val$isPurgeDelete);
    QMWatcherCenter.triggerMailOpertionSuccess(QMWatcherCenter.MailOperationType.DELETE, this.val$clockSendMailIds);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.28
 * JD-Core Version:    0.7.0.1
 */