package com.tencent.qqmail.bottle.controller;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCGIError;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class BottleThrowController$10
  extends QMCallback
{
  BottleThrowController$10(BottleThrowController paramBottleThrowController, int paramInt, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4) {}
  
  public void handleError(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "BottleThrowController", "sendBottleToCGI: error: " + paramQMNetworkError);
    BottleThrowController_ConversationUnreadDataORM.update(BottleThrowController.access$200(this.this$0).mDBOpenHelper.getWritableDatabase(), new BottleThrowController.ConversationUnreadData(this.val$oldBottleId, this.val$oldMsgId, 2));
    paramQMNetworkRequest = this.this$0;
    int j = this.val$fThrowType;
    int i;
    if (paramQMNetworkError == null) {
      i = -9999;
    }
    for (;;)
    {
      BottleThrowController.access$1100(paramQMNetworkRequest, j, i, this.val$content, this.val$geo, this.val$beginTime);
      if (!(paramQMNetworkError instanceof QMCGIError)) {
        break label246;
      }
      i = ((QMCGIError)paramQMNetworkError).appCode;
      if (i != -111) {
        break;
      }
      BottleThrowController.access$1200(this.this$0, this.val$oldBottleId, new BottleThrowController.BottleThrowError(-20002), true);
      return;
      if ((paramQMNetworkError instanceof QMCGIError)) {
        i = ((QMCGIError)paramQMNetworkError).appCode;
      } else {
        i = paramQMNetworkError.code;
      }
    }
    if (i == -127)
    {
      paramQMNetworkRequest = new String[1];
      paramQMNetworkRequest[0] = this.val$oldBottleId;
      if (!BottleThrowController.access$200(this.this$0).mBottleListController.deleteBottle(paramQMNetworkRequest)) {
        BottleThrowController.access$200(this.this$0).mBottleBeachController.deleteBottle(paramQMNetworkRequest);
      }
      BottleThrowController.access$1200(this.this$0, this.val$oldBottleId, new BottleThrowController.BottleThrowError(-20006), true);
      return;
    }
    label246:
    BottleThrowController.access$1200(this.this$0, this.val$oldBottleId, paramQMNetworkError, true);
  }
  
  public void handleSuccess(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    QMLog.log(4, "BottleThrowController", "sendBottleToCGI: success");
    paramQMNetworkRequest = (JSONObject)paramQMNetworkResponse.getResponseJson();
    paramQMNetworkResponse = paramQMNetworkRequest.getString("mailid");
    String str1 = paramQMNetworkRequest.getString("msgId");
    if ((paramQMNetworkResponse == null) || (paramQMNetworkResponse.length() == 0))
    {
      BottleThrowController.access$1100(this.this$0, this.val$fThrowType, -20001, this.val$content, this.val$geo, this.val$beginTime);
      BottleThrowController.access$1200(this.this$0, this.val$oldBottleId, new BottleThrowController.BottleThrowError(-20001), true);
      return;
    }
    String str2 = BottleThrowController.formatMsgId(str1);
    int i = BottleThrowController.access$1300(this.this$0, this.val$oldBottleId, paramQMNetworkResponse, this.val$oldMsgId, str2, this.val$content, paramQMNetworkRequest);
    if (i == 0)
    {
      BottleThrowController.access$1100(this.this$0, this.val$fThrowType, 0, this.val$content, this.val$geo, this.val$beginTime);
      BottleThrowController.access$1000(this.this$0, paramQMNetworkResponse, str1, false, BottleThrowController.isUnsendBottleId(this.val$oldBottleId));
      return;
    }
    BottleThrowController.access$1100(this.this$0, this.val$fThrowType, i, this.val$content, this.val$geo, this.val$beginTime);
    BottleThrowController.access$1200(this.this$0, this.val$oldBottleId, new BottleThrowController.BottleThrowError(i), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleThrowController.10
 * JD-Core Version:    0.7.0.1
 */