package com.tencent.qqmail.model.task;

import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.utilities.observer.QMNotification;

class QMSendMailTask$8
  implements Runnable
{
  QMSendMailTask$8(QMSendMailTask paramQMSendMailTask) {}
  
  public void run()
  {
    QMNotification.postNotification("cancel_protocol_after_success", QMSendMailTask.access$800(this.this$0).getInformation().getSubject());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.task.QMSendMailTask.8
 * JD-Core Version:    0.7.0.1
 */