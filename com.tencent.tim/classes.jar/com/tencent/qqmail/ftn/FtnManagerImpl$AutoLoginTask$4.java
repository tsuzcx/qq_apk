package com.tencent.qqmail.ftn;

import com.tencent.qqmail.utilities.log.QMLog;
import rx.functions.Action1;

class FtnManagerImpl$AutoLoginTask$4
  implements Action1<Throwable>
{
  FtnManagerImpl$AutoLoginTask$4(FtnManagerImpl.AutoLoginTask paramAutoLoginTask) {}
  
  public void call(Throwable paramThrowable)
  {
    QMLog.log(5, "FtnManagerImpl", this.this$0.mFuncTag + " preparedSid doOnError, callback: " + this.this$0.mCallback, paramThrowable);
    if (this.this$0.mCallback != null)
    {
      this.this$0.mCallback.onError(this.this$0.mError.headerCode, this.this$0.mError.bodyCode, this.this$0.mError.errType, this.this$0.mError.desp);
      this.this$0.mCallback = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManagerImpl.AutoLoginTask.4
 * JD-Core Version:    0.7.0.1
 */