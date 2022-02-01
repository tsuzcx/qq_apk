package com.tencent.qqmail.bottle.controller;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.bottle.model.Bottler;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class BottlerController$4
  extends QMCallback
{
  BottlerController$4(BottlerController paramBottlerController) {}
  
  public void handleError(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    BottleManager.dumpCGI("submitMyAvatar: error: " + paramQMNetworkError);
    BottlerController.access$202(this.this$0, BottlerController.access$100(this.this$0));
    BottlerController.access$400(this.this$0, paramQMNetworkError);
  }
  
  public void handleSuccess(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    BottleManager.dumpCGI("submitMyAvatar: success: " + paramQMNetworkResponse.getResponseString());
    paramQMNetworkResponse = (JSONObject)paramQMNetworkResponse.getResponseJson();
    if (paramQMNetworkResponse != null)
    {
      paramQMNetworkRequest = paramQMNetworkResponse.getString("avatar");
      paramQMNetworkResponse = paramQMNetworkResponse.getString("bigAvatar");
      paramQMNetworkRequest = BottleManager.formatAvatarUrl(paramQMNetworkRequest);
      paramQMNetworkResponse = BottleManager.formatAvatarUrl(paramQMNetworkResponse);
      paramQMNetworkRequest = new BottlerController.MyInformationData(BottlerController.access$200(this.this$0).getUin(), BottlerController.access$200(this.this$0).getName(), paramQMNetworkRequest, paramQMNetworkResponse, BottlerController.access$200(this.this$0).isMale());
      BottlerController_MyInformationDataORM.update(BottlerController.access$000(this.this$0).mDBOpenHelper.getWritableDatabase(), paramQMNetworkRequest);
    }
    paramQMNetworkRequest = BottlerController.access$100(this.this$0);
    BottlerController.access$300(this.this$0, paramQMNetworkRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottlerController.4
 * JD-Core Version:    0.7.0.1
 */