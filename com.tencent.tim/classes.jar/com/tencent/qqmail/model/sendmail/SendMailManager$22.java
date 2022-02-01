package com.tencent.qqmail.model.sendmail;

import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISendDataCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;

class SendMailManager$22
  implements QMCallback.ISendDataCallback
{
  SendMailManager$22(SendMailManager paramSendMailManager, MailManagerDelegate paramMailManagerDelegate, boolean paramBoolean, SendMailManager.BinaryFilesData paramBinaryFilesData) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, Long paramLong1, Long paramLong2)
  {
    if (this.val$callback != null)
    {
      if (!this.val$isSendMailByFtn) {
        this.val$callback.handleSendData(Long.valueOf(paramLong1.longValue() + this.val$binaryFilesData.getBytesAttachNeedFtnUpload()), Long.valueOf(paramLong2.longValue() + this.val$binaryFilesData.getBytesAttachNeedFtnUpload()));
      }
    }
    else {
      return;
    }
    this.val$callback.handleSendData(paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.22
 * JD-Core Version:    0.7.0.1
 */