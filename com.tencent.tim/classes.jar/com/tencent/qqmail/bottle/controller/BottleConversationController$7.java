package com.tencent.qqmail.bottle.controller;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.utilities.qmnetwork.QMCGIError;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.thread.Threads;

class BottleConversationController$7
  extends QMCallback
{
  BottleConversationController$7(BottleConversationController paramBottleConversationController, String paramString) {}
  
  private void invokeConversationSyncWatcherError()
  {
    Threads.runOnMainThread(new BottleConversationController.7.1(this));
  }
  
  public void handleError(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    BottleManager.dumpCGI("requestConversation: error: " + paramQMNetworkError);
    invokeConversationSyncWatcherError();
    if ((paramQMNetworkError instanceof QMCGIError))
    {
      paramQMNetworkRequest = (QMCGIError)paramQMNetworkError;
      if ((paramQMNetworkRequest.appCode == -3) || (paramQMNetworkRequest.appCode == -127) || (paramQMNetworkRequest.appCode == -3077))
      {
        paramQMNetworkRequest = new String[1];
        paramQMNetworkRequest[0] = this.val$bottleId;
        if (!BottleConversationController.access$100(this.this$0).mBottleListController.deleteBottle(paramQMNetworkRequest)) {
          BottleConversationController.access$100(this.this$0).mBottleBeachController.deleteBottle(paramQMNetworkRequest);
        }
        BottleConversationController.access$000(this.this$0, new BottleConversationController.LoadConversationError(-20001, paramQMNetworkError.desp));
        return;
      }
    }
    BottleConversationController.access$000(this.this$0, paramQMNetworkError);
  }
  
  public void handleSuccess(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    BottleManager.dumpCGI("requestConversation: success: " + paramQMNetworkResponse.getResponseString());
    invokeConversationSyncWatcherError();
    int i = BottleConversationController.access$700(this.this$0, this.val$bottleId, (JSONObject)paramQMNetworkResponse.getResponseJson());
    if (i == 0)
    {
      paramQMNetworkRequest = this.this$0.readConversationFromDB(this.val$bottleId, false);
      BottleConversationController.access$200(this.this$0, paramQMNetworkRequest);
      return;
    }
    BottleConversationController.access$000(this.this$0, new BottleConversationController.LoadConversationError(i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleConversationController.7
 * JD-Core Version:    0.7.0.1
 */