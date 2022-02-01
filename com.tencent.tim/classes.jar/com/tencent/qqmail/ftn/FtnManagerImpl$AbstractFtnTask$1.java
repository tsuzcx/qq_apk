package com.tencent.qqmail.ftn;

import android.util.Log;
import rx.functions.Action1;

class FtnManagerImpl$AbstractFtnTask$1
  implements Action1<Void>
{
  FtnManagerImpl$AbstractFtnTask$1(FtnManagerImpl.AbstractFtnTask paramAbstractFtnTask) {}
  
  public void call(Void paramVoid)
  {
    Log.d("FtnManagerImpl", this.this$0.mFuncTag + " subscribe onNext");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManagerImpl.AbstractFtnTask.1
 * JD-Core Version:    0.7.0.1
 */