package com.tencent.qqmail.model.mail;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.qmdomain.ComposeData;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.Date;

class QMComposeDataManager$4
  implements QMCallback.ISuccessCallback
{
  QMComposeDataManager$4(QMComposeDataManager paramQMComposeDataManager, ComposeData paramComposeData, int paramInt) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    paramQMNetworkRequest = (JSONObject)paramQMNetworkResponse.getResponseJson();
    if ((paramQMNetworkRequest != null) && (paramQMNetworkRequest.containsKey("items")))
    {
      paramQMNetworkRequest = paramQMNetworkRequest.getJSONObject("items");
      this.val$cache.parseWithDictionary(paramQMNetworkRequest);
      this.val$cache.setDatetime(new Date());
      this.val$cache.setAccountId(this.val$accountId);
      this.this$0.saveComposeData(this.val$accountId, this.val$cache);
      QMNotification.postNotification("loadcomposedatasucc", this.val$cache);
      return;
    }
    QMLog.log(6, "loadcomposedatafailed", "responseinfo:" + paramQMNetworkResponse.toString());
    QMNotification.postNotification("loadcomposedatasucc", this.val$cache);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMComposeDataManager.4
 * JD-Core Version:    0.7.0.1
 */