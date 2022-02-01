package com.tencent.qqmail.model.mail;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMMailCGIManager$42
  implements QMCallback.ISuccessCallback
{
  QMMailCGIManager$42(QMMailCGIManager paramQMMailCGIManager, int paramInt) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    paramQMNetworkRequest = ((JSONObject)paramQMNetworkResponse.getResponseJson()).getJSONObject("inf");
    if (paramQMNetworkRequest != null)
    {
      paramQMNetworkRequest = paramQMNetworkRequest.getJSONArray("filteridLst");
      if ((paramQMNetworkRequest != null) && (paramQMNetworkRequest.size() > 0))
      {
        int i = 0;
        while (i < paramQMNetworkRequest.size())
        {
          this.this$0.moveHistoryMail(this.val$accountId, Integer.parseInt(paramQMNetworkRequest.get(i) + ""));
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.42
 * JD-Core Version:    0.7.0.1
 */