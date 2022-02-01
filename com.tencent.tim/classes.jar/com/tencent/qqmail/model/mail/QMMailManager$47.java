package com.tencent.qqmail.model.mail;

import rx.Observable.OnSubscribe;
import rx.Subscriber;

class QMMailManager$47
  implements Observable.OnSubscribe<Void>
{
  QMMailManager$47(QMMailManager paramQMMailManager, int paramInt, String paramString1, String paramString2) {}
  
  public void call(Subscriber<? super Void> paramSubscriber)
  {
    QMMailManager.access$500(this.this$0).checkAppleIdVerifyCode(this.val$accountId, this.val$remoteMailId, this.val$verifyCode, new QMMailManager.47.1(this, paramSubscriber));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.47
 * JD-Core Version:    0.7.0.1
 */