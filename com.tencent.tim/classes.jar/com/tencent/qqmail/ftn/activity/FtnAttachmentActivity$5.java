package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.Observable;

class FtnAttachmentActivity$5
  extends IObserver
{
  FtnAttachmentActivity$5(FtnAttachmentActivity paramFtnAttachmentActivity, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    QMLog.log(4, "FtnAttachmentActivity", "ftn delete file success:" + FtnAttachmentActivity.access$000(this.this$0).getName());
    Threads.runOnMainThread(new FtnAttachmentActivity.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnAttachmentActivity.5
 * JD-Core Version:    0.7.0.1
 */