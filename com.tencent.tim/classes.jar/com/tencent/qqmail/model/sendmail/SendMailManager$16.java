package com.tencent.qqmail.model.sendmail;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCancelError;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class SendMailManager$16
  implements Observable.OnSubscribe<T>
{
  SendMailManager$16(SendMailManager paramSendMailManager, AtomicBoolean paramAtomicBoolean, Object paramObject) {}
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    if ((this.val$isAbort != null) && (this.val$isAbort.get()))
    {
      QMLog.log(3, SendMailManager.access$100(), "abort", new RuntimeException());
      paramSubscriber.onError(new QMCancelError(true));
      return;
    }
    paramSubscriber.onNext(this.val$params);
    paramSubscriber.onCompleted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.16
 * JD-Core Version:    0.7.0.1
 */