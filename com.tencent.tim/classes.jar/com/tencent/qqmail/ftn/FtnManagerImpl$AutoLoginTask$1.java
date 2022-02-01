package com.tencent.qqmail.ftn;

import rx.Observable;
import rx.functions.Func1;

class FtnManagerImpl$AutoLoginTask$1
  implements Func1<Void, Observable<Void>>
{
  FtnManagerImpl$AutoLoginTask$1(FtnManagerImpl.AutoLoginTask paramAutoLoginTask) {}
  
  public Observable<Void> call(Void paramVoid)
  {
    return this.this$0.requestSid();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManagerImpl.AutoLoginTask.1
 * JD-Core Version:    0.7.0.1
 */