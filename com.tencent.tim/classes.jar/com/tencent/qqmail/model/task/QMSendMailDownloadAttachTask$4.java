package com.tencent.qqmail.model.task;

import com.tencent.qqmail.model.MailManagerDelegate.EventCallback;
import com.tencent.qqmail.utilities.log.QMLog;

class QMSendMailDownloadAttachTask$4
  implements MailManagerDelegate.EventCallback
{
  QMSendMailDownloadAttachTask$4(QMSendMailDownloadAttachTask paramQMSendMailDownloadAttachTask) {}
  
  public void run(Object paramObject)
  {
    QMLog.log(4, "QMSendMailDownloadAttachTask", "download onComplete");
    this.this$0.handleComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.task.QMSendMailDownloadAttachTask.4
 * JD-Core Version:    0.7.0.1
 */