package com.tencent.qqmail.utilities.qmnetwork.ssl;

import rx.Observable.OnSubscribe;
import rx.Subscriber;

class SafeSSLStrategy$3$1
  implements Observable.OnSubscribe<Void>
{
  SafeSSLStrategy$3$1(SafeSSLStrategy.3 param3) {}
  
  public void call(Subscriber<? super Void> paramSubscriber)
  {
    String str = SafeSSLStrategy.access$400(this.this$1.this$0, this.this$1.val$certificate);
    SafeSSLStrategy.access$500(this.this$1.val$id, str, this.this$1.this$0.mHost, paramSubscriber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.ssl.SafeSSLStrategy.3.1
 * JD-Core Version:    0.7.0.1
 */