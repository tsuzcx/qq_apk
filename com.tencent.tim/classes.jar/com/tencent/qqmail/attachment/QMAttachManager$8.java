package com.tencent.qqmail.attachment;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter.AttachFolderOperationType;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMAttachManager$8
  implements QMCallback.ISuccessCallback
{
  QMAttachManager$8(QMAttachManager paramQMAttachManager, long[] paramArrayOfLong) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    QMLog.log(4, "QMAttachManager", "attach folder favorite setOnSuccess");
    QMWatcherCenter.triggerAttachFolderOpertionSuccess(QMWatcherCenter.AttachFolderOperationType.FAVORITE, this.val$attachIds);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.QMAttachManager.8
 * JD-Core Version:    0.7.0.1
 */