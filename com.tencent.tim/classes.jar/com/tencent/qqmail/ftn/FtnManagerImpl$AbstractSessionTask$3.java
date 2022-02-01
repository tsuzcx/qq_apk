package com.tencent.qqmail.ftn;

import rx.Observable;
import rx.functions.Func1;

class FtnManagerImpl$AbstractSessionTask$3
  implements Func1<Observable<? extends Throwable>, Observable<?>>
{
  FtnManagerImpl$AbstractSessionTask$3(FtnManagerImpl.AbstractSessionTask paramAbstractSessionTask) {}
  
  public Observable<?> call(Observable<? extends Throwable> paramObservable)
  {
    return paramObservable.flatMap(new FtnManagerImpl.AbstractSessionTask.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManagerImpl.AbstractSessionTask.3
 * JD-Core Version:    0.7.0.1
 */