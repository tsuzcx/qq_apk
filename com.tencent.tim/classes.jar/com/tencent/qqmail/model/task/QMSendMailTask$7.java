package com.tencent.qqmail.model.task;

import com.tencent.qqmail.utilities.observer.QMNotification;

class QMSendMailTask$7
  implements Runnable
{
  QMSendMailTask$7(QMSendMailTask paramQMSendMailTask) {}
  
  public void run()
  {
    QMNotification.postNotification("cancel_after_success", QMSendMailTask.access$800(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.task.QMSendMailTask.7
 * JD-Core Version:    0.7.0.1
 */