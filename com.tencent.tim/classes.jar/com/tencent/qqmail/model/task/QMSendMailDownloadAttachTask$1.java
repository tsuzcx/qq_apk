package com.tencent.qqmail.model.task;

import com.tencent.qqmail.model.MailManagerDelegate.BeforeSendCallback;
import com.tencent.qqmail.utilities.log.QMLog;

class QMSendMailDownloadAttachTask$1
  implements MailManagerDelegate.BeforeSendCallback
{
  QMSendMailDownloadAttachTask$1(QMSendMailDownloadAttachTask paramQMSendMailDownloadAttachTask) {}
  
  public void run(Object arg1)
  {
    QMLog.log(4, "QMSendMailDownloadAttachTask", "download onBefore");
    synchronized (QMSendMailDownloadAttachTask.access$000(this.this$0))
    {
      this.this$0.setTaskState(QMTask.QMTaskState.QMTaskStateReady);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.task.QMSendMailDownloadAttachTask.1
 * JD-Core Version:    0.7.0.1
 */