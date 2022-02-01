package com.tencent.qqmail.uma;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import rx.Observable;
import rx.functions.Func1;

class QMUmaManager$55
  implements Func1<QMUmaManager.QMUmaSession, Observable<? extends QMNetworkRequest>>
{
  QMUmaManager$55(QMUmaManager paramQMUmaManager) {}
  
  public Observable<? extends QMNetworkRequest> call(QMUmaManager.QMUmaSession paramQMUmaSession)
  {
    return Observable.create(new QMUmaManager.55.1(this, paramQMUmaSession));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.55
 * JD-Core Version:    0.7.0.1
 */