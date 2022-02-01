package com.tencent.qqmail.model.task;

import com.tencent.qqmail.model.MailManagerDelegate.MailErrorCallback;
import com.tencent.qqmail.model.mail.watcher.SendMailWatcher;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import moai.core.watcher.Watchers;

class QMSendMailTask$15
  implements MailManagerDelegate.MailErrorCallback
{
  QMSendMailTask$15(QMSendMailTask paramQMSendMailTask) {}
  
  public void run(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof QMNetworkError))) {
      QMLog.log(6, "QMSendMailTask", "sendMail onerror : " + ((QMNetworkError)paramObject).toString());
    }
    for (;;)
    {
      ((SendMailWatcher)Watchers.of(SendMailWatcher.class)).onError(QMSendMailTask.access$800(this.this$0).getComposeId(), paramObject);
      if ((!QMSendMailTask.access$1500(this.this$0)) || (!this.this$0.isProtocol())) {
        break;
      }
      return;
      if (paramObject == null) {
        QMLog.log(6, "QMSendMailTask", "sendMail onerror : error is null");
      } else {
        QMLog.log(6, "QMSendMailTask", "sendMail onerror : error is not QMNetworkError");
      }
    }
    this.this$0.handleError(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.task.QMSendMailTask.15
 * JD-Core Version:    0.7.0.1
 */