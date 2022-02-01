package com.tencent.qqmail.ftn;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMHttpUtil;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import rx.Observable;
import rx.functions.Func1;

class FtnManagerImpl$AbstractFtnTask$6
  implements Func1<QMNetworkRequest, Observable<QMNetworkResponse>>
{
  FtnManagerImpl$AbstractFtnTask$6(FtnManagerImpl.AbstractFtnTask paramAbstractFtnTask) {}
  
  public Observable<QMNetworkResponse> call(QMNetworkRequest paramQMNetworkRequest)
  {
    QMLog.log(3, "FtnManagerImpl", this.this$0.mFuncTag + " send request: " + paramQMNetworkRequest);
    return QMHttpUtil.sendInObservable(paramQMNetworkRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManagerImpl.AbstractFtnTask.6
 * JD-Core Version:    0.7.0.1
 */