package com.tencent.qqmail.bottle.controller;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class BottlerController$5
  extends QMCallback
{
  BottlerController$5(BottlerController paramBottlerController) {}
  
  public void handleError(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(4, "BottlerController", "requestMyInformationFromCGI error");
    BottleManager.dumpCGI("requestList: error: " + paramQMNetworkError);
    BottlerController.access$400(this.this$0, paramQMNetworkError);
    RequestFilter.resetRequestRunningState("mode=getname&t=bottle_setting_getname_app");
    if (!BottlerController.access$600(this.this$0))
    {
      BottlerController.access$602(this.this$0, true);
      QMLog.log(6, "BottlerController", "retry_requestMyInformation");
      BottlerController.access$700(this.this$0);
    }
  }
  
  public void handleSuccess(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    QMLog.log(4, "BottlerController", "requestMyInformationFromCGI success");
    BottleManager.dumpCGI("requestMyInfomation: success: " + paramQMNetworkResponse.getResponseString());
    BottlerController.access$500(this.this$0, (JSONObject)paramQMNetworkResponse.getResponseJson());
    paramQMNetworkRequest = BottlerController.access$100(this.this$0);
    BottlerController.access$300(this.this$0, paramQMNetworkRequest);
    RequestFilter.resetRequestRunningState("mode=getname&t=bottle_setting_getname_app");
    BottlerController.access$000(this.this$0).mSettings.setLoadMyInformationTime(System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottlerController.5
 * JD-Core Version:    0.7.0.1
 */