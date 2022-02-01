package com.tencent.qqmail.attachment;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter.AttachFolderOperationType;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMAttachManager$9
  implements QMCallback.IErrorCallback
{
  QMAttachManager$9(QMAttachManager paramQMAttachManager, long[] paramArrayOfLong) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    paramQMNetworkResponse = new StringBuilder().append("attach folder favorite setOnError  errorCode: ");
    if (paramQMNetworkError != null)
    {
      paramQMNetworkRequest = Integer.valueOf(paramQMNetworkError.code);
      paramQMNetworkResponse = paramQMNetworkResponse.append(paramQMNetworkRequest).append(" errorMsg: ");
      if (paramQMNetworkError == null) {
        break label78;
      }
    }
    label78:
    for (paramQMNetworkRequest = paramQMNetworkError.desp;; paramQMNetworkRequest = "")
    {
      QMLog.log(6, "QMAttachManager", paramQMNetworkRequest);
      QMWatcherCenter.triggerAttachFolderOpertionError(QMWatcherCenter.AttachFolderOperationType.FAVORITE, this.val$attachIds, paramQMNetworkError);
      return;
      paramQMNetworkRequest = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.QMAttachManager.9
 * JD-Core Version:    0.7.0.1
 */