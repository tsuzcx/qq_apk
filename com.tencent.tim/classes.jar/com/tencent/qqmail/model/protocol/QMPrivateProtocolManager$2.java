package com.tencent.qqmail.model.protocol;

import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.ArrayList;

class QMPrivateProtocolManager$2
  implements QMCallback.ISuccessCallback
{
  QMPrivateProtocolManager$2(QMPrivateProtocolManager paramQMPrivateProtocolManager, ArrayList paramArrayList) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    this.this$0.triggerSyncPhotoSuccess(this.val$finalEmailList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.protocol.QMPrivateProtocolManager.2
 * JD-Core Version:    0.7.0.1
 */