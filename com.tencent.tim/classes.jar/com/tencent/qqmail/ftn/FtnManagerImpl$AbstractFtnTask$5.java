package com.tencent.qqmail.ftn;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import rx.functions.Func1;

class FtnManagerImpl$AbstractFtnTask$5
  implements Func1<Throwable, QMNetworkResponse>
{
  FtnManagerImpl$AbstractFtnTask$5(FtnManagerImpl.AbstractFtnTask paramAbstractFtnTask) {}
  
  public QMNetworkResponse call(Throwable paramThrowable)
  {
    QMLog.log(5, "FtnManagerImpl", this.this$0.mFuncTag + " send error", paramThrowable);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManagerImpl.AbstractFtnTask.5
 * JD-Core Version:    0.7.0.1
 */