package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.MailManagerDelegate.MailErrorCallback;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter.MailOperationType;
import java.util.ArrayList;

class QMMailManager$27
  implements MailManagerDelegate.MailErrorCallback
{
  QMMailManager$27(QMMailManager paramQMMailManager, ArrayList paramArrayList, long[] paramArrayOfLong1, boolean paramBoolean, long[] paramArrayOfLong2) {}
  
  public void run(Object paramObject)
  {
    if (!this.val$normalMailIdList.isEmpty()) {
      QMMailManager.access$900(this.this$0, this.val$normalMailIds, this.val$isPurgeDelete);
    }
    QMWatcherCenter.triggerMailOpertionSuccess(QMWatcherCenter.MailOperationType.DELETE, this.val$originMailIds);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.27
 * JD-Core Version:    0.7.0.1
 */