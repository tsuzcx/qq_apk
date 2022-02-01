package com.tencent.qqmail.model.sendmail;

import android.util.Pair;
import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.functions.Func1;

class SendMailManager$18
  implements Func1<Pair<AttachInfo, FtnUploadInfo>, Observable<Pair<AttachInfo, FtnUploadInfo>>>
{
  SendMailManager$18(SendMailManager paramSendMailManager, AtomicBoolean paramAtomicBoolean) {}
  
  public Observable<Pair<AttachInfo, FtnUploadInfo>> call(Pair<AttachInfo, FtnUploadInfo> paramPair)
  {
    return SendMailManager.access$400(this.this$0, paramPair, this.val$isAbort);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.18
 * JD-Core Version:    0.7.0.1
 */