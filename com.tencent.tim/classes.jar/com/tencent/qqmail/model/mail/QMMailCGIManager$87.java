package com.tencent.qqmail.model.mail;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.stringextention.StringExtention;

class QMMailCGIManager$87
  implements QMCallback.ISuccessCallback
{
  QMMailCGIManager$87(QMMailCGIManager paramQMMailCGIManager, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    QMLog.log(4, "getShareCalendarFolderWXUrl", paramQMNetworkResponse.toString());
    paramQMNetworkResponse = (JSONObject)paramQMNetworkResponse.getResponseJson();
    if (paramQMNetworkResponse != null)
    {
      paramQMNetworkResponse = paramQMNetworkResponse.getString("url");
      if ((!StringExtention.isNullOrEmpty(paramQMNetworkResponse)) && (this.val$callback != null)) {
        this.val$callback.handleSuccess(paramQMNetworkRequest, paramQMNetworkResponse);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.87
 * JD-Core Version:    0.7.0.1
 */