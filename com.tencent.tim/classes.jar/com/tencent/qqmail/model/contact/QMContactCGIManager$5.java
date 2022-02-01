package com.tencent.qqmail.model.contact;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.ArrayList;

class QMContactCGIManager$5
  implements QMCallback.IErrorCallback
{
  QMContactCGIManager$5(QMContactCGIManager paramQMContactCGIManager, int paramInt, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    QMWatcherCenter.triggerAddContactListError(this.val$accountId, this.val$originIds, this.val$mailContacts, paramQMNetworkError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.QMContactCGIManager.5
 * JD-Core Version:    0.7.0.1
 */