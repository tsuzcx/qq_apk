package com.tencent.qqmail.attachment;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ICompleteCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMAttachManager$10
  implements QMCallback.ICompleteCallback
{
  QMAttachManager$10(QMAttachManager paramQMAttachManager) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(4, "QMAttachManager", "attach folder favorite setOnComplete");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.QMAttachManager.10
 * JD-Core Version:    0.7.0.1
 */