package com.tencent.qqmail.namelist;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class NameListCGIManager$2
  implements QMCallback.IErrorCallback
{
  NameListCGIManager$2(NameListCGIManager paramNameListCGIManager, String paramString, int paramInt) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "NameListCGIManager", "name list callback error." + paramQMNetworkError.toString());
    RequestFilter.resetRequestRunningState(this.val$requestFilterKey);
    QMWatcherCenter.triggerLoadNameListError(this.val$accountId, paramQMNetworkError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.NameListCGIManager.2
 * JD-Core Version:    0.7.0.1
 */