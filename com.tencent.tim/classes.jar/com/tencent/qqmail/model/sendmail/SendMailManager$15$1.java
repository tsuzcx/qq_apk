package com.tencent.qqmail.model.sendmail;

import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import java.util.List;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class SendMailManager$15$1
  implements Observable.OnSubscribe<List<FtnUploadInfo>>
{
  SendMailManager$15$1(SendMailManager.15 param15) {}
  
  public void call(Subscriber<? super List<FtnUploadInfo>> paramSubscriber)
  {
    paramSubscriber.onNext(this.this$1.val$ftnUploadInfos);
    paramSubscriber.onCompleted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.15.1
 * JD-Core Version:    0.7.0.1
 */