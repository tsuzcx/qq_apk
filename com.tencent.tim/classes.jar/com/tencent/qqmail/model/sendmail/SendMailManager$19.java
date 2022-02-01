package com.tencent.qqmail.model.sendmail;

import android.util.Pair;
import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import rx.Observable;
import rx.functions.Func1;

class SendMailManager$19
  implements Func1<Pair<AttachInfo, FtnUploadInfo>, Observable<Pair<AttachInfo, FtnUploadInfo>>>
{
  SendMailManager$19(SendMailManager paramSendMailManager, int paramInt) {}
  
  public Observable<Pair<AttachInfo, FtnUploadInfo>> call(Pair<AttachInfo, FtnUploadInfo> paramPair)
  {
    return SendMailManager.access$1100(this.this$0, paramPair, this.val$taskId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.19
 * JD-Core Version:    0.7.0.1
 */