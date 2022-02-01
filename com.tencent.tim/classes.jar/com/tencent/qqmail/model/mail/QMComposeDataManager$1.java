package com.tencent.qqmail.model.mail;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.qmdomain.ComposeData;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.Date;

class QMComposeDataManager$1
  implements QMCallback.ISuccessCallback
{
  QMComposeDataManager$1(QMComposeDataManager paramQMComposeDataManager, int paramInt, ICallBack paramICallBack1, ICallBack paramICallBack2) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    paramQMNetworkRequest = (JSONObject)paramQMNetworkResponse.getResponseJson();
    if ((paramQMNetworkRequest != null) && (paramQMNetworkRequest.containsKey("items")))
    {
      paramQMNetworkRequest = paramQMNetworkRequest.getJSONObject("items");
      QMLog.log(4, "loadcomposedataSUCC", paramQMNetworkRequest.toString());
      paramQMNetworkResponse = new ComposeData();
      paramQMNetworkResponse.parseWithDictionary(paramQMNetworkRequest);
      paramQMNetworkResponse.setDatetime(new Date());
      paramQMNetworkResponse.setAccountId(this.val$accountId);
      this.this$0.saveComposeData(this.val$accountId, paramQMNetworkResponse);
      this.val$sucCallBack.callback(paramQMNetworkResponse);
      return;
    }
    QMLog.log(6, "loadcomposedatafailed", "responseinfo:" + paramQMNetworkResponse.toString());
    this.val$failCallBack.callback(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMComposeDataManager.1
 * JD-Core Version:    0.7.0.1
 */