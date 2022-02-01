package com.tencent.qqmail.bottle.controller;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.thread.Threads;

class BottleManager$8$2
  extends QMCallback
{
  BottleManager$8$2(BottleManager.8 param8) {}
  
  public void handleError(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "BottleManager", "spam: error: " + paramQMNetworkError);
    Threads.runOnMainThread(new BottleManager.8.2.1(this, paramQMNetworkError));
  }
  
  public void handleSuccess(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    QMLog.log(4, "BottleManager", "success to spam bottleid:" + this.this$1.val$bottleId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleManager.8.2
 * JD-Core Version:    0.7.0.1
 */