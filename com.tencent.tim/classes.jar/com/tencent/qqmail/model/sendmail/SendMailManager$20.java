package com.tencent.qqmail.model.sendmail;

import android.util.Pair;
import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import rx.Observable;
import rx.functions.Func1;

class SendMailManager$20
  implements Func1<FtnUploadInfo, Observable<Pair<AttachInfo, FtnUploadInfo>>>
{
  SendMailManager$20(SendMailManager paramSendMailManager, int paramInt, AttachInfo paramAttachInfo, Pair paramPair) {}
  
  public Observable<Pair<AttachInfo, FtnUploadInfo>> call(FtnUploadInfo paramFtnUploadInfo)
  {
    return Observable.create(new SendMailManager.20.1(this, paramFtnUploadInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.20
 * JD-Core Version:    0.7.0.1
 */