package com.tencent.qqmail.utilities.qmnetwork.ssl;

import java.security.cert.X509Certificate;
import rx.Observable;
import rx.functions.Func1;

class SafeSSLStrategy$3
  implements Func1<Object, Observable<Void>>
{
  SafeSSLStrategy$3(SafeSSLStrategy paramSafeSSLStrategy, X509Certificate paramX509Certificate, int paramInt) {}
  
  public Observable<Void> call(Object paramObject)
  {
    return Observable.create(new SafeSSLStrategy.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.ssl.SafeSSLStrategy.3
 * JD-Core Version:    0.7.0.1
 */