package com.tencent.qqmail.ftn;

import com.tencent.qqmail.utilities.log.QMLog;
import rx.functions.Action1;

class FtnManagerImpl$AbstractSessionTask$2
  implements Action1<Throwable>
{
  FtnManagerImpl$AbstractSessionTask$2(FtnManagerImpl.AbstractSessionTask paramAbstractSessionTask) {}
  
  public void call(Throwable paramThrowable)
  {
    QMLog.log(6, "FtnManagerImpl", this.this$0.mFuncTag + " doOnError " + paramThrowable);
    if (this.this$0.mCallback != null) {
      this.this$0.mCallback.onError(this.this$0.mError.headerCode, this.this$0.mError.bodyCode, this.this$0.mError.errType, this.this$0.mError.desp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManagerImpl.AbstractSessionTask.2
 * JD-Core Version:    0.7.0.1
 */