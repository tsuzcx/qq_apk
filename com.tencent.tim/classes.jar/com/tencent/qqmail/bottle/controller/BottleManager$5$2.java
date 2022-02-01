package com.tencent.qqmail.bottle.controller;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.thread.Threads;

class BottleManager$5$2
  extends QMCallback
{
  BottleManager$5$2(BottleManager.5 param5, boolean paramBoolean) {}
  
  public void handleError(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "BottleManager", "remove msg: error: " + paramQMNetworkError);
    Threads.runOnMainThread(new BottleManager.5.2.1(this, paramQMNetworkError));
  }
  
  public void handleSuccess(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    QMLog.log(4, "BottleManager", "success to remove bottleid:" + this.this$1.val$bottleId + ", msgid:" + this.this$1.val$msgId);
    this.this$1.this$0.mBottleConversationController.autoLoadMore(this.this$1.val$bottleId);
    if (this.val$fNeedRefreshBottleList) {
      this.this$1.this$0.mBottleListController.refreshList();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleManager.5.2
 * JD-Core Version:    0.7.0.1
 */