package com.tencent.qqmail.utilities.qmnetwork.ssl;

import java.util.Set;
import rx.Observable;
import rx.functions.Func1;

final class SafeSSLStrategy$5
  implements Func1<Long, Observable<String>>
{
  SafeSSLStrategy$5(Set paramSet) {}
  
  public Observable<String> call(Long paramLong)
  {
    return Observable.from(this.val$ids);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.ssl.SafeSSLStrategy.5
 * JD-Core Version:    0.7.0.1
 */