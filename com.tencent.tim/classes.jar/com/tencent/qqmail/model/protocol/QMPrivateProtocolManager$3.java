package com.tencent.qqmail.model.protocol;

import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.ArrayList;

class QMPrivateProtocolManager$3
  implements QMCallback.IErrorCallback
{
  QMPrivateProtocolManager$3(QMPrivateProtocolManager paramQMPrivateProtocolManager, ArrayList paramArrayList) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    this.this$0.triggerSyncPhotoError(this.val$finalEmailList, paramQMNetworkError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.protocol.QMPrivateProtocolManager.3
 * JD-Core Version:    0.7.0.1
 */