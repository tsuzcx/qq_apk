package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.MailManagerDelegate;
import rx.Subscriber;

class QMMailManager$47$1
  extends MailManagerDelegate
{
  QMMailManager$47$1(QMMailManager.47 param47, Subscriber paramSubscriber) {}
  
  public void handleError(Object paramObject)
  {
    if ((paramObject instanceof Throwable))
    {
      this.val$subscriber.onError((Throwable)paramObject);
      return;
    }
    this.val$subscriber.onError(new Exception("un know error"));
  }
  
  public void handleSuccess(Object paramObject1, Object paramObject2)
  {
    this.val$subscriber.onNext(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.47.1
 * JD-Core Version:    0.7.0.1
 */