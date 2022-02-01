package com.tencent.qqmail.model.task;

import com.tencent.qqmail.model.MailManagerDelegate.MailErrorCallback;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.protocol.ProtocolResult;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class QMSendMailDownloadAttachTask$3
  implements MailManagerDelegate.MailErrorCallback
{
  QMSendMailDownloadAttachTask$3(QMSendMailDownloadAttachTask paramQMSendMailDownloadAttachTask) {}
  
  public void run(Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof QMNetworkError)) {
        break label76;
      }
      paramObject = (QMNetworkError)paramObject;
      DataCollector.logDetailEvent("DetailEvent_App_Download", QMSendMailDownloadAttachTask.access$000(this.this$0).getInformation().getAccountId(), 1L, "network err");
    }
    for (;;)
    {
      QMLog.log(6, "QMSendMailDownloadAttachTask", "download onError : " + paramObject.toString());
      this.this$0.handleError(paramObject);
      return;
      label76:
      if ((paramObject instanceof ProtocolResult))
      {
        ProtocolResult localProtocolResult = (ProtocolResult)paramObject;
        paramObject = new QMNetworkError(5, -10000, ProtocolResult.getErrorDesp(localProtocolResult.error_code_));
        DataCollector.logDetailEvent("DetailEvent_App_Download", QMSendMailDownloadAttachTask.access$000(this.this$0).getInformation().getAccountId(), 1L, "errcode:" + localProtocolResult.error_code_);
      }
      else
      {
        paramObject = new QMNetworkError(3, -10000);
        DataCollector.logDetailEvent("DetailEvent_App_Download", QMSendMailDownloadAttachTask.access$000(this.this$0).getInformation().getAccountId(), 1L, "errcode:-10000");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.task.QMSendMailDownloadAttachTask.3
 * JD-Core Version:    0.7.0.1
 */