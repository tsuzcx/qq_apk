package com.tencent.qqmail.ftn;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import rx.Observable;
import rx.functions.Func1;

class FtnManagerImpl$AbstractFtnTask$4
  implements Func1<QMNetworkResponse, Observable<Void>>
{
  FtnManagerImpl$AbstractFtnTask$4(FtnManagerImpl.AbstractFtnTask paramAbstractFtnTask) {}
  
  public Observable<Void> call(QMNetworkResponse paramQMNetworkResponse)
  {
    QMLog.log(3, "FtnManagerImpl", this.this$0.mFuncTag + " handle response: " + paramQMNetworkResponse);
    if (paramQMNetworkResponse != null) {
      this.this$0.handleResponse(paramQMNetworkResponse, this.this$0.mError);
    }
    while (this.this$0.mError.isSessionTimeout)
    {
      return Observable.error(new Throwable("session timeout"));
      this.this$0.mError.isError = true;
      this.this$0.mError.errType = 1;
      this.this$0.mError.desp = "请求发生异常";
    }
    if (this.this$0.mError.isMailSessionTimeout) {
      return Observable.error(new Throwable("mail session timeout"));
    }
    if (this.this$0.mError.isError) {
      return Observable.error(new Throwable("other error"));
    }
    return Observable.just(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManagerImpl.AbstractFtnTask.4
 * JD-Core Version:    0.7.0.1
 */