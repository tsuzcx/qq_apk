package com.tencent.qqmail.bottle.controller;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class BottleThrowController$4
  extends QMCallback
{
  BottleThrowController$4(BottleThrowController paramBottleThrowController, BottleManager.Coordinate paramCoordinate) {}
  
  public void handleError(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    BottleManager.dumpCGI("requestBottleLocation: error: " + paramQMNetworkError);
    BottleThrowController.access$400(this.this$0, paramQMNetworkError);
  }
  
  public void handleSuccess(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    BottleManager.dumpCGI("requestBottleLocation: success: " + paramQMNetworkResponse.getResponseString());
    paramQMNetworkRequest = (JSONObject)paramQMNetworkResponse.getResponseJson();
    if (paramQMNetworkRequest == null) {}
    for (paramQMNetworkRequest = null; (paramQMNetworkRequest != null) && (paramQMNetworkRequest.length() > 0); paramQMNetworkRequest = paramQMNetworkRequest.getString("city"))
    {
      BottleThrowController.access$200(this.this$0).mSettings.setLocality(this.val$latlng.lat, this.val$latlng.lng, paramQMNetworkRequest);
      BottleThrowController.access$300(this.this$0, this.val$latlng.toString(), paramQMNetworkRequest);
      return;
    }
    BottleThrowController.access$400(this.this$0, new QMNetworkError(0, -10000, "cgi error:" + paramQMNetworkRequest));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleThrowController.4
 * JD-Core Version:    0.7.0.1
 */