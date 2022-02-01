package com.tencent.qqmail.namelist;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class NameListCGIManager$6
  implements QMCallback.IErrorCallback
{
  NameListCGIManager$6(NameListCGIManager paramNameListCGIManager, int paramInt1, int paramInt2, String[] paramArrayOfString) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "NameListCGIManager", "deleteNameList type:" + this.val$type + " callback error." + paramQMNetworkError.toString());
    QMWatcherCenter.triggerDeleteNameListError(this.val$accountId, this.val$type, this.val$emails, paramQMNetworkError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.NameListCGIManager.6
 * JD-Core Version:    0.7.0.1
 */