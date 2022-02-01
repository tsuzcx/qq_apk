package com.tencent.qqmail.model.task;

import com.tencent.qqmail.model.MailManagerDelegate.BeforeSendCallback;
import com.tencent.qqmail.model.mail.watcher.SendMailWatcher;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeState;
import com.tencent.qqmail.utilities.log.QMLog;
import moai.core.watcher.Watchers;

class QMSendMailTask$13
  implements MailManagerDelegate.BeforeSendCallback
{
  QMSendMailTask$13(QMSendMailTask paramQMSendMailTask) {}
  
  public void run(Object paramObject)
  {
    QMLog.log(4, "QMSendMailTask", "sendMail onbeforesend");
    synchronized (QMSendMailTask.access$800(this.this$0))
    {
      QMSendMailTask.access$1400(this.this$0, ComposeMailUI.QMComposeState.QMComposeStateReady);
      ((SendMailWatcher)Watchers.of(SendMailWatcher.class)).onBeforeSend(QMSendMailTask.access$800(this.this$0).getComposeId(), paramObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.task.QMSendMailTask.13
 * JD-Core Version:    0.7.0.1
 */