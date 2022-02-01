package com.tencent.qqmail.model.sendmail;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import moai.oss.KvHelper;
import rx.Subscriber;

class SendMailManager$26
  extends Subscriber<QMNetworkRequest>
{
  SendMailManager$26(SendMailManager paramSendMailManager, Subscriber paramSubscriber) {}
  
  public void onCompleted() {}
  
  public void onError(Throwable paramThrowable)
  {
    KvHelper.eventNewComposeFailedWithAttach(new double[0]);
    this.val$subscriber.onError(paramThrowable);
  }
  
  public void onNext(QMNetworkRequest paramQMNetworkRequest)
  {
    this.val$subscriber.onNext(paramQMNetworkRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.26
 * JD-Core Version:    0.7.0.1
 */