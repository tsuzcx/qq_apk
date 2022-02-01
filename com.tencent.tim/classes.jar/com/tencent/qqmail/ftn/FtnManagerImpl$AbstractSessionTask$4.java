package com.tencent.qqmail.ftn;

import com.tencent.qqmail.utilities.log.QMLog;
import rx.Observable;
import rx.functions.Func1;

class FtnManagerImpl$AbstractSessionTask$4
  implements Func1<Void, Observable<Void>>
{
  FtnManagerImpl$AbstractSessionTask$4(FtnManagerImpl.AbstractSessionTask paramAbstractSessionTask) {}
  
  public Observable<Void> call(Void paramVoid)
  {
    QMLog.log(3, "FtnManagerImpl", this.this$0.mFuncTag + " ready to request");
    return this.this$0.request();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManagerImpl.AbstractSessionTask.4
 * JD-Core Version:    0.7.0.1
 */