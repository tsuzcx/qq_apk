package com.tencent.qqmail.model.task;

import com.tencent.qqmail.utilities.observer.QMNotification;
import rx.functions.Action1;

class QMSendMailTask$6
  implements Action1<Boolean>
{
  QMSendMailTask$6(QMSendMailTask paramQMSendMailTask) {}
  
  public void call(Boolean paramBoolean)
  {
    if (!this.this$0.isCancelFail) {
      QMNotification.postNotification("refresh_sending_list", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.task.QMSendMailTask.6
 * JD-Core Version:    0.7.0.1
 */