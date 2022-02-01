package com.tencent.qqmail.model.contact;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.HashMap;

class QMContactCGIManager$15
  implements QMCallback.IErrorCallback
{
  QMContactCGIManager$15(QMContactCGIManager paramQMContactCGIManager, HashMap paramHashMap) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    QMWatcherCenter.triggerVipContactError(this.val$cidMap, paramQMNetworkError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.QMContactCGIManager.15
 * JD-Core Version:    0.7.0.1
 */