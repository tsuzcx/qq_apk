package com.tencent.qqmail.model.media;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ICompleteCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMUploadImageManager$9
  implements QMCallback.ICompleteCallback
{
  QMUploadImageManager$9(QMUploadImageManager paramQMUploadImageManager) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(4, "QMUploadImageManager", "complete");
    this.this$0.startUpload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.media.QMUploadImageManager.9
 * JD-Core Version:    0.7.0.1
 */