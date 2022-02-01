package com.tencent.qqmail.model.sendmail;

import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.functions.Func1;

class SendMailManager$13
  implements Func1<List<FtnUploadInfo>, Observable<List<FtnUploadInfo>>>
{
  SendMailManager$13(SendMailManager paramSendMailManager, AtomicBoolean paramAtomicBoolean) {}
  
  public Observable<List<FtnUploadInfo>> call(List<FtnUploadInfo> paramList)
  {
    return SendMailManager.access$400(this.this$0, paramList, this.val$isAbort);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.13
 * JD-Core Version:    0.7.0.1
 */