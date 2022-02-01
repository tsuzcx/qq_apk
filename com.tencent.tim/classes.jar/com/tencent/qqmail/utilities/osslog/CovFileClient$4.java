package com.tencent.qqmail.utilities.osslog;

import com.tencent.qqmail.utilities.qmnetwork.QMHttpUtil;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import rx.Observable;
import rx.functions.Func1;

class CovFileClient$4
  implements Func1<QMNetworkRequest, Observable<QMNetworkResponse>>
{
  CovFileClient$4(CovFileClient paramCovFileClient) {}
  
  public Observable<QMNetworkResponse> call(QMNetworkRequest paramQMNetworkRequest)
  {
    return QMHttpUtil.sendInObservable(paramQMNetworkRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.osslog.CovFileClient.4
 * JD-Core Version:    0.7.0.1
 */