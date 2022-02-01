package com.tencent.qqmail.uma;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import rx.Observable;
import rx.functions.Func1;

class QMUmaManager$61
  implements Func1<QMUmaManager.QMUmaSession, Observable<? extends QMNetworkRequest>>
{
  QMUmaManager$61(QMUmaManager paramQMUmaManager, QMUmaManager.QMUmaSession paramQMUmaSession, String paramString) {}
  
  public Observable<? extends QMNetworkRequest> call(QMUmaManager.QMUmaSession paramQMUmaSession)
  {
    return Observable.just(QMUmaManager.access$1600(this.this$0, this.val$session, this.val$lastModify));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.61
 * JD-Core Version:    0.7.0.1
 */