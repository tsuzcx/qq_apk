package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.MailManagerDelegate;
import rx.Subscriber;

class QMMailManager$46$1
  extends MailManagerDelegate
{
  QMMailManager$46$1(QMMailManager.46 param46, Subscriber paramSubscriber) {}
  
  public void handleComplete(Object paramObject)
  {
    this.val$subscriber.onCompleted();
  }
  
  public void handleError(Object paramObject)
  {
    this.val$subscriber.onError((Throwable)paramObject);
  }
  
  public void handleSuccess(Object paramObject1, Object paramObject2)
  {
    this.val$subscriber.onNext((Integer)paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.46.1
 * JD-Core Version:    0.7.0.1
 */