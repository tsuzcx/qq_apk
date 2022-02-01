package com.tencent.qqmail.attachment;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMAttachManager$12
  implements QMCallback.IErrorCallback
{
  QMAttachManager$12(QMAttachManager paramQMAttachManager) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    paramQMNetworkError = new StringBuilder().append("updateMailBigAttachExpireTime error, response:");
    if (paramQMNetworkResponse == null) {}
    for (paramQMNetworkRequest = "null";; paramQMNetworkRequest = paramQMNetworkResponse.toString())
    {
      QMLog.log(6, "QMAttachManager", paramQMNetworkRequest);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.QMAttachManager.12
 * JD-Core Version:    0.7.0.1
 */