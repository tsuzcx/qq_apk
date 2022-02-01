package com.tencent.qqmail.ftn;

import android.os.SystemClock;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.Random;
import rx.Observable;
import rx.functions.Func1;

class FtnManagerImpl$AbstractSessionTask$3$1
  implements Func1<Throwable, Observable<Throwable>>
{
  FtnManagerImpl$AbstractSessionTask$3$1(FtnManagerImpl.AbstractSessionTask.3 param3) {}
  
  public Observable<Throwable> call(Throwable paramThrowable)
  {
    QMLog.log(5, "FtnManagerImpl", this.this$1.this$0.mFuncTag + " retry, count: " + FtnManagerImpl.AbstractSessionTask.access$1300(this.this$1.this$0) + ", tr: " + paramThrowable);
    String str = paramThrowable.getMessage();
    if ((FtnManagerImpl.AbstractSessionTask.access$1308(this.this$1.this$0) < 10) && (("session timeout".equals(str)) || ("mail session timeout".equals(str))))
    {
      SystemClock.sleep(new Random().nextInt(500));
      this.this$1.this$0.mError = new FtnManagerImpl.FtnTaskError(null);
      return Observable.just(paramThrowable);
    }
    return Observable.error(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManagerImpl.AbstractSessionTask.3.1
 * JD-Core Version:    0.7.0.1
 */