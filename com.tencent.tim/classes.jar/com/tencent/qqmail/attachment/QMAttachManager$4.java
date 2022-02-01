package com.tencent.qqmail.attachment;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IBeforeSendCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;

class QMAttachManager$4
  implements QMCallback.IBeforeSendCallback
{
  QMAttachManager$4(QMAttachManager paramQMAttachManager, int paramInt) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest)
  {
    QMWatcherCenter.triggerLoadAttachFolderListProcess(this.val$accountId, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.QMAttachManager.4
 * JD-Core Version:    0.7.0.1
 */