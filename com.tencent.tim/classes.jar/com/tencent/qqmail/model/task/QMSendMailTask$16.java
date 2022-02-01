package com.tencent.qqmail.model.task;

import com.tencent.qqmail.model.MailManagerDelegate.EventCallback;
import com.tencent.qqmail.model.mail.watcher.SendMailWatcher;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import moai.core.watcher.Watchers;

class QMSendMailTask$16
  implements MailManagerDelegate.EventCallback
{
  QMSendMailTask$16(QMSendMailTask paramQMSendMailTask) {}
  
  public void run(Object paramObject)
  {
    QMLog.log(4, "QMSendMailTask", "sendMail oncomplete");
    DataCollector.logPerformanceEnd("Performance_Send" + QMSendMailTask.access$800(this.this$0).getComposeId(), "");
    ((SendMailWatcher)Watchers.of(SendMailWatcher.class)).onComplete(QMSendMailTask.access$800(this.this$0).getComposeId());
    this.this$0.handleComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.task.QMSendMailTask.16
 * JD-Core Version:    0.7.0.1
 */