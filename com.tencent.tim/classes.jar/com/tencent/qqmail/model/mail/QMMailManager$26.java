package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter.MailOperationType;
import java.util.ArrayList;

class QMMailManager$26
  implements MailManagerDelegate.DataCallback
{
  QMMailManager$26(QMMailManager paramQMMailManager, int paramInt, long[] paramArrayOfLong1, boolean paramBoolean, ArrayList paramArrayList, long[] paramArrayOfLong2, long[] paramArrayOfLong3) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    QMMailManager.access$800(this.this$0, this.val$accountId, true, this.val$clockSendMailIds, this.val$isPurgeDelete);
    if (!this.val$normalMailIdList.isEmpty()) {
      QMMailManager.access$900(this.this$0, this.val$normalMailIds, this.val$isPurgeDelete);
    }
    QMWatcherCenter.triggerMailOpertionSuccess(QMWatcherCenter.MailOperationType.DELETE, this.val$originMailIds);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.26
 * JD-Core Version:    0.7.0.1
 */