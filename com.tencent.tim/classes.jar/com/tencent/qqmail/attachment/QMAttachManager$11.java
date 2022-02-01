package com.tencent.qqmail.attachment;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.Date;

class QMAttachManager$11
  implements QMCallback.ISuccessCallback
{
  QMAttachManager$11(QMAttachManager paramQMAttachManager, MailBigAttach paramMailBigAttach, int paramInt1, int paramInt2) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    QMLog.log(4, "QMAttachManager", "updateMailBigAttachExpireTime success");
    if ((paramQMNetworkResponse != null) && (paramQMNetworkResponse.getResponseString() != null))
    {
      QMLog.log(4, "QMAttachManager", "updateMailBigAttachExpireTime onSuccess: log:" + paramQMNetworkResponse.getResponseString());
      paramQMNetworkResponse = (JSONObject)JSONReader.parse(paramQMNetworkResponse.getResponseString());
      if (paramQMNetworkResponse != null)
      {
        paramQMNetworkRequest = (String)paramQMNetworkResponse.get("ret");
        paramQMNetworkResponse = (String)paramQMNetworkResponse.get("expiretime");
        QMLog.log(4, "QMAttachManager", "parse ret:" + paramQMNetworkRequest + ", expireTime:" + paramQMNetworkResponse);
        if (!paramQMNetworkResponse.equals("-2")) {
          break label161;
        }
        this.val$mailBigAttach.setExpireTimeMilli(-2L);
        this.val$mailBigAttach.setExpire(null);
        this.this$0.updateBigAttachExpire(this.val$mailBigAttach.getHashId(), -2L);
      }
    }
    label161:
    while (!paramQMNetworkRequest.equals("0")) {
      return;
    }
    long l = Long.parseLong(paramQMNetworkResponse) * 1000L;
    this.val$mailBigAttach.setExpireTimeMilli(l);
    this.val$mailBigAttach.setExpire(new Date(l));
    this.this$0.updateBigAttachExpire(this.val$mailBigAttach.getHashId(), l);
    QMWatcherCenter.triggerUpdateFtnExpireTimeSuccess(this.val$accountId, this.val$mailBigAttach, this.val$mailBigAttachPosition);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.QMAttachManager.11
 * JD-Core Version:    0.7.0.1
 */