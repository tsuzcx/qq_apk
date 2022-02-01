package com.tencent.qqmail.ftn;

import android.util.Log;
import rx.functions.Action1;

class FtnManagerImpl$AbstractFtnTask$2
  implements Action1<Throwable>
{
  FtnManagerImpl$AbstractFtnTask$2(FtnManagerImpl.AbstractFtnTask paramAbstractFtnTask) {}
  
  public void call(Throwable paramThrowable)
  {
    Log.w("FtnManagerImpl", this.this$0.mFuncTag + " subscribe onError", paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManagerImpl.AbstractFtnTask.2
 * JD-Core Version:    0.7.0.1
 */