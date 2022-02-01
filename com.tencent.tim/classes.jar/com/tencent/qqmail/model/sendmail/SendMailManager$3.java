package com.tencent.qqmail.model.sendmail;

import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable;
import rx.functions.Func1;

class SendMailManager$3
  implements Func1<Throwable, Observable<? extends Void>>
{
  SendMailManager$3(SendMailManager paramSendMailManager, SendMailRequest paramSendMailRequest, AtomicInteger paramAtomicInteger, MailManagerDelegate paramMailManagerDelegate) {}
  
  public Observable<? extends Void> call(Throwable paramThrowable)
  {
    QMLog.log(4, SendMailManager.access$100(), "sendMailByProtocol onerror, isAbort: " + this.val$sendMailRequest.getIsAbort(), paramThrowable);
    if ((this.val$step.get() < 3) && (this.val$sendMailRequest.getIsAbort().get())) {
      return Observable.empty();
    }
    SendMailManager.access$200(this.this$0, paramThrowable);
    if ((paramThrowable instanceof QMNetworkError)) {}
    for (paramThrowable = (QMNetworkError)paramThrowable;; paramThrowable = new QMNetworkError(5, -10000, QMApplicationContext.sharedInstance().getString(2131719526)))
    {
      if (this.val$newCallback != null) {
        this.val$newCallback.handleError(paramThrowable);
      }
      if (this.val$newCallback != null) {
        this.val$newCallback.handleComplete(null);
      }
      return Observable.empty();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.3
 * JD-Core Version:    0.7.0.1
 */