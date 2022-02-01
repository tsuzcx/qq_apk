package com.tencent.qqmail.model.task;

import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.utilities.observer.QMNotification;
import rx.functions.Action1;

class QMSendMailTask$5
  implements Action1<Boolean>
{
  QMSendMailTask$5(QMSendMailTask paramQMSendMailTask) {}
  
  public void call(Boolean paramBoolean)
  {
    QMSendMailTask.access$800(this.this$0).getInformation().setRemoteId(QMSendMailTask.access$800(this.this$0).originMailId());
    if (!this.this$0.isCancelFail) {
      QMNotification.postNotification("refresh_sending_list", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.task.QMSendMailTask.5
 * JD-Core Version:    0.7.0.1
 */