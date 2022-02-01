package com.tencent.qqmail.card;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMCardManager$11
  implements QMCallback.IErrorCallback
{
  QMCardManager$11(QMCardManager paramQMCardManager, int paramInt) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(4, "QMCardManager", "loadQQHotFriend error callback error");
    paramQMNetworkRequest = Lists.newArrayList();
    QMWatcherCenter.triggerLoadQQHotFriendSuccess(this.val$accountId, paramQMNetworkRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.QMCardManager.11
 * JD-Core Version:    0.7.0.1
 */