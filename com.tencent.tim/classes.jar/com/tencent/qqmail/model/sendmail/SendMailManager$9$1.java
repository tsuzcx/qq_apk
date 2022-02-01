package com.tencent.qqmail.model.sendmail;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class SendMailManager$9$1
  implements Observable.OnSubscribe<QMNetworkRequest>
{
  SendMailManager$9$1(SendMailManager.9 param9) {}
  
  public void call(Subscriber<? super QMNetworkRequest> paramSubscriber)
  {
    this.this$1.val$step.set(3);
    SendMailManager.access$700(this.this$1.this$0, this.this$1.val$account, this.this$1.val$mail, this.this$1.val$verify, this.this$1.val$sendMailTaskId, this.this$1.val$binaryFilesData, this.this$1.val$sendMailRequest, paramSubscriber, this.this$1.val$sendMailFtnCallback, this.this$1.val$callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.9.1
 * JD-Core Version:    0.7.0.1
 */