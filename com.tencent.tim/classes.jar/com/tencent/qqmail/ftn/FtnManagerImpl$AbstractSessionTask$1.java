package com.tencent.qqmail.ftn;

import rx.functions.Action0;

class FtnManagerImpl$AbstractSessionTask$1
  implements Action0
{
  FtnManagerImpl$AbstractSessionTask$1(FtnManagerImpl.AbstractSessionTask paramAbstractSessionTask) {}
  
  public void call()
  {
    if (this.this$0.mCallback != null)
    {
      if (this.this$0.mError.isError) {
        this.this$0.mCallback.onError(this.this$0.mError.headerCode, this.this$0.mError.bodyCode, this.this$0.mError.errType, this.this$0.mError.desp);
      }
      this.this$0.mCallback.onComplete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManagerImpl.AbstractSessionTask.1
 * JD-Core Version:    0.7.0.1
 */