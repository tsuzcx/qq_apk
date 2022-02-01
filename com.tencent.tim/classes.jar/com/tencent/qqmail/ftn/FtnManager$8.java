package com.tencent.qqmail.ftn;

import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class FtnManager$8
  implements Observable.OnSubscribe<FtnUploadInfo>
{
  FtnManager$8(FtnManager paramFtnManager, FtnUploadInfo paramFtnUploadInfo) {}
  
  public void call(Subscriber<? super FtnUploadInfo> paramSubscriber)
  {
    this.this$0.signFile(this.val$uploadItemData, paramSubscriber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManager.8
 * JD-Core Version:    0.7.0.1
 */