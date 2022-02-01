package com.tencent.qqmail.model.sendmail;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class SendMailManager$23
  implements QMCallback.ISuccessCallback
{
  SendMailManager$23(SendMailManager paramSendMailManager, MailManagerDelegate paramMailManagerDelegate, int paramInt, ComposeMailUI paramComposeMailUI) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    if (this.val$callback != null) {
      this.val$callback.handleSuccess(paramQMNetworkResponse, null);
    }
    paramQMNetworkRequest = (JSONObject)paramQMNetworkResponse.getResponseJson();
    SendMailManager.access$1400(this.this$0, this.val$accountId, this.val$mail, paramQMNetworkRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.23
 * JD-Core Version:    0.7.0.1
 */