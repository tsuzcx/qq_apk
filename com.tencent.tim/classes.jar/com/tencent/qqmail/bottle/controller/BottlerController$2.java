package com.tencent.qqmail.bottle.controller;

import com.tencent.qqmail.bottle.model.Bottler;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class BottlerController$2
  extends QMCallback
{
  BottlerController$2(BottlerController paramBottlerController, String paramString) {}
  
  public void handleError(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "BottlerController", "submitMyNickName: error:" + paramQMNetworkError);
    BottlerController.access$202(this.this$0, BottlerController.access$100(this.this$0));
    BottlerController.access$400(this.this$0, paramQMNetworkError);
  }
  
  public void handleSuccess(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    QMLog.log(4, "BottlerController", "submitMyNickName: success");
    paramQMNetworkRequest = new BottlerController.MyInformationData(BottlerController.access$200(this.this$0).getUin(), this.val$fNickname, BottlerController.access$200(this.this$0).getAvatar(), BottlerController.access$200(this.this$0).getBigAvatar(), BottlerController.access$200(this.this$0).isMale());
    BottlerController_MyInformationDataORM.update(BottlerController.access$000(this.this$0).mDBOpenHelper.getWritableDatabase(), paramQMNetworkRequest);
    paramQMNetworkRequest = BottlerController.access$100(this.this$0);
    BottlerController.access$300(this.this$0, paramQMNetworkRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottlerController.2
 * JD-Core Version:    0.7.0.1
 */