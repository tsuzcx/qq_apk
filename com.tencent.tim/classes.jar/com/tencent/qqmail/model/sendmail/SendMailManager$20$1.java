package com.tencent.qqmail.model.sendmail;

import android.util.Pair;
import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.model.task.QMTaskSQLiteHelper;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class SendMailManager$20$1
  implements Observable.OnSubscribe<Pair<AttachInfo, FtnUploadInfo>>
{
  SendMailManager$20$1(SendMailManager.20 param20, FtnUploadInfo paramFtnUploadInfo) {}
  
  public void call(Subscriber<? super Pair<AttachInfo, FtnUploadInfo>> paramSubscriber)
  {
    SendMailManager.access$1200(this.this$1.this$0).insertTaskFtnRid(this.this$1.val$taskId, this.this$1.val$attachInfo.getHashId(), this.val$ftnUploadInfo.getRid());
    paramSubscriber.onNext(this.this$1.val$attachInfoFtnUploadInfoPair);
    paramSubscriber.onCompleted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.20.1
 * JD-Core Version:    0.7.0.1
 */