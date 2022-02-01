package com.tencent.qqmail.uma;

import rx.Observable;
import rx.functions.Func1;

class QMUmaManager$48
  implements Func1<Observable<? extends Throwable>, Observable<?>>
{
  QMUmaManager$48(QMUmaManager paramQMUmaManager, QMUmaManager.QMUmaSession paramQMUmaSession) {}
  
  public Observable<?> call(Observable<? extends Throwable> paramObservable)
  {
    return paramObservable.concatMap(new QMUmaManager.48.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.48
 * JD-Core Version:    0.7.0.1
 */