package com.tencent.qqmail.ftn;

import com.tencent.qqmail.utilities.log.QMLog;
import rx.Observable;
import rx.functions.Func0;

class FtnManagerImpl$AutoLoginTask$5
  implements Func0<Observable<Void>>
{
  FtnManagerImpl$AutoLoginTask$5(FtnManagerImpl.AutoLoginTask paramAutoLoginTask) {}
  
  public Observable<Void> call()
  {
    boolean bool = FtnManagerImpl.access$1200();
    QMLog.log(4, "FtnManagerImpl", this.this$0.mFuncTag + " isValidSid: " + bool + ", isMailSessionTimeout: " + this.this$0.mError.isMailSessionTimeout);
    if ((bool) && (this.this$0.mCallback != null))
    {
      this.this$0.mCallback.onSuccess(null, null);
      this.this$0.mCallback = null;
    }
    Observable localObservable;
    if (this.this$0.mError.isMailSessionTimeout) {
      localObservable = this.this$0.mailAutoLogin();
    }
    for (;;)
    {
      this.this$0.mError = new FtnManagerImpl.FtnTaskError(null);
      return localObservable;
      if (bool) {
        localObservable = Observable.just((Void)null);
      } else {
        localObservable = this.this$0.requestSid();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManagerImpl.AutoLoginTask.5
 * JD-Core Version:    0.7.0.1
 */