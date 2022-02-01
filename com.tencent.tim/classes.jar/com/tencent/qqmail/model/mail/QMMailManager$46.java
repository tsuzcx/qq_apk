package com.tencent.qqmail.model.mail;

import rx.Observable.OnSubscribe;
import rx.Subscriber;

class QMMailManager$46
  implements Observable.OnSubscribe<Integer>
{
  QMMailManager$46(QMMailManager paramQMMailManager, int paramInt1, String paramString, int paramInt2) {}
  
  public void call(Subscriber<? super Integer> paramSubscriber)
  {
    QMMailManager.access$500(this.this$0).genAppleIdVerifyCode(this.val$accountId, this.val$remoteId, this.val$type, new QMMailManager.46.1(this, paramSubscriber));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.46
 * JD-Core Version:    0.7.0.1
 */