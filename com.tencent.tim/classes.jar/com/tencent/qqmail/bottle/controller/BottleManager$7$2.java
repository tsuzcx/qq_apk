package com.tencent.qqmail.bottle.controller;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.thread.Threads;

class BottleManager$7$2
  extends QMCallback
{
  BottleManager$7$2(BottleManager.7 param7) {}
  
  public void handleError(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("fail to remove bottle, response:");
    if (paramQMNetworkResponse != null)
    {
      paramQMNetworkRequest = paramQMNetworkResponse.toString();
      paramQMNetworkResponse = localStringBuilder.append(paramQMNetworkRequest).append(", error:");
      if (paramQMNetworkError == null) {
        break label77;
      }
    }
    label77:
    for (paramQMNetworkRequest = paramQMNetworkError.toString();; paramQMNetworkRequest = "error is null")
    {
      QMLog.log(4, "BottleManager", paramQMNetworkRequest);
      Threads.runOnMainThread(new BottleManager.7.2.1(this, paramQMNetworkError));
      return;
      paramQMNetworkRequest = "response is null";
      break;
    }
  }
  
  public void handleSuccess(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    QMLog.log(4, "BottleManager", "success to remove bottle");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleManager.7.2
 * JD-Core Version:    0.7.0.1
 */