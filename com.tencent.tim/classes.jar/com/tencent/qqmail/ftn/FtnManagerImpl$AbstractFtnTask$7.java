package com.tencent.qqmail.ftn;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import rx.Observable;
import rx.functions.Func0;

class FtnManagerImpl$AbstractFtnTask$7
  implements Func0<Observable<QMNetworkRequest>>
{
  FtnManagerImpl$AbstractFtnTask$7(FtnManagerImpl.AbstractFtnTask paramAbstractFtnTask) {}
  
  public Observable<QMNetworkRequest> call()
  {
    return Observable.just(this.this$0.buildRequest());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManagerImpl.AbstractFtnTask.7
 * JD-Core Version:    0.7.0.1
 */