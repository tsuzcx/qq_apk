package com.tencent.qqmail.model.sendmail;

import rx.Observable;
import rx.functions.Func1;

class SendMailManager$5
  implements Func1<Void, Observable<Void>>
{
  SendMailManager$5(SendMailManager paramSendMailManager, SendMailRequest paramSendMailRequest) {}
  
  public Observable<Void> call(Void paramVoid)
  {
    return SendMailManager.access$400(this.this$0, paramVoid, this.val$sendMailRequest.getIsAbort());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.5
 * JD-Core Version:    0.7.0.1
 */