package com.tencent.qqmail.model.task;

import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;

class QMSendMailDownloadAttachTask$2
  implements MailManagerDelegate.DataCallback
{
  QMSendMailDownloadAttachTask$2(QMSendMailDownloadAttachTask paramQMSendMailDownloadAttachTask) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    QMLog.log(4, "QMSendMailDownloadAttachTask", "download onSuccess");
    this.this$0.handleSucc(paramObject1);
    DataCollector.logDetailEvent("DetailEvent_App_Download", QMSendMailDownloadAttachTask.access$000(this.this$0).getInformation().getAccountId(), 0L, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.task.QMSendMailDownloadAttachTask.2
 * JD-Core Version:    0.7.0.1
 */