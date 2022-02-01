package com.tencent.qqmail.bottle.controller;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class BottleBeachController$10
  implements QMCallback.ISuccessCallback
{
  BottleBeachController$10(BottleBeachController paramBottleBeachController) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    int i;
    if ((paramQMNetworkResponse != null) && (paramQMNetworkResponse.getResponseString() != null))
    {
      QMLog.log(6, "BottleBeachController", "checkBottlePanel success response:" + paramQMNetworkResponse.toString());
      paramQMNetworkResponse = (JSONObject)JSONReader.parse(paramQMNetworkResponse.getResponseString());
      if (paramQMNetworkResponse == null) {
        break label116;
      }
      i = Integer.parseInt((String)paramQMNetworkResponse.get("block"));
      if (i != 0)
      {
        paramQMNetworkRequest = (String)paramQMNetworkResponse.get("blocktips1");
        paramQMNetworkResponse = (String)paramQMNetworkResponse.get("blocktips2");
        BottleBeachController.access$1200(this.this$0, i, paramQMNetworkRequest, paramQMNetworkResponse);
      }
    }
    else
    {
      return;
    }
    BottleBeachController.access$1200(this.this$0, i, "", "");
    return;
    label116:
    QMLog.log(6, "BottleBeachController", "checkBottlePanel success error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleBeachController.10
 * JD-Core Version:    0.7.0.1
 */