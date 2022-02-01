package com.tencent.qqmail.uma;

import rx.Observable;
import rx.functions.Func1;

class QMUmaManager$54$1
  implements Func1<QMUmaManager.QMUmaResult, Observable<QMUmaManager.QMUmaSession>>
{
  QMUmaManager$54$1(QMUmaManager.54 param54) {}
  
  public Observable<QMUmaManager.QMUmaSession> call(QMUmaManager.QMUmaResult paramQMUmaResult)
  {
    return Observable.just(QMUmaManager.access$1200(this.this$1.this$0, this.this$1.val$session));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.54.1
 * JD-Core Version:    0.7.0.1
 */