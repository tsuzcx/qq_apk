package com.tencent.qqmail.namelist;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.namelist.model.NameListContact;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class NameListCGIManager$3
  implements QMCallback.ISuccessCallback
{
  NameListCGIManager$3(NameListCGIManager paramNameListCGIManager, int paramInt1, String[] paramArrayOfString, int paramInt2) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    QMLog.log(3, "NameListCGIManager", "addNameList type:" + this.val$type + " callback success");
    paramQMNetworkRequest = this.val$emails;
    int j = paramQMNetworkRequest.length;
    int i = 0;
    if (i < j)
    {
      paramQMNetworkResponse = paramQMNetworkRequest[i];
      if (NameListManager.sharedInstance().getNameListContactById(NameListContact.generateId(this.val$accountId, paramQMNetworkResponse)) != null) {
        NameListManager.sharedInstance().sqlUpdateNameListContactTypeByContactId(this.val$type, NameListContact.generateId(this.val$accountId, paramQMNetworkResponse));
      }
      for (;;)
      {
        i += 1;
        break;
        NameListCGIManager.access$200(this.this$0, paramQMNetworkResponse, this.val$type, this.val$accountId);
      }
    }
    QMWatcherCenter.triggerAddNameListSuccess(this.val$accountId, this.val$type, this.val$emails);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.NameListCGIManager.3
 * JD-Core Version:    0.7.0.1
 */