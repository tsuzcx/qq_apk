package com.tencent.qqmail.model.sendmail;

import android.util.Pair;
import com.tencent.qqmail.ftn.callback.SendMailFtnCallback;
import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import rx.Observable;
import rx.functions.Func1;

class SendMailManager$17
  implements Func1<Pair<AttachInfo, FtnUploadInfo>, Observable<FtnUploadInfo>>
{
  SendMailManager$17(SendMailManager paramSendMailManager, int paramInt, SendMailManager.BytesWrittenRecord paramBytesWrittenRecord, SendMailFtnCallback paramSendMailFtnCallback, MailManagerDelegate paramMailManagerDelegate) {}
  
  public Observable<FtnUploadInfo> call(Pair<AttachInfo, FtnUploadInfo> paramPair)
  {
    return SendMailManager.access$1000(this.this$0, this.val$taskId, paramPair, this.val$bytesWrittenRecord, this.val$sendMailFtnCallback, this.val$callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.17
 * JD-Core Version:    0.7.0.1
 */