package com.tencent.qqmail.uma;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import rx.Observable;
import rx.functions.Func1;

class QMUmaManager$51
  implements Func1<QMNetworkRequest, Observable<? extends QMNetworkResponse>>
{
  QMUmaManager$51(QMUmaManager paramQMUmaManager) {}
  
  public Observable<? extends QMNetworkResponse> call(QMNetworkRequest paramQMNetworkRequest)
  {
    return QMUmaManager.access$600(this.this$0, paramQMNetworkRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.51
 * JD-Core Version:    0.7.0.1
 */