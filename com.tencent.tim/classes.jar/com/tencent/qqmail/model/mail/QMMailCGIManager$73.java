package com.tencent.qqmail.model.mail;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMMailCGIManager$73
  implements QMCallback.ISuccessCallback
{
  QMMailCGIManager$73(QMMailCGIManager paramQMMailCGIManager, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    if (paramQMNetworkResponse != null)
    {
      QMLog.log(4, "genAppleIdVerifyCode", "" + paramQMNetworkResponse.getResponseJson());
      paramQMNetworkResponse = (JSONObject)paramQMNetworkResponse.getResponseJson();
      if (paramQMNetworkResponse == null) {}
    }
    for (int i = paramQMNetworkResponse.getInteger("lockstatus").intValue();; i = 1)
    {
      if (this.val$callback != null) {
        this.val$callback.handleSuccess(paramQMNetworkRequest, Integer.valueOf(i));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.73
 * JD-Core Version:    0.7.0.1
 */