package com.tencent.qqmail.bottle.controller;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class BottleListController$7
  extends QMCallback
{
  BottleListController$7(BottleListController paramBottleListController, String paramString, BottleListController.RequestListCallback paramRequestListCallback) {}
  
  public void handleError(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(4, "BottleListController", "requestList: error: " + paramQMNetworkError.toString());
    RequestFilter.resetRequestRunningState(this.val$QUERY);
    this.val$callback.onError(paramQMNetworkError);
  }
  
  public void handleSuccess(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    QMLog.log(4, "BottleListController", "requestList: success: " + paramQMNetworkResponse.getResponseString());
    RequestFilter.resetRequestRunningState(this.val$QUERY);
    BottleListController.access$100(this.this$0).mSettings.setListOverdue(false);
    BottleListController.access$900(this.this$0, (JSONObject)paramQMNetworkResponse.getResponseJson());
    this.val$callback.onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleListController.7
 * JD-Core Version:    0.7.0.1
 */