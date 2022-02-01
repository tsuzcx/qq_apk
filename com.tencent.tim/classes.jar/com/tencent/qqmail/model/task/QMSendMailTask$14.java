package com.tencent.qqmail.model.task;

import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;
import com.tencent.qqmail.model.mail.watcher.SendMailSuccWatcher;
import com.tencent.qqmail.model.mail.watcher.SendMailWatcher;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import moai.core.watcher.Watchers;

class QMSendMailTask$14
  implements MailManagerDelegate.DataCallback
{
  QMSendMailTask$14(QMSendMailTask paramQMSendMailTask) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    QMLog.log(4, "QMSendMailTask", "sendMail onsuccess");
    this.this$0.handleSucc(paramObject1);
    if ((QMSendMailTask.access$800(this.this$0) != null) && (QMSendMailTask.access$800(this.this$0).getFromAppName() != null))
    {
      paramObject1 = QMSendMailTask.access$800(this.this$0).getFromAppName();
      if (!paramObject1.equals("popularize_sendmail_from_content")) {
        break label118;
      }
      DataCollector.logEvent("Event_Ad_Webview_Content_SendMail");
    }
    for (;;)
    {
      if ((QMSendMailTask.access$800(this.this$0) != null) && (QMSendMailTask.access$800(this.this$0).getClockSendTime() > 0L)) {
        DataCollector.logEvent("Event_Send_Timer_Mail_Success");
      }
      ((SendMailWatcher)Watchers.of(SendMailWatcher.class)).onSuccess(QMSendMailTask.access$800(this.this$0).getComposeId());
      return;
      label118:
      if (paramObject1.equals("popularize_sendmail_from_actionsheet")) {
        DataCollector.logEvent("Event_Ad_Webview_ActionSheet_SendMail");
      } else {
        ((SendMailSuccWatcher)Watchers.of(SendMailSuccWatcher.class)).onSuccess(QMSendMailTask.access$800(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.task.QMSendMailTask.14
 * JD-Core Version:    0.7.0.1
 */