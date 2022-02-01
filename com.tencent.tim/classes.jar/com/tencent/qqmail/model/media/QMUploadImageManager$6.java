package com.tencent.qqmail.model.media;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMUploadImageManager$6
  implements QMCallback.ISuccessCallback
{
  QMUploadImageManager$6(QMUploadImageManager paramQMUploadImageManager) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    paramQMNetworkRequest = paramQMNetworkResponse.getResponseString();
    QMLog.log(4, "upload file", "success" + paramQMNetworkRequest);
    if (paramQMNetworkRequest != null)
    {
      if ((QMUploadImageManager.access$700(this.this$0, paramQMNetworkRequest, "success")) || (QMUploadImageManager.access$700(this.this$0, paramQMNetworkRequest, "thumbnailSuccess")) || (QMUploadImageManager.access$700(this.this$0, paramQMNetworkRequest, "originalSuccess"))) {
        this.this$0.handleSucc();
      }
    }
    else {
      return;
    }
    this.this$0.handleError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.media.QMUploadImageManager.6
 * JD-Core Version:    0.7.0.1
 */