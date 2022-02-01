package com.tencent.qqmail.model.sendmail;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.functions.Func1;

class SendMailManager$10
  implements Func1<Void, Observable<Void>>
{
  SendMailManager$10(SendMailManager paramSendMailManager, AtomicBoolean paramAtomicBoolean) {}
  
  public Observable<Void> call(Void paramVoid)
  {
    return SendMailManager.access$400(this.this$0, paramVoid, this.val$isAbort);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.10
 * JD-Core Version:    0.7.0.1
 */