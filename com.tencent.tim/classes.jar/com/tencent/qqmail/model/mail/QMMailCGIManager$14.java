package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.callback.FolderOperationCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMMailCGIManager$14
  implements QMCallback.IErrorCallback
{
  QMMailCGIManager$14(QMMailCGIManager paramQMMailCGIManager, FolderOperationCallback paramFolderOperationCallback) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    if (this.val$callback != null) {
      this.val$callback.onError(null, paramQMNetworkError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.14
 * JD-Core Version:    0.7.0.1
 */