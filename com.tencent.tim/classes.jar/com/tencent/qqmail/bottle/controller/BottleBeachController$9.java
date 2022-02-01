package com.tencent.qqmail.bottle.controller;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.bottle.model.BottleBeach;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class BottleBeachController$9
  extends QMCallback
{
  BottleBeachController$9(BottleBeachController paramBottleBeachController, boolean paramBoolean, int paramInt) {}
  
  public void handleError(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "BottleBeachController", "requestBeachBottle: error: " + paramQMNetworkError.toString());
    BottleBeachController.access$1000(this.this$0, paramQMNetworkError);
  }
  
  public void handleSuccess(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    QMLog.log(4, "BottleBeachController", "requestBeachBottle: success: " + paramQMNetworkResponse.getResponseString());
    paramQMNetworkRequest = BottleBeachController.access$900(this.this$0, (JSONObject)paramQMNetworkResponse.getResponseJson());
    int i;
    if ((paramQMNetworkRequest instanceof BottleBeach[]))
    {
      paramQMNetworkRequest = (BottleBeach[])paramQMNetworkRequest;
      i = 0;
    }
    while (i < 0)
    {
      BottleBeachController.access$1000(this.this$0, new BottleBeachController.BottlePickupError(i, this.val$count));
      return;
      if (this.val$firstLoader)
      {
        i = -20004;
        paramQMNetworkRequest = null;
      }
      else
      {
        i = ((Integer)paramQMNetworkRequest).intValue();
        paramQMNetworkRequest = null;
      }
    }
    paramQMNetworkResponse = BottleBeachController.access$600(this.this$0);
    if (this.val$firstLoader)
    {
      BottleBeachController.access$700(this.this$0, paramQMNetworkResponse);
      return;
    }
    BottleBeachController.access$1100(this.this$0, this.val$count, paramQMNetworkRequest, paramQMNetworkResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleBeachController.9
 * JD-Core Version:    0.7.0.1
 */