package com.tencent.qqmail.model.task;

import com.tencent.qqmail.model.MailManagerDelegate.EventCallback;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.protocol.DataCollector;
import java.util.ArrayList;

class QMSendMailTask$12
  implements MailManagerDelegate.EventCallback
{
  QMSendMailTask$12(QMSendMailTask paramQMSendMailTask) {}
  
  public void run(Object paramObject)
  {
    paramObject = (ArrayList)paramObject;
    DataCollector.logPerformanceEnd("Performance_Send_MobileNumber" + QMSendMailTask.access$800(this.this$0).getComposeId(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.task.QMSendMailTask.12
 * JD-Core Version:    0.7.0.1
 */