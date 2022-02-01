package com.tencent.qqmail.ftn;

import com.tencent.qqmail.utilities.log.QMLog;
import rx.functions.Action0;

class FtnManagerImpl$AutoLoginTask$3
  implements Action0
{
  FtnManagerImpl$AutoLoginTask$3(FtnManagerImpl.AutoLoginTask paramAutoLoginTask) {}
  
  public void call()
  {
    QMLog.log(4, "FtnManagerImpl", this.this$0.mFuncTag + " preparedSid doOnCompleted, isError: " + this.this$0.mError.isError + ", callback: " + this.this$0.mCallback);
    if (this.this$0.mCallback != null)
    {
      if (this.this$0.mError.isError) {
        this.this$0.mCallback.onError(this.this$0.mError.headerCode, this.this$0.mError.bodyCode, this.this$0.mError.errType, this.this$0.mError.desp);
      }
      this.this$0.mCallback.onComplete();
      this.this$0.mCallback = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManagerImpl.AutoLoginTask.3
 * JD-Core Version:    0.7.0.1
 */